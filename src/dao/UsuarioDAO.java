/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;
import view.FormCastroView;

/**
 *
 * @author alex,
 *
 * Essa classe usuarioDAO será responsável por criar, deletar e manipular um
 * usuário através do banco de dados.
 */
public class UsuarioDAO {

    private final Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Usuario usuario) throws SQLException {

        String sql = "insert into usuario (usuario, senha) values('" + usuario.getUsuario() + "', '" + usuario.getSenha() + "');";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        connection.close();

    }

    public boolean existeNoBancoPorUsuarioESenha(Usuario usuario) throws SQLException {
        String sql = "select * from usuario where usuario = '"+ usuario.getUsuario()+"' and senha = '"+ usuario.getSenha() +"' ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
        
        ResultSet resultSet = statement.getResultSet();        
        return resultSet.next();
        
        
        
    }

}
