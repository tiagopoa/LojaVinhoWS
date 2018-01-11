/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade.dao;

import entidade.Produto;
import entidade.Venda;
import java.sql.Array;
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
 * @author objectedge-169
 */
public class VendaDaoBd implements VendaDao { 

    @Override
    public void inserir(Venda v) {
        try {
            Connection conexao = ConnectionFactory.getConnection();

            String sql = "INSERT INTO venda(codigo,data,cliente,itens,valortotal) VALUES (?,?,?,?,?)";

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, v.getCodigo());
            comando.setString(2, v.getData());
            comando.setString(3, v.getCliente());
            comando.setString(4, v.getItens());
            comando.setInt(5, v.getValorTotal());

            comando.executeUpdate();

            //Passo 5: fechar conexao
            comando.close();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(VendaDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void deletar(int id) {
        try {
            Connection conexao = ConnectionFactory.getConnection();

            String sql = "DELETE FROM venda WHERE id=?";

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, id);

            comando.executeUpdate();

            //Passo 5: fechar conexao
            comando.close();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(VendaDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  @Override
    public void atualizar(int id,Venda v) {
        try {
            Connection conexao = ConnectionFactory.getConnection();
            
            System.out.println(id + " " + v.getData() + " " + v.getCliente() + " " + v.getItens() + " " + v.getValorTotal());

            String sql = "UPDATE venda SET data=?, "
                    + "cliente=?, "
                    + "itens=?, "
                    + "valortotal=? "
                    + "WHERE id=?";

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, v.getData());          
            comando.setString(2, v.getCliente());
            comando.setString(3, v.getItens());
            comando.setInt(4, v.getValorTotal());
            comando.setInt(5, v.getId());
                       
            
            comando.executeUpdate();

            //Passo 5: fechar conexao
            comando.close();
            conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Venda> listar() {
        try {
            Connection conexao = ConnectionFactory.getConnection();

            //Passo 3 e 4: Comando
            String sql = "SELECT * FROM venda";

            List<Venda> listaVendas = new ArrayList<>();

            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                int id = resultado.getInt("id");
                String codigo = resultado.getString("codigo");
                String data = resultado.getString("data");               
                String cliente = resultado.getString("cliente");   
                String itens =  resultado.getString("itens");   
                int valorTotal = resultado.getInt("valortotal");   
                Venda v = new Venda(id, codigo, data, cliente, itens, valorTotal);
                listaVendas.add(v);

            }

            //Passo 5: fechar conexao
            comando.close();
            conexao.close();

            return listaVendas;

        } catch (SQLException ex) {
            Logger.getLogger(VendaDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Venda buscarPorId(int id) {
        try {
            Connection conexao = ConnectionFactory.getConnection();

            //Passo 3 e 4: Comando
            String sql = "SELECT * FROM venda WHERE id=?";

            Venda venda = null;

            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, id);

            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                id = resultado.getInt("id");
                String codigo = resultado.getString("codigo");
                String data = resultado.getString("data");               
                String cliente = resultado.getString("cliente");   
                String itens = resultado.getString("itens");   
                int valorTotal = resultado.getInt("valortotal");   
                venda = new Venda(id, codigo, data, cliente, itens, valorTotal);
            }

            //Passo 5: fechar conexao
            comando.close();
            conexao.close();

            return venda;

        } catch (SQLException ex) {
            Logger.getLogger(VendaDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }



}


