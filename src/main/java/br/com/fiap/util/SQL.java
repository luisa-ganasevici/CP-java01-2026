package br.com.fiap.util;

import br.com.fiap.anotacao.Descricao;
import jakarta.persistence.Table;

import java.lang.reflect.Field;

public class SQL {

    public String gerarSelect(Object obj) {
        String tabela = getNomeTabela(obj.getClass());
        return "SELECT * FROM " + tabela;
    }

    public String gerarInsert(Object obj) {
        Class<?> classe = obj.getClass();
        String tabela = getNomeTabela(classe);

        StringBuilder colunas = new StringBuilder();
        StringBuilder valores = new StringBuilder();

        Field[] fields = classe.getSuperclass().getDeclaredFields();
        Field[] fieldsFilha = classe.getDeclaredFields();

        Field[] todos = new Field[fields.length + fieldsFilha.length];
        System.arraycopy(fields, 0, todos, 0, fields.length);
        System.arraycopy(fieldsFilha, 0, todos, fields.length, fieldsFilha.length);

        boolean primeiro = true;

        for (Field field : todos) {
            field.setAccessible(true);


            if (field.getName().equalsIgnoreCase("id")) {
                continue;
            }

            try {
                Object valor = field.get(obj);

                if (!primeiro) {
                    colunas.append(", ");
                    valores.append(", ");
                }

                colunas.append(field.getName());

                if (valor instanceof String) {
                    valores.append("'").append(valor).append("'");
                } else {
                    valores.append(valor);
                }

                primeiro = false;

            } catch (IllegalAccessException e) {
                throw new RuntimeException("erro ao acessar: " + field.getName(), e);
            }
        }

        return "INSERT INTO " + tabela + " (" + colunas + ") VALUES (" + valores + ")";
    }

    public String gerarDelete(Object obj, Long id) {
        Class<?> classe = obj.getClass();
        String tabela = getNomeTabela(classe);
        return "DELETE FROM " + tabela + " WHERE id = " + id;
    }

    private String getNomeTabela(Class<?> classe) {
        Class<?> atual = classe;

        while (atual != null && atual != Object.class) {
            if (atual.isAnnotationPresent(Descricao.class)) {
                return atual.getAnnotation(Descricao.class).descricao();
            } else if (atual.isAnnotationPresent(Table.class)) {
                return atual.getAnnotation(Table.class).name();
            }
            atual = atual.getSuperclass();
        }

        return classe.getSimpleName().toUpperCase();
    }
}