/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;
import view.FormCadastroView;


/**
 *
 * @author digom
 */

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
            var rs = statement.executeQuery();
            if(rs.next()){
                Usuario Merdademacaco = convert(rs);
                System.out.println(Merdademacaco);
                return Merdademacaco;
                }
            return null;
            
            
            
            
                 
        
            
           
                              
             
    }    
    
    public static Usuario convert(ResultSet result) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setId(result.getInt("id"));
        usuario.setUsuario(result.getString("usuario"));
        usuario.setSenha(result.getString("senha"));

        return usuario;
    }

    public Usuario update(Usuario usuario) throws SQLException{
        String sql = "update usuario set usuario = ?, senha = ? where id = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, usuario.getUsuario());
        statement.setString(2, usuario.getSenha());
        statement.setInt(3, usuario.getId());
        
        statement.execute();
        return null;
       
    }
    
    public Usuario insertOrUpdate(Usuario usuario) throws SQLException{
        if(usuario.getId > 0){
            update(usuario);
        }else{
            insert(usuario);
        }
        return null;
    }
    
    public Usuario delete(Usuario usuario) throws SQLException{
        String sql = "delete from usuario where id = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1, usuario.getId());                
        statement.execute();                
        return null;
    }
    public ArrayList<Usuario> selectAll() throws SQLException{
        String sql = "select * from usuario";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        return pesquisa(statement);
    }

    private ArrayList<Usuario> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        while (resultSet.next()){
            int id = resultSet.getInt("ID");
            String usuario = resultSet.getString("usuario");            
            String senha = resultSet.getString("senha");
            
            Usuario usuarioComDadosDoBanco = new Usuario(id, usuario, senha);
            usuarios.add(usuarioComDadosDoBanco);
        }
        return usuarios;
    }
    
    public Usuario selectPorId(Usuario usuario) throws SQLException{
        String sql = "select * from usuario where ID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, usuario.getId());
        
        return pesquisa(statement).get(0);
        
        
    }
    
    
    public boolean existePorUsuarioESenha(Usuario usuario) throws SQLException {
        String sql = "select * from usuario where usuario = ? and senha = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, usuario.getUsuario());
        statement.setString(2, usuario.getSenha());
        statement.execute();
        
        ResultSet resultSet = statement.getResultSet();
                        
        return resultSet.next();
    }

    private  class ArrayListi<Usuario> {

        public ArrayListi() {
        }
    }

    




}
