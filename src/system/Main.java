package system;
import exception.*;


public class Main extends Object{

	public static void main(String[] args) {
		 //TODO Auto-generated method stub
		
		try{
			UserInterface main_UI = new UserInterface();	
			
		} catch (NoSuchCommandExceptions err){
			
			System.out.println("There is no such command");
		} catch(NoSuchIDExceptions err){
			
			System.out.println("There is no such ID");
		}

	}

}

