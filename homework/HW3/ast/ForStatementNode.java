/**
 * This class represents a binary operation (such as plus, minus, etc.) in the
 * AST.
 *
 * @author Peter Ohmann + <Patrick Hesse here>
 */
public class ForStatementNode extends StatementNode {
    private TypeNode t;
    private String loop_iter;
    private ExpressionNode list_id;
    private StatementListNode l;

    public ForStatementNode(TypeNode t, String loop_iter, ExpressionNode list_id, StatementListNode l){
        super();
        this.t = t;
        this.loop_iter = loop_iter;
        this.list_id = list_id;
        this.l = l;
        this.children.add(t);
        this.children.add(list_id);
        this.children.add(l);
    }

    @Override
    public String toString() {
        return "For Statement: " + loop_iter;
    }
}
