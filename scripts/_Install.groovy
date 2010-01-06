
Ant.mkdir(dir:"${basedir}/grails-app/views/pdf")
Ant.copy(file:"${pluginBasedir}/grails-app/views/pdf/demo.gsp",
         todir:"${basedir}/grails-app/views/pdf")
Ant.copy(file:"${pluginBasedir}/grails-app/views/pdf/demo2.gsp",
         todir:"${basedir}/grails-app/views/pdf")
Ant.copy(file:"${pluginBasedir}/grails-app/views/pdf/_demo2.gsp",
         todir:"${basedir}/grails-app/views/pdf")	
Ant.copy(file:"${pluginBasedir}/grails-app/views/pdf/demo3.gsp",
         todir:"${basedir}/grails-app/views/pdf")
Ant.copy(file:"${pluginBasedir}/grails-app/views/pdf/sampleInclude.gsp",
         todir:"${basedir}/grails-app/views/pdf")
         
//this script installs the demo files for the PDF plugin. The file and the 
//directory can be removed easily, and by the way this is my first GANT script :)
