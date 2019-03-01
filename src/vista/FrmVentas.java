package vista;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mantenimientos.GestionVentas;
import model.DetalleVentas;
import model.Ventas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.Color;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.SwingConstants;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.border.LineBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmVentas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNombre;
	public static JTextField txtNombreCliente;
	private JButton btnBuscarCliente;
	private JLabel lblCodigo;
	public static JTextField txtCodigoProducto;
	private JButton btnBuscarProducto;
	private JLabel lblNombre_1;
	public static JTextField txtNombreProducto;
	private JLabel lblStock;
	public static JTextField txtStockProducto;
	private JLabel lblPrecio;
	public static JTextField txtPrecioProducto;
	private JLabel lblDocumento;
	private JLabel lblFechaasdadasd;
	private JLabel lblNro;
	private JPanel panel_2;
	private JLabel lblCantidad;
	private JTextField txtCantidadPro;
	private JButton btnAgregar;
	private JButton btnQuitar;
	private JTable tblVenta;
	private JPanel panel_3;
	private JLabel lblImporte;
	private JLabel lblCambio;
	private JTextField txtImporte;
	private JTextField txtCambio;
	private JPanel panel_4;
	private JLabel lblTotalAPagar;
	private JTextField txtTotalAPagar;
	private JLabel lblNumeroVenta;
	private JLabel lblFecha;
	private JPanel pnlDatosVenta;
	public static JTextField txtApellidosCli;
	private JComboBox cboTipoDocumento;
	public static JTextField txtCodigoCliente;
	private JTextField txtIdEmpleado;
	DefaultTableModel modelo = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmVentas dialog = new FrmVentas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmVentas() {

		setTitle("Ventas");
		setBounds(100, 100, 805, 603);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		panel_2 = new JPanel();
		panel_2.setBounds(37, 284, 551, 36);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);

		lblCantidad = new JLabel("Cantidad :");
		lblCantidad.setBounds(10, 11, 56, 14);
		panel_2.add(lblCantidad);

		txtCantidadPro = new JTextField();
		txtCantidadPro.setBounds(91, 8, 72, 20);
		panel_2.add(txtCantidadPro);
		txtCantidadPro.setColumns(10);

		btnAgregar = new JButton("New button");
		/*--------------------------------------------------------*/
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarProducto(); // <------------------------------ EVENTO
									// AGREGAR PRODUCTOS AL CARRITO

			}
		});
		/*---------------------------------------------------------*/
		btnAgregar.setBounds(379, 5, 45, 23);
		panel_2.add(btnAgregar);

		btnQuitar = new JButton("New button");
		btnQuitar.setBounds(430, 5, 47, 23);
		panel_2.add(btnQuitar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 331, 730, 143);
		contentPanel.add(scrollPane);

		tblVenta = new JTable();
		scrollPane.setViewportView(tblVenta);
		tblVenta.setBackground(Color.GRAY);

		tblVenta.setModel(modelo);
		modelo.addColumn("Nro Venta");
		modelo.addColumn("Id Producto");
		modelo.addColumn("Precio Unitario");
		modelo.addColumn("Cantidad");

		scrollPane.setViewportView(tblVenta);

		panel_3 = new JPanel();
		panel_3.setBounds(36, 485, 151, 68);
		contentPanel.add(panel_3);
		panel_3.setLayout(null);

		lblImporte = new JLabel("Importe");
		lblImporte.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblImporte.setBounds(10, 11, 131, 14);
		panel_3.add(lblImporte);

		lblCambio = new JLabel("Cambio");
		lblCambio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCambio.setBounds(80, 11, 61, 14);
		panel_3.add(lblCambio);

		txtImporte = new JTextField();
		txtImporte.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				double Importe;
				
				Importe=Double.parseDouble(txtImporte.getText());
				txtCambio.setText(Importe-total+"");
				
			}
		});
		txtImporte.setBounds(10, 37, 53, 20);
		panel_3.add(txtImporte);
		txtImporte.setColumns(10);

		txtCambio = new JTextField();
		txtCambio.setBounds(80, 36, 61, 20);
		panel_3.add(txtCambio);
		txtCambio.setColumns(10);

		panel_4 = new JPanel();
		panel_4.setBounds(197, 485, 404, 68);
		contentPanel.add(panel_4);
		panel_4.setLayout(null);

		lblTotalAPagar = new JLabel("Total a pagar");
		lblTotalAPagar.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotalAPagar.setBounds(292, 11, 86, 14);
		panel_4.add(lblTotalAPagar);

		txtTotalAPagar = new JTextField();
		txtTotalAPagar.setBounds(292, 37, 86, 20);
		panel_4.add(txtTotalAPagar);
		txtTotalAPagar.setColumns(10);

		pnlDatosVenta = new JPanel();
		pnlDatosVenta.setBorder(new TitledBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de la Venta", TitledBorder.LEADING,
						TitledBorder.TOP, null, new Color(0, 0, 0)),
				"Datos de la Venta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlDatosVenta.setBounds(37, 12, 742, 216);
		contentPanel.add(pnlDatosVenta);
		pnlDatosVenta.setLayout(null);

		panel = new JPanel();
		panel.setBounds(22, 46, 290, 125);
		pnlDatosVenta.add(panel);
		panel.setBorder(
				new TitledBorder(null, "Datos del Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setLayout(null);

		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 64, 46, 14);
		panel.add(lblNombre);

		txtNombreCliente = new JTextField();
		txtNombreCliente.setBounds(68, 63, 117, 20);
		panel.add(txtNombreCliente);
		txtNombreCliente.setColumns(10);

		btnBuscarCliente = new JButton("New button");
	

		btnBuscarCliente.addMouseListener(new MouseAdapter() {
			@Override
			/*-----------------------------------------------------*/
			public void mouseClicked(MouseEvent e) {
				FrmClientes clientes = new FrmClientes();
				clientes.setLocationRelativeTo(null); // <------------------------------
														// EVENTO AGREGAR BUSCAR
														// CLIENTE
				clientes.tblClientes.setCellSelectionEnabled(true);
				clientes.setVisible(true);

			}
		});
		/*-----------------------------------------------------------*/
		btnBuscarCliente.setBounds(221, 32, 38, 23);
		panel.add(btnBuscarCliente);

		txtApellidosCli = new JTextField();
		txtApellidosCli.setColumns(10);
		txtApellidosCli.setBounds(68, 94, 117, 20);
		panel.add(txtApellidosCli);

		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(10, 97, 58, 14);
		panel.add(lblApellidos);

		JLabel lblCodigo_1 = new JLabel("Codigo");
		lblCodigo_1.setBounds(10, 36, 46, 14);
		panel.add(lblCodigo_1);

		txtCodigoCliente = new JTextField();
		txtCodigoCliente.setBounds(68, 33, 117, 20);
		panel.add(txtCodigoCliente);
		txtCodigoCliente.setColumns(10);

		lblDocumento = new JLabel("Documento :");
		lblDocumento.setBounds(22, 182, 70, 14);
		pnlDatosVenta.add(lblDocumento);

		lblFechaasdadasd = new JLabel("Fecha :");
		lblFechaasdadasd.setBounds(510, 185, 46, 14);
		pnlDatosVenta.add(lblFechaasdadasd);

		lblFecha = new JLabel("");
		lblFecha.setBounds(548, 185, 64, 14);
		pnlDatosVenta.add(lblFecha);

		panel_1 = new JPanel();
		panel_1.setBounds(343, 37, 389, 134);
		pnlDatosVenta.add(panel_1);
		panel_1.setBorder(
				new TitledBorder(null, "Datos del Producto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(null);

		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 50, 46, 14);
		panel_1.add(lblCodigo);

		txtCodigoProducto = new JTextField();
		txtCodigoProducto.setBounds(65, 47, 131, 20);
		panel_1.add(txtCodigoProducto);
		txtCodigoProducto.setColumns(10);

		btnBuscarProducto = new JButton("New button");
		btnBuscarProducto.addActionListener(new ActionListener() {

			/*-------------------------------------------------*/
			public void actionPerformed(ActionEvent e) {

				FrmProductos f = new FrmProductos();
				f.setVisible(true); // <------------------------------ EVENTO
									// BUSCAR PRODUCTOS
				f.setLocationRelativeTo(null);

			}
		});
		/*-------------------------------------------------------*/
		btnBuscarProducto.setBounds(342, 46, 35, 23);
		panel_1.add(btnBuscarProducto);

		lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setBounds(10, 96, 46, 14);
		panel_1.add(lblNombre_1);

		txtNombreProducto = new JTextField();
		txtNombreProducto.setBounds(65, 93, 131, 20);
		panel_1.add(txtNombreProducto);
		txtNombreProducto.setColumns(10);

		lblStock = new JLabel("Stock");
		lblStock.setBounds(231, 50, 46, 14);
		panel_1.add(lblStock);

		txtStockProducto = new JTextField();
		txtStockProducto.setBounds(276, 47, 46, 20);
		panel_1.add(txtStockProducto);
		txtStockProducto.setColumns(10);

		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(231, 96, 46, 14);
		panel_1.add(lblPrecio);

		txtPrecioProducto = new JTextField();
		txtPrecioProducto.setBounds(276, 93, 46, 20);
		panel_1.add(txtPrecioProducto);
		txtPrecioProducto.setColumns(10);

		lblNro = new JLabel("Nro\u00BA de Venta :");
		lblNro.setBounds(287, 185, 105, 20);
		pnlDatosVenta.add(lblNro);
		lblNro.setFont(new Font("Tahoma", Font.BOLD, 11));

		lblNumeroVenta = new JLabel("");
		lblNumeroVenta.setBounds(379, 182, 40, 20);
		pnlDatosVenta.add(lblNumeroVenta);
		lblNumeroVenta.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroVenta.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));

		cboTipoDocumento = new JComboBox();
		cboTipoDocumento.setModel(new DefaultComboBoxModel(new String[] {"Boleta", "Factura"}));
		cboTipoDocumento.setBounds(92, 179, 121, 20);
		pnlDatosVenta.add(cboTipoDocumento);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(37, 239, 302, 34);
		contentPanel.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblIdEmpleado = new JLabel("ID Empleado :");
		lblIdEmpleado.setBounds(10, 11, 86, 14);
		panel_5.add(lblIdEmpleado);

		txtIdEmpleado = new JTextField();
		txtIdEmpleado.setName("");
		txtIdEmpleado.setToolTipText("");
		txtIdEmpleado.setColumns(10);
		txtIdEmpleado.setBounds(90, 8, 92, 20);
		panel_5.add(txtIdEmpleado);

		JButton btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(new ActionListener() {

			/*----------------------------------------------*/
			public void actionPerformed(ActionEvent arg0) {

				grabarVenta(); // <------------------------------ EVENTO GRABAR
								// VENTA

			}
		});
		/*-------------------------------------------------------*/
		btnGrabar.setBounds(645, 510, 89, 23);
		contentPanel.add(btnGrabar);

		MostrarNumero();
		mostrarFecha();
	}

	ArrayList<DetalleVentas> carrito = new ArrayList<>();

	double total = 0; // <----------------VARIABLE GLOBAL PARA EL TOTAL DE LA 	 VENTA
					

	void mostrarFecha() {
		Date fecha = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		lblFecha.setText(sdf.format(fecha));
	}

	void MostrarNumero() {
		// obtener el ultimo numero de boleta(venta) incrementando en 1
		int numero = new GestionVentas().ObtenerNumero();
		lblNumeroVenta.setText(Integer.toString(numero));

	}

	void agregarProducto() {
		// VARIABLES
		int Nro_ven;
		int id_prod, CantxUnidad;
		double precioUnidad;

		// DETALLE VENTA
		Nro_ven = leerNumeroVenta();
		id_prod = leerIdProducto();
		CantxUnidad = leerCantidad();
		precioUnidad = leerPrecioProducto();
		total += (CantxUnidad * precioUnidad);

		// PROCESO
		DetalleVentas dv = new DetalleVentas();
		dv.setNro_ven(Nro_ven);
		dv.setId_prod(id_prod);
		dv.setCantxUnidad(CantxUnidad);
		dv.setPrecioUnidad(precioUnidad);
		carrito.add(dv);

		// SALIDA
		Object datos[] = { Nro_ven, id_prod, precioUnidad, CantxUnidad, precioUnidad * CantxUnidad };
		modelo.addRow(datos);
		txtTotalAPagar.setText(total+"") ;
	}

	void grabarVenta() {
		int Nro_ven, id_cli, id_emp;
		String doc_ven, fech_ven;

		Nro_ven = leerNumeroVenta();
		id_cli = leerIdCliente();
		id_emp = leerIdEmpleado();
		doc_ven = leerTipoDocumento();
		fech_ven = leerFecha();

		Ventas v = new Ventas();
		v.setNro_ven(Nro_ven);
		v.setDoc_ven(doc_ven);
		v.setFech_ven(fech_ven);
		v.setId_cli(id_cli);
		v.setId_emp(id_emp);

		GestionVentas gv = new GestionVentas();

		int ok = gv.realizaVenta(v, carrito);

		if (ok == 0) {
			JOptionPane.showMessageDialog(null, "Error al Grabar la venta");
		} else {
			txtCodigoCliente.setText("");
			txtApellidosCli.setText("");
			txtNombreCliente.setText("");
			txtCodigoProducto.setText("");
			txtNombreProducto.setText("");
			txtStockProducto.setText("");
			txtPrecioProducto.setText("");
			txtIdEmpleado.setText("");
			txtCantidadPro.setText("");
			txtCambio.setText("");
			txtImporte.setText("");
			txtTotalAPagar.setText("");
			modelo.setRowCount(0);
			JOptionPane.showMessageDialog(null, "Venta Exitosa");
			
		}
	}

	int leerNumeroVenta() {
		return Integer.parseInt(lblNumeroVenta.getText());
	}

	String leerTipoDocumento() {
		return String.valueOf(cboTipoDocumento.getSelectedItem());
	}

	String leerFecha() {
		return lblFecha.getText();
	}

	int leerIdCliente() {
		return Integer.parseInt(txtCodigoCliente.getText());
	}

	int leerIdEmpleado() {
		return Integer.parseInt(txtIdEmpleado.getText());
	}

	// METODOS CON PARAMETROS PARA DETALLE DE VENTAS
	int leerIdProducto() {
		return Integer.parseInt(txtCodigoProducto.getText());
	}

	String leerNombre() {
		return txtNombreProducto.getText();
	}

	int leerStockProducto() {
		return Integer.parseInt(txtStockProducto.getText());
	}

	double leerPrecioProducto() {
		return Double.parseDouble(txtPrecioProducto.getText());
	}

	int leerCantidad() {
		return Integer.parseInt(txtCantidadPro.getText());
	}
}
