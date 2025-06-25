# codigoalvo-kotlin-app-info

## OBJETIVO
- Exibir versão do projeto (extraída do pom.xml)
- Mostrar hash do último commit Git
- Disponibilizar via API REST

## FUNCIONAMENTO
### 1. VERSÃO
- Maven substitui `@project.version@` em `src/main/resources/application.properties`:
  ```properties
  app.version=@project.version@
  ```
- Injetada no código com:
  ```kotlin
  @Value("\${app.version}") private lateinit var appVersion: String
  ```

### 2. GIT HASH
- Plugin `git-commit-id-plugin` gera `target/classes/git.properties`
- Configuração essencial no `pom.xml`:
  ```xml
  <generateGitPropertiesFile>true</generateGitPropertiesFile>
  ```
- Deve ser carregado manualmente com:
  ```kotlin
  @PropertySource("classpath:git.properties")
  ```

### 3. API
- Endpoint `/app-info` retorna:
  ```json
  {
    "version": "0.0.1",
    "commitHash": "a1b2c3d"
  }
  ```

## COMO USAR
1. `mvn clean package`
2. `mvn spring-boot:run`
3. Acesse: [http://localhost:8080/app-info](http://localhost:8080/app-info)

## SOLUÇÃO-CHAVE
A anotação `@PropertySource("classpath:git.properties")` na classe principal foi o elemento crítico para o funcionamento.

## LIÇÕES
1. Spring Boot não carrega `git.properties` automaticamente
2. Kotlin exige classes `open` para injeção de dependências
3. Sempre verifique se o arquivo está em `target/classes`

## AUTOR
Cassio Reinaldo Amaral - codigoalvo
