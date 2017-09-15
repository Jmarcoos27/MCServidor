
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import model.Venda;


/**
 *
 * @author Ero
 */
public interface InterfaceVenda extends Remote {
    public int adicionarVenda(Venda v) throws RemoteException;
    public int excluirVenda(Venda v) throws RemoteException;
    public int alterarVenda(Venda v) throws RemoteException;
    public int getIdVenda(Venda v) throws RemoteException;
}
