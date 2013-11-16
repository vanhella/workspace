
/**
 * An int array that holds only at most 10 positive integers
 * It throws a RuntimeException if negative is added
 */
public class IntArray {

  private Integer numbers[] = new Integer[10];
  private int index = 0;

  /**
   * return the ith element
   * @param i
   * @return
   */
  public int get(int i) {
    return numbers[i];
  }

  /**
   * add num to next empty element
   * num must be a positive number, or exception is thrown
   * @param num
   */
  public void add(int num) {
    if (num < 0) {
      throw new NegIntegerException("Number is negative");
    }
    numbers[index] = num;
    index++;
  }

  /**
   * replace number at index i with num
   * num must be positive
   * @param i the index
   * @param num the new number
   */
  public void replace(int i, int num) {
    if (num < 0) {
      throw new NegIntegerException("Number is negative");
    }
    if (i >= index && i < 10) throw new NullPointerException();
    numbers[i] = num;
  }

  /**
   * return number of elements in the array
   * @return
   */
  public int size() {
    return index;
  }

  /**
   * Multiply each element by n and replace old value by the result.
   * @param n
   */
  public void multiplyAll(int n){
    for(int i=0; i<index; i++){
      numbers[i] = n*numbers[i];
    }
  }

  /**
   * Divide each element by n and replace old value by the result.
   * @param n
   */
  public void divideAll(int n){
    for(int i=0; i<index; i++){
      numbers[i] = numbers[i]/n;
    }
  }


  @Override
  public String toString(){
    String s = "[ ";
    for(int i=0; i<size(); i++){
      s+=get(i)+" ";
    }
    s+="]";
    return s;
  }

}
