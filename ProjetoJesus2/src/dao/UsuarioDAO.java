/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import mappers.UserMapper;
import model.Usuario;


public class UsuarioDAO {
    
    private final Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }
    
    public Usuario insert(Usuario usuario) throws SQLException{

        String sql = "insert into usuario(usuario,senha) values(?,?) returning * ; "; 
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usuario.getUsuario());
        statement.setString(2, usuario.getSenha());
        
        ResultSet rs = statement.executeQuery();

        if(rs.next()){
            Usuario novoUsuario = UserMapper.toEntity(rs);
            return novoUsuario;
        }

        return null;        
    }    
    
    public Boolean login(String usuario, String senha) {
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(
                    "SELECT * "
                            + "FROM usuario "
                            + "WHERE "
                            + "usuario.usuario = ? "
                            + "AND usuario.senha = ?"
            );

            statement.setString(1, usuario);
            statement.setString(2, senha);
            rs = statement.executeQuery();

            if (rs.next()) {
                return true;
            }
            return false;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } 
    }
}
