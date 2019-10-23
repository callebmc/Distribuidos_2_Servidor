/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dist2_interface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import dist2_interface.Curriculo;

/**
 *
 * @author ana
 */
public class ListaDeCurriculos implements Serializable{
    private List<Curriculo> listaCurriculos;
    
    public ListaDeCurriculos(){
        listaCurriculos = new ArrayList();
    }
    
    
    // Adiciona novo currículo a Lista
    public boolean adicionar (Curriculo curriculo){
        if (listaCurriculos.contains(curriculo)){
            System.out.println("Currículo já cadastrado no sistema");
            return false;
        }
        else {
        listaCurriculos.add(curriculo);
        System.out.println("Currículo Cadastrado com sucesso \n");
        return true;
       }
      
    }
    
    
    //Consulta a partir dos filtros
    public List<Curriculo> consultar (String area){
        List<Curriculo> curriculosFiltered;
        
        curriculosFiltered = new ArrayList();
        for (Curriculo curriculo : listaCurriculos){
            if (curriculo.getArea() == area){
                curriculosFiltered.add(curriculo);
            }
        }
        
        return curriculosFiltered;
    }
    
    
    
    
}
