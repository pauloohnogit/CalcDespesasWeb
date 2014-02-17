package net.studyprojects.calcdespesas.dao;

import java.util.List;

import net.studyprojects.calcdespesas.model.CartaoDeCredito;

public interface CartaoDeCreditoDao {

    public void adiciona(CartaoDeCredito cartaoDeCredito);

    public void remove(CartaoDeCredito cartaoDeCredito);

    public void altera(CartaoDeCredito cartaoDeCredito);

    public CartaoDeCredito buscaPorId(Long id);

    public List<CartaoDeCredito> lista();

}
