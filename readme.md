### (WIP) Project Manager

#
A aplicação é um gerenciador de projetos e atividades com permissionamentto de usuários.
A sua autenticação é gerida pela ferramenta keycloak que é utiliza pelas maiores empresas do ramo de tecnologia na atualidade, e a sua forma de gerir os projetos é simples, relacionando ambos atividade e projetos entre si.

#
####Para iniciar o projeto siga:

~~~
bash gradlew clean build
~~~
ou no windows
~~~
gradlew.bat clean build
~~~

Após configurado o build, basta somente executar o compose docker para iniciar a aplicação:
~~~
# bash docker-compose up
~~~

#
####Visualização dos dados:
Previamente o projeto terá somente os endpoints expostos, seguindo para uma implementação com VueJS com typescript.
