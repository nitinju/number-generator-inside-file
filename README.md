# number-generator-inside-file

1- Change path inside application.yml to your preference.
		path: "D:\\temp\\" 
 
2- Files will be generator inside temp folder.

3- Swagger has been integrated, can be used.
	http://localhost:8080/swagger-ui.html#/


 #numberGenerator/api/generate To generate taskid
 response will be 
	 {
	  "task": "8f023f2a-8897-4470-9076-c4dccc65f8ad"
	}
 #/numberGenerator/api/tasks/{id}/status can be used to fetch status
	/numberGenerator/api/tasks/8f023f2a-8897-4470-9076-c4dccc65f8ad/status
 
 #/numberGenerator/api/tasks/{id} can be used to fetch data inside that uuid
	/numberGenerator/api/tasks/8f023f2a-8897-4470-9076-c4dccc65f8ad?action=get_numlist
	
5- Handled scenario 
	- file not available
	- writting is in progress
	- some default scenario too.
	
	
	
Application will be hosted on
   http://localhost:8080/swagger-ui.html#/