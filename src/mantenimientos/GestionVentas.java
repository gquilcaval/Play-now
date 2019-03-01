package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Interfaces.InterfaceVentas;
import model.Compra;
import model.DetalleVentas;
import model.Reporte;
import model.Tipo_documento;
import model.Ventas;
import utils.MySQLconexion;

public class GestionVentas implements InterfaceVentas{

	public int ObtenerNumero() {
		// TODO Auto-generated method stub
		int numero=1; // tipo de resultado
		
		ResultSet rs=null;
		Connection con= null;
		PreparedStatement pst = null;
		try {
		   con = MySQLconexion.getConexion(); 
		   String sql = "select max(Nro_ven) from ventas"; 		  

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

public int realizaVenta(Ventas venta, ArrayList<DetalleVentas> detalle) {
		
		Connection con = null;
		PreparedStatement pst1=null;
		PreparedStatement pst2=null;
		int resultado=0;
			try {
				
				con=MySQLconexion.getConexion();
				con.setAutoCommit(false);
							//insert ventas values(null,'Factura','2018/11/10',1,1);
				String sql1="insert ventas values(?,?,?,?,?)";
				pst1=con.prepareStatement(sql1);
				pst1.setInt(1, venta.getNro_ven());
				pst1.setString(2,venta.getDoc_ven());
				pst1.setString(3, venta.getFech_ven());
				pst1.setInt(4, venta.getId_cli());
				pst1.setInt(5, venta.getId_emp());
				resultado=pst1.executeUpdate();
								//insert into detalle_venta values (1,1,3,500.0)
					String sql2="insert into detalle_venta values (?,?,?,?)";
					for (DetalleVentas dt : detalle) {
						pst1=con.prepareStatement(sql2);
						pst1.setInt(1,venta.getNro_ven());
						pst1.setInt(2, dt.getId_prod());
						pst1.setInt(3, dt.getCantxUnidad());
						pst1.setDouble(4,dt.getPrecioUnidad());
						resultado=pst1.executeUpdate();
					}
									//update producto set stock_prod=stock_prod-1 where id_prod = 1;
						String sql3="update producto set stock_prod=stock_prod-? where id_prod = ?";
						for (DetalleVentas dt: detalle) {
							pst1 = con.prepareStatement(sql3);
							pst1.setInt(1, dt.getCantxUnidad());
							pst1.setInt(2, dt.getId_prod());
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
/*No funiciona*/
/*
@Override
public ArrayList<Tipo_documento> tipoDocumento() {
	ArrayList<Tipo_documento> lista = new ArrayList<>();
	ResultSet rs = null;
	Connection con = null;
	PreparedStatement pst=null;
	
	try {
		con = MySQLconexion.getConexion();
		String sql = "select*from tipo_documento";
		pst = con.prepareStatement(sql);
		rs = pst.executeQuery();
		
		while (rs.next()) {
			Tipo_documento td = new Tipo_documento();
			td.setIdCategoria(rs.getInt(1));
			td.setDoc_ven(rs.getString(2));
			lista.add(td);
		}
	} catch (Exception e) {
		System.out.println("Error en la sentencia"+e.getMessage());
	}finally {
		try {
			if(pst!=null) pst.close();
			if(con!=null)con.close();
		} catch (SQLException  e) {
			System.out.println("Error al cerrar");
		}
	}
	return lista;
}
	*/

@Override
public ArrayList<Tipo_documento> tipoDocumento() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public ArrayList<Reporte> reportexfecha(String fecha) {
	//REPORTE POR FECHA
		
			ArrayList<Reporte> lista =new ArrayList<Reporte>();
			ResultSet rs =null;
			Connection con=null;
			PreparedStatement pst=null;
			
			try {
				con=MySQLconexion.getConexion();
				//  call sp_ReportexFecha ('2018-11-10');
				String sql="{ call sp_ReportexFecha (?)}";
				pst=con.prepareStatement(sql);
				pst.setString(1, fecha);
				rs=pst.executeQuery();
				
				while(rs.next()){
					Reporte r=new Reporte();
					r.setNro_ven(rs.getInt(1));
					r.setDoc_ven(rs.getString(2));
					r.setFech_ven(rs.getString(3));
					r.setNom_cliente(rs.getString(4));
					r.setNom_emple(rs.getString(5));
					lista.add(r);
				}
			} catch (Exception e) {
				System.out.println("Error en la sentencia "+e.getMessage());
			}finally {
				try {
					if(con!=null)con.close();
					if(pst!=null)pst.close();
				} catch (SQLException e) {
					System.out.println("Error al cerrar " + e.getMessage());
				}
			}
			return lista;
		}


@Override
public ArrayList<Reporte> reportexnombre(String nombre) {
	//REPORTE POR NOMBRE
		
			ArrayList<Reporte> lista =new ArrayList<Reporte>();
			ResultSet rs =null;
			Connection con=null;
			PreparedStatement pst=null;
			
			try {
				con=MySQLconexion.getConexion();
				// call sp_ReportexEmpleado ('giancarlos');
				String sql="{call sp_ReportexEmpleado (?)}";
				pst=con.prepareStatement(sql);
				pst.setString(1, nombre);
				rs=pst.executeQuery();
				
				while(rs.next()){
					Reporte r=new Reporte();
					r.setNro_ven(rs.getInt(1));
					r.setDoc_ven(rs.getString(2));
					r.setFech_ven(rs.getString(3));
					r.setNom_cliente(rs.getString(4));
					r.setNom_emple(rs.getString(5));
					lista.add(r);
				}
			} catch (Exception e) {
				System.out.println("Error en la sentencia "+e.getMessage());
			}finally {
				try {
					if(con!=null)con.close();
					if(pst!=null)pst.close();
				} catch (SQLException e) {
					System.out.println("Error al cerrar " + e.getMessage());
				}
			}
			return lista;
		}

@Override
public ArrayList<Ventas> listado() {
	ArrayList<Ventas> lista=new ArrayList<Ventas>();
	ResultSet rs=null;
	Connection con=null;
	PreparedStatement pst=null;
	try {
		con=MySQLconexion.getConexion();
		String sql="select sum(CantXUnidad * precioUnidad) 'cantidad'from detalle_venta";
		pst=(PreparedStatement) con.prepareStatement(sql);
		rs=pst.executeQuery();
		
		while (rs.next()) {
			Ventas c=new Ventas();
			c.setCant_vent(rs.getString(1));
		
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
	

