public class Node {
    private int value;//значение узла
    private Node leftChild;//потомки узла( два потому что дерево бинарное)
    private Node rightChild;


    public int getValue() {
        return this.value;
    }

    public void setValue(final int value) {
        this.value = value;
    }

    public Node getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(final Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(final Node rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "Node{ " + "value=" + value + ", leftChild=" + leftChild + ", rightChild=" + rightChild + " }";
    }
}
