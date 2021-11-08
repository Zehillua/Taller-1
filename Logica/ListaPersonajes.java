package Logica;
import Dominio.*;
public class ListaPersonajes {

    private int cant;
    private int max;
    private Personaje [] lista;

    public ListaPersonajes(int max){
        this.max = max;
        cant=0;
        lista = new Personaje[max];
    }

    public int getCant(){
        return cant;
    }

    public boolean addPersonaje(Personaje p){
        if(cant<max){
            lista[cant]=p;
            cant++;
            return true;
        }
        return false;
    }

    public Personaje buscaPersonaje(String nombre){
        for(int i=0;i<cant;i++){
            Personaje personaje = lista[i];
            String nombreB = personaje.getNombre();
            if(nombreB.equals(nombre)){
                return personaje;
            }
        }    
        return null;
    }

    public Personaje getPersonajeI(int i){
        if(i>=0 && i<=cant){
            return lista[i];
        }
        return null;
    }
}
