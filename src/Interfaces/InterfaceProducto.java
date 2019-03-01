package Interfaces;

import java.util.ArrayList;


import model.Producto;

public interface InterfaceProducto {

	public ArrayList<Producto>listado(); 
	public ArrayList<Producto>listado(String nombre);
	public int Agregar(Producto reg);
	
	public int actualizar(Producto c);
	public int eliminar(int codigo);
	
	
}
