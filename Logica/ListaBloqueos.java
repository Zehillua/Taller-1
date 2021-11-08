package Logica;
import Dominio.*;
public class ListaBloqueos {
    
    private int cant;
    private int max;
    private Bloqueo [] lista;

    public ListaBloqueos(int max){
        this.max = max;
        cant=0;
        lista = new Bloqueo[max];
    }

    public int getCant(){
        return cant;
    }

    public boolean addBloqueo(Bloqueo b){
        if(cant<max){
            lista[cant]=b;
            cant++;
            return true;
        }
        return false;
    }

    public Bloqueo buscarBloqueado(String nombre){
        for(int i=0;i<cant;i++){
            Bloqueo bloqueo = lista[i];
            String nombreB = bloqueo.getNombre();
            if(nombreB.equals(nombre)){
                return bloqueo;
            }
        }    
        return null;
    }
}
