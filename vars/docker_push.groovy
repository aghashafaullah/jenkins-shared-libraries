def call(String Project, String ImageTag, String docekrhubuser){
  echo "This is the pushing the image to the DockerHub"
  withCredentials([usernamePassword(credentialsId: 'dockerHubCred', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]){
      sh """echo "$dockerHubPass" | docker login -u "$dockerHubUser" --password-stdin"""
  }
  sh """
      docker push ${dockerhubuser}/${Project}:${ImageTag}
  """
}
