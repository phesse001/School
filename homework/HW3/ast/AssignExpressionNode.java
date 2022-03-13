import java_cup.runtime.*;

/**
 * This class represents an assignment expression in the AST.
 *
 * @author Peter Ohmann + <your name here>
 */
public class AssignExpressionNode extends ExpressionNode {
    private String id;

    public AssignExpressionNode(String id, ExpressionNode e) {
        super();
        this.id = id;
        this.children.add(e);
    }

     public AssignExpressionNode(String id, ExpressionListNode l) {
        super();
        this.id = id;
        this.children.add(l);
    }
   

    @Override
    public String toString() {
        return "Assignment to variable: " + this.id;
    }
}
