pipeline {
  agent any
  
  environment {
    AWS_ACCOUNT_ID="349415135410"
    AWS_DEFAULT_REGION="ap-northeast-2"
    JENKINS_CREDENTIAL="fitqa-aws-credential"
    IMAGE_REPO_NAME="fitqa"
    IMAGE_TAG="dev"
    REPOSITORY_URI="${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_DEFAULT_REGION}.amazonaws.com/${IMAGE_REPO_NAME}"
  }

  stages {
    stage('Clone repository') {
      steps {
        script {
          checkout scm
        }
      }
    }

    stage('Build Spring') {
      steps {
        script {
          sh "cd spring/fitqa-spring-java/; ./gradlew clean build"
          sh "cd ../.."
        }
      }
    }

    stage('Build Docker Image') {
      steps {
        script {
          dockerImage = docker.build "${IMAGE_REPO_NAME}:${IMAGE_TAG}"
        }
      }
    }

    stage('Push to ECR') {
      steps {
        script {
          sh 'rm ~/.dockercfg || true'
          sh 'rm ~/.docker/config.json || true'

          docker.withRegistry("https://${REPOSITORY_URI}", "ecr:${AWS_DEFAULT_REGION}:${JENKINS_CREDENTIAL}") {
            dockerImage.push()
          }
        }
      }
    }
  }
}