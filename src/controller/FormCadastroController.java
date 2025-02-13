/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import view.FormCastroView;

/**
 *
 * @author alex
 */
public class FormCadastroController {
    /*Um controlador precisar de uma view para administrar/gerenciar
        Então vamos criar uma: */
    
    
    /* Essa view deve ser do tipo: FormCadastroView:
       pois vai administrar essa view, que fica no pacote view    
    */
    
    private FormCastroView view;

    public FormCadastroController(FormCastroView view) {
        this.view = view;
    }
    
    public void salvaUsuario(){
       
       String usuario = view.getjTextFieldUsuario().getText();
       String senha = view.getjPasswordFieldSenha().getText();
       
       Usuario usuarioXande = new Usuario(usuario, senha);
       
        try {
            Connection conexao = new Conexao().getConnection();
            UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
            usuarioDao.insert(usuarioXande);
            
            JOptionPane.showMessageDialog(null, "Usuário salvo com sucesso!");
            
        } catch (SQLException ex) {
            Logger.getLogger(FormCastroView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    
    }
}

    
