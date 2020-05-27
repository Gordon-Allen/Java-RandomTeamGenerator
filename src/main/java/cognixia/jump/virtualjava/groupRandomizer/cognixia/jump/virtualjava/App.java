package cognixia.jump.virtualjava.groupRandomizer.cognixia.jump.virtualjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App 
{
    public static void main(String[] args)
    {
    	//Main ArrayList of names (students, team-mates, etc.)
    	ArrayList<String> students = new ArrayList<String>(Arrays.asList("Adebayo Ajayi", "Anthony Russell" , "Brooks McCament", "Carleton Thompson", "Colette Onenda", "Colt Lehr", "Dakota Purvis", "David Morales", "Dezmon Hall", "Gurmat Sandhu", "Haley Howell", "Haripriya Vasireddy", "Humza Sheikh", "Jack Liegey", "Jamie Vue", "Jayde Doetschman", "Kevin Fang", "Krishna Thapa",  "Kahan Raval", "Lindsay Prescott", "Malik E.", "Mathias Taylor", "Maurice B.", "Michael Mejia", "Mishal Baig", "Ramon Aboy", "Robert Pytel", "Santos Tapia", "Tersa Almaw", "Tom Burch", "Vinson Sorenson"));
        
    	System.out.println( "Welcome to Cognixia JUMP's Group Generator & Randomizer!" );
        System.out.println(" ");
        System.out.println("Here are your newly generated and randomized teams:");
        System.out.println(" ");
        
        //Calling group generate & randomize method, passing 'students' as argument
        groupRandomizeGenerator(students);
    }
	
	public static void groupRandomizeGenerator(List<String> students)
	{
		//Calculating the number of students we have been given to randomize/group together from the given 'students' parameter
		int numStudents =  students.size();
		
		// We start our team group numbering at one, this will be used later in my logic
		int teamNum = 1;
		
		//Declaring new ArrayList to temporarily store the randomized/grouped students during calculations
		List<String> teamTempStor = new ArrayList<String>();		
		
		// Here, we start iterating through our names to group/randomize them
		for (int idx = 0; idx <= numStudents; idx++)
		{
			//We use a 'while' loop here to avoid 'IndexOutOfBounds' Exception that comes from us decrementing 'idx' & 'numStudents' in following logic & calculations
			while(numStudents > 0)
			{
				//Generating a random number from 0 to number of elements in 'students' (either with initial provided ArrayList at runtime or remaining after calculations)
				//The random int ('randInt') returned will serve as the index of the student we are going to group/randomize next
				int randInt = (int)(numStudents * Math.random());
				
				//For our purposes, we wanted to limit each group to a maximum of (5)
				//Here, if the current teamTempStor < 5: we proceed to add the current selected element in 'students'
				if (teamTempStor.size() < 5)
				{
					//Using '.get()' to retrieve the String value (aka the name) of the student at 'randInt'
					teamTempStor.add(students.get(randInt));
					
					//Once the student has been randomized/grouped from initial ArrayList, we remove that student from 'students'
					students.remove(randInt);
					
					//To ensure our loop and its indexer do not lose track of the changes we've made to 'students', we decrement both 'idx' & 'numStudents' to account for it
					numStudents--;
					idx--;
				
				}
				// Once 'teamTempStor' reaches (5) total elements/group-members, we move to printing out the completed randomized/grouped of (5) students
				else if (teamTempStor.size() == 5)
				{
					//Utilizing the int variable we initialized earlier ('teamNum') to specific team segmentation/grouping
					System.out.println("   Team " + teamNum);
					System.out.println("<---------->");
					
					//Using a 'forEach' loop to print the (5) students names of the new group to the console
					for (String stu: teamTempStor)
					{
						System.out.println(stu);
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
