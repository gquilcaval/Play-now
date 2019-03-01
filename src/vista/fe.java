package vista;

import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JDialog;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class fe extends JDialog {
	private JDateChooser dtcfecha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fe dialog = new fe();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
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
	public fe() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		dtcfecha = new JDateChooser();
		dtcfecha.setBounds(22, 40, 95, 20);
		getContentPane().add(dtcfecha);
		
		JButton btnF = new JButton("f");
		btnF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fecha();
			}
		});
		btnF.setBounds(62, 115, 89, 23);
		getContentPane().add(btnF);

	}
	
	void fecha(){
		
		String fecha;
		
		Date fe=dtcfecha.getDate();
		SimpleDateFormat format=new SimpleDateFormat("yyyy/MM/dd");
		fecha=format.format(fe);
		System.out.println(fecha);
	}
}
