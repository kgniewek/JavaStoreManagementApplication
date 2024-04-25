# Java Store Management Application

### Project Overview
This Java application is designed to manage store inventory efficiently. The application is built using JavaFX and allows users to add, delete, edit, and view items in a store's inventory. It is structured to provide a user-friendly interface for managing items with details like name, category, and price.

### Team Collaboration
The development of this application was a collaborative effort among three team members. Working together on this project was an excellent learning experience in programming and project management. It highlighted the importance of effective communication and task division in achieving project goals.

### Technologies Used
- **Java**: Primary programming language.
- **JavaFX**: Used for creating all user interfaces.
- **Gradle**: For managing dependencies and overall project build.
- **PostgreSQL**: Backend database for storing item data.
- **Lombok**: To reduce boilerplate code in Java applications.

### Source Code Files
- `src/main/java/store/StoreApplication.java`: Main entry point of the application.
- `src/main/java/store/model/DataHandler.java`: Handles all data operations such as fetching, inserting, and updating items.
- `src/main/java/store/create/*`: Classes related to the 'Create Item' functionality.
- `src/main/java/store/edit/*`: Classes for the 'Edit Item' features.
- `src/main/java/store/overview/*`: Responsible for the 'Overview' scene where all items are listed.

### Functionality
- **Item Management**: Users can add, delete, and edit items within the store's inventory database.
- **Search and Filter**: Features to search items by name and filter the list of items by price.
- **Favorites Management**: Allows users to mark items as favorites.

### Setup Instructions
1. Ensure Java and Gradle are installed on your machine.
2. Clone the repository to your local machine.
3. Navigate to the project directory and run `gradlew build` to build the project.
4. Execute `gradlew run` to start the application.

### Learning Outcomes
- The project provided practical experience in using JavaFX for building desktop applications.
- Enhanced our skills in database management and application interface design.
- Gave us insights into the agile development process and version control with Gradle.

### Conclusion
This project not only enhanced our technical skills but also improved our ability to work effectively as part of a team. It culminated in a functional Java application that can be used as a reference for future projects.

### Project Structure

- `build.gradle`: Contains all the project dependencies and plugins.
- `gradlew`, `gradlew.bat`: Gradle wrapper scripts for building the project without requiring installed Gradle.
- `gradle/wrapper/gradle-wrapper.jar`, `gradle-wrapper.properties`: Ensure consistent builds across all environments.

- 📁 **root**
  - `build.gradle`
  - `gradlew`
  - `gradlew.bat`
  - `README.md`
  - `settings.gradle`
  - 📁 **gradle**
    - 📁 **wrapper**
      - `gradle-wrapper.jar`
      - `gradle-wrapper.properties`
  - 📁 **src**
    - 📁 **main**
      - 📁 **java**
        - 📁 **store**
          - `CustomEvent.java`
          - `StoreApplication.java`
          - 📁 **create**
            - `CreateBottomPane.java`
            - `CreateInputPane.java`
            - `CreatePane.java`
            - `CreateScene.java`
          - 📁 **edit**
            - `EditBottomPane.java`
            - `EditInputPane.java`
            - `EditPane.java`
            - `EditScene.java`
          - 📁 **model**
            - `DataHandler.java`
            - `Item.java`
          - 📁 **overview**
            - `OverviewLeftPane.java`
            - `OverviewPane.java`
            - `OverviewScene.java`
            - `OverviewTableView.java`
      - 📁 **resources**
    - 📁 **test**
      - 📁 **java**
      - 📁 **resources**
