/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import model.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserMapper {
    
    public static Usuario toEntity(ResultSet result) throws SQLException {
        Usuario usuario = new Usuario();
        
        usuario.setId(result.getInt("id"));
        usuario.setUsuario(result.getString("usuario"));
        usuario.setSenha(result.getString("senha"));
        
        return usuario;
    }
    
}
