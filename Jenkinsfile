pipeline {
    agent any

    stages {
        stage('Limpieza de Repositorio Maven') {
            steps {
                bat 'mvn clean install -U'  // El parámetro -U forzará a Maven a actualizar las dependencias
            }
        }
        stage('Clonar Repositorio') {
            steps {
                git branch: 'main', url: 'https://github.com/alexander3d2/package-tracker.git'
            }
        }
        stage('Construir Aplicación') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('Ejecutar Aplicación de Escritorio') {
            steps {
                sh 'java -jar target/package-tracker-1.0-SNAPSHOT.jar'
            }
        }
    }
}
