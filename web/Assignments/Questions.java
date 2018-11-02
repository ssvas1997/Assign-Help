import java.sql.*;

class Questions {
	public static void main(String args[])
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","root");
            Statement st=con.createStatement();
            
            st.execute("truncate table quiz;");
            
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('How many primitive data types are there in Java?','6','7','8','9','c');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('In Java byte, short, int and long all of these are','signed','unsigned','Both of the above','None of these','a');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('Which of the following options is the best for generating random integer 0 or 1?','(int)Math.random()','(int)Math.random() + 1','(int)(Math.random() + 0.5)','(int)(Math.random() + 0.2)','c');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('In which area of memory, the system stores parameters and local variables whenever a method is invoked?','Heap','Storage Area','Stack','Array','c');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('Which of the modifier can not be used for constructors?','public','static','private','protected','b');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('The implicit return type of a constructor is','void','A class object in which it is defined.','There is no return type.','None of the above','b');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('The main method should be static for the reason','It can be accessed easily by the class loader.','It can be accessed by every method or variable without any hindrance.','It can be executed without creating any instance of the class.','None of the above','c');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('Select from among the following character escape code which is not available in Java.','&#92;t','&#92;r','&#92;','&#92;a','d');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('Which of the following declares an abstract method in an abstract Java class?','public abstract method();','public abstract void method();','public void abstract Method();','public void method() {}','b');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('Which of the following is a correct interface?','interface A { void print() { } }','abstract interface A { print(); }','abstract interface A { abstract void print(); { }}','interface A { void print(); }','d');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('____________ method cannot be overridden.','final','super','static','private','a');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('The class at the top of exception class hierarchy is .................','ArithmeticException','Throwable','Object','Exception','b');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('Which keyword is used to specify the exception thrown by method?','catch','throws','finally','throw','b');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('What happen in case of multiple catch blocks? ','Either super or subclass can be caught first.','The superclass exception must be caught first.','The superclass exception cannot caught first.','None of these','c');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('Which of the below statement is/are true about Error?<br>A. An Error is a subclass of Throwable.<br>B. An Error is a subclass of Exception.<br>C. Error indicates serious problems that a reasonable application should not try to catch.<br>D. An Error is a subclass of IOException.','A and D','A and B','B and D','B and C','b');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('Which of the following constructor of class Thread is valid one?','Thread(Runnable threadOb, String threadName)','Thread(Runnable threadOb, int priority)','Thread(int priority)','Thread(String threadName, int priority)','a');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('Which of the following are methods of the Thread class?<br>1) yield()<br>2) sleep(long msec)<br>3) go()<br>4) stop()','1 , 2 and 4','1 and 3','3 only','None of the above','a');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('When comparing java.io.BufferedWriter and java.io.FileWriter, which capability exist as a method in only one of two ?','closing the stream','flushing the stream','writting to the stream','writting a line separator to the stream','d');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('In java, ............ can only test for equality, where as .......... can evaluate any type of the Boolean expression.','switch, if','if, switch','if, break','continue, if','a');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('Which of the following for loops will be an infinite loop?','for(i=0 ; i<1; i--)','for(; ;)','for(i=0; ; i++)','All of the above','d');");
            
            
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('Which of the following is not used to seek a file pointer?','ios::cur','ios::set','ios::end','ios::beg','b');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('During dynamic memory allocation in CPP, new operator returns _________ value if memory allocation is unsuccessful.','False','NULL','Zero','None of these','b');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('Which of the followings is/are pointer-to-member declarator?','->*','.*','::*','both a and b','c');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('Default value of static variable is_____ .','0','1','Garbage value','Compiler dependent','a');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values(' ________ are used to format the data display in CPP.','Iterators','Punctuators','Manipulators','Allocators','c');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('Reusability of the code can be achieved in CPP through ______ .','Polymorphism','Encapsulation ','Inheritance','Both a and c','c');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('By default, members of the class are ____________ in nature.','protected','private','public','static','b');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('Which of the following is CPP style type-casting?','per = total/(float)m','per = total/float(m)','per = (float)total/m','None of these','b');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('If a program uses Inline Function, then the function is expanded inline at ___________.','Compile time','Run time','Both a and b','None of these','b');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('Which of the following is/are valid ways to allocate memory for an integer by dynamic memory allocation in CPP?','int *p = new int(100);','int *p; p=new int; *p = 100;','int *p = NULL; p = new int; *p=100;','All of these','d');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('Which of the following is the perfect set of operators that can’t be overloaded in CPP ?','+=, ?, :: , >>','>>, <<, ?, *, sizeof()',':: , . , .* , ?:',':: , ->, * , new, delete','c');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('Static variable in a class is initialized when _____ .','every object of the class is created.','last object of the class is created.','first object of the class is created.','No need to initialize static variable.','c');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('To perform File I/O operations, we must use _____________ header file.','&lt;ifstream&gt;','&lt;ofstream&gt;','&lt;fstream&gt;','Any of these','c');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values(' An exception is thrown using _____________ keyword in CPP.','throws','throw','threw','Thrown','b');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('Which of the followings is/are not a manipulator/s ?<br>1. flush<br>2. base<br>3. ends<br>4. oct<br>5. bin<br>6. skipws','Only 1, 6 ','Only 1,4,6','Only 1,3,6','Only 2,5','d');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('If default constructor is not defined, then how the objects of the class will be created?','The compiler will generate error','Error will occur at run-time.','Compiler provides its default constructor to build the object.','None of these','c');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('C structure differs from CPP class in regards that by default all the members of the structure are __________ in nature.','private','protected','public','None of these','c');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('Which of the followings are true about constructors?<br>1. A class can have more than one constructor.<br>2. They can be inherited.<br>3. Their address can be referred.<br>4. Constructors cannot be declared in protected section of the class.<br>5. Constructors cannot return values.','Only 1,2,4','1,2,4,5','1,3,5','1,4,5','d');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('Which of the following best defines the syntax for template function ?','Template','Template return_type Function_Name(Parameters)','Both a and b','None of these','c');");
            st.executeUpdate("insert into quiz(que,a,b,c,d,ans) values('Generic pointers can be declared with__________ .','auto','void','asm','None of these','b');");
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}
}