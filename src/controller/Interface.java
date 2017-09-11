package controller;


import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ero
 */
public interface Interface extends Remote {
    public double somar(int x,int y ) throws RemoteException;
}
