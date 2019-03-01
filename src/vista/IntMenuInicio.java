package vista;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Panel;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.itextpdf.text.Image;
import com.mysql.jdbc.interceptors.ServerStatusDiffInterceptor;

import mantenimientos.GestionClientes;
import mantenimientos.GestionCompra;
import mantenimientos.GestionVentas;
import model.Clientes;
import model.Compra;
import model.Ventas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Rectangle;
import java.beans.PropertyVetoException;

import javax.swing.SwingConstants;

public class IntMenuInicio extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntMenuInicio frame = new IntMenuInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	DefaultTableModel model=new DefaultTableModel();
	private JLabel lblImgCompra;
	private JLabel lblimgcli;
	public static JPanel JPanel_Venta;
	private JPanel jPanel_Comp;
	private JPanel Jpanel_cli;
	/**
	 * Create the frame.
	 */
	
	private JLabel lblCantVent;
	private JLabel lblCantCompra;
	private JLabel lblCantCli;
	public IntMenuInicio() {
		
		getContentPane().setBackground(Color.WHITE);
	
		addInternalFrameListener(new InternalFrameAdapter() {
			
			@Override
			public void internalFrameActivated(InternalFrameEvent arg0) {
				Cant_cliente();
				Cant_compras();
				cant_Ventas();
				
				
			}
			
		});
		
		
		setBorder(null);
		setBounds(100, 100, 860, 584);
		getContentPane().setLayout(null);
		
		
		jPanel_Comp = new JPanel();
		jPanel_Comp.setLayout(null);
		jPanel_Comp.setBounds(300, 0, 255, 156);
		getContentPane().add(jPanel_Comp);
		
		lblImgCompra = new JLabel("");
		lblImgCompra.setIcon(new ImageIcon(IntMenuInicio.class.getResource("/img/compra.jpg")));
		lblImgCompra.setBounds(0, 0, 120, 124);
		jPanel_Comp.add(lblImgCompra);
		
		JLabel label_3 = new JLabel("Compras");
		label_3.setOpaque(true);
		label_3.setBackground(new Color(0, 153, 204));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(0, 124, 255, 32);
		jPanel_Comp.add(label_3);
		
		JLabel lblCompras = new JLabel("COMPRAS");
		lblCompras.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompras.setBounds(130, 11, 68, 14);
		jPanel_Comp.add(lblCompras);
		
		lblCantCompra = new JLabel("");
		lblCantCompra.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantCompra.setBounds(130, 36, 81, 14);
		jPanel_Comp.add(lblCantCompra);
		
		Jpanel_cli = new JPanel();
		Jpanel_cli.setLayout(null);
		Jpanel_cli.setBounds(584, 0, 255, 156);
		getContentPane().add(Jpanel_cli);
		
		JLabel label_5 = new JLabel("Clientes");
		label_5.setOpaque(true);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBackground(new Color(0, 102, 153));
		label_5.setForeground(Color.WHITE);
		label_5.setBounds(0, 124, 255, 32);
		Jpanel_cli.add(label_5);
		
		lblimgcli = new JLabel("");
		lblimgcli.setIcon(new ImageIcon(IntMenuInicio.class.getResource("/img/cliente.png")));
		lblimgcli.setBounds(0, 0, 120, 124);
		Jpanel_cli.add(lblimgcli);
		
		JLabel lblClientes = new JLabel("CLIENTES");
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setBounds(139, 11, 67, 14);
		Jpanel_cli.add(lblClientes);
		
		lblCantCli = new JLabel("");
		lblCantCli.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantCli.setBounds(125, 36, 81, 14);
		Jpanel_cli.add(lblCantCli);
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel_3.setLayout(null);
		panel_3.setBounds(11, 393, 328, 175);
		getContentPane().add(panel_3);
		
		JLabel label_6 = new JLabel("Productos mas Vendidos");
		label_6.setBounds(30, 11, 138, 14);
		panel_3.add(label_6);
		
	 JPanel_Venta = new JPanel();
	 JPanel_Venta.setLayout(null);
		JPanel_Venta.setBounds(20, 0, 255, 156);
		
		getContentPane().add(JPanel_Venta);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(IntMenuInicio.class.getResource("/img/ventas.png")));
		label.setBounds(0, 0, 120, 124);
		JPanel_Venta.add(label);
		
		JLabel lblVentas = new JLabel("ventas");
		lblVentas.setOpaque(true);
		lblVentas.setForeground(new Color(255, 255, 255));
		lblVentas.setBackground(new Color(255, 51, 102));
		lblVentas.setHorizontalAlignment(SwingConstants.CENTER);
		lblVentas.setBounds(0, 124, 255, 32);
		JPanel_Venta.add(lblVentas);
		
		JLabel lblVnetas = new JLabel("VENTAS");
		lblVnetas.setHorizontalAlignment(SwingConstants.CENTER);
		lblVnetas.setBounds(130, 11, 52, 14);
		JPanel_Venta.add(lblVnetas);
		
		lblCantVent = new JLabel("");
		lblCantVent.setHorizontalAlignment(SwingConstants.LEFT);
		lblCantVent.setBounds(130, 36, 81, 14);
		JPanel_Venta.add(lblCantVent);
		
		
		
		
	}
	void Cant_cliente(){
		
		GestionClientes gc = new GestionClientes();
		ArrayList<Clientes> lista = gc.ListCantidadClientes();
		
		
		for (Clientes cl : lista) {
			String datos =  cl.getNro_clientes();

			lblCantCli.setText(datos);

		}
		
	}
	void Cant_compras(){
		
		GestionCompra gc = new GestionCompra();
		ArrayList<Compra> lista = gc.listado();
		
		
		for (Compra cl : lista) {
			String datos =  cl.getCant_Comp();

			lblCantCompra.setText("S./"+" "+datos);

		}
		
	}
	void cant_Ventas(){
		GestionVentas gc = new GestionVentas();
		ArrayList<Ventas> lista = gc.listado();
		
		
		for ( Ventas cl : lista) {
			String datos =  cl.getCant_vent();

		lblCantVent.setText("S./"+" "+datos);

		}
	}
}
