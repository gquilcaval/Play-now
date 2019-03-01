package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import mantenimientos.GestionEmpledos;
import model.Clientes;
import model.Empleados;
import model.TipoEmpleado;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.JComboBox;


@SuppressWarnings("serial")
public class FrmLogin extends JFrame {

	private JPanel Jpanel_menu_login;
	private JPasswordField txtClaveUsu;
	public static JTextField txtIngUsu;
	private JButton btnIniciarSecin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin frame = new FrmLogin();
					frame.setVisible(true);

					frame.setLocationRelativeTo(null);// <----------------------
														// CENTRANDO EL FRAME
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmLogin() {

		

		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 388);

		Jpanel_menu_login = new JPanel();
		Jpanel_menu_login.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Jpanel_menu_login);
		Jpanel_menu_login.setLayout(null);

		JPanel jPanel_banner = new JPanel();
		jPanel_banner.setBounds(0, 0, 317, 388);
		Jpanel_menu_login.add(jPanel_banner);
		jPanel_banner.setLayout(null);

		JLabel lblBanner = new JLabel("");
		lblBanner.setBounds(0, 0, 317, 388);
		jPanel_banner.add(lblBanner);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 0, 306, 21);
		jPanel_banner.add(menuBar);
		
		JMenu mnEnter = new JMenu("Enter");
		menuBar.add(mnEnter);
		
		JMenuItem mntmPressEnter = new JMenuItem("Press Enter");
		mntmPressEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				validarLogin();
			}
		});
		mntmPressEnter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0));
		mnEnter.add(mntmPressEnter);

		/*-----------------------> FUNCIONALIDAD DEL GIF (BANNER)<----------------------------*/

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent ev) {
				Image imgFondo = new ImageIcon(getClass().getResource("/img/ps-symbols.gif")).getImage();
				lblBanner.setIcon(new ImageIcon(imgFondo.getScaledInstance(317, 388, Image.SCALE_DEFAULT)));
			}
		});
		/*-------------------------------------------------------------------------------*/

		JPanel Jpanel_Login = new JPanel();
		Jpanel_Login.setBackground(new Color(33, 45, 62));
		Jpanel_Login.setBounds(309, 31, 326, 357);
		Jpanel_menu_login.add(Jpanel_Login);
		Jpanel_Login.setLayout(null);

		JLabel lblIniciarSesion = new JLabel("Iniciar Seci\u00F3n");
		lblIniciarSesion.setBounds(56, 36, 212, 35);
		lblIniciarSesion.setFont(new Font("Candara Light", Font.PLAIN, 34));
		lblIniciarSesion.setForeground(Color.LIGHT_GRAY);
		lblIniciarSesion.setBackground(Color.WHITE);
		Jpanel_Login.add(lblIniciarSesion);

		JLabel lblUser = new JLabel("New label");
		lblUser.setBounds(46, 146, 24, 25);
		lblUser.setForeground(Color.BLACK);
		lblUser.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/user.png")));
		Jpanel_Login.add(lblUser);

		JLabel lblPadlock = new JLabel("");
		lblPadlock.setBounds(48, 199, 24, 34);
		lblPadlock.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/if_Padlock-RAD_2834766.png")));
		Jpanel_Login.add(lblPadlock);

		JSeparator separator = new JSeparator();
		separator.setAlignmentY(Component.TOP_ALIGNMENT);
		separator.setForeground(new Color(121, 121, 155));
		separator.setBounds(98, 168, 125, 2);
		separator.setBackground(new Color(18, 30, 49));
		Jpanel_Login.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(121, 121, 155));
		separator_1.setBackground(new Color(18, 30, 49));
		separator_1.setBounds(98, 227, 125, 2);
		Jpanel_Login.add(separator_1);

		txtClaveUsu = new JPasswordField();
		txtClaveUsu.setCaretColor(Color.GRAY);
		txtClaveUsu.setBackground(new Color(33, 45, 62));
		txtClaveUsu.setBounds(105, 209, 96, 17);
		txtClaveUsu.setText("Ingrese Clave");
		txtClaveUsu.setHorizontalAlignment(SwingConstants.CENTER);
		txtClaveUsu.setForeground(Color.GRAY);
		txtClaveUsu.setFont(new Font("Verdana", Font.ITALIC, 11));
		txtClaveUsu.setEchoChar((char) 0);// <--------- QUITA LA OPCION DEL *
		txtClaveUsu.setCaretPosition(0);
		txtClaveUsu.setBorder(null);
		txtClaveUsu.requestFocus();// <---------- ENFOCA EL TEXFIELD PARA
									// FUNCIONALIDAD DEL SETCARETPOSITION

		Jpanel_Login.add(txtClaveUsu);

		txtIngUsu = new JTextField();
		txtIngUsu.setHorizontalAlignment(SwingConstants.CENTER);
		txtIngUsu.setCaretColor(Color.GRAY);
		txtIngUsu.setAlignmentY(Component.TOP_ALIGNMENT);
		txtIngUsu.setBackground(new Color(33, 45, 62));
		txtIngUsu.setBounds(105, 150, 96, 17);
		txtIngUsu.setText("Ingrese Usuario");
		txtIngUsu.setForeground(Color.GRAY);
		txtIngUsu.setFont(new Font("Verdana", Font.ITALIC, 11));
		txtIngUsu.setColumns(10);
		txtIngUsu.setBorder(null);
		txtIngUsu.requestFocus();// <---------- ENFOCA EL TEXFIELD PARA
									// FUNCIONALIDAD DEL SETCARETPOSITION
		txtIngUsu.setCaretPosition(0);// <---------- COLOCA EL CURSOR AL
										// COMIENZO
		Jpanel_Login.add(txtIngUsu);

		btnIniciarSecin = new JButton("INICIAR SECI\u00D3N");
		
		btnIniciarSecin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				validarLogin();
			}
		});

		btnIniciarSecin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIniciarSecin.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
		btnIniciarSecin.setForeground(Color.WHITE);
		btnIniciarSecin.setBackground(new Color(51, 51, 51));
		btnIniciarSecin.setBorder(null);
		btnIniciarSecin.setBounds(101, 298, 125, 23);
		btnIniciarSecin.setBorderPainted(false);
		btnIniciarSecin.setContentAreaFilled(false);
		btnIniciarSecin.setOpaque(true);
		btnIniciarSecin.setEnabled(false);// DESABILITANDO JBUTON

		Jpanel_Login.add(btnIniciarSecin);

		JPanel jPanel_Barra = new JPanel();
		jPanel_Barra.setBackground(new Color(33, 45, 62));
		jPanel_Barra.setBounds(309, 0, 326, 32);
		Jpanel_menu_login.add(jPanel_Barra);
		jPanel_Barra.setLayout(null);

		JLabel lblCerrar = new JLabel("");
		lblCerrar.setBackground(new Color(51, 51, 51));
		lblCerrar.setBounds(292, 4, 15, 17);
		jPanel_Barra.add(lblCerrar);
		lblCerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCerrar.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/close.png")));

		/*-----------------------> FUNCIONALIDAD CERRAR FRAME  CON OPCIONES <----------------------------*/

		lblCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				int dialog = JOptionPane.YES_NO_OPTION;
				int result = JOptionPane.showConfirmDialog(null, "Desea salir del Login ?", "Salir", dialog);
				if (result == 0) {
					System.exit(0);
				}
			}
		});

		/*-------------------------------------------------------------------------------*/

		/*-----------------------> FUNCIONALIDAD  TECLA USUARIO <----------------------------*/

		/*----------> FUNCIONALIDAD  AL SOLTAR LA TECLA  <------------*/
		txtIngUsu.addKeyListener(new KeyAdapter() {

			public void keyReleased(KeyEvent e) {

				validacionUsuario();
				if (txtIngUsu.getText().equals("")) {

					txtIngUsu.setText("Ingrese Usuario");
					txtIngUsu.setCaretPosition(0);// <---------- COLOCA EL
													// CURSOR AL COMIENZO
					txtIngUsu.setForeground(Color.GRAY);
					txtIngUsu.setFont(new Font("Verdana", Font.ITALIC, 11));
				}

			}

			/*----------> FUNCIONALIDAD  AL PULSAR LA TECLA  <------------*/
			public void keyPressed(KeyEvent e) {
				if (txtIngUsu.getText().equals("Ingrese Usuario")) {
					txtIngUsu.setForeground(Color.LIGHT_GRAY);
					txtIngUsu.setText("");
					txtIngUsu.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 14));
				}

			}
		});

		/*-------------------------------------------------------------------------------------*/

		/*-----------------------> FUNCIONALIDAD  TECLA CLAVE <----------------------------*/

		txtClaveUsu.addKeyListener(new KeyAdapter() {

			/*----------> FUNCIONALIDAD  AL SOLTAR LA TECLA  <------------*/
			public void keyReleased(KeyEvent e) {
				if (txtClaveUsu.getText().equals("")) {
					txtClaveUsu.setEchoChar((char) 0);

					txtClaveUsu.setText("Ingrese Clave");
					txtClaveUsu.setCaretPosition(0);// <---------- COLOCA EL
													// CURSOR AL COMIENZO
					txtClaveUsu.setForeground(Color.GRAY);
					txtClaveUsu.setFont(new Font("Verdana", Font.ITALIC, 11));

				}

			}

			/*----------> FUNCIONALIDAD  AL PULSAR LA TECLA  <------------*/
			public void keyPressed(KeyEvent e) {
				if (txtClaveUsu.getText().equals("Ingrese Clave")) {
					txtClaveUsu.setEchoChar('*');
					txtClaveUsu.setText("");
					txtClaveUsu.setForeground(Color.LIGHT_GRAY);
					txtClaveUsu.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 14));
				}

			}
		});

		llenarCombo();
		
	}

	/*----------> METODO PARA HABILITAR/DESABILITAR JBUTON INICIAR SECION------------*/

	void validacionUsuario() {

		if (txtIngUsu.getText().isEmpty()) {
			btnIniciarSecin.setEnabled(false);
			btnIniciarSecin.setBackground(new Color(51, 51, 51));
			btnIniciarSecin.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));

		} else {

			btnIniciarSecin.setEnabled(true);
			btnIniciarSecin.setBackground(SystemColor.windowBorder);
			btnIniciarSecin.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));

		}

	}
