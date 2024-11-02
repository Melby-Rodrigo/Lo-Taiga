/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Produto;
import java.sql.Connection;

/**
 *
 * @author digom
 */
public class ProdutoDAO {

    private final Connection connection;
   
    
    public ProdutoDAO(Connection connection) {
        this.connection = connection;
    }
    
    public Produto insert(Produto produto) throws SQLException{
        String sql = "insert into Produto(produto,valor,quantidade,marca) values(?,?,?,?) returning* ;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, produto.getProduto());
        statement.setFloat(2, produto.getValor());
        statement.setInt(3, produto.getQuantidade());
        statement.setString(4, produto.getMarca());
        statement.execute();
        return null;
        
        
    
        
        
    }
       
    
}
