
package modelo;

public class proveedor {
    int provid;
    String razonsocial;
    String ruc;
    String telefono;
    String correo;
    String servicio;

    public proveedor() {
    }

    public proveedor(String razonsocial, String ruc, String telefono, String correo, String servicio) {
        this.razonsocial = razonsocial;
        this.ruc = ruc;
        this.telefono = telefono;
        this.correo = correo;
        this.servicio = servicio;
    }

    public int getProvid() {
        return provid;
    }

    public void setProvid(int provid) {
        this.provid = provid;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }
    
    
}
