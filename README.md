# FilmQueryProject

## Objectives

- **What is the End Goal?**
<p>The goal of the Film Query Project is to present the user with an application in which they can search for films in the database.

- **General Starter Setup :**
<p>Create object classes: interface implementations (if required), class fields, imports, constructors, getters, setters, hashCode and equals, and toString methods. Create interfaces: abstract methods to be overridden by implementing class(es). Convert to Maven project and add necessary dependencies to the pom.xml. Handle or throw necessary exceptions for the <code>Connection</code> and <code>DriverManager</code> in the <code>DatabaseAccessorObject (DAO)</code>.

- **User Story #1 :** 
<p>Utilizing boolean logic and a <code>switch</code> statement, the user can choose an option from the Film Query menu. The user may continue to peruse the film database until they select the 'Exit' option. A <code>try/catch</code> handles the <code>InputMismatchException</code> just in case the user enters something other than an integer for their selection, while the switch <code>default</code> handles integers that are out of scope. Both instances return the user to the menu to try again. 

- **User Story #2 :** 
<p>The first option in the menu is to search for a film via id. The user's selection is passed to our <code>DAO</code> via method call and is substituted into our <code>mySQL</code> <code>SELECT</code> statement using a <code>bind (?)</code>. The <code>PreparedStatement</code> utilizes the bind to execute the query and get a <code>ResultSet</code>. If there is a film that matches the id entered, the film's information is printed out to the user to include title, release year, rating and description. If not, "No such film found" is returned.

- **User Story #3 :** 
<p>The second option in the menu uses a very similar process as the first, but instead of an id, the user can input a keyword to search through the film's titles and descriptions. The biggest difference is that when it comes to the bind, we must use <code>Regular Expression (REGEX)</code> when substituting in the user's input. Also, this time we are using two bindings rather than one. The result is much the same: if a film's title or description contains the keyword, that film's title, release year, rating and description will print, otherwise, "No such film found" is returned.

- **User Story #4 :** 
<p>What if the user wants to watch a foreign film that is in a different language? The language can be added to the return information but we need the DAO to reach out to another table to get the actual language instead of a number that represents it. By <code>JOIN</code>-ing to the language table with the <code>ON</code>-common key language id, we can add <code>language.name</code> to our SELECT statement and get the language in the ResultSet instead of just a mostly-unhelpful number. Then we simply add language to our printout that returns to the user.

- **User Story #5 :** 
<p>Now the user is getting more curious about our films. They want to view the cast of actors in the film as well. Once the DAO knows the film exists, we can use our <code>findActorsByFilmId</code> method passing in the film id for the bind. This method works almost exactly the same but with the actor table in mind. Because the film and actor tables are not directly connected, the DAO must go through the <code>associate</code> table film_actor. The SELECT statement will include two JOINs this time with their own ON-common keys. Films typically have more than one actor, so after we've constructed each actor with the ResultSet information, we add the actor to an <code>ArrayList</code> of actors. Before the ArrayList gets returned to the calling method, a <code>for each</code> loop iterates through the list and prints out the actors for the user to view.

## Technologies Used
- JDBC, DAO
- Maven
- SQL, mySQL
- Java~OOP
- Eclipse
- Git
- Google - Stack Overflow, Oracle
- Saturday TA Help (Thank you!)

## Lessons Learned
- SQL as a 4th Language
- mySQL databases
- Connection, Driver Manager, Prepared Statement, Binding, Result Set
- DAO, DA Interface, Overriding
- REGEX
- Most Prominent Partial-BrainBlocks
<br>- Getting a REGEX combination can be tricky, especially when you don't use it often, no matter how simple. When it came to the keyword search, getting the REGEX just right for the bind setString took a few tries and I had to use a sysout to make sure it looked correct.
<br>- I know that an exception catch or throw wasn't wholy necessary for the switch statement but I wanted to challenge myself this time and figure it out so that only the correct input worked. After a couple Google search fails, a Stack-Overflow example helped lead me in the right direction and as Denise always recommends, "Flush your Scanner!"