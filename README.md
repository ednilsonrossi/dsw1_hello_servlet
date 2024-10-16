# dsw1_hello_servlet

Este projeto é uma introdução à utilização de **servlets** no desenvolvimento de aplicações web em Java. Ele contém várias funcionalidades que exploram os principais métodos e operações que podem ser realizadas em um servlet, como manipulação de requisições e respostas.

## Funcionalidades

1. **Hello**
   - Exibe uma mensagem de "Hello World" utilizando a tecnologia Servlet.
   - Demonstra a estrutura básica de um servlet, incluindo os métodos `doGet()` e `doPost()`.


2. **Post vs Get**
   - Mostra a diferença no tratamento de requisições HTTP `GET` e `POST` no servlet.
   - Explica quando e por que usar cada método de requisição, utilizando exemplos práticos.


3. **Request**
   - Apresenta os principais métodos utilizados no objeto `HttpServletRequest`.
   - Métodos abordados:
     - `getParameter(String name)`: Recupera um parâmetro enviado pela requisição.
     - `getMethod()`: Retorna o método de requisição (GET, POST, etc.).
     - `getRequestURL()`: Obtém a URL da requisição.


4. **Eco**
   - Apresenta várias chamadas de métodos da classe `HttpServletRequest`.
   - Exemplos de métodos utilizados:
     - `getRemoteAddr()`: Obtém o endereço IP remoto que fez a requisição.
     - `getHeader(String name)`: Recupera o valor de um cabeçalho específico.
     - Outros métodos importantes para análise de requisições HTTP.

     
5. **Response**
   - Explora as opções disponíveis no objeto `HttpServletResponse`.
   - Funcionalidades demonstradas:
     - Configuração de cabeçalhos HTTP.
     - Definição do código de status da resposta.
     - Envio de mensagens personalizadas e redirecionamento de respostas.


6. **Buscador**
   - Implementa um buscador que redireciona um termo de busca para motores de busca especializados.
   - Utiliza os métodos:
     - `sendRedirect()`: Redireciona a requisição para uma nova URL.
     - `sendError(int code)`: Envia um código de erro HTTP, como 404 ou 500.


## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **Servlets**: Tecnologia Java utilizada para criar aplicações web dinâmicas.
- **Tomcat**: Servidor web usado para executar o projeto.

## Como Executar

1. Clone o repositório:

   ```bash
   git clone https://github.com/ednilsonrossi/dsw1_hello_servlet.git
