package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Interfaces.InterfaceEmpleados;
import model.Clientes;
import model.Empleados;
import model.TipoEmpleado;
import utils.MySQLconexion;

public class GestionEmpledos implements InterfaceEmpleados {

	// VALIDACION DE LOGEO CON TIPO DE EMPLEADO
	public Empleados ValidaAcceso(String TIPO, String USU, String PSW) {
		Empleados e = null;
		ResultSet rs = null; // tipo de resultado
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLconexion.getConexion();
			String sql = "{call sp_login (?,?,?)}"; // sentencia sql

			pst = con.prepareStatement(sql);
			pst.setString(1, TIPO);
			pst.setString(2, USU);
			pst.setString(3, PSW);
			// parámetros según la sentencia

			rs = pst.executeQuery(); // tipo de ejecución

			// Acciones adicionales en caso de consultas
			while (rs.next()) {
				e = new Empleados();
				e.setLogin_emp(rs.getString(4));
				e.setPsw_emp(rs.getString(5));
				e.setNom_emp(rs.getString(2));
				e.setApe_pat_emp(rs.getString(3));

			}
		} catch (Exception ex) {
			System.out.println("Error en la sentencia " + ex.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException exc) {
				System.out.println("Error al cerrar ");
			}
		}

		return e;
	}

	// LLENAR COMBOBOX TIPO EMPLEADO
	public ArrayList<TipoEmpleado> tipo() {
		ArrayList<TipoEmpleado> lista = new ArrayList<TipoEmpleado>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLconexion.getConexion();
			String sql = "select*from tipo_empleado";

			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				TipoEmpleado te = new TipoEmpleado();
				te.setId_tip_emp(rs.getString(1));
				te.setDesc_emp(rs.getString(2));
				lista.add(te);
			}
		} catch (Exception e) {
			System.out.println("Error en la sentencia" + e.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar");
			}
		}
		return lista;
	}

	@Override
	public ArrayList<Empleados> listado() {
		// TODO Auto-generated method stub
		ArrayList<Empleados> lista = new ArrayList<Empleados>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLconexion.getConexion();
			String sql = " {call sp_listarEmpleado()}";
			pst = (PreparedStatement) con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				Empleados reg = new Empleados();

				reg.setId_emp(rs.getInt(1));
				reg.setNom_emp(rs.getString(2));
				reg.setSueldo_emp(rs.getDouble(3));
				reg.setEstado_emp(rs.getString(4));
				reg.setDni_emp(rs.getString(5));
				reg.setDescripcion(rs.getString(6));
				
				lista.add(reg);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error en la sentencia" + e.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {

				JOptionPane.showMessageDialog(null, "error al cerrar");
			}
		}
		return lista;

	
	}

	@Override
	public ArrayList<Empleados> listado(String nombre) {
		ArrayList<Empleados> lista=new ArrayList<Empleados>();
		ResultSet rs=null;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql="{call sp_BuscarEmp(?)}";
			pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setString(1,nombre);
			rs=pst.executeQuery();
			
			while (rs.next()) {
				Empleados reg = new Empleados();

				reg.setId_emp(rs.getInt(1));
				reg.setNom_emp(rs.getString(2));
				reg.setSueldo_emp(rs.getDouble(3));
				reg.setEstado_emp(rs.getString(4));
				reg.setDni_emp(rs.getString(5));
				reg.setDescripcion(rs.getString(6));
				
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
	public int registrar(Empleados reg) {
		
		int rs=0;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql=" insert into empleado values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setString(1,reg.getNom_emp());
			pst.setString(2,reg.getApe_pat_emp());
			pst.setString(3,reg.getApe_mat_emp());
			pst.setString(4,reg.getSex_emp());
			pst.setString(5,reg.getEmail_emp());
			pst.setDouble(6,reg.getSueldo_emp());
			pst.setString(7,reg.getEstado_emp());
			pst.setString(8,reg.getFech_nac());
			pst.setString(9,reg.getDirec_emp());
			pst.setString(10,reg.getTelf_emp());
			pst.setString(11,reg.getCell_emp());
			pst.setString(12,reg.getDni_emp());
			pst.setString(13,reg.getLogin_emp());
			pst.setString(14,reg.getPsw_emp());
			pst.setString(15,reg.getId_tip_emp());

			
		
			
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
	public int actualizar(Empleados c) {

		int rs=0;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySQLconexion.getConexion();
			String sql=" update empleado  set nom_emp=?,ape_pat_emp=?,ape_mat_emp=?,sex_emp=?,email_emp=?,sueldo_emp=?,estado_emp=?,fech_nac=?,direc_emp=?,telf_emp=?,cell_emp=?,dni_emp=?,login_emp=?,psw_emp=?,id_tip_emp=? where id_emp=?";
			
			pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setString(1,c.getNom_emp());
			pst.setString(2,c.getApe_pat_emp());
			pst.setString(3,c.getApe_mat_emp());
			pst.setString(4,c.getSex_emp());
			pst.setString(5,c.getEmail_emp());
			pst.setDouble(6, c.getSueldo_emp());
			pst.setString(7,c.getEstado_emp());
			pst.setString(8,c.getFech_nac());
			pst.setString(9,c.getDirec_emp());
			pst.setString(10,c.getTelf_emp());
			pst.setString(11,c.getCell_emp());
			pst.setString(12,c.getDni_emp());
			pst.setString(13,c.getLogin_emp());
			pst.setString(14,c.getPsw_emp());
			pst.setString(15,c.getId_tip_emp());
			
		
			
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
			String sql=" delete from empleado where id_emp=?";
			
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
	public Empleados ValidaAcceso2(String USU, String PSW) {
		Empleados e = null;
		ResultSet rs = null; // tipo de resultado
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLconexion.getConexion();
			String sql = "{call sp_Login_sinTIP (?,?)}"; // sentencia sql

			pst = con.prepareStatement(sql);
			
			pst.setString(1, USU);
			pst.setString(2, PSW);
			// parámetros según la sentencia

			rs = pst.executeQuery(); // tipo de ejecución

			// Acciones adicionales en caso de consultas
			while (rs.next()) {
				e = new Empleados();
				e.setLogin_emp(rs.getString(4));
				e.setPsw_emp(rs.getString(5));
				e.setNom_emp(rs.getString(2));
				e.setApe_pat_emp(rs.getString(3));
				e.setId_tip_emp(rs.getString(16));

			}
		} catch (Exception ex) {
			System.out.println("Error en la sentencia " + ex.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException exc) {
				System.out.println("Error al cerrar ");
			}
		}

		return e;
	}

}
