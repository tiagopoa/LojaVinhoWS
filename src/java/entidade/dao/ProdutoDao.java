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
import entidade.Produto;
import java.util.List;

public interface ProdutoDao {
    public void inserir(Produto p);
    public void deletar(int id);
    public void atualizar(int id,Produto c);
    public List<Produto> listar();
    public Produto buscarPorId(int id);
    
}
