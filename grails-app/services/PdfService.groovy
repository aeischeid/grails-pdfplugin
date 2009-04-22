import net.sf.ehcache.*
import net.sf.ehcache.store.*
import org.apache.commons.logging.LogFactory
import org.codehaus.groovy.grails.commons.ConfigurationHolder
import org.xhtmlrenderer.pdf.ITextRenderer


class PdfService {

    boolean transactional = false

/*  A Simple fetcher to turn a specific URL into a PDF.  */
	byte[] buildPdf(url) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        ITextRenderer renderer = new ITextRenderer();
        try {
        	renderer.setDocument(url);
        	renderer.layout();
        	renderer.createPDF(baos);
        	byte[] b = baos.toByteArray();
	        return b
        }
        catch (Throwable e) {
        	log.error e
        }
    }
    
/*  A Simple fetcher to turn a well formated HTML string into a PDF.  */
    byte[] buildPdfFromString(content) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        ITextRenderer renderer = new ITextRenderer();
        try {
        	renderer.setDocumentFromString(content);
        	renderer.layout();
        	renderer.createPDF(baos);
        	byte[] b = baos.toByteArray();
	        return b
        }
        catch (Throwable e) {
        	log.error e
        }
    }
}

