package com.sbperu.reportecontable.businessentities;

public class EmpresaBe {
    private int IdEmpresa;
    private String Empresa;
    private String Abreviado;
    private String RUC;
    private String Direccion;
    private String Telefono;
    private String Cabecera_Reporte;
    private String Codigo_Postal;
    private String Codigo_Estado;
    private int IdAuditoria;
    private String Flag_Default;
    private String Flag_Agente_Retencion;

    public int getIdEmpresa() {
        return IdEmpresa;
    }

    public void setIdEmpresa(int IdEmpresa) {
        this.IdEmpresa = IdEmpresa;
    }

    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String Empresa) {
        this.Empresa = Empresa;
    }

    public String getAbreviado() {
        return Abreviado;
    }

    public void setAbreviado(String Abreviado) {
        this.Abreviado = Abreviado;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCabecera_Reporte() {
        return Cabecera_Reporte;
    }

    public void setCabecera_Reporte(String Cabecera_Reporte) {
        this.Cabecera_Reporte = Cabecera_Reporte;
    }

    public String getCodigo_Postal() {
        return Codigo_Postal;
    }

    public void setCodigo_Postal(String Codigo_Postal) {
        this.Codigo_Postal = Codigo_Postal;
    }

    public String getCodigo_Estado() {
        return Codigo_Estado;
    }

    public void setCodigo_Estado(String Codigo_Estado) {
        this.Codigo_Estado = Codigo_Estado;
    }

    public int getIdAuditoria() {
        return IdAuditoria;
    }

    public void setIdAuditoria(int IdAuditoria) {
        this.IdAuditoria = IdAuditoria;
    }

    public String getFlag_Default() {
        return Flag_Default;
    }

    public void setFlag_Default(String Flag_Default) {
        this.Flag_Default = Flag_Default;
    }

    public String getFlag_Agente_Retencion() {
        return Flag_Agente_Retencion;
    }

    public void setFlag_Agente_Retencion(String Flag_Agente_Retencion) {
        this.Flag_Agente_Retencion = Flag_Agente_Retencion;
    }

    public EmpresaBe(int IdEmpresa, String Empresa, String Abreviado, String RUC, String Direccion, String Telefono, String Cabecera_Reporte, String Codigo_Postal, String Codigo_Estado, int IdAuditoria, String Flag_Default, String Flag_Agente_Retencion) {
        this.IdEmpresa = IdEmpresa;
        this.Empresa = Empresa;
        this.Abreviado = Abreviado;
        this.RUC = RUC;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Cabecera_Reporte = Cabecera_Reporte;
        this.Codigo_Postal = Codigo_Postal;
        this.Codigo_Estado = Codigo_Estado;
        this.IdAuditoria = IdAuditoria;
        this.Flag_Default = Flag_Default;
        this.Flag_Agente_Retencion = Flag_Agente_Retencion;
    }

    public EmpresaBe() {
    }

    public EmpresaBe(int IdEmpresa, String Empresa) {
        this.IdEmpresa = IdEmpresa;
        this.Empresa = Empresa;
    }
    
}
