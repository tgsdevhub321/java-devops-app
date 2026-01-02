pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/tgsdevhub321/java-devops-app.git'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t java-devops-app:latest .'
            }
        }

        stage('Deploy to App Server') {
            steps {
                sh '''
                ssh -o StrictHostKeyChecking=no ubuntu@172.31.18.38 "
                docker stop java-app || true
                docker rm java-app || true
                docker run -d --name java-app -p 8080:8080 java-devops-app:latest
                "
                '''
            }
        }

    }
}


