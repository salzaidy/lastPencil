package lastpencil;

import java.util.*;

public class Main {


    final private static String pencil = "|";
    static ArrayList<String> playerList = new ArrayList<>(List.of("John", "Jack"));
    static Scanner scanner = new Scanner(System.in);

    static int currentPlayerIndex;
    static int totalPencilCount;

    public static void main(String[] args) {
        askForPencilCount();
        askForFirstTurn();

        gameStatus();
    }

    // TODO: need to handle if player does not exist in list & numeric value!
    public static void askForFirstTurn() {
        System.out.println("Who will be the first (John, Jack): ");
        String userInput;

        while (true) {
            String str = scanner.next();
            // convert first letter to uppercase to match string in ArrayList
            userInput = str.substring(0, 1).toUpperCase() + str.substring(1);

            if (isNumeric(userInput)) {
                System.out.println("Choose between 'John' and 'Jack'");
            } else if (!userInput.equals(playerList.get(0)) && !userInput.equals(playerList.get(1))) {
                System.out.println("Choose between 'John' and 'Jack'");
            } else {
                // get index of player and assign to var currentPlayerIndex
                currentPlayerIndex = playerList.indexOf(userInput);
                break;
            }
        }
    }

    // DONE: handle both NONE Numeric & Negative input
    public static void askForPencilCount() {
        System.out.println("How many pencils would you like to use: ");

        while (totalPencilCount <= 0) {
            String userInput = scanner.nextLine();

            if (userInput.isEmpty()) {
                System.out.println("The number of pencils should be numeric");
            } else {
                try {
                    totalPencilCount = Integer.parseInt(userInput);

                    if (totalPencilCount <= 0) {
                        System.out.println("The number of pencils should be positive");
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("The number of pencils should be numeric");
                }
            }
        }
    }

    public static void updateCurrentPlayer() {
        currentPlayerIndex = playerList.get(currentPlayerIndex).equals("John") ? 1 : 0;
//        System.out.println(playerList.get(currentPlayerIndex));
    }

    // TODO:: need to handle both NONE Numeric & Negative input
    public static void updateTotalPencilCount() {

        boolean isValid = false;
        int pencilsToSubtract;

        while (!isValid) {

            String num = scanner.next();

            try {
                pencilsToSubtract = Integer.parseInt(num);

                if (pencilsToSubtract >= 1 && pencilsToSubtract <= 3) {
                    if (totalPencilCount >= pencilsToSubtract) {
                        totalPencilCount = totalPencilCount - pencilsToSubtract;
                        isValid = true;
                    } else {
                        System.out.println("Too many pencils were taken");
                    }
                } else {
                    System.out.println("Possible values: '1', '2' or '3'");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Possible values: '1', '2' or '3'");
            }
        }
    }

    public static void printPencilCount() {
        for (int i = 1; i <= totalPencilCount; i++) {
            System.out.print(pencil);
        }
    }

    public static void printCurrentPlayerName() {
        System.out.println("\n" + playerList.get(currentPlayerIndex) + "'s turn!");
    }

    public static void gameStatus() {
        while (totalPencilCount > 0) {
            printPencilCount();
            printCurrentPlayerName();
            updateTotalPencilCount();
            updateCurrentPlayer();
        }
        System.out.println(playerList.get(currentPlayerIndex) + " won!");
    }


    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}








