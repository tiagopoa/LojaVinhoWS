/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author objectedge-169
 */
@XmlRootElement
public class Venda implements Serializable {
    private int id, valorTotal;  
    private String codigo, data, cliente, itens;    
    
    //private String[] = new itens[];
    
        public Venda() {
    }

    public Venda(int id, String codigo, String data, String cliente, String itens, int valorTotal) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.codigo = codigo;
        this.data = data;
        this.cliente = cliente;
        this.itens = itens;
    }

   // public Venda(int id, String codigo, String data, String cliente, String itens, int valorTotal) {
   //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   // }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getItens() {
        return itens;
    }

    public void setItens(String itens) {
        this.itens = itens;
    }

   

    

   

}