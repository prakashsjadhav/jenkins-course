pipelineJob('NodeJS Pipeline Job DSL Docker example') {
  definition {
    cpsScm {
      scm {
        git {
	      remote {
		    url('git://github.com/wardviaene/docker-demo.git')
            scriptPath('misc/Jenkinsfile')
		  }
        }
      }
	}
  }
  triggers {
    scm('H/5 * * * *')
  }
  wrappers {
        nodejs('nodejs') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
  }
  steps {
    dockerBuildAndPublish {
      repositoryName('prakashsjadhav2019/docker-nodejs-demo')
      tag('${GIT_REVISION,length=9}')
      registryCredentials('dockerhub')
      forcePull(false)
      forceTag(false)
      createFingerprints(false)
      skipDecorate()
    }
  }
}
