package test.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class WhyFunctional {

   public static void main(String args[]){
      
	  List<Integer> list = Arrays.asList(1,4, 4, 3, 2, 5, 6, 7, 8, 9);
		      
      System.out.println("Print EVEN NUMBERS:");
      evalEvenWithoutPred(list);
      
      useSortedAndDistinct(list);
     // eval(list, n -> n%2 == 0);
    
     /* eval(list, new Predicate<Integer>() {

		@Override
		public boolean test(Integer n) {
			
			return n%2==0;
		}
	});*/
      
      System.out.println("Print ODD NUMBERS:");
     // evalOddWithoutPred(list);
     
      //eval(list, n-> n%2 != 0 );
		
      System.out.println("Print numbers MULTIPLE 0f 5");
      //evalMultiple5WithoutPred(list);
      
    //  eval(list, n-> n%5 == 0 );*/
   }


/**
 * @param list
 */
private static void useSortedAndDistinct(List<Integer> list) {
	System.out.println(
    		  list
    		  .stream()
    		  .sorted()
    		  .distinct()
    		  .filter(n->n%2==0)
    		  .collect(Collectors.toList())
    		  );
}
	
   
   public static void evalEvenWithoutPred(List<Integer> list) {
	   
	   for(Integer n: list) {
			
	         if(n%2==0) {
	            System.out.println(n + " ");
	         }
	      }
	   }
   
   public static void evalOddWithoutPred(List<Integer> list) {
	      for(Integer n: list) {
			
	         if(n%2!=0) {
	            System.out.println(n + " ");
	         }
	      }
	   }
   public static void evalMultiple5WithoutPred(List<Integer> list) {
	      for(Integer n: list) {
			
	         if(n%5==0) {
	            System.out.println(n + " ");
	         }
	      }
	   }

   public static void eval(List<Integer> list, Predicate<Integer> predicate) {
      for(Integer n: list) {
		
         if(predicate.test(n)) {
            System.out.println(n + " ");
         }
      }
   }
}