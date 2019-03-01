package mantenimientos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import Interfaces.InterfaceCliente;
import model.Clientes;

import utils.MySQLconexion;

public class GestionClientes implements InterfaceCliente {

	@Override
	public ArrayList<Clientes> listado() {
		ArrayList<Clientes> lista=new ArrayList<Clientes>();
		
		ResultSet rs=null;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql="select *from cliente";
			pst=(PreparedStatement) con.prepareStatement(sql);
			rs=pst.executeQuery();
			
			while (rs.next()) {
				Clientes c=new Clientes();
				c.setId_cli(rs.getInt(1));
				c.setNomb_cli(rs.getString(2));
				c.setApe_cli(rs.getString(3));
				c.setDni_cli(rs.getString(4));
				c.setTelf_cli(rs.getString(5));
				c.setDirec_cli(rs.getString(6));
				
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
	public ArrayList<Clientes> listado(String nombre) {
		ArrayList<Clientes> lista=new ArrayList<Clientes>();
		ResultSet rs=null;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql="{call sp_BuscarCli(?)}";
			pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setString(1,nombre);
			rs=pst.executeQuery();
			
			while (rs.next()) {
				Clientes c=new Clientes();
				c.setId_cli(rs.getInt(1));
				c.setNomb_cli(rs.getString(2));
				c.setApe_cli(rs.getString(3));
				c.setDni_cli(rs.getString(4));
				c.setTelf_cli(rs.getString(5));
				c.setDirec_cli(rs.getString(6));
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
	public int registrar(Clientes reg) {
	
		
		int rs=0;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql=" insert into cliente values(null,?,?,?,?,?)";
			pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setString(1,reg.getNomb_cli());
			pst.setString(2,reg.getApe_cli());
			pst.setString(3,reg.getDni_cli());
			pst.setString(4,reg.getTelf_cli());
			pst.setString(5,reg.getDirec_cli());
			
		
			
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
	public int actualizar(Clientes c) {
		
		int rs=0;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql=" update cliente set nomb_cli=?,ape_cli=?,telf_cli=?,direc_cli=?,dni_cli=? where id_cli=?";
			
			pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setString(1,c.getNomb_cli());
			pst.setString(2,c.getApe_cli());
			pst.setString(3,c.getTelf_cli());
			pst.setString(4,c.getDirec_cli());
			pst.setString(5,c.getDni_cli());
			pst.setInt(6, c.getId_cli());
			
		
			
			rs=pst.executeUpdate();
			
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error cliente en uso");
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
	public int eliminar(String dni) {
		int rs=0;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql=" delete from cliente where id_cli=?";
			
			pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setString(1,dni);
		
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
	public ArrayList<Clientes> ListCantidadClientes() {
		
		ArrayList<Clientes> lista=new ArrayList<Clientes>();
		
		ResultSet rs=null;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql="select *,count(*) 'cantidad'from cliente";
			pst=(PreparedStatement) con.prepareStatement(sql);
			rs=pst.executeQuery();
			
			while (rs.next()) {
				Clientes c=new Clientes();
				c.setId_cli(rs.getInt(1));
				c.setNomb_cli(rs.getString(2));
				c.setApe_cli(rs.getString(3));
				c.setDni_cli(rs.getString(4));
				c.setTelf_cli(rs.getString(5));
				c.setDirec_cli(rs.getString(6));
				c.setNro_clientes(rs.getString(7));
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
