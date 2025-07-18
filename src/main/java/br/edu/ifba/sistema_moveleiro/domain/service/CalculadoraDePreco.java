package br.edu.ifba.sistema_moveleiro.domain.service;

import br.edu.ifba.sistema_moveleiro.domain.strategy.DescontoStrategy;

public class CalculadoraDePreco {
    public double aplicarDesconto(double precoOriginal, DescontoStrategy strategy) {
        return strategy.calcular(precoOriginal);
    }
}
