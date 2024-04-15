# AYA Reviews Application

# Table of Contents
1. [How to run the application](#How-to-Run-the-Application)
2. [Functional Requirements](#Functional-Requirements)
3. [Non-Functional Requirements](#Non-Functional-Requirements)
4. [Code Structure](#Code-Structure)

## **How to Run the Application**

To run the application, navigate to the source directory and run `./gradlew run`. You may need to `./gradlew build` beforehand.

Upon launching, you'll be prompted to register a user by providing a username and password. After registration, proceed to log in using your credentials. Once logged in, you'll be directed to the main screen.

On the main screen, you have the option to search for a movie by name or navigate through a selection of movies using the previous page and next page buttons. When you find a movie you'd like to review, click the review button below the movie's listing to access the review page.

In the review page, you can write your review and assign a rating from 1 to 10. After completing your review, click submit to submit it. To view your review, exit the review page by clicking the exit button and return to the main screen.

From the main screen, search for the movie you reviewed and click the review button again to access the review page. On the right-hand side of the review page, you'll find all the reviews submitted for that movie. Navigate through the reviews using the next button until you find your submitted review. Repeat these steps to review another movie.

Note:
- There's a minor inconvenience when using the previous page and next page buttons on the main screen. Avoid pressing the buttons multiple times past the end of the movie selection. If you overshoot the end, tap the opposite button twice as many times as you tapped the first button at the end of the selection. For instance, if you pressed the next page button until the end and one more time, you'll need to press the previous page button twice to return to the previous movie selections. Alternatively, you can use the search function to navigate more efficiently.
- Currently, there are only 9 movies preloaded in the database. The movie "The Shawshank Redemption" has a couple dummy-reviews as an example. Try adding your own!
## **Functional Requirements**

1. User Account Creation:
   At the application start, each user is prompted to register by creating a unique username and password, which are then stored in the database.

2. User Login:
   Upon account creation, users are prompted to log in by pressing the login button.

3. User Can Search Movies:
   After logging in, users can search through a selection of movies by name or navigate using next page and previous page buttons under the movie selection dashboard.

4. User Writes Review:
   Users can search for a movie, select it, and then write a review along with a 1-10 star rating.

5. User Can View Reviews:
   Once a user submits a review, they can view their own reviews as well as reviews from other individuals for the same movie on the right-hand side of the review screen.

6. Documentation:
   We created a README document that provides users with a comprehensive guide to using the application, as well as instructions on how to avoid error-causing mistakes.


## **Non-Functional Requirements**

1. Data Retention:
   We've set up a SQLite database to store movies, user profiles, and movie reviews. SQLite's reliability and support for various data types make it an ideal choice for ensuring that our application retains data accurately over time.

2. Data Integrity:
   With SQLite's transactional support and ACID properties, changes made by one user are isolated from those made by others, guaranteeing that each user's data remains consistent across logins and actions.

3. Readability:
   We prioritize making our application easily usable and understandable for all types of users. By designing an intuitive user interface that meets application demands, we ensure that our application is highly readable and navigable.

4. Volume Testing:
   We conduct thorough volume testing to assess how our application performs under different load conditions. By using SQLite, we ensure that heavy traffic of users, movies, and reviews are handled properly, maintaining optimal performance and reliability

---

## **Code Structure**


Various design patterns were used when creating this application- the primary pattern implemented was the "Model-View-Control" pattern.

From the root package directory, we have three packages, `control`, `database`, `datamodels`, `view`.
- `view` contains code that directly represents and interacts with the UI. For example `ReviewControllerUI.java` contains definitions for the text objects, button and fields for the review page.
- `datamodels` contains the class definitions for different data elements. These are POJOs that define simple methods such as getters, setters and fields unique to each abstract data type.
- `database` contains Java files that provide a control interface between the actual SQLite database, and the other control classes, defined in the `control` package.
- `control` contains code which acts as in interface between the `view` code and the `database` code.
  - Note: there is likely one too many layers of abstraction between the UI and the Database. The current design is extensible, but ers  on the side of bloat.

###  Design Patterns
Various design patterns and Object-oriented techniques are used within this project
- Inheritance and Abstract classes
  - `Movie.java` and `TVShow.java` are inherited classes. They inherit from `Media`, which defines common "getter-setter" operations.
    - Note: `TVShow.java` is not actually *used* from the visible application- consider it more of a "display of functionality".
  - `AbstractDB` is an abstract class which contains some defined methods that the other `*DB`  files would normally share (for example, the `.get` operations for retrieving data from the database)
- Interface
  - There is one interface, DBOperations which defines the signatures for the `get` and `put` methods.
      - Note: This is only implemented in one location, `AbstractDB` but it allows for extensibility if, for example, the implementation of `get` and/or `put` aren't known.
- Singleton
    - The `connect` function in `AbstractDB.java` is a singleton that returns a single, global `Connection` object for the SQLite database. This is likely a good use case for this pattern, as a single `Connection` object should be used for the life of the application, and the call-chain of the `get` and `put` operations aren't known.

- Dependency Inversion Principle
   - The `AbstractDB` class showcases how the `*DB.java` files *do not depend on concrete object for their CR__ methods*.

- Dependency Injection
   - At various points in the codebase, actual objects are passed between methods and functions. Instead of relying on a global state, many operations/flows of operation will instead rely on a method's given parameter.
  
- Generics 
  - The `AbstractDB.java` class uses generics.
- General OO principles such as maintaining a global state (Current movies being displayed, and it's corresponding title + description, users). This example may also just indicate poor code quality.

### Tools:
We used git/github for version control and collaboration, gradle for dependencies and of course, SQLite for the database. 