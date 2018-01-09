/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.dao;

/**
 *
 * @author objectedge-169
 */
import entidade.Venda;
import java.util.List;

public interface VendaDao {
    public void inserir(Venda v);
    public void deletar(int id);
    public void atualizar(int id,Venda v);
    public List<Venda> listar();
    public Venda buscarPorId(int id);
    
}