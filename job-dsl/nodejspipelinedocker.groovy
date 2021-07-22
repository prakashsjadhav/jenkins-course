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
}
