package Dominio;
import Logica.*;
public class PersonajeU {
    
    private String nombre;
    private int cantS;
    ListaSkinsU lista;
    ListaUsuarios listaU;


    public PersonajeU(String nombre, int cantS) {
        this.nombre = nombre;
        this.cantS = cantS;
        lista = new ListaSkinsU(10000);
        listaU = new ListaUsuarios(10000);
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantS() {
        return cantS;
    }


    public void setCantS(int cantS) {
        this.cantS = cantS;
    }


    public ListaSkinsU getLista() {
        return lista;
    }


    public ListaUsuarios getListaU() {
        return listaU;
    }


    public void setListaU(ListaUsuarios listaU) {
        this.listaU = listaU;
    }    

   

}
