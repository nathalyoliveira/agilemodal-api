package br.com.fiap.agilemodalapi;

import java.util.List;

import br.com.fiap.agilemodalapi.exception.AgileModalError;
import br.com.fiap.agilemodalapi.model.Chamado;
import br.com.fiap.agilemodalapi.service.ChamadoService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/chamados")
public class ChamadoResource {
	
	ChamadoService service = new ChamadoService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    public Response buscaChamados() {
    	List<Chamado> chamados = null;
		try {
			chamados = service.buscaChamados();
		} catch (Exception e) {
			return buildErrorResponse(Response.Status.INTERNAL_SERVER_ERROR, "Erro interno do servidor: " + e.getMessage());
		}
        return Response.ok(chamados).build();
    }
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("id") Long id) {
		Chamado chamado = null;
		
		try {
			chamado = service.buscaChamado(id);
		} catch (Exception e) {
			return buildErrorResponse(Response.Status.INTERNAL_SERVER_ERROR, "Erro interno do servidor: " + e.getMessage());
		}
		
		if (chamado == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		return Response.ok(chamado).build();
		
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(Chamado chamado) {
		Chamado chamadoCriado = null;
		try {
			chamadoCriado = service.criaChamado(chamado);
		} catch (Exception e) {
			return buildErrorResponse(Response.Status.INTERNAL_SERVER_ERROR, "Erro interno do servidor: " + e.getMessage());
		}
		
		return Response.ok(chamadoCriado).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response update(@PathParam("id") Long id, Chamado chamado) {
		Chamado chamadoEncontrado = null;
		try {
			chamadoEncontrado = service.buscaChamado(id);
			if (chamadoEncontrado == null) 
				return Response.status(Response.Status.NOT_FOUND).build();
			
			if (!service.atualizaChamado(chamado)) 
				return Response.status(Response.Status.BAD_REQUEST).build();			
			
		} catch (Exception e) {
			return buildErrorResponse(Response.Status.INTERNAL_SERVER_ERROR, "Erro interno do servidor: " + e.getMessage());
		}
		
		return Response.ok(chamado).build();
	}
	
	private Response buildErrorResponse(Response.Status status, String message) {
		AgileModalError errorResponse = new AgileModalError(status.getReasonPhrase(), message);
	    return Response.status(status).entity(errorResponse).build();
	}
}
