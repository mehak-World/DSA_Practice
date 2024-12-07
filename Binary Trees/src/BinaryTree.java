
public class BinaryTree {

	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data, Node left, Node right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public static Node subNodeExists(Node root, Node subRoot) {
		if(root == null) {
			return null;
		}
		
		if(root.data == subRoot.data) {
			return root;
		}
		
		Node ln = subNodeExists(root.left, subRoot);
		Node rn = subNodeExists(root.right, subRoot);
		
		if(ln == null && rn == null) {
			return null;
		}
		
		else if(ln != null){
			return ln;
		}
		
		else {
			return rn;
		}
	}
	
	
	public static boolean subTreeExists(Node root, Node subroot) {
		Node n = subNodeExists(root, subroot);
		if(n == null) {
			return false;
		}
		
		else {
			return traverse(n, subroot);
		}
	}
	
	public static boolean traverse(Node n1, Node n2) {
		if(n1 == null && n2 == null) {
			return true;
		}
		
		if(n1==  null) {
			return false;
		}
		
		if(n2 == null) {
			return false;
		}
		
		if(n1.data != n2.data) {
			return false;
		}
		
		boolean r1 = traverse(n1.left, n2.left);
		boolean r2 = traverse(n1.right, n2.right);
		
		return r1 && r2;
	}
	
	
	
	public static void main(String[] args) {
		
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n4 = new Node(4 );
		Node n2 = new Node(2, n4, n5);
		Node n3 = new Node(3,null, n6);
		Node n1 = new Node(1, n2, n3);
		
		Node n7 = new Node(4);
		Node n8 = new Node(5);
		Node n9 = new Node(2, n7, n8);
		
		
		boolean result = subTreeExists(n1, n9);
		System.out.println(result);
		
		if(result) {
			System.out.println("The subtree exists");
		}
		
		
		else {
			
		System.out.println("No, the subtree does not exist.");
		}
		
				

	}

}
