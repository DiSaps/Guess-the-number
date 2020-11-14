import java.util.Random;
import java.util.Scanner;

public class Exercise1 {
	
	static char replay(char play) {
		Scanner scan = new Scanner(System.in);		
		while (play == 'y') {
			try {
				char userReplayChoice = Character.toLowerCase((scan.nextLine().trim()).charAt(0));
				if (userReplayChoice == 'n' || userReplayChoice == 'y') {
					play = userReplayChoice;
					break;
				}
				else {
					System.out.print("Not valid answer! Choose: (y/n): ");
				}
			}
			catch (Exception e) {
				System.out.print("Not valid answer! Choose: (y/n): ");
			}
		}
		return play;
	}
	

	public static void main(String[] args) {
        Random random = new Random();
        try (Scanner scan = new Scanner(System.in)) {
        	char play = 'y';
        	
        	while (play == 'y') {
                int randomInt = 1 + random.nextInt(100);
                int tries = 1, score = 10, minInput = 1, maxInput = 100;
                //System.out.println(randomInt); // Prints the right answer
                System.out.print("Give a number between 1 and 100: ");
                
                while (tries<=10) {
                	try {
                		String userInput = scan.nextLine();
                		int input = Integer.parseInt(userInput.trim());
       
                		if (input>=minInput && input<=maxInput) {
                        	if (input == randomInt) {
                        		System.out.println("Congratulations! You find the number after " + tries + " tries! Score: " + score );             		
                        		System.out.print("Play again (y/n)? ");
                        		play = replay(play);
                        		break;	
                            }
                        	else if (input < randomInt) {
                        		if (tries == 10) {
                            		System.out.println("You lose! Score: " + (score-1));
                            		System.out.print("Play again (y/n)?  ");
                            		play = replay(play);                  		
                            		break;
                        		}
                        		else {
                        			minInput = input + 1;
                        			System.out.println(input + " is low, try again!" + "\n" + "Give a number between " + minInput + " and " + maxInput + " :");
                        		}
                        	}
                        	else if (input > randomInt) {
                        		if (tries == 10) {
                            		System.out.println("You lose! Score: " + (score-1));
                            		System.out.print("Play again (y/n)? ");
                            		play = replay(play);
                            		//break;
                        		}
                        		else {
                        			maxInput = input - 1;
                        			System.out.println(input + " is high. Try again!" + "\n" + "Give a number between " + minInput + " and " + maxInput + " :");
                        		}	
                        	}
                        	tries++;
                        	score--;
                		}
                		else {
                			System.out.println("Number out of bounds! Give a number between " + minInput + " and " + maxInput + ": ");
                		}
                	}
                	catch (Exception e) {
                		System.out.println("Not valid answer! Give a number between " + minInput + " and " + maxInput + ": ");
                	}

            	}
                if (play == 'y') {
                	continue;
                }
                else if (play == 'n') {
                	System.out.println("Thank you!");
                	break;
                }
                
            }	
        		
        }

	}

}
