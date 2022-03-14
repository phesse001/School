/**
 * This class represents a statement that is a declaration of a variable.
 *
 * @author Peter Ohmann + <your name here>
 */
public class FunctionDeclarationNode extends StatementNode {
    private String fname;
    
    public FunctionDeclarationNode(TypeNode type, String fname,
                                  ParamListNode params, StatementListNode list) {
        super();
        this.fname = fname; 
	this.children.add(type);
        this.children.add(params);
        this.children.add(list);
    }

    @Override
    public String toString() {
        return "Function declaration: " + this.fname;
    }
}
