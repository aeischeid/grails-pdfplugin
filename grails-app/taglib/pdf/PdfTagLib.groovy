package pdf

import org.codehaus.groovy.grails.plugins.web.taglib.ApplicationTagLib

/*
  A simple taglib for producing links to the PDF creation for a page.
  @authors Aaron Eischeid, Glen Smith
*/

class PdfTagLib {

    /*
      Creates a PDF creation link for the supplied URL.
      eg. <g:pdf url="/test.gsp" filename="sample.pdf" icon="true"/>
    */

  def pdfLink = { attrs, body ->
    //String template = attrs['template']
    String pdfController = attrs['pdfController']
    String pdfAction = attrs['pdfAction']
    String pdfId = attrs['pdfId']
    //String pdfParams = attrs['pdfParams']
    String url = attrs['url']
    String filename = attrs['filename']
    String link
    // class attribute is for CSS styling
    String c = attrs['class'] ?: 'pdf'
    if(url){
      link = new ApplicationTagLib().createLink(url: [controller:'pdf', action:'pdfLink',
             params: [url: attrs.url] ] )
    }
    //if(template){
      //link = new ApplicationTagLib().createLink(url: [controller:'pdf', action:'pdfLink',
             //params: [template: "${template}"] ] )
    //}
    if(pdfController){
      link = new ApplicationTagLib().createLink(url: [controller:'pdf', action:'pdfLink',
             params: [pdfController:"${pdfController}"] ] )
      if(pdfAction) link += "&pdfAction=${pdfAction}"
      if(pdfId) link+= "&pdfId=${pdfId}"
    }
    if(filename){ link += "&filename=${filename}" }
    out << """
      <a href="${link}" class="${c}" title="pdf">
    """
    // setup icon/button inside of link if icon is set to 'true'
    if (attrs.icon) {
      out << "<img src='"
      out << createLinkTo(dir:'images', file:'pdf_button.png')
      out << "' alt='PDF Version' border='0'/>"
    }
    out << body()
    out << "</a>"
  }

  /*
    Creates a form. When submitted will create a PDF of given URL that can reference form data
    eg. <g:pdfForm url="/pdf/demo2" filename="sample.pdf" />
  */

  def pdfForm = { attrs, body -> 
    String formName = attrs['name'] ?: "simplePdfForm"
    String url = attrs['url']
    String template = attrs['template']
    String controller = attrs['controller']
    String action = attrs['action']
    String id = attrs['id']
    String filename = attrs['filename'] ?: 'document.pdf'
    String method = attrs['method'] ?: 'get'
    def uri = createLink(url: [controller: 'pdf', action:'pdfForm' ])
    
    out << """
      <form name="${formName}" class="${formName}" action="${uri}" method="${method}">
    """
    if(filename){
      out << """
        <input type="hidden" name="filename" value="${filename}" />
      """
    }
    
    if(url){
      out << """
        <input type='hidden' name='url' value="${url}" />
      """
    }
    if(template){
      out << """
        <input type='hidden' name='template' value="${template}" />
      """
    }
    else{
      out << """
        <input type='hidden' name='pdfController' value="${controller}" />
        <input type='hidden' name='pdfAction' value="${action}" />
      """
      if(id){
        out << """
          <input type='hidden' name='id' value="${id}" />
        """
      }
    }
    out << body()
    out << "</form>"
  }
}
