package pdf

class PdfController {

  PdfService pdfService

  def index = { redirect(action: demo) }

  def pdfLink = {
    try{
      byte[] b
      def baseUri = request.scheme + "://" + request.serverName + ":" + request.serverPort + grailsAttributes.getApplicationUri(request)
      // def baseUri = g.createLink(uri:"/", absolute:"true").toString()
      // TODO: get this working...
      //if(params.template){
        //println "Template: $params.template"
        //def content = g.render(template:params.template, model:[pdf:params])
        //b = pdfService.buildPdfFromString(content.readAsString(), baseUri)
      //}
      if(params.pdfController){
        //println "GSP - Controller: $params.pdfController , Action: $params.pdfAction, Id: $params.pdfId" 
        def content = g.include(controller:params.pdfController, action:params.pdfAction, id:params.pdfId)
        b = pdfService.buildPdfFromString(content.readAsString(), baseUri)
      }
      else{
        def url = baseUri + params.url
        b = pdfService.buildPdf(url)
      }
      response.setContentType("application/pdf")
      response.setHeader("Content-disposition", "attachment; filename=" + (params.filename ?: "document.pdf"))
      response.setContentLength(b.length)
      response.getOutputStream().write(b)
    }
    catch (Throwable e) {
      println "there was a problem with PDF generation ${e}"
      //if(params.template) render(template:params.template)
      if(params.pdfController) redirect(controller:params.pdfController, action:params.pdfAction, params:params)
      else redirect(uri:params.url + '?' + request.getQueryString())
    }
  }

  def pdfForm = {
    try{
      byte[] b
      def baseUri = request.scheme + "://" + request.serverName + ":" + request.serverPort + grailsAttributes.getApplicationUri(request)
      // def baseUri = g.createLink(uri:"/", absolute:"true").toString()
      if(request.method == "GET") {
        def url = baseUri + params.url + '?' + request.getQueryString()
        //println "BaseUri is $baseUri"
        //println "Fetching url $url"
        b = pdfService.buildPdf(url)
      }
      if(request.method == "POST"){
        def content
        if(params.template){
          //println "Template: $params.template"
          content = g.render(template:params.template, model:[pdf:params])
        }
        else{
          content = g.include(controller:params.pdfController, action:params.pdfAction, id:params.id, pdf:params)
        }
        b = pdfService.buildPdfFromString(content.readAsString(), baseUri)
      }
      response.setContentType("application/pdf")
      response.setHeader("Content-disposition", "attachment; filename=" + (params.filename ?: "document.pdf"))
      response.setContentLength(b.length)
      response.getOutputStream().write(b)
    }
    catch (Throwable e) {
      println "there was a problem with PDF generation ${e}"
      if(params.template) render(template:params.template)
      if(params.url) redirect(uri:params.url + '?' + request.getQueryString())
      else redirect(controller:params.pdfController, action:params.pdfAction, params:params)
    }
  }

  def demo = {
    def firstName = params.first ?: "Eric"
    def lastName = params.last ?: "Cartman"
    def age = params.age
    return [firstName:firstName, lastName:lastName, age:age]
  }

  def demo2 = {
    def id = params.id
    def name = params.name
    def age = params.age
    def randomString = params.randomString ?: "PDF creation is a blast!!!"
    def food = params.food
    def hometown = params.hometown
    return [id:id, name:name, age:age, randomString:randomString, food:food, hometown:hometown]
  }

  def demo3 = {
    def today = new Date()
    def tomorrow = today +1
    def content = g.include(controller:"pdf", action:"sampleInclude", params:['today':today, 'tomorrow':tomorrow])
    return ['content':content, 'pdf':params, 'id':params.id]
  }

  def sampleInclude = {
    def bar = 'foo'
    def today = params?.today
    def tomorrow = params?.tomorrow
    return ['bar':bar, 'today':today, 'tomorrow':tomorrow]
    //[today:today, tomorrow:tomorrow]
  }

}

