

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Simple PDF demo</title>
        <style>
        	.code_table {
        		width:80%;
        		background-color:#b2b2b2;
        	}
        	.code_table tr {padding:2px;}
        	.code_table td {
        		padding:7px;
        		background-color: #fff;
        	}
        </style>
    </head>
    <body>
   
	    <h1>Sample PDF Plugin demo page</h1>
	    
	    <h2>Tag Documentation / Examples</h2>
	    <h3>pdfLink tag:</h3>
	    <table class="code_table">
	        <thead>
	            <tr>
	                <th>Description</th>
	                <th>Sample Source/HTML output</th>
	                <th>In Action</th>
	            </tr>
	        </thead>
	        <tbody>
	        <tr>
	            <td rowspan="2" >Simple Usage:</td>
	            <td>
	                &lt;g:pdfLink url="/pdf/demo2"&gt;PDF View&lt;/g:pdfLink&gt;
	            </td>
	            <td rowspan="2">
	                <g:pdfLink url="/pdf/demo2">PDF View</g:pdfLink>
	            </td>
	        </tr>
	        <tr>
	        	<td>
	        		&lt;a class="pdf" title="pdf" href="/pdf/pdf/pdfLink?url=%2Fpdf%2Fdemo2&filename=document.pdf"&gt;<br />
	        		PDF View <br />
	        		&lt;/a&gt;
	        	</td>
	        </tr>
	        <tr>
	            <td rowspan="2" >Simple Usage w/ Get data:</td>
	            <td>
	                &lt;g:pdfLink url="/pdf/demo2/5?name=bob&age=22"&gt;PDF View&lt;/g:pdfLink&gt;
	            </td>
	            <td rowspan="2">
	                <g:pdfLink url="/pdf/demo2/5?name=bob&age=22">PDF View</g:pdfLink>
	            </td>
	        </tr>
	        <tr>
	        	<td>
	        		&lt;a class="pdf" title="pdf" href="/pdf/pdf/pdfLink?url=%2Fpdf%2Fdemo2%2F5%3Fname%3Dbob%26age%3D22&filename=document.pdf"&gt;<br />
	        		PDF View <br />
	        		&lt;/a&gt;
	        	</td>
	        </tr>
	        <tr>
	            <td rowspan="2" >Custom filename</td>
	            <td>
	                &lt;g:pdfLink url="/pdf/demo2.gsp" filename="sample.pdf"&gt;sample.pdf&lt;/g:pdfLink&gt;
	            </td>
	            <td rowspan="2" > 
	                <g:pdfLink url="/pdf/demo2.gsp" filename="sample.pdf">sample.pdf</g:pdfLink>
	            </td>
	        </tr>
	        <tr>
	        	<td>
	        		&lt;a class="pdf" title="pdf" href="/pdf/pdf/pdfLink?url=%2Fpdf%2Fdemo2.gsp&filename=sample.pdf"&gt;<br />
	        		sample.pdf<br />
	        		&lt;/a&gt;
	        	</td>
	        </tr>
	        <tr>
	            <td rowspan="2">Bundled icon</td>
	            <td>
	                &lt;g:pdfLink url="/pdf/demo2.gsp" filename="sample.pdf" icon="true"/&gt;
	            </td>
	            <td rowspan="2">
	                <g:pdfLink url="/pdf/demo2.gsp" filename="sample.pdf" icon="true"/>
	            </td>
	        </tr>
	        <tr>
	        	<td>
	        		&lt;a class="pdf" title="pdf" href="/pdf/pdf/pdfLink?url=%2Fpdf%2Fdemo2.gsp&filename=sample.pdf"&gt; <br />
	        		&lt;img border="0" alt="PDF Version" src="/pdf/images/pdf_button.png" /&gt; <br />
	        		&lt;/a&gt;
	        	</td>
	        </tr>
	        <tr>
	            <td rowspan="2">Bundled icon w/ link content</td>
	            <td>
	                &lt;g:pdfLink url="/pdf/demo2.gsp" filename="sample.pdf" icon="true" class="myPdfLink"&gt;Custom link&lt;/g:pdfLink&gt;
	            </td>
	            <td rowspan="2">
	                <g:pdfLink url="/pdf/demo2.gsp" filename="sample.pdf" icon="true" class="myPdfLink">Custom link</g:pdfLink>
	            </td>
	        </tr>
	        <tr>
	        	<td>
	        		&lt;a class="myPdfLink" title="pdf" href="/pdf/pdf/pdfLink?url=%2Fpdf%2Fdemo2.gsp&filename=sample.pdf"&gt; <br />
	        		&lt;img border="0" alt="PDF Version" src="/pdf/images/pdf_button.png" /&gt; <br />
	        		Custom link<br />
	        		&lt;/a&gt;
	        	</td>
	        </tr>
	        </tbody>
	    </table>
	    
	    <h3>pdfForm tag:</h3>
	    <table class="code_table">
	        <thead>
	            <tr>
	                <th>Description</th>
	                <th>Sample Source/HTML output</th>
	                <th>In Action</th>
	            </tr>
	        </thead>
	        <tbody>
	        <tr>
	            <td rowspan="2" >Simple Usage:</td>
	            <td>
	                &lt;g:pdfForm url="/pdf/demo2"&gt;...&lt;/g:pdfForm&gt;
	            </td>
	            <td rowspan="2">
	                <g:pdfForm url="/pdf/demo2" >
				    	name:<br />
						<g:textField name="name" size="10"/>
						<g:submitButton name="printPdf" value="pdf" />
				    </g:pdfForm>
	            </td>
	        </tr>
	        <tr>
	        	<td>
	        		&lt;form id="simplePdfForm" method="get" action="/pdf/pdf/pdfForm" name="simplePdfForm"&gt;<br />
	        		&lt;input type="hidden" value="/pdf/demo2" name="url"/&gt;<br />
					&lt;input type="hidden" value="document.pdf" name="filename"/&gt;<br />
	        		 ...<br /> 
	        		&lt;/form&gt;
	        	</td>
	        </tr>
	        <tr>
	            <td rowspan="2" >w/ Id and Filename:</td>
	            <td>
	                &lt;g:pdfForm url="/pdf/demo2/1968" filename="sample.pdf"&gt;...&lt;/g:pdfForm&gt;
	            </td>
	            <td rowspan="2">
	                <g:pdfForm url="/pdf/demo2/1968" filename="sample.pdf">
				    	age:<br />
						<g:textField name="age" size="3"/>
						<g:submitButton name="printPdf" value="pdf" />
				    </g:pdfForm>
	            </td>
	        </tr>
	        <tr>
	        	<td>
	        		&lt;form id="simplePdfForm" method="get" action="/pdf/pdf/pdfForm" name="simplePdfForm"&gt;<br />
	        		&lt;input type="hidden" value="/pdf/demo2/1968" name="url"/&gt;<br />
					&lt;input type="hidden" value="sample.pdf" name="filename"/&gt;<br />
	        		 ...<br /> 
	        		&lt;/form&gt;
	        	</td>
	        </tr>
	        <tr>
	            <td rowspan="2" >Post Method:</td>
	            <td>
	                &lt;g:pdfForm controller="pdf" action="demo3" method="post"&gt;...&lt;/g:pdfForm&gt;
	            </td>
	            <td rowspan="2">
	                <g:pdfForm controller="pdf" action="demo3" method="post" >
				    	food:<br />
						<g:textField name="food" size="10"/>
						<g:submitButton name="printPdf" value="pdf" />
				    </g:pdfForm>
	            </td>
	        </tr>
	        <tr>
	        	<td>
	        		&lt;form id="simplePdfForm" method="post" action="/pdf/pdf/pdfForm" name="simplePdfForm"&gt;<br />
	        		&lt;input type="hidden" value="pdf" name="pdfController"/&gt;<br />
	        		&lt;input type="hidden" value="demo3" name="pdfAction"/&gt;<br />
					&lt;input type="hidden" value="document.pdf" name="filename"/&gt;<br />
	        		 ...<br /> 
	        		&lt;/form&gt;
	        	</td>
	        </tr>
	        <tr>
	            <td rowspan="2" >2nd Post Example using template:</td>
	            <td>
	                &lt;g:pdfForm template="demo2" filename="sample.pdf"&gt;...&lt;/g:pdfForm&gt;
	            </td>
	            <td rowspan="2">
	                <g:pdfForm template="demo2" filename="sample.pdf" method="post">
				    	hometown:<br />
						<g:textField name="hometown" size="10"/>
						<g:submitButton name="printPdf" value="pdf" />
				    </g:pdfForm>
	            </td>
	        </tr>
	        <tr>
	        	<td>
	        		&lt;form id="simplePdfForm" method="post" action="/pdf/pdf/pdfForm2" name="simplePdfForm"&gt;<br />
	        		&lt;input type="hidden" value="demo2" name="template"/&gt;<br />
					&lt;input type="hidden" value="sample.pdf" name="filename"/&gt;<br />
	        		 ...<br /> 
	        		&lt;/form&gt;
	        	</td>
	        </tr>
	        
	        </tbody>
	    </table>
	    
%{--    <h3>Here is some data passed from the controller...</h3>
	    <p>First Name: ${firstName}</p>
	    <p>Last Name: ${lastName}</p>
	    <p>Age: ${age}</p> --}%
    </body>
</html>
