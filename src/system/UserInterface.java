package system;

import exception.*;
import java.util.Scanner;

public class UserInterface {
	
	static Scanner userinput = new Scanner(System.in);
	
	public GradeSystem GS;
	
	public String user;
	
	public boolean checkID(String ID) {
		
		if(GS.containsID(ID)) {
			
			System.out.println("Welcome "+ID);
			return true;
		}
		
		return false;
		
	}
	
	public boolean promptCommand(){
		
		
		while(true) {
			
			boolean exit = false; 
			
			if(userinput.hasNextLine()) {
				
				String cmd = userinput.nextLine();
				
				switch(cmd.toLowerCase()) {
				
					case "g": 
				
						GS.showGrade(user);					
						break;
					
					case "r":
						
						GS.showRank(user);
						break;
						
					case "a":
						
						GS.showAverage(user);
						break;
	
					case "w":
						
						GS.updateWeight();
						break;
						
					case "e":
						
						exit = true;
						break;
						
					default:
						
						return false;
						
					}
				}
			
			if(exit) return true;
			
			}
		
	}
	
	public boolean promptID(){
		
		System.out.println("請輸入ID或輸入Q結束:");
		
		if(userinput.hasNextLine()){
			//System.out.println(userinput.nextLine());
			String ID = userinput.nextLine();
			
			if(ID.toLowerCase().equals("q")){
				
				System.out.println("你已離開系統");
				return false;
				
			} else	{
				
				user = ID;
				return true;
			}

		}
		return false;
		
		

		
	}
	
	public void showFinishMsg() {
		
	}
	
	public UserInterface() throws NoSuchIDExceptions, NoSuchCommandExceptions{
		
		GS = new GradeSystem();
		
		while(true) {
			
			if(this.promptID()) {
				
				if(!this.checkID(user)) throw new NoSuchIDExceptions();
				if(!this.promptCommand()) throw new NoSuchCommandExceptions();
				
			} else  break;
			
		}
		
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
