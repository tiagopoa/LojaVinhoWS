/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;


import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author objectedge-169
 */
@XmlRootElement
public class Cliente implements Serializable {
    private int id;
    private double valor;
    private String nome, cpf;

    public Cliente() {
    }

    public Cliente(int id, String nome, String cpf, double valor) {
        this.id = id;
        this.valor = valor;
        this.nome = nome;
        this.cpf = cpf;
    }

    //public Cliente(int id, String nome, String cpf, double valor) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    


   

       
}
