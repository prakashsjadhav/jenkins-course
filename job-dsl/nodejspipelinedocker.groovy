pipelineJob('NodeJS Pipeline Job DSL Docker example') {
  definition {
    cpsScm {
      scm {
        git {
	      remote {
		    url('https://github.com/prakashsjadhav/docker-demo.git')
            scriptPath('misc/Jenkinsfile')
		  }
        }
      }
	}
  }
  triggers {
    scm('H/5 * * * *')
  }
}
