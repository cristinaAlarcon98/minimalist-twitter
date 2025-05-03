# WebTwitter

**To run the application:**

1. 🔁 Clone the repository  : `git clone <repository-url>`
2. 📂 Navigate to the project directory  : `cd <project-directory>`
3. 📦 Install dependencies :
   - 🛠️ For the backend : `cd backend && ./mvnw install`
   - 🎨 For the frontend : `cd frontend && npm install`
4. 🔙 Start the backend server : `cd backend && ./mvnw spring-boot:run`
5. 🌐 Start the frontend : `cd frontend && npm start`
6. 🌍 Open the application in your browser at `http://localhost:3000`

**To run the tests ✅:**

1. Navigate to the backend directory: `cd backend`
2. Run all tests using Maven: `./mvnw test`

<h2>My feedback and things to improve</h2>

1. Add more test cases.
2. Improve error handling, maybe using global exceptions.
3. Improve frontend code by using more CSS classes.
4. Maybe use a different structure for controllers and services.
5. General optimizations (?).

<h2>Scenarios</h2>


**Posting a message**

- As a user we should be able to add new messages to the timeline

**Following/Unfollowing a user**

- As a user we should be able to follow or unfollow a user.

**View timeline messages**

- Once the main view is accessed, the aggregated list of all messages from users we follow (including mine) will be displayed.
- When selecting one of the following users, the timeline should only show posts from that user.
- Again, if no follower is selected, it should show the aggregated message list of all the users you follow.
- The content of a message should include this info: author name, date, content

<h2>What we are looking for?</h2>
 
* We are loooking for a fullstack role, so pay attention to both, backend and frontend.
* Pay attention about how your code is organized. It's important the domain of the application is reflected in the code.
* We love reusable and scalable code. This is the reason why we pay attention to the separation of concerns between the UI and the business logic.
* We would love to see the usage of the Software Design Patterns, SOLID principles and Clean Architectures.
* We are not fanboys of frameworks/libraries but keep in mind that our frontend stack is based on React and our backend stack is Java with Springboot.
* We don't think 100% of code coverage is a must, but we love tests.
* It is essential to include clear instructions on how to run the application.
* We are looking forward to seeing your code and discussing your solution with you.
* You can explain the technical decisions if you find it useful.

<h2>How the UI should look like?</h2>

You are not intended to be proven as a designer. The provided mockup are just a guideline, feel free to build whatever you want. You can use a component's library in order to help you to build the UI or code it from scratch, no preference here.

![View the wall](resources/wireframe.png)

<h2>Note for the candidate</h2>

We understand that time can be a limiting factor, so it is not mandatory to complete the entire test. If you are unable to finish, we kindly ask you to briefly document the technical decisions you intended to follow and, if possible, set up the solution’s basic structure. We are more interested in understanding your reasoning and approach than a fully implemented solution.

Good luck!
