# Below steps Works :
1.If i run **mvn clean install -DskipTests=true** it works without tests and creates the FileUploadIssue.war file

2.Manually deploying in JBoss EAP 6.4 works !

3.Acessing http://localhost:8080/FileUploadIssue/upload/sayhello using browser or Postman and it works.

# Facing issues in below steps :

1. But i want **mvn clean install** to get passed without skipping the tests.

2. Once its done, i want to run mvn clean package -Parquillian-jbossas-remote-7 to test arquillian tests without deploying manually.
