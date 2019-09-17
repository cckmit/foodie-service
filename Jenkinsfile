def getHost(){
    def remote = [:]
    remote.name = 'mysql'
    remote.host = '192.168.8.108'
    remote.user = 'root'
    remote.port = 22
    remote.password = 'qweasd'
    remote.allowAnyHosts = true
    return remote
}
pipeline {
    agent {
        docker {
            image 'openjdk:8'
            label 'docker-local'
        }
    }
    stages {
        stage('Git') {
            steps {
                git 'https://github.com/demonran/foodie-service.git'
            }
        }
        // stage('Build') {
        //     steps {
        //         sh './gradlew clean build'
        //     }
        // }
        stage('init-server'){
            steps {
                script {
                   server = getHost()
                }
            }
        }
//         stage('Deploy') {
//             steps {
//                  sshPut remote:server, from: 'run.sh', into: '.'
//             }
//         }
    }
}
