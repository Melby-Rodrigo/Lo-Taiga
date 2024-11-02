/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.Conexao;
import dao.ProdutoDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import view.MenuView;
import model.Produto;

/**
 *
 * @author digom
 */
public class MenuController {
    private MenuView view;
    private final ProdutoDAO dao;
    
    public MenuController (MenuView view) throws SQLException {
        this.view = view;
        Connection conexao = new Conexao().getConnection();
        this.dao = new ProdutoDAO(conexao);
    }
    
    public Produto registrarProduto(String produto, String quantidade, String valor, String marca) {
        return this.dao.insert(produto, quantidade, valor, marca);
    } 
    
    public ArrayList<Produto> listarProdutos() {
        return this.dao.getAll();
    }
    
    public Produto atualizarProduto(int id, String produto, String quantidade, String valor, String marca) {
        return this.dao.update(id, produto, quantidade, valor, marca);
    }
    
    public int excluirProduto(int id) {
        return this.dao.delete(id);
    }
}
