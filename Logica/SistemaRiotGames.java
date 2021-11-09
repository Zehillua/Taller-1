package Logica;
import Dominio.*;
import java.io.*;
public interface SistemaRiotGames {

    /**
     * Enter a user to the system.
     * @param nombre is the name of the user's account to enter the system.
     * @param pass is the password of the user's account to enter the system.
     * @param nick is the nick of the user's account to enter the system.
     * @param nivel is the level of the user's account to enter the system.
     * @param rp is the rp of the user's account to enter the system.
     * @param cantP is the number of characters that the user has to enter the system.
     * @param region is the region of the user's account to enter the system.
     */
    public void ingresarUsuario(String nombre, String pass, String nick, int nivel, int rp, int cantP, String region);
    /**
     * Enter the user's characters to the system.
     * @param nombreP is the name of the character to enter the system.
     * @param cantS is the amount of Skins that the user's character has.
     * @param nombre is the name of the user whose character will be added.
     */
    public void ingresarPersonajeU(String nombreP, int cantS, String nombre);
    /**
     * Enter the user's skins to the system.
     * @param nombre is the name of the skin to enter the systrem.
     * @param nombreP is the name of the character to which the skin belongs.
     */
    public void ingresarSkinU(String nombre, String nombreP);
    /**
     * Enter a character to the system.
     * @param nombre is the name of the character to enter the system.
     * @param rol is the rol of the character has to enter the system.
     * @param cantS is the amount of skins the character has to enter the system.
     * @param recaudacion It is the collection that the character has to enter the system.
     */
    public void ingresarPersonaje(String nombre, String rol, int cantS ,int recaudacion);
    /**
     * Enter a skin to the system.
     * @param nombre is the name of the skin to add it to the system.
     * @param calidad is the name of the quality to add it to the system.
     * @param nombreP is the name of the character to which it belongs.
     */
    public void ingresarSkin(String nombre, String calidad, String nombreP);
    /**
     * Confirm the username.
     * @param nombre confirm user name to login.
     * @return return to an option.
     */
    public int confirmarNombre2(String nombre);
    /**
     * Confirm the username.
     * @param nombre confirm user name to login.
     * @return returns to the username.
     */
    public boolean confirmarNombre(String nombre);
    /**
     * Confirm the user's password.
     * @param nombre is the name of the user trying to login.
     * @param pass is to confirm that the password matches the password for the user name trying to enter the system.
     * @return returns to a boolean.
     */
    public boolean confirmarPass(String nombre, String pass);
    /**
     * You get the skins of the character entered by the user.
     * @param nombreP It is the name of the character whose skins will be obtained.
     */
    public void obtencionSkinsP(String nombreP);
    /**
     * The user buys a skin.
     * @param nombreS is the name of the skin you want to buy.
     * @param nombre is the name of the user who logged in.
     * @param nombreP is the name of the character from whom you want to buy a skin.
     */
    public void comprarSkin(String nombreS, String nombre, String nombreP);
    /**
     * You get the characters from the system.
     */
    public void personajesDelJuego();
    /**
     * The user buys a character from the system.
     * @param nombreP is the name of the character you want to buy.
     * @param nombre is the name of the user who logged into the system.
     */
    public void comprarPersonaje(String nombreP, String nombre);
    /**
     * You get the skins from the system.
     * @param nombre is the name of the user who logged into the system.
     */
    public void obtencionSkins(String nombre);
    /**
     * The inventory of the user who started the session is obtained.
     * @param nombre is the name of the user who logged into the system.
     */
    public void obtencionInventario(String nombre);
    /**
     * User recharges RP.
     * @param nombre is the name of the user who logged into the system.
     */
    public void recargaRp(String nombre);
    /**
     * The data of the user who started the session is obtained.
     * @param nombre is the name of the user who logged into the system.
     */
    public void obtenerDatos(String nombre);
    /**
     * You get the sales collection for the role of the character.
     */
    public void recaudacionDeVentasPorRol();
    /**
     * You get the sales collection by region of the character.
     */
    public void recaudacionVentasPorRegion();
    /**
     * You get the collection of sales per character.
     */
    public void recaudacionVentasPorPersonaje();
    /**
     * You get the number of characters per role that are in the system.
     */
    public void cantidadPersonajesRol();
    /**
     * A character is added to the system.
     */
    public void agregarPersonaje();
    /**
     * A skin is added to the system.
     */
    public void agregarSkin();
    /**
     * A system account is locked.
     */
    public void bloqueoCuenta();
    /**
     * The blocking of the account entered is verified.
     * @param nombre It is the name of the account that will be blocked.
     * @return returns to a boolean.
     */
    public boolean verificarBloqueo(String nombre);
    /**
     * The data of the users is obtained from highest to lowest by level.
     * @return returns to a String.
     */
    public String desplegarMayorMenor();
    /**
     * User files are overwritten.
     * @return returns to a String.
     */
    public String obtenerDatosCuentas();
    /**
     * Character Stats files are overwritten.
     * @return returns to a String.
     */
    public String obtenerDatosEstadísticas();
    /**
     * Character files are overwritten.
     * @return returns to a String.
     */
    public String obtenerDatosPersonajes();

}
