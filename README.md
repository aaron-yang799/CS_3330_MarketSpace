# Tiger-Trades
Tiger-Trades is a online auctioning website designed for Mizzou students. Users can create Listings with a set minimum bid, and a buyout price for users that want to buy the Listing immediately. Each user has a personal wallet of 'TigerTokens', these tokens have a one to one exchange rate with USD. Users can also view their current active listings. Each listing has a time limit users set upon creation, when that date is reached the listing is sold to teh user with the highest bid.

This project utilizes a RDMS hosted on Amazon Web Services (AWS) written in MySQL to store user data. JavaServer Tag Library (JSTL) is also used in conjunction with Bootstrap 5 to create a sleek and pleasing user exprience when viewing the webpage. MySQL Connecter Java is used to make queries to the database. Jbcrypt is used to create a secure user exprience by converting user passwords into a hash, so actual passwords are not stored in the database. jakarta.servlet.jsp.jstl-3.0.1 and jakarta.servlet.jsp.jstl-api-3.0.0 are used in order to allow JSTL 1.2 to be used in conjunction with Apache Tomcat 10.1.

### Group Members
- Aaron Yang
- Chetan Vanteddu
- Viet Nguyen
- Zach Snyder

### Usage

This project was developed using Java Dev Kit version 21. In order to run this code you will need to have JDK 21 selected as you Java Runtime Environment within your IDE. In addition, this project was tested with Apache Tomcat version 10.1 as the local hosting enviroment, you will need this to run the project.

To run, right click on the project file and click run on server, then select the correct Apache Tomcat version.

## Dependancies

[Apache Tomcat 10.1](https://tomcat.apache.org/download-10.cgi)

[MySQL Connector Java 8.4](https://mvnrepository.com/artifact/com.mysql/mysql-connector-j/8.4.0)

[Jbcrypt 0.4](https://mvnrepository.com/artifact/org.mindrot/jbcrypt/0.4)

[jstl 1.2](https://mvnrepository.com/artifact/javax.servlet/jstl/1.2)

[jakarta.servlet.jsp.jstl-3.0.1](https://mvnrepository.com/artifact/org.glassfish.web/jakarta.servlet.jsp.jstl/3.0.1)

[jakarta.servlet.jsp.jstl-api-3.0.0](https://mvnrepository.com/artifact/jakarta.servlet.jsp.jstl/jakarta.servlet.jsp.jstl-api/3.0.0)

