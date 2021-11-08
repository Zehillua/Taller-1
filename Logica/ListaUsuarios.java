package Logica;
import Dominio.*;
public class ListaUsuarios{

    private int max;
    private int cant;
    private Usuario [] lista;

    public ListaUsuarios(int max){
        this.max = max;
        cant = 0;
        lista = new Usuario[max];
    }

    public boolean addUsuario(Usuario u){
        if(cant<max){
            lista[cant]=u;
            cant++;
            return true;
        }
        return false;
    }

    public Usuario buscarUsuario(String nombre){
        for(int i=0; i<cant;i++){
            Usuario usuario = lista[i];
            String nombreB = usuario.getNombre();
            if(nombreB.equals(nombre)){
                return usuario;
            }
            
        }
        return null;
    }



    public int getCant(){
        return cant;
    }

    public Usuario getUsuarioI(int i){
        if(i>=0 && i<=cant){
            return lista[i];
        }
        return null;
    }

    public boolean eliminarUsuario(String nombre){
        int i;
        for( i=0;i<cant;i++){
            if(lista[i].getNombre().equals(nombre)){
                break;
            }
        }
        if(i==cant){
            return false;
        }else{
            for(int j = i;j<cant-1;j++){
                lista[j] = lista[j+1];
            }
            cant--;
            return true;
        }

    }

    public int indexUsuario(String nombre){
        for(int i=0;i<cant;i++){
            if(lista[i]!=null){
                if(lista[i].getNombre().equals(nombre)){
                    return i;
                }
            }
        }
        return -1;
    }


}

