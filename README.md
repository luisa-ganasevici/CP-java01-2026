README 

Projeto Java, CP 01 - CRUD com JPA, Hibernate e Oracle

Descrição
Este projeto implementa um CRUD completo utilizando Java, JPA (Jakarta Persistence) e Hibernate, com persistência em banco de dados Oracle developer.

O sistema modela uma hierarquia de funcionários utilizando herança com a estratégia JOINED e também utiliza reflection para gerar comandos SQL por meio de uma classe utilitária.

Durante a execução da main, o sistema realiza operações de criação, leitura, atualização e remoção de dados, além de exibir os comandos SQL simulados e os gerados automaticamente pelo Hibernate.

Estrutura do Projeto

Pacote br.com.fiap.funcionario
entidades do sistema: Funcionario, Senior e Estagiario. A estrutura utiliza herança com JPA.

Pacote br.com.fiap.principal
classe Main responsável pela execução do sistema e teste das operações CRUD.

Pacote br.com.fiap.util
classe SQL responsável pela geração de comandos SQL dinamicamente utilizando reflection.

Pacote br.com.fiap.anotacao
anotação personalizada Descricao, utilizada para definir o nome das tabelas dinamicamente.

Conceitos Utilizados

JPA (Jakarta Persistence API)
Hibernate ORM
Mapeamento objeto-relacional (ORM)
Herança com estratégia JOINED
Anotações (@Entity, @Table, @Column, @Id, @GeneratedValue, @Inheritance)
Reflection em Java
Geração dinâmica de SQL
Operações CRUD (Create, Read, Update, Delete)
Conexão com banco Oracle developer via JDBC

Entidades

Funcionario
Classe base do sistema. Contém os atributos id, nome, horasTrabalhadas e valorHora. Possui método para cálculo de salário base e serve como superclasse para as demais entidades.

Estagiario
Classe que herda de Funcionario. Possui o atributo relatorio e aplica um desconto de 20% no cálculo do salário.

Senior
Classe que herda de Funcionario. Possui o atributo avaliarRelatorio e adiciona bônus ao salário com base nas horas trabalhadas.

Funcionalidades

Create
Criação e persistência de objetos no banco de dados utilizando EntityManager.

Read
Consulta de registros a partir do identificador utilizando o método find.

Update
Atualização de dados de um registro existente utilizando merge.

Delete
Remoção de registros do banco de dados utilizando remove.

Classe Utilitária SQL

A classe SQL é responsável por gerar comandos SQL dinamicamente utilizando reflection.

Ela identifica automaticamente os atributos das classes e monta comandos SQL com base nos dados dos objetos.

Principais métodos:
gerarInsert
gerarSelect
gerarDelete

Configuração do Banco

As configurações estão definidas no arquivo persistence.xml, incluindo:

Driver JDBC do Oracle
URL de conexão com o banco
Usuário e senha
Dialeto do Hibernate
Estratégia de geração de tabelas (create)

O Hibernate é responsável por criar automaticamente as tabelas no banco de dados com base nas entidades.

Execução do Projeto

Compilar o projeto utilizando Maven.
Executar a classe Main.

Durante a execução, o sistema:

Cria registros no banco
Consulta dados
Atualiza informações
Remove registros
Exibe os comandos SQL gerados

Tecnologias Utilizadas

Java 21
Hibernate 6
Jakarta Persistence 3.1
Oracle JDBC Driver
Maven




O projeto tem como objetivo demonstrar o uso de persistência com JPA e Hibernate, aplicação de herança em banco de dados relacional e uso de reflection para geração dinâmica de comandos SQL.
