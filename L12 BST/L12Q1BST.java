import java.util.ArrayList;

public class L12Q1BST<E extends Comparable<E>>{
    private L12Q1TreeNode<E> root;
    private int size;

    public L12Q1BST(){
        root = null;
        size = 0;
    }

    public boolean search(E e){
        return searchRecursive(root, e);
    }

    private boolean searchRecursive(L12Q1TreeNode<E> current, E value){
        if(current == null){
            return false;
        }

        if(value.equals(current.element)){
            return true;
        }

        if(value.compareTo(current.element) < 0){
            return searchRecursive(current.left, value);
        }else{
            return searchRecursive(current.right, value);
        }
    }

    public boolean insert(E e){
        if(root == null){
            root = new L12Q1TreeNode<>(e);
            size++;
            return true;
        }
        L12Q1TreeNode<E> parent = null;
        L12Q1TreeNode<E> current = root;
        while(current!=null){
            parent = current;
            if(e.compareTo(current.element)<0){
                current = current.left;
            }else if(e.compareTo(current.element)>0){
                current = current.right;
            }else{
                return false;
            }
        }
        if(e.compareTo(parent.element)<0){
            parent.left = new L12Q1TreeNode<>(e);
        }else{
            parent.right = new L12Q1TreeNode<>(e);
        }
        size++;
        return true;
    }

    public int getSize(){
        return size;
    }

    public int height(){
        return height(root);
    }

    private int height(L12Q1TreeNode<E> node){
        if(node == null){
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public E getRoot(){
        return root != null? root.element : null;
    }

    public E minValue(){
        if(root == null){
            return null;
        }
        L12Q1TreeNode<E> current = root;
        while(current.left != null){
            current = current.left;
        }
        return current.element;
    }

    public E maxValue(){
        if(root == null){
            return null;
        }
        L12Q1TreeNode<E> current = root;
        while(current.right != null){
            current = current.right;
        }
        return current.element;
    }

    public ArrayList<L12Q1TreeNode<E>> path(E e){
        ArrayList<L12Q1TreeNode<E>> path = new ArrayList<>();
        L12Q1TreeNode<E> current = root;
        while(current != null){
            path.add(current);
            if(e.compareTo(current.element) < 0 ){
                current = current.left;
            }else if(e.compareTo(current.element) > 0){
                current = current.right;
            }else{
                current = null;
            }
        }
        return path;
    }

    public boolean delete(E e){
        if(root == null){
            return false;
        }
        L12Q1TreeNode<E> current = root;
        L12Q1TreeNode<E> parent = null;
        while(current != null && !current.element.equals(e)){
            parent = current;
            if(e.compareTo(current.element) < 0){
                current = current.left;
            }else if(e.compareTo(current.element) > 0){
                current = current.right;
            }
        }
        if(current ==  null){
            return false;
        }

        if(current.left == null && current.right == null){
            if(current == root){
                root = null;
            }else if(parent.left == current){
                parent.left = null;
            }else{
                parent.right = null;
            }
        }else if(current.left == null){
            if(current == root){
                root = current.right;
            }else if(parent.left == current){
                parent.left = current.right;
            }else{
                parent.right = current.right;
            }
        }else if(current.right == null){
            if(current == root){
                root = current.left;
            }else if(parent.left == current){
                parent.left = current.right;
            }else{
                parent.right = current.right;
            }
        }else{
            L12Q1TreeNode<E> successorParent = current;
            L12Q1TreeNode<E> succesor = current.right;

            while (succesor.left != null) {
                successorParent = succesor;
                succesor = succesor.left;
            }

            current.element = succesor.element;

            if(successorParent.left == succesor){
                successorParent.left = succesor.right;
            }else{
                successorParent.right = succesor.right;
            }
        }
        return true;
    }

    public boolean clear() {
        while (root != null) {
            delete(root.element);
        }
        return true;
    }

    public void inorder() {
        inorderTraversal(root);
        System.out.println();
    }
    
    private void inorderTraversal(L12Q1TreeNode<E> node) {
        if (node == null) return;
        inorderTraversal(node.left);
        System.out.print(node.element + " ");
        inorderTraversal(node.right);
    }

    public void postorder() {
        postorderTraversal(root);
        System.out.println();
    }
    
    private void postorderTraversal(L12Q1TreeNode<E> node) {
        if (node == null) return;
        inorderTraversal(node.left);
        inorderTraversal(node.right);
        System.out.print(node.element + " ");
    }

    public void preorder() {
        preorderTraversal(root);
        System.out.println();
    }
    
    private void preorderTraversal(L12Q1TreeNode<E> node) {
        if (node == null) return;
        System.out.print(node.element + " ");      // 1. Visit root
        preorderTraversal(node.left);              // 2. Traverse left
        preorderTraversal(node.right);             // 3. Traverse right
    }
    
}