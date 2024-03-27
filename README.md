# Engenharia de Software Moderna

O conceito de Arquitetura Hexagonal foi proposto por **Alistair Cockburn**, em meados dos anos 90, em um artigo postado na primeira wiki que foi desenvolvida, chamada WikiWikiWeb (cujos artigos tratavam principalmente de temas relacionados com Engenharia de Software).<br/>

Os objetivos de uma Arquitetura Hexagonal são parecidos com os de uma Arquitetura Limpa.<br/>
Mas, para reforçar, a ideia é construir sistemas que favorecem reusabilidade de código, alta coesão, baixo acoplamento, independência de tecnologia e que são mais fáceis de serem testados.<br/>

**Uma Arquitetura Hexagonal divide as classes de um sistema em dois grupos principais:**<br/>
* Classes de domínio, isto é, diretamente relacionadas com o negócio do sistema.
* Classes relacionadas com infraestrutura, tecnologias e responsáveis pela integração com sistemas externos (tais como bancos de dados).<br/>

Além disso, em uma Arquitetura Hexagonal, **classes de domínio não devem depender de classes relacionadas com infraestrutura, tecnologias ou sistemas externos.**<br/>
A vantagem dessa divisão é desacoplar esses dois tipos de classes.<br/>

Assim, as classes de domínio não conhecem as tecnologias – bancos de dados, interfaces com usuário e quaisquer outras bibliotecas – usadas pelo sistema. <br/>
Consequentemente, mudanças de tecnologia podem ser feitas sem impactar as classes de domínio. <br/>
Talvez ainda mais importante, as classes de domínio podem ser compartilhadas por mais de uma tecnologia. Por exemplo, um sistema pode ter diversas interfaces (Web, mobile, etc)  [saiba mais](https://engsoftmoderna.info/artigos/arquitetura-hexagonal.html).<br/><br/>
Visualmente, a arquitetura é representada por meio de dois hexágonos concêntricos (veja figura). No hexágono interno, ficam as classes do domínio (ou classes de negócio, se você preferir). No hexágono externo, ficam os adaptadores. Por fim, as classes de interface com o usuário, classes de tecnologia ou de sistemas externos ficam fora desses dois hexágonos.<br/><br/>
<img align="right" src="https://github.com/JeffersonSilveira/hexagonal-architecture-in-microservices/blob/final-project/images/core.JPG"><br/>

## Recurso que utilizaremos para esse projeto<br/>
* Java
* Spring Boot (Framework)
* MongoDb (Banco de dados)
* Kafka (Mensageria)
* Docker (Virtualização)

## Arquitetura Hexagonal
Como mencionado acima vamos tuilizar para este projeto a arquitetura hexagonal, ela é organizada neste formato (imagem abaixo)<br/><br/>
<img  src="https://github.com/JeffersonSilveira/hexagonal-architecture-in-microservices/blob/final-project/images/formato.JPG"><br/>

Apartir de agora vamos focar nesta estrutura mostrada na imagem abaixo, onde está definida nos seguinte fluxo.<br/><br/>
<img align="right" src="https://github.com/JeffersonSilveira/hexagonal-architecture-in-microservices/blob/final-project/images/fluxo.JPG"><br/>


## Breve descrição do fluxo
* API de cliente
 > Vamos busca o endereço do cliente através do cep na api de endereço.
* API de Endereço
 > Não iremos criar API, vamos mocar, vamos utilizar wiremock para simular na aplicação.
* API de validação de cpf
 > Onde será validado o cpf do cliente
* Mongo
 > Vamos salvar os registros
* Kafka
 > Onde iremos enviar os dados do cliente

 ## Recursos do Wiremock
 Para simularmos uma api de serviço de endereço basta baixar o [wiremock](https://wiremock.org/), extraia no diretório do projeto e digite o seguinte comando no terminal<br/>
> java -jar wiremock-standalone-3.4.2.jar --port 8082

Ao realizar o comando acima, será gerado um diretório chamado mappings, onde serão criados dois arquivos que servirão de endereços para o nosso mock, address.json e address_2.json. <br/>
**Arquivo: address.json**
 ```{
    "request": {
        "method": "GET",
        "url": "/addresses/38400000"
    },
    "response": {
        "status": 200,
        "headers": {
            "Content-Type": "application/json"
        },
        "jsonBody": {
            "street": "Rua Hexagonal",
            "city": "Uberlândia",
            "state": "Minas Gerais"
        }
    }
}
```
**Arquivo: address_2.json**

``` {
    "request": {
        "method": "GET",
        "url": "/addresses/38400001"
    },
    "response": {
        "status": 200,
        "headers": {
            "Content-Type": "application/json"
        },
        "jsonBody": {
            "street": "Rua das Flores",
            "city": "São Paulo",
            "state": "São Paulo"
        }
    }
}
```
Para testarmos o recurso basta abrir o Postman e digitar o seguinte url.
> http://localhost:8082/addresses/38400000 ou
> http://localhost:8082"/addresses/38400001 

<br/>
<img  src="https://github.com/JeffersonSilveira/hexagonal-architecture-in-microservices/blob/final-project/images/endereco.JPG"><br/>

Para utilizar os recursos desenvolvidos basta acessar o endereço http://locaslhost:8081/api/customers via Postman, a imagem abaixo mostrar a criação de um customer.<br/>

<img  src="https://github.com/JeffersonSilveira/hexagonal-architecture-in-microservices/blob/final-project/images/insertCustomer.JPG"><br/>

## ArchUnit
[ArchUnit]( https://www.archunit.org/) é uma biblioteca gratuita, simples e extensível para verificar a arquitetura do seu código Java. <br/>
Ou seja, o ArchUnit pode verificar dependências entre pacotes e classes, camadas e fatias, verificar dependências cíclicas e muito mais. <br/>
Isso é feito analisando um determinado bytecode Java, importando todas as classes para uma estrutura de código Java.<br/>
O foco principal do ArchUnit é testar automaticamente a arquitetura e as regras de codificação, usando qualquer estrutura de teste de unidade Java simples. <br/>
Isso evita que criarem estruturas paralelas no projeto.




