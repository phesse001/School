import java_cup.runtime.*;

/**
 *
 * @author Peter Ohmann + <Patrick Hesse>
 */
public class FuncCallExpressionNode extends ExpressionNode {
    private String id;
    private ExpressionListNode list;

    public FuncCallExpressionNode(String id, ExpressionListNode list) {
        super();
        this.id = id;
        this.list = list;
        this.children.add(list);
    }

    @Override
    public String toString() {
        return "Function call: " + this.id;
    }
}
