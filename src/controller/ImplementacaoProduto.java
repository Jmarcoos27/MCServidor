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
import model.Produto;

/**
 *
 * @author Ero
 */
public class ImplementacaoProduto extends UnicastRemoteObject implements InterfaceProduto {
    
    public ImplementacaoProduto() throws RemoteException{}
    private Conexao conexao;
    private int retornoProduto;
    String sql;
    PreparedStatement stm;
    @Override
    public int adicionarProduto(Produto p) throws RemoteException {
        retornoProduto = 0;
        sql = "INSERT INTO produto (descricao,unidade,valorEntrada,valorSaidaAVista,valorSaidaAPrazo) VALUES (?,?,?,?,?)";
        try{
            conexao = new Conexao();
            stm = conexao.con.prepareStatement(sql);
            stm.setString(1, p.getDescricao());
            stm.setString(2,p.getUnidade());
            stm.setDouble(3, p.getValorEntrada());
            stm.setDouble(4, p.getValorSaidaAvista());
            stm.setDouble(5, p.getValorSaidaAPrazo());
            retornoProduto = stm.executeUpdate();
            stm.close();
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            retornoProduto = 0;
        }
        return retornoProduto;
    }

    @Override
    public int excluirProduto(Produto p) throws RemoteException {
        retornoProduto = 0;
        conexao = new Conexao();
        sql = "DELETE FROM produto WHERE idProduto = ?";
        try{
            stm = conexao.con.prepareStatement(sql);
            stm.setInt(1, this.getIdProduto(p));
            retornoProduto = stm.executeUpdate();
            stm.close();
        }
        catch(SQLException ex){
            System.out.println();
            retornoProduto = 0;
        }
        return retornoProduto;
    }

    @Override
    public int alterarProduto(Produto p) throws RemoteException {
       retornoProduto = 0;
       conexao = new Conexao();
       sql = "Update produto set descricao = ?,unidade = ?,"
               + "valorEntrada = ?,valorSaidaAVista = ?,"
               + "valorSaidaAPrazo = ? WHERE idProduto = ?";
       try{
           stm = conexao.con.prepareStatement(sql);
           stm.setString(1, p.getDescricao());
           stm.setString(2, p.getUnidade());
           stm.setDouble(3, p.getValorEntrada());
           stm.setDouble(4,p.getValorSaidaAvista());
           stm.setDouble(5, p.getValorSaidaAPrazo());
           stm.setInt(6, this.getIdProduto(p));
           retornoProduto = stm.executeUpdate();
           stm.close();
       }
       catch(SQLException ex){
           System.out.println(ex.getMessage());
           retornoProduto = 0;
       }
       return retornoProduto;
    }

    private int getIdProduto(Produto p) {
        int idProduto = 0;
        conexao = new Conexao();
        sql = "SELECT idProduto FROM produto WHERE descricao = '"+ p.getDescricao()+"'";
        try{
            PreparedStatement ps;
            ps = conexao.con.prepareStatement(sql);
            //ps.setString(1, p.getDescricao());
            ResultSet st = ps.executeQuery(sql);
            if(st.next()){
                idProduto = st.getInt("idProduto");
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return idProduto;
    }
    
}
