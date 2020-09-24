package quicksort;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

import model.Person;
import util.ShowProcess;

public class QuickSortProcess {

	private static ArrayList<Person> sortedpersonList = new ArrayList<>();

	public static void byId(ArrayList<Person> personList) {

		// Convert ArrayList to Array
		Person[] persons = personList.toArray(new Person[personList.size()]);

		Comparator<Person> compTr = new Comparator<Person>() {
			@Override
			public int compare(Person p0, Person p1) {
				return Long.compare(p0.getId(), p1.getId());
			}
		};

		Person[] sortedpersons = quickSort(persons, compTr);

		sortedpersonList = new ArrayList<>(Arrays.asList(sortedpersons));

		ShowProcess.showValues(sortedpersonList);

	}

	public static void byLastName(ArrayList<Person> personList) {

		// Convert ArrayList to Array
		Person[] persons = personList.toArray(new Person[personList.size()]);

		Comparator<Person> compTr = new Comparator<Person>() {
			@Override
			public int compare(Person p0, Person p1) {
				Collator collator = Collator.getInstance(new Locale("tr", "TR"));
				return collator.compare(p0.getLastname(), p1.getLastname());
			}
		};

		Person[] sortedpersons = quickSort(persons, compTr);

		sortedpersonList = new ArrayList<>(Arrays.asList(sortedpersons));

		ShowProcess.showValues(sortedpersonList);
	}

	public static void byName(ArrayList<Person> personList) {
		
		// Convert ArrayList to Array
		Person[] persons = personList.toArray(new Person[personList.size()]);

		Comparator<Person> compTr = new Comparator<Person>() {
			@Override
			public int compare(Person p0, Person p1) {
				Collator collator = Collator.getInstance(new Locale("tr", "TR"));
				return collator.compare(p0.getName(), p1.getName());
			}
		};

		Person[] sortedpersons = quickSort(persons, compTr);

		sortedpersonList = new ArrayList<>(Arrays.asList(sortedpersons));

		ShowProcess.showValues(sortedpersonList);
	}

	public static void byAge(ArrayList<Person> personList) {

		// Convert ArrayList to Array
		Person[] persons = personList.toArray(new Person[personList.size()]);

		Comparator<Person> compTr = new Comparator<Person>() {
			@Override
			public int compare(Person p0, Person p1) {
				return Integer.compare(p0.getAge(), p1.getAge());
			}
		};

		Person[] sortedpersons = quickSort(persons, compTr);

		sortedpersonList = new ArrayList<>(Arrays.asList(sortedpersons));

		ShowProcess.showValues(sortedpersonList);
	}
	
	
	public static void byRegisterDate(ArrayList<Person> personList) {

		Comparator<Person> compTr = new Comparator<Person>() {
			@Override
			public int compare(Person p0, Person p1) {
				if(p0.getRegisterDate().before(p1.getRegisterDate())){
					return -1;
				}else if(p0.getRegisterDate().after(p1.getRegisterDate())) {
					return 1;
				}else {
					return 0;
				}
			}
		};
		
		
		// Convert ArrayList to Array
		Person[] persons = personList.toArray(new Person[personList.size()]);

	
		Person[] sortedpersons = quickSort(persons, compTr);

		sortedpersonList = new ArrayList<>(Arrays.asList(sortedpersons));

		ShowProcess.showValues(sortedpersonList);
	}
	
	public static Person[] quickSort(Person a[], Comparator comp) {
		return quickSort(a, 0, a.length - 1 , comp);
	}

	private static Person[] quickSort(Person[] array,int lowerIndex, int higherIndex, Comparator comp) {
               
        int ll = lowerIndex;
        int rr = higherIndex;

        if (rr>ll){
        	
        	// calculate pivot number, I am taking pivot as middle index number
            Person pivot = array[lowerIndex + (higherIndex-lowerIndex)/2];
            
            while (ll <=rr){
                while(ll< higherIndex && lessThan(comp, array[ll], pivot)){
                    ll +=1;
                }
                while(rr> lowerIndex && greaterThan(comp, array[rr], pivot)){
                    rr -=1;
                }
                if (ll <=rr){
                	exchangeNumbers(array, ll, rr, comp);
                    ll +=1;
                    rr -=1;
                }
            }
            if (lowerIndex < rr){
                quickSort(array,lowerIndex, rr,comp);

            }
            if (ll< higherIndex){
                quickSort(array,ll, higherIndex,comp);
            }
        }
        return array;
    }
 
    private static void exchangeNumbers(Person[] array, int i, int j, Comparator comp) {
        Person temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
	

	// ASC
	private static boolean greaterThan(Comparator comp, Person x, Person y) {
		return comp.compare(x, y) > 0;
	}

	// DESC
	private static boolean lessThan(Comparator comp, Person x, Person y) {
		return comp.compare(x, y) < 0;
	}

}
