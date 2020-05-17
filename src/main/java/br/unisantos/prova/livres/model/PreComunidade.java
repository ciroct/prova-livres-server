package br.unisantos.prova.livres.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_precomunidade")
@NamedQueries({
	@NamedQuery(name = "PreComunidade.listarTodas", 
			    query = "select p from PreComunidade p"),
	@NamedQuery(name = "PreComunidade.consultarPorId", 
    			query = "select p from PreComunidade p where p.id=?1")
})
public class PreComunidade extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "nm_nome")
	private String nome;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "fk_precomunidade_id")
	private List<ConsumidorAvulso> consumidores;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "fk_calendario_id")
	private List<Calendario> calendarioEntrega;

	public PreComunidade() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ConsumidorAvulso> getConsumidores() {
		return consumidores;
	}

	public void setConsumidores(List<ConsumidorAvulso> consumidores) {
		this.consumidores = consumidores;
	}

	public List<Calendario> getCalendarioEntrega() {
		return calendarioEntrega;
	}

	public void setCalendarioEntrega(List<Calendario> calendarioEntrega) {
		this.calendarioEntrega = calendarioEntrega;
	}	

}
