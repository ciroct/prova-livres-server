package br.unisantos.prova.livres.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tb_consumidor_avulso")
@NamedQueries({
	@NamedQuery(name = "ConsumidorAvulso.listarTodos", 
			    query = "select c from ConsumidorAvulso c order by c.nome"),
	@NamedQuery(name = "ConsumidorAvulso.consultarPorId", 
    			query = "select c from ConsumidorAvulso c where c.id=?1"),
	@NamedQuery(name = "ConsumidorAvulso.listarPorPreComunidade", 
				query = "select c from PreComunidade p join p.consumidores c where p.id=?1")
})
public class ConsumidorAvulso extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "nm_nome", length = 60)
	private String nome;
	@Column(name = "nm_telefone", length = 20)
	private String telefone;

	public ConsumidorAvulso() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
		
}
