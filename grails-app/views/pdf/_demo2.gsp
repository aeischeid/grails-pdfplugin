

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Simple PDF demo2</title>
        <style>
        	.sample_table {
        		width:60%;
        		background-color:#b2b2b2;
        	}
        	.sample_table th {
        		text-align:center;
        		text-decoration:underline;
        	}
        	.sample_table td {
        		padding:7px;
        		background-color: #fff;
        	}
        	.small_text {
        		font-size:8pt;
        	}
        </style>
    </head>
    <body>
   
	    <h1>Sample PDF Output</h1>
	    <h2>This is simple HTML</h2>
	    <h2 style='color:red'>this has inline CSS</h2>
	    
	    <h3>Here is some data passed from the contorller...</h3>
	    <p>Information gathered from the controller: ${randomString}</p>
	    
	    <h3>Here is some information sent in the URL and handled by a controller (get variables):</h3>
	    <table class="sample_table">
	        <thead>
	            <tr>
	                <th>ID</th>
	                <th>Name</th>
	                <th>Age</th>
	            </tr>
	        </thead>
	        <tbody>
		        <tr>
		            <td>${id}</td>
		            <td>${name}</td>
		            <td>${age}</td>
		        </tr>
		        <tr>
		        	<td colspan="3" class="small_text">styled with css...</td>
		        </tr>
	        </tbody>
	    </table> 
	    
%{--	For some reason checkboxes cause major error with pdf renderer. uncomment this to see    
        <input type="checkbox" />--}%
	    
	    <h3>Here is some information gathered from a form and handled by a controller (post variables):</h3>
	    <p>(if anyone can figure this out let me know...)</p>
	    <p>Favorite food: ${food}</p>
	    <p>Hometown: ${hometown}</p> 
    </body>
</html>
