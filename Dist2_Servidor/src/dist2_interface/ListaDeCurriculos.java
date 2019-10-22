/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dist2_interface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    public void adicionar (Curriculo curriculo){
        listaCurriculos.add(curriculo);
    }
    
    
    //Consulta a partir dos filtros
    public List<Curriculo> consultar (String area, double salario){
     //TOOD: Filtros
        return this.listaCurriculos;
    }
    
    
    
    
}
