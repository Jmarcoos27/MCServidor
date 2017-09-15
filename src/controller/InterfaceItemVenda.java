/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import model.ItemVenda;
/**
 *
 * @author Ero
 */
public interface InterfaceItemVenda extends Remote{
    public int adcionarItemVenda(ArrayList<ItemVenda> iv) throws RemoteException;
    public int adcionarItemVenda(ItemVenda iv) throws RemoteException;
    public int excluirItemVenda(ItemVenda iv) throws RemoteException;
    public int alterarItemVenda(ItemVenda iv) throws RemoteException;
}