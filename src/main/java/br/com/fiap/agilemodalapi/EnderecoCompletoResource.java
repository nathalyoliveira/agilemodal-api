package br.com.fiap.agilemodalapi;

import br.com.fiap.agilemodalapi.exception.AgileModalError;
import br.com.fiap.agilemodalapi.model.EnderecoCompleto;
import br.com.fiap.agilemodalapi.service.EnderecoCompletoService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/endereco")
public class EnderecoCompletoResource {

	EnderecoCompletoService service = new EnderecoCompletoService();
	
	@GET
	@Path("{cep}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findByCep(@PathParam("cep") Long cep) {
		EnderecoCompleto endereco = null;
		
		try {
			endereco = service.buscarEnderecoPorCep(cep);
		} catch (Exception e) {
			e.printStackTrace();
			return buildErrorResponse(Response.Status.INTERNAL_SERVER_ERROR, "Erro interno do servidor: " + e.getMessage());
		}
		
		if (endereco == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		return Response.ok(endereco).build();
		
	}
	
	private Response buildErrorResponse(Response.Status status, String message) {
		AgileModalError errorResponse = new AgileModalError(status.getReasonPhrase(), message);
	    return Response.status(status).entity(errorResponse).build();
	}
}
