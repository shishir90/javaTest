pipeline {
    agent any
    environment {
       M2_HOME = "/opt/maven"
   }
    //tools { 
        // maven 'Maven 3.3.9' 
        // jdk 'jdk8' 
    //}
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                    "printenv | sort"
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
