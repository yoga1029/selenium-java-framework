pipeline {
    agent any

    tools {
        maven 'Maven-3.9.16'
    }

    stages {

        stage('Build & Test') {
            steps {
                sh 'mvn clean test'
            }
        }

    }
}