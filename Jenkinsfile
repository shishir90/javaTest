pipeline {
    agent any
    environment {
       M2_HOME = "/opt/maven"
       JAVA_HOME = "/usr/lib/jvm/jre"
       PATH = "/opt/maven/bin:$PATH"
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
                ''' 
            }
        }

        stage ('Build') {
            steps {
                sh "cd spring-boot-web-jsp-demo"
                sh "printenv | sort"
                sh "mvn compile"
            }
        }
    }
}
