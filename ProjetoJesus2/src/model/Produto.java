/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author digom
 */
public class Produto {
    
    public String produto;
    public int quantidade;
    public float valor;
    public String marca;
    private int id;
    
    public Produto (){}
    
    public Produto(String produto, int quantidade, float valor, String marca, int id){
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = valor;
        this.marca = marca;
        this.id = id;
    
    }
    
    public Produto(String produto, int quantidade, float valor, String marca){
    
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = valor;
        this.marca = marca;
        
    }
    
    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
            
    
}
