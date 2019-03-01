package model;

public class Ventas {
	private int Nro_ven ,id_cli,id_emp;
	private String doc_ven,fech_ven,Cant_vent;
	
	public int getNro_ven() {
		return Nro_ven;
	}
	public void setNro_ven(int nro_ven) {
		Nro_ven = nro_ven;
	}
	public int getId_cli() {
		return id_cli;
	}
	public void setId_cli(int id_cli) {
		this.id_cli = id_cli;
	}
	public int getId_emp() {
		return id_emp;
	}
	public void setId_emp(int id_emp) {
		this.id_emp = id_emp;
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
	public String getCant_vent() {
		return Cant_vent;
	}
	public void setCant_vent(String cant_vent) {
		Cant_vent = cant_vent;
	}
	
	
	
}
