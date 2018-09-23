/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.si2016.DAO;

import br.com.si2016.models.Usuario;
import br.com.si2016.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public Boolean inserir(Usuario exemplo)
    {
        Boolean retorno = false;
        String sql = "INSERT INTO exemplo (nome, cpf, email, telefone, imagem) values (?,?,?,?,?)";
        
        PreparedStatement pst = ConnectionFactory.getPreparedStatement(sql);
        try
        {
            pst.setString(1, exemplo.getNome());
            pst.setString(2, exemplo.getCpf());
            pst.setString(3, exemplo.getEmail());
            pst.setString(4, exemplo.getTelefone());
            pst.setBytes(5, exemplo.getImagem());
            pst.executeUpdate();
            retorno = true;
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        return retorno;
    
    }
    
    public Usuario buscar(Integer id)
    {
        Usuario retorno = null;
        String sql = "SELECT id, imagem from exemplo where id=?";
        PreparedStatement pst = ConnectionFactory.getPreparedStatement(sql);
        
        try {
            pst.setInt(1, id); 
            ResultSet rs = pst.executeQuery();
            if(rs.next())
            {
                retorno = new Usuario();
                retorno.setId(rs.getLong("id"));
                retorno.setNome(rs.getString("nome"));
                retorno.setNome(rs.getString("cpf"));
                retorno.setNome(rs.getString("email"));
                retorno.setNome(rs.getString("telefone"));                
                retorno.setImagem(rs.getBytes("imagem"));
            
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            retorno = null;
        }
        
        return retorno;
    
    }
}
