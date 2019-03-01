package mantenimientos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import Interfaces.InterfaceProducto;

import model.Producto;
import utils.MySQLconexion;

public class GestionProductos implements InterfaceProducto{

	public ArrayList<Producto> listado() {
		ArrayList<Producto> lista=new ArrayList<Producto>();
		ResultSet rs=null;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql="select*from producto";
			pst=(PreparedStatement) con.prepareStatement(sql);
			rs=pst.executeQuery();
			
			while (rs.next()) {
				Producto reg=new Producto();
				reg.setCodigo(rs.getInt(1));
				reg.setDescripcion(rs.getString(2));
				reg.setStock(rs.getInt(3));
				reg.setPrecioUnidad(rs.getInt(4));
				reg.setIdcategoria(rs.getString(5));
				reg.setIdproveedor(rs.getInt(6));
				
				
				
				lista.add(reg);
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

	@Override
	public ArrayList<Producto> listado(String nombre) {
		// TODO Auto-generated method stub
		ArrayList<Producto> lista=new ArrayList<Producto>();
		ResultSet rs=null;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql="{call sp_BuscarPro(?)}";
			pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setString(1,nombre);
			rs=pst.executeQuery();
			
			while (rs.next()) {
				Producto reg=new Producto();
				reg.setCodigo(rs.getInt(1));
				reg.setDescripcion(rs.getString(2));
				reg.setStock(rs.getInt(3));
				reg.setPrecioUnidad(rs.getInt(4));
				reg.setIdcategoria(rs.getString(5));
				reg.setIdproveedor(rs.getInt(6));
				lista.add(reg);
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

	@Override
	public int Agregar(Producto reg) {
	
		
		int rs=0;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql="insert into Producto values (null, ?, ?, ?, ?, ?)";
			pst=(PreparedStatement) con.prepareStatement(sql);
			
			pst.setString(1, reg.getDescripcion());
			pst.setInt(2, reg.getStock());
			pst.setDouble(3,reg.getPrecioUnidad());
			pst.setString(4, reg.getIdcategoria());
			pst.setInt(5, reg.getIdproveedor());
			
			rs=pst.executeUpdate();
			
			
			
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
		return rs;
		
	}

public int actualizar(Producto p) {
		
		int rs=0;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql=" update producto set nom_prod=?,stock_prod=?,pre_prod=?,id_cat=?,id_prov=?  where id_prod=?";
			
			pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setString(1,p.getDescripcion());
			pst.setInt(2,p.getStock());
			pst.setDouble(3,p.getPrecioUnidad());
			pst.setString(4,p.getIdcategoria());
			pst.setInt(5,p.getIdproveedor());
			pst.setInt(6, p.getCodigo());
			
		
			
			rs=pst.executeUpdate();
			
			
			
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
		return rs;
	}

	@Override
	public int eliminar(int codigo) {
		int rs=0;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql=" delete from producto where id_prod =?";
			
			pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setInt(1,codigo);
		
			rs=pst.executeUpdate();
			
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error Producto en uso");
		}finally {
			try {
				if(pst!=null)pst.close();
				if(con!=null)con.close();
			} catch (Exception e2) {
				
				JOptionPane.showMessageDialog(null, "error al cerrar");
			}
		}
		return rs;
	}

	
}
