# Innovacer-summergeeks-Intern-Assignment
Innovacer-summergeeks-Assignment

## Software Used
1- Eclipse  of version - 2019-03(4.11.0)  - For IDE
2- Apache -tomcat- 8.5.49 - For server
3- Mysql -8.0.13 - For Database
## Jar Files Required
1- activation-1.1.jar
2- commons-codec-1.9.jar
3- commons-logging-1.2.jar
4- mail-1.4.5.jar
5- smtp-1.4.4.jar
6- mysql-connector-java-5.1.48.jar
7- guava-18.0.jar
8 - httpclient-4.5.2.jar
9- httpcore-4.4.4.jar
10- jackson-annotation-2.8.7.jar
11- jackson-core-2.8.7.jar
12- jackson-databind-2.8.7.jar
13- jaxb-api-2.2.jar
14- jjwt-0.4.jar
15- joda-time-2.5.jar
16- slf4j-api-1.7.6.jar
17- stax-api-1.0-2.jar
18- twilio-7.17.0.jar 
## API used
1- JavaMail.api - For sending mail
2- JDBC - For connecting Database
3- Twilio API - For sending SMS

## Framework Used
**JSP -  used to create dynamically generated web pages.**

# Database Schemas
In a database section, we are using 3 tables namely Visitor, Host and Visit.

1- Visitor Table will consists of Name of the visitor, mobile number of the visitor, and email address of the visitor. Here, the mobile number is taken as a primary key.

2- Now, Host table will consist of name of the host, mobile number of host, and email address of the host. Here, in this table mobile number of the host is taken as a primary key.

3- Visit Table will consist of Phone number of the visitor, Phone number of the host, In-time  and Out- time of that visitor. Here, primary key is a tuple of (Visitor's Mob. No, Host's Mob. No, In-time). Here, in this table, Visitor's Mob No is taken as a foreign key which is referencing Visitor Table and Host's Mob No is also a foreign key which is referencing Host table.

# Function Documentation
**In this section , some details  related to parameters passed to the functions  are given.**
1- func1(visitor's name, visitor's phone no, visitor's email, host's name, host's phone no, host's email).

2- sendemail1( host's email, visitor's email, visitor's name, visitor's phone no). -> used to send mail to the host.

3- updatedb1(visitor's name, visitor's phone no, visitor's email, host's name, host's phone no, host's email). 

4- sendsms( visitor's email, visitor's name, visitor's phone no, host's phone no). -> used to send sms to the host.

