package br.unisantos.prova.livres.resources;

import javax.ws.rs.core.Response;

public interface ResourcesInterface<T> {
	
	Response getAll();
	
	Response getById(Long id);
	
	Response post(T obj);

	Response put(T obj);

	Response delete(Long id);

}
