/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Ero
 */
public class ItemMovimenta {
    private Produto produto;
    private double quantidade;
    private double valorItem;
    
    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * @return the quantidade
     */
    public double getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the valorItem
     */
    public double getValorItem() {
        return valorItem;
    }

    /**
     * @param valorItem the valorItem to set
     */
    public void setValorItem(double valorItem) {
        this.valorItem = valorItem;
    }
}
