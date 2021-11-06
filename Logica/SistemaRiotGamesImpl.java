package Logica;

import Dominio.Personaje;
import Dominio.PersonajeU;
import Dominio.Skin;
import Dominio.SkinU;
import Dominio.Usuario;

public class SistemaRiotGamesImpl implements SistemaRiotGames {

    private ListaPersonajes lPersonajes;
    private ListaPersonajesU lPersonajesU;
    private ListaSkins lSkins;
    private ListaSkinsU lSkinsU;
    private ListaUsuarios lUsuarios;

    public SistemaRiotGamesImpl(){
        lPersonajes = new ListaPersonajes(155);
        lPersonajesU = new ListaPersonajesU(155);
        lSkins = new ListaSkins(50);
        lSkinsU = new ListaSkinsU(50);
        lUsuarios = new ListaUsuarios(10000);
    }

    @Override
    public void ingresarUsuario(String nombre, String pass, String nick, int nivel, int rp, int cantP, String region) {
        Usuario u = new Usuario(nombre, pass, nick, nivel, rp, cantP, region);
        if(!lUsuarios.addUsuario(u)){
            throw new NullPointerException("Error al ingresar un Usuario");
            
        }
        
    }

    @Override
    public void ingresarPersonajeU(String nombreP, int cantS) {
        PersonajeU p = new PersonajeU(nombreP, cantS);
        if(p != null ){
            if(!lPersonajesU.addPersonajeU(p)){
                throw new NullPointerException("Error al ingresar el personaje de un Usuario al sistema.");
            }
        }
       
        
    }

    @Override
    public void ingresarSkinU(String nombre) {
        SkinU s = new SkinU(nombre);
        if(s !=null){
            if(!lSkinsU.addSkinU(s)){
                throw new NullPointerException("Error al ingresar la skin de un Usuario.");
            }
        }
        
    }



    @Override
    public void ingresarPersonaje(String nombre, String rol, int cantS ,int recaudacion) {
        Personaje p = new Personaje(nombre, rol, cantS ,recaudacion);
        if(!lPersonajes.addPersonaje(p)){
            throw new NullPointerException("Error al ingresar un personaje al sistema.");
        }
        
    }

    @Override
    public void ingresarSkin(String nombre, String calidad) {
        Skin s = new Skin(nombre, calidad);
        if(!lSkins.addSkin(s)){
            throw new NullPointerException("Error al ingresar una skin al sistema.");
        }
        
    }

    

    @Override
    public int confirmarNombre2(String nombre) {
        if(confirmarNombre(nombre)){
            return 1;
        }if(confirmarNombre("C")){
            return 2;
        }if(confirmarNombre("R")){
            return 3;
        }if(confirmarNombre("ADMIN")){
            return 4;
        }else{
            throw new NullPointerException("El nombre ingresado no se encuentra en el sistema.");
        }
        
    }

    @Override
    public boolean confirmarNombre(String nombre) {
        
        Usuario u = lUsuarios.buscarUsuario(nombre);
        return u != null;
    }

    @Override
    public boolean confirmarPass(String nombre, String pass) {
        boolean conf = false;
        if(confirmarNombre2(nombre) == 1){
            Usuario u = lUsuarios.buscarUsuario(nombre);
            conf = pass.equals(u.getPass());
        }
        return conf;
    }

    
    
    

}
