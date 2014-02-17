package net.studyprojects.calcdespesas.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Compra {

	// Compra: nome, descricao, data da compra, valor, no_parcelas (dado pelo
	// list.size)

	public Compra() {

	}

	// Construtor para o CompraBuilder
	public Compra(String titulo, String descricao, Calendar data,
			BigDecimal valor, Integer numeroDeParcelas) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = data;
		this.valor = valor;
		this.numeroDeParcelas = numeroDeParcelas;
		this.parcelas = new ArrayList<>();
	}

	@Id
	@GeneratedValue
	private Long id;
	private String titulo;
	private String descricao;
	@Temporal(TemporalType.DATE)
	private Calendar data;
	private BigDecimal valor;
	private Integer numeroDeParcelas;

	// Relationships

	// @OneToMany - 1 Compra : N Parcelas
	@OneToMany(mappedBy = "compra")
	private List<Parcela> parcelas;

	@ManyToOne
	private CartaoDeCredito cartaoDeCredito;

	// Getters & Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}

	// Relationships

	public List<Parcela> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<Parcela> parcelas) {
		this.parcelas = parcelas;
	}

	public CartaoDeCredito getCartaoDeCredito() {
		return cartaoDeCredito;
	}

	public void setCartaoDeCredito(CartaoDeCredito cartaoDeCredito) {
		this.cartaoDeCredito = cartaoDeCredito;
	}

	public void addParcela(Parcela parcela) {
		this.parcelas.add(parcela);
		if (parcela.getCompra() != this) {
			parcela.setCompra(this);
		}
	}

}
