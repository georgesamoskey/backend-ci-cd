pipeline {
  agent any
  stages {
    stage("Verifications des outils ") {
      steps {
        sh 'docker version'
        sh 'docker info'
        sh 'docker compose version'
        sh 'curl --version'
            }
        }
    stage("Creations des volumes ") {
     steps {
            sh 'docker system prune -a --volumes -f'
        }
    }
    stage(" Deploiement de container ") {
     steps {
             sh 'docker compose up -d '
             sh 'docker compose ps'
        }
    }
    

    stage('Verification de la  response') {
        steps {
            sh 'curl http://localhost:8097'
        }
    } 

  }

  post{
    always{
        // bat 'docker compose down --remove-orphans
        sh 'docker compose ps'
    }
}
}