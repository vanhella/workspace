import java.util.InputMismatchException;


public class IntArrayDriver {

  public static void main(String[] args) {

    IntArray a = new IntArray();

    java.util.Scanner scanner = new java.util.Scanner(System.in);

    System.out.println("Enter positive integers terminate by -1:");
    int n = scanner.nextInt();
    while (n > -1) {
      try{
    	  a.add(n);
    	  n = scanner.nextInt();
      }
      catch(NegIntegerException e){
    	  System.out.print("\nERROR: You entered a negative number!\n");
      }
      catch(InputMismatchException e){
    	  System.out.print("\nERROR: Input must be an integer!\n");
      }
      catch(ArrayIndexOutOfBoundsException e){
    	  System.out.print("\nERROR: You entered too amny numbers!\n");
    	  n=-1;
      }
    }

    System.out.println("You have entered " + a);
    char cont = 'n';
    System.out.print("Change a number? (y/n) ");
    cont = scanner.next().charAt(0);

    if (cont == 'y' || cont == 'Y') {
    	int index = 0;
      do {
        System.out.println("Enter index of number to change:");
        try{
        	index = scanner.nextInt();
        }
        catch(InputMismatchException e){
        	System.out.print("\nERROR: Index must be an integer!\n");
        }
        System.out.println("Enter new value:");
        try{
        	a.replace(index, scanner.nextInt());
        }
        catch(NegIntegerException e){
        	System.out.print("\nERROR: You entered a negative number!\n");
        }
        catch(NullPointerException e){
        	System.out.print("\nERROR: Index must be between 0 and 9!\n");
        }
        catch(InputMismatchException e){
        	System.out.print("\nERROR: You must enter an integer!\n");
        }
        System.out.println(a);
        System.out.print("Change another ? (y/n) ");
        cont = scanner.next().charAt(0);
      } while (cont != 'n');

    }

    System.out.println("Divide numbers in array by : ");
    n = scanner.nextInt();
    try{
    	a.divideAll(n);
    }
    catch(ArithmeticException e){
    	System.out.print("ERROR: You can't divide by 0!\n");
    }
    System.out.println(a);

  }

}
