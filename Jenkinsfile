pipeline {
  agent any
  stages {
    stage("Verifications docker ") {
      steps {
        sh 'snapctl run docker version'
        sh 'snapctl run docker info'
        sh 'snapctl run docker compose version'
        sh 'snapctl runcurl --version'
            }
        }
    stage("Creations des volumes ") {
     steps {
            sh 'snapctl run docker system prune -a --volumes -f'
        }
    }
    stage(" Deploiement ") {
     steps {
             sh 'snapctl run docker compose up -d  --no-color --wait'
             sh 'snapctl run docker compose ps'
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
        sh 'snapctl run docker compose ps'
    }
}
}