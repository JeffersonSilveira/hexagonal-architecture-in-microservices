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
Visualmente, a arquitetura é representada por meio de dois hexágonos concêntricos (veja figura). No hexágono interno, ficam as classes do domínio (ou classes de negócio, se você preferir). No hexágono externo, ficam os adaptadores. Por fim, as classes de interface com o usuário, classes de tecnologia ou de sistemas externos ficam fora desses dois hexágonos.<br/>
<img align="right" src="https://github.com/JeffersonSilveira/hexagonal-architecture-in-microservices/blob/final-project/images/core.JPG">

Apartir de agora vamos focar nesta estrutura mostrada na imagem abaixo, onde está definida nos seguinte fluxo.
* API de cliente
  Vamos busca o endereço do cliente através do cep na api de endereço.
* API de Endereço
  Não iremos criar API, vamos mocar, vamos utilizar wiremock para simular na aplicação.
* API de validação de cpf
* Mongo
  Vamos salvar os registros
* Kafka
  Onde iremos enviar os dados do cliente
  



