package br.unisantos.prova.livres.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.unisantos.prova.livres.model.ConsumidorAvulso;
import br.unisantos.prova.livres.model.dao.DAO;

@Path("/consumidores_avulsos")
public class ConsumidorAvulsoResource implements ResourcesInterface<ConsumidorAvulso> {

	@Override
	@GET
	@Produces("application/json")
	public Response getAll() {
		DAO<ConsumidorAvulso> dao = new DAO<>(ConsumidorAvulso.class);
		List<ConsumidorAvulso> _consumidores = dao.listarGenerico("ConsumidorAvulso.listarTodos");
		return Response.ok(_consumidores).build();
	}

	@Override
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response getById(@PathParam("id") Long id) {
		DAO<ConsumidorAvulso> dao = new DAO<>(ConsumidorAvulso.class);
		ConsumidorAvulso _consumidor = dao.consultarGenerico("ConsumidorAvulso.consultarPorId", id);
		if (_consumidor != null) {
			return Response.ok(_consumidor).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}

	@GET
	@Path("/precomunidade/{id}")
	@Produces("application/json")
	public Response getByPreComunidade(@PathParam("id") Long id) {
		DAO<ConsumidorAvulso> dao = new DAO<>(ConsumidorAvulso.class);
		List<ConsumidorAvulso> _consumidores = dao.listarGenerico("ConsumidorAvulso.listarPorPreComunidade");
		return Response.ok(_consumidores).build();
	}
	
	@Override
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response post(ConsumidorAvulso obj) {
		DAO<ConsumidorAvulso> dao = new DAO<>(ConsumidorAvulso.class);
		dao.adicionar(obj);
		return Response.ok(obj).build();
	}

	@Override
	@PUT
	@Produces("application/json")
	@Consumes("application/json")
	public Response put(ConsumidorAvulso obj) {
		DAO<ConsumidorAvulso> dao = new DAO<>(ConsumidorAvulso.class);
		dao.alterar(obj);
		return Response.ok(obj).build();
	}

	@Override
	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	public Response delete(@PathParam("id") Long id) {
		DAO<ConsumidorAvulso> dao = new DAO<>(ConsumidorAvulso.class);
		if (dao.excluir(id)) {
			return Response.ok().build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}

}
