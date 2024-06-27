
# Conversor de Moedas

Este projeto é um conversor de moedas simples, desenvolvido em Java, que segue a arquitetura MVC (Model-View-Controller). O usuário pode converter valores entre várias moedas usando uma interface de linha de comando. O projeto utiliza a API [Exchangerate](https://www.exchangerate-api.com/) para obter as taxas de conversão.

## Funcionalidades

- Conversão de Real (BRL) para Dólar (USD)
- Conversão de Dólar (USD) para Real (BRL)
- Conversão de Real (BRL) para Peso Argentino (ARS)
- Conversão de Euro (EUR) para Real (BRL)
- Conversão de Yuan (CNY) para Real (BRL)

## Como Executar

### Pré-requisitos

- Java 11 ou superior

### Passos

1. Clone o repositório:

    ```sh
    git clone https://github.com/seu-usuario/conversor-moedas.git
    ```

2. Navegue até o diretório do projeto:

    ```sh
    cd conversor-moedas
    ```

3. Compile o projeto:

    ```sh
    javac -d out src/br/com/conversor/**/*.java
    ```

4. Execute a aplicação:

    ```sh
    java -cp out br.com.conversor.Principal
    ```

## Estrutura de Pastas

```plaintext
src/
└── br/
    └── com/
        └── conversor/
            ├── controllers/
            │   └── ConversorController.java
            ├── modelos/
            │   ├── MeuHttpClient.java
            │   └── ResultadoConversao.java
            ├── views/
            │   └── ConversorView.java
            └── Principal.java
```

## Tecnologias Utilizadas

- Java 11
- API Exchangerate
- Biblioteca `java.net.http` para requisições HTTP
- Biblioteca Gson para parsing de JSON

## Licença

Este projeto está licenciado sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.
