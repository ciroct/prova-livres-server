package br.unisantos.prova.livres.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_calendario")
@NamedQuery(name = "Calendario.listarPorPreComunidade",
            query = "select c from PreComunidade p join p.calendarioEntrega c where p.id=?1 and c.dataEntrega >= ?2")
public class Calendario extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "dt_data_entrega")
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dataEntrega;

	public Calendario() {
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	} 
	
}
