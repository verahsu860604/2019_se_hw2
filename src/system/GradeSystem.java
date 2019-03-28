package system;

import java.util.Scanner;
import exception.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class GradeSystem {
	
	public float[] weight = {0.1f, 0.1f, 0.1f, 0.3f, 0.4f};
	
	public LinkedList<Grades> gradeList = new LinkedList<Grades>();

	public boolean containsID(String ID) {
		
		for(Grades el:gradeList){
			
			if(el.ID.equals(ID)){
				return true;
			} 
			
		}
		
		return false;
		
	}
	
	public int showAverage(String ID) {
		
		for(Grades el:gradeList){
				
			if(el.ID.equals(ID)){
				
				System.out.println("Average: "+el.totalGrade);
				break;
			} 
		}
		
		return -1;
		
	}
	
	
	public void showGrade(String ID) {
		
		for(Grades el:gradeList){
        	
        	if(el.ID.equals(ID)){
        	
        		System.out.println(el.name);
        		System.out.println(el.lab1);
        		System.out.println(el.lab2);
        		System.out.println(el.lab3);
        		System.out.println(el.midTerm);
        		System.out.println(el.finalExam);
        		System.out.println(el.totalGrade);
        		break;
        		
        	}
			
        }
		
	}
	
	public void showRank(String ID){
		
		for(Grades el : gradeList){
			if(el.ID.equals(ID)){
				
				System.out.println("Rank: "+ gradeList.indexOf(el));
				break;
			}
		}
	}
	
	public void updateWeight() {
		
			System.out.println("舊配分");
			System.out.println("Lab1: " + this.weight[0]);
			System.out.println("Lab2: " + this.weight[1]);
			System.out.println("Lab3: " + this.weight[2]);
			System.out.println("midTerm: " + this.weight[3]);
			System.out.println("finalExam: " + this.weight[4]);
			
			System.out.println("請輸入新的配分，已空白鍵分開");
			
			Scanner userinput = new Scanner(System.in);
			String str = userinput.nextLine();
			
			String[] arr = str.split(" ");
			
			int[] new_weight = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
			
			if(Arrays.stream(new_weight).sum() != 100){
				
				System.out.println("總合必須為100!");
				return;
			}
			
			if(new_weight.length != 5) {
				
				System.out.println("必須輸入五項！");
				return;
			}
			
			
			System.out.println("請確認新的配分");
			System.out.println("Lab1: " + arr[0]);
			System.out.println("Lab2: " + arr[1]);
			System.out.println("Lab3: " + arr[2]);
			System.out.println("Lab4: " + arr[3]);
			System.out.println("Lab5: " + arr[4]);
			System.out.println("Y/N");
			
			str = userinput.nextLine();
			
			if(str.toLowerCase().equals("y")){
				
				this.weight[0] = ((float)new_weight[0])/100;
				this.weight[1] = ((float)new_weight[1])/100;
				this.weight[2] = ((float)new_weight[2])/100;
				this.weight[3] = ((float)new_weight[3])/100;
				this.weight[4] = ((float)new_weight[4])/100;

			}
			
			return;

	}
	
	public GradeSystem(){
		
		File file = new File("./data/input.txt");
		
		try{
		
			Scanner scanner = new Scanner(file);
			
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                
//                String name;
//                String ID;
//                int lab1;
//                int lab2;
//                int lab3;
//                int midTerm;
//                int finalExam;
                
                String[] arr = line.split(" ");
                
                Grades tmp = new Grades(arr[0], arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), Integer.parseInt(arr[5]), Integer.parseInt(arr[6]));
                
                tmp.calculateTotalGrade(weight);
                
                gradeList.add(tmp);                
             
            }
            
            Collections.sort(gradeList, new Comparator<Grades>() {
            	@Override
            	public int compare(Grades G1, Grades G2) {
            		
            		return G2.totalGrade - G1.totalGrade;
            		
            	}
            	
            });
            
			
		} catch(FileNotFoundException e){
			
			System.out.println("File not found!");
		}
		
	}
	
	
	public static void main(String[] args) {
	
		//GradeSystem tmp = new GradeSystem();
		
	}
}
