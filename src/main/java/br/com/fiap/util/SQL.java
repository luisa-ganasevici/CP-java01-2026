package br.com.fiap.util;

import br.com.fiap.anotacao.Descricao;

public class SQL {

    public void gerarSelect(Object obj) {

        Class classe = obj.getClass();

        Descricao descricao = (Descricao) classe.getAnnotation(Descricao.class);

        if (descricao != null) {

            String nomeTabela = descricao.descricao();

            String sql = "SELECT * FROM " + nomeTabela;

            System.out.println(sql);
        }
    }
}