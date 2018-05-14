public class IntTreeClient{
    public static void main(String[] args) {
        IntTree tree1 = new IntTree(14);
        IntTree tree2 = new IntTree(28);
        IntTree tree3 = new IntTree(30);

        tree1.printSideways();
        tree1.printPreorder();
        tree1.printInorder();
        tree1.printPostorder();

        System.out.println();
        
        tree2.printSideways();
        tree2.printPreorder();
        tree2.printInorder();
        tree2.printPostorder();

        System.out.println();
        
        tree3.printSideways();
        tree3.printPreorder();
        tree3.printInorder();
        tree3.printPostorder();
    }
}