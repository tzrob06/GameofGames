# Data Configuration Table

## CoinFlip Class

| Value & Variable | Input Type/Format | Output Type/Format | Internal Representation |
|-----------------|-------------------|--------------------|------------------------|
| Number of rounds to play – `roundsToPlay` | Integer (1-9, odd numbers only) via `GetInput.getOddIntInput()` | Printed as "First to win X rounds" | `int roundsToPlay` |
| Rounds needed to win – `roundsToWin` | N/A (calculated as `(roundsToPlay / 2) + 1`) | Printed as integer | `int roundsToWin` |
| Player's score – `playerScore` | N/A (incremented on correct guess) | Printed as "You: X" | `int playerScore` |
| Computer's score – `computerScore` | N/A (incremented on incorrect guess) | Printed as "Computer: X" | `int computerScore` |
| Coin flip result – `computerFlip` | N/A (random 1 or 2) | Printed as "HEADS" or "TAILS" | `int: 1 = HEADS, 2 = TAILS` |
| User's guess – `guess` | Single char via `GetInput.getCharInput()` with `{'H', 'T'}` | Printed as "HEADS" or "TAILS" | `char: 'H' = HEADS, 'T' = TAILS` |
| Play again choice – `choice` | Single char via `GetInput.getYesNoInput()` with `{'Y', 'N'}` | "Play again? (Y/N)" | `char: 'Y' = Yes, 'N' = No` |

## Unified Data Configuration Table (All Games)

| Class | Value | Input Type/Format | Output Type/Format | Internal Representation |
|-------|-------|-------------------|--------------------|------------------------|
| **CoinFlip** | roundsToPlay | Integer (odd, 1-9) | "First to win X rounds" | `int` |
| **CoinFlip** | coin result | N/A (random) | "HEADS" or "TAILS" | `int: 1=HEADS, 2=TAILS` |
| **CoinFlip** | user guess | 'H' or 'T' | "HEADS" or "TAILS" | `char: 'H'=HEADS, 'T'=TAILS` |
| **FindTheThimble** | hand choice | 'L' or 'R' | "LEFT" or "RIGHT" | `char: 'L'=LEFT, 'R'=RIGHT` |
| **GuessTheNumber** | range bounds | N/A (random) | Printed as numbers | `int lowestInRange, int highestInRange` |
| **GuessTheNumber** | guess limit | N/A (calculated) | Printed as integer | `int guessLimit` |
| **EvenOdd** | even/odd choice | 'E' or 'O' | "EVEN" or "ODD" | `char: 'E'=EVEN, 'O'=ODD` |
| **EvenOdd** | number choice | Integer (1-5) | Printed as integer | `int userNumber` |
| **FindTheRedThread** | spools to pull | Integer (1-10) | Printed as integer | `int xChoice` |
| **FindTheRedThread** | red spool position | N/A (random 1-50) | "Red spool found!" | `int redSpoolPosition` |
| **PlayGames** | menu choice | Integer (1-6) | Game menu options | `int choice` |