public class ListFilterNode extends ExpressionNode {
    private ExpressionNode la;
    private ExpressionNode str;

    public ListFilterNode(ExpressionNode str, ExpressionNode la) {
        super();
        this.la = la;
        this.str = str;
        this.children.add(str);
        this.children.add(la);
    }

    @Override 
    public String toString() {
        return "List Filter";
    }

}
