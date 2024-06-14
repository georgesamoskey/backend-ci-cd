pipeline {
  agent any
  environment {
    PATH = "/snap/bin:$PATH"
   }

  stages {
    stage("Verifications docker ") {
      steps {
        sh 'snap run docker version'
        sh 'snap run docker info'
        sh 'snap run docker compose version'
        sh 'snap runcurl --version'
            }
        }
    stage("Creations des volumes ") {
     steps {
            sh 'snap run docker system prune -a --volumes -f'
        }
    }
    stage(" Deploiement ") {
     steps {
             sh 'snap run docker compose up -d  --no-color --wait'
             sh 'snap run docker compose ps'
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
        // bat 'docker compose down --remove-orphanss
        sh 'snap run docker compose ps'
    }
}
}