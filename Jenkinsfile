pipeline {
    agent any

    stages {
        stage('Clonar Repositorio') {
            steps {
                git branch: 'main', credentialsId: 'TUS_CREDENCIALES_ID', url: 'https://github.com/alexander3d2/package-tracker.git'
            }
        }
        stage('Construir Aplicación') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Ejecutar Aplicación de Escritorio') {
            steps {
                sh 'java -jar target/package-tracker-1.0-SNAPSHOT.jar'
            }
        }
    }
}
