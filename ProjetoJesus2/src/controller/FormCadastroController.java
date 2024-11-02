/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;
import view.FormCadastroView;

/**
 *
 * @author digom
 */
public class FormCadastroController {
    
    private FormCadastroView view;
 
    public FormCadastroController(FormCadastroView view) {
        this.view = view;
    }
    
    public void salvaUsuario(){
        
        
    
        String usuario = view.getjTextFieldUsuario().getText();
        String senha = view.getjPasswordFieldSenha().getText();
        
        Usuario usuarioescrito = new Usuario(usuario, senha);
        

        try {
           Connection conexao = new Conexao().getConnection();
           UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
           usuarioDao.insert(usuarioescrito);
           
            JOptionPane.showMessageDialog(null, "Usuario Salvo com sucesso!!");
           
           
        } catch (SQLException ex) {
            Logger.getLogger(FormCadastroView.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    
}
