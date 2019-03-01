package Interfaces;

import java.util.ArrayList;

import model.Compra;
import model.DetalleCompra;


public interface InterfaceCompra {

	public int ObtenerNumero();
	public ArrayList<Compra>listado();

	
	//REGISTRAR VENTA
	public int realizaCompra(Compra c,ArrayList<DetalleCompra>detalle);
	
	
}
