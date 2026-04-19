package thro.fpk;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    static MovieProcessor movieProcessor = new MovieProcessor();

    public static Stream<Movie> streamFiniteSearch(String searchQuery) {
        return Stream.empty();

    }

    public static Stream<Movie> streamFiniteSearch(String searchQuery, int newerThanYear) {
        // Example: Implement infinite stream with year filter, for simplicity newer than given year instead of range

        return Stream.empty();
    }

    public static Stream<Movie> generateInfiniteRecommendations() {
        return Stream.empty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Movie CLI!");
        System.out.println("Type '5' for a list of commands.");

        while (true) {
            System.out.print("\nEnter a command number: ");
            String command = scanner.nextLine().trim();

            switch (command) {
                case "1": // Search

                    break;

                case "2": // Filter
                    //TODO
                    break;

                case "3": // Recommend

                    break;

                case "4": // Toggle
                    //TODO
                    break;

                case "5": // Help
                    System.out.println("Available commands:");
                    System.out.println("1 - Search for movies by title");
                    System.out.println("2 - Filter movies released after 2000 and sort by title");
                    System.out.println("3 - Get infinite movie recommendations");
                    System.out.println("4 - Switch between mock data and live data");
                    System.out.println("5 - Display this help message");
                    System.out.println("6 - Exit the application");
                    break;

                case "6": // Exit
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Unknown command. Type '5' for a list of commands.");
                    break;
            }
        }
    }
}
