package modelo;

public class empleado {
    int empid;
    String nombres;
    String apellidos;
    String dni;
    String telf;
    int areaid;
    String areadescp;
    int cargoid;
    String cargodescp;
    String fecha;

    public empleado() {
    }

    public empleado(String nombres, String apellidos, String dni, String telf, int areaid, String areadescp, int cargoid, String cargodescp, String fecha) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.telf = telf;
        this.areaid = areaid;
        this.areadescp = areadescp;
        this.cargoid = cargoid;
        this.cargodescp = cargodescp;
        this.fecha = fecha;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelf() {
        return telf;
    }

    public void setTelf(String telf) {
        this.telf = telf;
    }

    public int getAreaid() {
        return areaid;
    }

    public void setAreaid(int areaid) {
        this.areaid = areaid;
    }

    public String getAreadescp() {
        return areadescp;
    }

    public void setAreadescp(String areadescp) {
        this.areadescp = areadescp;
    }

    public int getCargoid() {
        return cargoid;
    }

    public void setCargoid(int cargoid) {
        this.cargoid = cargoid;
    }

    public String getCargodescp() {
        return cargodescp;
    }

    public void setCargodescp(String cargodescp) {
        this.cargodescp = cargodescp;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
            
 }
