/**
 * This class represents a binary operation (such as plus, minus, etc.) in the
 * AST.
 *
 * @author Peter Ohmann + <Patrick Hesse here>
 */
public class ErrorStatementNode extends StatementNode {
    private StatementListNode l;

    public ErrorStatementNode(StatementListNode l){
        super();
        this.l = l;
        this.children.add(l);
    }

    @Override
    public String toString() {
        return "Error Statement";
    }
}
