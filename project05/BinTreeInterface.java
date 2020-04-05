package cmsc256;


    import bridges.base.BinTreeElement;

    public interface BinTreeInterface<E> {

        /** Returns the root of this tree
         */
        public BinTreeElement<E> getRoot();

        /** Insert element into the binary tree
         * Return true if the element is inserted successfully
         */
        public boolean add(E element);

        /** Delete the specified element from the tree
         * Return true if the element is deleted successfully
         */
        public boolean remove(E element);

        /** Returns the number of nodes in the tree
         */
        public int size();

        /** Return true if the tree is empty
         */
        public  boolean isEmpty();

        /** Removes all nodes from the tree
         */
        public void clear();

        /** Return true if the element is in the tree
         */
        public boolean search(E e);

        /** Inorder traversal from the root
         *  @returns a String representation of the traversal
         *           with two spaces between the String representation
         *           of each element
         */
        public String inorder();

        /** Postorder traversal from the root
         *  @returns a String representation of the traversal
         *           with two spaces between the String representation
         *           of each element
         */
        public String postorder();

        /** Preorder traversal from the root
         *  @returns a String representation of the traversal
         *           with two spaces between the String representation
         *           of each element
         */
        public String preorder();

    }
