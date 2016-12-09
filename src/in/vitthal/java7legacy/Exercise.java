package in.vitthal.java7legacy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Exercise {

	public Exercise() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String [] args) {
		
		List<Person> people = new ArrayList<Person>();
		
		people.add(new Person("Vitthal", "Mirji", 26));
		people.add(new Person("Krishna", "Mirji", 60));
		people.add(new Person("Sandhya", "Mirji", 52));
		people.add(new Person("Gouri", "Mirji", 20));
		people.add(new Person("Pooja", "Shandilya", 23));
		
		
		//Method that print all elements in List
		
		//display(people);
		
		//Sort List by Last Name
		
		//Collections.sort(people);
		//---------OR------------
				
		Collections.sort(people, new Comparator<Person>() {

			@Override
			public int compare(Person person1, Person person2) {
				// TODO Auto-generated method stub
				return person1.getFirstName().compareTo(person2.getFirstName());
			}
			
		});
		
		display(people);
				
		//Method that prints all elements last Name beginning with letter M
		
		displayAfterTest(people, new Test() {
			
			@Override
			public boolean isTrue(Person person) {
				// TODO Auto-generated method stub
				return person.getLastName().startsWith("M");
			}
		});
	}
	
	public static void display(List<Person> people) {
		Iterator<Person> peopleIterator = people.iterator();
		
		while(peopleIterator.hasNext())
			System.out.println(peopleIterator.next());
	}

	public static void displayAfterTest(List<Person> people, Test test) {
		Iterator<Person> peopleIterator = people.iterator();
		
		while(peopleIterator.hasNext()) {
			Person person = peopleIterator.next();
			if(test.isTrue(person))
				System.out.println(person);
		}

	}
	
}

interface Test {
	boolean isTrue(Person person);
}
