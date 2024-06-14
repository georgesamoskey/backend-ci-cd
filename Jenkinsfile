pipeline {
  agent any
  environment {
    PATH = "/snap/bin:$PATH"
   }

  stages {
    stage("Verifications docker ") {
      steps {
        sh 'snapctl --user=jenkins run docker version'
        // sh 'snap run docker info'
        // sh 'snap run docker compose version'
        // sh 'snap run curl --version'
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
        // bat 'docker compose down --remove-orphans
        sh 'snap run docker compose ps'
    }
}
}