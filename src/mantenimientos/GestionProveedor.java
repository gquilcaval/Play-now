package mantenimientos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import Interfaces.InterfaceProveedor;
import model.Clientes;
import model.Proveedores;
import utils.MySQLconexion;

public class GestionProveedor implements InterfaceProveedor {

	@Override
	public ArrayList<Proveedores> listado() {
		ArrayList<Proveedores> lista=new ArrayList<Proveedores>();
		ResultSet rs=null;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql="select*from proveedor";
			pst=(PreparedStatement) con.prepareStatement(sql);
			rs=pst.executeQuery();
			
			while (rs.next()) {
				Proveedores p=new Proveedores();
				p.setId_prov(rs.getInt(1));
				p.setNom_prov(rs.getString(2));
				p.setRuc_prov(rs.getString(3));
				p.setDirec_prov(rs.getString(4));
				p.setTelf_prov(rs.getString(5));
				p.setCell_prov(rs.getString(6));
				p.setEmail_prov(rs.getString(7));
				p.setEstado_prov(rs.getString(8));
				p.setNro_cuenta_prov(rs.getString(9));
				lista.add(p);
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
	public ArrayList<Proveedores> listado(String nombre) {
		ArrayList<Proveedores> lista=new ArrayList<Proveedores>();
		ResultSet rs=null;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql="{call sp_BuscarProveedor(?)}";
			pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setString(1,nombre);
			rs=pst.executeQuery();
			
			while (rs.next()) {
				Proveedores p=new Proveedores();
				p.setId_prov(rs.getInt(1));
				p.setNom_prov(rs.getString(2));
				p.setRuc_prov(rs.getString(3));
				p.setDirec_prov(rs.getString(4));
				p.setTelf_prov(rs.getString(5));
				p.setCell_prov(rs.getString(6));
				p.setEmail_prov(rs.getString(7));
				p.setEstado_prov(rs.getString(8));
				p.setNro_cuenta_prov(rs.getString(9));
				lista.add(p);
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
	public int registrar(Proveedores reg) {
		int rs=0;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql=" insert into proveedor values(null,?,?,?,?,?,?,?,?)";
			pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setString(1,reg.getNom_prov());
			pst.setString(2,reg.getRuc_prov());
			pst.setString(3,reg.getDirec_prov());
			pst.setString(4,reg.getTelf_prov());
			pst.setString(5,reg.getCell_prov());
			pst.setString(6,reg.getEmail_prov());
			pst.setString(7,reg.getEstado_prov());
			pst.setString(8,reg.getNro_cuenta_prov());
			
			
		
			
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
	public int actualizar(Proveedores c) {

		int rs=0;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql=" update proveedor set nom_prov=?,ruc_prov=?,direc_prov=?,telf_prov=?,cell_prov=?,email_prov=?,estado_prov=?,Nro_cuenta_prov=? where id_prov=?";
			
			pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setString(1,c.getNom_prov());
			pst.setString(2,c.getRuc_prov());
			pst.setString(3,c.getDirec_prov());
			pst.setString(4,c.getTelf_prov());
			pst.setString(5,c.getCell_prov());
			pst.setString(6,c.getEmail_prov());
			pst.setString(7,c.getEstado_prov());
			pst.setString(8,c.getNro_cuenta_prov());
			pst.setInt(9,c.getId_prov());
			
			
		
			
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
	public int eliminar(int id) {
		int rs=0;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql=" delete from proveedor where id_prov=?";
			
			pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setInt(1,id);
		
			rs=pst.executeUpdate();
			
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error Proveedor en uso");
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
