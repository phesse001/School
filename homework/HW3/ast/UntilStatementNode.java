/**
 * This class represents a binary operation (such as plus, minus, etc.) in the
 * AST.
 *
 * @author Peter Ohmann + <Patrick Hesse here>
 */
public class UntilStatementNode extends StatementNode {
    private StatementListNode list;
    private DeclarationStatementNode dec;

    public UntilStatementNode(DeclarationStatementNode dec, StatementListNode list){
        super();
        this.list = list;
        this.dec = dec;
        this.children.add(dec);
        this.children.add(list);
    }

    @Override
    public String toString() {
        return "Until Statement";
    }
}
