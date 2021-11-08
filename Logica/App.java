package Logica;
import Dominio.*;
import java.util.*;
import java.io.*;
public class App {

    public static void main(String [] args)throws IOException {
        SistemaRiotGames sistema = new SistemaRiotGamesImpl();
        LecturaPersonaje(sistema);
        LecturaUsuario(sistema);
        inicioSesion(sistema);
        escritura(sistema);
        
    }

    public static void LecturaPersonaje(SistemaRiotGames sistema)throws IOException{
        File fileP = new File("C://Users//ignac//Desktop//Código//Personajes.txt");
        Scanner scanP = new Scanner(fileP);
        while(scanP.hasNext()){
            
            String lineaP = scanP.nextLine();
            String [] partesP = lineaP.split(",");
            String nombre = partesP[0];
            String rol = partesP[1];
            int cantS = Integer.parseInt(partesP[2]);
            File file = new File("C://Users//ignac//Desktop//Código//Estadísticas.txt");
            Scanner scan = new Scanner(file);
            while(scan.hasNext()){
                String linea = scan.nextLine();
                String [] partes = linea.split(",");
                String nombrePR = partes [0];
                int rec = Integer.parseInt(partes[1]);
                    
                if(nombrePR.equals(nombre)){
                    sistema.ingresarPersonaje(nombre, rol, cantS, rec);
                    
                }
               
                    
            }
            for(int i=3;i<partesP.length;i++){
                String nameSkin = partesP[i];
                String calidad = partesP[i+1];
                i++;
                sistema.ingresarSkin(nameSkin, calidad,nombre);
                //sistema.agregarSkinPersonaje(nombre, nameSkin, calidad);
            }
            
              
        }
        
        
    }

