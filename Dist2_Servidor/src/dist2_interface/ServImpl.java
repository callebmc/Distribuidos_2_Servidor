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
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import dist2_interface.ListaDeCurriculos;
import java.util.List;

/**
 *
 * @author a1609556
 */

public class ServImpl extends UnicastRemoteObject implements InterfaceServ{
    
    private ArrayList<Empresa> vagasCadastradas;   
    private ListaDeCurriculos listaDeCurriculos;
    
    public ServImpl() throws RemoteException{
        this.vagasCadastradas = new ArrayList<>();
        this.listaDeCurriculos = new ListaDeCurriculos();
    }

    @Override
    public void chamar(String mensagem, InterfaceCli referenciaCli) throws RemoteException {
        referenciaCli.echo(mensagem);
    }

    
     @Override
    public boolean inserirCurriculo(String a, String b, String e, int c, float d)throws RemoteException{
        System.out.println("Estou aqui!");
        Curriculo rescu = new Curriculo (a, b, e, c, d);
        
        return listaDeCurriculos.adicionar(rescu);
    }

    //Empresa consulta currículo
    synchronized public List<Curriculo> consultar(String area) throws RemoteException {

	return listaDeCurriculos.consultar(area);

    }

    @Override
    synchronized public void criarVaga(String nomeEmpresa, String emailEmpresa, String areaVaga, String cargaHorariaVaga, float salarioVaga, InterfaceCli cliente) {
        try {
            Empresa novaEmpresa = new Empresa(nomeEmpresa, emailEmpresa, areaVaga, cargaHorariaVaga, salarioVaga, cliente);
            vagasCadastradas.add(novaEmpresa);
            System.out.println("Nova vaga cadastrada com sucesso");
            cliente.notificarVaga(novaEmpresa);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Not supported yet.");
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    synchronized public ArrayList<Empresa> consultar(int filtro, String area, float salario) throws RemoteException {
        try {
            ArrayList<Empresa> empresasFiltered;

            empresasFiltered = new ArrayList();
            if (filtro == 1) {
                for (Empresa empresa : vagasCadastradas) {

                    if (empresa.getSalarioVaga()>= salario) {
                        if (empresa.getAreaVaga().equals(area)) {
                            empresasFiltered.add(empresa);
                        }
                    }
                }
            }
            if(filtro == 2){
                for (Empresa empresa : vagasCadastradas) {
                    empresasFiltered.add(empresa);
                }
            }
            return empresasFiltered;            
        } catch (Exception e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

}
