# bookStore
A bookStore java spring boot reduce with TDD

Deplying to Heroku
- add github workflow actions .github/workflows/gradle.yml
- update gradle.yml file with a unique heroku app name. (the heroku action will create the repo on 1st build. Afterwards it will update)
- Procfile - needed to specify jar for Heroku Dyno 
- system.properites - needed to specify JDK version for heroku build
- github actions workflow - needed to specify the heroku step and api key to deploy the org.
  - get Heroku API key by logging into heroku and go to your account settings.
  - Add API key "HEROKU_API_KEY" to the repo settings. Settings --> secrets & variables --> actions


FlywayDB and migrations
1. convert application.properties to yaml
2. add depenncy in gradle file.
3. add migration directory /resources/db/migration
4. add migration for SQL to CRUD the schema or modify data in the format `V1_DoSomething.sql`
5. run `./gradlew flywayMigrate -i`

[Flyway Official Docs for gradle](https://flywaydb.org/documentation/getstarted/firststeps/gradle)

JaCOCO
"JaCoCo runs as a Java agent. It's responsible for instrumenting the byte code while running the tests. JaCoCo drills into each instruction, and shows which lines are exercised during each test."

run `./gradlew check'

Testing the Service Layer

a html file is created showing test reports
```build/reports/jacoco/test/html/index.html```