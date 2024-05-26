/*
Sarai Ayon
5/17/2024
CS240 Data Structures and Algorithms
Week 6: AVL Tree    
Below is a Java implementation of a music playlist manager using an AVL tree. 
Each song has attributes like title, artist, and duration (seconds). 
The AVL tree will ensure that the playlist remains balanced, maintaining efficient insertion, 
deletion, and search operations.
*/

class Song {
    String title;
    String artist;
    int duration; // duration in seconds

    Song(String title, String artist, int duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }
}

class AVLNode {
    Song song;
    int height;
    AVLNode left, right;

    AVLNode(Song song) {
        this.song = song;
        this.height = 1;
    }
}

class AVLTree {
    private AVLNode root;

    // Get the height of the node
    private int height(AVLNode N) {
        if (N == null)
            return 0;
        return N.height;
    }

    // Get the balance factor of the node
    private int getBalance(AVLNode N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    // Right rotate subtree rooted with y
    private AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Left rotate subtree rooted with x
    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Insert a song into the AVL tree
    public void insert(Song song) {
        root = insertRec(root, song);
    }

    private AVLNode insertRec(AVLNode node, Song song) {
        if (node == null)
            return new AVLNode(song);

        if (song.title.compareTo(node.song.title) < 0)
            node.left = insertRec(node.left, song);
        else if (song.title.compareTo(node.song.title) > 0)
            node.right = insertRec(node.right, song);
        else
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && song.title.compareTo(node.left.song.title) < 0)
            return rightRotate(node);

        if (balance < -1 && song.title.compareTo(node.right.song.title) > 0)
            return leftRotate(node);

        if (balance > 1 && song.title.compareTo(node.left.song.title) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && song.title.compareTo(node.right.song.title) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Pre-order traversal
    public void preOrder() {
        preOrderRec(root);
    }

    private void preOrderRec(AVLNode node) {
        if (node != null) {
            System.out.println(node.song.title + " by " + node.song.artist + " - " + node.song.duration + " seconds");
            preOrderRec(node.left);
            preOrderRec(node.right);
        }
    }

    // In-order traversal
    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(AVLNode node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.println(node.song.title + " by " + node.song.artist + " - " + node.song.duration + " seconds");
            inOrderRec(node.right);
        }
    }

    // Post-order traversal
    public void postOrder() {
        postOrderRec(root);
    }

    private void postOrderRec(AVLNode node) {
        if (node != null) {
            postOrderRec(node.left);
            postOrderRec(node.right);
            System.out.println(node.song.title + " by " + node.song.artist + " - " + node.song.duration + " seconds");
        }
    }

    // Main method to demonstrate the AVL tree
    public static void main(String[] args) {
        AVLTree playlist = new AVLTree();

        // Adding songs to the playlist
        playlist.insert(new Song("Shape of You", "Ed Sheeran", 240));
        playlist.insert(new Song("Blinding Lights", "The Weeknd", 200));
        playlist.insert(new Song("Dance Monkey", "Tones and I", 210));
        playlist.insert(new Song("Rockstar", "Post Malone", 230));
        playlist.insert(new Song("Someone You Loved", "Lewis Capaldi", 182));

        // Performing and printing traversals
        System.out.println("Pre-order traversal:");
        playlist.preOrder();

        System.out.println("\nIn-order traversal:");
        playlist.inOrder();

        System.out.println("\nPost-order traversal:");
        playlist.postOrder();
    }
}

