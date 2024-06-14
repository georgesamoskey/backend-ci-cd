pipeline {
  agent any
  environment {
    PATH = "/snap/bin:$PATH"
   }

  stages {
    stage("Verifications docker ") {
      steps {
        sh 'snapctl --user=jenkins run docker version'
        sh 'snapctl --user=jenkins run docker info'
        sh 'snapctl --user=jenkins run docker compose version'
        sh 'snapctl --user=jenkins run curl --version'
            }
        }
    stage("Creations des volumes ") {
     steps {
            sh 'snapctl --user=jenkins run docker system prune -a --volumes -f'
        }
    }
    stage(" Deploiement ") {
     steps {
             sh 'snapctl --user=jenkins run docker compose up -d  --no-color --wait'
             sh 'snapctl --user=jenkins run docker compose ps'
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