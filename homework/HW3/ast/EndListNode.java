/**
 * This class represents a binary operation (such as plus, minus, etc.) in the
 * AST.
 *
 * @author Peter Ohmann + <Patrick Hesse here>
 */
public class EndListNode extends ExpressionNode {

    /**
     * An empty expression list.
     */
    public EndListNode() {
        super();
    }
   @Override
    public String toString() {
        return "Expression List";
    }
}
