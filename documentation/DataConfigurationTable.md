# Data Configuration Table

## CoinFlip Class

| Value & Variable | Input Type/Format | Output Type/Format | Internal Representation |
|-----------------|-------------------|--------------------|------------------------|
| Number of rounds to play – `roundsToPlay` | Integer (1-9, odd numbers only) via `GetInput.getOddIntInput()` | Printed as "First to win X rounds" | `int roundsToPlay` |
| Rounds needed to win – `roundsToWin` | N/A (calculated as `(roundsToPlay / 2) + 1`) | Printed as integer | `int roundsToWin` |
| Player's score – `playerScore` | N/A (incremented on correct guess) | Printed as "You: X" | `int playerScore` |
| Computer's score – `computerScore` | N/A (incremented on incorrect guess) | Printed as "Computer: X" | `int computerScore` |
| Coin flip result – `computerFlip` | N/A (random 1 or 2 via `Random.nextInt(2) + 1`) | Printed as "HEADS" or "TAILS" | `int: 1 = HEADS, 2 = TAILS` |
| User's guess – `guess` | Single char via `GetInput.getCharInput()` with `{'H', 'T'}` | Printed as "HEADS" or "TAILS" | `char: 'H' = HEADS, 'T' = TAILS` |
| Play again choice – `choice` | Single char via `GetInput.getYesNoInput()` with `{'Y', 'N'}` | "Play again? (Y/N)" | `char: 'Y' = Yes, 'N' = No` |

## FindTheThimble Class

| Value & Variable | Input Type/Format | Output Type/Format | Internal Representation |
|-----------------|-------------------|--------------------|------------------------|
| Minimum rounds – `MIN_ROUNDS` | N/A (constant) | N/A | `int: 1` |
| Maximum rounds – `MAX_ROUNDS` | N/A (constant) | N/A | `int: 9` |
| Left hand value – `LEFT` | N/A (constant) | Printed as "LEFT" | `int: 1` |
| Right hand value – `RIGHT` | N/A (constant) | Printed as "RIGHT" | `int: 2` |
| Total rounds to play – `totalRounds` | Integer (odd, 1-9) via `GetInput.getOddIntInput()` | Printed as "First to reach X points wins" | `int totalRounds` |
| Rounds needed to win – `roundsNeededToWin` | N/A (calculated as `(totalRounds / 2) + 1`) | Printed as integer | `int roundsNeededToWin` |
| Thimble location – `thimbleLocation` | N/A (random 1 or 2 via `Random.nextInt(2) + 1`) | Printed as "LEFT" or "RIGHT" | `int: 1 = LEFT, 2 = RIGHT` |
| User's guess – `userGuess` | Single char via `GetInput.getCharInput()` with `{'L', 'R'}` | Printed as "LEFT" or "RIGHT" | `char: 'L' = LEFT, 'R' = RIGHT` |
| Player score – `player1Score` | N/A (incremented on correct guess) | Printed as "You: X" | `int player1Score` |
| Computer score – `computerScore` | N/A (incremented on incorrect guess) | Printed as "Computer: X" | `int computerScore` |

## GuessTheNumber Class

| Value & Variable | Input Type/Format | Output Type/Format | Internal Representation |
|-----------------|-------------------|--------------------|------------------------|
| Range generation min – `RANGE_GENERATION_MIN` | N/A (constant) | N/A | `int: 1` |
| Range generation max – `RANGE_GENERATION_MAX` | N/A (constant) | N/A | `int: 50` |
| Lowest in range – `lowestInRange` | N/A (random from 1-50) | Printed as integer | `int lowestInRange` |
| Highest in range – `highestInRange` | N/A (random from lowestInRange to 50) | Printed as integer | `int highestInRange` |
| Correct number – `correctNumber` | N/A (random within generated range) | Printed as integer | `int correctNumber` |
| Guess limit – `guessLimit` | N/A (calculated as `(highestInRange - lowestInRange) / 2`) | Printed as integer | `int guessLimit` |
| User's guess – `guessNumber` | Integer via `GetInput.getIntInRange()` within current range | Printed as integer | `int guessNumber` |
| Guess count – `guessCount` | N/A (incremented each guess) | Printed as integer | `int guessCount` |

## EvenOdd Class

| Value & Variable | Input Type/Format | Output Type/Format | Internal Representation |
|-----------------|-------------------|--------------------|------------------------|
| Even constant – `EVEN` | N/A (constant) | Printed as "EVEN" | `char: 'E'` |
| Odd constant – `ODD` | N/A (constant) | Printed as "ODD" | `char: 'O'` |
| Valid choices – `VALID_CHOICES` | N/A (constant array) | N/A | `char[]{'E', 'O'}` |
| Minimum rounds – `MIN_ROUNDS` | N/A (constant) | N/A | `int: 1` |
| Maximum rounds – `MAX_ROUNDS` | N/A (constant) | N/A | `int: 9` |
| Computer number min – `COMPUTER_NUMBER_MIN` | N/A (constant) | N/A | `int: 1` |
| Computer number max – `COMPUTER_NUMBER_MAX` | N/A (constant) | N/A | `int: 5` |
| Player number min – `PLAYER_NUMBER_MIN` | N/A (constant) | N/A | `int: 1` |
| Player number max – `PLAYER_NUMBER_MAX` | N/A (constant) | N/A | `int: 10` |
| Rounds to play – `rounds` | Integer (odd, 1-9) via `GetInput.getOddIntInput()` | Printed as "Playing best of X rounds" | `int rounds` |
| Player's number – `playerNumber` | Integer (1-10) via `GetInput.getIntInRange()` | Printed as integer | `int playerNumber` |
| Computer's number – `computerNumber` | N/A (random 1-5 via `Random.nextInt(5) + 1`) | Printed as integer | `int computerNumber` |
| Even/odd guess – `evenOddGuess` | Single char via `GetInput.getCharInput()` with `{'E', 'O'}` | Printed as "Even" or "Odd" | `char: 'E' = EVEN, 'O' = ODD` |
| Sum of numbers – `sum` | N/A (calculated as `playerNumber + computerNumber`) | Printed as integer | `int sum` |

