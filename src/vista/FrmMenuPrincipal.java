package vista;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import hilos.Hilo_Tiempo;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.PUBLIC_MEMBER;

import AppPackage.AnimationClass;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Cursor;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.TextAttribute;
import java.net.URL;
import java.util.Map;

import javax.swing.border.TitledBorder;
import javax.swing.plaf.IconUIResource;
import javax.swing.text.StyledEditorKit.UnderlineAction;
import javax.swing.JButton;

public class FrmMenuPrincipal extends JFrame {

	private JPanel contentPane;
	public static JLabel lblFecha;
	public static JLabel lblCargo;
	private JLabel label;
	private JPanel panel;
	public static JLabel lblUsuario;
	private JPanel jpanelMenu;
	private JLabel lblGenerarVentas;
	private JLabel lblVentas;
	public static JLabel lblLogistica;
	private JLabel lblHome;
	private JLabel lblRegistrarProductos;
	private JLabel lblRegistrarClientes;
	private JPanel jPanelBody;
	private JDesktopPane dktBody;
	public static JLabel lblUsuarioIcon;
	public static JLabel lblUser2;
	private JLabel lblConectado;
	private JLabel lblConectado_1;
	private JLabel lblGenerarCompra;
	public static JLabel lblCompras;
	private JLabel lblRegistrarCategoria;
	public static JLabel lblReporte;
	public static JLabel lblMantenimiento;
	private JLabel lblRegistrarProveedor;
	private JLabel lblReporteVenta;
	private JLabel lblEmpleado;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMenuPrincipal frame = new FrmMenuPrincipal();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public static JPanel jpanelHeader;
	private JLabel lblFondo;
	private JLabel lblBienvenido;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;

