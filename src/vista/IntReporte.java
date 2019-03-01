package vista;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;

import mantenimientos.GestionVentas;
import model.Reporte;

public class IntReporte extends JInternalFrame {

private static final long serialVersionUID = 1L;
	
	public static JTextField txtNombreEmpleado;
	private JTable tblReporteEmpleado;
	private JTable tblReporteFecha;
	private JDateChooser txtFecha;
	DefaultTableModel modelo1=new DefaultTableModel();
	DefaultTableModel modelo2=new DefaultTableModel();
	private JButton btnBuscarCliente;
	private JButton btnReporteXemplead;
	private JButton btnGenerarPdfXfech;
	private JButton btnGenerarPdfXemple;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntReporte frame = new IntReporte();
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
	public IntReporte() {
		setBorder(null);
		setBounds(100, 100, 750, 500);
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 710, 439);
		getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Reporte por Fecha", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblReportePorFecha = new JLabel("Reporte por fecha");
		lblReportePorFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblReportePorFecha.setBounds(201, 38, 120, 20);
		panel.add(lblReportePorFecha);
		
		txtFecha = new JDateChooser();
		txtFecha.setBounds(331, 38, 136, 20);
		panel.add(txtFecha);
		
		JButton btnReporteXfech = new JButton("Reporte");
		btnReporteXfech.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listarxFecha();
				
			}
		});
		btnReporteXfech.setBounds(242, 69, 89, 23);
		panel.add(btnReporteXfech);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 140, 680, 242);
		panel.add(scrollPane);
		
		//TABLA REPORTE POR FECHA
		tblReporteFecha = new JTable();
		tblReporteFecha.setModel(modelo1);
		modelo1.addColumn("Numero Venta");
		modelo1.addColumn("Tipo Documento");
		modelo1.addColumn("Fecha Venta");
		modelo1.addColumn("Cliente");
		modelo1.addColumn("Empleado");
		scrollPane.setViewportView(tblReporteFecha);
		
		btnGenerarPdfXfech = new JButton("Generar PDF");
		btnGenerarPdfXfech.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				generarPDF();
			}
		});
		btnGenerarPdfXfech.setBounds(341, 69, 120, 23);
		panel.add(btnGenerarPdfXfech);
			
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Reporte por Empleado", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblCliente = new JLabel("Empleado");
		lblCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCliente.setBounds(140, 44, 85, 14);
		panel_1.add(lblCliente);
		
		txtNombreEmpleado = new JTextField();
		txtNombreEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		txtNombreEmpleado.setBounds(248, 41, 195, 20);
		panel_1.add(txtNombreEmpleado);
		txtNombreEmpleado.setColumns(10);
		
		btnBuscarCliente = new JButton("");
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmEmpleado em=new FrmEmpleado();
				em.setVisible(true);
				em.setLocationRelativeTo(null);
			}
		});
	
			

		btnBuscarCliente.setBounds(475, 41, 43, 23);
		panel_1.add(btnBuscarCliente);
		
		btnReporteXemplead = new JButton("Reporte");
		btnReporteXemplead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarxNombre();
				
			}
		});
		btnReporteXemplead.setBounds(248, 72, 89, 23);
		panel_1.add(btnReporteXemplead);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 131, 680, 242);
		panel_1.add(scrollPane_1);
		
		tblReporteEmpleado = new JTable();
		tblReporteEmpleado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				try {

					// COMPRAS
					int fila = tblReporteEmpleado.getSelectedRow();
					txtNombreEmpleado.setText(FrmEmpleado.tblEmpleados.getValueAt(fila, 1).toString());
					
					dispose();
				} catch (Exception e2) {

				}
				
			}
			
		});
		tblReporteEmpleado.setModel(modelo2);
		modelo2.addColumn("Numero Venta");
		modelo2.addColumn("Tipo Documento");
		modelo2.addColumn("Fecha Venta");
		modelo2.addColumn("Cliente");
		modelo2.addColumn("Empleado");
		scrollPane_1.setViewportView(tblReporteEmpleado);
		
		btnGenerarPdfXemple = new JButton("Generar PDF");
		btnGenerarPdfXemple.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				generarPDFempleado();
			}
		});
		btnGenerarPdfXemple.setBounds(365, 72, 131, 23);
		panel_1.add(btnGenerarPdfXemple);
		
	}
	
	//REPORTE POR FECHA
	void listarxFecha(){
		String fecha=leerFecha();
		
		GestionVentas gv=new GestionVentas();
		ArrayList<Reporte> reporte= gv.reportexfecha(fecha);
		
		if(reporte.isEmpty()){
			JOptionPane.showMessageDialog(null, "No existen ventas en la fecha solicitada");
		}
		else{
			limpiarTabla1();
			for (Reporte re : reporte) {
				Object datos[]={
						re.getNro_ven(),
						re.getDoc_ven(),
						re.getFech_ven(),
						re.getNom_cliente(),
						re.getNom_emple()
				};
				modelo1.addRow(datos);
			}
			
		}
	}
	
	//REPORTE POR NOMBRE
	void listarxNombre(){
		String nombre=leerNombre();
		GestionVentas gv=new GestionVentas();
		ArrayList<Reporte> reporte= gv.reportexnombre(nombre);
		
		if(reporte.isEmpty()){
			JOptionPane.showMessageDialog(null, "No existen ventas registradas con el cliente solicitado");
		}
		else{
			limpiarTabla2();
			for (Reporte r : reporte) {
				Object datos[]={
						r.getNro_ven(),
						r.getDoc_ven(),
						r.getFech_ven(),
						r.getNom_cliente(),
						r.getNom_emple()
				};
				modelo2.addRow(datos);
			}
			
		}
	}
	
	//REPORTE PDF FECHA
	void generarPDF(){
		String fecha=leerFecha();
		GestionVentas gv=new GestionVentas();
		ArrayList<Reporte> reporte= gv.reportexfecha(fecha);
		if(reporte.isEmpty()){
			JOptionPane.showMessageDialog(null, "No existen ventas en la fecha solicitada");
		}
		else{
			try {
				//Crear un objeto documento
				Document documento =new Document();
				//Crear archivo fisico
				FileOutputStream fos=new FileOutputStream("archivoEmpleado.pdf");
				//Relaciona el obj y el archivo
				PdfWriter pdfw=PdfWriter.getInstance(documento, fos);
				pdfw.setInitialLeading(20);//Espacio entre lineas
				//Abrir el documento para escribir
				documento.open();
				
				//Agregar texto=>parrafo
				documento.add(new Paragraph("Reporte por Fecha",FontFactory.getFont(BaseFont.TIMES_ROMAN,50,Font.UNDERLINE,BaseColor.DARK_GRAY)));
				documento.add(new Paragraph(" "));
				documento.add(new Paragraph("Fecha : "+fecha));
				documento.add(new Paragraph(" "));
				documento.add(new Paragraph(" "));
				
				//Agregar productos ->tabla
				PdfPTable tabla =new PdfPTable(5);
				tabla.addCell("Numero de venta");
				tabla.addCell("Tipo de Documento");
				tabla.addCell("Fecha de Venta");
				tabla.addCell("Cliente");
				tabla.addCell("Empleado");
				for (Reporte re : reporte) {
					tabla.addCell(re.getNro_ven()+"");
					tabla.addCell(re.getDoc_ven());
					tabla.addCell(re.getFech_ven());
					tabla.addCell(re.getNom_cliente());
					tabla.addCell(re.getNom_emple());
				}
				documento.add(tabla);
				documento.add(new Paragraph(" "));
				documento.add(new Paragraph(" "));
				
				//Agregamos una imagen de la firma
				Image firma=Image.getInstance("src/img/firma.png");
				firma.scaleToFit(300,300);
				firma.setAlignment(Chunk.ALIGN_MIDDLE);
				documento.add(firma);
				//Alinear texto
				Paragraph p=new Paragraph("Giancarlos Quilca - Gerente");
				p.setAlignment(Chunk.ALIGN_CENTER);
				documento.add(p);
				//Cerrar el documento
				documento.close();
				
				//Ver el archivo creado
				Desktop.getDesktop().open(new File("archivo.pdf"));
				
			} catch (Exception e) {
				System.out.println("Erro al crear PDF");
			}
			
			
		}
	}
	
	//REPORTE PDF EMPLEADO
		void generarPDFempleado(){
			String nombre=leerNombre();
			GestionVentas gv=new GestionVentas();
			ArrayList<Reporte> reporte= gv.reportexnombre(nombre);
			if(reporte.isEmpty()){
				JOptionPane.showMessageDialog(null, "No existen ventas con el empleado solicitado");
			}
			else{
				try {
					//Crear un objeto documento
					Document documento =new Document();
					//Crear archivo fisico
					FileOutputStream fos=new FileOutputStream("archivo.pdf");
					//Relaciona el obj y el archivo
					PdfWriter pdfw=PdfWriter.getInstance(documento, fos);
					pdfw.setInitialLeading(20);//Espacio entre lineas
					//Abrir el documento para escribir
					documento.open();
					
					//Agregar texto=>parrafo
					documento.add(new Paragraph("Reporte por Empleado",FontFactory.getFont(BaseFont.TIMES_ROMAN,50,Font.UNDERLINE,BaseColor.DARK_GRAY)));
					documento.add(new Paragraph(" "));
					documento.add(new Paragraph("Empleado : "+nombre));
					documento.add(new Paragraph(" "));
					documento.add(new Paragraph(" "));
					
					//Agregar productos ->tabla
					PdfPTable tabla =new PdfPTable(5);
					tabla.addCell("Numero de venta");
					tabla.addCell("Tipo de Documento");
					tabla.addCell("Fecha de Venta");
					tabla.addCell("Cliente");
					tabla.addCell("Empleado");
					for (Reporte r : reporte) {
						tabla.addCell(r.getNro_ven()+"");
						tabla.addCell(r.getDoc_ven());
						tabla.addCell(r.getFech_ven());
						tabla.addCell(r.getNom_cliente());
						tabla.addCell(r.getNom_emple());
					}
					documento.add(tabla);
					documento.add(new Paragraph(" "));
					documento.add(new Paragraph(" "));
					
					//Agregamos una imagen de la firma
					Image firma=Image.getInstance("src/img/firma.png");
					firma.scaleToFit(300,300);
					firma.setAlignment(Chunk.ALIGN_MIDDLE);
					documento.add(firma);
					//Alinear texto
					Paragraph p=new Paragraph("Giancarlos Quilca - Gerente");
					p.setAlignment(Chunk.ALIGN_CENTER);
					documento.add(p);
					//Cerrar el documento
					documento.close();
					
					//Ver el archivo creado
					Desktop.getDesktop().open(new File("archivo.pdf"));
					
				} catch (Exception e) {
					System.out.println("Erro al crear PDF");
				}
				
				
			}
		}
	
	//LIMPIAR TABLA
	void limpiarTabla1(){
		int filas= modelo1.getRowCount();
		for(int i=0;i<filas;i++){
			modelo1.removeRow(0);
		}
	}
	void limpiarTabla2(){
		int filas= modelo2.getRowCount();
		for(int i=0;i<filas;i++){
			modelo2.removeRow(0);
		}
	}
	
	//PARAMETROS DE ENTRADA
	String leerFecha() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		if (txtFecha.getDate() == null) {
			txtFecha.setDate(new Date());// Captura la fecha del sistema en el
											// txtFecha
			return sdf.format(new Date());// Si esta vacio devuelve fecha del
											// sistema
		} else {
			return sdf.format(txtFecha.getDate());
		}

	}
	
	String leerNombre(){
		return txtNombreEmpleado.getText();
	}
}
