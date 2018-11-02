CREATE DATABASE  IF NOT EXISTS `assignment` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `assignment`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: assignment
-- ------------------------------------------------------
-- Server version	5.6.22-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `assign`
--

DROP TABLE IF EXISTS `assign`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assign` (
  `assign_id` int(11) NOT NULL AUTO_INCREMENT,
  `stud_id` int(11) NOT NULL,
  `assign_file_path` varchar(245) DEFAULT NULL,
  `is_over` varchar(5) DEFAULT NULL,
  `teach_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`assign_id`),
  KEY `stud_id_idx` (`stud_id`),
  KEY `teach_id_idx` (`teach_id`),
  CONSTRAINT `fk_teachid` FOREIGN KEY (`teach_id`) REFERENCES `teacher` (`teach_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `stud_id` FOREIGN KEY (`stud_id`) REFERENCES `student` (`stud_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assign`
--

LOCK TABLES `assign` WRITE;
/*!40000 ALTER TABLE `assign` DISABLE KEYS */;
/*!40000 ALTER TABLE `assign` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quiz`
--

DROP TABLE IF EXISTS `quiz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quiz` (
  `quiz_id` int(11) NOT NULL AUTO_INCREMENT,
  `que` varchar(300) NOT NULL,
  `a` varchar(100) NOT NULL,
  `b` varchar(100) NOT NULL,
  `c` varchar(100) NOT NULL,
  `d` varchar(100) NOT NULL,
  `ans` char(1) NOT NULL,
  PRIMARY KEY (`quiz_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quiz`
--

LOCK TABLES `quiz` WRITE;
/*!40000 ALTER TABLE `quiz` DISABLE KEYS */;
INSERT INTO `quiz` VALUES (1,'How many primitive data types are there in Java?','6','7','8','9','c'),(2,'In Java byte, short, int and long all of these are','signed','unsigned','Both of the above','None of these','a'),(3,'Which of the following options is the best for generating random integer 0 or 1?','(int)Math.random()','(int)Math.random() + 1','(int)(Math.random() + 0.5)','(int)(Math.random() + 0.2)','c'),(4,'In which area of memory, the system stores parameters and local variables whenever a method is invoked?','Heap','Storage Area','Stack','Array','c'),(5,'Which of the modifier can not be used for constructors?','public','static','private','protected','b'),(6,'The implicit return type of a constructor is','void','A class object in which it is defined.','There is no return type.','None of the above','b'),(7,'The main method should be static for the reason','It can be accessed easily by the class loader.','It can be accessed by every method or variable without any hindrance.','It can be executed without creating any instance of the class.','None of the above','c'),(8,'Select from among the following character escape code which is not available in Java.','&#92;t','&#92;r','&#92;','&#92;a','d'),(9,'Which of the following declares an abstract method in an abstract Java class?','public abstract method();','public abstract void method();','public void abstract Method();','public void method() {}','b'),(10,'Which of the following is a correct interface?','interface A { void print() { } }','abstract interface A { print(); }','abstract interface A { abstract void print(); { }}','interface A { void print(); }','d'),(11,'____________ method cannot be overridden.','final','super','static','private','a'),(12,'The class at the top of exception class hierarchy is .................','ArithmeticException','Throwable','Object','Exception','b'),(13,'Which keyword is used to specify the exception thrown by method?','catch','throws','finally','throw','b'),(14,'What happen in case of multiple catch blocks? ','Either super or subclass can be caught first.','The superclass exception must be caught first.','The superclass exception cannot caught first.','None of these','c'),(15,'Which of the below statement is/are true about Error?<br>A. An Error is a subclass of Throwable.<br>B. An Error is a subclass of Exception.<br>C. Error indicates serious problems that a reasonable application should not try to catch.<br>D. An Error is a subclass of IOException.','A and D','A and B','B and D','B and C','b'),(16,'Which of the following constructor of class Thread is valid one?','Thread(Runnable threadOb, String threadName)','Thread(Runnable threadOb, int priority)','Thread(int priority)','Thread(String threadName, int priority)','a'),(17,'Which of the following are methods of the Thread class?<br>1) yield()<br>2) sleep(long msec)<br>3) go()<br>4) stop()','1 , 2 and 4','1 and 3','3 only','None of the above','a'),(18,'When comparing java.io.BufferedWriter and java.io.FileWriter, which capability exist as a method in only one of two ?','closing the stream','flushing the stream','writting to the stream','writting a line separator to the stream','d'),(19,'In java, ............ can only test for equality, where as .......... can evaluate any type of the Boolean expression.','switch, if','if, switch','if, break','continue, if','a'),(20,'Which of the following for loops will be an infinite loop?','for(i=0 ; i<1; i--)','for(; ;)','for(i=0; ; i++)','All of the above','d'),(21,'Which of the following is not used to seek a file pointer?','ios::cur','ios::set','ios::end','ios::beg','b'),(22,'During dynamic memory allocation in CPP, new operator returns _________ value if memory allocation is unsuccessful.','False','NULL','Zero','None of these','b'),(23,'Which of the followings is/are pointer-to-member declarator?','->*','.*','::*','both a and b','c'),(24,'Default value of static variable is_____ .','0','1','Garbage value','Compiler dependent','a'),(25,' ________ are used to format the data display in CPP.','Iterators','Punctuators','Manipulators','Allocators','c'),(26,'Reusability of the code can be achieved in CPP through ______ .','Polymorphism','Encapsulation ','Inheritance','Both a and c','c'),(27,'By default, members of the class are ____________ in nature.','protected','private','public','static','b'),(28,'Which of the following is CPP style type-casting?','per = total/(float)m','per = total/float(m)','per = (float)total/m','None of these','b'),(29,'If a program uses Inline Function, then the function is expanded inline at ___________.','Compile time','Run time','Both a and b','None of these','b'),(30,'Which of the following is/are valid ways to allocate memory for an integer by dynamic memory allocation in CPP?','int *p = new int(100);','int *p; p=new int; *p = 100;','int *p = NULL; p = new int; *p=100;','All of these','d'),(31,'Which of the following is the perfect set of operators that can’t be overloaded in CPP ?','+=, ?, :: , >>','>>, <<, ?, *, sizeof()',':: , . , .* , ?:',':: , ->, * , new, delete','c'),(32,'Static variable in a class is initialized when _____ .','every object of the class is created.','last object of the class is created.','first object of the class is created.','No need to initialize static variable.','c'),(33,'To perform File I/O operations, we must use _____________ header file.','&lt;ifstream&gt;','&lt;ofstream&gt;','&lt;fstream&gt;','Any of these','c'),(34,' An exception is thrown using _____________ keyword in CPP.','throws','throw','threw','Thrown','b'),(35,'Which of the followings is/are not a manipulator/s ?<br>1. flush<br>2. base<br>3. ends<br>4. oct<br>5. bin<br>6. skipws','Only 1, 6 ','Only 1,4,6','Only 1,3,6','Only 2,5','d'),(36,'If default constructor is not defined, then how the objects of the class will be created?','The compiler will generate error','Error will occur at run-time.','Compiler provides its default constructor to build the object.','None of these','c'),(37,'C structure differs from CPP class in regards that by default all the members of the structure are __________ in nature.','private','protected','public','None of these','c'),(38,'Which of the followings are true about constructors?<br>1. A class can have more than one constructor.<br>2. They can be inherited.<br>3. Their address can be referred.<br>4. Constructors cannot be declared in protected section of the class.<br>5. Constructors cannot return values.','Only 1,2,4','1,2,4,5','1,3,5','1,4,5','d'),(39,'Which of the following best defines the syntax for template function ?','Template','Template return_type Function_Name(Parameters)','Both a and b','None of these','c'),(40,'Generic pointers can be declared with__________ .','auto','void','asm','None of these','b');
/*!40000 ALTER TABLE `quiz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solution`
--

DROP TABLE IF EXISTS `solution`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solution` (
  `sol_id` int(11) NOT NULL AUTO_INCREMENT,
  `assign_id` int(11) NOT NULL,
  `teach_id` int(11) NOT NULL,
  `sol_filepath` varchar(245) DEFAULT NULL,
  PRIMARY KEY (`sol_id`),
  KEY `assign_id_idx` (`assign_id`),
  KEY `teach_id_idx` (`teach_id`),
  CONSTRAINT `assign_id` FOREIGN KEY (`assign_id`) REFERENCES `assign` (`assign_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `teach_id` FOREIGN KEY (`teach_id`) REFERENCES `teacher` (`teach_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solution`
--

LOCK TABLES `solution` WRITE;
/*!40000 ALTER TABLE `solution` DISABLE KEYS */;
/*!40000 ALTER TABLE `solution` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `stud_id` int(11) NOT NULL AUTO_INCREMENT,
  `stud_name` varchar(45) NOT NULL,
  `stud_contact` varchar(10) NOT NULL,
  `stud_email` varchar(45) NOT NULL,
  `stud_password` varchar(45) NOT NULL,
  PRIMARY KEY (`stud_id`),
  UNIQUE KEY `stud_email_UNIQUE` (`stud_email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'Ranjith','8082125030','krishnanranjith@ymail.com','abcd1234'),(2,'Advait','9876543210','advaitjoshi8@gmail.com','abcd1234'),(3,'Bhavik','7021379452','bhavik@gmail.com','abcd1234');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `teach_id` int(11) NOT NULL AUTO_INCREMENT,
  `teach_name` varchar(45) NOT NULL,
  `teach_contact` varchar(45) NOT NULL,
  `teach_email` varchar(45) NOT NULL,
  `teach_password` varchar(45) NOT NULL,
  `teach_rating` int(11) DEFAULT NULL,
  PRIMARY KEY (`teach_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'Srinivas','8097481862','ssvas1997@gmail.com','abcd1234',0),(2,'Kumar','9856321452','kumar@free.com','123456',0);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'assignment'
--

--
-- Dumping routines for database 'assignment'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-30 17:41:53
