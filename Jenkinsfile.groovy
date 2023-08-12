pipeline {
    agent any
    
    environment {
        AWS_ACCESS_KEY_ID = credentials('aws-access-key')
        AWS_SECRET_ACCESS_KEY = credentials('aws-secret-key')
        AWS_REGION = 'ap-south-1'
        S3_BUCKET = 'my-web-app-bucket'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                sh 'npm install' // Assuming you need to install dependencies
            }
        }
        
        stage('Deploy to S3') {
            steps {
                withAWS(region: AWS_REGION, credentials: 'aws-credentials') {
                    sh "aws s3 sync . s3://${S3_BUCKET} --delete"
                }
            }
        }
    }
}
