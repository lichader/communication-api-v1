pipeline {
    agent none
    stages {
        stage('Build') {
            agent {
                docker {
                    image 'gradle:6.4-jdk11'
                }
            }
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
            agent any
            steps {
                echo "Start publishing in ${env.BUILD_ID}"
                script {
                    def newImage = docker.build("lichader/communication-api-v1:${env.BUILD_ID}")
                    docker.withRegistry('', "dockerhub_id") {
                        newImage.push()
                    }
                }
            }
        }
    }
}