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
    
    private ArrayList<Empresa> vagasCadastradas;   
    
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
    
     @Override
    public void criarVaga(String nomeEmpresa, String emailEmpresa, String areaVaga, String cargaHorariaVaga, float salarioVaga, InterfaceCli cliente) {
        try{
            Empresa novaEmpresa = new Empresa(nomeEmpresa, emailEmpresa, areaVaga, cargaHorariaVaga, salarioVaga, cliente);
            vagasCadastradas.add(novaEmpresa);
            System.out.println("Nova vaga cadastrada com sucesso");
        }
        catch(Exception e){
            throw new UnsupportedOperationException("Not supported yet.");
        } //To change body of generated methods, choose Tools | Templates.
    }
        
}
