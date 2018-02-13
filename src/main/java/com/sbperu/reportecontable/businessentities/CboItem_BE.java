package com.sbperu.reportecontable.businessentities;

public class CboItem_BE {

	private String codigo="";
	private String descripcion="";
	
        public CboItem_BE(String cod, String nom){
            codigo=cod;
            descripcion=nom;
        }
        
        public CboItem_BE(){

        }
        
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
        
        public String toString(){
            return descripcion;
        }
}
