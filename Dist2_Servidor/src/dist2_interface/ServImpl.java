/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dist2_interface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import dist2_interface.Curriculo;
import java.util.List;

/**
 *
 * @author a1609556
 */
public class ServImpl extends UnicastRemoteObject implements InterfaceServ{
    
    public ServImpl() throws RemoteException{
    }
    
    @Override
    public void chamar(String mensagem, InterfaceCli referenciaCli) throws RemoteException {
        referenciaCli.echo(mensagem);
    }
    
    
    synchronized public boolean inserirCurriculo(Curriculo curriculo){
        return Dist2_Servidor.listaDeCurriculos.adicionar(curriculo);
    }
    
    //Empresa consulta currículo
    synchronized public List<Curriculo> consultar(String area) throws RemoteException {
	return Dist2_Servidor.listaDeCurriculos.consultar(area);
    }

        
}
