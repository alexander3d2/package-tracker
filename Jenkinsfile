pipeline {
    agent any

    environment {
        // Asegúrate de tener las credenciales de GitHub configuradas
        GITHUB_CREDENTIALS = 'Github'
    }

    stages {
        stage('Clonar Repositorio') {
            steps {
                git credentialsId: "${GITHUB_CREDENTIALS}", url: 'https://github.com/alexander3d2/package-tracker.git'
            }
        }

        stage('Construir Aplicación') {
            steps {
                script {
                    sh './mvnw clean package'
                }
            }
        }

        stage('Ejecutar Aplicación de Escritorio') {
            steps {
                script {
                    // Ejecutar el JAR generado por Maven
                    sh 'java -jar target/package-tracker-0.0.1-SNAPSHOT.jar'
                }
            }
        }
    }

    post {
        success {
            echo 'Despliegue exitoso!'
        }
        failure {
            echo 'Hubo un error en el despliegue.'
        }
    }
}
