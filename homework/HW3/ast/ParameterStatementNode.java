/**
 * This class represents a binary operation (such as plus, minus, etc.) in the
 * AST.
 *
 * @author Peter Ohmann + <Patrick Hesse here>
 */
public class ParameterStatementNode extends StatementNode {

    private String id;

    public ParameterStatementNode(TypeNode type, String id){
        super();
        this.id = id;
        this.children.add(type);
    }

    @Override
    public String toString() {
        return "Parameter: " + this.id;
    }
}
