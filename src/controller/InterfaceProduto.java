/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import model.Produto;

/**
 *
 * @author Ero
 */
public interface InterfaceProduto extends Remote{
    public int adicionarProduto(Produto p) throws RemoteException;
    public int excluirProduto(Produto p) throws RemoteException;
    public int alterarProduto(Produto p) throws RemoteException;
    public int getProdutoId(Produto p) throws RemoteException;
}
