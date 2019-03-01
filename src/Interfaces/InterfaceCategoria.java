package Interfaces;

import java.util.ArrayList;

import model.Categoria;
import model.Clientes;

public interface InterfaceCategoria {
public ArrayList<Categoria>listar();
	public ArrayList<Categoria>BusquedaCat(String descrip);
	public int agregar(Categoria c );
	
	public int actualizar(Categoria c);
	public int eliminar(String codigo);
	
}
