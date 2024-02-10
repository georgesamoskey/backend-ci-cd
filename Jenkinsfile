pipeline {
  agent any
  stages {
    stage("Verification des outils ") {
      steps {
        bat 'docker version'
        bat 'docker info'
        bat 'docker compose version'
        bat 'curl --version'
            }
        }
    stage("Creations des volumes ") {
     steps {
            bat 'docker system prune -a --volumes -f'
        }
    }
    stage(" Demarrage de container ") {
     steps {
             bat 'docker compose up -d  --no-color --wait'
             bat 'docker compose ps'
        }
    }

  }
}