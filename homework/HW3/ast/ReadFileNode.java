import java_cup.runtime.*;

/**
 * This class represents an assignment expression in the AST.
 *
 * @author Peter Ohmann + <Patrick Hesse>
 */
public class ReadFileNode extends ExpressionNode {
    private String id;

    public ReadFileNode(String id, ExpressionNode fn) {
        super();
        this.id = id;
        this.children.add(fn);
    }

    @Override
    public String toString() {
        return "File read into variable: " + this.id;
    }
}
