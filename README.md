# Group8

# Software Engineering Assignment

For the rest of this semester, you will work in groups of five on a software development project. You are expected to utilize a “Scrum-Kanban”-type hybrid agile methodology, including user stories, sprints, standups and retrospectives; more details will be provided as we progress. This project will also be the backdrop to integrate topics such as version control, test-driven development, and code reviews as we cover them in class.

The software development projects should be of moderate complexity. Each project should be written in Java and should include the following components:

	1. Automatic download of a structured dataset (e.g. CSV, XML, JSON) through the use of an API. The dataset should be 
	   downloaded automatically at set intervals (daily or weekly, depending on the project).
	2. Automatic parsing of the dataset
	3. A front-end/GUI through which the user can interact with the data.
	
Group 8: daily NYC schoolbus delays and breakdowns (https://data.cityofnewyork.us/Transportation/Bus-Breakdown-and-Delays/ez4e-fazm​)

# Our Results

Project Name: BUSWHERE

What did we accomplish?

We created a functioning bus application, using the MVC architectural pattern, which can sort and search school bus data with different users and user-specific functionalities. We also implemented unit testing using JUnit and TestFX, where we tested our controllers, database connection, and FXML components.

Features We Added: 

	• Login and SignUp feature with validation of username and password using implemented database

	• Table that shows all NYC school bus breakdown and delay information using data from API

	• Each table column can be sorted ascending/descending and users can choose to filter out columns they don't want to see

	• Users can also search the table to find school buses by borough, name, or type of delay.


Technologies Used:

	• Java/JavaScript/JavaFX/HTML/CSS/Junit/Test-FX/MySQL/Scene-Builder
