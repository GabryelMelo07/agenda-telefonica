# Agenda Telefônica
API de uma agenda telefônica usando Java, Spring Boot e MongoDB para o trabalho de Tópicos em Bancos de Dados

# Como testar
* Primeiramente o banco de dados MongoDB precisa estar instalado ou rodando em um container docker.
* Criar um banco de dados, sem senha, chamado "agenda" no MongoDB.
* Clonar este repositório, abrir a pasta em uma IDE e executar o seguinte comando no terminal:
```
mvn spring-boot:run
```
* Abrir no navegador a página do Swagger para testar a API, usando o seguinte link:
```
http://localhost:8080/swagger-ui/index.html#/
``` 

# Descrição do trabalho

O objetivo é desenvolver uma agenda de contatos com MongoDB e Java:

Nesta agenda, cada **contato** tem um **nome**, **telefones** (possível mais de 1) e um **endereço**. Cada **endereço** cadastrado possui **cidade**, **rua**, **bairro**, **número** e **complemento**. 

1) (1.0) Desenvolva as operações CRUD para os **contatos** da agenda (incluindo seus **endereços** e **telefones**) 
2) (1.0) Liste os **contatos** que moram em uma mesma **cidade** (Ex: Rio Grande)
3) (1.0) Liste os **contatos** que tem tem mais de um **telefone** cadastrado 
