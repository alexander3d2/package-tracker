pipeline {
    agent any

    stages {
        stage('Clonar Repositorio') {
            steps {
                git branch: 'main', url: 'https://github.com/alexander3d2/package-tracker.git'
            }
        }
        stage('Limpieza y Construcción de la Aplicación') {
            steps {
                bat 'mvn clean install -DskipTests -U'  // Limpia, instala y actualiza dependencias
            }
        }
        stage('Ejecutar Aplicación de Escritorio') {
            steps {
                bat 'java -jar target/packageTracker-1.0-SNAPSHOT.jar' // Usa bat para ejecutar el JAR en Windows
            }
        }
    }
}
