public class L12Q1TreeNode<E extends Comparable<E>>{
    E element;
    L12Q1TreeNode<E> left;
    L12Q1TreeNode<E> right;

    public L12Q1TreeNode(E element){
        this.element = element;
        this.left = null;
        this.right = null;
    }

    public E getElement() {
        return element;
    }

    public L12Q1TreeNode<E> getLeft() {
        return left;
    }

    public L12Q1TreeNode<E> getRight() {
        return right;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public void setLeft(L12Q1TreeNode<E> left) {
        this.left = left;
    }

    public void setRight(L12Q1TreeNode<E> right) {
        this.right = right;
    }

    
    
}