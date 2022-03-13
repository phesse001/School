/*
 * This class represents a Statement List in the AST.
 *
 * @author Peter Ohmann + <your name here>
 */
public class ParamListNode extends ASTNode {
    /**
     * An empty statement list.
     */
    public ParamListNode() {
        super();
    }

    public void addParam(ParameterStatementNode s, int position) {
        this.children.add(position, s);
    }

    public void addParam(ParameterStatementNode s) {
        this.children.add(s);
    }

    @Override
    public String toString() {
        return "Parameter List";
    }
}
