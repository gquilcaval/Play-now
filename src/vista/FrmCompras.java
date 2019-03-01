package vista;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionCompra;
import mantenimientos.GestionVentas;
import model.Compra;
import model.DetalleCompra;
import model.DetalleVentas;
import model.Ventas;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmCompras extends JDialog {
	private JTextField txtCantiCompra;
	private JTextField txtImporte;
	private JTextField txtCambio;
	private JTextField txtTotalPag;
	public static JTextField txtRucProv;
	public static JTextField txtCodigoProdu;
	public static JTextField txtNombreProdu;
	public static JTextField txtstockPro;
	public static JTextField txtPrecioProdu;
	public static JTextField txtRazonSocialProv;

	DefaultTableModel modelo = new DefaultTableModel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCompras dialog = new FrmCompras();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocationRelativeTo(null);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public FrmCompras() {
		setTitle("Compra");
		setBounds(100, 100, 729, 536);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 211, 551, 36);
		getContentPane().add(panel);
		
		JLabel label = new JLabel("Cantidad");
		label.setBounds(10, 11, 56, 14);
		panel.add(label);
		
		txtCantiCompra = new JTextField();
		txtCantiCompra.setColumns(10);
		txtCantiCompra.setBounds(63, 8, 65, 20);
		panel.add(txtCantiCompra);
		
		JButton btnAgregar = new JButton("New button");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				agregarProducto();
			}
		});
		btnAgregar.setBounds(283, 7, 45, 23);
		panel.add(btnAgregar);
		
		JButton btnEliminar = new JButton("New button");
		btnEliminar.setBounds(334, 7, 47, 23);
		panel.add(btnEliminar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 410, 151, 68);
		getContentPane().add(panel_1);
		
		JLabel label_2 = new JLabel("Importe");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(10, 11, 131, 14);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Cambio");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(80, 11, 61, 14);
		panel_1.add(label_3);
		
		txtImporte = new JTextField();
		txtImporte.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
              double Importe;
				
				Importe=Double.parseDouble(txtImporte.getText());
				txtCambio.setText(Importe-total+"");
			}
		});
		txtImporte.setColumns(10);
		txtImporte.setBounds(10, 37, 53, 20);
		panel_1.add(txtImporte);
		
		txtCambio = new JTextField();
		txtCambio.setColumns(10);
		txtCambio.setBounds(80, 36, 61, 20);
		panel_1.add(txtCambio);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(171, 410, 404, 68);
		getContentPane().add(panel_2);
		
		JLabel label_7 = new JLabel("Total a pagar");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_7.setBounds(292, 11, 86, 14);
		panel_2.add(label_7);
		
		txtTotalPag = new JTextField();
		txtTotalPag.setColumns(10);
		txtTotalPag.setBounds(292, 37, 86, 20);
		panel_2.add(txtTotalPag);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos de la Venta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Datos de la Compra", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(10, 11, 730, 190);
		getContentPane().add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del Proveedor", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBounds(22, 32, 290, 101);
		panel_3.add(panel_4);
		
		JLabel lblRuc = new JLabel("RUC :");
		lblRuc.setBounds(10, 62, 46, 14);
		panel_4.add(lblRuc);
		
		txtRucProv = new JTextField();
		txtRucProv.setColumns(10);
		txtRucProv.setBounds(100, 59, 117, 20);
		panel_4.add(txtRucProv);
		
		JButton btnbuscar = new JButton("New button");
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmProveedores p=new FrmProveedores();
				p.setVisible(true);
				p.setLocationRelativeTo(null);
			}
		});
		btnbuscar.setBounds(227, 30, 38, 23);
		panel_4.add(btnbuscar);
		
		JLabel lblRazonSocial = new JLabel("Razon Social :");
		lblRazonSocial.setBounds(10, 34, 80, 14);
		panel_4.add(lblRazonSocial);
		
		txtRazonSocialProv = new JTextField();
		txtRazonSocialProv.setColumns(10);
		txtRazonSocialProv.setBounds(100, 31, 117, 20);
		panel_4.add(txtRazonSocialProv);
		
		JLabel label_10 = new JLabel("Documento");
		label_10.setBounds(33, 140, 70, 14);
		panel_3.add(label_10);
		
		JLabel txtFe = new JLabel("Fecha :");
		txtFe.setBounds(33, 165, 46, 14);
		panel_3.add(txtFe);
		
		lblFecha = new JLabel("2018/11/21");
		lblFecha.setBounds(77, 165, 64, 14);
		panel_3.add(lblFecha);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos del Producto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBounds(345, 32, 346, 134);
		panel_3.add(panel_5);
		
		JLabel label_13 = new JLabel("Codigo");
		label_13.setBounds(10, 50, 46, 14);
		panel_5.add(label_13);
		
		txtCodigoProdu = new JTextField();
		txtCodigoProdu.setColumns(10);
		txtCodigoProdu.setBounds(65, 47, 86, 20);
		panel_5.add(txtCodigoProdu);
		
		JButton btnBuscar = new JButton("New button");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmProductos p = new FrmProductos();
				p.setVisible(true);
				p.setLocationRelativeTo(null);
			}
		});
		btnBuscar.setBounds(161, 46, 35, 23);
		panel_5.add(btnBuscar);
		
		JLabel label_14 = new JLabel("Nombre");
		label_14.setBounds(10, 96, 46, 14);
		panel_5.add(label_14);
		
		txtNombreProdu = new JTextField();
		txtNombreProdu.setColumns(10);
		txtNombreProdu.setBounds(65, 93, 131, 20);
		panel_5.add(txtNombreProdu);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(231, 50, 46, 14);
		panel_5.add(lblCantidad);
		
		txtstockPro = new JTextField();
		txtstockPro.setColumns(10);
		txtstockPro.setBounds(290, 47, 46, 20);
		panel_5.add(txtstockPro);
		
		JLabel label_16 = new JLabel("Precio");
		label_16.setBounds(231, 96, 46, 14);
		panel_5.add(label_16);
		
		txtPrecioProdu = new JTextField();
		txtPrecioProdu.setColumns(10);
		txtPrecioProdu.setBounds(276, 93, 46, 20);
		panel_5.add(txtPrecioProdu);
		
		JLabel lblNroDeCompra = new JLabel("Nro\u00BA de Compra :");
		lblNroDeCompra.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNroDeCompra.setBounds(185, 162, 105, 20);
		panel_3.add(lblNroDeCompra);
		
		lblNrCompra = new JLabel("1");
		lblNrCompra.setHorizontalAlignment(SwingConstants.CENTER);
		lblNrCompra.setFont(new Font("Segoe UI Historic", Font.BOLD, 16));
		lblNrCompra.setBounds(272, 162, 40, 20);
		panel_3.add(lblNrCompra);
		
		cboDocumento = new JComboBox();
		cboDocumento.setModel(new DefaultComboBoxModel(new String[] {"Boleta", "Factura"}));
		cboDocumento.setBounds(116, 137, 121, 20);
		panel_3.add(cboDocumento);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 258, 551, 134);
		getContentPane().add(scrollPane);
		
		tblCompra = new JTable();
		tblCompra.setModel(modelo);
		modelo.addColumn("Nro Venta");
		modelo.addColumn("Id Producto");
		modelo.addColumn("Precio Unitario");
		modelo.addColumn("Cantidad");
		
		scrollPane.setViewportView(tblCompra);
		
		JButton btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				grabarCompra();
			}
		});
		btnGrabar.setBounds(581, 422, 89, 23);
		getContentPane().add(btnGrabar);
		
		txtidProveeee = new JTextField();
		txtidProveeee.setBounds(171, 0, 86, 20);
		getContentPane().add(txtidProveeee);
		txtidProveeee.setColumns(10);
		
		
		MostrarNumero();
		mostrarFecha();
	}
	ArrayList<DetalleCompra> carrito = new ArrayList<>();

	double total = 0; // <----------------VARIABLE GLOBAL PARA EL TOTAL DE LA 	 VENTA
	private JLabel lblNrCompra;
	private JComboBox cboDocumento;
	private JLabel lblFecha;
	private JTable tblCompra;
	public static JTextField txtidProveeee;
					

	void mostrarFecha() {
		Date fecha = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		lblFecha.setText(sdf.format(fecha));
	}

	void MostrarNumero() {
		// obtener el ultimo numero de boleta(venta) incrementando en 1
		int numero = new GestionCompra().ObtenerNumero();
		lblNrCompra.setText(Integer.toString(numero));

	}

	void agregarProducto() {
		// VARIABLES
		int Nro_com;
		int id_prod, CantxUnidad;
		double precioUnidad;

		// DETALLE VENTA
		Nro_com = leerNumeroCompra();
		id_prod = leerIdProducto();
		CantxUnidad = leerCantidad();
		precioUnidad = leerPrecioProducto();
		total += (CantxUnidad * precioUnidad);

		// PROCESO
		DetalleCompra dv = new DetalleCompra();
		dv.setNroCompra(Nro_com);
		dv.setIdprodu(id_prod);
		dv.setCantidad(CantxUnidad);
		dv.setPrecio(precioUnidad);
		carrito.add(dv);

		// SALIDA
		Object datos[] = { Nro_com, id_prod, precioUnidad, CantxUnidad, precioUnidad * CantxUnidad };
		modelo.addRow(datos);
		txtTotalPag.setText(total + "");
	}

	void grabarCompra() {
		int Nro_com,idProve;
		String doc_com, fech_com;

		Nro_com = leerNumeroCompra();
		doc_com = leerTipoDocumento();
		fech_com = leerFecha();
		idProve = leerIdproveedor();
		Compra reg=new Compra();
		reg.setNroCompra(Nro_com);
		reg.setDocumentocom(doc_com);
		reg.setFechaCom(fech_com);
		reg.setIdProveCom(idProve);
		
		
		GestionCompra gv = new GestionCompra();

		int ok = gv.realizaCompra(reg, carrito);

		if (ok == 0) {
			JOptionPane.showMessageDialog(null, "Error al Grabar la Compra");
		} else {
			JOptionPane.showMessageDialog(null, "Compra Exitosa");
		}
	}

	int leerNumeroCompra(){
		return Integer.parseInt(lblNrCompra.getText());
	}

	String leerTipoDocumento() {
		return String.valueOf(cboDocumento.getSelectedItem());
	}

	String leerFecha() {
		return lblFecha.getText();
	}

	int leerIdproveedor() {
		return Integer.parseInt(txtidProveeee.getText());
	}

	

	// METODOS CON PARAMETROS PARA DETALLE DE VENTAS
	int leerIdProducto() {
		return Integer.parseInt(txtCodigoProdu.getText());
	}

	String leerNombre() {
		return txtNombreProdu.getText();
	}

	int leerStockProducto() {
		return Integer.parseInt(txtstockPro.getText());
	}

	double leerPrecioProducto() {
		return Double.parseDouble(txtPrecioProdu.getText());
	}

	int leerCantidad() {
		return Integer.parseInt(txtCantiCompra.getText());
	}
}
