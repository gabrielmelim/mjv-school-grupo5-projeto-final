package br.com.groupfive.jobby;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
Garantir que os cadastros sejam inseridos no banco de dados considerando a nova estrutura
Identificar quais candidatos NÃO possuem habilidade relacionadas
Contar quantos candidatos possuem a habilidade JAVA
Selecionar os candidatos que são do sexo FEMININO e que moram nas cidades do estado sigla SP informando o nome, cpf, dados de endereço e nome da cidade
Agrupar por profissão e contar quantos profissionais que moram na cidade de nome SÃO PAULO
Selecionar candidatos que registram experiências com data de contratação entre 01/01/202 a 31/12/2023
Selecionar candidatos que trabalharam na empresa MICROSOFT
Selecionar candidatos que AINDA trabalham na empresa MICROSOFT
Selecionar candidatos que estão trabalhando atualmente
Criar uma consulta que retorne todos os candidatos e nome da sua profissão correspondentemente
Criar uma consulta que retorne todos os candidatos e nome da sua profissão onde o id da profissão corresponda ao registro ANALISTA DE SISTEMAS
Criar uma consulta que conte a quantidade de profissionais por profissão
Criar uma consulta que retorne os candidatos ordenados por profissão e salário máximo de forma decrescente
 */
@SpringBootApplication
public class JobbyApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobbyApplication.class, args);
    }
}
