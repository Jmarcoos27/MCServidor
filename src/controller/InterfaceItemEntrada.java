/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import model.ItemEntrada;

/**
 *
 * @author Ero
 */
public interface InterfaceItemEntrada extends Remote {
    public int adicionarItemEntrada(ArrayList<ItemEntrada> ie) throws RemoteException;
    public int adicionarItemEntrada(ItemEntrada ie) throws RemoteException;
    public int excluirItemEntrada(ItemEntrada ie) throws RemoteException;
    public int alterarItemEntrada(ItemEntrada ie) throws RemoteException;
}
