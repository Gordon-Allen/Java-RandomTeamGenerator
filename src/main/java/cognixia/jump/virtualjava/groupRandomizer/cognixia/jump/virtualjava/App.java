package cognixia.jump.virtualjava.groupRandomizer.cognixia.jump.virtualjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App 
{
    public static void main(String[] args)
    {
    	//To start: Initialize a ArrayList<String> of the names (students, team-mates, etc.), utilziing 'Arrays.asList()', that you would like to randomly separate, create groups, and select Team Leaders for
    	
    	//Matt & Gordon's Class - ArrayList<String> of student names
    	ArrayList<String> students = new ArrayList<String>(Arrays.asList("Adebayo Ajayi", "Anthony Russell" , "Brooks McCament", "Carleton Thompson", "Colette Onenda", "Colt Lehr", "Dakota Purvis", "David Morales", "Gurmat Sandhu", "Haley Howell", "Haripriya Vasireddy", "Humza Sheikh", "Jack Liegey", "Jamie Vue", "Jayde Doetschman", "Kevin Fang", "Krishna Thapa", "Lindsay Prescott", "Malik E.", "Mathias Taylor", "Maurice B.", "Michael Mejia", "Mishal Baig", "Ramon ('Dylan') Aboy", "Robert Pytel", "Santos Tapia", "Tersa Almaw", "Tom Burch", "Vinson Sorenson"));
        
    	//Orquidia & Daniel's Class - ArrayList<String> of student names
//    	ArrayList<String> students = new ArrayList<String>(Arrays.asList("Ainsley McWaters", "Alek Sung", "Ashley Williams", "Bill Knobbe", "Caroline Rives", "Carson Jobe", "Cheick Kane", "D'Andre Guess", "Dante' Taylor", "Darreal Chambers", "Dezmon Hall", "Elliot Blaser", "Elton Wee", "Fatih ", "Gabriella Middleton", "Joetta Hall", "Jun Liang", "Kacper ", "Lori White", "Nahom Zena", "Phoca Sunzu", "Ryan Tan", "Samidh Patel", "Seth Campbell", "Sidiki Camara", "Tara Kelly", "Taylor Rotolo", "Thomas Martinez", "Vinita Ray"));
    	
    	System.out.println( "Welcome to Cognixia JUMP's Group Generator & Randomizer!" );
        System.out.println(" ");
        System.out.println("Here are your newly generated and randomized teams:");
        System.out.println(" ");
        
        //Calling group generate & randomize method, passing 'students' as argument
        randomGroupGenerator(students);
    }
    
    public static List<String> sortGroupAlphabetically(List<String> teamTempStor)
    {
    	//For our class purposes, each group we randomly generate needs to have a Team Leader
    	//To accomplish this, we have initially decided that once each randomized/generated team is fully populated in 'tempTeamStor' by 'randomGroupGenerator(List<String> students)', we want to alphabetically sort in ascending order by the student's first name and the Team Leader will be the first individual 
    	//The Team Leader selection logic will change over time to ensure fair distribution of responsibilities to students, where I will be adding additional helper methods like this one so they can be called upon whenever they are needed depending on how we will to select Team Leader's
    	
    	//We use 'Collections.sort()' to alphabetically sort the given 'teamTempStor' List<String> parameter by First Name, and then return it to the calling method to be utilized as needed
    	Collections.sort(teamTempStor);
    	
    	return teamTempStor;
    }
	
	public static void randomGroupGenerator(List<String> students)
	{
		//Calculating the number of students we have been given to randomize/group together from the given 'students' parameter
		int numStudents =  students.size();
		
		//We start our team group numbering at '1' and increment as each new randomized/generated team is created/completed, this will be used later in my logic
		int teamNum = 1;
		
		//Declaring new ArrayList<String> to temporarily store the randomized/grouped students during calculations
		List<String> teamTempStor = new ArrayList<String>();		
		
		//Here, we start iterating through our student names to group/randomize them
		for (int idx = 0; idx <= numStudents; idx++)
		{
			//We use a 'while' loop here to avoid the 'IndexOutOfBounds' Exception that occurs from us decrementing 'idx' & 'numStudents' in following logic & calculations
			while(numStudents > 0)
			{
				//Generating a random number from 0 to number of elements in 'students' (either with the 'List<String> students' in its entirety that is given at runtime or with the remaining elements with 'students' after calculations)
				//The random int ('randInt') returned will serve as the index of the student we are going to group/randomize next
				int randInt = (int)(numStudents * Math.random());
				
				//Our first conditional "if" check is to see if the student we are currently iterating through is the final name in 'students'
				//By doing this conditional check first, this algo can now dynamically generate random teams no matter if ArrayList 'students' has an even or odd length/size or the specified group size(logic for that below)
				if (numStudents - 1 == 0) 
				{
					//Using '.get()' to retrieve the String value (aka the student's name) of the element @ the index of 'randInt', removing from 'students'
					teamTempStor.add(students.get(randInt));
					students.remove(randInt);
					
					//Calling my sorting helper method to determine Team Leader,
					sortGroupAlphabetically(teamTempStor);
					
					//Utilizing the int variable we initialized earlier ('teamNum') to specific team segmentation/grouping
					System.out.println("   Team " + teamNum);
					System.out.println("<---------->");
					
					//Using a 'forEach' loop to print the students names of the new group to the console
					for (int x = 0; x < teamTempStor.size(); x++)
					{
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
					
					//To ensure our loop or its indexer do not lose track of the changes we've made to 'students', we decrement both 'idx' & 'numStudents' to account for it
					numStudents--;
					idx--;
				}
				
				//For our specific class purposes, we wanted to limit each group to a maximum of (5)
				//Here, if the current teamTempStor < 5: we proceed to add the current selected element in 'students' to 'tempTeamStor'
				else if (teamTempStor.size() < 5)
				{
					//Using '.get()' to retrieve the String value (aka the student's name) of the element @ the index of 'randInt'
					teamTempStor.add(students.get(randInt));
					
					//Once the selected student has been randomized/grouped from initial ArrayList, we remove that student from 'students' to account for their new team placement
					students.remove(randInt);
					
					//To ensure our loop/its indexer and our # of students left to randomize/group do not lose track of the changes we've made to 'students', we decrement both 'idx' & 'numStudents' to account for these changes (the 'for' & 'while' loops will spiral out of control and bounds if you do not do this)
					numStudents--;
					idx--;
				
				}
				//Once 'teamTempStor' reaches (5) total elements/group-members and fails the first 'if' conditional statement, we have completed this team and move to printing out the completed randomized/grouped of (5) students
				else if (teamTempStor.size() == 5)
				{
					sortGroupAlphabetically(teamTempStor);
					//Utilizing the int variable we initialized earlier ('teamNum') to specific team segmentation/grouping
					System.out.println("   Team " + teamNum);
					System.out.println("<---------->");
					
					for (int x = 0; x < teamTempStor.size(); x++)
					{
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
					
					//To ensure our loop or its indexer do not lose track of the changes we've made to 'students', we decrement both 'idx' & 'numStudents' to account for it
					numStudents--;
					idx--;
					
					//Now that we are complete with this group (max (5) members reached), we use '.clear()' to remove all elements from our 'tempTeamStor' and also increment our 'teamNum' to account for the new team being created
					teamTempStor.clear();
					teamNum++;
					
					//Finally, with 'tempTeamStor' empty and ready to be re-used for the next group, we add the randomly selected student as the first element and remove that name from 'students'
					teamTempStor.add(students.get(randInt));
					students.remove(randInt);					
				}				
			}
		}
		System.out.println("Thank you for using Cognixia JUMP's Group Generator & Randomizer!");
		System.out.println("<<< Gordon Allen - 2020 >>>");
	}
}
