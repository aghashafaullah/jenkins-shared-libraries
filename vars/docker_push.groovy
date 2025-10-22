def call(String Project, String ImageTag, String docekrhubuser){
  echo "This is the pushing the image to the DockerHub"
  withCredentials([usernamePassword(credentialsId: 'dockerHubCred', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]){
      sh "docker login -u ${dockerHubUser}" -p ${dockerHubPass} 
  }
  sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
}
