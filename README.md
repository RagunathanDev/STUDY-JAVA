# STUDY-JAVA WITH SPRING and SPRING-BOOT \n







#*********************    application.properties    *************************\n

# Entry options \n

#Added View Page Path and extention \n
spring.mvc.view.prefix=/pages/
spring.mvc.view.suffix=.jsp

#Added for to connect H2 database
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:test
spring.sql.init.platform=h2

#Added For while start the application execute the data.sql inside querys
spring.jpa.defer-datasource-initialization=true 
