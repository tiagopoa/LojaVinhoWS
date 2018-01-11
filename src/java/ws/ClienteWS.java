/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;
import entidade.Cliente;
import entidade.dao.ClienteDaoBd;
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
@Path("/clientes")
public class ClienteWS {

    @Context
    private UriInfo context;
    static List<Cliente> listaClientes = new ArrayList<>();

    
    private ClienteDaoBd clienteDao;
    private int id;
    /**
     * Creates a new instance of MotorWS
     */
    public ClienteWS() {
        clienteDao = new ClienteDaoBd();
    }

    /**
     * Retrieves representation of an instance of ws.MotorWS
     * @return an instance of entidade.Motor
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> getClientesss() {
        return clienteDao.listar();           
    }    

    /**
     * PUT method for updating or creating an instance of MotorWS
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserirCliente(Cliente cliente) {
        clienteDao.inserir(cliente);
    }
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void editarCliente(@PathParam("id") int id, Cliente cliente) {
        cliente.setId(id);
        clienteDao.atualizar(id,cliente);
    }
    
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void removerCliente(@PathParam("id") int id) { 
        clienteDao.deletar(id);
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente buscarPorId(@PathParam("id") int id) {
        return clienteDao.buscarPorId(id);
    }
    
}
