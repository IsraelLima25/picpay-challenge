def NAME_ARTIFACT = "UNINTIALIZED"
def VERSION_ARTIFACT = "UNINTIALIZED"

pipeline{

    agent any

    options {
        ansiColor('xterm')
    }

    stages{

        stage('Build') {
            steps{
               sh 'mvn -Dmaven.test.skip=true -Dtests.unit.skip=true clean package'
               script {
                    NAME_ARTIFACT = readMavenPom().getName()
                    VERSION_ARTIFACT = readMavenPom().getVersion()
                }
            }
        }

        stage('Unit Tests') {
            steps{
               sh 'mvn -Dmaven.test.skip=false test'
            }
        }
    }
}