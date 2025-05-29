pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/your-username/sample-app.git'
            }
        }

        stage('Build Image') {
            steps {
                sh 'docker build -t blue-app:latest .'
            }
        }

        stage('Deploy to Green') {
            steps {
                sh 'docker stop green || true && docker rm green || true'
                sh 'docker run -d --name green -p 8082:80 blue-app:latest'
            }
        }

        stage('Health Check') {
            steps {
                sh 'curl --fail http://localhost:8082 || exit 1'
            }
        }

        stage('Switch Traffic to Green') {
            steps {
                sh 'cp ./nginx/green.conf ./nginx/default.conf'
                sh 'docker restart nginx-lb'
            }
        }

        stage('Shutdown Blue') {
            steps {
                sh 'docker stop blue || true && docker rm blue || true'
            }
        }
    }

    post {
        success {
            echo "Deployment successful to GREEN."
        }
        failure {
            echo "Deployment failed. Rollback may be needed."
        }
    }
}
