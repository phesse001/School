/**
 * This class represents a Statement in the AST.
 *
 * @author Peter Ohmann + <your name here>
 */
public class NumExpressionNode extends ExpressionNode {
    private String value;
    /**
     * TODO: Handle statements in the AST!
     */
    public NumExpressionNode(String value) {
        super();
        this.value = value;
    }


    public String toString() {
        return "Number: " + this.value;
    }
}
