/**
 * This class represents a binary operation (such as plus, minus, etc.) in the
 * AST.
 *
 * @author Peter Ohmann + <Patrick Hesse here>
 */
public class NotExpressionNode extends ExpressionNode {
    private ExpressionNode bool;

    /**
     * Represent an infix binary operator; that is "left op right".
     */
    public NotExpressionNode(ExpressionNode bool) {
        super();
        this.bool = bool;
        this.children.add(bool);
    }

    @Override
    public String toString() {
        return "Not expression";
    }
}
