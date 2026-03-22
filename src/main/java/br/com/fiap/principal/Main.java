package br.com.fiap.principal;

import br.com.fiap.funcionario.Estagiario;
import br.com.fiap.funcionario.Senior;
import br.com.fiap.util.SQL;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        System.out.println("antes do factory");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle-fiap");

        System.out.println("pós factory");

        EntityManager em = factory.createEntityManager();

        SQL sqlTool = new SQL();

        try {

            Senior senior = new Senior("Carlos ", 160, 80.0, "relatorio aprovado");
            Estagiario estagiario = new Estagiario("Luisa", 40, 25.0, "projeto de java");

            System.out.println("\n create ");

            System.out.println("SQL Gerado: " + sqlTool.gerarInsert(senior));
            System.out.println("SQL Gerado: " + sqlTool.gerarInsert(estagiario));

            em.getTransaction().begin();
            em.persist(senior);
            em.persist(estagiario);
            em.getTransaction().commit();
            System.out.println("funcionarios registrados");

            senior.imprimirInformacao();
            estagiario.imprimirInformacao();

            System.out.println("\n read");

            System.out.println("SQL: " + sqlTool.gerarSelect(senior));

            Senior buscado = em.find(Senior.class, senior.getId());
            if (buscado != null) {
                buscado.imprimirInformacao();
            }

            System.out.println("\n update");

            em.getTransaction().begin();

            Estagiario estagiarioUpdate = em.find(Estagiario.class, estagiario.getId());

            if (estagiarioUpdate != null) {
                estagiarioUpdate.setRelatorio("relatorio");

                System.out.println("Simulando SQL Update: UPDATE "
                        + estagiarioUpdate.getClass().getSimpleName().toUpperCase()
                        + " SET relatorio = ? WHERE id = " + estagiarioUpdate.getId());

                em.merge(estagiarioUpdate);
            }

            em.getTransaction().commit();
            System.out.println("dados do estagiario atualizados");

            System.out.println("\n delete");

            System.out.println("SQL: " + sqlTool.gerarDelete(senior, senior.getId()));

            em.getTransaction().begin();

            Senior seniorParaRemover = em.find(Senior.class, senior.getId());
            if (seniorParaRemover != null) {
                em.remove(seniorParaRemover);
            }

            em.getTransaction().commit();
            System.out.println("Sênior removido do banco");

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Erro durante o CRUD: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
            factory.close();
        }
    }
}