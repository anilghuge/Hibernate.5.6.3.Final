* If the XML document/file is satisfying only synatx rules.. then it is called well-formed XML document

**XML Synatx rules**
1. Every open tag should have closing tag
2. The tags must be nested property
3. The tag, attribute names are case-sensitive
4. first tag of xml file/doc is called root tag/element.. once the root     tag closed.. no other content should placed and etc..

* If the XML document is satisying the imported DTD/XSD then it is called Valid XML document
    1. DTD :: Document Type Definitation
    2. XSD :: XML Schedma Definitation
    

* XML parser is a software comp/App performing the following operations on given XML document/file  
    1. Loads the given xml file/doc from HDD   
    2. Checks wellformed doc or not(if not throws exception)  
    3. Checks valid doc or not(if not throws exception)  
    4. Reads xml doc content and prepare Inmemory MetaData having xml        file content in the JVM Memory of RAM where current App is Running      for the faster reutilization pf the content for multiple times

**See Application Flow Image :**
[Application Flow]()  Figure Number 01

* Example of XML parser in java
    1. SAX parser(Simple API for XML processing)
    2. DOM parser (Docuemnt Object Model)
    3. JDOM parser (Java Document Object Model)
    4. DOM4J (DOM for Java)
    and etc

---------------------------------------------------------

* If Hibernate persitence logic is placed in the main(-) of standalone Application then the flow begins with main(-) and ends main(-) method.

 **1. Bootstrap or Activate the hibernate**  
###  Configuration cfg=new Configuration();
 
 - Activates/Bootstrap the hibernate framework(software)based on the Hibernate files/libaries that are added to CLASSPATH/Build Path
 
###  cfg.configure("com/hb/config/hibernate.cfg.xml");

 - Load given hiberate cfg file from the specified location of the HDD
 - Checks wheather hibernate cfg file is well-forrmed or not and valid or not(if not exception will be thrown)
 - Reads hiberate file content and prepare InMemory Metadata in the JVM memory of RAM belonging to current Application  
 - stores hibernate cfg file info and additional info(Metadata) in the Configuration object
 
[Application Flow]()  Figure Number 02

```
cfg.configure("com/hb/config/hibernate.cfg.xml");
System.out.println(cfg.getProperties());
```
----------------------------------------
### cfg.configure();
- This method takes hiberate.cfg.xml file from the classpath folder(In maven project in src/main/java folder) and makes it as the hiberante cfg file.

- Note : if u do not specify name and location of hibernate cfg file in the configure(-) method then it takes hiberante.cfg.xml file of classpath folder(src/main/java folder) as the default hibernate cfg file. if the name or location of the hibernate cfg file is changed we must specify it explicity.in the cfg.configure(-) method

- cfg.configure("com/hb/config/hibernate.cfg.xml");

- Note : cfg.configure(-) does not attempt to load and read the content of hibernate mapping files though their name is specified in hibernate configuation file
--------------------------------------

### SessionFactory sessionFactory=cfg.buildSessionFactory();
- The cfg.buildSessionFactory() method perform following operations
    1. gets the names and location of hibernate mapping file(s) from the configuration object(Indirectly from hibernate cfg file),loads the maaping file(s),checks mapping file(s) are well-formed or not, valid or not?) if not valid or if not well-formed they throws exception)->
    2. create inMemory Meta data for mapping files
    3. Based on info placed in Hibernate Mapping files Metadata it will create following services like dialect,datasource object with jdbc connection pool(Connection Provider),Generator services,Cache service,pre-generated SQL quries and etc.. -> having all these services one heavy weight bigger object will be created that is SessionFactory Object
    
[Application Flow]()  Figure Number 03

--------------------------------------
### Session session = sessionFactory.openSession();

- 1. get one jdbc con object from con pool,collects InMemory meta data of mapping files and creates Hibernate Session having them,so we can Hibernate session object as con++

**Hibernate Session Object=jdbc connection object++**
1. SessionFactory Object is the object of java class that implements SessionFactory(I) and that class will be given Hibernate Framwork software(In the jar files Hibernate Framework)

```
System.out.println("session factory obj class name :"+fact.getClass());
```