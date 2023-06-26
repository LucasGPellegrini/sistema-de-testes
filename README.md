# Sistema De Testes

Sistema parcialmente desenvolvido para a disciplina de Engenharia de Software na UFU.

## **Membros da equipe**

- Amauri Pietropaolo
- Gabriel Moraes
- Lucas Pellegrini
- Pedro Leale
- Pedro Marra
- Raphael Azambuja
- Vinicius Calixto

## **Sobre o repositório**

Este repositório possui uma solução para a atividade da disciplina de Engenharia de Software, o objetivo é a implementação parcial ou completa de um sistema de gerênciamento de testes de sistemas.

## **Início rápido**

Para realizar a execução do **fat jar** compilado(Não é necessário baixar dependencias do maven):
  - Possuir instalado a versão Java SE 18 ou posterior
  - Clone este repositório `git clone https://github.com/LucasGPellegrini/sistema-de-testes.git`
  - Acesse o codigo fonte pelo terminal em .\telastestes:
  - Execute `java -jar .\jar\SistemaTestesFat.jar`
  - **Atenção**: Devido ao jar utilizar o SQLite que reserva um arquivo em src/main/java/com/grupo/database/database.db, executar o .jar sem ser direto em .\telastestes irá causar erros ao tentar encontrar o arquivo, por isso, **tenha certeza de estar no path .\telastestes**

Para realizar execução do código fonte não compilado no **terminal**:
  - Possuir instalado a versão Java SE 18 ou posterior
  - Possuir instalado o Maven
    - As variáveis de ambiente JAVA_HOME e MAVEN_HOME devem estar configuradas e é necessário anexar %MAVEN_HOME%\bin e %JAVA_HOME%\bin na variável PATH. Veja https://phoenixnap.com/kb/install-maven-windows para mais detalhes de como instalar o maven
    - Ao final o comando `mvn -version` deve retornar informações do maven
  - Clone este repositório `git clone https://github.com/LucasGPellegrini/sistema-de-testes.git`
  - Acesse o codigo fonte pelo terminal em .\telastestes:
  - Execute `mvn clean javafx:run`
    - Será feito as instalações do maven(mvn clean) e depois a execução do javafx(javafx:run)

Para realizar execução do código fonte não compilado em **IDEs**:
  - Possuir instalado a versão Java SE 18 ou posterior
  - Possuir instalado a IDE
  - Verificar como executar projetos Java Maven em sua IDE
