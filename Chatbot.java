package application.org;
import java.util.*;
public class Chatbot {
	private Stack<SelectedOptions> backStack = new Stack<>();
	
	public static void main(String[] args) {
	new Chatbot().start();
	}
	private void start() {
	    System.out.println("Welcome to Our Customer Care Service");
	    Scanner input = new Scanner(System.in);
	    backStack.push(new SelectedOptions(1, 1));

	    do {
	        print(backStack.peek().level, backStack.peek().getChoice());
	        System.out.print("Enter your option: ");
	        int choice;

	        try {
	            choice = input.nextInt();

	            if (choice < 0 || choice > 5) {
	                System.out.println("Please enter a valid option");
	                continue;
	            }

	        } catch (InputMismatchException e) {
	            System.out.println("Please enter a valid numeric option.");
	            input.nextLine(); 
	            continue;
	        }

	        if (choice == 5 && !backStack.isEmpty()) {
	            backStack.pop();
	        } else {
	            backStack.push(new SelectedOptions(backStack.peek().level + 1, choice));
	        }

	    } while (!backStack.isEmpty() && backStack.peek().getChoice() != 0);

	    System.out.println("Thank you for visiting our website...");
	    input.close();
	}


	private void print(int level, int choice) {
		for (String choiceString : getChoices(level, choice)) {
			System.out.println(choiceString);
		}
	}

	private ArrayList<String> getChoices(int level, int choice) {
		ArrayList<String> choiceList = new ArrayList<>();

		switch (level) {
		case 1:
			switch (choice) {
			case 1:
				choiceList.addAll(Arrays.asList("1. EB bill", "2. Music", "3. DTH", "4. Movie Ticket", "5. Back",
						"0. Exit"));
				break;
			}
			break;
		case 2:
			switch (choice) {
			
			
			case 1:
				choiceList.addAll(Arrays.asList("1.Pay with Bank Account",
						"2. Pay with Wallet","3.QR code","4.Manage the bill", "5. Back", "0. Exit"));
				break;
			case 2:
				choiceList.addAll(Arrays.asList("1. Ennodu vaa veedu varaikkum", "2. kaaviri aarum kai kuthal arisiyum maranthu pogumaah", "3. En iniya Thanimaiye",
						"4. BadAss maaah ","5. Back", "0. Exit"));
				break;
			case 3:
				choiceList.addAll(Arrays.asList("1. Sun Direct three months start from Rs. 554",
						"2. Airtel Digital TV Mega Lite 3 Month Pack comes with a starting price of Rs. 1106 ", "3. Arasu cable 3 Month Pack comes with a starting price of Rs. 500 ",
						"4. Dish TV  3 Month Pack comes with a starting price of Rs. 460 ","5. Back", "0. Exit"));
				break;
			case 4:
				choiceList.addAll(Arrays.asList("1. Leo-Rohini-Koyambedu-Rs.150", "2. Jigarthanda DoubleX-PVR Grand Mall, Velachery-Rs.200",
						"3. Jappan-Sathyam Cinemas, Royapettah-Rs.250", "4. Jailer-Mayajaal Multiplex,Kanathur-Rs.175","5. Back", "0. Exit"));
				break;
			}
			break;
		case 3:
			choiceList.addAll(Arrays.asList("Your Request Completed Successfully", "5. Back", "0. Exit"));
			break;
		}

		return choiceList;
	}

}