5-  func2( visitor's phone no)

6-  updatedb2 (visitor's phone no)

# Actual Working of the Application
1- We have a html file ( detail.html) in which all the work related to front end is done.
detail.html file will consists of two forms. First form is used to enter the information when the visitor will check in. This form is connected with the jsp file (result1.jsp) so that all the information enterd by visitor can be used in result1.jsp file.

2- Now, inside the result1.jsp file , function namely func1 is called which is present in Driver.java file in which (visitor's name , visitor's phone no, visitor's email ,host's name, host's phone no, host's email) is passed as a parameter.

3- So, inside the function func1 , sendemail1 function is called which is present inside the file sendmail.java . In the function sendmail1, (host's email, visitor's email, visitor's name and visitor's phone no) is passed as a parameter. Actually, this function sendemail1 is used to send email to the host about the information of the visitor. Email is sent using SMTP server on port 465.

4- Now, after sending email to the host, next function updatedb1 is called which is present in the  file Updatedb.java . Now in the function updatedb1, (visitor's name, visitor's phone number, visitor's email, host's name, host's phone no, host's email) is passed as a parameter. Now, inside the function updatedb1 , JDBC is used to establish connection with the database. 

5- Now for the visitor table, visitor's phone is used as a primary key. If there is already a record having the same phone no as the current visitor's phone no, then there is no need to enter visitor's information again, otherwise we will update our visitor's table with visitor's name, visitor's phone no and visitor's email. The same goes for the Host table in which host's phone number is taken as a primary key. If there is a record in host table that matches with the host's phone no then no need to update host table, otherwise we will update our host's table with host's name , host's phone no, and host's email.  After that, Visit table is updated with Visitor's Phone no, Host's phone no, in-time and out- time. In this Visit table, in-time is the current time stamp and out-time is set as NULL .

6- Now after the updatedb1 function is completely executed, sendsms function is called which is present in the file Sendsms.java . In the function sendsms (visitor's email, visitor's name , visitor's phone no, host's phone no) is passed as a parameter. This function sendsms is used to send sms to the host about the information of the visitor. 
In this function , Twilio API is used to send message to the host.

7-  Till here, we have handled the entry of the visitor.  Now, in  detail.html file, second form is used for the check out of the visitor. Now, this form is connected with the jsp file (result2.jsp)  so that phone no enterd by visitor can be used in result2.jsp file. 

8- Now, from the result2.jsp file function named func2 is called which is present in the file Driver.java .  In this function func2 ,phone No of the visiter is passed as a parameter.

9- Now in the file Driver.java  , inside the function func2 , updatedb2 function is called which is present in the file Updatedb.java . In the function updatedb2, phone No of the visitor is passed as a parameter. Now inside the function updatedb2 , JDBC is used to establish connection with the database. Now, in the Visit table, records are taken corresponding to the visitor's phone number and after that,  we will search for the record having check out time as NULL and corresponding to that particular record, Host's phone no and in time of the visitor is used. So, now we have visitor's phone no, host's phone no and check in time of the visitor. Using these information, a particular record is selected that match with the given information and corresponding to that record, check out time is updated.  Now, from the Visitor Table, visitor's name and visitor's email is retrieved and similarly from Host table, host's name and host email is retrieved. 

10- After that, function sendemail2 is called which is present in the file Sendmail.java .
In this funtion sendemail2 , (visitor's email, visitor's name, visitor's phone no, visitor's check in time, visitor's check out time , host's name) is sent as a parameter. 
This function sendemail2 is used to send email to the visitor about the given details after he checked out. Email is again sent using SMTP server on port 465.


# Demonstration of the use of the Application 



1 - Initially to run  the given application, our html file (detail.html) is run on server.
![enter image description here](https://lh3.googleusercontent.com/sHKN4bpOWtZksei0CAL6RCHpWfBQiqthCWkaEaIcjjcXoteqW9qS44vgBuCCkiIom3Rg-8wfJkfu)


2- Now select the tomcat v8.5 server, and click on finish.
![enter image description here](https://lh3.googleusercontent.com/S1dXwt8S8wxkAd-BSm6gPXUPW21jGw653R7h1XioU-4XlH-9t-780GQ_nkikJkBA5JwGHXF4cK8l)


3- Here we are at the front end page of the application.

![enter image description here](https://lh3.googleusercontent.com/wZ5XWpNG8J5trre5-27uCHkcAtBSP4zenm10ifrvLI6xazbGJ1VaLKuennrge_y_L7M1VbHPaZhq)

4- First entering the visitor's name , visitor's mobile no and visitor's email.
![enter image description here](https://lh3.googleusercontent.com/hg301ZNDTm4kSVNcFYhcPPOlqc2P6Tq4i27uE31_PkLxPcND1XsV9LNxpqLiQjFjYc_FaqE-F0Gx)

5- Now entering host's name, host's mobile no and host's email
![enter image description here](https://lh3.googleusercontent.com/awdpvq0J4cPb7un1We-PdUanXDEaY44iKi_yGWw29SYUmj7_2_IZLN0wy1-sY97ecXtZR29DQZF8)

6- After filing details at the time of check in, click on submit.

7- Now the host will recieve an email as shown here.
![enter image description here](https://lh3.googleusercontent.com/M8Q9P3IdUmUTrQSKnJ2UFyPybKREYhgbB294ISzcLr9-gYetvRiVU6k1ZbOQg9qpIwn97aSDE24c)

8- Also the sms will be sent to the host's mobile no giving the details of the visitor

![enter image description here](https://lh3.googleusercontent.com/xZArqc5o0gu4LRPL-u0OrJbw9uuhuMoxGsgBwnDU2LEWHXs_wluJkzsmX4IUnL7cF2xa1-ugD6va)

Now the job of the Check in section is done.

9 -  Now during the time of checkout, Visitor's phone no is entered.![enter image description here](https://lh3.googleusercontent.com/6OTYkcOjLJgCUX7xaaFw5S3HyiPhv93gtyR0LaZ9ZTXvpG2ov-bfg1cp8e4ayEI6X7TTp7xkBdjP)

10- And now finally, the visitor will recieve an email as shown.
![enter image description here](https://lh3.googleusercontent.com/aenfDExLH0iyf47DH8bstf3yHx9eALsAaS06FsfMCEX4CM0US4W14iMkJ04VnVhkiHotAK3qh5Cn)





