pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/LasyaMoravineni/pet-clinic-app.git'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t pet-clinic-app .'
            }
        }

        stage('Run Docker Container') {
            steps {
                sh 'docker stop petclinic || true'
                sh 'docker rm petclinic || true'
                sh 'docker run -d -p 8080:8080 --name petclinic pet-clinic-app'
            }
        }
    }
}
