package br.edu.ifba.sistema_moveleiro.domain.strategy;

public class DescontoBlackFriday implements DescontoStrategy {
    @Override
    public double calcular(double precoOriginal) {
        return precoOriginal * 0.7;
    }
}
