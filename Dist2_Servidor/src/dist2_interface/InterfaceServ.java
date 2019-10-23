/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dist2_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import dist2_interface.Curriculo;

/**
 *
 * @author a1609556
 */
public interface InterfaceServ extends Remote{
    void chamar(String mensagem, InterfaceCli interfaceCli) throws RemoteException;
    public ArrayList<Curriculo> consultarCurriculos(String area) throws RemoteException ;
    public boolean inserirCurriculo(String a, String b, String e, int c, float d, InterfaceCli cli)throws RemoteException;
    public void criarVaga(String nomeEmpresa, String emailEmpresa, String areaVaga, String cargaHorariaVaga, float salarioVaga, InterfaceCli cliente) throws RemoteException;
    public ArrayList<Empresa> consultar(int filtro, String area, float salario) throws RemoteException ;
}