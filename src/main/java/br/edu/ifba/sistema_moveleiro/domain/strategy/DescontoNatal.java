package br.edu.ifba.sistema_moveleiro.domain.strategy;

public class DescontoNatal implements DescontoStrategy {
    @Override
    public double calcular(double precoOriginal) {
        return precoOriginal * 0.9;
    }
}
