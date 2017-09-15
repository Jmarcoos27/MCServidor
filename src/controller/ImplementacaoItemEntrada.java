/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ItemEntrada;

/**
 *
 * @author Ero
 */
public class ImplementacaoItemEntrada extends UnicastRemoteObject implements InterfaceItemEntrada
{
    public ImplementacaoItemEntrada() throws RemoteException{}
    private Conexao conexao;
    private int retornoItemEntrada;
    String sql;
    PreparedStatement stm;
    
    @Override
    public int adicionarItemEntrada(ArrayList<ItemEntrada> ie) throws RemoteException {
            conexao = new Conexao();
            retornoItemEntrada = 0;
            sql = "Insert into ItensEntrada (quantidade,valorItem,produto,entrada) VALUES (?,?,?,?)";
            try {
                for(int i = 0;i < ie.size(); i++){
                stm = conexao.con.prepareStatement(sql);
                stm.setDouble(1, ie.get(i).getQuantidade());
                stm.setDouble(2, ie.get(i).getValorItem());
                stm.setInt(3, ie.get(i).getProduto());
                stm.setInt(4, ie.get(i).getCodEntrada());
                retornoItemEntrada += stm.executeUpdate();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        return retornoItemEntrada;
    }

    @Override
    public int adicionarItemEntrada(ItemEntrada ie) throws RemoteException {
           conexao = new Conexao();
        retornoItemEntrada = 0;
            sql = "Insert into itensEntrada (quantidade,valorItem,produto,entrada) VALUES (?,?,?,?)";
            try {
                stm = conexao.con.prepareStatement(sql);
                stm.setDouble(1, ie.getQuantidade());
                stm.setDouble(2, ie.getValorItem());
                stm.setInt(3, ie.getProduto());
                stm.setInt(4, ie.getCodEntrada());
                retornoItemEntrada += stm.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        return retornoItemEntrada;
    }

    @Override
    public int excluirItemEntrada(ItemEntrada ie) throws RemoteException {
         conexao = new Conexao();
        retornoItemEntrada = 0;
            sql = "DELETE FROM itensEntrada where entrada = ? and produto = ?";
            try {
                stm = conexao.con.prepareStatement(sql);
                stm.setInt(1, ie.getCodEntrada());
                stm.setInt(2, ie.getProduto());
                retornoItemEntrada = stm.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        return retornoItemEntrada;
    }

    @Override
    public int alterarItemEntrada(ItemEntrada ie) throws RemoteException {
        conexao = new Conexao();
        retornoItemEntrada = 0;
            sql = "Update itensEntrada set quantidade = ?, valorItem = ?,produto = ?, entrada = ?"
                    + " where produto = ? and entrada = ? ";
            try {
                stm = conexao.con.prepareStatement(sql);
                stm.setDouble(1, ie.getQuantidade());
                stm.setDouble(2, ie.getValorItem());
                stm.setInt(3, ie.getProduto());
                stm.setInt(4, ie.getCodEntrada());
                stm.setInt(5, ie.getProduto());
                stm.setInt(6, ie.getCodEntrada());
                retornoItemEntrada = stm.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        return retornoItemEntrada;
    }
    
}
