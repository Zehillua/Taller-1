package Logica;
import Dominio.*;
import java.io.*;
public interface SistemaRiotGames {
    
    public void ingresarUsuario(String nombre, String pass, String nick, int nivel, int rp, int cantP, String region);

    public void ingresarPersonajeU(String nombreP, int cantS);

    public void ingresarSkinU(String nombre);

    public void ingresarPersonaje(String nombre, String rol, int cantS ,int recaudacion);

    public void ingresarSkin(String nombre, String calidad);

    public int confirmarNombre2(String nombre);

    public boolean confirmarNombre(String nombre);
    
    public boolean confirmarPass(String nombre, String pass);
}
