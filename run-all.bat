echo "About to launch all services ..."

SET app[0]=MyEurekaServiceRegistry\pom.xml
SET app[1]=ProductServiceApp\pom.xml
SET app[2]=InvoiceServiceApp\pom.xml
SET app[3]=OrderProcessingServiceApp\pom.xml
SET app[4]=cloudApiGateway\pom.xml

SET runcmd=start cmd /C mvn spring-boot:run -f 

%runcmd% %app[0]%
%runcmd% %app[1]%
%runcmd% %app[2]%
%runcmd% %app[3]%
%runcmd% %app[4]%
