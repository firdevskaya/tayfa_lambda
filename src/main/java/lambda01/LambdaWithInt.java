package lambda01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LambdaWithInt {
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
	    list.add(12);
	    list.add(9);
	    list.add(13);
	    list.add(4);
	    list.add(9);
	    list.add(2);
	    list.add(4);
	    list.add(12);
	    list.add(15);

	    System.out.println(getOddSquaresRevSorted(list));

	}

	/*
	1)Use "Structured Programming"
	  Create a method to print the even list elements on the console in the same line 
	  with a space between two consecutive elements. 
	*/
	
	
	
	/*
	Use "Functional Programming"
	Create a method to print the even list elements on the console in the same line 
	with a space between two consecutive elements. 
	*/
	
	//1st Way: By using lambda expression
	public static void printEvenListElFunctional1(List<Integer> list){
	    list.stream().filter(t->t%2==0).forEach(t-> System.out.print(t + " "));
	}
	
	//2nd Way: By using Method Reference, use Java methods
	public static void printEvenListElFunctional2(List<Integer> list){
	    list.stream().filter(t->t%2==0).forEach(System.out::print);
	}
	
	//3rd Way: By using Method Reference, use your own methods
	public static void printEvenListElFunctional3(List<Integer> list){
	    list.stream().filter(t->t%2==0).forEach(LambdaWithInt::getPrint);
	}
	public static void getPrint(int a){
        System.out.print(a + " ");
    }

	/*
	 Use "Functional Programming"
	 2)Create a method to print the squares of every odd element on the console in the same line with a space between two consecutive elements. 
	*/

	//1st Way: By using lambda expression
	public static void getSquare1(List<Integer> list){
        list.stream().filter(t->t%2!=0).map(t->t*t).forEach(t-> System.out.print(t + " "));
    }

	//2nd Way: By using Method Reference, use your own methods
	public static void getSquare2(List<Integer> list){
        list.stream().filter(LambdaWithInt::getOdds).map(LambdaWithInt::getSquare).forEach(LambdaWithInt::getPrint);
    }
	
	public static boolean getOdds(int a){
		if(a%2!=0) {
			return true;
		}else {
			return false;
		}
    }	
	public static int getSquare(int a){
       return a*a;
    }
	
	/*
	 Use "Functional Programming"
	 3)Create a method to find the sum of the square of all add elements in the given list
	*/
	//1st Way: By using lambda expression
	public static int sumOfOdds1(List<Integer> list){
        return list.stream().filter(LambdaWithInt::getOdds).map(LambdaWithInt::getSquare).reduce(0, (x,y)->x+y);
    }

	//2nd Way: By using Method Reference, use Java methods in reduce()
	//Note: The purpose of the "Optional Class" is to provide a type-level solution for representing optional values instead of null references.
	public static Optional<Integer> sumOfOdds2(List<Integer> list){
        return list.stream().filter(LambdaWithInt::getOdds).map(LambdaWithInt::getSquare).reduce(Integer::sum);
    }	
	public static Optional<Integer> sumOfOdds3(List<Integer> list){
        return list.stream().filter(LambdaWithInt::getOdds).map(LambdaWithInt::getSquare).reduce(Math::addExact);
    }
	
	//3rd Way: By using Method Reference, use your own methods
	public static Optional<Integer> sumOfOdds4(List<Integer> list){
        return list.stream().filter(LambdaWithInt::getOdds).map(LambdaWithInt::getSquare).reduce(LambdaWithInt::getSum);
    }
	public static int getSum(int a, int b){
	       return a+b;
	    }
	
	/*
	 Use "Functional Programming"
	 4)Create a method to find the maximum value from the list
	*/
	//1st Way: By using lambda expression
	public static Optional<Integer> maxEl1(List<Integer> list){
        return list.stream().reduce((x,y)->x>y ? x : y);
    }
	//2nd Way: By using Method Reference, use Java methods in reduce()
	public static Optional<Integer> maxEl2(List<Integer> list){
        return list.stream().reduce(Integer::max);
    }
	public static Optional<Integer> maxEl3(List<Integer> list){
        return list.stream().reduce(Math::max);
    }
	//3rd Way: By using Method Reference, use your own methods
	public static Optional<Integer> maxEl4(List<Integer> list){
        return list.stream().reduce(LambdaWithInt::getMax);
    }
	public static int getMax(int x, int y){
        return x>y ? x : y;
    }
	
	/*
	 Use "Functional Programming"
	 5)Create a method to find the maximum value by using sort()
	*/
	//1st Way: By using lambda expression
	public static Optional<Integer> maxEl5(List<Integer> list){
       return list.stream().sorted().reduce((x,y)->y);
   }
	
	/*
	 Use "Functional Programming"
	 6)Create a method to find the minimum value by using sort()
	*/
	//1st Way: By using lambda expression
	public static Optional<Integer> maxEl6(List<Integer> list){
      return list.stream().sorted().reduce((x,y)->x);
  }
	
	/*
	 Use "Functional Programming"
	 7)Create a method to print the squares of even list elements in natural order. 
	   Print the repeated elements just once.
	*/
	//1st Way: By using Method Reference
	public static List<Integer> getOddSquaresSorted(List<Integer> list){
        return list.stream().filter(LambdaWithInt::getOdds).distinct().map(LambdaWithInt::getSquare).sorted().collect(Collectors.toList());
    }
	
	/*
	 Use "Functional Programming"
	 8)Create a method to print the squares of even list elements in reverse order. 
	   Print the repeated elements just once.
	*/
	//1st Way: By using Method Reference
	public static List<Integer> getOddSquaresRevSorted(List<Integer> list){
       return list.stream().filter(LambdaWithInt::getOdds).distinct().map(LambdaWithInt::getSquare).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
   }

}
