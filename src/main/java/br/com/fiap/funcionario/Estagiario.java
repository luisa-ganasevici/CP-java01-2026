package br.com.fiap.funcionario;

import br.com.fiap.anotacao.Descricao;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import jakarta.persistence.*;


@Descricao(descricao = "estagiário")
@Entity


public class Estagiario extends Funcionario {

    @Column(name = "colunarelatorio")
    private String relatorio;

    public Estagiario() {
    }

    public Estagiario(String nome, int horasTrabalhadas, double valorHora, String relatorio) {
        super(nome, horasTrabalhadas, valorHora);
        this.relatorio = relatorio;
    }

    public String getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(String relatorio) {
        this.relatorio = relatorio;
    }

    @Override
    public double calcularSalario() {

        double salarioNormal = horasTrabalhadas * valorHora;
        return salarioNormal * 0.8;

    }

    @Override
    public void imprimirInformacao() {

        System.out.println("nome do estagiário: " + nome);
        System.out.println("horas trabalhadas: " + horasTrabalhadas);
        System.out.println("valor por hora: " + valorHora);
        System.out.println("relatorio: " + relatorio);
        System.out.println("salário final: " + calcularSalario());

    }
}