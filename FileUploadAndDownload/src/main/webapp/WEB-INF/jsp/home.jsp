<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<!-- HTML5 Input Form Elements -->
<form name="file" >
<input id="fileupload" type="file" name="fileupload" multiple="multiple" /> 
<button id="upload-button" onclick="uploadFile()"> Upload </button>
<button id="download-button" onclick="downlod()">Download</button>
<a href="/download">download</a>
<select name="forma" onchange="location = /download;">
 <option value="download">Home</option>
 <option value="download">Contact</option>
 <option value="download">Sitemap</option>
</select>
</form>
<!-- Ajax JavaScript File Upload to Spring Boot Logic -->
<script>

function downlod(){
	const xhr = new XMLHttpRequest();
	xhr.open('POST', '/download');
	xhr.send(null);
	// Set the response type of the server
	xhr.responseType = "blob";
	// Listen for Downloads
	xhr.addEventListener('progress', event => {
		// Calculate the percentage
		const percent  = ((event.loaded / event.total) * 100).toFixed(2);
		console.log(`Download progress: ${percent}`);
	}, false);
	
	xhr.onreadystatechange = event => {
		if(xhr.readyState == 4){
			if (xhr.status == 200){
				
				/* // Get ContentType
				const contentType = xhr.getResponseHeader('Content-Type');
				
				// File name
				var fileName = xhr.getResponseHeader('Content-Disposition').split(';')[1].split('=')[1];
				fileName.replace("_","");
				console.log(fileName);
				// Create an a tag for downloading
				const donwLoadLink = document.createElement('a');
				donwLoadLink.download = fileName;
				donwLoadLink.href = URL.createObjectURL(xhr.response);
				
				// Trigger download event, IO to disk
				donwLoadLink.click();
				
				// Freeing resources in memory
				URL.revokeObjectURL(donwLoadLink.href); */
				
				const contentType = xhr.getResponseHeader('Content-Type');
				
				const fileName = xhr.getResponseHeader("Content-Disposition").split(";")[1].split("=")[1];
				
				const down = document.createElement('a');
				down.download=fileName;
				down.href=URL.createObjectURL(xhr.response);
				
				down.click();
				
				URL.revokeObjectURl(down.href);
				
				
				
				// Turn off load animation
				layer.close(index);
			} else if (response.status == 404){
				alert(`Document: ${file} non-existent`);
			} else if (response.status == 500){
				alert('System abnormality');
			}
		}
	}
}


	function downloadFile() {
		/* document.file.method = "GET";
		document.file.action = "/download";
		document.file.submit();  */
		let response = await
		fetch('/download', {
			method : "GET",
	
		});
	
	}
	async function uploadFile() {
		let formData = new FormData();
		//console.log(fileupload.files);

		$.each($("input[type='file']")[0].files, function(i, file) {
			formData.append('file', file);
		});

		//formData.append("file", fileupload.files[0]);
		// console.log(formData["file"]);
		let response = await
		fetch('/upload', {
			method : "POST",
			body : formData
		});

		if (response.status == 200) {
			alert("File successfully uploaded.");
		}
	}
</script>
</body>

</html>