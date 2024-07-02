package Task01;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class Task1 {

	public static void main(String[] args) {
		Scanner scan_obj = new Scanner(System.in);
		Random rand = new Random();
        int max_range = 100,min_range = 1;
        int generated_number;
        int guessed_number;
        boolean win = false;
        int attempt = 0;
        int total_attempt = 0;
        boolean play_again = true;
        String level = "easy";
        int round = 0;
        
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Generated numbers are within " + min_range + " to " + max_range);
        
        
        do {
        	
        	while(true) {
        		
        		++round;
            	//Adding levels of game
                System.out.print("Choose type of level - (Easy or Hard): ");
                level = scan_obj.nextLine();
            
                //Generated Random Number
                generated_number = rand.nextInt(max_range - min_range + 1) + min_range;
                //System.out.println("\nYour generated number : "+generated_number);
                
                
                if (level.equalsIgnoreCase("Easy")) {
                	//Playing easy level
                	System.out.println("You choosed easy level. You have unlimited chances to play.");
            
                	while(!win) {
                    	System.out.println("\n\nThis is your attempt "+ ++attempt + " of round " + round + " : ");
                        
                    	try {
                    		//Getting user input to guess for the generated number
                            System.out.print("Enter a number to guess for the generated number: ");
                            guessed_number = scan_obj.nextInt();
                            //System.out.println(guessed_number);
                    		
                            if (guessed_number < generated_number) {
                            	System.out.println("Guessed number " + guessed_number + " is too low.");
                            }
                            else if (guessed_number > generated_number) {
                            	System.out.println("Guessed number " + guessed_number + " is too high.");
                            } 
                            else {
                            	System.out.println("Guessed number " + guessed_number + " is correct.");
                            	win = true;
                            	
                            	System.out.println("Congratulations! You win the game.");
                            	System.out.println("You took " + attempt + " attempts to guess the number");
                            	
                            }
        				} catch (InputMismatchException e) {
        					System.out.println("Invalid input. Please enter an integer.");
        					scan_obj.next();
        				}
                    }
                    
                	
                	break;
                }
                else if (level.equalsIgnoreCase("Hard")) {
                	//Playing Hard Level
                	System.out.println("You choosed hard level. You have just 10 attempts to play.");
                	
                	while(!win) {
                    	
                		++attempt;
                		
                        if (attempt<10) {
                        	System.out.println("\n\nThis is your attempt "+ attempt + " of round " + round + " : ");
                        }
                        else if (attempt==10) {
                    		System.out.println("\n\nThis is last attempt " + attempt + " of round " + round + ".");
                    	}else if(attempt>10) {
                    		System.out.println("\n\nYou attempted all 10 chances. You lossed!");
                    		break;
                    	}
                    	
                    	try {
                    		//Getting user input to guess for the generated number
                            System.out.print("Enter a number to guess for the generated number: ");
                            guessed_number = scan_obj.nextInt();
                            //System.out.println(guessed_number);
                    		
                            if (guessed_number < generated_number) {
                            	System.out.println("Guessed number " + guessed_number + " is too low.");
                            }
                            else if (guessed_number > generated_number) {
                            	System.out.println("Guessed number " + guessed_number + " is too high.");
                            } 
                            else {
                            	System.out.println("Guessed number " + guessed_number + " is correct.");
                            	win = true;
                            	
                            	System.out.println("Congratulations! You win the game.");
                            	System.out.println("You took " + attempt + " attempts to guess the number");
                            }
        				} catch (InputMismatchException e) {
        					System.out.println("Invalid input. Please enter an integer.");
        					scan_obj.next();
        				}
                    }
                    
                	break;
                }
                else {
                	System.out.println("Invalid input. Please enter 'Easy' or 'Hard'.");
                }
                
            }

        	System.out.println("\nDo you want to play again(Yes or No)?");
        	play_again = scan_obj.next().equalsIgnoreCase("Yes");
        	win = false;
        	total_attempt += attempt;
        	attempt = 0;
        }while (play_again);
        
        System.out.println("You have played " + round + " round with total " + total_attempt + " attempts.");
        System.out.println("Thanks to play game!");
	}
}
