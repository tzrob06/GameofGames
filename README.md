-The Game of Games - Implementation

-Project Overview
  This project is Group 1's implementation of the "Game of Games", which is a terminal-based suite of mini-games written in Java. This implementation is   based on the design documents, use cases, and test suites provided by Group 4 (Valeria, Allan, David, and Erica).

-Program Modes
  The program includes two variations of execution to facilitate both standard gameplay and debugging:
  * **Player Mode:** The standard player experience without any hidden information revealed.
  * **Test Mode:** A debugging mode that displays hidden information in advance of or during game play (e.g., showing the random hand the thimble is in,   or where the red thread is hidden). This mode allows the program to be verified efficiently without needing to play rounds repeatedly until specific     random conditions occur.

-File Directory Definition
  As per the implementation requirements, the following Java files and documentation are included in this repository. Each game has been separated into    its own distinct class.

-Core Classes
  * **PlayGames.java**: The main driver class of the program. It displays the main Game of Games menu, controls overall progression, tracks the global     user/computer scoreboard, and handles the toggle between Player and Test modes. It looks 
  * **GetInput.java**: A centralized utility class containing generic methods to prompt and retrieve user input. It ensures the program remains            resilient and gracefully handles user input errors (such as catching exception errors when text is entered instead of an integer).

//in progress
-Game Classes
  * **FindTheThimble.java**: Contains the internal logic and loops for the "Find the Thimble" game.
  * **CoinFlip.java**: Contains the internal logic and loops for the "Coin Flip" game.
  * **GuessTheNumber.java**: Contains the internal logic and loops for the "Guess the Number" game.
  * **EvenOdd.java**: Contains the internal logic and loops for the "Even and Odd" game.
  * **FindTheRedThread.java**: Contains the internal logic and loops for the "Find the Red Thread" game.

** for each of the necessary classes a test class is included to verify all possible paths as according to group 4's testing document

//still need to complete these
-Documentation Files
  * **Deployment_Document.pdf**: Details step-by-step directions on how the code can be accessed, downloaded, configured, and run.
  * **Responsibilities_Document.pdf**: Indicates which implementation team member was responsible for coding specific classes and managing external documents.
  * **Code_Design_and_Testing.pd**: A unified document containing UML diagrams, Method Glossaries, Data Configuration Tables, and Unit Tests (including    the design team's test suites marked with actual testing results).
  * **Meeting_Notes.pdf**: A compiled record of the implementation team's meetings and progress tracking.

-How to Run
  Please refer to the Deployment_Document.pdf for detailed IDE configuration, compilation, and execution instructions.
