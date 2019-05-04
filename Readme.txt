Project Discretion :-
----------------------
1- This dir will contain all projects and files related to Voice Note Service ( Careen Interview )
2- Those services will simulate unidirectional voice note service btw car captain and riders so captain can send a note or check note status and rider can join trip , listen to note and captain should be notified when this rider listen to this note 

Architecture entities :-
---------------------------
DTOs :-
	Java class which represent DB tables and annotated with JPA annotations 
DAO  :-
	Java class which used to persist , merge and execute named queries on DB
Business ( Facade ) :- 
	Java class ( can be annotated with EJBs annotations and used to create business logic 
End points ( RESTful web service ) :-
	Java class annotated with restful annotations and used as end points 

Development Environment and Technologies used :-
----------------------
Environment & Technologies:
	1- MySQL DB
		1.1- to create DB just follow this path (voice_note_service\service-documents\DB\DB_schema.sql)
		1.2- after creating DB run insert testing data to make service run and u can show results
	2- Java 
		2.1- Java version is JAVAEE 8
		2.2- Technologies used 
			2.2.1- JPA ( Hibernate )
			2.2.2- RESTFul web-services 
		Hint for simplicity in environment set-up i replace EJBs with ordinary entities  
	3- Maven
	4- IDE
		4.1- eclipse photon
	5- Server 
		5.1- Tomcat 
		
To import Maven Project in eclipse :-
-----------------------
1- file > import > select maven project > navigate to project path > ok
2- window > prefrences > java > installed jar > replace it with jdk
	2.1- if u don't have jdk plz install and setup before start 

To run maven project :-
-----------------------
use this command :
	mvn clean install -DskipTests