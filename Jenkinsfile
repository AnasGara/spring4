pipeline {
  agent any
  tools {
    maven 'maven'
    nodejs 'NodeJS'
  }
  stages {
    stage("Clean up") {
      steps {
        deleteDir()
      }
    }
    
    stage("Clone and Install Angular app") {
      steps {
        sh "git clone https://github.com/AnasGara/Jen4"
        dir("Jen4") {
          sh "npm install"
        }
      }
    }

    stage("Build Angular App") {
      steps {
        dir("Jen4") {
          sh "ng build --configuration=production"
        }
      }
    }

    stage("Clone and Build Spring Boot app") {
      steps {
        sh "git clone https://github.com/AnasGara/spring4"
        dir("spring4") {
          sh "mvn clean install"
        }
      }
    }

    stage("Generate Backend Image") {
      steps {
        dir("spring4") {
          sh "docker build -t spring4 ."
        }
      }
    }

    stage("Run Docker Compose") {
      steps {
        dir("spring4") {
          sh "docker compose up -d"
        }
      }
    }
  }
}
