import java.util.Random;
import java.util.Scanner;

public class RPSGame {

    // Helper to convert a character to its full word for printing
    private static String moveToString(char c) {
        switch (c) {
            case 'R': return "Rock";
            case 'P': return "Paper";
            case 'S': return "Scissors";
            default:  return "Invalid";
        }
    }

    // Determine outcome: 0 = tie, 1 = player win, -1 = computer win
    private static int decideWinner(char player, char computer) {
        if (player == computer) return 0;
        // Rock beats Scissors, Scissors beats Paper, Paper beats Rock
        if ((player == 'R' && computer == 'S') ||
            (player == 'S' && computer == 'P') ||
            (player == 'P' && computer == 'R')) {
            return 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Enter number of rounds to play: ");
        int rounds;
        try {
            rounds = Integer.parseInt(scanner.nextLine().trim());
            if (rounds <= 0) {
                System.out.println("Please enter a positive integer.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("That isn’t a valid number.");
            return;
        }

        int playerWins = 0, computerWins = 0, ties = 0;

        for (int i = 1; i <= rounds; i++) {
            System.out.println("\n--- Round " + i + " ---");
            System.out.print("Your move (R=Rock, P=Paper, S=Scissors): ");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.length() != 1 || "RPS".indexOf(input.charAt(0)) == -1) {
                System.out.println("Invalid move – skipping this round.");
                i--; // don’t count this as a played round
                continue;
            }

            char playerMove = input.charAt(0);

            // Generate computer move
            char[] moves = {'R', 'P', 'S'};
            char computerMove = moves[rand.nextInt(3)];

            System.out.println("You chose:      " + moveToString(playerMove));
            System.out.println("Computer chose: " + moveToString(computerMove));

            int result = decideWinner(playerMove, computerMove);
            if (result == 1) {
                System.out.println("You win this round!");
                playerWins++;
            } else if (result == -1) {
                System.out.println("Computer wins this round.");
                computerWins++;
            } else {
                System.out.println("It’s a tie.");
                ties++;
            }
        }

        // Final summary
        System.out.println("\n=== Game Over ===");
        System.out.println("Rounds played : " + rounds);
        System.out.println("Your wins     : " + playerWins);
        System.out.println("Computer wins : " + computerWins);
        System.out.println("Ties          : " + ties);

        if (playerWins > computerWins) {
            System.out.println("Overall result: You Win!");
        } else if (computerWins > playerWins) {
            System.out.println("Overall result: Computer Wins!");
        } else {
            System.out.println("Overall result: Tie!");
        }

        scanner.close();
    }
}