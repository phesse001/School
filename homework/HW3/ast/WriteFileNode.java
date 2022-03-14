import java_cup.runtime.*;

/**
 * This class represents an assignment expression in the AST.
 *
 * @author Peter Ohmann + <Patrick Hesse>
 */
public class WriteFileNode extends StatementNode {
    private ExpressionNode id;
    private ExpressionNode fn;

    public WriteFileNode(ExpressionNode id, ExpressionNode fn) {
        super();
        this.id = id;
        this.fn = fn;
        this.children.add(id);
        this.children.add(fn);
    }

    @Override
    public String toString() {
        return "File Write Statement";
    }
}
