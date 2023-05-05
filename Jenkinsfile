pipeline {
    agent any

    stages {
        stage('Echo') {
            steps {
				echo 'this is feature1'
			}
        }
        stage('Compile') {
            steps {
                sh 'chmod +x ./gradlew && ./gradlew compileJava'
            }
        }
        stage('Unit test') {
            steps {
                sh './gradlew test --info'
            }
        }

        stage('Code coverage') {
            steps {
                sh './gradlew jacocoTestCoverageVerification'
                sh './gradlew jacocoTestReport'
                publishHTML(target: [
                    reportDir: 'build/reports/jacoco/test/html',
                    reportFiles: 'index.html',
                    reportName: 'JaCoCo Report'
                ])
            }
        }
        stage('Static code analysis') {
            steps {
                sh './gradlew checkstyleMain'
                publishHTML(target: [
                    reportDir: 'build/reports/checkstyle/',
                    reportFiles: 'main.html',
                    reportName: 'CheckStyle Report'
                ])
            }
        }
    }
}
