package Task01;

import java.util.Scanner;
import java.util.Random;

public class Task1 {

	public static void main(String[] args) {
		Scanner scan_obj = new Scanner(System.in);
		Random rand = new Random();
        int max_range=100,min_range=1;
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Generated numbers are within "+min_range+" to "+max_range);
        
        //Generated Random Number
        System.out.println(rand.nextInt(max_range - min_range + 1) + min_range);
		
	}
}
