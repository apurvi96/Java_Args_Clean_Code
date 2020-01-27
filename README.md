### Name : Apurvi Mansinghka ###
### RollNo. : 2019201093 ##
This is the java version of the Args program described in: http://butunclebob.com/ArticleS.UncleBob.CleanCodeArgs
### Code Explanation  ###
User provides the input as command line argument as per the defined Schema.
The Program extracts, sets the value of each datatype and displays all the values as output.

    Schema:
     - char    - Boolean arg.
     - char*   - String arg.
     - char#   - Integer arg.
     - char##  - double arg.
     - char[*] - one element of a string ar ray.
     - char&   - give key:value elements of Map

Example schema: (f,s*,n#,a##,p[*],m&)<br>
Coresponding command line: "-f -s Bob -n 1 -a 3.2 -p e1 -p e2 -p e3 -m aa:1,bb:2,cc:3


### Features ###
* Parse input and set values for different datatypes
    * Map data structure - [-char key:value] parses the key-value pair provided and stores the value into a hasmap.
    * String Array - [-char stringValue] add provided stringValue to string array .
    * Integer - [-char intValue] Set the default or user provided value to Integer variable. 
    * Double -  [-char doubleValue] Set the default or user provided value to double variable. 
    * String -  [-char stringValue] Set the default or user provided value to string variable.
    * Boolean - [-char ] sets the boolean variable to true. 

Implemented following OOPs concepts:<br>
* Polymorphism - constructor overloading in all the classes to intialize the data members.
* Abstraction - used an Interface class ArgsMarshaller to implement common functions in varios classes.
* Modularity - Seperate classes to represent different entities and each method implements single functionality. 
* Encapsulation - Related data structures and functions in single unit.
    

### Requirements and execution of code ###
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

### Characterstics of Clean Code included in code ###
* Meaningful Naming- Methods named as verb+noun, class and data members named as noun or noun-phrase
* Followed naming Convention for class, method, data members.
* Followed proper indention of function, loops and classes.
* Each Method serves only one functionality.
* Functions are not more than 8-9 lines.
* No function has more than 3 arguments. Most of the functions have 1 or 2 arguments, used 3 arguments only when it is necessary.
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
  -  Fast.
  - Independent.
  - Repeatable.
  - Self validating
  - Timely
  

  
