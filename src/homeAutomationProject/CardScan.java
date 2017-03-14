import java.util.Scanner;

public class CardScan {
	
	static String[] cards = new String[] {  
	         "0008008784122,13392"
	         , "0007659672116,57496"
	         		
	     };
	
	
	static boolean inArray(String thing, String[] array){ 
        boolean in = false;
        for(int i = 0; i < array.length; i += 1){
            if(array[i].equals(thing)){
                in = true;
            }
        }
       return in;
    }
	

	public static void main(String[] args) {	// make and open attendance file with time/date in file name
		Scanner scanner = new Scanner(System.in);

		String input = null;
		
		while(!inArray(input, cards)){
			System.out.println("Scanner your card");
			input = scanner.nextLine();
		
				if(!inArray(input, cards)){
					System.out.println("intruder");
				}
				else{
					if(input.equals(cards[0])){
						System.out.println("welcome Jin");
					}
					else{
						System.out.println("welcome Chris");
					}	
				}	
		}
	}

}

