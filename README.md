# Casa do Código - API
![Version](src/main/resources/static/img/version.svg)
![License](src/main/resources/static/img/license.svg)
![Coverage](src/main/resources/static/img/coverage.svg)

## Objetivos
Criar o backend para a plataforma da Casa do Código.
Essa API deve possibilitar o cadastro de autores, categorias de livros, países, estados e cadastro de clientes da casa do código.

O projeto apresenta diversas restrições, obrigando certos rumos a serem tomados.
Cada classe de modelo pode ter apenas 2 setters
Deve fazer diversas validações. 
Não aceita cadastros duplicados.
Classe service é dispensável ao projeto. Caso seja extremamente necessária, apenas uma classe service será permitida.

## Endpoints & payloads
### Endpoints
#### Autores
**Ação** | **Endpoint** | **Método**
---------- | ------------ | ----------
Inserir autor | _/api/v1/authors_ | POST

#### Categorias
**Ação** | **Endpoint** | **Método**
---------- | ------------ | ----------
Inserir categoria | _/api/v1/categories_ | POST

#### Livros
**Ação** | **Endpoint** | **Método**
---------- | ------------ | ----------
Inserir livro | _/api/v1/books_ | POST
Listar livro por id | _/api/v1/books/{id}_ | GET

#### Países
**Ação** | **Endpoint** | **Método**
---------- | ------------ | ----------
Inserir país | _/api/v1/countries_ | POST

#### Estados
**Ação** | **Endpoint** | **Método**
---------- | ------------ | ----------
Inserir estado | _/api/v1/states_ | POST

#### Clientes
**Ação** | **Endpoint** | **Método**
---------- | ------------ | ----------
Inserir cliente | _/api/v1/customers_ | POST

### Payloads - (request & response)
#### Autores
##### POST - request
    {
        "name": "Jacob Grimm",
        "email": "jcgrimm@email.com",
        "description": "Autor de livros infantis."
    }

##### POST - response
    {
        "name": "Jacob Grimm",
        "email": "jcgrimm@email.com",
        "description": "Autor de livros infantis.",
        "createdAt": "2021-01-28T15:14:39.6513199",
        "books": []
    }

#### Categorias
##### POST - request
    {
        "name": "Contos Infantis"
    }

##### POST - response
    {
        "name": "Contos Infantis"
    }

#### Livros
##### POST - request
    {
        "title": "João e Maria",
        "abstractText": "Emocionante história de dois irmãos...",
        "summary": "Texto em formato markdown, podendo ser formatado depois.",
        "price": 55.20,
        "pages": 115,
        "isbn": "123460",
        "toBePublishedAt": "2021-10-15",
        "categoryName": "Contos Infantis",
        "authorName": "Jacob Grimm"
    }

##### POST - response
    {
        "id": 1,
        "title": "João e Maria",
        "abstractText": "Emocionante história de dois irmãos...",
        "summary": "Texto em formato markdown, podendo ser formatado depois.",
        "price": 55.20,
        "pages": 115,
        "isbn": "123460",
        "toBePublishedAt": "2021-10-15",
        "category": "Contos Infantis",
        "author": "Jacob Grimm"
    }

##### GET - list by id
    {
        "id": 1,
        "title": "João e Maria",
        "abstractText": "Emocionante história de dois irmãos...",
        "summary": "Texto em formato markdown, podendo ser formatado depois.",
        "price": 55.20,
        "pages": 115,
        "isbn": "123460",
        "toBePublishedAt": "2021-10-15",
        "category": "Contos Infantis",
        "author": "Jacob Grimm"
    }

#### Países
##### POST - request
    {
        "name": "USA"
    }

##### POST - response
    {
        "id": 1,
        "name": "USA"
    }

#### Estados
##### POST - request
    {
        "name": "Rio Grande do Sul",
        "countryName": "Brasil"
    }

##### POST - response
    {
        "id": 1,
        "name": "Rio Grande do Sul"
    }

#### Clientes
##### POST - request
    {
        "email": "john@email.com",
        "firstName": "John",
        "lastName": "Doe",
        "document": "26117922086",
        "address": "Rua da Bica, 410",
        "complement": "Bloco A, Apto. 171-A",
        "city": "São Paulo",
        "country": "Brasil",
        "state": "São Paulo",
        "phone": "1133335544",
        "zip": "12365478"
    }

##### POST - response
    {
        "id": 1,
        "firstName": "John",
        "lastName": "Doe"
    }

