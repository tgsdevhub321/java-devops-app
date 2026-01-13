pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "tgsdevops/java-devops-app"
        DOCKER_TAG = "latest"
        DEPLOY_SERVER = "ubuntu@172.31.18.38"
    }

    stages {

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE:$DOCKER_TAG .'
            }
        }

        stage('Login to DockerHub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
                    sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                sh 'docker push $DOCKER_IMAGE:$DOCKER_TAG'
            }
        }

        stage('Deploy to App Server') {
            steps {
                sh """
                ssh -o StrictHostKeyChecking=no $DEPLOY_SERVER '
                    docker pull $DOCKER_IMAGE:$DOCKER_TAG
                    docker stop java-app || true
                    docker rm java-app || true
                    docker run -d --name java-app -p 8080:8080 $DOCKER_IMAGE:$DOCKER_TAG
                '
                """
            }
        }
    }
}
