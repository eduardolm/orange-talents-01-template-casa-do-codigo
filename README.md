# Casa do Código - API
![Version](img/version.svg)
![License](img/license.svg)
![Coverage](img/coverage.svg)

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
Listar autores | _/api/v1/authors_ | GET

#### Categorias
**Ação** | **Endpoint** | **Método**
---------- | ------------ | ----------
Inserir categoria | _/api/v1/categories_ | POST

#### Livros
**Ação** | **Endpoint** | **Método**
---------- | ------------ | ----------
Inserir livro | _/api/v1/books_ | POST
Listar livros | _/api/v1/books_ | GET
Listar livro por id | _/api/v1/books/{id}_ | GET

#### Países
**Ação** | **Endpoint** | **Método**
---------- | ------------ | ----------
Inserir país | _/api/v1/countries_ | POST
Listar países | _/api/v1/countries_ | GET
Listar país por id | _/api/v1/countries/{id}_ | GET

#### Estados
**Ação** | **Endpoint** | **Método**
---------- | ------------ | ----------
Inserir estado | _/api/v1/states_ | POST
Listar estados | _/api/v1/states_ | GET
Listar estado por id | _/api/v1/states/{id}_ | GET

#### Clientes
**Ação** | **Endpoint** | **Método**
---------- | ------------ | ----------
Inserir cliente | _/api/v1/customers_ | POST
Listar clientes | _/api/v1/customers_ | GET
Listar cliente por id | _/api/v1/customers/{id}_ | GET

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
    
##### GET - list all
    [
        {
            "name": "Jacob Grimm",
            "email": "jcgrimm@email.com",
            "description": "Autor de livros infantis.",
            "createdAt": "2021-01-28T15:14:39.65132",
            "books": [
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
            ]
        }
    ]

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

##### GET - list all books
    [
        {
            "id": 1,
            "title": "João e Maria"
        }
    ]

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

##### GET - list all
    [
        {
            "id": 1,
            "name": "USA"
        }
    ]

##### GET - list by id
    {
        "id": 1,
        "name": "USA",
        "states": []
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

##### GET - list all
    [
        {
            "id": 1,
            "name": "Rio Grande do Sul"
        }
    ]

##### GET - list by id
    {
        "id": 1,
        "name": "Rio Grande do Sul",
        "country": "Brasil"
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

##### GET - list all
    [
        {
            "id": 1,
            "firstName": "John",
            "lastName": "Doe"
        }
    ]

##### GET - list by id
    {
        "id": 1,
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

