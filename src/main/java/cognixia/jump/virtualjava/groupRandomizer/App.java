package cognixia.jump.virtualjava.groupRandomizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class App 
{
    public static void main(String[] args)
    {
    	//TO START: Initialize a ArrayList<String> as in the examples below of the names (students, team-mates, etc.) you wish to generate teams from    	    	
    	
    	Scanner sc = new Scanner(System.in);
    	boolean isSystemOn = true;
    	  	
    	while (isSystemOn)
    	{
    		System.out.println( "Welcome to Cognixia JUMP's Class Generator App!" );
            System.out.println(" ");
            System.out.println("Which class would you like generate lists/groups for?:");
            System.out.println("1) Matt's & Gordon's Class");
            System.out.println("2) Orquidia's & Daniel's Class");
            System.out.println(" ");
            System.out.println("3) EXIT App");
            
            int classChoiceUserInput = sc.nextInt();
            
            if (classChoiceUserInput == 1)
            {
            	ArrayList<String> students = new ArrayList<String>(Arrays.asList("Adebayo Ajayi", "Anthony Russell" , "Anthony Shahid" ,"Brooks McCament", "Calvin Houser", "Carleton Thompson", "Colette Onenda", "Colt Lehr", "Dakota Purvis", "David Morales", "Gurmat Sandhu", "Haley Howell", "Haripriya Vasireddy", "Humza Sheikh", "Jack Liegey", "Jamie Vue", "Jayde Doetschman", "Kevin Fang", "Krishna Thapa", "Lindsay Prescott", "Malik East", "Mathias Taylor", "Michael Mejia", "Mishal Baig", "Ramon ('Dylan') Aboy", "Robert Pytel", "Santos Tapia", "Tersa Almaw", "Tom Burch", "Vinson Sorenson"));
            	
            	System.out.println("CLASS SELECTED: Matt's & Gordon's");
            	System.out.println(" ");
            	System.out.println("Which would you like generate?:");
            	System.out.println("1) Random Student List Generator");
            	System.out.println("2) Random Group/Team Leader Generator");
            	
            	int generatorChoiceUserInput = sc.nextInt();
            	
            	if (generatorChoiceUserInput == 1)
            	{
            		randomStudentListGenerator(students);
            	}
            	else if (generatorChoiceUserInput == 2)
            	{
            		randomGroupGenerator(students);
            	}
            	else
            	{
            		System.out.println("Whoops.......that wasn't '1' or '2'......hmmmm, try again ");
            	}
            }
            else if (classChoiceUserInput == 2)
            {
            	ArrayList<String> students = new ArrayList<String>(Arrays.asList("Ainsley McWaters", "Alek Sung", "Ashley Williams", "Bill Knobbe", "Caroline Rives", "Carson Jobe", "Cheick Kane", "D'Andre Guess", "Dante' Taylor", "Darreal Chambers", "Dezmon Hall", "Elliot Blaser", "Elton Wee", "Fatih ", "Gabriella Middleton", "Joetta Hall", "Jun Liang", "Kacper ", "Lori White", "Nahom Zena", "Phoca Sunzu", "Ryan Tan", "Samidh Patel", "Seth Campbell", "Sidiki Camara", "Tara Kelly", "Taylor Rotolo", "Thomas Martinez", "Vinita Ray"));
            	System.out.println("CLASS SELECTED: Orquidia's & Daniel's");
            	System.out.println(" ");
            	System.out.println("Which would you like generate?:");
            	System.out.println("1) Random Student List Generator");
            	System.out.println("2) Random Group/Team Leader Generator");
            	
            	int generatorChoiceUserInput = sc.nextInt();
            	
            	if (generatorChoiceUserInput == 1)
            	{
            		randomStudentListGenerator(students);
            	}
            	else if (generatorChoiceUserInput == 2)
            	{
            		randomGroupGenerator(students);
            	}
            	else
            	{
            		System.out.println("Whoops.......that wasn't '1' or '2'......hmmmm, try again ");
            	}
            }
            else if (classChoiceUserInput == 3)
            {
            	isSystemOn = false;
            }
            else
            {
            	System.out.println("Whoops.......that wasn't '1' or '2'......hmmmm, try again ");
            }
    	}
    	System.out.println("Thank you for using Cognixia JUMP's Class Group Generator!");
		System.out.println("<<< Gordon Allen - 2020 >>>");
    }
    
    public static void generatedTeamConsolePrinter(List<String> teamTempStor, int teamNum)
    {
    	System.out.println( "Welcome to Cognixia JUMP's Class Group Generator!" );
        System.out.println(" ");
        System.out.println("Here are your newly generated and randomized teams:");
        System.out.println(" ");
    	
    	//Utilizing int parameter "teamNum" to specific team segmentation and grouping
    	System.out.println("   Team " + teamNum);
		System.out.println("<---------->");
		
		//'FOR' loop to print Team Leader first then Team Members to console
		for (int x = 0; x < teamTempStor.size(); x++)
		{
			//'IF' indexer == 0, this element is group's 'Team Leader'
			if (x == 0)
			{
				System.out.println("Team Leader: " + teamTempStor.get(x));
				x++;
				System.out.println(" ");
				System.out.println("Team Members: ");
				System.out.println(" ");
			}
			System.out.println(teamTempStor.get(x));
		}
		System.out.println("<---------->");
		System.out.println(" ");
    }
    
    public static List<String> randomGroupSortSelectTL(List<String> teamTempStor)
    {
    	//Alphabetically sorting given 'teamTempStor' parameter by First Name
    	Collections.sort(teamTempStor);
    	
    	//Generating a random int from 0 to the number of elements in 'teamTempStor' parameter
    	int randIdx = (int)(teamTempStor.size() * Math.random());
    	
    	//Using 'randInt' to randomly select Team Leader and storing the student's name at that index in 'teamLead'
    	String teamLead = teamTempStor.get(randIdx);
    	
    	//Setting student's name at index 0 to the index of 'randInt'
    	teamTempStor.set(randIdx, teamTempStor.get(0));
    	
    	//Setting 'teamLead' name as first element in returned 'teamTempStor' for proper console printing
    	teamTempStor.set(0, teamLead);
    	return teamTempStor;
    }
    
    public static void randomStudentListGenerator(List<String> students)
	{ 		
    	//Calculating the number of students we have been given to generate a randomly ordered list of
    	int numStudents =  students.size();
    	
    	//Starting student int 'count' at 1
    	int count = 1;
    	
    	while (numStudents > 0) {
    		//Generating random int from 0 to the number of elements present in 'students'
    		//'randInt' == the index of the student we are going to randomly select and group next
    		int randInt = (int)(numStudents * Math.random());
    		    		
    		//Using 'randint' to randomly select student from 'students' by index
    		String randStudent = students.get(randInt);
    		
    		System.out.println("Randomly Selected Student " + count + ": " + randStudent);    		
    		
    		//Removing randomly selected and printed student name from 'students'
    		students.remove(randInt);
    		
    		//Incrementing 'count' & decrementing 'numStudents' to account for our ccalculations
    		count++;
    		numStudents--;
    	}
	}	
	
	public static void randomGroupGenerator(List<String> students)
	{
		//Calculating the number of students we have been given to randomize/group together
		int numStudents =  students.size();
		
		//Starting team group numbering at '1', will increment as each new random generated team is completed
		int teamNum = 1;
		
		//Declaring new ArrayList<String> to temporarily store the randomized/grouped students during iterations and calculations
		List<String> teamTempStor = new ArrayList<String>();		
		
		//Here, starting to iterate through our names to randomize and group together from given List<String> 'students' parameter 
		for (int idx = 0; idx <= numStudents; idx++)
		{
			//'WHILE' loop implementation avoids 'IndexOutOfBounds' Exception that occurs from us decrementing 'idx' & 'numStudents' in calculations
			while(numStudents > 0)
			{
				//Generating random int from 0 to the number of elements present in 'students'
				//'randInt' == the index of the student we are going to randomly select and group next
				int randInt = (int)(numStudents * Math.random());
				
				//Checking to see if the student we are currently iterating through is the final name in 'students'
				//This allows dynamically generation of teams no matter the user's choice of generated group size or if the provided class/group size is even/odd
				if (numStudents - 1 == 0) 
				{
					//Retrieving the name of the student element at the index of 'randInt'
					//Then, removing that name from 'students'
					teamTempStor.add(students.get(randInt));
					students.remove(randInt);
										
					//Calling helper method to sort group and randomly select Team Leader 
					randomGroupSortSelectTL(teamTempStor);
					
					//* Calling helper method to print randomly generated Team Leader/Team to console *
					generatedTeamConsolePrinter(teamTempStor, teamNum);										
									
					//Decrementing both 'numStudents' & 'idk' to account for the student name that we removed from 'students'
					numStudents--;
					idx--;
				}
				
				//* RANDOMLY GENERATED GROUP SIZE // USER SPECIFICATION *
				//Here, the user may specify their desired group size: we have selected (5) 
				//We add the current randomly selected element in 'students' to 'tempTeamStor'
				else if (teamTempStor.size() < 5)
				{
					teamTempStor.add(students.get(randInt));
					
					//We then remove the name from 'students', to account for the student's new team placement
					students.remove(randInt);
					numStudents--;
					idx--;
				}
				//Once 'teamTempStor' reaches (5) total elements/group-members, we move to team printing out the completed randomized team of students
				else if (teamTempStor.size() == 5)
				{
					randomGroupSortSelectTL(teamTempStor);
					generatedTeamConsolePrinter(teamTempStor, teamNum);
					numStudents--;
					idx--;
					
					//With this team's random grouping and printing complete, we use '.clear()' to remove all elements from our 'tempTeamStor'
					//We increment our 'teamNum' to account for the new team that is about to be created
					teamTempStor.clear();
					teamNum++;
					
					// We then add the current randomly selected student as the first member of the next team, while removing that student name from 'students'
					teamTempStor.add(students.get(randInt));
					students.remove(randInt);					
				}				
			}
		}
//		System.out.println("Thank you for using Cognixia JUMP's Class Group Generator!");
//		System.out.println("<<< Gordon Allen - 2020 >>>");
	}
}
