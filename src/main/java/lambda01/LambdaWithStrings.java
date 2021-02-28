package lambda01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaWithStrings {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
        list.add("Ali");
        list.add("Mark");
        list.add("Jackson");
        list.add("Amanda");
        list.add("Mariano");
        list.add("Alberto");
        list.add("Tucker");
        list.add("Christ");
        
        System.out.println(checkLastChar(list));

	}

	/*
	Use "Functional Programming"
	1)Create a method to remove the list elements whose lengths are less than 5. 
	*/
	//1st Way: By using Lambda Expression
	public static List<String> getEl1(List<String> list){
		list.removeIf(t->t.length()>5);
		return list;		
	}
	
	/*
	Use "Functional Programming"
	2)Create a method to remove the list elements which are starting with 'A' OR ending with 'N'. 
	*/
	//1st Way: By using Lambda Expression
	public static List<String> getEl2(List<String> list){
		list.removeIf(t->t.startsWith("A") || t.endsWith("n"));
		return list;		
	}
	
	/*
	Use "Functional Programming"
	3)Create a method to print the elements in uppercases after ordering according to their lengths 
	*/
	//1st Way: By using Lambda Expression
	public static void sortLengthEl(List<String> list){
        list.stream().map(t->t.toUpperCase()).sorted(Comparator.comparing(t->t.length())).forEach(System.out::println);
    }
	
	/*
	Use "Functional Programming"
	4)Create a method to print the elements in lowercases after ordering according to their last characters 
	*/
	//1st Way: By using Lambda Expression
	public static void sortLastChar(List<String> list){
        list.stream().map(t->t.toLowerCase()).sorted(Comparator.comparing(t->t.substring(t.length()-1))).forEach(System.out::println);
    }
	
	/*
	Use "Functional Programming"
	5)Create a method to print the length of every element in the following format.
	  Sort by length.
	  Ali: 3        Mark: 4       Amanda: 6     etc.
	*/
	//1st Way: By using Lambda Expression
	public static void getCharAndLength(List<String> list){
        list.stream().sorted(Comparator.comparing(t->t.length())).map(t->t + ": " + t.length()).forEach(System.out::println);
    }
	
	/*
	Use "Functional Programming"
	6)Create a method to check if the lengths of all elements are less than 8
	*/
	//1st Way: By using Lambda Expression
	public static boolean checkLength(List<String> list){
        return list.stream().allMatch(t->t.length()<8);
    }
	
	/*
	Use "Functional Programming"
	7)Create a method to check if the initials of any element are not X
	*/
	//1st Way: By using Lambda Expression
	public static boolean checkInitials(List<String> list){
        return list.stream().noneMatch(t->t.startsWith("X"));
    }
	
	/*
	Use "Functional Programming"
	7)Create a method to check if at least one element ending with "r"
	*/
	//1st Way: By using Lambda Expression
	public static boolean checkLastChar(List<String> list){
        return list.stream().anyMatch(t->t.endsWith("r"));
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
