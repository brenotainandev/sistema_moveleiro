package br.edu.ifba.sistema_moveleiro.strategy;

public class CalculadoraDePreco {
    public double aplicarDesconto(double precoOriginal, DescontoStrategy strategy) {
        return strategy.calcular(precoOriginal);
    }
}
