/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import model.Usuario;
import view.LoginView;
import view.MenuView;

/**
 *
 * @author alex
 */
public class LoginController {

    private LoginView view;

    public LoginController(LoginView view) {
        this.view = view;
    }

    public void autenticar() {
        //buscar um usuário da view

        String usuario = view.getjTextFieldUsuario().getText();
        String senha = view.getjPasswordFieldSenha().getText();

        Usuario usuarioAutenticar = new Usuario(usuario, senha);
        
        //Verificar se existe no banco de dados
        Connection conexao = new Conexao().getConnection();
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);

        usuarioDao.existePorUsuarioESenha(usuarioAutenticar);
        // se direcionar no menu
        

        MenuView telaDeMenu = new MenuView();
        telaDeMenu.setVisible(true);
    }

}
