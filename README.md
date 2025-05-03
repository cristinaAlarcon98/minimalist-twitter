# MinimalistTwitter

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


We understand that time can be a limiting factor, so it is not mandatory to complete the entire test. If you are unable to finish, we kindly ask you to briefly document the technical decisions you intended to follow and, if possible, set up the solution’s basic structure. We are more interested in understanding your reasoning and approach than a fully implemented solution.

Good luck!
