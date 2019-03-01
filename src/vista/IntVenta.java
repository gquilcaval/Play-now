package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Caret;

import mantenimientos.GestionVentas;
import model.DetalleVentas;
import model.Ventas;
import java.awt.Component;
import javax.swing.ImageIcon;
import java.awt.Cursor;

public class IntVenta extends JInternalFrame {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNombre;
	public static JTextField txtNombreCliente;
	private JLabel lblCodigo;
	public static JTextField txtCodigoProducto;
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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntVenta frame = new IntVenta();
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
	public IntVenta() {
		setAlignmentX(Component.LEFT_ALIGNMENT);
		setAlignmentY(Component.TOP_ALIGNMENT);
		setBackground(new Color(237, 240, 249));
		
		setOpaque(true);
		setBorder(null);
		setBounds(100, 100, 450, 300);
		setBounds(100, 100, 805, 603);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
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
		
		btnQuitar = new JLabel("");
		btnQuitar.setHorizontalAlignment(SwingConstants.CENTER);
		btnQuitar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQuitar.setIcon(new ImageIcon(IntVenta.class.getResource("/img/menos.png")));
		btnQuitar.setBounds(415, 5, 32, 28);
		panel_2.add(btnQuitar);
		
		btnAgregar = new JLabel("");
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregar.setHorizontalAlignment(SwingConstants.CENTER);
		btnAgregar.setIcon(new ImageIcon(IntVenta.class.getResource("/img/mas.png")));
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				agregarProducto();
			}
		});
		btnAgregar.setBounds(379, 5, 32, 28);
		panel_2.add(btnAgregar);

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
		pnlDatosVenta.setBackground(Color.WHITE);
		pnlDatosVenta.setBorder(new TitledBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de la Venta", TitledBorder.LEADING,
						TitledBorder.TOP, null, new Color(0, 0, 0)),
				"Datos de la Venta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlDatosVenta.setBounds(37, 0, 742, 216);
		contentPanel.add(pnlDatosVenta);
		pnlDatosVenta.setLayout(null);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
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
		
		btnBuscarCliente = new JLabel("");
		btnBuscarCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscarCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FrmClientes f = new FrmClientes();
				f.setVisible(true); // <------------------------------ EVENTO
									// BUSCAR PRODUCTOS
				f.setLocationRelativeTo(null);
			}
		});
		btnBuscarCliente.setIcon(new ImageIcon(IntVenta.class.getResource("/img/busqueda.png")));
		btnBuscarCliente.setBounds(220, 33, 33, 31);
		panel.add(btnBuscarCliente);

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
		panel_1.setBackground(Color.WHITE);
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
		
		btnBuscarProducto = new JLabel("");
		btnBuscarProducto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscarProducto.setHorizontalAlignment(SwingConstants.CENTER);
		btnBuscarProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FrmProductos f = new FrmProductos();
				f.setVisible(true); // <------------------------------ EVENTO
									// BUSCAR PRODUCTOS
				f.setLocationRelativeTo(null);
			}
		});
		btnBuscarProducto.setIcon(new ImageIcon(IntVenta.class.getResource("/img/busqueda.png")));
		btnBuscarProducto.setBounds(346, 36, 33, 31);
		panel_1.add(btnBuscarProducto);

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
	private JLabel btnBuscarCliente;
	private JLabel btnBuscarProducto;
	private JLabel btnQuitar;
	private JLabel btnAgregar;
					

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


