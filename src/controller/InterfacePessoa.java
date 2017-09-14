/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import model.Pessoa;

/**
 *
 * @author Ero
 */
public interface InterfacePessoa extends Remote {
    public int adcionarPessoa(Pessoa p) throws RemoteException;
    public int excluirPessoa(Pessoa p) throws RemoteException;
    public int alterarPessoa(Pessoa p) throws RemoteException;
}
