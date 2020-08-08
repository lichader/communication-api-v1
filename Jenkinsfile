pipeline {
    agent {
        docker {
            image 'gradle:6.4-jdk11'
        }
    }
    stages {
        stage('Build') {
            steps {
                echo "Start building"
                sh "gradle clean build"
                sh "ls build/libs/*"
            }
            post {
                always {
                    junit 'build/test-results/**/**.xml'
                }
            }
        }
        stage('Publish') {
            steps {
                echo "Start publishing"
            }
        }
    }
}