pipeline {
    agent any
    //tools { 
        // maven 'Maven 3.3.9' 
        // jdk 'jdk8' 
    //}
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    export M2_HOME = /opt/maven
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
            }
        }

        stage ('Build') {
            steps {
                echo 'This is a minimal pipeline.'
            }
        }
    }
}
