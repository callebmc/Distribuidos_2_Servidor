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

//INTERESSADOS EM VAGAS (ALUNOS)
public class InteressadosVagas implements Serializable{
    private ArrayList<Curriculo> listaInteressados;
    
    public InterfaceCli interfaceCliente;
    
    public InteressadosVagas(InterfaceCli interfaceCliente){
        this.interfaceCliente = interfaceCliente;
        this.listaInteressados = new ArrayList();
    }
    
    public void adicionaInteressado(Curriculo curr){
        this.listaInteressados.add(curr);
    }
    
    public void notifica(String msg) throws RemoteException{
        
        this.interfaceCliente.notificarVagas(msg, "123");
    
    }

    
}
