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

import java.util.Scanner;

public class Task2 {

	public static void main(String[] args) {
		
		Scanner scan_obj = new Scanner(System.in);
		
		//Getting number of Subjects
		System.out.print("Enter number of Subjects: ");
		int number_of_subjects = scan_obj.nextInt();
		
		int total_marks = 0;
		int []marks = new int[number_of_subjects];
		
		//Getting and calculating total Marks of subjects
		for(int i=0;i<number_of_subjects;i++) {
			System.out.print("Enter marks of Subject " + (i+1) + " (out of 100): ");
			marks[i] = scan_obj.nextInt();
			total_marks += marks[i];
		}
		
		//Calculating Average Percentage
		float avg_percentage = total_marks/number_of_subjects;
		
		//Calculating grades
		String grade;
		if (avg_percentage>90) {
			grade = "A+";
		} else if (avg_percentage>80) {
			grade = "A";
		} else if (avg_percentage>65) {
			grade = "B";
		} else if (avg_percentage>50) {
			grade = "C";
		} else if (avg_percentage>45) {
			grade = "D";
		} else {
			grade = "F";
		}
		
		//Showing the total marks, average percentage, and grade
		System.out.println("Total Marks: " + total_marks);
		System.out.println("Average Percentage: " + avg_percentage);
		System.out.println("Grade: " + grade);
		
		scan_obj.close();
	}

}