	public FrmMenuPrincipal() {
	
	
		
		setBackground(new Color(237, 240, 247));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				dktBody.removeAll();
				dktBody.repaint();
				IntMenuInicio p=new IntMenuInicio();
				dktBody.add(p);
		
				
				
				try {
					p.setMaximum(true);
					p.setUI(null);       //<------------ QUITAR BORDE DE UN INTERNAL FRAME 
					p.show();
				} catch (Exception ex) {
					// TODO: handle exception
				}
			
			
			}
		});
	
		
		
		
		
		
		setTitle("Play Now!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1155, 757);
		
		/*---------------------------------------------------*/
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
				JPanel PanelLogo = new JPanel();
				PanelLogo.setBackground(Color.WHITE);
				PanelLogo.setBounds(0, 0, 278, 81);
				contentPane.add(PanelLogo);
				PanelLogo.setLayout(null);
				
				label = new JLabel("");
				label.setBackground(Color.WHITE);
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setHorizontalTextPosition(SwingConstants.CENTER);
				label.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/logo_PlayNow2-hz.png")));
				label.setBounds(0, 0, 278, 81);
				PanelLogo.add(label);
				
				panel = new JPanel();
				panel.setBackground(new Color(34, 43, 54));
				panel.setBounds(0, 80, 279, 53);
				contentPane.add(panel);
				panel.setLayout(null);
				
				lblUsuario = new JLabel("");
				lblUsuario.setForeground(Color.WHITE);
				lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
				lblUsuario.setBounds(170, 9, 98, 14);
				panel.add(lblUsuario);
				
				lblUsuarioIcon = new JLabel("");
				lblUsuarioIcon.setBounds(65, 4, 56, 47);
				panel.add(lblUsuarioIcon);
				
				lblConectado = new JLabel("");
				lblConectado.setHorizontalAlignment(SwingConstants.LEFT);
				lblConectado.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/online.png")));
				lblConectado.setBounds(181, 34, 21, 14);
				panel.add(lblConectado);
				
				lblConectado_1 = new JLabel("Conectado");
				lblConectado_1.setBounds(203, 34, 65, 14);
				lblConectado_1.setForeground(new Color(255, 255, 255));
				panel.add(lblConectado_1);
				
				
			
				
				jpanelMenu = new JPanel();
				jpanelMenu.setBounds(0, 133, 279, 585);
				jpanelMenu.setBackground(new Color(33, 47, 61));
				contentPane.add(jpanelMenu);
				jpanelMenu.setLayout(null);
				
				lblVentas = new JLabel("Ventas");
				
				lblVentas.setBorder(null);
				
				lblVentas.setHorizontalAlignment(SwingConstants.LEFT);
				
				lblVentas.addMouseListener(new MouseAdapter() {
					
					@Override
					public void mouseClicked(MouseEvent e) {
						AnimationClass animacion =new AnimationClass();
						animacion.jLabelXRight(50, 165, 2,1, lblGenerarVentas);
						animacion.jLabelXRight(50, 165, 2,1, lblRegistrarClientes);
						
						AnimationClass animacionOcul =new AnimationClass();
						animacionOcul.jLabelXLeft(165, 50, 2,1, lblGenerarVentas);
						animacionOcul.jLabelXLeft(165,50, 2,1, lblRegistrarClientes);
						
						AnimationClass animationOculLogistica=new AnimationClass();
						animationOculLogistica.jLabelXLeft(165,50, 2,1, lblRegistrarProductos);
						animationOculLogistica.jLabelXLeft(165,50, 2,1, lblRegistrarCategoria);
						
						AnimationClass animationOculCompras=new AnimationClass();
						animationOculCompras.jLabelXLeft(165,50, 2,1, lblGenerarCompra);
						animationOculCompras.jLabelXLeft(165,50, 2,1, lblRegistrarProveedor);
						
						AnimationClass animationOculRepVent=new AnimationClass();
						animationOculRepVent.jLabelXLeft(165,50, 2,1, lblReporteVenta);
						
						AnimationClass animationOculMante=new AnimationClass();
						animationOculMante.jLabelXLeft(165, 50, 2, 1, lblEmpleado);
					}
					@Override
					public void mouseEntered(MouseEvent arg0) {
						lblVentas.setForeground(Color.white);
						
						}
						@Override
						public void mouseExited(MouseEvent e) {
							lblVentas.setForeground(new Color(137, 137, 127));
						
						}
				});
				lblVentas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblVentas.setForeground(new Color(137, 137, 127));
				lblVentas.setBackground(new Color(33, 47, 61));
				lblVentas.setOpaque(true);
				lblVentas.setHorizontalTextPosition(SwingConstants.LEFT);
				lblVentas.setBounds(50, 88, 115, 55);
				jpanelMenu.add(lblVentas);
				
				lblLogistica = new JLabel("Logistica");
				lblLogistica.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
				lblLogistica.addMouseListener(new MouseAdapter() {
					
					
					@Override
					public void mouseClicked(MouseEvent e) {
						if (lblLogistica.isEnabled()==false) {
							JOptionPane.showMessageDialog(null, "Acceso Restringido");
						}
						else{
							
							AnimationClass animation=new AnimationClass();
							animation.jLabelXRight(50, 165, 2, 1, lblRegistrarProductos);
							animation.jLabelXRight(50, 165, 2, 1, lblRegistrarCategoria);
							
							AnimationClass animationOculLogistica=new AnimationClass();
							animationOculLogistica.jLabelXLeft(165, 50, 2, 1, lblRegistrarProductos);
							animationOculLogistica.jLabelXLeft(165, 50, 2, 1, lblRegistrarCategoria);
							
							AnimationClass animacionOculVenta =new AnimationClass();
							animacionOculVenta.jLabelXLeft(165, 50, 2,1, lblGenerarVentas);
							animacionOculVenta.jLabelXLeft(165,50, 2,1, lblRegistrarClientes);
							
							AnimationClass animationOculCompras=new AnimationClass();
							animationOculCompras.jLabelXLeft(165, 50, 2, 1, lblGenerarCompra);
							animationOculCompras.jLabelXLeft(165, 50, 2, 1, lblRegistrarProveedor);
							
							AnimationClass animationOculRepVent=new AnimationClass();
							animationOculRepVent.jLabelXLeft(165, 50, 2,1, lblReporteVenta);
							
							AnimationClass animationOculMante=new AnimationClass();
							animationOculMante.jLabelXLeft(165, 50, 2, 1, lblEmpleado);
						}
						
					}
					
					@Override
					public void mouseEntered(MouseEvent arg0) {
						lblLogistica.setForeground(Color.white);
						
						}
						@Override
						public void mouseExited(MouseEvent e) {
							lblLogistica.setForeground(new Color(137, 137, 127));
						
						}
				});
			
				lblLogistica.setForeground(new Color(137, 137, 127));
				lblLogistica.setOpaque(true);
				lblLogistica.setBackground(new Color(33, 47, 61));
				lblLogistica.setHorizontalAlignment(SwingConstants.LEFT);
				lblLogistica.setBounds(50, 142, 115, 55);
				jpanelMenu.add(lblLogistica);
				
				lblHome = new JLabel("Home");
				lblHome.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						dktBody.removeAll();
						dktBody.repaint();
						IntMenuInicio p=new IntMenuInicio();
						dktBody.add(p);
						
						
						
						try {
							p.setMaximum(true);
							p.setUI(null);       //<------------ QUITAR BORDE DE UN INTERNAL FRAME 
		
							p.show();
						} catch (Exception ex) {
							// TODO: handle exception
						}
					}
					@Override
					public void mouseEntered(MouseEvent arg0) {
					lblHome.setForeground(Color.white);
					
					}
					@Override
					public void mouseExited(MouseEvent e) {
						lblHome.setForeground(new Color(137, 137, 127));
						
					}
				});
				lblHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblHome.setOpaque(true);
				lblHome.setHorizontalTextPosition(SwingConstants.CENTER);
				lblHome.setHorizontalAlignment(SwingConstants.LEFT);
				lblHome.setForeground(new Color(137, 137, 127));
				lblHome.setBackground(new Color(33, 47, 61));
				lblHome.setBounds(148, 0, 130, 59);
				jpanelMenu.add(lblHome);
				
				lblRegistrarProductos = new JLabel("Registrar Producto");
				lblRegistrarProductos.setFont(new Font("Serif", Font.PLAIN, 13));
				lblRegistrarProductos.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						dktBody.removeAll();
						dktBody.repaint();
						IntProducto p=new IntProducto();
						dktBody.add(p);
						
						
						
						try {
							p.setMaximum(true);
							p.setUI(null);       //<------------ QUITAR BORDE DE UN INTERNAL FRAME 
							p.show();
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					
					@Override
					public void mouseEntered(MouseEvent arg0) {
						lblRegistrarProductos.setForeground(Color.white);
					
					}
					@Override
					public void mouseExited(MouseEvent e) {
						lblRegistrarProductos.setForeground(new Color(137, 137, 127));
						
					}
					
				});
				lblRegistrarProductos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
				lblRegistrarProductos.setOpaque(true);
				lblRegistrarProductos.setHorizontalAlignment(SwingConstants.LEFT);
				lblRegistrarProductos.setForeground(new Color(137, 137, 127));
				lblRegistrarProductos.setBackground(new Color(33, 47, 61));
				lblRegistrarProductos.setBounds(50, 143, 111, 34);
				jpanelMenu.add(lblRegistrarProductos);
				
				lblCompras = new JLabel("Compras");
				lblCompras.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						if (lblCompras.isEnabled()==false) {
							JOptionPane.showMessageDialog(null, "Acceso Restringido");
						}
						else {
						
							AnimationClass animation=new AnimationClass();
							animation.jLabelXRight(50, 165, 2, 1, lblGenerarCompra);
							animation.jLabelXRight(50, 165, 2, 1, lblRegistrarProveedor);
							
							AnimationClass animationOculCompras=new AnimationClass();
							animationOculCompras.jLabelXLeft(165, 50, 2, 1, lblGenerarCompra);
							animationOculCompras.jLabelXLeft(165, 50,2, 1, lblRegistrarProveedor);
							
							AnimationClass animationOculLogistica=new AnimationClass();
							animationOculLogistica.jLabelXLeft(165, 50, 2, 1, lblRegistrarProductos);
							animationOculLogistica.jLabelXLeft(165, 50, 2, 1, lblRegistrarCategoria);
							
							AnimationClass animacionOculVenta =new AnimationClass();
							animacionOculVenta.jLabelXLeft(165, 50, 2, 1, lblGenerarVentas);
							animacionOculVenta.jLabelXLeft(165, 50, 2, 1, lblRegistrarClientes);
							
							AnimationClass animationOculRepVent=new AnimationClass();
							animationOculRepVent.jLabelXLeft(165, 50, 2, 1, lblReporteVenta);
							
							AnimationClass animationOculMante=new AnimationClass();
							animationOculMante.jLabelXLeft(165, 50, 2, 1, lblEmpleado);
						}
						
					}
					@Override
					public void mouseEntered(MouseEvent arg0) {
						lblCompras.setForeground(Color.white);
						
						}
						@Override
						public void mouseExited(MouseEvent e) {
							lblCompras.setForeground(new Color(137, 137, 127));
						
						}
				});
				lblCompras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblCompras.setOpaque(true);
				lblCompras.setHorizontalAlignment(SwingConstants.LEFT);
				lblCompras.setForeground(new Color(137, 137, 127));
				lblCompras.setBackground(new Color(33, 47, 61));
				lblCompras.setBounds(50, 197, 115, 55);
				jpanelMenu.add(lblCompras);
				
				lblGenerarCompra = new JLabel("Generar Compra");
				lblGenerarCompra.setFont(new Font("Serif", Font.PLAIN, 13));
				lblGenerarCompra.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dktBody.removeAll();
						dktBody.repaint();
						IntCompra p=new IntCompra();
						dktBody.add(p);
						
						
						
						try {
							p.setMaximum(true);
							p.setUI(null);       //<------------ QUITAR BORDE DE UN INTERNAL FRAME 
							p.show();
						} catch (Exception ex) {
							// TODO: handle exception
						}
					}
					@Override
					public void mouseEntered(MouseEvent arg0) {
						lblGenerarCompra.setForeground(Color.white);
					
					}
					@Override
					public void mouseExited(MouseEvent e) {
						lblGenerarCompra.setForeground(new Color(137, 137, 127));
					
					}
				});
				lblGenerarCompra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblGenerarCompra.setOpaque(true);
				lblGenerarCompra.setHorizontalAlignment(SwingConstants.LEFT);
				lblGenerarCompra.setForeground(new Color(137, 137, 127));
				lblGenerarCompra.setBackground(new Color(33, 47, 61));
				lblGenerarCompra.setBounds(50, 198, 111, 34);
				jpanelMenu.add(lblGenerarCompra);
				
				lblGenerarVentas = new JLabel("Generar Ventas");
				lblGenerarVentas.setFont(new Font("Serif", Font.PLAIN, 13));
			
				lblGenerarVentas.setBounds(50, 88, 111, 34);
				jpanelMenu.add(lblGenerarVentas);
				lblGenerarVentas.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						dktBody.removeAll();
						dktBody.repaint();
						IntVenta venta=new IntVenta();
						dktBody.add(venta);
						try {
							venta.setMaximum(true);
							venta.setUI(null);  //<------------ QUITAR BORDE DE UN INTERNAL FRAME  
							venta.show(); 
						} catch (Exception e) {
							// TODO: handle exception
						}
					
						
					}
				
					@Override
					public void mouseEntered(MouseEvent arg0) {
					lblGenerarVentas.setForeground(Color.white);
					
					
					}
					@Override
					public void mouseExited(MouseEvent e) {
						lblGenerarVentas.setForeground(new Color(137, 137, 127));
						
					}
				});
				lblGenerarVentas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblGenerarVentas.setForeground(new Color(137, 137, 127));
				lblGenerarVentas.setOpaque(true);
				lblGenerarVentas.setBorder(null);
				lblGenerarVentas.setBackground(new Color(33, 47, 61));
				lblGenerarVentas.setHorizontalAlignment(SwingConstants.LEFT);
				lblGenerarVentas.setHorizontalTextPosition(SwingConstants.CENTER);
				
				lblRegistrarClientes =  new JLabel("Registrar Clientes");
				lblRegistrarClientes.setFont(new Font("Serif", Font.PLAIN, 13));
				lblRegistrarClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblRegistrarClientes.setBounds(50, 122, 111, 34);
				jpanelMenu.add(lblRegistrarClientes);
				lblRegistrarClientes.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						dktBody.removeAll();
						dktBody.repaint();
						IntClientes c=new IntClientes();
						
						dktBody.add(c);
						
						
						
						try {
							c.setMaximum(true);
							c.setUI(null);       //<------------ QUITAR BORDE DE UN INTERNAL FRAME 
							c.show();
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					
					@Override
					public void mouseEntered(MouseEvent arg0) {
						lblRegistrarClientes.setForeground(Color.white);
					
					}
					@Override
					public void mouseExited(MouseEvent e) {
						lblRegistrarClientes.setForeground(new Color(137, 137, 127));
						
					}
				});
				lblRegistrarClientes.setOpaque(true);
				lblRegistrarClientes.setForeground(new Color(137, 137, 127));
				lblRegistrarClientes.setHorizontalAlignment(SwingConstants.LEFT);
				lblRegistrarClientes.setBackground(new Color(33, 47, 61));
				
				lblRegistrarCategoria = new JLabel("Registrar Categoria");
				lblRegistrarCategoria.setFont(new Font("Serif", Font.PLAIN, 13));
				lblRegistrarCategoria.setHorizontalAlignment(SwingConstants.LEFT);
				lblRegistrarCategoria.setBorder(null);
				lblRegistrarCategoria.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						dktBody.removeAll();
						dktBody.repaint();
						IntCategoria p=new IntCategoria();
						dktBody.add(p);
						
						
						
						try {
							p.setMaximum(true);
							p.setUI(null);       //<------------ QUITAR BORDE DE UN INTERNAL FRAME 
							p.show();
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					
					@Override
					public void mouseEntered(MouseEvent arg0) {
					lblRegistrarCategoria.setForeground(Color.white);
					
					}
					@Override
					public void mouseExited(MouseEvent e) {
						lblRegistrarCategoria.setForeground(new Color(137, 137, 127));
						
					}
				});
				lblRegistrarCategoria.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
				lblRegistrarCategoria.setOpaque(true);
				lblRegistrarCategoria.setBounds(50, 177, 111, 34);
				lblRegistrarCategoria.setForeground(new Color(137, 137, 127));
				lblRegistrarCategoria.setBackground(new Color(33, 47, 61));
				jpanelMenu.add(lblRegistrarCategoria);
				
				lblReporte = new JLabel("Reporte");
				lblReporte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblReporte.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						if (lblReporte.isEnabled()==false) {
							JOptionPane.showMessageDialog(null, "Acceso Restringido");
						}
						else {
							AnimationClass animation=new AnimationClass();
							animation.jLabelXRight(50, 165, 2, 1, lblReporteVenta);
							
							
							AnimationClass animationOculRepVent=new AnimationClass();
							animationOculRepVent.jLabelXLeft(165, 50, 2, 1, lblReporteVenta);
							
							
							AnimationClass animationOculCompras=new AnimationClass();
							animationOculCompras.jLabelXLeft(165, 50, 2, 1, lblGenerarCompra);
							animationOculCompras.jLabelXLeft(165, 50, 2, 1, lblRegistrarProveedor);
							
							AnimationClass animationOculLogistica=new AnimationClass();
							animationOculLogistica.jLabelXLeft(165, 50, 2, 1, lblRegistrarProductos);
							animationOculLogistica.jLabelXLeft(165, 50, 2, 1, lblRegistrarCategoria);
							
							AnimationClass animacionOculVenta =new AnimationClass();
							animacionOculVenta.jLabelXLeft(165, 50, 2, 1, lblGenerarVentas);
							animacionOculVenta.jLabelXLeft(165, 50, 2, 1, lblRegistrarClientes);
							
							AnimationClass animationOculMante=new AnimationClass();
							animationOculMante.jLabelXLeft(165, 50, 2, 1, lblEmpleado);
						}
						
					}
					
					@Override
					public void mouseEntered(MouseEvent arg0) {
						lblReporte.setForeground(Color.white);
						
						}
						@Override
						public void mouseExited(MouseEvent e) {
							lblReporte.setForeground(new Color(137, 137, 127));
						
						}
				});
				lblReporte.setOpaque(true);
				lblReporte.setHorizontalAlignment(SwingConstants.LEFT);
				lblReporte.setForeground(new Color(137, 137, 127));
				lblReporte.setBackground(new Color(33, 47, 61));
				lblReporte.setBounds(50, 252, 115, 55);
				jpanelMenu.add(lblReporte);
				
				lblMantenimiento = new JLabel("Mantenimiento");
				lblMantenimiento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblMantenimiento.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						if (lblMantenimiento.isEnabled()==false) {
							JOptionPane.showMessageDialog(null, "Acceso Restringido");
						}
						else {
							AnimationClass animation=new AnimationClass();
							animation.jLabelXRight(50, 165, 2, 1, lblEmpleado);
							
							AnimationClass animationOculMante=new AnimationClass();
							animationOculMante.jLabelXLeft(165, 50, 2, 1, lblEmpleado);
							
							AnimationClass animationOculRepVent=new AnimationClass();
							animationOculRepVent.jLabelXLeft(165, 50, 2, 1, lblReporteVenta);
							
							
							AnimationClass animationOculCompras=new AnimationClass();
							animationOculCompras.jLabelXLeft(165, 50, 2, 1, lblGenerarCompra);
							animationOculCompras.jLabelXLeft(165, 50, 2, 1,lblRegistrarProveedor);
							
							AnimationClass animationOculLogistica=new AnimationClass();
							animationOculLogistica.jLabelXLeft(165, 50, 2, 1, lblRegistrarProductos);
							animationOculLogistica.jLabelXLeft(165, 50, 2, 1, lblRegistrarCategoria);
							
							AnimationClass animacionOculVenta =new AnimationClass();
							animacionOculVenta.jLabelXLeft(165, 50, 2, 1,lblGenerarVentas);
							animacionOculVenta.jLabelXLeft(165, 50, 2, 1, lblRegistrarClientes);
						}
						
					}
					
					@Override
					public void mouseEntered(MouseEvent arg0) {
						lblMantenimiento.setForeground(Color.white);
						
						}
						@Override
						public void mouseExited(MouseEvent e) {
							lblMantenimiento.setForeground(new Color(137, 137, 127));
						
						}
				});
				lblMantenimiento.setOpaque(true);
				lblMantenimiento.setHorizontalAlignment(SwingConstants.LEFT);
				lblMantenimiento.setForeground(new Color(137, 137, 127));
				lblMantenimiento.setBackground(new Color(33, 47, 61));
				lblMantenimiento.setBounds(50, 310, 115, 55);
				jpanelMenu.add(lblMantenimiento);
				
				lblRegistrarProveedor = new JLabel("Registrar Proveedor");
				lblRegistrarProveedor.setFont(new Font("Serif", Font.PLAIN, 13));
				lblRegistrarProveedor.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						dktBody.removeAll();
						dktBody.repaint();
						IntProveedor p=new IntProveedor();
						dktBody.add(p);
						
						
						
						try {
							p.setMaximum(true);
							p.setUI(null);       //<------------ QUITAR BORDE DE UN INTERNAL FRAME 
							p.show();
						} catch (Exception ex) {
							// TODO: handle exception
						}
					}
					
					@Override
					public void mouseEntered(MouseEvent arg0) {
						lblRegistrarProveedor.setForeground(Color.white);
				
					}
					@Override
					public void mouseExited(MouseEvent e) {
						lblRegistrarProveedor.setForeground(new Color(137, 137, 127));
						
					}
				});
				lblRegistrarProveedor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblRegistrarProveedor.setOpaque(true);
				lblRegistrarProveedor.setHorizontalAlignment(SwingConstants.LEFT);
				lblRegistrarProveedor.setForeground(new Color(137, 137, 127));
				lblRegistrarProveedor.setBackground(new Color(33, 47, 61));
				lblRegistrarProveedor.setBounds(50, 232, 111, 34);
				jpanelMenu.add(lblRegistrarProveedor);
				
				lblReporteVenta = new JLabel("Reporte Venta");
				lblReporteVenta.setFont(new Font("Serif", Font.PLAIN, 13));
				lblReporteVenta.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						dktBody.removeAll();
						dktBody.repaint();
						IntReporte p=new IntReporte();
						dktBody.add(p);
						
						
						
						try {
							p.setMaximum(true);
							p.setUI(null);       //<------------ QUITAR BORDE DE UN INTERNAL FRAME 
							p.show();
						} catch (Exception ex) {
							// TODO: handle exception
						}
					}
					
					@Override
					public void mouseEntered(MouseEvent arg0) {
						lblReporteVenta.setForeground(Color.white);
			
					}
					@Override
					public void mouseExited(MouseEvent e) {
						lblReporteVenta.setForeground(new Color(137, 137, 127));
					
					}
				});
				lblReporteVenta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblReporteVenta.setOpaque(true);
				lblReporteVenta.setHorizontalAlignment(SwingConstants.LEFT);
				lblReporteVenta.setForeground(new Color(137, 137, 127));
				lblReporteVenta.setBackground(new Color(33, 47, 61));
				lblReporteVenta.setBounds(50, 253, 111, 34);
				jpanelMenu.add(lblReporteVenta);
				
				lblEmpleado = new JLabel("Empleado");
				lblEmpleado.setFont(new Font("Serif", Font.PLAIN, 13));
				lblEmpleado.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						dktBody.removeAll();
						dktBody.repaint();
						IntEmpleado p=new IntEmpleado();
						dktBody.add(p);
						
						
						
						try {
							p.setMaximum(true);
							p.setUI(null);       //<------------ QUITAR BORDE DE UN INTERNAL FRAME 
							p.show();
						} catch (Exception ex) {
							// TODO: handle exception
						}
					}
					
					@Override
					public void mouseEntered(MouseEvent arg0) {
						lblEmpleado.setForeground(Color.white);
				
					}
					@Override
					public void mouseExited(MouseEvent e) {
						lblEmpleado.setForeground(new Color(137, 137, 127));
					
					}
				});
				lblEmpleado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblEmpleado.setOpaque(true);
				lblEmpleado.setHorizontalAlignment(SwingConstants.LEFT);
				lblEmpleado.setForeground(new Color(137, 137, 127));
				lblEmpleado.setBackground(new Color(33, 47, 61));
				lblEmpleado.setBounds(50, 310, 111, 34);
				jpanelMenu.add(lblEmpleado);
				
				JLabel lbliconVent = new JLabel("");
				lbliconVent.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/vender.png")));
				lbliconVent.setBounds(0, 98, 45, 34);
				jpanelMenu.add(lbliconVent);
				
				label_1 = new JLabel("");
				label_1.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/logistica.png")));
				label_1.setBounds(0, 154, 45, 34);
				jpanelMenu.add(label_1);
				
				label_2 = new JLabel("");
				label_2.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/compras.png")));
				label_2.setBounds(0, 209, 45, 34);
				jpanelMenu.add(label_2);
				
				label_3 = new JLabel("");
				label_3.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/reporte.png")));
				label_3.setBounds(0, 263, 45, 34);
				jpanelMenu.add(label_3);
				
				label_4 = new JLabel("");
				label_4.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/mantenimiento.png")));
				label_4.setBounds(0, 318, 45, 34);
				jpanelMenu.add(label_4);
				
				label_5 = new JLabel("");
				label_5.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/home.png")));
				label_5.setBounds(93, 14, 45, 34);
				jpanelMenu.add(label_5);
				
				jPanelBody = new JPanel();
				jPanelBody.setBorder(null);
				jPanelBody.setBounds(279, 122, 860, 596);
				contentPane.add(jPanelBody);
				jPanelBody.setLayout(new CardLayout(0, 0));
				
				dktBody = 	new JDesktopPane();
				dktBody.setBorder(null);
				jPanelBody.add(dktBody, "name_995467860582600");
				
				jpanelHeader = new JPanel();
				jpanelHeader.setBorder(null);
			
					
					
				jpanelHeader.setBounds(279, 0, 860, 81);
				contentPane.add(jpanelHeader);
				jpanelHeader.setBackground(new Color(0, 0,0, 35));
				jpanelHeader.setLayout(null);
				
				lblCargo = new JLabel("");
				lblCargo.setFont(new Font("Segoe UI Semilight", Font.BOLD, 20));
				lblCargo.setForeground(Color.WHITE);
				lblCargo.setBounds(159, 27, 155, 21);
				jpanelHeader.add(lblCargo);
				
				lblFecha = new JLabel("");
				lblFecha.setFont(new Font("Serif", Font.ITALIC, 14));
				lblFecha.setForeground(Color.WHITE);
				lblFecha.setBounds(21, 59, 205, 14);
				jpanelHeader.add(lblFecha);
				
				lblUser2 = new JLabel("");
				lblUser2.setBounds(800, 6, 50, 42);
				jpanelHeader.add(lblUser2);
				
				lblBienvenido = new JLabel("Hola Mascota");
				lblBienvenido.setFont(new Font("Monospaced", Font.PLAIN, 22));
				lblBienvenido.setForeground(Color.WHITE);
				lblBienvenido.setBackground(Color.WHITE);
				lblBienvenido.setBounds(21, 27, 149, 21);
				jpanelHeader.add(lblBienvenido);
				
				lblFondo = new JLabel("");
				lblFondo.setBorder(null);
				lblFondo.setBounds(279, 0, 860, 122);
				contentPane.add(lblFondo);
				lblFondo.setIcon(new ImageIcon(FrmMenuPrincipal.class.getResource("/img/1.jpg")));
		iniciaReloj();
		

	}
	void iniciaReloj() {
		
		//INSTANCIAMOS LA CLASE HILO RELOJ
		Hilo_Tiempo r = new Hilo_Tiempo();
		
		//INICIA EL HILO
		r.start();
	}
	}

