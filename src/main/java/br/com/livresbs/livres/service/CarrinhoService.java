package br.com.livresbs.livres.service;

import br.com.livresbs.livres.dto.CarrinhoDTO;

public interface CarrinhoService {
    void sincronizarProduto(String cpf, Long cotacaoId, Double quantidade);
    CarrinhoDTO listarCarrinhos(String cpf);
}
