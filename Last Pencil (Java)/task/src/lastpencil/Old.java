//package lastpencil;
//
//import java.util.Random;
//import java.util.Scanner;
//
//public class Old {
//
//    public static Scanner scanner = new Scanner(System.in);
//    public static void print_message(String message) {
//        System.out.println(message);
//    }
//
//    public static String pencils(int number) {
//        return "|".repeat(number);
//    }
//
//    public static boolean is_numeric(String input) {
//        boolean isValid = false;
//        if (input.matches("-?\\d+")) {
//            isValid = true;
//        } else {
//            System.out.println("The number of pencils should be numeric");
//        }
//        return isValid;
//    }
//
//    public static boolean is_positive(String input) {
//        boolean isPositive = false;
//        int number = Integer.parseInt(input);
//        if (number > 0) {
//            isPositive = true;
//        } else {
//            System.out.println("The number of pencils should be positive");
//        }
//        return isPositive;
//    }
//
//    public static String get_player(String[] players) {
//        boolean found = false;
//        String name = "";
//        while (!found) {
//            name = scanner.next();
//            for (String p: players) {
//                if (name.equals(p)) {
//                    found = true;
//                }
//            }
//            if (!found) {
//                System.out.println("Choose between 'John' and 'Jack'");
//            }
//        }
//        return name;
//    }
//
//    public static boolean validate_input_pencil(String input) {
//        boolean isValid = false;
//        String[] pencil_values = {"1", "2", "3"};
//
//        for (String i: pencil_values) {
//            if (i.equals(input)) {
//                isValid = true;
//                break;
//            }
//        }
//        if (!isValid) {
//            System.out.println("Possible values: '1', '2' or '3'");
//        }
//
//        return isValid;
//    }
//
//
//    public static boolean find_winner(int numberOfPencils, String playerName) {
//        boolean found = false;
//        if (numberOfPencils <= 0) {
//            found = true;
//            System.out.printf("%s won!%n", playerName);
//        }
//        return found;
//    }
//
//    public static int bot_winning_strat(int numberOfPencils) {
//        Random rand = new Random();
//        int number = rand.nextInt(3) + 1;
//
//        for (int i = 3; i >= 1; i--) {
//            if((numberOfPencils - i) % 4 == 1) {
//                number = i;
//                break;
//            }
//        }
//
//        if (number > numberOfPencils) {
//            number = numberOfPencils;
//        }
//        return number;
//    }
//
//    public static void main(String[] args) {
//        String[] players = {"John", "Jack"};
//
//        print_message("How many pencils would you like to use: ");
//        Scanner scanner = new Scanner(System.in);
//        String input = "";
//
//        while (true) {
//            input = scanner.nextLine();
//
//            if (is_numeric(input)) {
//                if (is_positive(input)) {
//                    break;
//                }
//            }
//        }
//
//        int numberOfPencils = Integer.parseInt(input);
//
//        print_message("Who will be the first (John, Jack): ");
//        String name = get_player(players);
//        int playerindex = name.equals(players[0]) ? 0 : 1;
//        String currentPlayer;
//        int number;
//        Random rand = new Random();
//
//        do {
//            System.out.println(pencils(numberOfPencils));
//            currentPlayer = players[playerindex];
//            System.out.printf("%s's turn%n", currentPlayer);
//
//            // have bot pick number based on the winning strategy
//            if (currentPlayer.equals("Jack")) {
//
//                number = bot_winning_strat(numberOfPencils);
//
//                System.out.println(number);
//                numberOfPencils -= number;
//                if (find_winner(numberOfPencils, "John")) {
//                    break;
//                }
//
//                // switch loop to John
//                playerindex = 0;
//                continue;
//            }
//
//            // checking input if numeric/is_positive
//            while (true) {
//                input = scanner.nextLine();
//
//                if (is_numeric(input)) {
//                    if (is_positive(input)) {
//                        break;
//                    }
//                }
//            }
//
//            // validate input (1,2,3) max
//            while (!validate_input_pencil(input)) {
//                input = scanner.nextLine();
//            }
//
//            number = Integer.parseInt(input);
//
//            // repeat if input pencil is higher than current pencils
//            while (number > numberOfPencils) {
//                System.out.println("Too many pencils were taken");
//                number = scanner.nextInt();
//            }
//
//            numberOfPencils -= number;
//
//            playerindex = playerindex == 0 ? 1: 0;
//            if (find_winner(numberOfPencils, players[playerindex])) {
//                break;
//            }
//
//        } while (numberOfPencils > 0);
//    }
//}
