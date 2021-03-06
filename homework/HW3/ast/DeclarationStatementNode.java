/**
 * This class represents a statement that is a declaration of a variable.
 *
 * @author Peter Ohmann + <your name here>
 */
public class DeclarationStatementNode extends StatementNode {
    private TypeNode varType;
    private String varName;

    /**
     * Just a plain declaration.
     * For example:  num myVal;
     */
    public DeclarationStatementNode(TypeNode type, String varName) {
        super();
        this.varType = type;
        this.varName = varName;
        this.children.add(type);
    }

    /**
     * A declaration that includes initialization.
     * For example:  num myVal = 3.5;
     */
    public DeclarationStatementNode(TypeNode type, String varName,
                                    AssignExpressionNode assignment) {
        this(type, varName);
        this.children.add(assignment);
    }

    public DeclarationStatementNode(TypeNode type, String varName,
                                    ReadFileNode assignment) {
        this(type, varName);
        this.children.add(assignment);
    }
    
    @Override
    public String toString() {
        return "Declaration statement: " + this.varName;
    }
}
