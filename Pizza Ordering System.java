import java.util.Scanner;

public class Homework_2 {
	
	static Scanner s = new Scanner(System.in);		// to use Scanner everywhere in this class
	
	public static int numofpizzas(int pizzas) {
		while (pizzas<0){
			System.out.println("Please enter a positive number or 0 to exit!");
			System.out.print("How many pizzas would you like? ");
			pizzas=s.nextInt();		
			}
		return pizzas;
	}
	
	public static char sizeofpizzas (char size, int i) {
		while (size!='S' && size!='M' && size!='L') {
			System.out.println("You may type only: S, M or L.");
			System.out.printf("What size (S, M, or L) of pizza would you like for pizza %d? ",i);
			size=s.next().charAt(0);
			} 
		return size;
	}
	
	public static int numoftoppings (int toppings, int i) {
		while (toppings<0) {
			System.out.println("You can enter only positive numbers!");
			System.out.printf("How many toppings would you like on pizza %d? ",i);
			toppings=s.nextInt();
			} 
		return toppings;
	}
	
		public static void order (int small, int medium, int large, int sumoftoppings) {
			System.out.println("\nYour order is:");
			if (small!=0){												// avoids typing "0 pizzas"
				if (small==1)
					System.out.printf("\t%d small pizza\n",small);		// if 1 pizza then write "pizza"
				else
					System.out.printf("\t%d small pizzas\n",small);		// if more than 1 pizza write "pizzas"
			}
			
			if (medium!=0){
				if (medium==1)
					System.out.printf("\t%d medium pizza\n",medium);
				else
					System.out.printf("\t%d medium pizzas\n",medium);
			}
				
			if (large!=0){
				if (large==1)
					System.out.printf("\t%d large pizza\n",large);
				else
					System.out.printf("\t%d large pizzas\n",large);
			}
				System.out.printf("\t%d toppings\n",sumoftoppings);
		}
		
		public static void calculations (int small, int medium, int large, int sumoftoppings, int order){
			double totaltoppings=1, subtotal, total, totalsmall=1, totalmedium=1, totallarge=1;
			System.out.println("Receipt:\n---------------Pizza House---------------\n\t\tOrder No "+order);
			totalsmall=5*small;
			totalmedium=7*medium;
			totallarge=9*large;
			totaltoppings=0.75*sumoftoppings;
			subtotal=totalsmall+totalmedium+totallarge+totaltoppings;
			total=subtotal+tax(subtotal);
			
			if (small!=0){																	// avoids typing "0 pizzas"
				if (small==1)
					System.out.printf("\t%d small pizza \t$ %.2f\n",small,totalsmall);		// if 1 pizza then write "pizza"
				else
					System.out.printf("\t%d small pizzas \t$ %.2f\n",small,totalsmall);		// if more than 1 pizza write "pizzas"
			}
			
			if (medium!=0){
				if (medium==1)
					System.out.printf("\t%d medium pizza  $%5.2f\n",medium,totalmedium);
				else
					System.out.printf("\t%d medium pizzas $ %5.2f\n",medium,totalmedium);
			}
				
			if (large!=0){
				if (large==1)
					System.out.printf("\t%d large pizza \t$ %.2f\n",large,totallarge);
				else
					System.out.printf("\t%d large pizzas \t$ %.2f\n",large,totallarge);
			}
				System.out.printf("\t%d toppings \t$ %.2f\n",sumoftoppings, totaltoppings);
				System.out.printf("\n\tSubtotal \t$ %.2f\n",subtotal);
				System.out.printf("\tTax \t\t$ %.2f\n",tax(subtotal));
				System.out.printf("\tTOTAL \t\t$ %.2f\n",total);
		}
		
		public static double tax (double subtotal) {
			double x=subtotal*0.1;
			return x;
		}
	
		public static void main(String[] args) {
			int order=1, pizzas, i, toppings, k, n, m;			// k, n and variables I'll use to hold methods, i-iteration
			char size, approve;									// size: S,M,L; approve: Y or N
		do {
			int  small=0, medium=0, large=0, sumoftoppings=0;
			boolean b=false;
			System.out.println("This is order "+order);
			System.out.print("How many pizzas would you like? ");
			pizzas = s.nextInt();
			k = numofpizzas(pizzas); 		// assigned this method to a variable for easy using
			if (k==0) break;
			else {
				for (i=1;i<=k;i++){			// repeats until entered number of pizzas
					System.out.printf("What size (S, M, or L) of pizza would you like for pizza %d? ",i);
					size = s.next().charAt(0);
					n = sizeofpizzas(size, i);		// assigned this method to a variable for easy using
						if (n=='S')		
							small++;
						else if (n=='M')
							medium++;
						else if (n=='L')
							large++;
					System.out.printf("How many toppings would you like on pizza %d? ",i);	
					toppings=s.nextInt();
					m = numoftoppings(toppings, i);			// assigned this method to a variable for easy using
					sumoftoppings+=m;
				}
				order(small,medium,large,sumoftoppings);
			}
			System.out.println();
			System.out.print("Is this corect? ");
			approve = s.next().charAt(0);
				if (approve=='Y')
					b=true;
				else if (approve=='N'){
					System.out.println();
					continue;					// passes by one and asks again the last order
				}
			if (b)			// if user enters "Yes" then make calculations
				calculations(small, medium, large, sumoftoppings, order);
			System.out.println();
			order++;
		} while (k!=0);			// loop repeats until number of pizzas equals 0
		
		System.out.println("Thanks!");
		
	}
}
