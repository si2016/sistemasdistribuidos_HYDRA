/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Usuario;
import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author felip
 */
public class UsuarioDAO 
{ 
    private Connection connection;
    Long id;
    String nome;
    String cpf;
    String email;
    String telefone;
    public UsuarioDAO(){ 
        this.connection = new ConnectionFactory().getConnection();
    } 
    public void adiciona(Usuario usuario){ 
        String sql = "INSERT INTO usuario(nome,cpf,email,telefone) VALUES(?,?,?,?)";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getTelefone());
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) 
        { 
            throw new RuntimeException(u);
        } 
        
    } 
}
