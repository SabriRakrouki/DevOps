pipeline {
     environment { 
        registry = "wofurani/achat" 
        registryCredential = 'dockerhub_id' 
        dockerImage = '' 
    }
    agent any

    stages {
        stage('git') {
            steps {
                echo 'git'
                git branch :'sabri',
                url : 'https://github.com/SabriRakrouki/DevOps.git'
            }
        }
        stage('mvn test') {
            steps {
                echo 'maven test'
                sh 'mvn  test'
            }
            
        }
        stage('mvn install') {
            steps {
                echo 'maven install'
                sh 'mvn install'
            }
        }
        stage('mvn compile') {
            steps {
                echo 'maven compile'
                sh 'mvn compile'
            }
        }
        stage('Sonar') {
            steps {
                echo 'sonar'
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sabri'
            }
        }
        stage('Nexus') {
            steps {
                echo 'nexus'
                sh 'mvn deploy -DskipTests'
            }
        }
         stage('Building our image') { 
            steps { 
                script { 
                    dockerImage = docker.build registry + ":$BUILD_NUMBER" 
                }
            } 
        }
        stage('Deploy our image') { 
            steps { 
                script { 
                    docker.withRegistry( '', registryCredential ) { 
                        dockerImage.push() 
                    }
                } 
            }
        } 
        stage('Docker compose') { 
            steps { 
                script { 
                    sh "docker-compose up --build -V -d"
                }
            } 
        }
        
    }
}