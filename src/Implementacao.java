import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ero
 */
public class Implementacao extends UnicastRemoteObject implements Interface {

    public Implementacao()throws RemoteException {
    }
    @Override
    public double somar(int x, int y) throws RemoteException {
        return x+y;
    }
    
}
