###Requirements and execution of code
<b>Install/Update Java</b>
* sudo add-apt-repository ppa:openjdk-r/ppa
* sudo apt-get update -q 
* sudo apt install -y openjdk-11-jdk 

<b>For The Main File</b>
* Clone this repo 
* install ant by running 'sudo apt-get install ant'
* then go to the folder where you have cloned this repo
* run 'ant compile'
* run 'ant jar'
* run 'java -cp build/jar/args.jar com.cleancoder.args.ArgsMain'

<b>For the tests</b>
* Run the command given below from the root folder of this repo
* 'java -cp "lib/junit-4.13.jar:lib/hamcrest-core-1.3.jar:build/jar/args.jar" ./test/com/cleancoder/args/ArgsTest.java testCreateWithNoSchemaOrArguments'

###Norms of Clean Code Implemented:
* Meaningful Naming- Methods named as verb+noun, class and data members named as noun or noun-phrase
* Followed naming Convention for class, method, data members.
* Followed proper indention of function, loops and classes.
* Each Method serves only one functionality.
* Functions are not more than 8-9 lines.
* No function has more than 3 arguments. Most of the functions have 1 or 2 arguments, used 3 arguments only when it is nesecaary
* Each function validates its arguments by calling a validation function.
* Each class uses constructors for data member initialization.
* Each class has a default constructor if parameterized exists even if it is not used.
* Vertical Alignment of function arguments.
* Readable and self explanatory code with no useless comments.
* Use of Optional class to handle null checking and handle nullpointer exception.
* No duplication of methods and data members.
* Encapsulation and abstraction feature of classes by declaring relevant private and public class members.
* Objects hide their data behind abstractions and expose functions that operate on that data. 
* Exceptional handling using Try and catch 
  * If a function has try keyword then is first keyword 
  * there is nothing after the catch blocks.
  * try and catch blocks are made one liners by using functions
* If else block are one liners mainly a function call.
* No use of  flag arguments. 
* Unit Test rules-
  - Readable.
  - Fast.
  - Independent.
  - Repeatable.
  
