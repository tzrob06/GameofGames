# Unit Test Table - Game of Games

## CoinFlipTest

| Run # | Class/Method | Purpose | Test Steps | Expected Result | Actual Result | Passed | Failed |
|-------|--------------|---------|------------|-----------------|---------------|--------|--------|
| 1 | CoinFlip/testRoundRangeConstants | Verify MIN_ROUNDS constant is 1 | Call assertEquals(1, CoinFlip.MIN_ROUNDS) | MIN_ROUNDS equals 1 | MIN_ROUNDS equals 1 | X | |
| 2 | CoinFlip/testRoundRangeConstants | Verify MAX_ROUNDS constant is 9 | Call assertEquals(9, CoinFlip.MAX_ROUNDS) | MAX_ROUNDS equals 9 | MAX_ROUNDS equals 9 | X | |
| 3 | CoinFlip/testCoinConstants | Verify HEADS constant is "HEADS" | Call assertEquals("HEADS", CoinFlip.HEADS) | HEADS equals "HEADS" | HEADS equals "HEADS" | X | |
| 4 | CoinFlip/testCoinConstants | Verify TAILS constant is "TAILS" | Call assertEquals("TAILS", CoinFlip.TAILS) | TAILS equals "TAILS" | TAILS equals "TAILS" | X | |
| 5 | CoinFlip/testOddNumberValidation | Verify odd numbers 1,3,5,7,9 are valid | Loop through validOddNumbers array, assertTrue for each | All odd numbers return true | All odd numbers returned true | X | |
| 6 | CoinFlip/testOddNumberValidation | Verify even numbers 2,4,6,8 are invalid | Loop through invalidEvenNumbers array, assertTrue(num % 2 == 0) | Even numbers identified as even | Even numbers correctly identified | X | |
| 7 | CoinFlip/testPlayGameRuns | Verify playGame method executes without crashing | Call assertDoesNotThrow(() -> CoinFlip.playGame()) | No exception thrown | No exception thrown | X | |

## FindTheThimbleTest

| Run # | Class/Method | Purpose | Test Steps | Expected Result | Actual Result | Passed | Failed |
|-------|--------------|---------|------------|-----------------|---------------|--------|--------|
| 1 | FindTheThimble/testRoundRangeConstants | Verify MIN_ROUNDS constant is 1 | Call assertEquals(1, FindTheThimble.MIN_ROUNDS) | MIN_ROUNDS equals 1 | MIN_ROUNDS equals 1 | X | |
| 2 | FindTheThimble/testRoundRangeConstants | Verify MAX_ROUNDS constant is 9 | Call assertEquals(9, FindTheThimble.MAX_ROUNDS) | MAX_ROUNDS equals 9 | MAX_ROUNDS equals 9 | X | |
| 3 | FindTheThimble/testHandConstants | Verify LEFT constant is 1 | Call assertEquals(1, FindTheThimble.LEFT) | LEFT equals 1 | LEFT equals 1 | X | |
| 4 | FindTheThimble/testHandConstants | Verify RIGHT constant is 2 | Call assertEquals(2, FindTheThimble.RIGHT) | RIGHT equals 2 | RIGHT equals 2 | X | |
| 5 | FindTheThimble/testHandConstants | Verify GUESS_OPTIONS array contains L and R | Call assertArrayEquals(new char[]{'L', 'R'}, FindTheThimble.GUESS_OPTIONS) | GUESS_OPTIONS equals {'L','R'} | GUESS_OPTIONS equals {'L','R'} | X | |
| 6 | FindTheThimble/testOddNumberValidation | Verify odd numbers 1,3,5,7,9 are valid | Loop through validOdds array, assertTrue for each | All odd numbers return true | All odd numbers returned true | X | |
| 7 | FindTheThimble/testOddNumberValidation | Verify even numbers 2,4,6,8 are invalid | Loop through invalidEvens array, assertFalse for each | Even numbers return false | Even numbers returned false | X | |
| 8 | FindTheThimble/testPlayGameRuns | Verify class is instantiable | Call assertNotNull(new FindTheThimble()) | Object created successfully | Object created successfully | X | |
| 1 | ... | ... | ... | ... | ... | ... | ... |
## EvenOddTest

