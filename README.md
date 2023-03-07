# bookStore
A bookStore java spring boot reduce with TDD

Deplying to Heroku
- Procfile - needed to specify jar for Heroku Dyno 
- system.properites - needed to specify JDK version for heroku build
- github actions workflow - needed to specify the heroku step and api key to deploy the org.
  - Add API key "HEROKU_API_KEY" to the repo settings. Settings --> secrets & variables --> actions
