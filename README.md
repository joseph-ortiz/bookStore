# bookStore
A bookStore java spring boot reduce with TDD

Deplying to Heroku
- add github workflow actions .github/workflows/gradle.yml
- update gradle.yml file with a unique heroku app name. (the heroku action will create the repo on 1st build. Afterwards it will update)
- Procfile - needed to specify jar for Heroku Dyno 
- system.properites - needed to specify JDK version for heroku build
- github actions workflow - needed to specify the heroku step and api key to deploy the org.
  - Add API key "HEROKU_API_KEY" to the repo settings. Settings --> secrets & variables --> actions
