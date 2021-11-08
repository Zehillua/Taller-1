package Logica;
import java.util.Scanner;

import Dominio.Bloqueo;
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
    private ListaBloqueos lBloqueos;

    public SistemaRiotGamesImpl(){
        lPersonajes = new ListaPersonajes(155);
        lPersonajesU = new ListaPersonajesU(155);
        lSkins = new ListaSkins(50);
        lSkinsU = new ListaSkinsU(50);
        lUsuarios = new ListaUsuarios(10000);
        lBloqueos = new ListaBloqueos(10000);
    }

    @Override
    public void ingresarUsuario(String nombre, String pass, String nick, int nivel, int rp, int cantP, String region) {
        Usuario u = new Usuario(nombre, pass, nick, nivel, rp, cantP, region);
        if(!lUsuarios.addUsuario(u)){
            throw new NullPointerException("Error al ingresar un Usuario");
            
        }
        
    }

    @Override
    public void ingresarPersonajeU(String nombreP, int cantS, String nombre) {
        PersonajeU p = new PersonajeU(nombreP, cantS);
        Usuario u = lUsuarios.buscarUsuario(nombre);
        if(u != null ){
            u.getLista().addPersonajeU(p);
        }
        if(!lPersonajesU.addPersonajeU(p)){
            throw new NullPointerException("Error al ingresar el personaje de un Usuario al sistema.");
        }
       
        
    }

    @Override
    public void ingresarSkinU(String nombre, String nombreP) {
        SkinU s = new SkinU(nombre);
        PersonajeU p = lPersonajesU.buscarPersonajeU(nombreP);
        if(p !=null){
            p.getLista().addSkinU(s); 
        }
        if(!lSkinsU.addSkinU(s)){
            throw new NullPointerException("Error al ingresar la skin de un Usuario.");
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
    public void ingresarSkin(String nombre, String calidad, String nombreP) {
        Skin s = new Skin(nombre, calidad); 
        Personaje p = lPersonajes.buscaPersonaje(nombreP);
        if(p !=null){
            p.getLista().addSkin(s);
        }       
        if(!lSkins.addSkin(s)){
            throw new NullPointerException("Error al ingresar una skin al sistema.");
        }
    }

    @Override
    public int confirmarNombre2(String nombre) {
       
        if(confirmarNombre(nombre)){
            return 1;
        }   
        if(nombre.equals("C")){
                return 2;
        }if(nombre.equals("R")){
                return 3;
        }if(nombre.equals("ADMIN")){
                return 4;
        }else{
            throw new NullPointerException("El nombre ingresado no se encuentra en el sistema.");
        }
      
    }

    @Override
    public boolean confirmarNombre(String nombre) {
        Bloqueo b = lBloqueos.buscarBloqueado(nombre);
        if(b != null){
            System.out.println("Cuenta bloqueada.");
        }
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

    @Override
    public void personajesDelJuego() {
           System.out.println("Estos son los personajes del juego: ");
           for(int i=0;i<lPersonajes.getCant();i++){
               Personaje p2 = lPersonajes.getPersonajeI(i);
               System.out.println("Personaje: "+p2.getNombre());
           }   
    }

    

    @Override
    public void comprarPersonaje(String nombreP, String nombre) {
        int cantS = 0;
        Scanner scan = new Scanner(System.in);
        Personaje p = lPersonajes.buscaPersonaje(nombreP);
        System.out.println(p.getRecaudacion());
        Usuario u = lUsuarios.buscarUsuario(nombre);
        PersonajeU pU = u.getLista().buscarPersonajeU(nombreP);
            if( p != null && pU == null){
              PersonajeU pU2 = new PersonajeU(nombreP, cantS);
              System.out.println("El precio para comprar un personaje es de 975 RP.");
              System.out.println("¿Desea hacer la compra?");
              System.out.println("Ingrese '1' para confirmar\nIngrese '2' para cancelar.");
              try{ 
                int opcion = Integer.parseInt(scan.nextLine());
                if(opcion == 1){
                    if(u.getRp()>= 975){ 
                        u.getLista().addPersonajeU(pU2);
                        u.setCantP(u.getCantP()+1);
                        u.setRp(u.getRp()-975);
                        u.setNivel(u.getNivel()+1);
                        System.out.println(u.getNivel());
                        System.out.println(u.getRp());
                        for(int i=0;i<u.getLista().getCant();i++){
                            System.out.println(u.getLista().getPersonajeUI(i).getNombre());
                        }
                    }else{
                        System.out.println("Rp insuficiente.");
                    }
                }
                if(opcion == 2){
                    System.out.println("Se cancela la compra.");
                }
              }catch(NullPointerException e){
                  System.out.println("Debe ingresar el 1 o el 2 solamente.");
              }
            }
           if(p == null){
               System.out.println("El personaje no se encuentra en el sistema.");
           }
           if(pU != null){
               System.out.println("Y tiene al personaje.");
           }
        
        
    }

    @Override
    public void obtencionSkinsP(String nombreP) {  
      try{ 
        Personaje p = lPersonajes.buscaPersonaje(nombreP);
        System.out.println("Estas son las skins del personaje: "+p.getLista().getCant());
        for(int i=0;i<p.getLista().getCant();i++){
            Skin s1 = p.getLista().getSkinI(i);
            System.out.println("Skin: "+s1.getNombre());
            
        }
        
        }catch(NullPointerException e){
            System.out.println("El campeon no esta en el sistema.");
            
        }
    
    }

    @Override
    public void comprarSkin(String nombreS, String nombre, String nombreP) {
        Scanner scan = new Scanner(System.in);
        Skin s = lSkins.buscarSkin(nombreS);
        Usuario u = lUsuarios.buscarUsuario(nombre);
        SkinU sU = lSkinsU.buscarSkinU(nombreS);
        PersonajeU pU = u.getLista().buscarPersonajeU(nombreP);
        Personaje p = lPersonajes.buscaPersonaje(nombreP);
        while(true){ 
        if(s!= null){
            String calidad = s.getCalidad();
            if(calidad.equals("M")){
                int precio = 3250;
                System.out.println("El precio de la skin es de: "+precio);
                System.out.println("¿Desea comprar esta skin?");
                System.out.println("Si\nNo");
                String opcion2 = scan.nextLine();
                if(opcion2.equals("Si")){
                    if(sU ==null && pU != null){ 
                        SkinU sU2 = new SkinU(nombreS);
                        if(u.getRp()>= precio){
                            u.setRp(u.getRp()-precio);
                            pU.getLista().addSkinU(sU2);
                            pU.setCantS(pU.getCantS()+1);
                            p.setRecaudacion(p.getRecaudacion()+precio);
                            System.out.println("Compra completa.");
                            break;
                        }else{
                            System.out.println("Rp insuficiente.");
                            break;
                        }
                    }else{
                        if(sU != null){ 
                        System.out.println("La skin ya la tiene.");
                        break;
                        }
                        if(pU == null){
                            System.out.println("No tiene al personaje, se le recomienda comprarlo primero.");
                            break;
                        }
                    }
                }
                if(opcion2.equals("No")){
                    System.out.println("Se cancela la compra.");
                    break;
                }
            }
            if(calidad.equals("D")){
                int precio = 2750;
                System.out.println("El precio de la skin es de: "+precio);
                System.out.println("¿Desea comprar esta skin?");
                System.out.println("Si\nNo");
                String opcion2 = scan.nextLine();
                if(opcion2.equals("Si")){
                    if(sU ==null && pU != null){ 
                        SkinU sU2 = new SkinU(nombreS);
                        if(u.getRp()>= precio){
                            u.setRp(u.getRp()-precio);
                            pU.getLista().addSkinU(sU2);
                            pU.setCantS(pU.getCantS()+1);
                            p.setRecaudacion(p.getRecaudacion()+precio);
                            System.out.println("Compra completa.");
                            break;
                        }else{
                            System.out.println("Rp insuficiente.");
                            break;
                        }
                    }else{
                        if(sU != null){ 
                        System.out.println("La skin ya la tiene.");
                        break;
                        }
                        if(pU == null){
                            System.out.println("No tiene al personaje, se le recomienda comprarlo primero.");
                            break;
                        }
                    }
                }
                if(opcion2.equals("No")){
                    System.out.println("Se cancela la compra.");
                    break;
                }
            }
            if(calidad.equals("L")){
                int precio = 1820;
                System.out.println("El precio de la skin es de: "+precio);
                System.out.println("¿Desea comprar esta skin?");
                System.out.println("Si\nNo");
                String opcion2 = scan.nextLine();
                if(opcion2.equals("Si")){
                    if(sU ==null && pU != null){ 
                        SkinU sU2 = new SkinU(nombreS);
                        if(u.getRp()>= precio){
                            u.setRp(u.getRp()-precio);
                            pU.getLista().addSkinU(sU2);
                            pU.setCantS(pU.getCantS()+1);
                            p.setRecaudacion(p.getRecaudacion()+precio);
                            System.out.println("Compra completa.");
                            break;
                        }else{
                            System.out.println("Rp insuficiente.");
                            break;
                        }
                    }else{
                        if(sU != null){ 
                        System.out.println("La skin ya la tiene.");
                        break;
                        }
                        if(pU == null){
                            System.out.println("No tiene al personaje, se le recomienda comprarlo primero.");
                            break;
                        }
                    }
                }
                if(opcion2.equals("No")){
                    System.out.println("Se cancela la compra.");
                    break;
                }
            }
            if(calidad.equals("E")){
                int precio = 1350;
                System.out.println("El precio de la skin es de: "+precio);
                System.out.println("¿Desea comprar esta skin?");
                System.out.println("Si\nNo");
                String opcion2 = scan.nextLine();
                if(opcion2.equals("Si")){
                    if(sU ==null && pU != null){ 
                        SkinU sU2 = new SkinU(nombreS);
                        if(u.getRp()>= precio){
                            u.setRp(u.getRp()-precio);
                            pU.getLista().addSkinU(sU2);
                            pU.setCantS(pU.getCantS()+1);
                            System.out.println(p.getRecaudacion());
                            System.out.println("Compra completa.");
                            break;
                        }else{
                            System.out.println("Rp insuficiente.");
                            break;
                        }
                    }else{
                        if(sU != null){ 
                        System.out.println("La skin ya la tiene.");
                        break;
                        }
                        if(pU == null){
                            System.out.println("No tiene al personaje, se le recomienda comprarlo primero.");
                            break;
                        }
                    }
                }
                if(opcion2.equals("No")){
                    System.out.println("Se cancela la compra.");
                    break;
                }
                
            }
            if(calidad.equals("N")){
                int precio = 975;
                System.out.println("El precio de la skin es de: "+precio);
                System.out.println("¿Desea comprar esta skin?");
                System.out.println("Si\nNo");
                String opcion2 = scan.nextLine();
                if(opcion2.equals("Si")){
                    if(sU ==null && pU != null){ 
                        SkinU sU2 = new SkinU(nombreS);
                        if(u.getRp()>= precio){
                            u.setRp(u.getRp()-precio);
                            pU.getLista().addSkinU(sU2);
                            pU.setCantS(pU.getCantS()+1);
                            p.setRecaudacion(p.getRecaudacion()+precio);
                            System.out.println("Compra completa.");
                            break;
                        }else{
                            System.out.println("Rp insuficiente.");
                            break;
                        }
                    }else{
                        if(sU != null){ 
                        System.out.println("La skin ya la tiene.");
                        break;
                        }
                        if(pU == null){
                            System.out.println("No tiene al personaje, se le recomienda comprarlo primero.");
                            break;
                        }
                    }
                }
                if(opcion2.equals("No")){
                    System.out.println("Se cancela la compra.");
                    break;
                }
            }
            
        }else{
            System.out.println("La skin no se encuentra en el sistema.");
            break;
        }
    }
        
    }

    @Override
    public void obtencionInventario(String nombre) {
        Usuario u = lUsuarios.buscarUsuario(nombre);
        for(int i=0;i<u.getLista().getCant();i++){
            PersonajeU pU = u.getLista().getPersonajeUI(i);
            System.out.println("Personaje: "+pU.getNombre());
            for(int j=0;j<pU.getLista().getCant();j++){
                SkinU sU = pU.getLista().getSkinUI(j);
                System.out.println("Skin: "+sU.getNombre());
            }
        }
        
    }

    @Override
    public void obtencionSkins(String nombre) {
        Usuario u = lUsuarios.buscarUsuario(nombre);
        for(int i=0;i<lSkins.getCant();i++){
            Skin s = lSkins.getSkinI(i);
            System.out.println(s.getNombre());
            
        }
    }

    @Override
    public void obtenerDatos(String nombre) {
        Scanner scan = new Scanner(System.in);
        Usuario u = lUsuarios.buscarUsuario(nombre);
        String text = "";
        for(int i=0;i<u.getPass().length()-3;i++){
            text = "*";
        }
        System.out.println("Nombre de cuenta: "+u.getNombre()+"\nNick: "+u.getNick()+"\nContraseña: "+text+u.getPass().substring(u.getPass().length()-3,u.getPass().length()));
        System.out.println("Si quiere cambiar la contraseña ingrese '1', si no, ingrese '2'.");
        try{ 
            int opcion = Integer.parseInt(scan.nextLine());
            if(opcion == 1){
                while(true){ 
                    System.out.println("Ingrese su contraseña actual: ");
                    String pass = scan.nextLine();
                    if(u.getPass().equals(pass)){
                        System.out.println("Ingrese su nueva contraseña: ");
                        String newPass = scan.nextLine();
                        System.out.println("Ingrese su nueva contraseña nuevamente: ");
                        String newPass2 = scan.nextLine();
                        if(newPass.equals(newPass2)){
                            u.setPass(newPass2);
                            System.out.println(u.getPass());
                            break;
                        }else{
                            System.out.println("La nueva contraseña no coinciden.");
                        }
                    }else{
                        System.out.println("Contraseña incorrecta.");
                    }
                }
            }
        }catch(NullPointerException e){
            System.out.println("Ingrese 1 o 2 solamente.");
        }
    }

    @Override
    public void recargaRp(String nombre) {
        Scanner scan = new Scanner(System.in);
        Usuario u = lUsuarios.buscarUsuario(nombre);
        System.out.println("Ingrese la cantidad que desea recargar de RP: ");
        int cantRp = Integer.parseInt(scan.nextLine());
        u.setRp(u.getRp()+cantRp);
        System.out.println("Su cantidad de RP ahora es de: "+u.getRp()+" RP");
    }

    @Override
    public void recaudacionDeVentasPorRol() {
        
        
    }

    @Override
    public void cantidadPersonajesRol() {
        int cantRolADC=0;
        int cantRolTOP=0;
        int cantRolSUP=0;
        int cantRolJG=0;
        int cantRolMID=0;
        int cantP = lPersonajes.getCant();
        for(int i=0;i<cantP;i++){
            Personaje p = lPersonajes.getPersonajeI(i);
            if(p.getRol().equals("ADC")){
                cantRolADC++;
                System.out.println(cantRolADC);
            }
            if(p.getRol().equals("TOP")){
                cantRolTOP++;
                System.out.println(cantRolTOP);
            }
            if(p.getRol().equals("MID")){
                cantRolMID++;
                System.out.println(cantRolMID);
            }
            if(p.getRol().equals("JG")){
                cantRolJG++;
                System.out.println(cantRolJG);
            }
            if(p.getRol().equals("SUP")){
                cantRolSUP++;
                System.out.println(cantRolSUP);
            }
        }
        System.out.println("Cantidad de personajes con rol TOP: "+cantRolTOP+"\nCantidad de personajes con rol JG: "+cantRolJG+"\nCantidad de personajes con rol MID: "+cantRolMID+"\nCantidad de personajes con rol SUP: "+cantRolSUP+"\nCantidad de personajes con rol ADC: "+cantRolADC);
        
        
    }

    @Override
    public void agregarPersonaje(){
        int rec = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el nombre del personaje: ");
        String nombreP = scan.nextLine();
        System.out.println("Ingrese el rol del personaje: ");
        String rol = scan.nextLine();
        System.out.println("Ingrese la cantidad de skins que tendra el personaje: ");
        int cantS = Integer.parseInt(scan.nextLine());
        Personaje p = new Personaje(nombreP, rol, rec, cantS);
        lPersonajes.addPersonaje(p);
        for(int i=0;i<cantS;i++){
            System.out.println("Ingrese el nombre de la skin: ");
            String nombreS = scan.nextLine();
            System.out.println("Ingrese la calidad de la skin: ");
            String calidad = scan.nextLine();
            Skin s = new Skin(nombreS, calidad);
            lSkins.addSkin(s);
            Personaje p2 = lPersonajes.buscaPersonaje(p.getNombre());
            if(p2 != null){
                p2.getLista().addSkin(s);
            }
        }
        System.out.println("Personaje agregado exitosamente.");
        
        
    }

    @Override
    public void agregarSkin(){
        Scanner scan = new Scanner(System.in);
        while(true){ 
            System.out.println("Ingrese el nombre del personaje al cual quiere agregarle una skin: ");
            String nombreP = scan.nextLine();
            Personaje p = lPersonajes.buscaPersonaje(nombreP);
            if(p != null){
                System.out.println("Ingrese el nombre de la skin: ");
                String nombreS = scan.nextLine();
                System.out.println("Ingrese la calidad de la skin: ");
                String calidad = scan.nextLine();
                Skin s = new Skin(nombreS, calidad);
                lSkins.addSkin(s);
                p.getLista().addSkin(s);
                System.out.println("Skin agregado exitosamente.");
                break;
            }else{
                System.out.println("Nombre del presonaje no encontrado en el sistema.");
            }
        }
        
    }

    @Override
    public void bloqueoCuenta(){
        Scanner scan = new Scanner(System.in);
        while(true){ 
            System.out.println("Ingrese el nombre de la cuenta que desea bloquear: ");
            String nombre = scan.nextLine();
            Usuario u = lUsuarios.buscarUsuario(nombre);
            if(u != null){
                Bloqueo b = lBloqueos.buscarBloqueado(nombre);
                if( b==null){
                    Bloqueo b2 = new Bloqueo(u.getNombre());
                    lBloqueos.addBloqueo(b2);
                    lUsuarios.eliminarUsuario(u.getNombre());
                    break;
                }
                
            }else{
                System.out.println("El nombre de usuario no se encuentra en el sistema.");
            }
        }
        
        
    }

    @Override
    public boolean verificarBloqueo(String nombre) {
        boolean bloqueo = false;
        Bloqueo b = lBloqueos.buscarBloqueado(nombre);
        if( b !=null){
            bloqueo = true;
        }
        return false;
    }

    @Override
    public String desplegarMayorMenor() {
        String salida = "";
        int min = 100000;
        int max =-1;
        Usuario aux = null;
        for(int i=0;i<lUsuarios.getCant();i++){
            Usuario u = lUsuarios.getUsuarioI(i);
            if(u.getNivel()>max){
                max = u.getNivel();
                aux = u;
            }
        }
        if(aux != null){
            for(int j=0;j<lUsuarios.getCant();j++){
                aux = lUsuarios.getUsuarioI(j);
                salida = "Nick: "+aux.getNick()+"Nivel: "+aux.getNivel();
            } 
        }
        return salida;
        
    }

    @Override
    public String obtenerDatosCuentas() {
        String salida = "";
        for(int i=0;i<lUsuarios.getCant();i++){
            Usuario u = lUsuarios.getUsuarioI(i);
            for(int j=0;j<u.getListaS().getCant();j++){
                SkinU sU = lSkinsU.getSkinUI(j);
            
                if(i<lUsuarios.getCant()-1){
                    salida = salida+u.getNombre()+","+u.getPass()+","+u.getNick()+","+u.getNivel()+","+u.getRp()+","+u.getCantP()+","+sU.getNombre()+"\n";
                }else{
                    salida = salida+u.getNombre()+","+u.getPass()+","+u.getNick()+","+u.getNivel()+","+u.getRp()+","+u.getCantP()+","+sU.getNombre()+"\n";
                }
            }
        }
        return salida;
    }

    @Override
    public String obtenerDatosEstadísticas() {
        String salida = "";
        for(int i=0;i<lPersonajes.getCant();i++){
            Personaje p = lPersonajes.getPersonajeI(i);
            if(i<lPersonajes.getCant()-1){
                salida = salida+p.getNombre()+","+p.getRecaudacion()+"\n";
            }else{
                salida = salida+p.getNombre()+","+p.getRecaudacion()+"\n";
            }
        }
        return salida;
    }

    @Override
    public String obtenerDatosPersonajes() {
        String salida = "";
        for(int i=0;i<lPersonajes.getCant();i++){
            Personaje p = lPersonajes.getPersonajeI(i);
            if(i<lPersonajes.getCant()-1){
                salida = salida+p.getNombre()+","+p.getRol()+","+p.getCantS()+"\n";
            }else{
                salida = salida+p.getNombre()+","+p.getRol()+","+p.getCantS()+"\n";
            }
        }
        return salida;
    }

    
    
    
    

}
