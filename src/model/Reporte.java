package model;

public class Reporte {
	private int Nro_ven;
	private String doc_ven,fech_ven,nom_cliente,nom_emple;
	
	public int getNro_ven() {
		return Nro_ven;
	}
	public void setNro_ven(int nro_ven) {
		Nro_ven = nro_ven;
	}
	public String getDoc_ven() {
		return doc_ven;
	}
	public void setDoc_ven(String doc_ven) {
		this.doc_ven = doc_ven;
	}
	public String getFech_ven() {
		return fech_ven;
	}
	public void setFech_ven(String fech_ven) {
		this.fech_ven = fech_ven;
	}
	public String getNom_cliente() {
		return nom_cliente;
	}
	public void setNom_cliente(String nom_cliente) {
		this.nom_cliente = nom_cliente;
	}
	public String getNom_emple() {
		return nom_emple;
	}
	public void setNom_emple(String nom_emple) {
		this.nom_emple = nom_emple;
	}
}
