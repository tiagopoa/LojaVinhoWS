/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;
import entidade.Venda;
import entidade.dao.VendaDaoBd;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
/**
 *
 * @author objectedge-169
 */
@Path("/vendas")
public class VendaWS {

    @Context
    private UriInfo context;
    static List<Venda> listaVendas = new ArrayList<>();

    
    private VendaDaoBd vendaDao;
    private int id;
    /**
     * Creates a new instance of MotorWS
     */
    public VendaWS() {
        vendaDao = new VendaDaoBd();
    }

    /**
     * Retrieves representation of an instance of ws.MotorWS
     * @return an instance of entidade.Motor
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Venda> getVenda() {
        return vendaDao.listar();        
    }

    /**
     * PUT method for updating or creating an instance of MotorWS
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserirVenda(Venda venda) {
        vendaDao.inserir(venda);
    }
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void editarVenda(@PathParam("id") int id, Venda venda) {
        venda.setId(id);
        vendaDao.atualizar(id,venda);
    }
    
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void removerVenda(@PathParam("id") int id) { 
        vendaDao.deletar(id);
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Venda buscarPorId(@PathParam("id") int id) {
        return vendaDao.buscarPorId(id);
    }
    
}

