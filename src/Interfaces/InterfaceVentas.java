package Interfaces;

import java.util.ArrayList;

import model.DetalleVentas;
import model.Reporte;
import model.Tipo_documento;
import model.Ventas;

public interface InterfaceVentas {

	public ArrayList<Ventas>listado();
	
	public int ObtenerNumero();
	

	
	//REGISTRAR VENTA
	public int realizaVenta(Ventas venta,ArrayList<DetalleVentas>detalle);
	
	//LLENAR COMBOBOX
	public ArrayList<Tipo_documento> tipoDocumento();
		
	//REPORTE POR FECHA
	public ArrayList<Reporte> reportexfecha(String fecha);
	
	//REPORTE POR NOMBRE
		public ArrayList<Reporte> reportexnombre(String nombre);
}

