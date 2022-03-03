/**
 * This class represents a boolean literal (such as true, false) in the
 * AST.
 *
 * @author Peter Ohmann + <Patrick Hesse>
 */
public class BoolNode extends ExpressionNode {
    private boolean bool;

    /**
     * Represent a bool.
     */
    public BoolNode(String text) {
        super();
        boolean b = Boolean.parseBoolean(text);
        this.bool = b;
    }

    @Override
    public String toString() {
        return "Boolean literal: " + this.bool;
    }
}
