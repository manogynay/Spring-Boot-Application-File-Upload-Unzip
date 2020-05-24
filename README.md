# Spring-Boot-Application-File-Upload-Unzip

This application contains Restful API which does below functionality
Takes a zip file as input
Stores in local directory
Extracts the zip and stores in specified directory

Note: This application unzips only .zip files.It throws exception for tar files

# Softwares needed
Java - jdk 1.8 or more
Maven - 3.3.3 or more

# How to run?
Download the project and unzip it to some folder
Open project root folder which contains pom.xml using command prompt
Run the command : mvn clean install
Once the build is successful, run below command
java -jar target\File_Upload_Unzip-0.0.1-SNAPSHOT.jar
Spring boot application starts successfully.

# How to test?

Using postman:
Download postman and open it
Create new request with below details:
Method type: Post
URL : http://localhost:8090/uploadFile
Request body : form-data
Request param : 
key : file 
Value : select file from your local (there exists a dropdown in the key attribute field to select text/file, select file in the drop down)
Post the request to view response.

# Where to find the uploaded files

Uploaded and unziped files would be present in /users/manogyna folder with in same project directory
