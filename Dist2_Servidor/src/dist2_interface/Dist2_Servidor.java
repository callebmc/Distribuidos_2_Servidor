/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dist2_interface;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author a1609556
 */
public class Dist2_Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        Registry referenciaServicoNomes = LocateRegistry.createRegistry(1099);
        
        ServImpl servico = new ServImpl();
        ServImpl servicoDistribuido = (ServImpl) UnicastRemoteObject.exportObject(servico, 1099);
        referenciaServicoNomes.bind("Servidor", servicoDistribuido);                
    }
    
}
