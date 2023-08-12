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
                // Build Docker image and package your code
                sh 'docker build -t mywebapp .'
            }
        }

        stage('Deploy') {
            steps {
                // Deploy the Docker container
                sh 'docker run -d -p 80:80 mywebapp'
            }
        }
    }
}
