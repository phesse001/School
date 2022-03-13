/**
 * This class represents a binary operation (such as plus, minus, etc.) in the
 * AST.
 *
 * @author Peter Ohmann + <Patrick Hesse here>
 */
public class ReturnStatementNode extends StatementNode {

    public ReturnStatementNode(ExpressionNode e) {
        super();
        this.children.add(e);
    }

    @Override
    public String toString() {
        return "Return Statement";
    }
}
