package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import mantenimientos.GestionCategorias;
import model.Categoria;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class IntCategoria extends JInternalFrame {
	private JTextField txtBusqueda;
	private JTable tblCategoria;
	private JTextField txtIdCategoria;
	private JTextField txtDescripcion;
	private JLabel lblGuardar_1;
	private JLabel lblModificar_1;
	private JLabel lblSalir_1;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnSalir;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntCategoria frame = new IntCategoria();
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
	DefaultTableModel model=new DefaultTableModel( );
	private JPanel panel_1;
	private JTextField txtOculto;
	
	public IntCategoria() {
		setBorder(null);
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameActivated(InternalFrameEvent arg0) {
				listar();
			}
		});

		
		setTitle("Categorias");
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 621, 392);
		getContentPane().setLayout(null);
		
		JTabbedPane panelPrincipal = new JTabbedPane(JTabbedPane.TOP);
		panelPrincipal.setBounds(10, 35, 544, 307);
		getContentPane().add(panelPrincipal);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panelPrincipal.addTab("Buscar", new ImageIcon(FrmCategorias.class.getResource("/img/buscar.png")), panel, null);
		panelPrincipal.setForegroundAt(0, Color.BLACK);
		panelPrincipal.setBackgroundAt(0, Color.LIGHT_GRAY);
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		
		JLabel lblBusqueda = new JLabel("Busqueda");
		lblBusqueda.setFont(new Font("Candara Light", Font.BOLD | Font.ITALIC, 15));
		lblBusqueda.setForeground(new Color(255, 255, 255));
		lblBusqueda.setBounds(10, 11, 69, 14);
		panel.add(lblBusqueda);
		
		txtBusqueda = new JTextField();
		txtBusqueda.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				Busquedad();
				
			}
		});
		txtBusqueda.setCaretColor(new Color(255, 255, 255));
		txtBusqueda.setForeground(Color.BLACK);
		txtBusqueda.setBorder(null);
		txtBusqueda.setBackground(Color.WHITE);
		txtBusqueda.setBounds(14, 36, 292, 20);
		panel.add(txtBusqueda);
		txtBusqueda.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 93, 292, 157);
		panel.add(scrollPane);
		
		tblCategoria = new JTable();
		tblCategoria.setCellSelectionEnabled(true);
		tblCategoria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					int fila1 = tblCategoria.getSelectedRow();
					txtIdCategoria.setText(tblCategoria.getValueAt(fila1, 0).toString());
					
					
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println("error nos euqe pasa "+e2.getMessage());
					
				}
				
				
				btnModificar.setEnabled(true);
				btnEliminar.setEnabled(true);
				
			}
		});
		
		tblCategoria.setFont(new Font("Candara Light", Font.BOLD | Font.ITALIC, 13));
		tblCategoria.setForeground(new Color(240, 240, 240));
		tblCategoria.setModel(model);
		model.addColumn("Codigo");
		model.addColumn("Descripcion");
		tblCategoria.addKeyListener(new KeyAdapter() {
			/*-------------------------> EVENTO BUSCAR CATEGORIAS <------------------------*/
			@Override
			public void keyReleased(KeyEvent e) {
				
				
				Busquedad();
			
			}
			/*------------------------------------------------------------------------------*/
		});
		
		scrollPane.setViewportView(tblCategoria);
		tblCategoria.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		tblCategoria.setGridColor(new Color(33, 45, 62));
		tblCategoria.setBackground(new Color(33, 45, 62));
		
		
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 57, 296, 2);
		panel.add(separator);
		
		btnAgregar = new JButton("");
	
	
		
		
		btnAgregar.setBounds(396, 11, 33, 30);
		panel.add(btnAgregar);
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelPrincipal.removeAll();

				panelPrincipal.add("Nuevo ", panel_1);

				
				/*cuando le haces click al tblCategoria y presiona el btn Nuevo se vaceara el txtidcateogira porque
				 * sino se almacenara el dato que le hiciste click */
				txtIdCategoria.setText("");
				
			}
		});
		btnAgregar.setRolloverSelectedIcon(new ImageIcon(FrmCategorias.class.getResource("/img/nuevo.png")));
		btnAgregar.setRolloverIcon(new ImageIcon(FrmCategorias.class.getResource("/img/nuevo.png")));
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregar.setContentAreaFilled(false);
		btnAgregar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAgregar.setBorderPainted(false);
		btnAgregar.setIcon(new ImageIcon(FrmCategorias.class.getResource("/img/nuevo - of.png")));
		
		btnEliminar = new JButton("");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtIdCategoria.getText().isEmpty()) {
					
				}
				else{eliminar();

				}
				
			}
		});
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(417, 167, 33, 30);
		panel.add(btnEliminar);
		btnEliminar.setRolloverSelectedIcon(new ImageIcon(FrmCategorias.class.getResource("/img/save.png")));
		btnEliminar.setRolloverIcon(new ImageIcon(FrmCategorias.class.getResource("/img/save.png")));
		btnEliminar.setBorder(null);
		btnEliminar.setContentAreaFilled(false);
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setBorderPainted(false);
		btnEliminar.setIcon(new ImageIcon(FrmCategorias.class.getResource("/img/save - of.png")));
		
		btnModificar = new JButton("");
		btnModificar.setEnabled(false);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPrincipal.removeAll();

				panelPrincipal.add("Modificar", panel_1);

				txtIdCategoria.setEditable(false);
				txtDescripcion.setText("");
				
			}
		});
		btnModificar.setBounds(417, 103, 33, 30);
		panel.add(btnModificar);
		btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificar.setBorder(null);
		btnModificar.setContentAreaFilled(false);
		btnModificar.setBorderPainted(false);
		btnModificar.setRolloverSelectedIcon(new ImageIcon(FrmCategorias.class.getResource("/img/modificar.png")));
		btnModificar.setRolloverIcon(new ImageIcon(FrmCategorias.class.getResource("/img/modificar.png")));
		btnModificar.setIcon(new ImageIcon(FrmCategorias.class.getResource("/img/modificar - of.png")));
		
		lblModificar_1 = new JLabel("Modificar");
		lblModificar_1.setBounds(411, 132, 63, 14);
		panel.add(lblModificar_1);
		lblModificar_1.setForeground(Color.GRAY);
		
		lblGuardar_1 = new JLabel("eliminar");
		lblGuardar_1.setBounds(417, 195, 46, 14);
		panel.add(lblGuardar_1);
		lblGuardar_1.setForeground(Color.GRAY);
		
		btnSalir = new JButton("");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setBounds(496, 226, 33, 30);
		panel.add(btnSalir);
		btnSalir.setBorder(null);
		btnSalir.setBorderPainted(false);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalir.setIcon(new ImageIcon(FrmCategorias.class.getResource("/img/salir - of.png")));
		btnSalir.setRolloverIcon(new ImageIcon(FrmCategorias.class.getResource("/img/salir.png")));
		btnSalir.setRolloverSelectedIcon(new ImageIcon(FrmCategorias.class.getResource("/img/salir.png")));
		
		lblSalir_1 = new JLabel("  Salir");
		lblSalir_1.setBounds(457, 236, 46, 14);
		panel.add(lblSalir_1);
		lblSalir_1.setForeground(Color.GRAY);
		
		panel_1 = new JPanel();
		panelPrincipal.addTab("Nuevo / Modificar", new ImageIcon(FrmCategorias.class.getResource("/img/nuevo_2.png")), panel_1, null);
		panelPrincipal.setBackgroundAt(1, Color.LIGHT_GRAY);
		panelPrincipal.setForegroundAt(1, Color.BLACK);
        panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);
		
		JLabel lblDatosDeCategoria = new JLabel("Datos de Categoria");
		lblDatosDeCategoria.setFont(new Font("Candara Light", Font.BOLD | Font.ITALIC, 15));
		lblDatosDeCategoria.setForeground(new Color(255, 255, 255));
		lblDatosDeCategoria.setBounds(10, 11, 136, 14);
		panel_1.add(lblDatosDeCategoria);
		
		JLabel lblIdCategoria = new JLabel("ID Categoria");
		lblIdCategoria.setFont(new Font("Verdana", Font.ITALIC, 11));
		lblIdCategoria.setBounds(23, 49, 73, 14);
		lblIdCategoria.setForeground(Color.BLACK);
		panel_1.add(lblIdCategoria);
		
		JLabel lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setFont(new Font("Verdana", Font.ITALIC, 11));
		lblDescripcin.setBounds(23, 89, 73, 14);
		lblDescripcin.setForeground(Color.BLACK);
		panel_1.add(lblDescripcin);
		
		txtIdCategoria = new JTextField();
		txtIdCategoria.setEnabled(false);
		txtIdCategoria.setFont(new Font("Verdana", Font.ITALIC, 11));
		txtIdCategoria.setCaretColor(Color.LIGHT_GRAY);
		txtIdCategoria.setBorder(null);
		txtIdCategoria.setBackground(Color.WHITE);
		txtIdCategoria.setForeground(Color.BLACK);
		txtIdCategoria.setBounds(111, 42, 112, 20);
		
		panel_1.add(txtIdCategoria);
		txtIdCategoria.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setCaretColor(Color.LIGHT_GRAY);
		txtDescripcion.setBorder(null);
		txtDescripcion.setFont(new Font("Verdana", Font.ITALIC, 11));
		txtDescripcion.setColumns(10);
		txtDescripcion.setForeground(Color.BLACK);
		txtDescripcion.setBounds(111, 82, 112, 20);
		txtDescripcion.setBackground(Color.WHITE);
		panel_1.add(txtDescripcion);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(106, 65, 119, 2);
		panel_1.add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(106, 105, 119, 2);
		panel_1.add(separator_2);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*<-----------------SIRVE PARA DIFERENCIA EL ACTUALIZAR Y EL REGISTRAR :v  ---------->*/
				
				panelPrincipal.removeAll();
				panelPrincipal.add("Buscar", panel);
				panelPrincipal.add("Nuevo / Modificar", panel_1);
				
				
				if (txtIdCategoria.getText().isEmpty()) {
					registrarcat();// <----------------- ginion
				}
				else {
					
					actualizar();
				}
			}
				
				
			
		});
		btnAceptar.setBounds(295, 46, 89, 23);
		panel_1.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPrincipal.removeAll();
				panelPrincipal.add("Buscar", panel);
				panelPrincipal.add("Nuevo / Modificar", panel_1);

				
				
				
			}
		});
		btnCancelar.setBounds(295, 86, 89, 23);
		panel_1.add(btnCancelar);
		
		txtOculto = new JTextField();
		txtOculto.setEditable(false);
		txtOculto.setBounds(132, 195, 86, 20);
		panel_1.add(txtOculto);
		txtOculto.setColumns(10);

		
	}
	
	void listar(){
	    
	    GestionCategorias gc=new GestionCategorias();
	    ArrayList<Categoria>lista=gc.listar();

	   
	    for(Categoria cl:lista) {
			Object datos[]= {cl.getCodigo(),cl.getDescripcion()};
			model.addRow(datos);
			
		}
		
	}
	
	void Busquedad(){

		
		String Cat=txtBusqueda.getText();
		
GestionCategorias gc=new GestionCategorias();
		model.getDataVector().removeAllElements();
		
	
		ArrayList<Categoria>list=gc.BusquedaCat(Cat);
		for(Categoria cl:list) {
			Object datos[]= {cl.getCodigo(),cl.getDescripcion()};
			model.addRow(datos);
			
		}
};

	void registrarcat(){
		
		String codigo,descrip;
		
		codigo=txtIdCategoria.getText();
		descrip=txtDescripcion.getText();
		
		Categoria c=new Categoria();
		
		
		c.setCodigo(codigo);
		c.setDescripcion(descrip);
		
		GestionCategorias ges=new GestionCategorias();
		
		int ok=ges.agregar(c);
		
		if(ok==0){
		
		}
		else{
			JOptionPane.showMessageDialog(null, "Registro Exitoso");
			model.setRowCount(0);
			listar();
		}
	}
	
	void actualizar() {

		String codigo,nombre;
		codigo=txtIdCategoria.getText();
		nombre=txtDescripcion.getText();

		
		

		Categoria c = new Categoria();
	
		c.setCodigo(codigo);
		c.setDescripcion(nombre);

		GestionCategorias gu=new GestionCategorias();

		int ok = gu.actualizar(c);

		if (ok == 0) {
		
		} else {
			JOptionPane.showMessageDialog(null, ok + "Registro actulizado");
			model.setRowCount(0);
			listar();
		}
	}

	void eliminar() {

		String dni;

		dni = txtIdCategoria.getText();

		GestionCategorias gu=new GestionCategorias();

		int ok = gu.eliminar(dni);

		if (ok == 0) {
			
		} else {
			JOptionPane.showMessageDialog(null, ok + " Registro eliminado");
			model.setRowCount(0); // <--------- LIMPIA LA TABLA
			listar();
		}
	}
	
	}




