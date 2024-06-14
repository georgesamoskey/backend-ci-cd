pipeline {
  agent any
  environment {
        DOCKER_BINARY = '/snap/bin/docker'
   }

  stages {
    stage("Verifications docker ") {
      steps {
        sh '${DOCKER_BINARY} run docker version'
        sh '${DOCKER_BINARY} run docker info'
        sh '${DOCKER_BINARY} run docker compose version'
        sh '${DOCKER_BINARY} run curl --version'
            }
        }
    stage("Creations des volumes ") {
     steps {
            sh '${DOCKER_BINARY} run docker system prune -a --volumes -f'
        }
    }
    stage(" Deploiement ") {
     steps {
             sh '${DOCKER_BINARY} run docker compose up -d  --no-color --wait'
             sh '${DOCKER_BINARY} run docker compose ps'
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
        sh '${DOCKER_BINARY} run docker compose ps'
    }
}
}