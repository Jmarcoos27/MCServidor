package view;
import controller.ImplementacaoEntrada;
import controller.ImplementacaoItemEntrada;
import controller.ImplementacaoItemVenda;
import controller.ImplementacaoPessoa;
import controller.ImplementacaoProduto;
import controller.ImplementacaoVenda;
import controller.InterfaceEntrada;
import controller.InterfaceItemEntrada;
import controller.InterfaceItemVenda;
import controller.InterfacePessoa;
import controller.InterfaceProduto;
import controller.InterfaceVenda;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {

    public static void main(String[] args) throws AlreadyBoundException {

        try {
            
            InterfacePessoa objetoRemotoPessoa = new ImplementacaoPessoa();
            InterfaceProduto objetoRemotoProduto = new ImplementacaoProduto();
            InterfaceVenda objetoRemotoVenda = new ImplementacaoVenda();
            InterfaceEntrada objetoRemotoEntrada = new ImplementacaoEntrada();
            InterfaceItemVenda objetoRemotoItemVenda = new ImplementacaoItemVenda();
            InterfaceItemEntrada objetoRemotoItemEntrada = new ImplementacaoItemEntrada();
            
            Registry conexao = LocateRegistry.createRegistry(1522);
            System.out.println("Servidor Conectado");
            conexao.bind("chavePessoa", objetoRemotoPessoa);
            conexao.bind("chaveProduto", objetoRemotoProduto);
            conexao.bind("chaveVenda", objetoRemotoVenda);
            conexao.bind("chaveEntrada", objetoRemotoEntrada);
            conexao.bind("chaveItemVenda", objetoRemotoItemVenda);
            conexao.bind("chaveItemEntrada", objetoRemotoItemEntrada);
            
        } catch (RemoteException e) {

            System.out.println(e.getMessage());

        } catch (AlreadyBoundException ex) {

            System.out.println(ex.getMessage());

        }

    }

}
