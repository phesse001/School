/**
 * This class represents a binary operation (such as plus, minus, etc.) in the
 * AST.
 *
 * @author Peter Ohmann + <Patrick Hesse here>
 */
public class IfStatementNode extends StatementNode {
    private ExpressionNode e;
    private StatementListNode l1;
    private StatementListNode l2;

    public IfStatementNode(ExpressionNode e, StatementListNode l1, StatementListNode l2){
        super();
        this.l1 = l1;
        this.l2 = l2;
        this.e = e;
        this.children.add(e);
        this.children.add(l1);
        this.children.add(l2);
    }

    @Override
    public String toString() {
        return "If Statement";
    }
}
