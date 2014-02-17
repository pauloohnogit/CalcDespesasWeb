package net.studyprojects.calcdespesas.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.studyprojects.calcdespesas.dao.CartaoDeCreditoDao;
import net.studyprojects.calcdespesas.model.CartaoDeCredito;

public class JpaCartaoDeCreditoDao implements CartaoDeCreditoDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void adiciona(CartaoDeCredito cartaoDeCredito) {
	em.persist(cartaoDeCredito);
    }

    @Override
    public void remove(CartaoDeCredito cartaoDeCredito) {
	CartaoDeCredito cartaoARemover = buscaPorId(cartaoDeCredito.getId());
	em.remove(cartaoARemover);

    }

    @Override
    public void altera(CartaoDeCredito cartaoDeCredito) {
	em.merge(cartaoDeCredito);

    }

    @Override
    public CartaoDeCredito buscaPorId(Long id) {
	return em.find(CartaoDeCredito.class, id);
    }

    @Override
    public List<CartaoDeCredito> lista() {
	return em.createQuery("select c from CartaoDeCredito as c")
		.getResultList();
    }
}
