/**
 * This class represents a Statement in the AST.
 *
 * @author Peter Ohmann + <your name here>
 */
public class ExpressionStatementNode extends StatementNode {
    /**
     * TODO: Handle statements in the AST!
     */
    public ExpressionStatementNode(ExpressionNode e) {
        super();
        this.children.add(e);
    }

    @Override
    public String toString() {
        return "Statement as Expression";
    }
}
