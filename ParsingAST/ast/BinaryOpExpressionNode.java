/**
 * This class represents a Statement in the AST.
 *
 * @author Peter Ohmann + <your name here>
 */
public class BinaryOpExpressionNode extends ExpressionNode {
    /**
     * TODO: Handle statements in the AST!
     */
    private ExpressionNode LeftExpression;
    private ExpressionNode RightExpression;
    private String op;

    public BinaryOpExpressionNode(ExpressionNode e1, ExpressionNode e2, String op) {
        super();
        this.LeftExpression = e1; 
        this.RightExpression = e2; 
        this.op = op;
        this.children.add(e1);
        this.children.add(e2);
    }
    
    @Override
    public String toString() {
        return "Binary Operator '" + this.op + "'";
    }
}
