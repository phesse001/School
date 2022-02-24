import java.io.*;
import java.util.*;
import expressions.*;

public class InfixPostfixDriver{
  
  static Scanner console = new Scanner(System.in);
  
  public static void main(String[] args){
    System.out.println("Enter and infix expression");
    
    String input = console.nextLine();
    
    Queue<Token> infix = Tokenizer.parseString(input);
    
    Queue<Token> postfix = InfixToPostfix.convert(infix);
    
    Iterator postIt = postfix.iterator();
    while(postIt.hasNext()){
      System.out.print(postIt.next() + " ");
    }
    
    System.out.println();
    
    //int result = PostfixEvaluator.evaluate(postfix);
    //System.out.println(result);
    
  }
}
