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
		
		Scanner scanObj = new Scanner(System.in);
		
		int total_marks = 0;
		int mrk = 0;
		double avg_percentage=0.0;
		int number_of_subjects=0;
		boolean valuesOK = false;
		
		while(!valuesOK) {
			try {
				//Getting number of Subjects
				System.out.print("Enter number of subjects: ");
				number_of_subjects = scanObj.nextInt();
				while(number_of_subjects<1) {
					System.out.println("Number of subjects must be one or more than one...");
					System.out.print("Enter number of subjects: ");
					number_of_subjects = scanObj.nextInt();
				}
				
				int []marks = new int[number_of_subjects];
				
				//Getting and calculating total Marks of subjects
				for(int i=0;i<number_of_subjects;i++) {
					System.out.print("Enter marks of Subject " + (i+1) + " (out of 100): ");
					mrk = scanObj.nextInt();
					
					if (mrk>100) {
						System.out.println("Please enter valid marks. Marks must be less than or equal to 100");
						i--;
					}else if (mrk<0){
						System.out.println("Please enter valid marks. Marks must be Positive.");
						i--;
					}else{
						marks[i]=mrk;
						total_marks += marks[i];
					}
				}
				
				
				try {
					//Calculating Average Percentage
					avg_percentage = (double)total_marks/number_of_subjects;
				} catch (ArithmeticException e) {
					System.out.print("Number of subjects must greater than zero.");
				}
				
				valuesOK = true;
					
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a numerical value.\n");
	            scanObj.next(); // Consume invalid input
			}	
		}
				
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
		
		scanObj.close();
	}

}
