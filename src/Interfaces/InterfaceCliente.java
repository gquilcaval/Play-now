package Interfaces;

import java.util.ArrayList;

import model.Clientes;


public interface InterfaceCliente {

	public ArrayList<Clientes>listado(); 
	public ArrayList<Clientes>ListCantidadClientes();
	public ArrayList<Clientes>listado(String nombre);

	public int registrar(Clientes reg);
	public int actualizar(Clientes c);
	public int eliminar(String dni);
}
