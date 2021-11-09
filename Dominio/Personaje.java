package Dominio;
import Logica.*;
public class Personaje {
    
    private String nombre;
    private String rol;
    private int cantS;
    private int recaudacion;
    ListaSkins lista;
    
    public Personaje(String nombre, String rol, int cantS, int recaudacion) {
        this.nombre = nombre;
        this.rol = rol;
        this.cantS = cantS;
        this.recaudacion = recaudacion;
        lista = new ListaSkins(10000);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getCantS() {
        return cantS;
    }

    public void setCantS(int cantS) {
        this.cantS = cantS;
    }

    public int getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(int recaudacion) {
        this.recaudacion = recaudacion;
    }

    public ListaSkins getLista() {
        return lista;
    }
    
}
