package Logica;
import Dominio.*;
import java.io.*;
public interface SistemaRiotGames {
    
    public void ingresarUsuario(String nombre, String pass, String nick, int nivel, int rp, int cantP, String region);

    public void ingresarPersonajeU(String nombreP, int cantS, String nombre, String pass, String nick, int nivel, int rp, int cantP, String region);

    public void ingresarSkinU(String nombre, String nombreP);

    public void ingresarPersonaje(String nombre, String rol, int cantS ,int recaudacion);

    public void ingresarSkin(String nombre, String calidad, String nombreP);

    public int confirmarNombre2(String nombre);

    public boolean confirmarNombre(String nombre);
    
    public boolean confirmarPass(String nombre, String pass);

    public void obtencionSkinsP(String nombreP);

    public void comprarSkin(String nombreS, String nombre, String nombreP);

    public void personajesDelJuego();

    public void comprarPersonaje(String nombreP, String nombre);

    public void obtencionSkins(String nombre);

    public void obtencionInventario(String nombre);

    public void recargaRp(String nombre);

    public void obtenerDatos(String nombre);

    public void recaudacionDeVentasPorRol();

    public void recaudacionVentasPorRegion();

    public void recaudacionVentasPorPersonaje();

    public void cantidadPersonajesRol();

    public void agregarPersonaje();

    public void agregarSkin();

    public void bloqueoCuenta();

    public boolean verificarBloqueo(String nombre);

    public String desplegarMayorMenor();

    public String obtenerDatosCuentas();

    public String obtenerDatosEstadísticas();

    public String obtenerDatosPersonajes();

}
