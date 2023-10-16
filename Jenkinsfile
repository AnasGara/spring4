pipeline {
  agent any
  tools {
    maven 'maven'
  }
  stages {
    stage("Clean up") {
      steps {
        deleteDir()
      }
    }
    
    stage("Clone Angular repo and Install Dependencies") {
      steps {
        sh "https://github.com/AnasGara/Jen4"
        dir("angular-app") {
          sh "npm install"
        }
      }
    }

    stage("Build Angular App") {
      steps {
        dir("angular-app") {
          sh "ng build --prod"
        }
      }
    }

    stage("Generate Backend Image") {
      steps {
        dir("ex2") {
          sh "mvn clean install"
          sh "docker build -t ex2 ."
        }
      }
    }

    stage("Run Docker Compose") {
      steps {
        dir("ex2") {
          sh "docker-compose up -d"
        }
      }
    }
  }
}
