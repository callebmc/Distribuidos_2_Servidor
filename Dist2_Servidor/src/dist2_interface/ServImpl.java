/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dist2_interface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author a1609556
 */
public class ServImpl extends UnicastRemoteObject implements InterfaceServ{

    private ArrayList<Aluno> alunosCadastrados;
    private ArrayList<Empresa> vagasCadastradas;    
    
    public ServImpl() throws RemoteException{
        this.alunosCadastrados = new ArrayList<>();
        this.vagasCadastradas = new ArrayList<>();
    }
    
    @Override
    public void chamar(String mensagem, InterfaceCli referenciaCli) throws RemoteException {
        referenciaCli.echo(mensagem);
    }
    
    @Override
    synchronized public boolean inserirAluno(Aluno a){
        if(this.alunosCadastrados.contains(a)){
            System.out.println("Aluno já cadastrado no sistema");
            return false;
        }
        this.alunosCadastrados.add(a);
        System.out.println("Aluno cadastrado no sistema");
        return true;
    }
}
