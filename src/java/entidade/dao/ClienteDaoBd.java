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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lhries
 */
public class ClienteDaoBd implements ClienteDao {

    @Override
    public void inserir(Cliente c) {
        try {
            Connection conexao = ConnectionFactory.getConnection();

            String sql = "INSERT INTO cliente(nome,cpf) VALUES (?,?)";

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, c.getNome());
            comando.setString(2, c.getCpf());

            comando.executeUpdate();

            //Passo 5: fechar conexao
            comando.close();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void deletar(int id) {
        try {
            Connection conexao = ConnectionFactory.getConnection();

            String sql = "DELETE FROM cliente WHERE id=?";

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, id);

            comando.executeUpdate();

            //Passo 5: fechar conexao
            comando.close();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void atualizar(int id,Cliente c) {
        try {
            Connection conexao = ConnectionFactory.getConnection();
            
            System.out.println(id + " " + c.getNome() + " " + c.getCpf());

            String sql = "UPDATE cliente SET nome=?, "
                    + "cpf=? "
                    + "WHERE id=?";

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, c.getNome());          
            comando.setString(2, c.getCpf());
            comando.setInt(3, c.getId());
                       
            
            comando.executeUpdate();

            //Passo 5: fechar conexao
            comando.close();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Cliente> listar() {
        try {
            Connection conexao = ConnectionFactory.getConnection();

            //Passo 3 e 4: Comando
            String sql = "SELECT * FROM cliente";

            List<Cliente> listaClientes = new ArrayList<>();

            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");                
                String cpf = resultado.getString("cpf");               
                Cliente c = new Cliente(id, nome, cpf);
                listaClientes.add(c);

            }

            //Passo 5: fechar conexao
            comando.close();
            conexao.close();

            return listaClientes;

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Cliente buscarPorId(int id) {
        try {
            Connection conexao = ConnectionFactory.getConnection();

            //Passo 3 e 4: Comando
            String sql = "SELECT * FROM cliente WHERE id=?";

            Cliente cliente = null;

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, id);

            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                id = resultado.getInt("id");
                String nome = resultado.getString("nome");                
                String cpf = resultado.getString("cpf");               
                cliente = new Cliente(id, nome, cpf);
            }

            //Passo 5: fechar conexao
            comando.close();
            conexao.close();

            return cliente;

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }



}
