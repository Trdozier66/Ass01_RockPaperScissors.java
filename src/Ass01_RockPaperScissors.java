import java.util.Scanner;

public class Ass01_RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playerAChoice, playerBChoice;
        String playAgain;

        do {
            // Get a valid move from Player A
            playerAChoice = getValidMove(scanner, "Player A");

            // Get a valid move from Player B
            playerBChoice = getValidMove(scanner, "Player B");

            // Determine the winner
            String result = determineWinner(playerAChoice, playerBChoice);
            System.out.println(result);

            // Prompt to play again
            System.out.print("Do you want to play again? (Y/N): ");
            playAgain = scanner.next();
        } while (playAgain.equalsIgnoreCase("Y"));

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static String getValidMove(Scanner scanner, String player) {
        String move;
        do {
            System.out.print(player + ", enter your move (R/P/S): ");
            move = scanner.next();
            if (!move.equalsIgnoreCase("R") && !move.equalsIgnoreCase("P") && !move.equalsIgnoreCase("S")) {
                System.out.println("Invalid move. Please enter R, P, or S.");
            }
        } while (!move.equalsIgnoreCase("R") && !move.equalsIgnoreCase("P") && !move.equalsIgnoreCase("S"));
        return move;
    }

    private static String determineWinner(String playerAChoice, String playerBChoice) {
        if (playerAChoice.equals(playerBChoice)) {
            return "It's a Tie!";
        }

        switch (playerAChoice.toUpperCase()) {
            case "R":
                return playerBChoice.equalsIgnoreCase("S") ? "Player A wins! Rock breaks Scissors." : "Player B wins! Paper covers Rock.";
            case "P":
                return playerBChoice.equalsIgnoreCase("R") ? "Player A wins! Paper covers Rock." : "Player B wins! Scissors cuts Paper.";
            case "S":
                return playerBChoice.equalsIgnoreCase("P") ? "Player A wins! Scissors cuts Paper." : "Player B wins! Rock breaks Scissors.";
            default:
                return "Invalid input.";
        }
    }
}