## FindtheRedThread Class

| Value & Variable | Input Type/Format | Output Type/Format | Internal Representation |
|-----------------|-------------------|--------------------|------------------------|
| Total spools – `TOTAL_SPOOLS` | N/A (constant) | N/A | `int: 50` |
| Remaining spools – `remainingSpools` | N/A (decrements as spools are pulled) | Printed as integer | `int remainingSpools` |
| Spools to pull per turn – `xChoice` | Integer (1-10) via `GetInput.getIntInRange()` | Printed as "You picked X spools" | `int xChoice` |
| Red spool position – `redSpoolPosition` | N/A (random 1-50 via `Random.nextInt(50) + 1`) | Printed as integer in Test Mode | `int redSpoolPosition` |
| Current spool position – `currentSpoolPosition` | N/A (increments as spools are pulled) | N/A | `int currentSpoolPosition` |
| Spools picked this turn – `spoolsPicked` | N/A (calculated as `Math.min(xChoice, remainingSpools)`) | Printed as integer | `int spoolsPicked` |
| Player score – `playerScore` | N/A (incremented on win) | Printed as "You: X" | `int playerScore` |
| Computer score – `computerScore` | N/A (incremented on loss) | Printed as "Computer: X" | `int computerScore` |

## PlayGames Class

| Value & Variable | Input Type/Format | Output Type/Format | Internal Representation |
|-----------------|-------------------|--------------------|------------------------|
| Test mode flag – `testMode` | Single char via `GetInput.getStringOptions()` with `{'Y', 'N'}` | Printed as "Test Mode ENABLED/DISABLED" | `boolean: true = enabled, false = disabled` |
| Menu choice – `choice` | Integer (1-6) via `GetInput.getIntInRange()` | Printed as game menu options | `int choice` |
| User total wins – `userTotalWins` | N/A (incremented when player wins a game) | Printed as integer | `int userTotalWins` |
| Computer total wins – `compTotalWins` | N/A (incremented when computer wins a game) | Printed as integer | `int compTotalWins` |
| Games played – `gamesPlayed` | N/A (incremented after each game) | Printed as integer | `int gamesPlayed` |

---

## Unified Data Configuration Table (All Games)

| Class | Value | Input Type/Format | Output Type/Format | Internal Representation |
|-------|-------|-------------------|--------------------|------------------------|
| **CoinFlip** | roundsToPlay | Integer (odd, 1-9) | "First to win X rounds" | `int` |
| **CoinFlip** | coin result | N/A (random) | "HEADS" or "TAILS" | `int: 1=HEADS, 2=TAILS` |
| **CoinFlip** | user guess | 'H' or 'T' | "HEADS" or "TAILS" | `char: 'H'=HEADS, 'T'=TAILS` |
| **FindTheThimble** | totalRounds | Integer (odd, 1-9) | "First to reach X points wins" | `int` |
| **FindTheThimble** | thimble location | N/A (random) | "LEFT" or "RIGHT" | `int: 1=LEFT, 2=RIGHT` |
| **FindTheThimble** | user guess | 'L' or 'R' | "LEFT" or "RIGHT" | `char: 'L'=LEFT, 'R'=RIGHT` |
| **GuessTheNumber** | lowestInRange | N/A (random 1-50) | Printed as integer | `int` |
| **GuessTheNumber** | highestInRange | N/A (random) | Printed as integer | `int` |
| **GuessTheNumber** | correctNumber | N/A (random) | Printed as integer | `int` |
| **GuessTheNumber** | guessLimit | N/A (calculated) | Printed as integer | `int` |
| **GuessTheNumber** | user guess | Integer (within range) | Printed as integer | `int` |
| **EvenOdd** | rounds | Integer (odd, 1-9) | "Playing best of X rounds" | `int` |
| **EvenOdd** | playerNumber | Integer (1-10) | Printed as integer | `int` |
| **EvenOdd** | computerNumber | N/A (random 1-5) | Printed as integer | `int` |
| **EvenOdd** | even/odd guess | 'E' or 'O' | "Even" or "Odd" | `char: 'E'=EVEN, 'O'=ODD` |
| **EvenOdd** | sum | N/A (calculated) | Printed as integer | `int` |
| **FindtheRedThread** | TOTAL_SPOOLS | N/A (constant 50) | Printed as integer | `int: 50` |
| **FindtheRedThread** | xChoice | Integer (1-10) | "You picked X spools" | `int` |
| **FindtheRedThread** | redSpoolPosition | N/A (random 1-50) | Printed in Test Mode | `int` |
| **PlayGames** | testMode | 'Y' or 'N' at startup | "Test Mode ENABLED/DISABLED" | `boolean` |
| **PlayGames** | menu choice | Integer (1-6) | Game menu options | `int` |
| **PlayGames** | userTotalWins | N/A (incremented) | Printed as integer | `int` |
| **PlayGames** | compTotalWins | N/A (incremented) | Printed as integer | `int` |
| **PlayGames** | gamesPlayed | N/A (incremented) | Printed as integer | `int` |