# Consulta de endereço por meio de CEP ![GitHub Actions Workflow Status](https://img.shields.io/github/actions/workflow/status/matheusrodriguesf/spring-boot-via-cep-service/maven)


Serviço de consulta de endereço que faz integração com API do VIACEP.

Recebe como parâmetro o CEP informado e retorna uma estrutura JSON com os seguintes campos: cep, logradouro, complemento, bairro localidade e uf.

# Desenvolvimento
## Tecnologias
- Docker
- Java 17
- Openfeign
- Spring-boot:3.0.6

## Executando o aplicativo localmente
A aplicação é construida a partir do maven. Para executar o projeto:
```
mvn spring-boot:run
``` 
## Executando o aplicativo via Docker

Realizar o build da image

```
docker build -t matheusrodriguesf/cep-service .
```
Para executar o contêiner

```
docker run -p 8080:8080 --name cep-service matheusrodriguesf/cep-service
```

## Como Usar:

### Requisição

Realizar uma requisição do tipo GET para o endpoint.

```
/api/v1/viacep/01001000
```


### Resposta
```
{
  "cep": "01001-000",
  "logradouro": "Praça da Sé",
  "complemento": "lado ímpar",
  "bairro": "Sé",
  "localidade": "São Paulo",
  "uf": "SP"
}
```

## Autor
Matheus Rodrigues

