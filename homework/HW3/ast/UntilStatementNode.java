/**
 * This class represents a binary operation (such as plus, minus, etc.) in the
 * AST.
 *
 * @author Peter Ohmann + <Patrick Hesse here>
 */
public class UntilStatementNode extends StatementNode {
    private StatementListNode list;
    private StatementNode s;

    public UntilStatementNode(StatementNode s, StatementListNode list){
        super();
        this.list = list;
        this.s = s;
        this.children.add(s);
        this.children.add(list);
    }

    @Override
    public String toString() {
        return "Until Statement";
    }
}
