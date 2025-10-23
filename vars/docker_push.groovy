def call(String Project, String ImageTag, String dockerhubuser){
  withCredentials([usernamePassword(credentialsId: 'dockerHubCred', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]){
      sh '''
            echo "$dockerHubPass" | docker login -u "$dockerHubUser" --password-stdin
        '''
  }
  sh """
      docker push ${dockerhubuser}/${Project}:${ImageTag}
  """
  echo "✅ Docker image pushed successfully!"
}
