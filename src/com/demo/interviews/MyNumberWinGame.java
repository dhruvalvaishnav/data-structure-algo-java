package com.demo.interviews;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Dhruval Vaishnav Created on 17-09-2024
 * <p>
 * Detail of the Game :
 * Jay and Amisha are playing a game called "MY NUMBER WIN". Jay and Amisha have set of numbers as favourite numbers but not known to each other
 * it means that Jay doesn’t know Amisha's favourite numbers and vice versa.
 * Jay and Amisha will declare a random number one by one.
 * <p>
 * If the number is favourite of Jay and Amisha both then the person who declared a number will receive last number declared by their opponent in their reward balance.
 * If the number is favourite of only the person who declared the number then that person will receive a loss in reward balance by 5.
 * If the number is favourite of only the opponent then the opponent will receive last number declared by them in their reward balance.
 * Whoever scores 25 in reward balance first will be declared as winner.
 * Jay and Amisha both have total 100 numbers in their favourite list numbers.
 * DEVELOP THIS GAME EFFICIENTLY.
 */
/*
To efficiently implement the game "MY NUMBER WIN," we need to follow these steps:

Data Structures:
    Use Set<Integer> for Jay's and Amisha's favorite numbers for fast lookup.
    Track the last number declared by each player for reward calculations.
    Track the reward balance for both Jay and Amisha.
    Define a constant for the reward amount and loss amount.

Game Logic:
    Each player declares a number.
    Check if the declared number is in the opponent's favorite list.
    Update the reward balances based on the rules provided.
    Check if either player reaches a reward balance of 25 to declare the winner.

Simulation:
    Implement a loop where players declare numbers alternately.
    Track and update the state of the game after each number declaration.
    Announce the winner when a player reaches the target reward balance.

 */

public class MyNumberWinGame {

    // Constants
    private static final int WINNING_SCORE = 25;
    private static final int LOSS_AMOUNT = 5;

    public static void main(String[] args) {
        // Sample favorite numbers
        Set<Integer> jayFavorites = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> amishaFavorites = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));

        // Initializing game state
        int jayBalance = 0;
        int amishaBalance = 0;
        Integer lastJayNumber = null;
        Integer lastAmishaNumber = null;

        Scanner scanner = new Scanner(System.in);

        // Game loop
        while (jayBalance < WINNING_SCORE && amishaBalance < WINNING_SCORE) {
            // Jay's turn
            System.out.print("Jay, declare a number: ");
            int jayNumber = scanner.nextInt();
            lastJayNumber = jayNumber;

            if (amishaFavorites.contains(jayNumber)) {
                // Amisha's favorite
                if (lastAmishaNumber != null) {
                    jayBalance += lastAmishaNumber;
                }
            } else if (jayFavorites.contains(jayNumber)) {
                // Jay's own favorite
                jayBalance -= LOSS_AMOUNT;
            }

            lastJayNumber = jayNumber;

            // Check win condition
            if (jayBalance >= WINNING_SCORE) {
                System.out.println("Jay wins with a balance of " + jayBalance);
                return;
            }

            // Amisha's turn
            System.out.print("Amisha, declare a number: ");
            int amishaNumber = scanner.nextInt();
            lastAmishaNumber = amishaNumber;

            if (jayFavorites.contains(amishaNumber)) {
                // Jay's favorite
                if (lastJayNumber != null) {
                    amishaBalance += lastJayNumber;
                }
            } else if (amishaFavorites.contains(amishaNumber)) {
                // Amisha's own favorite
                amishaBalance -= LOSS_AMOUNT;
            }

            lastAmishaNumber = amishaNumber;

            // Check win condition
            if (amishaBalance >= WINNING_SCORE) {
                System.out.println("Amisha wins with a balance of " + amishaBalance);
                return;
            }

            System.out.println("Jay's Balance is : " + jayBalance + " and Amisha's Balance is : " + amishaBalance);
        }
    }
}

/*

Test Case 1: Basic Scenario
Jay's Favorites: [1, 2, 3]
Amisha's Favorites: [3, 4, 5]
Jay's Declarations: 1, 3
Amisha's Declarations: 3, 4
Expected Outcome:
Both players end up with a few changes in their balances due to overlapping favorite numbers and own favorite numbers.

Test Case 2: No Overlapping Favorites
Jay's Favorites: [1, 2, 3]
Amisha's Favorites: [4, 5, 6]
Jay's Declarations: 1, 2
Amisha's Declarations: 4, 5
Expected Outcome:
No mutual favorites, so both players incur losses for their own favorites and gain nothing from the opponent.

Test Case 3: Same Favorite Numbers
Jay's Favorites: [1, 2, 3]
Amisha's Favorites: [1, 2, 3]
Jay's Declarations: 1, 2, 3
Amisha's Declarations: 3, 2, 1
Expected Outcome:
Both players should frequently receive rewards based on the last declared number of the opponent, leading to a potentially quick win if the balance threshold is reached.

Test Case 4: One Player's Favorites Are Superset of the Other
Jay's Favorites: [1, 2, 3, 4, 5]
Amisha's Favorites: [3, 4]
Jay's Declarations: 3, 5
Amisha's Declarations: 3, 4
Expected Outcome:
Amisha receives rewards for Jay’s favorite numbers and incurs losses when Jay declares his own favorites.

Test Case 5: Immediate Win Condition
Jay's Favorites: [1]
Amisha's Favorites: [2]
Jay's Declarations: 1
Amisha's Declarations: 2
Expected Outcome:
The game should conclude quickly as the declared numbers do not overlap and players incur losses.

Test Case 6: Rapid Gain from Opponent’s Favorite
Jay's Favorites: [1, 2]
Amisha's Favorites: [2, 3]
Jay's Declarations: 1, 2
Amisha's Declarations: 2, 3
Expected Outcome:
Both players should end up with gains due to mutual favorites, potentially reaching the winning score fast.

Test Case 7: Only One Favorite Matches
Jay's Favorites: [1, 2, 3]
Amisha's Favorites: [3, 4, 5]
Jay's Declarations: 1, 4
Amisha's Declarations: 3, 5
Expected Outcome:
Each player gets rewarded once and incurs a loss once due to overlapping and non-overlapping favorites.

Test Case 8: Loss Heavy Game
Jay's Favorites: [1, 2, 3]
Amisha's Favorites: [2, 3, 4]
Jay's Declarations: 1, 2
Amisha's Declarations: 2, 4
Expected Outcome:
Both players should experience significant losses due to frequent self-favorite declarations.

Test Case 9: Empty Favorites
Jay's Favorites: []
Amisha's Favorites: []
Jay's Declarations: 1, 2
Amisha's Declarations: 3, 4
Expected Outcome:
Both players will incur losses for declaring their own numbers since there are no favorite numbers to match with the opponent.

Test Case 10: Alternating Favorited and Non-Favorited Numbers
Jay's Favorites: [1, 3, 5]
Amisha's Favorites: [2, 4, 6]
Jay's Declarations: 1, 4, 5, 2
Amisha's Declarations: 2, 5, 6, 1
Expected Outcome:
The game should have a balanced outcome with rewards and losses, reflecting the alternating nature of favorite declarations.

Testing Procedure:
    Initialize: Set the favorite numbers and declared numbers for each test case.
    Run: Execute the game logic using the test case parameters.
    Verify: Check the final balances and ensure they match the expected outcomes.
    Adjust: Modify the test cases or implementation if discrepancies are found.

 */