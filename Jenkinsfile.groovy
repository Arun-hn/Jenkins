pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout your repository from GitHub
                checkout([$class: 'GitSCM', 
                          branches: [[name: '*/main']], 
                          userRemoteConfigs: [[url: 'https://github.com/Arun-hn/Jenkins.git']]])
            }
        }

        stage('Build and Package') {
            steps {
                // Build Docker image
                sh 'docker build -t mywebapp .'
            }
        }

        stage('Deploy') {
            steps {
                // Run Docker container from the built image
                sh 'docker run -d -p 80:80 mywebapp'
            }
        }
    }
}
