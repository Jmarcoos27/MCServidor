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
import model.Entrada;

/**
 *
 * @author Ero
 */
public class ImplementacaoEntrada extends UnicastRemoteObject implements InterfaceEntrada {
    
    public ImplementacaoEntrada()throws RemoteException {}
    private Conexao conexao;
    private int retornoVenda;
    String sql;
    PreparedStatement stm;
    @Override
    public int adicionarEntrada(Entrada e) throws RemoteException {
        retornoVenda = 0;
        conexao = new Conexao();
        sql = "INSERT INTO entrada (numeroEntrada,dataEntrada,valorTotal,fornecedor) VALUES (?,?,?,?)";
        try{
            stm = conexao.con.prepareStatement(sql);
            stm.setInt(1, e.getNumero());
            stm.setString(2, e.getData());
            stm.setDouble(3, e.getValorTotal());
            stm.setInt(4, e.getCliente());
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
    public int excluirEntrada(Entrada e) throws RemoteException {
        
       retornoVenda = 0;
       conexao = new Conexao();
       sql = "DELETE FROM venda WHERE idVenda = ?";
       try{
           stm = conexao.con.prepareStatement(sql);
           stm.setInt(1, this.getIdEntrada(e));
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
    public int alterarEntrada(Entrada e) throws RemoteException {
        retornoVenda = 0;
        conexao = new Conexao();
        sql = "UPDATE entrada set numeroEntrada = ?,dataEntrada = ?,"
                + "valorTotal = ?,fornecedor = ? WHERE idEntrada = ?";
        try{
            stm = conexao.con.prepareStatement(sql);
            stm.setInt(1, e.getNumero());
            stm.setString(2, e.getData());
            stm.setDouble(3, e.getValorTotal());
            stm.setInt(4, e.getCliente());
            stm.setInt(5, this.getIdEntrada(e));
            retornoVenda = stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return retornoVenda;
    }

    @Override
    public int getIdEntrada(Entrada e) {
       int idEntrada = 0;
        conexao = new Conexao();
        sql = "SELECT idEntrada FROM entrada WHERE numeroEntrada = '"+ e.getNumero()+"'";
        try{
            PreparedStatement ps;
            ps = conexao.con.prepareStatement(sql);
            //ps.setString(1, p.getDescricao());
            ResultSet st = ps.executeQuery(sql);
            if(st.next()){
                idEntrada = st.getInt("idEntrada");
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return idEntrada;
    }
    
}
