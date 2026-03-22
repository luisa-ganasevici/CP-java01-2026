package br.com.fiap.funcionario;

import br.com.fiap.anotacao.Descricao;
import jakarta.persistence.*;

@Descricao(descricao = "funcionario")
@Entity
@Table(name = "funcionario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Funcionario {

    @Id
    @GeneratedValue

    @Column(name = "colunaId")
    private Long id;

    @Column(name ="colunaNome")
    protected String nome;

    @Column(name = "colunaHorasDeTrabalho")
    protected int horasTrabalhadas;

    @Column(name ="colunaValorHora")
    protected double valorHora;

    public Funcionario() {

    }

    public Funcionario(String nome, int horasTrabalhadas, double valorHora) {
        this.nome = nome;
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
    }

    public double calcularSalario() {

        return horasTrabalhadas * valorHora;

    }

    public void imprimirInformacao() {

        System.out.println("funcionario" + nome);
        System.out.println("quantidade de horas de trabalho " + horasTrabalhadas);
        System.out.println("quanto ganhou por hora" + valorHora);
        System.out.println("salario " + calcularSalario());

    }


    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }
    public double getValorHora() {
        return valorHora;
    }
}