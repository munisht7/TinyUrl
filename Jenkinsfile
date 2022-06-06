pipeline {
    agent any

    stages {

        stage ('Compile Stage') {

            steps {
                withMaven(maven : 'maven_3') {
                            sh 'mvn clean compile'
                        }
                    }
                }

        stage ('Testing Stage') {

            steps {
                withMaven(maven : 'maven_3') {
                    sh 'mvn test'
                }
            }
        }

      //  tried creating the free repo on the maven repository but couldn't create one so skipping the depolyment as of now
//         stage ('Deployment Stage') {
//             steps {
//                 withMaven(maven : 'maven_3_5_0') {
//                     sh 'mvn deploy'
//                 }
//             }
//         }
    }
}