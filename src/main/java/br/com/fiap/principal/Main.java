package br.com.fiap.principal;

import br.com.fiap.funcionario.Estagiario;
import br.com.fiap.funcionario.Senior;
import br.com.fiap.util.SQL;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        System.out.println("ANTES DO FACTORY");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle-fiap");

        System.out.println("DEPOIS DO FACTORY");

        EntityManager em = factory.createEntityManager();

        SQL sqlTool = new SQL();

        try {

            Senior senior = new Senior("Carlos Alberto", 160, 80.0, "Relatório de TI Aprovado");
            Estagiario estagiario = new Estagiario("Luisa", 40, 25.0, "Projeto Java Advanced");

            System.out.println("\n--- [ETAPA 1 - CREATE] ---");

            System.out.println("SQL Gerado: " + sqlTool.gerarInsert(senior));
            System.out.println("SQL Gerado: " + sqlTool.gerarInsert(estagiario));

            em.getTransaction().begin();
            em.persist(senior);
            em.persist(estagiario);
            em.getTransaction().commit();
            System.out.println("Funcionários persistidos no Oracle com sucesso!");

            senior.infoFuncionario();
            estagiario.infoFuncionario();

            System.out.println("\n--- [ETAPA 2 - READ] ---");

            System.out.println("SQL Gerado: " + sqlTool.gerarSelect(senior));

            Senior buscado = em.find(Senior.class, senior.getId());
            if (buscado != null) {
                buscado.infoFuncionario();
            }

            System.out.println("\n--- [ETAPA 3 - UPDATE] ---");

            em.getTransaction().begin();

            Estagiario estagiarioUpdate = em.find(Estagiario.class, estagiario.getId());

            if (estagiarioUpdate != null) {
                estagiarioUpdate.setRelatorio("Relatório Final do Checkpoint 1");

                System.out.println("Simulando SQL Update: UPDATE "
                        + estagiarioUpdate.getClass().getSimpleName().toUpperCase()
                        + " SET relatorio = ? WHERE id = " + estagiarioUpdate.getId());

                em.merge(estagiarioUpdate);
            }

            em.getTransaction().commit();
            System.out.println("Dados do estagiário atualizados!");

            System.out.println("\n--- [ETAPA 4 - DELETE] ---");

            System.out.println("SQL Gerado: " + sqlTool.gerarDelete(senior, senior.getId()));

            em.getTransaction().begin();

            Senior seniorParaRemover = em.find(Senior.class, senior.getId());
            if (seniorParaRemover != null) {
                em.remove(seniorParaRemover);
            }

            em.getTransaction().commit();
            System.out.println("Funcionário Sênior removido do banco.");

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