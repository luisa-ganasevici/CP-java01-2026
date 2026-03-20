package br.com.fiap.util;

import br.com.fiap.anotacao.Descricao;
import jakarta.persistence.Table;

public class SQL {

    public String gerarSelect(Object obj) {
        Class<?> classe = obj.getClass();
        String tabela = getNomeTabela(classe);
        return "SELECT * FROM " + tabela;
    }

    public String gerarInsert(Object obj) {
        Class<?> classe = obj.getClass();
        String tabela = getNomeTabela(classe);
        return "INSERT INTO " + tabela + " (VALORES DO OBJETO VIA REFLECTION)";
    }

    public String gerarDelete(Object obj, Long id) {
        Class<?> classe = obj.getClass();
        String tabela = getNomeTabela(classe);
        return "DELETE FROM " + tabela + " WHERE id = " + id;
    }

    private String getNomeTabela(Class<?> classe) {

        if (classe.isAnnotationPresent(Descricao.class)) {
            return classe.getAnnotation(Descricao.class).descricao();
        } else if (classe.isAnnotationPresent(Table.class)) {
            return classe.getAnnotation(Table.class).name();
        }
        return classe.getSimpleName().toUpperCase();
    }
}