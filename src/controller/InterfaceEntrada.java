/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import model.Entrada;

/**
 *
 * @author Ero
 */
public interface InterfaceEntrada extends Remote{
    public int adicionarEntrada(Entrada e) throws RemoteException;
    public int excluirEntrada(Entrada e) throws RemoteException;
    public int alterarEntrada(Entrada e) throws RemoteException;
    public int getIdEntrada(Entrada e) throws RemoteException;
}
