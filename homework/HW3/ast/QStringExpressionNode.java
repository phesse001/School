import java_cup.runtime.*;

/**
 * This class represents a number (as an expression in the AST).
 *
 * @author Peter Ohmann + <Patrick Hesse>
 */
public class QStringExpressionNode extends ExpressionNode {
    private String value;

    public QStringExpressionNode(String text) {
        super();
        this.value = text;
        
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "Quoted string: " + this.value;
    }
}
