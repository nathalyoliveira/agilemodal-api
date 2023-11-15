package br.com.fiap.agilemodalapi;

import java.util.List;

import br.com.fiap.agilemodalapi.exception.AgileModalError;
import br.com.fiap.agilemodalapi.model.VariacoesVeiculo;
import br.com.fiap.agilemodalapi.service.VariacaoVeiculoService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/variacoes")
public class VariacaoVeiculoResource {

	VariacaoVeiculoService service = new VariacaoVeiculoService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    public Response buscaVariacoes() {
    	List<VariacoesVeiculo> variacoes = null;
		try {
			variacoes = service.buscaVariacoes();
		} catch (Exception e) {
			return buildErrorResponse(Response.Status.INTERNAL_SERVER_ERROR, "Erro interno do servidor: " + e.getMessage());
		}
        return Response.ok(variacoes).build();
    }
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("id") Long id) {
		VariacoesVeiculo variacao = null;
		
		try {
			variacao = service.buscaVariacao(id);
		} catch (Exception e) {
			e.printStackTrace();
			return buildErrorResponse(Response.Status.INTERNAL_SERVER_ERROR, "Erro interno do servidor: " + e.getMessage());
		}
		
		if (variacao == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		return Response.ok(variacao).build();
		
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(VariacoesVeiculo variacao) {
		VariacoesVeiculo variacaoCriada = null;
		try {
			variacaoCriada = service.criaVariacaoVeiculo(variacao);
		} catch (Exception e) {
			return buildErrorResponse(Response.Status.INTERNAL_SERVER_ERROR, "Erro interno do servidor: " + e.getMessage());
		}
		
		return Response.ok(variacaoCriada).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response update(@PathParam("id") Long id, VariacoesVeiculo variacao) {
		VariacoesVeiculo variacaoEncontrada = null;
		try {
			variacaoEncontrada = service.buscaVariacao(id);
			if (variacaoEncontrada == null) 
				return Response.status(Response.Status.NOT_FOUND).build();
	
			variacaoEncontrada = service.atualizaVariacaoVeiculo(variacao);
			
		} catch (Exception e) {
			return buildErrorResponse(Response.Status.INTERNAL_SERVER_ERROR, "Erro interno do servidor: " + e.getMessage());
		}
		
		return Response.ok(variacaoEncontrada).build();
	}
	
	private Response buildErrorResponse(Response.Status status, String message) {
		AgileModalError errorResponse = new AgileModalError(status.getReasonPhrase(), message);
	    return Response.status(status).entity(errorResponse).build();
	}
}
