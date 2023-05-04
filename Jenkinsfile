pipeline {
    agent any

    stages {
        stage('Compile'){
            steps {
                sh "chmod +x ./gradlew && ./gradlew compileJava"
            }
        }
        stage("Unit test") {
            steps {
                sh "./gradlew test --info"
            }
        }

        stage("Code coverage") {
            steps {
                sh "./gradlew jacocoTestCoverageVerification"
                sh "./gradlew jacocoTestReport"
            }
        }
    }
}