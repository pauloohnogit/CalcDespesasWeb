package net.studyprojects.calcdespesas.model;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Uma Parcela pertence a uma Compra. Navegabilidade: Compra -> Parcela Foi
 * criada a data de lancamento da parcela em determinada fatura. Pode acontecer
 * de uma determinada parcela nao ter sido lancada no mes que deveria - ocorre
 * no Diners.
 * 
 * @author Paul
 * 
 */
@Entity
public class Parcela {

	@Id
	@GeneratedValue
	private Long id;
	@Temporal(TemporalType.DATE)
	private Calendar data;
	@Temporal(TemporalType.DATE)
	private Calendar dataDeLancamento;
	private BigDecimal valor;
	// private boolean paga;

	// Relationships

	@ManyToOne
	private Compra compra;

	@ManyToOne
	private Fatura fatura;

	public Parcela() {

	}

	public Parcela(Calendar data, BigDecimal valor, Compra compra,
			Calendar dataDeLancamento) {
		this.data = data;
		this.valor = valor;
		this.compra = compra;
		this.dataDeLancamento = dataDeLancamento;
	}

	// Getters & Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
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

	// Relationships

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
		if (!compra.getParcelas().contains(this)) {
			compra.getParcelas().add(this);
		}
	}

	public Fatura getFatura() {
		return fatura;
	}

	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
		if (!fatura.getParcelas().contains(this)) {
			fatura.getParcelas().add(this);
		}
	}

}
