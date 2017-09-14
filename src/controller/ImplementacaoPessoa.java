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
import model.Pessoa;

/**
 *
 * @author Ero
 */
public class ImplementacaoPessoa extends UnicastRemoteObject implements InterfacePessoa {

    public ImplementacaoPessoa()throws RemoteException{}

    @Override
    public int adcionarPessoa(Pessoa p) throws RemoteException {
        int nLinhasAlteradas = 0;
        Conexao c = new Conexao();
        String sql = "INSERT INTO pessoa "
                + "(nome,cnpj_cpf,rg_insc,rua,numeroEndereco,bairro,cidade,estado,cliente,fornecedor,transportador)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps;
            ps = c.con.prepareStatement(sql);
            ps.setString(1, p.getNome());
            ps.setString(2, p.getCnpj_cpf());
            ps.setString(3, p.getRg_insc());
            ps.setString(4, p.getRua());
            ps.setInt(5, p.getNumeroEndereco());
            ps.setString(6, p.getBairro());
            ps.setString(7, p.getCidade());
            ps.setString(8, p.getEstado());
            ps.setInt(9, p.getCliente());
            ps.setInt(10, p.getFornecedor());
            ps.setInt(11, p.getTransportador());
            nLinhasAlteradas = ps.executeUpdate();
            ps.close();
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            nLinhasAlteradas = 0;
        }
        return nLinhasAlteradas;
    }

    @Override
    public int alterarPessoa(Pessoa p) throws RemoteException {
        Conexao conexao = new Conexao();
        int pessoaAtualizada = 0;
        String sql = "UPDATE pessoa set nome = ?, cnpj_cpf = ?,"
                + "rg_insc = ?, rua = ?, numeroEndereco = ?,"
                + "bairro = ?, cidade = ?, estado = ?, cliente = ?,"
                + " fornecedor = ?, transportador = ? "
                + "WHERE idPessoa = ?";
        try{
            PreparedStatement psUpdate;
            psUpdate = conexao.con.prepareStatement(sql);
            psUpdate.setString(1, p.getNome());
            psUpdate.setString(2, p.getCnpj_cpf());
            psUpdate.setString(3, p.getRg_insc());
            psUpdate.setString(4, p.getRua());
            psUpdate.setInt(5, p.getNumeroEndereco());
            psUpdate.setString(6, p.getBairro());
            psUpdate.setString(7, p.getCidade());
            psUpdate.setString(8, p.getEstado());
            psUpdate.setInt(9, p.getCliente());
            psUpdate.setInt(10, p.getFornecedor());
            psUpdate.setInt(11, p.getTransportador());
            psUpdate.setInt(12, this.getIdPessoa(p));
            pessoaAtualizada = psUpdate.executeUpdate();
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            pessoaAtualizada = 0;
        }
        return pessoaAtualizada;
    }

    @Override
    public int excluirPessoa(Pessoa p) throws RemoteException {
        Conexao conexao = new Conexao();
        int pessoaExcluida = 0;
        String sql = "DELETE FROM pessoa WHERE idPessoa = " + this.getIdPessoa(p);
        try{
            PreparedStatement psUpdate;
            psUpdate = conexao.con.prepareStatement(sql);
            pessoaExcluida = psUpdate.executeUpdate();
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
            pessoaExcluida = 0;
        }
        return pessoaExcluida;
    }
    private int getIdPessoa(Pessoa p){
        Conexao conexao = new Conexao();
        int idPessoa = 0;
        String sql = "SELECT idPessoa FROM pessoa WHERE cnpj_cpf = '"+p.getCnpj_cpf()+"'";
        try{
            PreparedStatement ps;
            ps = conexao.con.prepareStatement(sql);
            //ps.setString(1, c.getDescricao());
            ResultSet st = ps.executeQuery(sql);
            if(st.next()){
                idPessoa = st.getInt("idPessoa");
            }
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return idPessoa;
    }
    
}