pipeline {
    agent any

    stages {
        stage('Compile') {
            steps {
                sh 'chmod +x ./gradlew && ./gradlew build'
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
        stage('Docker build') {
            steps {
                sh 'docker build -t 10.222.60.139:5000/calcjenkins .'
            }
        }
        stage('Docker push') {
            steps {
                sh 'docker push 10.222.60.139:5000/calcjenkins'
            }
        }
    }
}
