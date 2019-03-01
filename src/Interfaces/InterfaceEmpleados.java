package Interfaces ;

import java.util.ArrayList;


import model.Empleados;
import model.TipoEmpleado;

public interface InterfaceEmpleados {
	public Empleados ValidaAcceso(String TIPO,String USU,String PSW);
	public Empleados ValidaAcceso2(String USU,String PSW);
	ArrayList<TipoEmpleado> tipo();
	
	public ArrayList<Empleados>listado(); 
	public ArrayList<Empleados>listado(String nombre);
	
	public int registrar(Empleados reg);
	public int actualizar(Empleados c);
	public int eliminar(String dni);
	
	
}
