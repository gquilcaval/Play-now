package mantenimientos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import Interfaces.InterfaceCategoria;
import model.Categoria;
import model.Clientes;
import utils.MySQLconexion;

public class GestionCategorias implements InterfaceCategoria {

	@Override
	public ArrayList<Categoria> BusquedaCat(String descrip) {
		// TODO Auto-generated method stub
		ArrayList<Categoria> lista=new ArrayList<Categoria>();
		ResultSet rs=null;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql="{call sp_BuscarCat(?)}";
			pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setString(1,descrip);
			rs=pst.executeQuery();
			
			while (rs.next()) {
				Categoria c=new Categoria();
				c.setCodigo(rs.getString(1));
				c.setDescripcion(rs.getString(2));
				
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

	@Override
	public ArrayList<Categoria> listar() {
		ArrayList<Categoria> lista=new ArrayList<Categoria>();
		ResultSet rs=null;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql="select*from categoria";
			pst=(PreparedStatement) con.prepareStatement(sql);
			rs=pst.executeQuery();
			
			while (rs.next()) {
				Categoria c=new Categoria();
				c.setCodigo(rs.getString(1));
				c.setDescripcion(rs.getString(2));
				
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

	@Override
	public int agregar(Categoria c) {
		// TODO Auto-generated method stub
		int rs=0;
		
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql="insert categoria values(null,?);";
			pst=(PreparedStatement) con.prepareStatement(sql);
			
		
			pst.setString(1,c.getDescripcion());
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
	public int actualizar(Categoria c) {
		
		int rs=0;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql=" update categoria set nomb_cat=? where id_cat=?";
			
			pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setString(1,c.getDescripcion());
			pst.setString(2, c.getCodigo());
			
		
			
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
	public int eliminar(String codigo) {
		int rs=0;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql=" delete from categoria where  id_cat=?";
			
			pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setString(1,codigo);
		
			rs=pst.executeUpdate();
			
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error Categoria en uso");
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
