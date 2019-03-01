package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.xml.stream.events.ProcessingInstruction;
import javax.swing.JLabel;


public class PanelVenta extends JPanel {
	public PanelVenta() {
	}
	

	/**
	 * Create the panel.
	 */


	public void panit(Graphics g){
		Dimension tam=getSize();
		
		ImageIcon iamgen=new ImageIcon(new ImageIcon(getClass().getResource("/img/1.jpg")).getImage());
		g.drawImage(iamgen.getImage(), 0, 0, 861,95,this);
		setOpaque(false);
		super.paint(g);
	}
	
		

}
