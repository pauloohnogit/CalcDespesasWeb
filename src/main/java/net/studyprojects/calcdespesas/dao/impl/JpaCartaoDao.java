package net.studyprojects.calcdespesas.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import net.studyprojects.calcdespesas.dao.DAO;
import net.studyprojects.calcdespesas.model.Cartao;

/**
 * Ideia para colocar um Dao mais generico e com menos repeticao de codigo.
 * Pendencia: Como usar Dao Generico com o Spring MVC
 */

public class JpaCartaoDao {

    private final DAO<Cartao> dao;

    public JpaCartaoDao(EntityManager em) {
	dao = new DAO<Cartao>(em, Cartao.class);
    }

    public void adiciona(Cartao t) {
	dao.adiciona(t);
    }

    public Cartao busca(Long id) {
	return dao.busca(id);
    }

    public List<Cartao> lista() {
	return dao.lista();
    }

    public void remove(Cartao t) {
	dao.remove(t);
    }

    public void altera(Cartao t) {
	dao.altera(t);
    }

}
