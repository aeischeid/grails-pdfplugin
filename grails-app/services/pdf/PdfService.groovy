package pdf

import net.sf.ehcache.*
import net.sf.ehcache.store.*
import org.apache.commons.logging.LogFactory
import org.codehaus.groovy.grails.commons.ConfigurationHolder
import org.xhtmlrenderer.pdf.ITextRenderer

class PdfService {

	boolean transactional = false

/*  A Simple fetcher to turn a specific URL into a PDF.  */

	byte[] buildPdf(url) {
		log.debug "PdfService ****************************************************"
		log.debug "    buildPdf: url = " + url
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ITextRenderer renderer = new ITextRenderer();
		try {
			renderer.setDocument(url);
			renderer.layout();
			renderer.createPDF(baos);
			byte[] b = baos.toByteArray();
			return b
		} catch (e) {
			log.error "There was an error generating the pdf: " + e
		}
	}

/*
	A Simple fetcher to turn a well formated XHTML string into a PDF
	The baseUri is included to allow for relative URL's in the XHTML string
*/

	byte[] buildPdfFromString(content, baseUri) {
		log.debug "PdfService ****************************************************"
		log.debug "    buildPdfFromString: baseUri = " + baseUri
		log.debug "    buildPdfFromString: content = " + content
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ITextRenderer renderer = new ITextRenderer();
		try {
			renderer.setDocumentFromString(content, baseUri);
			renderer.layout();
			renderer.createPDF(baos);
			byte[] b = baos.toByteArray();
			return b
		} catch (e) {
			log.error "There was an error generating the pdf: " + e
		}
	}

}

