// Esta función reemplaza todo el código repetitivo de build y push
// Recibe el nombre de la imagen como parámetro
def call(String imageName) {
    
    stage('Clonar repositorio') {
        checkout scm
    }

    stage('Build y Push a Docker Hub') {
        sh """
            docker login -u justing0 -p dckr_pat_Cp48FdPKfj-76paEBamKNw0v0vE
            docker buildx build --platform linux/amd64 -t ${imageName}:latest --push .
        """
    }
}
