package main;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import model.Person;
import quicksort.QuickSortProcess;
import util.DefineValues;
import util.ShowProcess;

public class Main {

	private static ArrayList<Person> personList = new ArrayList<>();
	
	public static void main(String[] args) throws ParseException {
		
		
		personList = DefineValues.defineValues(personList);
		
		
		System.out.println("---------------------------------");
		System.out.println("BEFORE QUICK SORT byId");
		ShowProcess.showValues(personList);	
		

		System.out.println("AFTER QUICK SORT byId");
		QuickSortProcess.byId(personList);	
		System.out.println("---------------------------------\n");
		
		System.out.println("BEFORE QUICK SORT byLastName");		
		ShowProcess.showValues(personList);				
		
		System.out.println("AFTER QUICK SORT byLastName");
		QuickSortProcess.byLastName(personList);	
		System.out.println("---------------------------------\n");
		
		System.out.println("BEFORE QUICK SORT byName");
		ShowProcess.showValues(personList);

		System.out.println("AFTER QUICK SORT byName");
		QuickSortProcess.byName(personList);
		System.out.println("---------------------------------\n");
		
		System.out.println("BEFORE QUICK SORT byAge");		
		ShowProcess.showValues(personList);

		System.out.println("AFTER QUICK SORT byAge");
		QuickSortProcess.byAge(personList);
		System.out.println("---------------------------------");
		
		System.out.println("BEFORE QUICK SORT byRegisterDate");		
		ShowProcess.showValues(personList);
		
		System.out.println("AFTER QUICK SORT byRegisterDate");
		QuickSortProcess.byRegisterDate(personList);
		System.out.println("---------------------------------");
	}
}
