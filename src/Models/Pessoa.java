/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author felip
 */
public class Pessoa 
{
    Integer Id;
    String Nome;
    String Cpf;
    String Email;
    String Telefone;
    
    public String getCpf() {
        return Cpf;
    }
    public void setCpf(String cpf) {
        this.Cpf = Cpf;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        this.Email = Email;

    }
    public Integer getId() {
        return Id;
    }
    public void setId(Long id) {
        this.Id = Id;
    } 
    public String getNome() { 
        return Nome;
    } 
    public void setNome(String nome) { 
        this.Nome = Nome;
    } 
    public String getTelefone() { 
        return Telefone;
    } 
    public void setTelefone(String telefone) { 
        this.Telefone = Telefone;
    } 
}