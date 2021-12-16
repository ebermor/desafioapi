---
# Recursos
Possibilitar a leitura da lista de indicados e vencedores
da categoria Pior Filme do Golden Raspberry Awards

Obter o produtor com maior intervalo entre dois prêmios consecutivos, e o que
obteve dois prêmios mais rápido.<br/>
Utilizado Spring Boot, Tom Cat 8 incorporado, JPA/Hibernate

# Instruções para rodar o aplicativo
A IDE utilizada no projeto foi STS (Spring Tools Suite 4) For Eclipse.<br/>
1 Abra a IDE e clique File/Open Projects from File System.<br/>
2 Clique em Directory e localiza a pasta do projeto.<br/>
3 Clique em Finish e aguarda baixar as dependecias.<br/>
4 No Project Explorer clique com o botão direito no projeto desafioapi depois em Run As em seguida em Spring Boot Apps.  




# Endpoint
----
Obter o produtor com maior intervalo entre dois prêmios consecutivos, e o que
obteve dois prêmios mais rápido, seguindo a especificação de formato definida na

http://localhost:8080/api/producer/interval

## Endpoints extras
Retorna o filme informado no parametro id<br/>
http://localhost:8080/api/movie/{id}<br/>

Retorna a lista de todos os filmes cadastrados<br/>
http://localhost:8080/api/movie/<br/>
