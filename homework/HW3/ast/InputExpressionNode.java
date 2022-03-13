import java_cup.runtime.*;
/**
 *
 * @author Peter Ohmann + <Patrick Hesse>
 */
public class InputExpressionNode extends ExpressionNode {
    private ExpressionNode str;

    public InputExpressionNode(ExpressionNode str) {
        super();
        this.str = str;
        this.children.add(str);
    }

    @Override
    public String toString() {
        return "Input expression";
    }
}
