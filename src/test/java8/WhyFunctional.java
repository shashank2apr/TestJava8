package test.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class WhyFunctional {

   public static void main(String args[]){
      
	  List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		      
      System.out.println("Print EVEN NUMBERS:");
      evalEvenWithoutPred(list);
      
     // eval(list, n -> n%2 == 0);
    
     /* eval(list, new Predicate<Integer>() {

		@Override
		public boolean test(Integer n) {
			
			return n%2==0;
		}
	});*/
      
      System.out.println("Print ODD NUMBERS:");
      evalOddWithoutPred(list);
     
   eval(list, n-> n%2 != 0 );
		
      System.out.println("Print numbers MULTIPLE 0f 5");
      evalMultiple5WithoutPred(list);
      
    //  eval(list, n-> n%5 == 0 );*/
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