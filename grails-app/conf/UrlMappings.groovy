class UrlMappings {
    static mappings = {
      "/$controller/$action?/$id?"{
	      constraints {
			 // apply constraints here
		  }
	  }
      "/"(view:"/pdf/demo.gsp")
	  "500"(view:'/error')
	}
}
