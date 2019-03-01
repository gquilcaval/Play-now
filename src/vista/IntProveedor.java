package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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

import mantenimientos.GestionProveedor;
import model.Proveedores;

public class IntProveedor extends JInternalFrame {

	private JTabbedPane panelPrincipal;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblProveedor;
	private JTextField txtBusquedaProv;
	private JTable tblProveedor;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblRuc;
	private JLabel lblDireccion;
	private JLabel lblTelefono;
	private JLabel lblCelular;
	private JLabel lblEmail;
	private JLabel lblEstado;
	private JLabel lblNrocuentaprov;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtRuc;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtCelular;
	private JTextField txtEmail;
	private JTextField txtNroCuenta;
	private JButton btnNuevo;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JScrollPane scrollPane;
	private JButton btnAceptar;
	private JButton btnCancelar;

	private JTextField txtcodOculto;
	private JComboBox cboEstado;
	
	DefaultTableModel model=new DefaultTableModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntProveedor frame = new IntProveedor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IntProveedor() {
		setBorder(null);
		setBounds(100, 100, 722, 416);
		getContentPane().setLayout(null);
		
		panelPrincipal = new JTabbedPane(JTabbedPane.TOP);
		panelPrincipal.setBounds(35, 46, 661, 320);
		getContentPane().add(panelPrincipal);
		
		panel = new JPanel();
		panelPrincipal.addTab("buscar Proveedor", null, panel, null);
		panel.setLayout(null);
		
		lblProveedor = new JLabel("Proveedor : ");
		lblProveedor.setBounds(10, 48, 70, 14);
		panel.add(lblProveedor);
		
		txtBusquedaProv = new JTextField();
		txtBusquedaProv.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				buscarProv();
			}
		});
		
		
		
		txtBusquedaProv.setBounds(84, 45, 250, 20);
		panel.add(txtBusquedaProv);
		txtBusquedaProv.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 89, 523, 192);
		panel.add(scrollPane);
		
		tblProveedor = new JTable();
		tblProveedor.setColumnSelectionAllowed(true);
		tblProveedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int fila1 = tblProveedor.getSelectedRow();
				txtCodigo.setText(tblProveedor.getValueAt(fila1, 0).toString());
				txtcodOculto.setText(tblProveedor.getValueAt(fila1, 1).toString());// <-- PARA REALIZAR REGISTRO
				
				btnModificar.setEnabled(true);
				btnEliminar.setEnabled(true);
			}
		});
		tblProveedor.setCellSelectionEnabled(true);
		tblProveedor.setModel(model);
		model.addColumn("ID");
		model.addColumn("Razon Social");
		model.addColumn("Ruc");
		model.addColumn("Direccion");
		model.addColumn("Telefono");
		model.addColumn("Celular");
		model.addColumn("Email");
		model.addColumn("Estado");
		model.addColumn("N° Cuenta");
		
		scrollPane.setViewportView(tblProveedor);
		
		txtcodOculto = new JTextField();
		scrollPane.setColumnHeaderView(txtcodOculto);
		txtcodOculto.setColumns(10);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPrincipal.removeAll();

				panelPrincipal.add("Nuevo ", panel_1);

				txtCodigo.setText("");
				txtCodigo.setEditable(false);
			
			}
		});
		btnNuevo.setBounds(557, 64, 89, 23);
		panel.add(btnNuevo);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				panelPrincipal.removeAll();

				panelPrincipal.add("Modificar", panel_1);

				txtCodigo.setEditable(false);
			}
		});
		btnModificar.setBounds(557, 98, 89, 23);
		panel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (txtcodOculto.getText().isEmpty()) {
					
				}
				else{eliminar();}
				
			}
		});
		btnEliminar.setBounds(557, 135, 89, 23);
		panel.add(btnEliminar);
		
		panel_1 = new JPanel();
		panelPrincipal.addTab("Mantener Proveedor", null, panel_1, null);
		panel_1.setLayout(null);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 16, 46, 14);
		panel_1.add(lblCodigo);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 46, 46, 14);
		panel_1.add(lblNombre);
		
		lblRuc = new JLabel("Ruc");
		lblRuc.setBounds(10, 76, 46, 14);
		panel_1.add(lblRuc);
		
		lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(10, 106, 65, 14);
		panel_1.add(lblDireccion);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 136, 65, 14);
		panel_1.add(lblTelefono);
		
		lblCelular = new JLabel("Celular");
		lblCelular.setBounds(10, 166, 46, 14);
		panel_1.add(lblCelular);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 196, 46, 14);
		panel_1.add(lblEmail);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(10, 226, 46, 14);
		panel_1.add(lblEstado);
		
		lblNrocuentaprov = new JLabel("N\u00B0 Cuenta");
		lblNrocuentaprov.setBounds(10, 262, 75, 14);
		panel_1.add(lblNrocuentaprov);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(85, 11, 86, 20);
		panel_1.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(85, 42, 86, 20);
		panel_1.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtRuc = new JTextField();
		txtRuc.setBounds(85, 73, 86, 20);
		panel_1.add(txtRuc);
		txtRuc.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(85, 104, 86, 20);
		panel_1.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(85, 135, 86, 20);
		panel_1.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtCelular = new JTextField();
		txtCelular.setBounds(85, 166, 86, 20);
		panel_1.add(txtCelular);
		txtCelular.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(85, 197, 86, 20);
		panel_1.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtNroCuenta = new JTextField();
		txtNroCuenta.setBounds(85, 259, 86, 20);
		panel_1.add(txtNroCuenta);
		txtNroCuenta.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panelPrincipal.removeAll();
				panelPrincipal.add("Buscar", panel);
				panelPrincipal.add("Nuevo / Modificar", panel_1);
				
				if (txtCodigo.getText().isEmpty()) {
					registrar();
				}
				else {
					actualizar();
					
					
				}
			}
		});
		btnAceptar.setBounds(377, 192, 89, 23);
		panel_1.add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panelPrincipal.removeAll();
				panelPrincipal.add("Buscar", panel);
				panelPrincipal.add("Nuevo / Modificar", panel_1);

				panelPrincipal.revalidate();
				panelPrincipal.repaint();
			}
		});
		btnCancelar.setBounds(377, 222, 89, 23);
		panel_1.add(btnCancelar);
		
		cboEstado = new JComboBox();
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"Activo", "Inactivo"}));
		cboEstado.setBounds(85, 223, 86, 20);
		panel_1.add(cboEstado);
		
