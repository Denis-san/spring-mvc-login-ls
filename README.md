# spring-mvc-login-ls
Aplicação consiste em um login simples usando Spring Boot + Spring MVC + Thymeleaf e Spring Security. Objetivos: aplicação dos conceitos adquiridos sobre o  Spring Security, implemetação de uma autenticação simples e proteção básica contra ataques de força bruta. 
#

### :cloud: Você pode testar essa aplicação em: https://spring-mvc-login-ls.herokuapp.com/

#

<h3>Ferramentas e tecnologias usadas:</h3>

Linguagem base:

- Java;

Para persitência de dados:

- JPA (Java Persitence API);
- Hibernate;

Banco de dados:

- PostgreSQL;

Para construção da aplicação web:

- Spring Framework;
- Spring Boot;
- Spring MVC;

Como template, (view) da aplicação:

- Thymeleaf;
- HTML;

Para estilização das páginas da aplicação:

- Bootstrap;
- javascript; 
- css;

Além de:

- Spring Security, para aspectos de segurança da aplicação;
- Hibernate Validator, para validação server-side;
- Heroku, implantação da aplicação na nuvem;

#

###  Algumas características:


- <h5>Cadastro/registro de usuários</h5>
  É possível registrar um usuário desde que este não exista no banco de dados, essa verificação é feita comparando somente seu "nome de login". 
  
- <h5>Validação server-side</h5>
  Alguns campos são validados de acordo com algumas regras, por exemplo, nome, sobrenome, alguns campos do endereço do usuario não podem estar em branco e ou vazio,
  assim como nome de login e senha, esta ultima possui algumas validações a mais como: possuir mais de 8 caracteres e ser equivalente á senha inserida no campo de confirmação.
  
- <h5>Login</h5>
  A partir desse cadastro, onde são informados nome de login criada uma senha, pode-se utilizar essas credenciais para realizar um login na aplicação.
  
- <h5>Validações</h5>
  Obviamente, caso o usuário insira suas credenciais erradas, o sistema lhe informará que houve um erro ao realizar a autenticação, desde validções com javascript à validações server-side.
  
- <h5>Limitando tentativas sem sucesso de logins (prevenção básica contra ataques de força bruta)</h5>
  A aplicação permite apenas 5 tentativa ao o usuário para que este tente realizar o login, caso ele exceda esse limite o sistema "bloqueia" seu endereço de ip, ou seja,
  o sistema impede que sejam realizadas novas tentativas de autenticação vindas desse endereço de internet, esse bloqueio permanece até às 23:59 horas do dia presente, permitindo e ou desbloqueando o acesso à pagina de login após esse período.

- <h5>Outras caracteŕisticas:</h5>

  - Auto login após um registro/cadastro bem sucedido;
  - Caso um usuário esteja logado, este é impedido de acessar as páginas de cadastro e login, sendo redirecionado à pagina inicial;

#

- <h5>Sugestões de correções e adição de funcionalidades futuras </h5>

  - Recuperação de login;
  - Identificação de login por meio de email do usuário, para que permita ao sistema a opção de recuperação da conta do usuário;
  - Bloqueio de uma conta caso essa, esteja recebendo um número limitante de "bloqueio de ip"; 

#

### :book: Essa é uma aplicação fictícia, construída apenas para fins estudantis.