/*-------------------------------------------------------------------------------------*/
	
	
	//LLENAR CBOTIPOUSUARIO
		void llenarCombo(){
			GestionEmpledos ge=new GestionEmpledos();
			ArrayList<TipoEmpleado>lista= ge.tipo();
			for (TipoEmpleado te : lista) {
				
			}
		}
	
	
	
	/*//RESTRICCION DE USUARIO DEPENDIENDO EL TIPO
		void restriccionDeUsuario(){
			if(cboTipoEmpleado.getSelectedItem().equals("Administrador")){
				FrmMenuPrincipal p = new FrmMenuPrincipal();
				p.setVisible(true);
				p.setLocationRelativeTo(null);
				dispose();
			}else{
				if(cboTipoEmpleado.getSelectedItem().equals("Vendedor")){
					FrmMenuPrincipal p = new FrmMenuPrincipal();
					p.setVisible(true);
					p.mnAlmacen.setEnabled(false);
					p.mnMantenimiento.setEnabled(false);
					p.mnReportes.setEnabled(false);
					p.mnClientes.setEnabled(false);
					p.mnCompras.setEnabled(false);
					p.setLocationRelativeTo(null);
					dispose();
				}
			}
		}*/
	@SuppressWarnings("deprecation")
	void validarLogin() {
		String usu,psw;
		
		
		usu = txtIngUsu.getText();
		psw = txtClaveUsu.getText();
		
		GestionEmpledos emp = new GestionEmpledos();
		Empleados e = emp.ValidaAcceso2(usu, psw);
		
		
	
		if (e == null) {

			JOptionPane.showMessageDialog(null, "algo incorrecto");

		} else {
			JOptionPane.showMessageDialog(null, " Bienvenido " + e.getNom_emp() + "  " + e.getApe_pat_emp());
			FrmMenuPrincipal p = new FrmMenuPrincipal();
			p.lblUsuario.setText(e.getNom_emp()+" "+e.getApe_pat_emp());
			//METODO PARA VALIDAR RESTRICCION DE GUIS
			if (e.getId_tip_emp().equals("1")) {
				
				p.setVisible(true);
				p.setLocationRelativeTo(null);
				p.lblCargo.setText("Administrador");
				p.lblUsuarioIcon.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/user2.png")));
				p.lblUser2.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/user2.png")));
				dispose();
			}
			
			if (e.getId_tip_emp().equals("2")) {
		
				p.setVisible(true);
				p.lblLogistica.setEnabled(false);
				p.lblCompras.setEnabled(false);
				p.lblMantenimiento.setEnabled(false);
				p.lblReporte.setEnabled(false);
				
				p.setLocationRelativeTo(null);
				p.lblCargo.setText("Vendedor");
				p.lblUsuarioIcon.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/vendedor.png")));
				p.lblUser2.setIcon(new ImageIcon(FrmLogin.class.getResource("/img/vendedor.png")));
				dispose();
			}
		}	}
}
