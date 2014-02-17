package net.studyprojects.calcdespesas.model;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Toda Despesa estara associada a uma parcela de uma compra. Isto permite que
 * dada uma parcela, nao necessariamente ela sera lancada na fatura daquele mes.
 * 
 * @author paulo.nonaka
 * 
 */

@Entity
public class Despesa {

	@Id
	@GeneratedValue
	private Long id;

	// private double fracao;

	private BigDecimal valor;

	@Temporal(TemporalType.DATE)
	private Calendar dataDeLancamento;

	// Relacionamentos
	// @OneToOne
	// private Parcela parcela;

	// Construtores
	public Despesa() {

	}

	public Despesa(BigDecimal valor, Calendar dataDeLancamento, Parcela parcela) {
		this.valor = valor;
		this.dataDeLancamento = dataDeLancamento;
		// this.parcela = parcela;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Calendar getDataDeLancamento() {
		return dataDeLancamento;
	}

	public void setDataDeLancamento(Calendar dataDeLancamento) {
		this.dataDeLancamento = dataDeLancamento;
	}

	// public Parcela getParcela() {
	// return parcela;
	// }
	//
	// public void setParcela(Parcela parcela) {
	// this.parcela = parcela;
	// }

}
