package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Interfaces.InterfaceCompra;
import model.Clientes;
import model.Compra;
import model.DetalleCompra;
import model.DetalleVentas;
import model.Ventas;
import utils.MySQLconexion;

public class GestionCompra implements InterfaceCompra {

	public int ObtenerNumero() {
		// TODO Auto-generated method stub
		int numero=1; // tipo de resultado
		
		ResultSet rs=null;
		Connection con= null;
		PreparedStatement pst = null;
		try {
		   con = MySQLconexion.getConexion(); 
		   String sql = "select max(Nro_comp) from compra"; 		  

		   pst = con.prepareStatement(sql);
		   // parámetros según la sentencia
		   
		   
		   rs=pst.executeQuery(); // tipo de ejecución
		   
		   while(rs.next()){
			  numero=rs.getInt(1); 
			   //V004
		
			  numero=numero+1;
		   }

		   // Acciones adicionales en caso de consultas
		} catch (Exception e) {
		   System.out.println("error en ultimo numero : "+e.getMessage());
		} finally {
		  try {
		      if (pst != null) pst.close();
		      if (con != null) con.close();
		   } catch (SQLException e) {
		      System.out.println("Error al cerrar ");
		   }
		}
		
		return numero; 
	}

public int realizaCompra(Compra c, ArrayList<DetalleCompra> detalle) {
		
		Connection con = null;
		PreparedStatement pst1=null;
		PreparedStatement pst2=null;
		int resultado=0;
			try {
				
				con=MySQLconexion.getConexion();
				con.setAutoCommit(false);
							//insert ventas values(null,'Factura','2018/11/10',1,1);
				String sql1="insert compra values(null,?,?,?)";
				pst1=con.prepareStatement(sql1);
				
				pst1.setString(1,c.getDocumentocom());
				pst1.setString(2, c.getFechaCom());
				pst1.setInt(3, c.getIdProveCom());
				
				resultado=pst1.executeUpdate();
								//insert into detalle_venta values (1,1,3,500.0)
					String sql2="insert into detalle_compra values(?,?,?,?);";
					for (DetalleCompra dt : detalle) {
						pst1=con.prepareStatement(sql2);
						pst1.setInt(1,dt.getNroCompra());
						pst1.setInt(2, dt.getIdprodu());
						pst1.setInt(3, dt.getCantidad());
						pst1.setDouble(4,dt.getPrecio());
						resultado=pst1.executeUpdate();
					}
									//update producto set stock_prod=stock_prod-1 where id_prod = 1;
						String sql3="update producto set stock_prod=stock_prod+? where id_prod = ?";
						for (DetalleCompra dt: detalle) {
							pst1 = con.prepareStatement(sql3);
							pst1.setInt(1, dt.getCantidad());
							pst1.setInt(2, dt.getIdprodu());
							resultado=pst1.executeUpdate();
						}
					
				con.commit();
			} catch (Exception ex) {
				try {
					con.rollback();
					System.out.println("Ocurrio un evento inesperado en el metodo insertar boleta : "+ex.getMessage());
					resultado=0;
				} catch (SQLException e) {
					System.out.println("Error en el Rollback "+e.getMessage());
				}
			}
			finally {
				try {
					if(pst1!=null)pst1.close();
					if(pst2!=null)pst2.close();
					if(con!=null)con.close();
				} catch (SQLException e) {
					System.out.println("Error al cerrar :"+e.getMessage());
				}
			}
		return resultado;
	}


public ArrayList<Compra> listado() {
	ArrayList<Compra> lista=new ArrayList<Compra>();
	ResultSet rs=null;
	Connection con=null;
	PreparedStatement pst=null;
	try {
		con=MySQLconexion.getConexion();
		String sql="select sum(CantXUnidad * precioUnidad) 'cantidad'from detalle_compra";
		pst=(PreparedStatement) con.prepareStatement(sql);
		rs=pst.executeQuery();
		
		while (rs.next()) {
			Compra c=new Compra();
			c.setCant_Comp(rs.getString(1));
		
			lista.add(c);
		}
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "error en la sentencia"+e.getMessage());
	}finally {
		try {
			if(pst!=null)pst.close();
			if(con!=null)con.close();
		} catch (Exception e2) {
			
			JOptionPane.showMessageDialog(null, "error al cerrar");
		}
	}
	return lista;
}
	
}