listar();
	}
	

	void listar() {

		GestionProveedor gp = new GestionProveedor();
		ArrayList<Proveedores> lista = gp.listado();

		for (Proveedores cl : lista) {
			Object datos[] = {  cl.getId_prov(),cl.getNom_prov(), cl.getRuc_prov(), cl.getDirec_prov(), cl.getTelf_prov(),
					cl.getCell_prov(),cl.getEmail_prov(),cl.getEstado_prov(),cl.getNro_cuenta_prov() };

			model.addRow(datos);

		}

	}
	
	
	void buscarProv() {

		String proveedor = txtBusquedaProv.getText();

		GestionProveedor gc = new GestionProveedor();
		model.getDataVector().removeAllElements();

		ArrayList<Proveedores> list = gc.listado(proveedor);
		for (Proveedores  cl : list) {
			Object datos[] = { cl.getId_prov(),cl.getNom_prov(), cl.getRuc_prov(), cl.getDirec_prov(), cl.getTelf_prov(),
					cl.getCell_prov(),cl.getEmail_prov(),cl.getEstado_prov(),cl.getNro_cuenta_prov()};
			model.addRow(datos);

		}
	}
	
	
	void registrar() {

		String nom, ruc, direc, telf, cell,email,estado,nro_cuenta;
		nom = txtNombre.getText();
		ruc = txtRuc.getText();
		direc = txtDireccion.getText();
	    telf = txtTelefono.getText();
		cell = txtCelular.getText();
		email = txtEmail.getText();
		estado = (String) cboEstado.getSelectedItem();
		nro_cuenta = txtNroCuenta.getText();
		
			Proveedores c = new Proveedores();
			c.setNom_prov(nom);
			c.setRuc_prov(ruc);;
			c.setDirec_prov(direc);;
			c.setTelf_prov(telf);;
			c.setCell_prov(cell);
			c.setEmail_prov(email);
			c.setEstado_prov(estado);
			c.setNro_cuenta_prov(nro_cuenta);

			GestionProveedor gc = new GestionProveedor();

			int ok = gc.registrar(c);
			
			if (ok == 0) {
				
			} else {
				JOptionPane.showMessageDialog(null, "registro correcto");
				model.setRowCount(0);
				listar();
			}
			
			panelPrincipal.removeAll();
			panelPrincipal.add("Buscar", panel);
			panelPrincipal.add("Nuevo / Modificar", panel_1);


		}
		
		

		
			

	void actualizar() {

		int id;
		String nom, ruc, direc, telf, cell,email,estado,nro_cuenta;
		
		id=Integer.parseInt(txtCodigo.getText());
		nom = txtNombre.getText();
		ruc = txtRuc.getText();
		direc = txtDireccion.getText();
	    telf = txtTelefono.getText();
		cell = txtCelular.getText();
		email = txtEmail.getText();
		estado = (String) cboEstado.getSelectedItem();
		nro_cuenta = txtNroCuenta.getText();

		Proveedores c = new Proveedores();
	
		c.setId_prov(id);
		c.setNom_prov(nom);
		c.setRuc_prov(ruc);;
		c.setDirec_prov(direc);;
		c.setTelf_prov(telf);;
		c.setCell_prov(cell);
		c.setEmail_prov(email);
		c.setEstado_prov(estado);
		c.setNro_cuenta_prov(nro_cuenta);

		GestionProveedor gc = new GestionProveedor();

		int ok = gc.actualizar(c);

		if (ok == 0) {
	
		} else {
			JOptionPane.showMessageDialog(null, ok + "Registro actulizado");
			model.setRowCount(0);
			listar();
		}
	}
	
	
	void eliminar() {

		int id;

		id = Integer.parseInt(txtCodigo.getText());

		GestionProveedor gc = new GestionProveedor();

		int ok = gc.eliminar(id);

		if (ok == 0) {
			
		} else {
			JOptionPane.showMessageDialog(null, ok + " Registro eliminado");
			model.setRowCount(0); // <--------- LIMPIA LA TABLA
			listar();
		}
	}
}
