package cognixia.jump.virtualjava.groupRandomizer.cognixia.jump.virtualjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App 
{
    public static void main(String[] args)
    {
    	//TO START: Initialize a ArrayList<String> as in the examples below of the names (students, team-mates, etc.) you wish to generate teams from
    	
    	//Matt & Gordon's Class - ArrayList<String> of student names
    	ArrayList<String> students = new ArrayList<String>(Arrays.asList("Adebayo Ajayi", "Anthony Russell" , "Anthony Shahid" ,"Brooks McCament", "Calvin Houser", "Carleton Thompson", "Colette Onenda", "Colt Lehr", "Dakota Purvis", "David Morales", "Gurmat Sandhu", "Haley Howell", "Haripriya Vasireddy", "Humza Sheikh", "Jack Liegey", "Jamie Vue", "Jayde Doetschman", "Kevin Fang", "Krishna Thapa", "Lindsay Prescott", "Malik E.", "Mathias Taylor", "Maurice B.", "Michael Mejia", "Mishal Baig", "Ramon ('Dylan') Aboy", "Robert Pytel", "Santos Tapia", "Tersa Almaw", "Tom Burch", "Vinson Sorenson"));
        
    	//Orquidia & Daniel's Class - ArrayList<String> of student names
//    	ArrayList<String> students = new ArrayList<String>(Arrays.asList("Ainsley McWaters", "Alek Sung", "Ashley Williams", "Bill Knobbe", "Caroline Rives", "Carson Jobe", "Cheick Kane", "D'Andre Guess", "Dante' Taylor", "Darreal Chambers", "Dezmon Hall", "Elliot Blaser", "Elton Wee", "Fatih ", "Gabriella Middleton", "Joetta Hall", "Jun Liang", "Kacper ", "Lori White", "Nahom Zena", "Phoca Sunzu", "Ryan Tan", "Samidh Patel", "Seth Campbell", "Sidiki Camara", "Tara Kelly", "Taylor Rotolo", "Thomas Martinez", "Vinita Ray"));
    	
    	System.out.println( "Welcome to Cognixia JUMP's Class Group Generator!" );
        System.out.println(" ");
        System.out.println("Here are your newly generated and randomized teams:");
        System.out.println(" ");
        
        //Calling primary random group generator method, passing 'students' as our argument
        randomGroupGenerator(students);
    }
    
    public static List<String> sortGroupAlphabetically(List<String> teamTempStor)
    {
    	//Each group that is randomly generated will have a Team Leader
    	
    	//Team Leader Random Selection Method #1:
    	//Using 'Collections.sort()' to alphabetically sort the given 'teamTempStor' parameter by First Name
    	//The Team's Leader will be the first student element in 'teamTempStor' post-sorting
    	Collections.sort(teamTempStor);
    	return teamTempStor;
    }
    
    public static List<String> sortGroupReverseAlphabetically(List<String> teamTempStor)
    {
    	//Team Leader Random Selection Method #2:
    	//Reverse Alphabetical Order by First Name, Team Leader is first element post-sorting
    	Collections.sort(teamTempStor, Collections.reverseOrder());
    	return teamTempStor;
    }
	
	public static void randomGroupGenerator(List<String> students)
	{
		//Calculating the number of students we have been given to randomize/group together
		int numStudents =  students.size();
		
		//We start our team group numbering at '1', will increment as each new randomized/generated team is completed
		int teamNum = 1;
		
		//Declaring new ArrayList<String> to temporarily store the randomized/grouped students during iteration and calculations
		List<String> teamTempStor = new ArrayList<String>();		
		
		//Here, we start iterating through our names to randomize and group together
		for (int idx = 0; idx <= numStudents; idx++)
		{
			//'WHILE' loop implementation avoids 'IndexOutOfBounds' Exception that occurs from us decrementing 'idx' & 'numStudents'
			while(numStudents > 0)
			{
				//Generating a random number from 0 to number of elements in 'students'
				//'randInt' is the index of the student we are going to group next
				int randInt = (int)(numStudents * Math.random());
				
				//Checking to see if the student we are currently iterating through is the final name in 'students' we need to group
				//By doing so, we can dynamically generate teams no matter if initial class/group size is even/odd, or the user's choice of random generated group size
				if (numStudents - 1 == 0) 
				{
					//Using '.get()' to retrieve the name of the student element @ the index of 'randInt'
					//Then, removing that name from 'students'
					teamTempStor.add(students.get(randInt));
					students.remove(randInt);
					
					//Team Leader Selection OPTION #1: Calling sorting helper method to determine Team Leader
//					sortGroupAlphabetically(teamTempStor);
					
					//Team Leader Selection OPTION #2:
					sortGroupReverseAlphabetically(teamTempStor);
					
					System.out.println("   Team " + teamNum);
					System.out.println("<---------->");
					
					//'FOR' loop to print newly generated team and Team Leader to console
					for (int x = 0; x < teamTempStor.size(); x++)
					{
						//'IF' our indexer == 0, this element is group's 'Team Leader'
						if (x == 0)
						{
							System.out.println("Team Leader: " + teamTempStor.get(x));
							x++;
							System.out.println(" ");
							System.out.println("Team Members: ");
						}
						System.out.println(teamTempStor.get(x));
					}
					System.out.println("<---------->");
					System.out.println(" ");
					
					//Decrementing both 'numStudents' & 'idk' to account for the student name that we removed from 'students'
					numStudents--;
					idx--;
				}
				
				//For our specific class purposes, we wanted (on average) groups of (5) members
				//Here, if the current team being generated < 5 members:
				//We add the current randomly selected element in 'students' to 'tempTeamStor'
				else if (teamTempStor.size() < 5)
				{
					teamTempStor.add(students.get(randInt));
					
					//Once the randomly selected student has been grouped from 'students':
					//We remove that name from 'students' to account for the student's new team placement
					students.remove(randInt);
					
					numStudents--;
					idx--;
				}
				//Once 'teamTempStor' reaches (5) total elements/group-members, we move to printing out the completed randomized team of students
				else if (teamTempStor.size() == 5)
				{
					//Team Leader Selection OPTION #1: Calling sorting helper method to determine Team Leader
//					sortGroupAlphabetically(teamTempStor);
					
					//Team Leader Selection OPTION #2
					sortGroupReverseAlphabetically(teamTempStor);
					
					//Utilizing int 'teamNum' to specific team segmentation and grouping
					System.out.println("   Team " + teamNum);
					System.out.println("<---------->");
					
					//'FOR' loop to print newly generated team and its Team Leader to console
					for (int x = 0; x < teamTempStor.size(); x++)
					{
						//'IF' our indexer == 0, this element is the group's 'Team Leader'
						if (x == 0)
						{
							System.out.println("Team Leader: " + teamTempStor.get(x));
							x++;
							System.out.println(" ");
							System.out.println("Team Members: ");
						}
						System.out.println(teamTempStor.get(x));
					}
					System.out.println("<---------->");
					System.out.println(" ");
					
					numStudents--;
					idx--;
					
					//With this team's random grouping and printing complete, we use '.clear()' to remove all elements from our 'tempTeamStor'
					//We then increment our 'teamNum' to account for the new team that is about to be created
					teamTempStor.clear();
					teamNum++;
					
					// We then add the current randomly selected student as the first member of the next team and remove that student name from 'students'
					teamTempStor.add(students.get(randInt));
					students.remove(randInt);					
				}				
			}
		}
		System.out.println("Thank you for using Cognixia JUMP's Class Group Generator!");
		System.out.println("<<< Gordon Allen - 2020 >>>");
	}
}
