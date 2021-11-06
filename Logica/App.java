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
    }

    public static void LecturaPersonaje(SistemaRiotGames sistema)throws IOException{
        
        File fileP = new File("C://Users//ignac//Desktop//   //UCN//Segundo año//Segundo semestre//Prog. Avanzada//Talleres//Taller 1//Código//Personajes.txt");
        Scanner scanP = new Scanner(fileP);
        while(scanP.hasNext()){
            String lineaP = scanP.nextLine();
            String [] partesP = lineaP.split(",");
            String nombre = partesP[0];
            String rol = partesP[1];
            int cantS = Integer.parseInt(partesP[2]);
            File file = new File("C://Users//ignac//Desktop//   //UCN//Segundo año//Segundo semestre//Prog. Avanzada//Talleres//Taller 1//Código//Estadísticas.txt");
            Scanner scan = new Scanner(file);
            while(scan.hasNext()){
                String linea = scan.nextLine();
                String [] partes = linea.split(",");
                String nombrePR = partes [0];
                if(nombrePR.equals(nombre)){
                    int rec = Integer.parseInt(partes[partes.length-1]);
                    sistema.ingresarPersonaje(nombre, rol, cantS, rec);
                    
                }
            }
            for(int i=3;i<partesP.length;i++){
                String nameSkin = partesP[i];
                String calidad = partesP[i+1];
                i++;
                sistema.ingresarSkin(nameSkin, calidad);
            }
            
        }
        
    }

    public static void LecturaUsuario(SistemaRiotGames sistema)throws IOException{
        
        File file = new File("C://Users//ignac//Desktop//   //UCN//Segundo año//Segundo semestre//Prog. Avanzada//Talleres//Taller 1//Código//Cuentas.txt");
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
                sistema.ingresarPersonajeU(nombreP, cantS);
                i+=2;
                for(int j=i;j<cantS+i;j++){
                    String nombreS = partes[j];
                    sistema.ingresarSkinU(nombreS);
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
            }
            if(validarN == 2){
                break;
            }
            if(validarN == 3){

            }

            if(validarN == 4){
                System.out.println("Ingrese su contraseña: ");
                String pass = scan.nextLine();
                if(pass.equals("ADMIN")){
                    
                }
            }
        }
    }
}
