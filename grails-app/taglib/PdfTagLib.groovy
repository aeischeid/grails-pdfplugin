import org.codehaus.groovy.grails.plugins.web.taglib.ApplicationTagLib

/**
 * A simple taglib for producing links to the PDF creation for a page.
 *
 * @authors Aaron Eischeid, Glen Smith
 */
class PdfTagLib {

    /**
     * Creates a PDF creation link for the supplied URL.
     *
     * eg. <g:pdf url="/test.gsp" filename="sample.pdf" icon="true"/>
     *
     */
    def pdfLink = { attrs, body ->
        String link = new ApplicationTagLib().createLink(url: [controller: 'pdf', action:'pdfLink',
                      params: [url: attrs.url, filename: attrs.filename ?: 'document.pdf'] ] )
        String c = attrs['class'] ?: 'pdf'
        
        out << """
            <a href="${link}" class="${c}" title="pdf">
        """
        if (attrs.icon) {
            out << "<img src='"
            out << createLinkTo(dir:'images', file:'pdf_button.png')
            out << "' alt='PDF Version' border='0'/>"
        }
        out << body()
        out << "</a>"
    }

    /**
     * Creates a form. When submitted will create a PDF of given URL that can reference form data.
     *
     * eg. <g:pdfForm url="/pdf/demo2" filename="sample.pdf" />
     *
     */    
    def pdfForm = { attrs, body -> 
    	String formName = attrs['name'] ?: "simplePdfForm"
    	String url = attrs['url']
    	String template = attrs['template']
    	String controller = attrs['controller']
    	String action = attrs['action']
    	String filename = attrs['filename'] ?: 'document.pdf'
    	String method = attrs['method'] ?: 'get'
    	def uri = createLink(url: [controller: 'pdf', action:'pdfForm' ])
    	
    	out << """
    		<form name="${formName}" class="${formName}" action="${uri}" method="${method}">
    		<input type="hidden" name="filename" value="${filename}" />
    	"""
    	
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
    	}
    	out << body()
        out << "</form>"
    }
}
