
pipeline {
    agent any

    stages {
        stage('Clean') {
            steps {
                bat '.\\gradlew.bat clean'
            }
        }

        stage('Compile Java') {
            steps {
                bat '.\\gradlew.bat compileJava'
            }
        }

        stage('Run Tests') {
            steps {
                bat '.\\gradlew.bat test'
            }
        }

        stage('Generate JAR') {
            steps {
                bat '.\\gradlew.bat jar'
            }
        }

        stage('Build') {
            steps {
                bat '.\\gradlew.bat build'
            }
        }

        stage('Run Calculator') {
            steps {
                bat 'java -jar .\\build\\libs\\calculator-gradle-1.0.0.jar 12 multiply 4'
            }
        }
    }

    post {
        always {
            junit testResults: 'build/test-results/test/*.xml',
                  allowEmptyResults: true
        }

        success {
            archiveArtifacts artifacts: 'build/libs/*.jar',
                             fingerprint: true
        }
    }
}
