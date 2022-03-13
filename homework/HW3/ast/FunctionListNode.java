/**
 * This class represents a Function List in the AST.
 *
 * @author Peter Ohmann + <your name here>
 */
public class FunctionListNode extends ASTNode {
    private FunctionDeclarationNode dec;
    /**
     * An empty function list.
     */
    public FunctionListNode() {
        super();
    }

    /**
     * TODO: add a function declaration to this function list!?
     */
    public FunctionListNode(FunctionDeclarationNode dec) {
        super();
        this.dec = dec;
        this.children.add(dec);

    }

    @Override
    public String toString() {
        return "Function List";
    }
}
