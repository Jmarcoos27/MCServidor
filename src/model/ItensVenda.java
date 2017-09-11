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
public class ItensVenda extends ItemMovimenta {
   
    private Venda codVenda;
    /**
     * @return the codVenda
     */
    public Venda getCodVenda() {
        return codVenda;
    }

    /**
     * @param codVenda the codVenda to set
     */
    public void setCodVenda(Venda codVenda) {
        this.codVenda = codVenda;
    } 
}
