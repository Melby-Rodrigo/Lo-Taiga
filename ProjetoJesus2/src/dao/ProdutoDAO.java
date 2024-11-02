/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Produto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import mappers.ProductMapper;

/**
 *
 * @author digom
 */
public class ProdutoDAO {

    private final Connection connection;
   
    
    public ProdutoDAO(Connection connection) {
        this.connection = connection;
    }
    
    public Produto insert(String produto, String quantidade, String valor, String marca) {
        String sql = "insert into produto (produto,valor,quantidade,marca) values(?,?,?,?) RETURNING *;";
        ResultSet rs = null;
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, produto);
            statement.setFloat(2, Float.parseFloat(valor));
            statement.setInt(3, Integer.parseInt(quantidade));
            statement.setString(4, marca);

            rs = statement.executeQuery();
            
            System.out.println(rs);
            if (rs.next()) {
                System.out.println(rs);
                return ProductMapper.toEntity(rs);
            }
            
            return null;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    
    }
    
    public Produto update(int id, String produto, String quantidade, String valor, String marca) {
        String sql = "update produto set produto = ?, marca = ?, quantidade = ?, valor = ? where id = ? RETURNING *;";
        PreparedStatement statement = null;
        ResultSet rs = null;
        
        try {
            statement = connection.prepareStatement(sql);
 
            statement.setString(1, produto);
            statement.setString(2, marca);
            statement.setInt(3, Integer.parseInt(quantidade));
            statement.setFloat(4, Float.parseFloat(valor));
            statement.setInt(5, id);
            
            rs = statement.executeQuery();
            if (rs.next()) {
                return ProductMapper.toEntity(rs);
            }

            return null;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public ArrayList<Produto> getAll() {
        String sql = "SELECT * FROM produto;";
        PreparedStatement statement = null;
        ResultSet rs = null;
        ArrayList<Produto> produtos = new ArrayList<>();
        
        try {
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            
            while (rs.next()) {
                produtos.add(ProductMapper.toEntity(rs));
            }
            
            return produtos;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return produtos;
        }
    }
    
    public int delete(int id) {
        String sql = "DELETE FROM produto WHERE produto.id = ?;";
        PreparedStatement statement = null;
        ResultSet rs = null;
        ArrayList<Produto> produtos = new ArrayList<>();
        
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            return statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
