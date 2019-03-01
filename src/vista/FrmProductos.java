package vista;

import java.awt.BorderLayout;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionCategorias;
import mantenimientos.GestionClientes;
import mantenimientos.GestionProductos;
import mantenimientos.GestionProveedor;
import model.Categoria;
import model.Clientes;
import model.Producto;
import model.Proveedores;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class FrmProductos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtBuscarPro;
	private JTable tblProducto;
	private JTable table_1;
	private JTable table_2;
	private JTextField txtCodigo;
	private JTextField txtDescripcion;
	private JTextField txtStock;
	private JTextField txtPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmProductos dialog = new FrmProductos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	DefaultTableModel model = new DefaultTableModel();
	private JTextField txtCodOculto;
	private JButton btnModifficar;
	private JButton btnEliminar;
	private JComboBox cboCategoria;
	private JComboBox cboProveedor;

	public FrmProductos() {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				listar();
			}
		});
		setBounds(100, 100, 571, 338);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JTabbedPane panelPrincipal = new JTabbedPane(JTabbedPane.TOP);
		panelPrincipal.setBounds(21, 24, 507, 250);
		contentPanel.add(panelPrincipal);

		model.addColumn("Codigo");
		model.addColumn("Descripcion");
		model.addColumn("Stock");
		model.addColumn("precio ");
		model.addColumn("id categoria");
		model.addColumn("id proveedor");

		JPanel panel1 = new JPanel();
		panelPrincipal.addTab("buscar Producto", null, panel1, null);
		panel1.setLayout(null);

		JLabel lblNombre = new JLabel("Buscar");
		lblNombre.setBounds(10, 43, 46, 14);
		panel1.add(lblNombre);

		txtBuscarPro = new JTextField();
		txtBuscarPro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				buscarPro();
			}
		});
		txtBuscarPro.setBounds(66, 40, 185, 20);
		panel1.add(txtBuscarPro);
		txtBuscarPro.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 68, 371, 143);
		panel1.add(scrollPane);

		tblProducto = new JTable();

		tblProducto.addMouseListener(new MouseAdapter() {

			/*-----------------------> EVENTO SELECCIONAR PRODUCTO <----------------------------*/
			@Override
			public void mouseClicked(MouseEvent arg0) {

				//ELIMINAR O REGISTRAR
				int fila1 = tblProducto.getSelectedRow();
				txtCodigo.setText(tblProducto.getValueAt(fila1, 0).toString());
				txtCodOculto.setText(tblProducto.getValueAt(fila1, 3).toString());

				try {

					// COMPRAS
					int fila = tblProducto.getSelectedRow();
					IntVenta.txtCodigoProducto.setText(tblProducto.getValueAt(fila, 0).toString());
					IntVenta.txtNombreProducto.setText(tblProducto.getValueAt(fila, 1).toString());
					IntVenta.txtStockProducto.setText(tblProducto.getValueAt(fila, 2).toString());
					IntVenta.txtPrecioProducto.setText(tblProducto.getValueAt(fila, 3).toString());
					
					

					dispose();
				} catch (Exception e2) {

				}
				try {
					//VENTAS
					int fila2 = tblProducto.getSelectedRow();
					IntCompra.txtCodigoProdu.setText(tblProducto.getValueAt(fila2, 0).toString());
					IntCompra.txtNombreProdu.setText(tblProducto.getValueAt(fila2, 1).toString());
					IntCompra.txtPrecioProdu.setText(tblProducto.getValueAt(fila2, 3).toString());
					IntCompra.txtstockPro.setText(tblProducto.getValueAt(fila2, 2).toString());
					dispose();
				} catch (Exception e) {
					// TODO: handle exception
				}
				btnModifficar.setEnabled(true);
				btnEliminar.setEnabled(true);
			}
		});

		/*-----------------------------------------------------------------------------------*/

		tblProducto.setModel(model);

		scrollPane.setViewportView(tblProducto);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(403, 102, 89, 23);
		panel1.add(btnEliminar);

		btnModifficar = new JButton("Modifficar");
		btnModifficar.setEnabled(false);
		btnModifficar.setBounds(403, 69, 89, 23);
		panel1.add(btnModifficar);

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(301, 39, 89, 23);
		panel1.add(btnNuevo);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(403, 188, 89, 23);
		panel1.add(btnSalir);
		
				txtCodOculto = new JTextField();
				txtCodOculto.setBounds(0, 24, 30, -24);
				panel1.add(txtCodOculto);
				txtCodOculto.setColumns(10);

		JPanel panel2 = new JPanel();
		panelPrincipal.addTab("Modificar Producto", null, panel2, null);
		panel2.setLayout(null);

		table_2 = new JTable();
		table_2.setBounds(188, 5, 0, 0);
		panel2.add(table_2);

		table_1 = new JTable();
		table_1.setBounds(193, 5, 0, 0);
		panel2.add(table_1);

		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 31, 46, 14);
		panel2.add(lblCodigo);

		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(10, 56, 60, 14);
		panel2.add(lblDescripcion);

		JLabel lblNewLabel = new JLabel("Stock");
		lblNewLabel.setBounds(10, 86, 46, 14);
		panel2.add(lblNewLabel);

		JLabel lblPrecio = new JLabel("precio");
		lblPrecio.setBounds(10, 116, 46, 14);
		panel2.add(lblPrecio);

		JLabel lblIdcategoria = new JLabel("categoria");
		lblIdcategoria.setBounds(10, 141, 60, 14);
		panel2.add(lblIdcategoria);

		JLabel lblIdproveedor = new JLabel("Proveedor");
		lblIdproveedor.setBounds(10, 173, 75, 14);
		panel2.add(lblIdproveedor);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(80, 28, 86, 20);
		panel2.add(txtCodigo);
		txtCodigo.setColumns(10);

		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(80, 56, 86, 20);
		panel2.add(txtDescripcion);
		txtDescripcion.setColumns(10);

		txtStock = new JTextField();
		txtStock.setBounds(80, 83, 86, 20);
		panel2.add(txtStock);
		txtStock.setColumns(10);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(80, 113, 86, 20);
		panel2.add(txtPrecio);
		txtPrecio.setColumns(10);

		JButton btnAceptar = new JButton("Aceptar");
		/*-----------------------> EVENTO AL ACEPTAR REGISTRA O ACTUALIZA DATOS DEL CLIENTE <----------------------------*/

		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPrincipal.removeAll();
				panelPrincipal.add("Buscar", panel1);
				panelPrincipal.add("Nuevo / Modificar", panel2);

				/*
				 * DIFERENCIA EL TXTCODIGO CON EL TXTDNI ANTES (PARA PORDER
				 * ENTENDERLO)
				 */
				try {
					if (txtCodigo.getText().isEmpty()) {
						Agregar();
					} else {
						actualizar();
					}
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println("error" + e2.getMessage());
				}

			}
		});
		btnAceptar.setBounds(296, 112, 89, 23);
		panel2.add(btnAceptar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(296, 141, 94, 23);
		panel2.add(btnCancelar);
		
		cboCategoria = new JComboBox();
		cboCategoria.setBounds(80, 138, 86, 20);
		panel2.add(cboCategoria);
		
		cboProveedor = new JComboBox();
		cboProveedor.setBounds(80, 170, 86, 20);
		panel2.add(cboProveedor);

		/*------------------------------------------------------------------------------------------------------*/

		/*-----------------------> EVENTO AL CANCELAR REGRESA A LA VENTANA CLIENTE BUSCAR <----------------------------*/
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPrincipal.removeAll();
				panelPrincipal.add("Buscar", panel1);
				panelPrincipal.add("Nuevo / Modificar", panel2);

				panelPrincipal.revalidate();
				panelPrincipal.repaint();
			}
		});

		/*-----------------------> EVENTO  ELIMANAR CLIENTE <-------------------------*/
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtCodOculto.getText().isEmpty()) {

				} else {
					eliminar();
				}

			}
		});

		/*-----------------------------------------------------------------------*/

		/*--------> EVENTO  AL PRECIONAR EL BOTON MODIFICAR TE ABRE FORMULARIO PARA MODIFICAR <----------*/
		btnModifficar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				panelPrincipal.removeAll();

				panelPrincipal.add("Modificar", panel2);

				txtCodigo.setEditable(false);

			}
		});

		/*-----------------------------------------------------------------------------------------------*/

		/*-------> EVENTO  TE ABRE FORMULARIO PARA AGREGAR CLIENTE <----------*/
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPrincipal.removeAll();

				panelPrincipal.add("Nuevo ", panel2);

				txtCodigo.setEnabled(false);
				txtCodigo.setText("");

			}
		});

		/*-------------------------------------------------------------------------*/

		llenarcboCategoria();
		llenarcboProveedor();
	}

	void listar() {

		GestionProductos gc = new GestionProductos();
		ArrayList<Producto> lista = gc.listado();

		for (Producto cl : lista) {
			Object datos[] = { cl.getCodigo(), cl.getDescripcion(), cl.getStock(), cl.getPrecioUnidad(),
					cl.getIdcategoria(), cl.getIdproveedor() };
			model.addRow(datos);

		}

	}

	void buscarPro() {

		String producto = txtBuscarPro.getText();

		GestionProductos gc = new GestionProductos();
		model.getDataVector().removeAllElements();

		ArrayList<Producto> list = gc.listado(producto);
		for (Producto cl : list) {
			Object datos[] = { cl.getCodigo(), cl.getDescripcion(), cl.getStock(), cl.getPrecioUnidad(),
					cl.getIdcategoria(), cl.getIdproveedor() };
			model.addRow(datos);

		}
	}

	void Agregar() {

		String nom = txtDescripcion.getText();
		double precio = Double.parseDouble(txtPrecio.getText());
		int stock = Integer.parseInt(txtStock.getText());
		String idcate = cboCategoria.getSelectedIndex()+"";
		int proveedor = cboProveedor.getSelectedIndex();

		Producto c = new Producto();
		c.setDescripcion(nom);
		c.setStock(stock);
		
		c.setPrecioUnidad(precio);
		
		c.setIdcategoria(idcate);
		
		c.setIdproveedor(proveedor);

		GestionProductos gc = new GestionProductos();

		int ok = gc.Agregar(c);

		if (ok == 0) {
			
		} else {
			JOptionPane.showMessageDialog(null, "registro correcto");
			model.setRowCount(0);
limpiarCampos();
			listar();
		}

	}

	void actualizar() {

		int codigo, stock, idProve;
		double precio;
		String descripcion, idcate;

		codigo = Integer.parseInt(txtCodigo.getText());
		descripcion = txtDescripcion.getText();
		stock = Integer.parseInt(txtStock.getText());
		precio = Double.parseDouble(txtPrecio.getText());
		idcate = cboCategoria.getSelectedIndex()+"";
		idProve = cboProveedor.getSelectedIndex();

		Producto p = new Producto();

		p.setCodigo(codigo);
		p.setDescripcion(descripcion);
		p.setStock(stock);
		p.setPrecioUnidad(precio);
		p.setIdcategoria(idcate);
		p.setIdproveedor(idProve);

		GestionProductos gc = new GestionProductos();

		int ok = gc.actualizar(p);

		if (ok == 0) {
			
		} else {
			JOptionPane.showMessageDialog(null, ok + "Registro actulizado");
			model.setRowCount(0);
			limpiarCampos();
			listar();
		}
	}

	void eliminar() {
		int cod;
		cod = Integer.parseInt(txtCodigo.getText());

		GestionProductos gc = new GestionProductos();

		int ok = gc.eliminar(cod);

		if (ok == 0) {
			
		} else {
			JOptionPane.showMessageDialog(null, ok + "Registro Eliminado");
			model.setRowCount(0);  // <--------- LIMPIA LA TABLA
		
			listar();
		}
	}
	void llenarcboCategoria(){
		
		GestionCategorias gc=new GestionCategorias();
		ArrayList<Categoria> lista=gc.listar();
		cboCategoria.addItem("selecione tipo");
		
		for (Categoria categoria : lista) {
			cboCategoria.addItem(categoria.getDescripcion());
		}
	}
	
void llenarcboProveedor(){
		
		GestionProveedor gc=new GestionProveedor();
		ArrayList<Proveedores> lista=gc.listado();
		cboProveedor.addItem("selecione tipo");
		
		for (Proveedores proveedores : lista) {
			cboProveedor.addItem(proveedores.getNom_prov());
		}
	}

void limpiarCampos(){
	
	
	txtDescripcion.setText("");
	txtPrecio.setText("");
	txtStock.setText("");
	cboCategoria.setSelectedIndex(0);
	cboProveedor.setSelectedIndex(0);
}
}
