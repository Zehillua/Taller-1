package Logica;
import Dominio.*;
public class ListaPersonajesU{

    private int cant;
    private int max;
    private PersonajeU [] lista;

    public ListaPersonajesU(int max){
        this.max=max;
        cant=0;
        lista = new PersonajeU[max];
    }

    public boolean addPersonajeU(PersonajeU p){
        if(cant<max){
            lista[cant]=p;
            cant++;
            return true;
        }
        return false;
    }

    public PersonajeU buscarPersonajeU(String nombre){
        for(int i=0; i<cant;i++){
            PersonajeU personajeU = lista[i];
            String nombreB = personajeU.getNombre();
            if(nombreB.equals(nombre)){
                return personajeU;
            }
        }
        return null;
    }

    public int getCant(){
        return cant;
    }

    public PersonajeU getPersonajeUI(int i){
        if(i>=0 && i<=cant){
            return lista[i];
        }
        return null;
    }
    
}