package Logica;
import Dominio.*;
public class ListaSkinsU {
    
    private int cant;
    private int max;
    private SkinU [] lista;


    public ListaSkinsU(int max){
        this.max=max;
        cant=0;
        lista = new SkinU[max];
    }


    public boolean addSkinU(SkinU s){
        if(cant<max){
            lista[cant]=s;
            cant++;
            return true;
        }
        return false;
    }

    public SkinU buscarSkinU(String nombre){
        for(int i=0; i<cant;i++){
            SkinU skinU = lista[i];
            String nombreB = skinU.getNombre();
            if(nombreB.equals(nombre)){
                return skinU;
            }
        }
        return null;
    }

    public int getCant(){
        return cant;
    }

    public SkinU getUsuarioI(int i){
        if(i>=0 && i<=cant){
            return lista[i];
        }
        return null;
    }
}
