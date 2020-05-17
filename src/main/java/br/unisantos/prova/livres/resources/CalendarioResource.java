package br.unisantos.prova.livres.resources;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.unisantos.prova.livres.model.Calendario;
import br.unisantos.prova.livres.model.dao.DAO;

@Path("/calendario")
public class CalendarioResource implements ResourcesInterface<Calendario> {

	@Override
	public Response getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@GET
	@Path("/precomunidade/{id}/{data}")
	@Produces("application/json")
	public Response getByPreComunidade(@PathParam("id") Long id,
			@PathParam("data") String data) {
		final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date _data;
		try {
			_data = dateFormat.parse(data);
		} catch (ParseException e) {			
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		DAO<Calendario> dao = new DAO<>(Calendario.class);
		List<Calendario> _entrega = dao.listarGenerico("Calendario.listarPorPreComunidade", id, _data);		
		return Response.ok(_entrega).build();
	}

	
	@Override
	public Response post(Calendario obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response put(Calendario obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
