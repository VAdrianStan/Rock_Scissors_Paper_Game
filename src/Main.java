import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        playGame();
    }

    static void playGame() {

        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        Random rnd = new Random();
        int playerScore = 0;
        int computerScore = 0;

        while (true) {
            // for player
            System.out.print("Input your choice (1 -> Rock, 2 -> Paper, 3 -> Scissors, 0 -> QUIT GAME: ");
            int playerChoice = sc.nextInt();

            if (playerChoice == 0) {
                System.out.println("Are you sure you want to exit the game? Y/N");
                char exitChar = sc1.next().charAt(0);
                exitChar = Character.toLowerCase(exitChar);

                if (exitChar == 'y') {
                    System.out.printf("Score: Player -> %d | Computer -> %d\n", playerScore, computerScore);
                    System.out.println("The final winner is: "
                            + (playerScore > computerScore ? "Player"
                            : playerScore < computerScore ? "Computer"
                            : "Draw"));
                    break;
                } else if (exitChar == 'n') {
                    continue;
                }
            }

            // for computer
            int computerChoice = rnd.nextInt(1, 4);

            if (playerChoice == 1) {
                System.out.println("You chose rock");
                if (computerChoice == 1) {
                    System.out.println("The computer chose rock");
                    System.out.println(ConsoleColors.YELLOW + "Draw" + ConsoleColors.RESET);
                } else if (computerChoice == 2) {
                    System.out.println("The computer chose paper");
                    System.out.println(ConsoleColors.RED + "You lost" + ConsoleColors.RESET);
                    computerScore++;
                } else {
                    System.out.println("The computer chose scissors");
                    System.out.println(ConsoleColors.GREEN + "You won" + ConsoleColors.RESET);
                    playerScore++;
                }
            } else if (playerChoice == 2) {
                System.out.println("You chose paper");

                if (computerChoice == 1) {
                    System.out.println("The computer chose rock");
                    System.out.println(ConsoleColors.GREEN + "You won" + ConsoleColors.RESET);
                    playerScore++;
                } else if (computerChoice == 2) {
                    System.out.println("The computer chose paper");
                    System.out.println(ConsoleColors.YELLOW + "Draw" + ConsoleColors.RESET);
                } else {
                    System.out.println("The computer chose scissors");
                    System.out.println(ConsoleColors.RED + "You lost" + ConsoleColors.RESET);
                    computerScore++;
                }
            } else if (playerChoice == 3) {
                System.out.println("You chose scissors");

                if (computerChoice == 1) {
                    System.out.println("The computer chose rock");
                    System.out.println(ConsoleColors.RED + "You lost" + ConsoleColors.RESET);
                    computerScore++;
                } else if (computerChoice == 2) {
                    System.out.println("The computer chose paper");
                    System.out.println(ConsoleColors.GREEN + "You won" + ConsoleColors.RESET);
                    playerScore++;
                } else {
                    System.out.println("The computer chose scissors");
                    System.out.println(ConsoleColors.YELLOW + "Draw" + ConsoleColors.RESET);
                }
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }
}
