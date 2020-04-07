import java.util.*;

public class InToPost{
  public static void main(String[] args) {
    Scanner a = new Scanner(System.in);
    String operation;
    System.out.println("Input :");
        operation = a.nextLine();
    Infix op = new Infix(operation);
        String temp = op.convert();
    if(temp != "NO"){
    Post op1 = new Post(temp);
        op1.start();
        }
  }
}
