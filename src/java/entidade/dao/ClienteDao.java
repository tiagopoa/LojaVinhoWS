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
import entidade.Cliente;
import java.util.List;

public interface ClienteDao {
    public void inserir(Cliente c);
    public void deletar(int id);
    public void atualizar(int id,Cliente c);
    public List<Cliente> listar();
    public Cliente buscarPorId(int id);
    
}
