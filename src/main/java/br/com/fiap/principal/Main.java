package br.com.fiap.principal;


import br.com.fiap.funcionario.Funcionario;
import br.com.fiap.util.SQL;

public class Main {
    public static void main(String[] args) {
        Funcionario f = new Funcionario("Ana", 160, 20);

        SQL sql = new SQL();
        sql.gerarSelect(f);
    }
}