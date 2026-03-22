package br.com.fiap.funcionario;

import br.com.fiap.anotacao.Descricao;
import jakarta.persistence.*;

@Descricao(descricao = "senior")
@Entity


public class Senior extends Funcionario {

    public Senior() {
    }
    @Column(name = "colunaAvaliarRelatorio")

    protected String avaliarRelatorio;


    public Senior(String nome, int horasTrabalhadas, double valorHora, String avaliarRelatorio) {

        super(nome, horasTrabalhadas, valorHora);

        this.avaliarRelatorio = avaliarRelatorio;

    }

    public String getAvaliarRelatorio() {

        return avaliarRelatorio;

    }

    public void setAvaliarRelatorio(String avaliarRelatorio) {

        this.avaliarRelatorio = avaliarRelatorio;

    }

    @Override
    public double calcularSalario() {

        double salarioNormal = horasTrabalhadas * valorHora;
        int quantidadeBonus = horasTrabalhadas / 15;
        double bonus = quantidadeBonus * valorHora;
        return salarioNormal + bonus;

    }

    @Override
    public void imprimirInformacao() {

        System.out.println("nome do sênior: " + nome);
        System.out.println("horas trabalhadas: " + horasTrabalhadas);
        System.out.println("valor por hora: " + valorHora);
        System.out.println("avaliação do relatório: " + avaliarRelatorio);
        System.out.println("salário final com o bonus: " + calcularSalario());

    }
}