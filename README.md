# TrucoScoreBoard

An electronic scoreboard application for the traditional card game Truco. Developed as a class assignment for Mobile Device Programming. This repository implements the classic Android UI approach using XML Views.

## Features
* **Score Tracking:** Visual components to track points for Team A and Team B.
* **Point Controls:** Buttons to add 1 point or 3 points.
* **Mão de 11 (11-Point Hand):** Automatically detects and alerts when a team enters the 11-point hand. The +3 points button is automatically disabled for the team with 11 points to follow standard Truco rules.
* **Match Winner:** Declares the winning team once 12 points are reached.
* **Restart:** A button to reset the match points to zero.

## Tech Stack
* **Language:** Kotlin 2.2
* **UI Toolkit:** XML Views (Classic Layouts)
* **Minimum SDK:** API 26 (Android 8/Oreo)
* **IDE:** Android Studio Panda 1
* **Build System:** Gradle 9.2.1 with AGP 9.0.1

## How to Run
1. Clone the repository: `git clone https://github.com/heitorlemescaldas/TrucoScoreBoard.git`
2. Open the project in Android Studio.
3. Sync the project with Gradle files.
4. Run the app on an emulator or physical device running API 26 or higher.

## Author
**Heitor Lemes Caldas**