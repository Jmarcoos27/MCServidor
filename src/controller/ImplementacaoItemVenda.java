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
import model.ItemVenda;

/**
 *
 * @author Ero
 */
public class ImplementacaoItemVenda extends UnicastRemoteObject implements InterfaceItemVenda {

    public ImplementacaoItemVenda() throws RemoteException {
    }
    private Conexao conexao;
    private int retornoItemVenda;
    String sql;
    PreparedStatement stm;
    
    /*Metodo que insere uma lista de ItensVenda de uma vez só*/
    @Override
    public int adcionarItemVenda(ArrayList<ItemVenda> iv) throws RemoteException {
        conexao = new Conexao();
        retornoItemVenda = 0;
            sql = "Insert into ItensVenda (quantidade,valorItem,produto,venda) VALUES (?,?,?,?)";
            try {
                for(int i = 0;i < iv.size(); i++){
                stm = conexao.con.prepareStatement(sql);
                stm.setDouble(1, iv.get(i).getQuantidade());
                stm.setDouble(2, iv.get(i).getValorItem());
                stm.setInt(3, iv.get(i).getProduto());
                stm.setInt(4, iv.get(i).getCodVenda());
                retornoItemVenda += stm.executeUpdate();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        return retornoItemVenda;
    }
    
    /*Exclui apenas um itemVenda, usa o numero da venda e o produto para excluir*/
    
    @Override
    public int excluirItemVenda(ItemVenda iv) throws RemoteException {
        conexao = new Conexao();
        retornoItemVenda = 0;
            sql = "DELETE FROM itensVenda where venda = ? and produto = ?";
            try {
                stm = conexao.con.prepareStatement(sql);
                stm.setInt(1, iv.getProduto());
                stm.setInt(2, iv.getCodVenda());
                retornoItemVenda = stm.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        return retornoItemVenda;
    }

    @Override
    public int alterarItemVenda(ItemVenda iv) throws RemoteException {
        conexao = new Conexao();
        retornoItemVenda = 0;
            sql = "Update ItensVenda set quantidade = ?, valorItem = ?,produto = ?, venda = ?"
                    + " where produto = ? and venda = ? ";
            try {
                stm = conexao.con.prepareStatement(sql);
                stm.setDouble(1, iv.getQuantidade());
                stm.setDouble(2, iv.getValorItem());
                stm.setInt(3, iv.getProduto());
                stm.setInt(4, iv.getCodVenda());
                stm.setInt(5, iv.getProduto());
                stm.setInt(6, iv.getCodVenda());
                retornoItemVenda = stm.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        return retornoItemVenda;
    }

    
    
    
    /*Metodo que insere apenas um ItemVenda de cada vez*/
    @Override
    public int adcionarItemVenda(ItemVenda iv) throws RemoteException {
         conexao = new Conexao();
        retornoItemVenda = 0;
            sql = "Insert into ItensVenda (quantidade,valorItem,produto,venda) VALUES (?,?,?,?)";
            try {
                stm = conexao.con.prepareStatement(sql);
                stm.setDouble(1, iv.getQuantidade());
                stm.setDouble(2, iv.getValorItem());
                stm.setInt(3, iv.getProduto());
                stm.setInt(4, iv.getCodVenda());
                retornoItemVenda += stm.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        return retornoItemVenda;
    }
}
