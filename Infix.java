import java.util.*;
import java.util.StringTokenizer;
import java.lang.Object;

public class Infix extends Post{
    private StringBuffer post = new StringBuffer();
    private Stack<String> number = new Stack<>();
    private Stack<String> oprtrs = new Stack<>();
    private String operation;

  public Infix(String infix){
    super(infix);
    this.operation = infix;
  }

  public String convert(){
        StringTokenizer st = new StringTokenizer(operation);
      while(st.hasMoreTokens()){
              String temp = st.nextToken();
        if(super.isNumber(temp))
              number.push(temp);
        else if(super.isOprtr(temp))
              oprtrs.push(temp);
        else if(!super.isOprtr(temp)){
          System.out.println("INVALID SYMBOL");
          return "NO";
        }
        }
      makeOpr();
      String tmp = post.toString();
      if(!number.isEmpty()){
        System.out.println("MISSING OPERATOR");
        tmp = "NO";
        }
      else
        System.out.println("Converted = "+post);
      return tmp;
  }
  private void makeOpr(){
    while(!oprtrs.isEmpty()){
          post.insert(0," "); //insert space
          if(!oprtrs.isEmpty())
          post.insert(0,oprtrs.pop());
          post.insert(0," ");

        if(!oprtrs.isEmpty())
            post.insert(0,number.pop());
        else if(!number.isEmpty()){
            post.insert(0,number.pop());
            post.insert(0," ");
            if(!number.isEmpty())
              post.insert(0,number.pop());
          }
      }
    }
}
