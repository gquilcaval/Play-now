package model;

public class DetalleVentas {
	private int Nro_ven,id_prod,CantxUnidad;
	private double precioUnidad;
	
	public int getNro_ven() {
		return Nro_ven;
	}
	public void setNro_ven(int nro_ven) {
		Nro_ven = nro_ven;
	}
	public int getId_prod() {
		return id_prod;
	}
	public void setId_prod(int id_prod) {
		this.id_prod = id_prod;
	}
	public int getCantxUnidad() {
		return CantxUnidad;
	}
	public void setCantxUnidad(int cantxUnidad) {
		CantxUnidad = cantxUnidad;
	}
	public double getPrecioUnidad() {
		return precioUnidad;
	}
	public void setPrecioUnidad(double precioUnidad) {
		this.precioUnidad = precioUnidad;
	}

}
