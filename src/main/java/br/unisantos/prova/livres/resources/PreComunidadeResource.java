package br.unisantos.prova.livres.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.unisantos.prova.livres.model.PreComunidade;
import br.unisantos.prova.livres.model.dao.DAO;

@Path("/pre_comunidades")
public class PreComunidadeResource implements ResourcesInterface<PreComunidade> {

	@Override
	@GET
	@Produces("application/json")
	public Response getAll() {
		DAO<PreComunidade> dao = new DAO<>(PreComunidade.class);
		List<PreComunidade> _preComunidades = dao.listarGenerico("PreComunidade.listarTodas");
		return Response.ok(_preComunidades).build();
	}

	@Override
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response getById(@PathParam("id") Long id) {
		DAO<PreComunidade> dao = new DAO<>(PreComunidade.class);
		PreComunidade _preComunidade = dao.consultar(id);
		if (_preComunidade != null) {
			return Response.ok(_preComunidade).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}

	
	@Override
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response post(PreComunidade obj) {
		DAO<PreComunidade> dao = new DAO<>(PreComunidade.class);
		dao.adicionar(obj);
		return Response.ok(obj).build();
	}

	@Override
	public Response put(PreComunidade obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
