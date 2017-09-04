import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class Servidor {
    
    public static void main (String[] args) throws AlreadyBoundException{
       
        try{
            
        Interface objetoRemoto = new Implementacao();
        Registry conexao = LocateRegistry.createRegistry(1522);
        System.out.println("Servidor Conectado");
        conexao.bind("chave", objetoRemoto);
        
        
        } catch (RemoteException e){
            
            System.out.println(e.getMessage());
        
        } catch (AlreadyBoundException ex){
            
            System.out.println(ex.getMessage());
            
        }
        
    }
    
}