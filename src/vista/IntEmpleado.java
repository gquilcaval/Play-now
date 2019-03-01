package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import mantenimientos.GestionEmpledos;
import model.Empleados;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class IntEmpleado extends JInternalFrame {

	private JTextField txtBusqueda;
	public static JTable tblEmpleados;
	private JTextField txtidEmpleado;
	private JTextField txtNombreEmp;
	private JTextField txtApellidoPat;
	private JTextField txtTelfCli;
	private JButton btnNuevo;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnSalir;
	private JTextField txtDni;
	private JLabel label;
	private JTextField txtDirecEmp;
	private JLabel lblBusqueda;
	private JButton btnCancelar;
	private JTextField txtDniOculto;
	private JTabbedPane panelPrincipal;
	private JPanel panel_1;
	private JPanel panel;
	private JTextField txtApellidoMat;
	private JLabel lblSexo;
	private JTextField txtEmail;
	private JTextField txtSueldo;
	private JTextField txtCelular;
	private JTextField txtLogin;
	private JTextField txtContra;
	private JComboBox cboSexo;
	private JComboBox cboEstado;
	private JDateChooser dtmFecha;
	private JComboBox cboTipoEmpleado;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntEmpleado frame = new IntEmpleado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	DefaultTableModel model = new DefaultTableModel();

	/**
	 * Create the frame.
	 */
	public IntEmpleado() {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameActivated(InternalFrameEvent arg0) {
				listar();
			}
		});
		setBorder(null);
		

		setTitle("Empleados");
		setBounds(100, 100, 697, 550);
		getContentPane().setLayout(null);

		panelPrincipal = new JTabbedPane(JTabbedPane.TOP);
		panelPrincipal.setBounds(39, 33, 615, 467);
		getContentPane().add(panelPrincipal);

		model.addColumn("id ");
		model.addColumn("Nombre");
		model.addColumn("Sueldo");
		model.addColumn("Estado");
		model.addColumn("Dni");
		model.addColumn("Puesto");
		

		panel = new JPanel();

		panelPrincipal.addTab("Buscar", null, panel, null);
		panel.setLayout(null);

		txtBusqueda = new JTextField();
		txtBusqueda.setName("");
		txtBusqueda.setToolTipText("");
		txtBusqueda.addKeyListener(new KeyAdapter() {

			/*-----------------------> EVENTO BUSCAR CLIENTE <----------------------------*/
			@Override
			public void keyReleased(KeyEvent arg0) {
				buscarCli();
			}
		});
		/*----------------------------------------------------------------------------------------*/
		txtBusqueda.setBounds(20, 33, 241, 20);
		panel.add(txtBusqueda);
		txtBusqueda.setColumns(10);

		lblBusqueda = new JLabel("Busqueda");
		lblBusqueda.setBounds(21, 11, 61, 14);
		panel.add(lblBusqueda);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(20, 64, 462, 181);

		panel.add(scrollPane);

		tblEmpleados = new JTable();

		tblEmpleados.addMouseListener(new MouseAdapter() {

			/*-----------------------> EVENTO SELECCIONAR CLIENTE <----------------------------*/
			@Override
			public void mouseClicked(MouseEvent arg0) {

				int fila1 = tblEmpleados.getSelectedRow();
				txtidEmpleado.setText(tblEmpleados.getValueAt(fila1, 0).toString());
				txtDniOculto.setText(tblEmpleados.getValueAt(fila1, 4).toString());
			
				btnModificar.setEnabled(true);
				btnEliminar.setEnabled(true);
			}
		});

		/*-----------------------------------------------------------------------------------*/
		
		tblEmpleados.setCellSelectionEnabled(true);
		tblEmpleados.setModel(model);
		scrollPane.setViewportView(tblEmpleados);
		
		txtDniOculto = new JTextField();
		scrollPane.setColumnHeaderView(txtDniOculto);
		txtDniOculto.setColumns(10);

		btnNuevo = new JButton("Nuevo");

		btnNuevo.setBounds(408, 32, 73, 23);
		panel.add(btnNuevo);

		btnModificar = new JButton("Modificar");
		btnModificar.setEnabled(false);
		btnModificar.setBounds(502, 96, 73, 23);
		panel.add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtidEmpleado.getText().isEmpty()) {
					
				}
				else{eliminar();
				}
			}
		});
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(502, 130, 73, 23);
		panel.add(btnEliminar);

		btnSalir = new JButton("salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(502, 164, 73, 23);
		panel.add(btnSalir);
		
		JButton btnCambiarContrasea = new JButton("cambiar contrase\u00F1a");
		btnCambiarContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panelPrincipal.removeAll();

				panelPrincipal.add("Modificar", panel_1);
			}
		});
		btnCambiarContrasea.setBounds(492, 61, 108, 23);
		panel.add(btnCambiarContrasea);

		panel_1 = new JPanel();
		panelPrincipal.addTab("Nuevo / Modificar", null, panel_1, null);
		panelPrincipal.setEnabledAt(1, false);
		panel_1.setLayout(null);
		

		JLabel lblNewLabel = new JLabel("ID Empleado");
		lblNewLabel.setBounds(27, 35, 69, 14);
		panel_1.add(lblNewLabel);

		txtidEmpleado = new JTextField();
		txtidEmpleado.setEditable(false);
		txtidEmpleado.setBounds(172, 32, 99, 20);
		panel_1.add(txtidEmpleado);
		txtidEmpleado.setColumns(10);

		txtNombreEmp = new JTextField();
		txtNombreEmp.setBounds(172, 57, 99, 20);
		panel_1.add(txtNombreEmp);
		txtNombreEmp.setColumns(10);

		JLabel lblNombreORazon = new JLabel("Nombre");
		lblNombreORazon.setBounds(27, 57, 135, 14);
		panel_1.add(lblNombreORazon);

		JLabel lblRuc = new JLabel("Apellidos Paterno");
		lblRuc.setBounds(27, 82, 94, 14);
		panel_1.add(lblRuc);

		txtApellidoPat = new JTextField();
		txtApellidoPat.setBounds(172, 82, 99, 20);
		panel_1.add(txtApellidoPat);
		txtApellidoPat.setColumns(10);

		txtDni = new JTextField();
		txtDni.setBounds(172, 329, 99, 20);
		panel_1.add(txtDni);
		txtDni.setColumns(10);

		JLabel lblDni = new JLabel("Dni");
		lblDni.setBounds(27, 332, 69, 14);
		panel_1.add(lblDni);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(27, 280, 69, 14);
		panel_1.add(lblTelefono);

		txtTelfCli = new JTextField();
		txtTelfCli.setBounds(172, 277, 99, 20);
		panel_1.add(txtTelfCli);
		txtTelfCli.setColumns(10);

		txtDirecEmp = new JTextField();
		txtDirecEmp.setBounds(172, 255, 99, 20);
		panel_1.add(txtDirecEmp);
		txtDirecEmp.setColumns(10);

		label = new JLabel("Direcci\u00F3n");
		label.setBounds(27, 255, 69, 14);
		panel_1.add(label);

		JButton btnAceptar = new JButton("Aceptar");
		
		/*-----------------------> EVENTO AL ACEPTAR REGISTRA O ACTUALIZA DATOS DEL CLIENTE <----------------------------*/
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				panelPrincipal.removeAll();
				panelPrincipal.add("Buscar", panel);
				panelPrincipal.add("Nuevo / Modificar", panel_1);

				if (txtidEmpleado.getText().isEmpty()) {
					registrar();
				}
				else {
					actualizar();
					
				}
			}
		});
		
		/*------------------------------------------------------------------------------------------------------*/
		btnAceptar.setBounds(369, 106, 94, 23);
		panel_1.add(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		
		/*-----------------------> EVENTO AL CANCELAR REGRESA A LA VENTANA CLIENTE BUSCAR <----------------------------*/
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPrincipal.removeAll();
				panelPrincipal.add("Buscar", panel);
				panelPrincipal.add("Nuevo / Modificar", panel_1);

			}
		});
		
		/*--------------------------------------------------------------------------------------------*/
		btnCancelar.setBounds(369, 140, 94, 23);
		panel_1.add(btnCancelar);
		
		txtApellidoMat = new JTextField();
		txtApellidoMat.setBounds(172, 107, 99, 20);
		panel_1.add(txtApellidoMat);
		txtApellidoMat.setColumns(10);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Materno");
		lblApellidoMaterno.setBounds(27, 107, 99, 14);
		panel_1.add(lblApellidoMaterno);
		
		lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(27, 140, 46, 14);
		panel_1.add(lblSexo);
		
		cboSexo = new JComboBox();
		cboSexo.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		cboSexo.setBounds(171, 137, 100, 20);
		panel_1.add(cboSexo);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(27, 165, 46, 14);
		panel_1.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(172, 162, 86, 20);
		panel_1.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblSuelfo = new JLabel("Sueldo");
		lblSuelfo.setBounds(27, 189, 46, 14);
		panel_1.add(lblSuelfo);
		
		txtSueldo = new JTextField();
		txtSueldo.setBounds(172, 186, 86, 20);
		panel_1.add(txtSueldo);
		txtSueldo.setColumns(10);
		
		cboEstado = new JComboBox();
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"Activo", "Inactivo"}));
		cboEstado.setBounds(172, 209, 99, 20);
		panel_1.add(cboEstado);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(27, 214, 46, 14);
		panel_1.add(lblEstado);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha nacimiento");
		lblFechaNacimiento.setBounds(27, 230, 111, 14);
		panel_1.add(lblFechaNacimiento);
		
		dtmFecha = new JDateChooser();
		dtmFecha.setBounds(172, 230, 95, 20);
		panel_1.add(dtmFecha);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(27, 307, 46, 14);
		panel_1.add(lblCelular);
		
		txtCelular = new JTextField();
		txtCelular.setBounds(172, 298, 86, 20);
		panel_1.add(txtCelular);
		txtCelular.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setBounds(27, 359, 46, 14);
		panel_1.add(lblNewLabel_1);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(172, 356, 86, 20);
		panel_1.add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(27, 394, 69, 14);
		panel_1.add(lblContrasea);
		
		txtContra = new JTextField();
		txtContra.setText("");
		txtContra.setBounds(172, 387, 86, 20);
		panel_1.add(txtContra);
		txtContra.setColumns(10);
		
		JLabel lblTipoempleado = new JLabel("TipoEmpleado");
		lblTipoempleado.setBounds(27, 419, 69, 14);
		panel_1.add(lblTipoempleado);
		
		cboTipoEmpleado = new JComboBox();
		cboTipoEmpleado.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar", "Administrador", "Vendedor"}));
		cboTipoEmpleado.setBounds(171, 416, 100, 20);
		panel_1.add(cboTipoEmpleado);

		/*-----------------------> EVENTO  ELIMANAR CLIENTE <-------------------------*/
		/*btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtDniOculto.getText().isEmpty()) {
				
				}
				else{
					eliminar();
				}
				
			}
		});*/
		
		/*-----------------------------------------------------------------------*/
		
		
		/*--------> EVENTO  AL PRECIONAR EL BOTON MODIFICAR TE ABRE FORMULARIO PARA MODIFICAR <----------*/
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				panelPrincipal.removeAll();

				panelPrincipal.add("Modificar", panel_1);

				
				
			}
		});

		/*-----------------------------------------------------------------------------------------------*/
		
		/*-------> EVENTO  TE ABRE FORMULARIO PARA AGREGAR CLIENTE <----------*/
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPrincipal.removeAll();

				panelPrincipal.add("Nuevo ", panel_1);

				
				
				txtidEmpleado.setText("");
				
				

			}
		});
     
		/*-------------------------------------------------------------------------*/
	}

	void listar() {

		GestionEmpledos gc = new GestionEmpledos();
		ArrayList<Empleados> lista = gc.listado();
		
		
		for (Empleados c : lista) {
			Object datos[] = {  c.getId_emp(),c.getNom_emp(),c.getSueldo_emp(),c.getEstado_emp(),c.getDni_emp(),c.getDescripcion()};

			model.addRow(datos);

		}

	}

	void buscarCli() {

		String cliente = txtBusqueda.getText();

		GestionEmpledos gc = new GestionEmpledos();
		model.getDataVector().removeAllElements();

		ArrayList<Empleados> list = gc.listado(cliente);
		for (Empleados c : list) {
			Object datos[] = {  c.getId_emp(),c.getNom_emp(),c.getSueldo_emp(),c.getEstado_emp(),c.getDni_emp(),c.getDescripcion()};

			model.addRow(datos);

		}
	}

	void registrar() {

		String nom_emp ,ape_mat_emp,ape_pat_emp,sex_emp ,email_emp,estado_emp,	fech_nac ,direc_emp,telf_emp,cell_emp,
		dni_emp,login_emp,psw_emp,id_tip_emp;
		
		 Double sueldo_emp;
		
		 
		nom_emp = txtNombreEmp.getText();
		ape_mat_emp=txtApellidoMat.getText();
		ape_pat_emp=txtApellidoPat.getText();
		sex_emp=Integer.toString(cboSexo.getSelectedIndex());
		email_emp=txtEmail.getText();
		sueldo_emp=Double.parseDouble(txtSueldo.getText());
		estado_emp=cboEstado.getSelectedIndex()+"";
		
		

		Date fe=dtmFecha.getDate();
		SimpleDateFormat forma=new SimpleDateFormat("yyyy/MM/dd");
		fech_nac=forma.format(fe);
		
	
	
		direc_emp=txtDirecEmp.getText();
		telf_emp=txtTelfCli.getText();
		cell_emp=txtCelular.getText();
		dni_emp=txtDni.getText();
		login_emp=txtLogin.getText();
		psw_emp=txtContra.getText();
		id_tip_emp=Integer.toString(cboTipoEmpleado.getSelectedIndex());
		
		Empleados c = new Empleados();
		c.setNom_emp(nom_emp);
		c.setApe_mat_emp(ape_mat_emp);
		c.setApe_pat_emp(ape_pat_emp);
		c.setSex_emp(sex_emp);
		c.setEmail_emp(email_emp);
		c.setSueldo_emp(sueldo_emp);
		c.setEstado_emp(estado_emp);
		c.setFech_nac(fech_nac);
		c.setDirec_emp(direc_emp);
		c.setTelf_emp(telf_emp);
		c.setCell_emp(cell_emp);
		c.setDni_emp(dni_emp);
		c.setLogin_emp(login_emp);
		c.setPsw_emp(psw_emp);
		c.setId_tip_emp(id_tip_emp);
		if (nom_emp.matches("[a-zA-Z]+")) {
	

			GestionEmpledos gc = new GestionEmpledos();

			int ok = gc.registrar(c);
			
			if (ok == 0) {
				
			} else {
				JOptionPane.showMessageDialog(null, "registro correcto");
				model.setRowCount(0);
				vaciarCampos();
				listar();
			}
			
			panelPrincipal.removeAll();
			panelPrincipal.add("Buscar", panel);
			panelPrincipal.add("Nuevo / Modificar", panel_1);


		}
		else {
			JOptionPane.showMessageDialog(null,"campo nombre incorrecto");
			
		}
		

		
			}

	void actualizar() {

		String nom_emp ,ape_mat_emp,ape_pat_emp,sex_emp ,email_emp,estado_emp,	fech_nac ,direc_emp,telf_emp,cell_emp,
		dni_emp,login_emp,psw_emp,id_tip_emp;
		
		 Double sueldo_emp;
		
		 
		nom_emp = txtNombreEmp.getText();
		ape_mat_emp=txtApellidoMat.getText();
		ape_pat_emp=txtApellidoPat.getText();
		sex_emp=cboSexo.getSelectedIndex()+"";
		email_emp=txtEmail.getText();
		sueldo_emp=Double.parseDouble(txtSueldo.getText());
		estado_emp=cboEstado.getSelectedIndex()+"";
		
		
		Date fe=dtmFecha.getDate();
		SimpleDateFormat forma=new SimpleDateFormat("yyyy/MM/dd");
		fech_nac=forma.format(fe);
		
		
		
		direc_emp=txtDirecEmp.getText();
		telf_emp=txtTelfCli.getText();
		cell_emp=txtCelular.getText();
		dni_emp=txtDni.getText();
		login_emp=txtLogin.getText();
		psw_emp=txtContra.getText();
		id_tip_emp=Integer.toString(cboTipoEmpleado.getSelectedIndex());

		Empleados c = new Empleados();
	
		c.setNom_emp(nom_emp);
		c.setApe_mat_emp(ape_mat_emp);
		c.setApe_pat_emp(ape_pat_emp);
		c.setSex_emp(sex_emp);
		c.setEmail_emp(email_emp);
		c.setSueldo_emp(sueldo_emp);
		c.setEstado_emp(estado_emp);
		c.setFech_nac(fech_nac);
		c.setDirec_emp(direc_emp);
		c.setTelf_emp(telf_emp);
		c.setCell_emp(cell_emp);
		c.setDni_emp(dni_emp);
		c.setLogin_emp(login_emp);
		c.setPsw_emp(psw_emp);
		c.setId_tip_emp(id_tip_emp);
		
		GestionEmpledos gc = new GestionEmpledos();

		int ok = gc.actualizar(c);

		if (ok == 0) {
		
		} else {
			JOptionPane.showMessageDialog(null, ok + "Registro actulizado");
			model.setRowCount(0);
			vaciarCampos();
			listar();
		}
	}

	void eliminar() {

		String dni;

		dni = txtidEmpleado.getText();

		GestionEmpledos gc = new GestionEmpledos();

		int ok = gc.eliminar(dni);

		if (ok == 0) {
			
		} else {
			JOptionPane.showMessageDialog(null, ok + " Registro eliminado");
			model.setRowCount(0);  // <--------- LIMPIA LA TABLA
			listar();
		}

	}
	
	void vaciarCampos(){
		txtidEmpleado.setText("");
		txtNombreEmp.setText("");
		txtApellidoPat.setText("");
		txtApellidoMat.setText("");
		txtEmail.setText("");
		txtSueldo.setText("");
		
		txtDirecEmp.setText("");
		txtTelfCli.setText("");
		txtCelular.setText("");
		txtDni.setText("");
		txtLogin.setText("");
		txtContra.setText("");
		cboTipoEmpleado.setSelectedIndex(0);;
		
	}
}