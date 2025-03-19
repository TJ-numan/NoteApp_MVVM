# NoteApp_MVVM - A Simple Note-Taking App

## Overview
**NoteApp_MVVM** is a simple yet powerful note-taking application built with **Java** following the **MVVM (Model-View-ViewModel) architecture**. The app provides an intuitive interface to create, edit, update, and delete notes efficiently. Additionally, it includes an **alarm feature** to notify users for specific date-based notes and a **strike-through task feature** to mark completed tasks.

## Features
- **MVVM Architecture** for clean and maintainable code.
- **Create, Edit, Update, and Delete Notes** with ease.
- **Alarm Feature** to set reminders for specific date-based notes.
- **Strike-through Task Feature** to mark tasks as completed.
- **RecyclerView with LiveData** to display notes dynamically.
- **Material Design UI Components** for a modern look and feel.

## Technologies Used
- **Android (Java)**
- **MVVM Architecture** (ViewModel, LiveData, Repository, Room Database)
- **Room Database** for local data storage.
- **AlarmManager & BroadcastReceiver** for the reminder feature.
- **RecyclerView** for displaying notes.
- **Material Design Components** for UI enhancements.

## Project Structure
```
NoteApp_MVVM/
│-- app/
│   ├── java/com/example/noteapp_mvvm/
│   │   ├── model/         # Data Models (Room Entity)
│   │   ├── repository/    # Repository for database interactions
│   │   ├── view/          # UI Components (Activities, Fragments)
│   │   ├── viewmodel/     # Business Logic (ViewModel)
│   ├── res/layout/        # XML Layout Files
│   ├── res/values/        # Strings, Colors, Styles
```

## Installation and Setup
1. **Clone the Repository**
   ```sh
   git clone https://github.com/your-repo/NoteApp_MVVM.git
   ```

2. **Open in Android Studio**
   - Open the project in **Android Studio**

3. **Add Dependencies** (if not already added)
   ```gradle
   implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0'
   implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.4.0'
   implementation 'androidx.room:room-runtime:2.4.2'
   annotationProcessor 'androidx.room:room-compiler:2.4.2'
   ```

4. **Run the Application**
   - Connect an Android device or emulator
   - Press `Run` ▶️ in Android Studio

## How to Use
- **Add a Note**: Click on the `+` button to create a new note.
- **Edit or Update a Note**: Tap on an existing note to modify its content.
- **Set an Alarm**: When adding or editing a note, set a reminder to receive a notification.
- **Mark as Completed**: Use the strike-through feature to indicate completed tasks.

## Contributing
Feel free to contribute by submitting pull requests to enhance the project.

## License
This project is licensed under the **MIT License**.

