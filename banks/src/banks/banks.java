/**********************************************

Workshop 2

Course:JAC444

Last Name:Khaikin

First Name:Sergey



Section:<section name>

This assignment represents my own work in accordance with Seneca Academic Policy.

Sergey Khaikin

Date:<submission date>

**********************************************/

package banks;

import java.util.*;

public class banks {

	public static void main(String[] args) {
		
		int n = 0, id;
		double limit = 0, amount, assets;
		boolean invalidInput;
				
		Scanner input = new Scanner(System.in);
		
		//Input number of banks and asset limit---------------------------------------	
		do{
			invalidInput = false;
			try{			
				System.out.print("Number of banks: ");
				n = input.nextInt();
				
				System.out.print("Minimum asset limit: ");
				limit = input.nextDouble();
			}catch(InputMismatchException e){
				System.out.println("Invalid input");
				invalidInput = true;
				input.nextLine();
			}
		}while(invalidInput);

		
		//Input information for n banks-------------------------------------------------
		
		Bank[] bank = new Bank[n];
		
		for(int i = 0; i < n; i++){
			
			bank[i] = new Bank();
			bank[i].setId(i);
			
			do{
				invalidInput = false;
				try{
				System.out.print("Bank # " + i + " Balance: ");
				bank[i].setBalance(input.nextDouble());
				
				System.out.print("Number of banks Loaned: ");
				bank[i].setLoaned(input.nextInt());
				
				for(int j = 0; j < bank[i].getLoaned(); j++){
					
					do{
						System.out.print("Bank ID: ");
						id = input.nextInt();
					}while(bank[i].getId() == id || id > n - 1);
					
					System.out.print("Amount: ");
					amount = input.nextDouble();
					
					bank[i].setAmount(id, amount);
					
					bank[i].setUnsafe(false);
				}
				
				}catch(InputMismatchException e){
					System.out.println("Invalid Input ");
					invalidInput = true;
					input.nextLine();
				}
			}while(invalidInput);
		}

		
		//Check which banks are unsafe--------------------------------------
		for(int i = 0; i < n; i++){
				
			assets = bank[i].getBalance();
				
			Set<Integer> keys = bank[i].getAmount().keySet();
				
			for(Integer key: keys){
					
				if(bank[key].getUnsafe() == false){
					assets += bank[i].getAmount().get(key);
				}
		    }
				
			if(assets < limit && bank[i].getUnsafe() == false){
				bank[i].setUnsafe(true);
				System.out.println("Bank " + bank[i].getId() + " is unsafe.");
				i = 0;
			}
	
		}
						
		input.close();
	}

}
