package hilos;
import java.text.SimpleDateFormat;
import java.util.Date;
import vista.FrmMenuPrincipal;
public class Hilo_Tiempo extends Thread{
	

	
		
		public void run() {
			while(true) {
				Date tiempo = new Date();
				SimpleDateFormat diaSring=new SimpleDateFormat("EEEE");
				SimpleDateFormat dia=new SimpleDateFormat("dd");
				SimpleDateFormat mes=new SimpleDateFormat("MMMM");
				SimpleDateFormat año=new SimpleDateFormat("yyyy");
				SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
				FrmMenuPrincipal.lblFecha.setText(diaSring.format(tiempo)+", " +dia.format(tiempo)+" de "+mes.format(tiempo)+" del "+año.format(tiempo));//FECHA
				//FrmMenuPrincipal.lblReloj.setText(sdf.format(tiempo));//HORA
			}
		}	
	}