    public static void LecturaUsuario(SistemaRiotGames sistema)throws IOException{
        
        File file = new File("C://Users//ignac//Desktop//Código//Cuentas.txt");
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()){
            String linea = scan.nextLine();
            String [] partes = linea.split(",");
            String nombre = partes[0];
            String pass = partes[1];
            String nick = partes[2];
            int nivel = Integer.parseInt(partes[3]);
            int rp = Integer.parseInt(partes[4]);
            int cantP = Integer.parseInt(partes[5]);
            String region = partes[partes.length-1];
            sistema.ingresarUsuario(nombre, pass, nick, nivel, rp, cantP, region);
            for(int i=6;i<partes.length-2;i++){
                String nombreP = partes[i];
                int cantS = Integer.parseInt(partes[i+1]);
                sistema.ingresarPersonajeU(nombreP, cantS, nombre, pass, nick, nivel, rp, cantP, region);
                i+=2;
                for(int j=i;j<cantS+i;j++){
                    String nombreS = partes[j];
                    sistema.ingresarSkinU(nombreS, nombreP);
                }
            }
            
            
        }
        scan.close();
    }
    
    public static void inicioSesion(SistemaRiotGames sistema){
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("Ingrese 'C' para cerrar el sistema.\nIngrese 'R' si desea registrarse.");
            System.out.println("Ingrese su nombre: ");
            String nombre = scan.nextLine();
            int validarN = sistema.confirmarNombre2(nombre);
            if(validarN == 1){
                while(true){
                    System.out.println("Ingrese su contrasena: ");
                    String pass = scan.nextLine();
                    if(sistema.confirmarPass(nombre, pass)){
                        menuUsuario(sistema, nombre);
                        break;
                    }else{
                        System.out.println("Contrasena incorrecta.");
                        System.out.println("¿Desea intentarlo de nuevo?\n1.Si\n2.No");
                        int opcion = Integer.parseInt(scan.nextLine());
                        if(opcion == 2){
                            break;
                        }
                    }
                }
            }if(validarN == 2){
                
                    break;
            }if(validarN == 3){
                    registroU(sistema);
            }if(validarN == 4){
                    System.out.println("Ingrese su contraseña: ");
                    String pass = scan.nextLine();
                    if(pass.equals("ADMIN")){
                        menuAdmin(sistema);
                    
                    }
            }
        }
    }

    public static void registroU(SistemaRiotGames sistema){
      try{   
        Scanner scan = new Scanner(System.in);
        System.out.println("Bienvenido al menu de Registro.");
        System.out.println("Ingrese su nombre de cuenta: ");
        String nombreU = scan.nextLine();
        System.out.println("Ingrese su contraseña: ");
        String passU = scan.nextLine();
        System.out.println("Ingrese su nick: ");
        String nickU = scan.nextLine();
        System.out.println("Eliga la región en la que está: ");
        System.out.println("LAS\nLAN\nEUW\nKR\nNA\nRU");
        String region = scan.nextLine();
        int cantPU = 0;
        int rpU = 0;
        int nivelU = 0;
        boolean b = sistema.verificarBloqueo(nombreU);
        if(b = false){ 
            sistema.ingresarUsuario(nombreU, passU, nickU, nivelU, rpU, cantPU, region);
            System.out.println("Se registro correctamente.");
        }else{
            System.out.println("Cuenta bloqueada.");
        }
      }catch(NullPointerException e){
          System.out.println(e.getMessage());
      }
    }

    public static void menuUsuario(SistemaRiotGames sistema, String nombre){
        Scanner scan = new Scanner(System.in);
        System.out.println("Bienvenido al menu del Usuario.");
        while(true){ 
            System.out.println("Por favor ingrese la opcion que desea realizar: ");
            System.out.println("1.Comprar Skin.\n2.Comprar Personaje.\n3.Skins disponibles.\n4.Mostrar su inventario.\n5.Recragar RP.\n6.Mostrar datos de su cuenta.\n7.Cierre del menu.");
            int opcionU = Integer.parseInt(scan.nextLine());
            if(opcionU == 1){
                while(true){ 
                    sistema.personajesDelJuego();
                    System.out.println("Ingrese el nombre del personaje que le desea comprar una skin: ");
                    String nombreP = scan.nextLine();
                    sistema.obtencionSkinsP(nombreP);
                    System.out.println("Ingrese el nombre de la Skin que desea comprar: ");
                    String nombreS = scan.nextLine();
                    sistema.comprarSkin(nombreS, nombre, nombreP);
                    break;
                }

            }
            if(opcionU == 2){
                while(true){
                    sistema.personajesDelJuego();
                    System.out.println("Ingrese el nombre del personaje que desea comprar: ");
                    String nombreP = scan.nextLine();
                    sistema.comprarPersonaje(nombreP, nombre);
                    break;
                }
            }
            if(opcionU == 3){
                sistema.obtencionSkins(nombre);
            }
            if(opcionU == 4){
                sistema.obtencionInventario(nombre);
            }
            if(opcionU == 5){
                sistema.recargaRp(nombre);
            }
            if(opcionU == 6){
                sistema.obtenerDatos(nombre);
            }
            if(opcionU == 7){
                break;
            }  
        }   
    }

    public static void menuAdmin(SistemaRiotGames sistema){
        Scanner scan= new Scanner(System.in);
        System.out.println("Bienvenido a su menu.");
        while(true){ 
            System.out.println("Ingrese la opcion que desea realizar: ");
            System.out.println("1.Recaudacion de ventas por rol\n2.Recaudacion total de ventas por region\n3.Recaudacion de ventas por personaje\n4.Cantidad de personajes por cada rol\n5.Agregar personaje al juego\n6.Agregar skin al juego\n7.Bloqueo de un jugador\n8.Obtener cuentas de menor a mayor\n9.Cierre del menu");
            int opcion = Integer.parseInt(scan.nextLine());
            if(opcion == 1){
                sistema.recaudacionDeVentasPorRol();
            }
            if(opcion == 2){
                sistema.recaudacionVentasPorRegion();
            }
            if(opcion == 3){
                sistema.recaudacionVentasPorPersonaje();
            }
            if(opcion == 4){
                sistema.cantidadPersonajesRol();
            }
            if(opcion == 5){
                sistema.agregarPersonaje();
            }
            if(opcion == 6){
                sistema.agregarSkin();
            }
            if(opcion == 7){
                sistema.bloqueoCuenta();
            }
            if(opcion == 8){
                sistema.desplegarMayorMenor();
            }
            if(opcion == 9){
                break;
            }
        }

     }
     
     public static void escritura(SistemaRiotGames sistema)throws IOException{
        try{
            //BufferedWriter cuentas = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C://Users//ignac//Desktop//Código//Cuentass.txt")));
            //cuentas.write(sistema.obtenerDatosCuentas());
            //cuentas.close();
            BufferedWriter personajes = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C://Users//ignac//Desktop//Código//Personajess.txt")));
            personajes.write(sistema.obtenerDatosPersonajes());
            personajes.close();
            BufferedWriter estadisticas = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C://Users//ignac//Desktop//Código//Estadisticass.txt")));
            estadisticas.close();
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
     }

     
}
