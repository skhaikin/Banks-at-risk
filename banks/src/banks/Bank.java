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

public class Bank {

		private int id;
		private double balance;
		private int loaned;	
		Hashtable<Integer, Double> amount = new Hashtable<Integer, Double>();
		private boolean unsafe;
		
		//setters
		public void setId(int id){
			this.id = id;
		}
		
		public void setBalance(double balance){
			this.balance = balance;
		}
		
		public void setLoaned(int loaned){
			this.loaned = loaned;
		}
		
		public void setAmount(int id, double amount){
			this.amount.put(id, amount);
		}
		
		public void setUnsafe(boolean unsafe){
			this.unsafe = unsafe;
		}
		
		//getters
		public int getId(){
			return id;
		}
		
		public double getBalance(){
			return balance;
		}
		
		public int getLoaned(){
			return loaned;
		}
		
		public Hashtable<Integer, Double> getAmount(){
			return amount;
		}

		public boolean getUnsafe(){
			return unsafe;
		}

}
