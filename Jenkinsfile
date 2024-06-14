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
    stage(" Demarrage de container ") {
     steps {
             sh 'docker compose up -d  --no-color --wait'
             sh 'docker compose ps'
        }
    }
    

    stage('Check Response') {
        steps {
            sh 'curl http://localhost'
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