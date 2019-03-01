package model;

public class Compra {

	public String getCant_Comp() {
		return Cant_Comp;
	}
	public void setCant_Comp(String cant_Comp) {
		Cant_Comp = cant_Comp;
	}
	int nroCompra,idProveCom;
	String 	Cant_Comp;
	
	public int getNroCompra() {
		return nroCompra;
	}
	public void setNroCompra(int nroCompra) {
		this.nroCompra = nroCompra;
	}
	public int getIdProveCom() {
		return idProveCom;
	}
	public void setIdProveCom(int idProveCom) {
		this.idProveCom = idProveCom;
	}
	public String getDocumentocom() {
		return documentocom;
	}
	public void setDocumentocom(String documentocom) {
		this.documentocom = documentocom;
	}
	public String getFechaCom() {
		return fechaCom;
	}
	public void setFechaCom(String fechaCom) {
		this.fechaCom = fechaCom;
	}
	String documentocom,fechaCom;
	
}
