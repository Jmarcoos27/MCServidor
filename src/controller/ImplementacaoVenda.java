/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Venda;

/**
 *
 * @author Ero
 */
public class ImplementacaoVenda extends UnicastRemoteObject implements InterfaceVenda {

    public ImplementacaoVenda() throws RemoteException{}
    private Conexao conexao;
    private int retornoVenda;
    String sql;
    PreparedStatement stm;
    @Override
    public int adicionarVenda(Venda v) throws RemoteException {
        retornoVenda = 0;
        conexao = new Conexao();
        sql = "INSERT INTO venda (numeroVenda,dataVenda,valorTotal,cliente) VALUES (?,?,?,?)";
        try{
            stm = conexao.con.prepareStatement(sql);
            stm.setInt(1, v.getNumero());
            stm.setString(2, v.getData());
            stm.setDouble(3, v.getValorTotal());
            stm.setInt(4, v.getCliente());
            retornoVenda = stm.executeUpdate();
            stm.close();
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return retornoVenda;
        /*
        Retorna a quantidade de linhas alteradas
        Retorna 0 se nada foi inserido
        */
    }

    @Override
    public int excluirVenda(Venda v) throws RemoteException {
        
       retornoVenda = 0;
       conexao = new Conexao();
       sql = "DELETE FROM venda WHERE idVenda = ?";
       try{
           stm = conexao.con.prepareStatement(sql);
           stm.setInt(1, this.getIdVenda(v));
           retornoVenda = stm.executeUpdate();
       } catch (SQLException ex) {    
           System.out.println(ex.getMessage());
           retornoVenda = 0;
        }
       return retornoVenda;
       /*
        Retorna a quantidade de linhas alteradas
        Retorna 0 se nada foi excluido
       */
    }

    @Override
    public int alterarVenda(Venda v) throws RemoteException {
        retornoVenda = 0;
        conexao = new Conexao();
        sql = "UPDATE venda set numeroVenda = ?,dataVenda = ?,"
                + "valorTotal = ?,cliente = ? WHERE idVenda = ?";
        try{
            stm = conexao.con.prepareStatement(sql);
            stm.setInt(1, v.getNumero());
            stm.setString(2, v.getData());
            stm.setDouble(3, v.getValorTotal());
            stm.setInt(4, v.getCliente());
            stm.setInt(5, this.getIdVenda(v));
            retornoVenda = stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return retornoVenda;
    }

    @Override
    public int getIdVenda(Venda v) throws RemoteException {
       int idVenda = 0;
        conexao = new Conexao();
        sql = "SELECT idVenda FROM venda WHERE numeroVenda = '"+ v.getNumero()+"'";
        try{
            PreparedStatement ps;
            ps = conexao.con.prepareStatement(sql);
            //ps.setString(1, p.getDescricao());
            ResultSet st = ps.executeQuery(sql);
            if(st.next()){
                idVenda = st.getInt("idVenda");
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return idVenda;
    }
    
}
