Explanation
Song Class:

Represents a song with attributes: title, artist, and duration (in seconds).
AVLNode Class:

Represents a node in the AVL tree. Each node contains a Song object, its height, and pointers to left and right children.
AVLTree Class:

Manages the AVL tree operations, including insertion, rotations to maintain balance, and traversal methods.
The insert method inserts a new song into the AVL tree and performs necessary rotations to maintain balance.
The preOrderRec, inOrderRec, and postOrderRec methods are used to traverse the tree recursively in pre-order, in-order, and post-order respectively.
Main Method:

Demonstrates the insertion of sample songs and the traversal of the AVL tree in pre-order, in-order, and post-order.
Usage
Insertion: Songs are inserted into the AVL tree based on their titles. The title is used as the key for comparison.
Traversal:
Pre-order: Visits the root node first, then the left subtree, followed by the right subtree.
In-order: Visits the left subtree first, then the root node, followed by the right subtree.
Post-order: Visits the left subtree first, then the right subtree, followed by the root node.
This implementation provides a music playlist manager that maintains a balanced AVL tree for efficient operations and supports various traversal methods to view the playlist in different orders.
