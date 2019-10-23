/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dist2_interface;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author ana
 */

//Classe interessados em curriculos (EMPRESAS)
public class InteressadosCurriculos implements Serializable {
    
    public InterfaceCli interfaceCliente;
    
     private ArrayList<Empresa> listaInteressados;
    
    
    public InteressadosCurriculos(InterfaceCli interfaceCliente){
        this.interfaceCliente = interfaceCliente;
        this.listaInteressados = new ArrayList();
    }
    
    public void adicionaInteressado(Empresa emp){
        this.listaInteressados.add(emp);
    }
    
    public void notifica(String msg) throws RemoteException{
        
        this.interfaceCliente.notificarCurriculos(msg, "123");
    
    }
    
    
    
}