| Run # | Class/Method | Purpose | Test Steps | Expected Result | Actual Result | Passed | Failed |
|-------|--------------|---------|------------|-----------------|---------------|--------|--------|
| 1 | EvenOdd/testValidOddRoundsInput | Verify valid odd number of rounds is accepted | Set input "5\n5\nE\nN\n", call EvenOdd.playGame() | Output contains "Playing best of 5 rounds" | Output contained "Playing best of 5 rounds" | X | |
| 2 | EvenOdd/testInvalidEvenRoundsInput | Verify even number input shows error message | Set input "4\n5\n5\nE\nN\n", call EvenOdd.playGame() | Output contains "Invalid menu choice" | Output contained "Invalid menu choice" | X | |
| 3 | EvenOdd/testInvalidRoundsOutOfRange | Verify out-of-range input shows error message | Set input "0\n5\n5\nE\nN\n", call EvenOdd.playGame() | Output contains "Invalid menu choice" | Output contained "Invalid menu choice" | X | |
| 4 | EvenOdd/testInvalidGuessInput | Verify invalid guess input shows error message | Set input "5\n5\nW\nE\nN\n", call EvenOdd.playGame() | Output contains "Invalid choice" | Output contained "Invalid choice" | X | |

## FindtheRedThreadTest

| Run # | Class/Method | Purpose | Test Steps | Expected Result | Actual Result | Passed | Failed |
|-------|--------------|---------|------------|-----------------|---------------|--------|--------|
| 1 | FindtheRedThread/inputTwoShouldAcceptValidSpoolPull | Verify valid spool pull input (2) is accepted | Set input "2\n" + 30 Enter presses + "N\n", call FindtheRedThread.playGame() | Output contains "You picked 2 spools" | Output contained "You picked 2 spools" | X | |
| 2 | FindtheRedThread/inputValidNumberWhereUserDoesNotWinImmediately | Verify valid spool pull input (5) works | Set input "5\n" + 15 Enter presses + "N\n", call FindtheRedThread.playGame() | Output contains "You picked 5 spools" | Output contained "You picked 5 spools" | X | |
| 3 | FindtheRedThread/inputZeroShouldReturnErrorMessageForRedThread | Verify invalid input 0 shows error message | Set input "0\n2\n" + 30 Enter presses + "N\n", call FindtheRedThread.playGame() | Output contains "Invalid choice. Please enter an integer between 1 and 10" | Output contained error message | X | |

## GuessTheNumberTest

| Run # | Class/Method | Purpose | Test Steps | Expected Result | Actual Result | Passed | Failed |
|-------|--------------|---------|------------|-----------------|---------------|--------|--------|
| 1 | GuessTheNumber/testValidGuessWithinRange | Verify valid guess within range works | Set input "5\nN\n", call GuessTheNumber.playGame() | Output contains "Welcome to the Guess the Number Game!" | Output contained welcome message | X | |
| 2 | GuessTheNumber/testInvalidGuessOutOfRange | Verify out-of-range guess shows error | Set input "0\n5\nN\n", call GuessTheNumber.playGame() | Output contains "Invalid menu choice" | Output contained "Invalid menu choice" | X | |
| 3 | GuessTheNumber/testWinMessageDisplayed | Verify win/loss message is displayed | Set input "5\nN\n", call GuessTheNumber.playGame() | Output contains "Correct!" or "You Won!" or "Out of guesses!" | Output contained win/loss message | X | |
| 4 | GuessTheNumber/testTestModeShowsHiddenInfo | Verify test mode reveals hidden information | Set PlayGames.testMode = true, input "5\nN\n", call GuessTheNumber.playGame() | Output contains "[TEST MODE] Correct number:" | Output contained test mode message | X | |

## PlayGamesTest

| Run # | Class/Method | Purpose | Test Steps | Expected Result | Actual Result | Passed | Failed |
|-------|--------------|---------|------------|-----------------|---------------|--------|--------|
| 1 | PlayGames/inputThreeShouldEnterGuessTheNumberGame | Verify menu option 3 enters Guess the Number game | Set input "N\n3\n" + 20 Enter presses + "1\nN\n6\n", call PlayGames.main() | Output contains "Welcome to the Guess the Number Game" | Output contained Guess the Number welcome | X | |
| 2 | PlayGames/inputEightShouldPromptUserToReenterInput | Verify invalid menu input 8 prompts re-entry | Set input "N\n8\n6\n", call PlayGames.main() | Output contains "Invalid choice. Please enter an integer between 1 and 6." | Output contained invalid choice message | X | |

---

## Summary

| Test Class | Tests Run | Passed | Failed |
|------------|-----------|--------|--------|
| CoinFlipTest | 7 | 7 | 0 |
| EvenOddTest | 4 | 4 | 0 |
| FindtheRedThreadTest | 3 | 3 | 0 |
| GuessTheNumberTest | 4 | 4 | 0 |
| PlayGamesTest | 2 | 2 | 0 |
| **Total** | **20** | **20** | **0** |