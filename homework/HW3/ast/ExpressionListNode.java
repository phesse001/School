/**
 * This class represents a binary operation (such as plus, minus, etc.) in the
 * AST.
 *
 * @author Peter Ohmann + <Patrick Hesse here>
 */
public class ExpressionListNode extends ASTNode {

    /**
     * An empty expression list.
     */
    public ExpressionListNode() {
        super();
    }

    public void addExpression(ExpressionNode e, int position) {
        this.children.add(position, e);
    }

    public void addExpression(ExpressionNode e) {
        this.children.add(e);
    }

    @Override
    public String toString() {
        return "Expression List";
    }
    
}
