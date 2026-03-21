# Projeto Java - CRUD com JPA e Hibernate (Oracle)

## Descrição

Este projeto demonstra a implementação de um CRUD completo utilizando Java, JPA (Jakarta Persistence) e Hibernate, com persistência em banco de dados Oracle.

O sistema modela uma hierarquia de funcionários, utilizando herança em JPA, além de aplicar reflection para geração de comandos SQL dinâmicos.

## Estrutura do Projeto

Pacote br.com.fiap.funcionario
Contém as entidades do sistema: Funcionario, Senior e Estagiario.

Pacote br.com.fiap.principal
Contém a classe Main responsável pela execução do sistema.

Pacote br.com.fiap.util
Contém a classe SQL responsável pela geração de comandos SQL via reflection.

Pacote br.com.fiap.anotacao
Contém a anotação personalizada Descricao.

## Conceitos Utilizados

JPA (Jakarta Persistence API)
Hibernate ORM
Mapeamento objeto-relacional (ORM)
Herança com estratégia JOINED
Anotações como Entity, Table, Column, Id e GeneratedValue
Reflection para geração de SQL
Operações CRUD (Create, Read, Update, Delete)
Conexão com banco Oracle via JDBC

## Entidades

Funcionario
Classe base do sistema contendo os atributos id, nome, horasTrabalhadas e valorHora. Possui método para cálculo de salário base.

Estagiario
Classe que herda de Funcionario. Possui o atributo relatorio e aplica um desconto de 20% no cálculo do salário.

Senior
Classe que herda de Funcionario. Possui o atributo avaliarRelatorio e adiciona bônus ao salário com base nas horas trabalhadas.

## Funcionalidades

Create
Criação e persistência de objetos no banco de dados.

Read
Consulta de registros utilizando o identificador.

Update
Atualização de dados de um registro existente.

Delete
Remoção de registros do banco de dados.

## Classe Utilitária SQL

A classe SQL é responsável por gerar comandos SQL dinamicamente utilizando reflection.

Principais métodos:
gerarSelect
gerarInsert
gerarDelete

## Configuração do Banco

As configurações de conexão estão definidas no arquivo persistence.xml, incluindo driver JDBC, URL, usuário, senha, dialeto do Hibernate e estratégia de geração de tabelas.

## Execução do Projeto

Compilar o projeto utilizando Maven.
Executar a classe Main.

Durante a execução são exibidos os comandos SQL gerados e as operações realizadas no banco de dados.

## Tecnologias Utilizadas

Java 21 ou superior
Hibernate 6
Jakarta Persistence 3.1
Oracle JDBC Driver
Maven

## Autor

Projeto desenvolvido para fins acadêmicos.

## Observação

O projeto tem como objetivo demonstrar o uso de persistência com JPA e Hibernate, além da aplicação de conceitos de orientação a objetos como herança e uso de reflection.
