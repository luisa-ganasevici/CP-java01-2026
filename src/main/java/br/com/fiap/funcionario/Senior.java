package br.com.fiap.funcionario;

import jakarta.persistence.*;

@Entity
@Table(name = "Senior")

public class Senior extends Funcionario {

    @Id
    @GeneratedValue
    @Column(name = "colunaAvaliarRelatório")

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
    public void infoFuncionario() {

        System.out.println("Funcionário Sênior: " + nome);
        System.out.println("Horas trabalhadas: " + horasTrabalhadas);
        System.out.println("Valor por hora: " + valorHora);
        System.out.println("Avaliação do relatório: " + avaliarRelatorio);
        System.out.println("Salário final com bônus: " + calcularSalario());

    }
}