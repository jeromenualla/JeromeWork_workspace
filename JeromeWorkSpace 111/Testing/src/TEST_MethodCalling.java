public class TEST_MethodCalling {
   /** Main method */
	
   public static void main(String[] args) {
      int i = 1;
      int j = 1;
      int k = maximo(i, j);
      System.out.println(max());
      
      System.out.println("The maximum between " + i +
                    " and " + j + " is " + k);
   }

   /** Return the max between two numbers */
   public static int maximo(int num1, int num2) {
      int result;
      if (num1 > num2)
         result = num1;
      else
         result = num2;

      return result; 
   }
   
   public static String max() {
	    
	      return "hi"; 
	   }
}