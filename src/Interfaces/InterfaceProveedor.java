package Interfaces;

import java.util.ArrayList;

import model.Clientes;
import model.Proveedores;

public interface InterfaceProveedor {

	public ArrayList<Proveedores>listado(); 
	public ArrayList<Proveedores>listado(String nombre);
	
	public int registrar(Proveedores reg);
	public int actualizar(Proveedores c);
	public int eliminar(int id);
	
}
