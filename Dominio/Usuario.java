package Dominio;
import Logica.*;
public class Usuario {
    private String nombre;
    private String pass;
    private String nick;
    private int nivel;
    private int rp;
    private int cantP;
    //private boolean bloqueo;
    private String region;
    ListaPersonajesU lista;
    ListaSkinsU listaS;

    public Usuario(String nombre, String pass, String nick, int nivel, int rp, int cantP, String region){
        this.nombre = nombre;
        this.pass = pass;
        this.nick=nick;
        this.nivel=nivel;
        this.rp=rp;
        this.cantP=cantP;
        //this.bloqueo=bloqueo;
        this.region=region;
        lista = new ListaPersonajesU(155);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getRp() {
        return rp;
    }

    public void setRp(int rp) {
        this.rp = rp;
    }

    public int getCantP() {
        return cantP;
    }

    public void setCantP(int cantP) {
        this.cantP = cantP;
    }

    //public boolean isBloqueo() {
        //return bloqueo;
    //}

    //public void setBloqueo(boolean bloqueo) {
      //  this.bloqueo = bloqueo;
    //}

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public ListaPersonajesU getLista() {
        return lista;
    }

    public ListaSkinsU getListaS() {
        return listaS;
    }
    
}
