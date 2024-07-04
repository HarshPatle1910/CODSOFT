/*
 										TASK 2
->Input: Take marks obtained (out of 100) in each subject.
->Calculate Total Marks: Sum up the marks obtained in all subjects.
->Calculate Average Percentage: Divide the total marks by the total number of subjects to get the
average percentage.
->Grade Calculation: Assign grades based on the average percentage achieved.
->Display Results: Show the total marks, average percentage, and the corresponding grade to the user
*/

package Task02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
    	
    	System.out.println("\t\t\tSTUDENT GRADE CALCULATOR\r\n ");
    	
        Scanner scanner = new Scanner(System.in);

        int numberOfSubjects = getValidNumberOfSubjects(scanner);
        double[] marks = new double[numberOfSubjects];
        double totalMarks = 0;

        for (int i = 0; i < numberOfSubjects; i++) {
            marks[i] = getValidMark(scanner, i + 1);
            totalMarks += marks[i];
        }

        double averagePercentage = (double) totalMarks / numberOfSubjects;
        String grade = getGrade(averagePercentage);

        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    //Getting number of subjects
    private static int getValidNumberOfSubjects(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter number of subjects: ");
                int numberOfSubjects = scanner.nextInt();
                if (numberOfSubjects < 1) {
                    System.out.println("Number of subjects must be one or more than one...");
                } else {
                    return numberOfSubjects;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numerical value.\n");
                scanner.next(); // Consume invalid input
            }
        }
    }

    //Method to get valid marks
    private static double getValidMark(Scanner scanner, int subjectNumber) {
        while (true) {
            try {
                System.out.print("Enter marks of Subject " + subjectNumber + " (out of 100): ");
                double mark = scanner.nextDouble();
                if (mark < 0) {
                    System.out.println("Please enter valid marks. Marks must be Positive.");
                } else if (mark > 100) {
                    System.out.println("Please enter valid marks. Marks must be less than or equal to 100");
                } else {
                    return mark;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numerical value.\n");
                scanner.next(); // Consume invalid input
            }
        }
    }

    //Method for finding grade
    private static String getGrade(double averagePercentage) {
        if (averagePercentage > 90) {
            return "A+";
        } else if (averagePercentage > 80) {
            return "A";
        } else if (averagePercentage > 65) {
            return "B";
        } else if (averagePercentage > 50) {
            return "C";
        } else if (averagePercentage > 45) {
            return "D";
        } else {
            return "F";
        }
    }
}