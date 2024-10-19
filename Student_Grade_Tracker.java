package Grade;
import java.util.ArrayList;
import java.util.Scanner;

public class Student_Grade_Tracker {
    // ArrayList to store student scores
    private ArrayList<Double> scores;

    // Constructor to initialize the ArrayList
    public Student_Grade_Tracker() {
        scores = new ArrayList<>();
    }

    // Method to add a score to the list
    public void addScore(double score) {
        scores.add(score);
    }

    // Method to calculate the average score
    public double calculateAverage() {
        if (scores.isEmpty()) {
            return 0; // Return 0 if no scores are entered
        }
        double sum = 0;
        for (double score : scores) {
            sum += score; // Sum up all scores
        }
        return sum / scores.size(); // Return average
    }

    // Method to get the highest score
    public Double getHighestScore() {
        if (scores.isEmpty()) {
            return null; // Return null if no scores are entered
        }
        return scores.stream().max(Double::compare).orElse(null); // Get max score
    }

    // Method to get the lowest score
    public Double getLowestScore() {
        if (scores.isEmpty()) {
            return null; // Return null if no scores are entered
        }
        return scores.stream().min(Double::compare).orElse(null); // Get min score
    }

    // Method to compute grades based on scores
    public ArrayList<String> computeGrades() {
        ArrayList<String> grades = new ArrayList<>();
        for (double score : scores) {
            if (score >= 90) {
                grades.add("A");
            } else if (score >= 80) {
                grades.add("B");
            } else if (score >= 70) {
                grades.add("C");
            } else if (score >= 60) {
                grades.add("D");
            } else {
                grades.add("F");
            }
        }
        return grades; // Return the list of grades
    }

    // Method to display results
    public void displayResults() {
        ArrayList<String> grades = computeGrades();
        System.out.println("\nStudent Grades:");
        for (int i = 0; i < scores.size(); i++) {
            System.out.printf("Student %d: Score: %.2f, Grade: %s%n", (i + 1), scores.get(i), grades.get(i));
        }
        System.out.printf("%nAverage Score: %.2f%n", calculateAverage());
        System.out.printf("Highest Score: %.2f%n", getHighestScore());
        System.out.printf("Lowest Score: %.2f%n", getLowestScore());
    }

    // Main method to run the program
    public static void main(String[] args) {
        Student_Grade_Tracker tracker = new Student_Grade_Tracker();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("Enter student score (or 'done' to finish): ");
            String input = scanner.nextLine();

            // Check if the user wants to finish inputting scores
            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                double score = Double.parseDouble(input); // Parse the input to a double
                tracker.addScore(score); // Add the score to the tracker
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number or 'done' to finish.");
            }
        }

        tracker.displayResults(); // Display the results
        scanner.close(); // Close the scanner
    }
}
