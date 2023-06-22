# Recipe Management Application

### Background
It is a standalone spring boot java application exposing REST endpoints to allow users to manage their
favourite recipes. It will allow adding, updating, removing and fetching recipes.

### Contribution
Following section provides guidelines on how other developers can contribute to this project. Following tools should be pre-installed to do further development on this application.
1. Java 1.8
2. Maven
3. Git
4. MySQL database should be up and running with creation of recipe_store database in advance. More details about database configuration can be found in application.properties file.
5. This application is built using spring boot framework.
6. pom.xml file covers dependencies used to build this application
7. swagger ui provides documentation around REST endpoints and it can be accessed using URL - http://localhost:8080/swagger-ui/index.html

### Launching the application
Following are the steps required to launch the application locally -
- Clone the repository: git clone https://github.com/asinghalgit/recipe-management-app.git
- Navigate to the project directory: cd recipe-management-app
- Build the project: mvn clean install
- Run the application: java -jar target/recipe-management-app-1.0.0-SNAPSHOT.jar
