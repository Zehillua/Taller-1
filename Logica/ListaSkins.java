package Logica;
import Dominio.*;
public class ListaSkins {
    
    private int cant;
    private int max;
    private Skin [] lista;


    public ListaSkins(int max){
        this.max=max;
        cant = 0;
        lista = new Skin[max];
    }

    public boolean addSkin(Skin s){
        if(cant<max){
            lista[cant]=s;
            cant++;
            return true;
        }
        return false;
    }

    public Skin buscarSkin(String nombre){
        for(int i=0; i<cant;i++){
            Skin skin = lista[i];
            String nombreB = skin.getNombre();
            if(nombreB.equals(nombre)){
                return skin;
            }
        }
        return null;
    }

    public int getCant(){
        return cant;
    }

    public Skin getSkinI(int i){
        if(i>=0 && i<=cant){
            return lista[i];
        }
        return null;
    }
}
