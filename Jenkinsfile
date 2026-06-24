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
		post {
		    always {
		        publishHTML([
		            allowMissing: true,
		            alwaysLinkToLastBuild: true,
		            keepAll: true,
		            reportDir: 'Reports',
		            reportFiles: 'ExtentReport.html',
		            reportName: 'Extent Report'
		        ])
		    }
		}
       

    }
}

