pipeline {
  agent any
  environment {
        DOCKER_HOST = 'unix:///var/run/docker.sock'
   }

  stages {
    stage("Verifications docker ") {
      steps {
        sh ' docker version'
        // sh 'snap run docker info'
        // sh 'snap run docker compose version'
        // sh 'snap runcurl --version'
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