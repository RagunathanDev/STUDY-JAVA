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
<button id="download-button" onclick="downloadFile()">Download</button>
<a href="/download">download</a>
</form>
<!-- Ajax JavaScript File Upload to Spring Boot Logic -->
<script>
 function downloadFile() {

document.file.action="/download";
document.file.submit();
	  
}
async function uploadFile() {
  let formData = new FormData(); 
  //console.log(fileupload.files);
  
$.each($("input[type='file']")[0].files, function(i, file) {
	formData.append('file', file);
});
  
  //formData.append("file", fileupload.files[0]);
 // console.log(formData["file"]);
  let response = await fetch('/upload', {
    method: "POST", 
    body: formData
  }); 

  if (response.status == 200) {
    alert("File successfully uploaded.");
  }
}
</script>
</body>

</html>