<h1 align="center">📝 Task App</h1>

<p align="center">
  Sistema backend para gerenciamento de tarefas desenvolvido com <strong>Spring Boot</strong>,
  seguindo boas práticas de arquitetura em camadas e preparado para evolução futura.
</p>

<hr/>

<h2>🚀 Sobre o Projeto</h2>
<p>
O <strong>Task App</strong> é uma API RESTful voltada para o gerenciamento de tarefas,
permitindo a organização de atividades em listas. O projeto foi desenvolvido com foco em
<strong>boas práticas de desenvolvimento backend</strong>, como separação de responsabilidades,
uso de DTOs e modelagem de domínio bem definida.
</p>

<hr/>

<h2>🏗️ Arquitetura</h2>
<p>O projeto segue uma arquitetura em camadas, organizada da seguinte forma:</p>

<ul>
  <li><strong>Controller</strong> → Responsável pela exposição dos endpoints REST</li>
  <li><strong>Service</strong> → Contém as regras de negócio</li>
  <li><strong>Domain</strong> → Entidades e DTOs</li>
  <li><strong>Repository</strong> → Comunicação com o banco de dados (JPA)</li>
</ul>

<p>
A estrutura foi pensada para facilitar manutenção, testes e futura migração para
<strong>Clean Architecture</strong>.
</p>

<hr/>

<h2>🧠 Modelagem do Domínio</h2>

<ul>
  <li><strong>Task</strong>
    <ul>
      <li>Título</li>
      <li>Descrição</li>
      <li>Status</li>
      <li>Prioridade</li>
      <li>Data de vencimento</li>
    </ul>
  </li>

  <li><strong>TaskList</strong>
    <ul>
      <li>Nome da lista</li>
      <li>Relacionamento com tarefas</li>
    </ul>
  </li>
</ul>

<p>
O projeto utiliza <strong>UUID</strong> como identificador e <strong>Enums</strong> para controle
de status e prioridade.
</p>

<hr/>

<h2>🔗 Persistência</h2>

<ul>
  <li>Spring Data JPA + Hibernate</li>
  <li>Mapeamento objeto-relacional (ORM)</li>
  <li>Relacionamentos:
    <ul>
      <li>OneToMany (TaskList → Task)</li>
      <li>ManyToOne (Task → TaskList)</li>
    </ul>
  </li>
  <li>Uso de <strong>FetchType.LAZY</strong> para otimização</li>
  <li>Configuração de <strong>cascade</strong> para operações automáticas</li>
</ul>

<hr/>

<h2>🔄 DTOs</h2>

<p>
O projeto utiliza <strong>DTOs (Data Transfer Objects)</strong> para desacoplar a camada de
apresentação da camada de domínio, garantindo:
</p>

<ul>
  <li>Maior segurança na exposição de dados</li>
  <li>Organização e clareza no código</li>
  <li>Facilidade de manutenção</li>
</ul>

<hr/>

<h2>🌐 API REST</h2>

<p>Endpoints iniciais seguem padrão RESTful:</p>

<ul>
  <li>CRUD de tarefas</li>
  <li>Gerenciamento de listas</li>
  <li>Respostas padronizadas em JSON</li>
</ul>

<hr/>

<h2>🛠️ Tecnologias Utilizadas</h2>

<ul>
  <li>Java 21</li>
  <li>Spring Boot</li>
  <li>Spring Data JPA</li>
  <li>Hibernate</li>
  <li>PostgreSQL (ou outro banco relacional)</li>
  <li>Maven</li>
</ul>

<hr/>

<h2>⚙️ Como Executar o Projeto</h2>

<ol>
  <li>Clone o repositório:
    <pre><code>git clone https://github.com/Marcus-Austin/task-app.git</code></pre>
  </li>

  <li>Acesse a pasta do projeto:
    <pre><code>cd task-app</code></pre>
  </li>

  <li>Configure o banco de dados no <code>application.properties</code></li>

  <li>Execute a aplicação:
    <pre><code>./mvnw spring-boot:run</code></pre>
  </li>
</ol>

<hr/>

<h2>🔐 Melhorias Futuras</h2>

<ul>
  <li>Implementação de autenticação com JWT (Spring Security)</li>
  <li>Controle de usuários</li>
  <li>Paginação e filtros avançados</li>
  <li>Documentação com Swagger/OpenAPI</li>
  <li>Testes automatizados (JUnit + Mockito)</li>
</ul>

<hr/>

<h2>📌 Status do Projeto</h2>

<p>
🚧 Em desenvolvimento — estrutura base concluída e pronta para evolução.
</p>

<hr/>

<h2>👨‍💻 Autor</h2>

<p>
Desenvolvido por <strong>Marcus Austin</strong>
</p>
