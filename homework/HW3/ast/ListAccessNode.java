public class ListAccessNode extends ExpressionNode {
    private ExpressionNode id;
    private ExpressionNode num;

    public ListAccessNode(ExpressionNode id, ExpressionNode num) {
        super();
        this.id = id;
        this.num = num;
        this.children.add(id);
        this.children.add(num);
    }

    @Override 
    public String toString() {
        return "List Access";
    }

}
