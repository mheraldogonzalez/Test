pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://tu-repo.git'
            }
        }
        stage('Build') {
            steps {
                sh './mvnw clean install'
            }
        }
        stage('Run Tests') {
            steps {
                sh './mvnw test -Dcucumber.options="--tags @regression"'
            }
        }
        stage('Report') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
            }
        }
        stage('Upload Results to Xray') {
            steps {
                sh 'curl -H "Content-Type: multipart/form-data" -u usuario:token \
                -F "file=@target/cucumber.json" \
                https://tu-jira/rest/raven/1.0/import/execution/cucumber'
            }
        }
    }
}
