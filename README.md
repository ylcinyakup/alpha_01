# alpha_01
Spring Mvc deneme


Uygulamayı öğrenme sürecimdeyken yazdığım için eksikler ve bug lar bulunmakta daha sonradan dönüp bakma fırsatım olmadı sürekli ilerlemeye devam ettiğim için  



çalıştırabilmek için aşağıdaki talimatları uygulayın.

öncelikle db.sql i mysql workbench de çalıştırın ve database şemasını oluşturun.

db.sql i çalıştırdıysanız default olarak 

	username : asdqwe
	password : asdqwe

App ın db ile bağlantısını jndi lookup ile yaptığımdan dolayı aşağıdaki talimatları uygulayıp bağlantıyı sizinde sağlamanız gerekmektedir.

	<Resource name="jdbc/spring" auth="Container" type="javax.sql.DataSource"
		maxTotal="100" maxIdle="30" maxWaitMillis="10000" username="root"
		password="root" driverClassName="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/testspringdb" />
    
 bu satırları Tomcat serverin içerisindeki context.xml ye girmeniz gerekmektedir ayrıyetten username password kısmını düzenlemeniz gerekmektedir.
 ( bakınız https://tomcat.apache.org/tomcat-8.0-doc/jndi-datasource-examples-howto.html )
 

