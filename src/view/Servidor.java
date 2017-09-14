package view;
import controller.ImplementacaoPessoa;
import controller.ImplementacaoProduto;
import controller.InterfacePessoa;
import controller.InterfaceProduto;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {

    public static void main(String[] args) throws AlreadyBoundException {

        try {
            
            InterfacePessoa objetoRemotoPessoa = new ImplementacaoPessoa();
            InterfaceProduto objetoRemotoProduto = new ImplementacaoProduto();
            Registry conexao = LocateRegistry.createRegistry(1522);
            System.out.println("Servidor Conectado");
            conexao.bind("chavePessoa", objetoRemotoPessoa);
            conexao.bind("chaveProduto", objetoRemotoProduto);

        } catch (RemoteException e) {

            System.out.println(e.getMessage());

        } catch (AlreadyBoundException ex) {

            System.out.println(ex.getMessage());

        }

    }

}
