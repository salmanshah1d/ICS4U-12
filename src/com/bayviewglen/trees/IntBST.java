package com.bayviewglen.trees;

public class IntBST {
	IntTreeNode root;

	public IntBST(IntTreeNode root) {
		super();
		this.root = root;
	}

	public IntBST() {
		super();
		this.root = null;
	}

	public IntTreeNode getRoot() {
		return root;
	}

	private void add(IntTreeNode current, int x) {
		if (x < current.getData()) {
			if (current.getLeft() == null) {
				IntTreeNode temp = new IntTreeNode(x);
				current.setLeft(temp);
			} else {
				add(current.getLeft(), x);
			}
		} else {
			if (current.getRight() == null) {
				IntTreeNode temp = new IntTreeNode(x);
				current.setRight(temp);
			} else {
				add(current.getRight(), x);
			}
		}
	}

	public void add(int x) {
		if (root == null) {
			IntTreeNode temp = new IntTreeNode(x);
			root = temp;
		} else {
			add(root, x);
		}
	}

	private boolean search(IntTreeNode current, int x) {
		if (current.getData() == x) {
			return true;
		} else if (x < current.getData()) {
			if (current.getLeft() == null) {
				return false;
			} else {
				return search(current.getLeft(), x);
			}
		} else {
			if (current.getRight() == null) {
				return false;
			} else {
				return search(current.getRight(), x);
			}
		}
	}

	public boolean search(int x) {
		if (root.getData() == x) {
			return true;
		} else {
			return search(root, x);
		}
	}

	public void inOrderTraversal(IntTreeNode current) {
		if (current.getLeft() != null) {
			inOrderTraversal(current.getLeft());
		}
		evaluate(current);
		if (current.getRight() != null) {
			inOrderTraversal(current.getRight());
		}
	}

	public void preorderTraversal(IntTreeNode current) {
		evaluate(current);

		if (current.getLeft() != null) {
			inOrderTraversal(current.getLeft());
		}

		if (current.getRight() != null) {
			inOrderTraversal(current.getRight());
		}
	}

	public void postorderTraversal(IntTreeNode current) {
		if (current.getLeft() != null) {
			inOrderTraversal(current.getLeft());
		}

		if (current.getRight() != null) {
			inOrderTraversal(current.getRight());
		}

		evaluate(current);
	}

	public boolean delete(int x) {
		if (root.getData() == x) {
			rebalance(root, x); // CHECK THIS BOI
			return true;
		} else {
			return delete(root, x);
		}
	}

	private void rebalance(IntTreeNode current, int x) {
		if (current.getRight() != null && current.getRight().getData() == x) {
			if (current.getRight().getLeft() == null && current.getRight().getRight() == null) {
				current.setLeft(null);
			} else if (current.getRight().getLeft() == null) {
				current.setRight(current.getRight().getRight());
			} else if (current.getRight().getRight() == null) {
				current.setRight(current.getRight().getLeft());
			} else {
				IntTreeNode tempNode = current.getRight().getRight();
				int temp;
				if (tempNode.getLeft() != null) {
					while (tempNode.getLeft().getLeft() != null) {
						tempNode = tempNode.getLeft();
					}
					temp = tempNode.getLeft().getData();
					if (tempNode.getLeft().getRight() != null) {
						tempNode.setLeft(tempNode.getLeft().getRight());
					} else {
						tempNode.setLeft(null);
					}
				} else {
					tempNode.setLeft(null);
					temp = tempNode.getData();
					current.getRight().setRight(null);
				}
				current.getRight().setData(temp);
			}
		} else {
			if (current.getLeft().getLeft() == null && current.getLeft().getRight() == null) {
				current.setLeft(null);
			} else if (current.getLeft().getLeft() == null) {
				current.setLeft(current.getLeft().getRight());
			} else if (current.getLeft().getRight() == null) {
				current.setLeft(current.getLeft().getLeft());
			} else {
				IntTreeNode tempNode = current.getLeft().getRight();
				int temp;
				if (tempNode.getLeft() != null) {
					while (tempNode.getLeft().getLeft() != null) {
						tempNode = tempNode.getLeft();
					}
					temp = tempNode.getLeft().getData();
					tempNode.setLeft(null);
				} else {
					temp = tempNode.getData();
					current.getLeft().setRight(null);
				}
				current.getLeft().setData(temp);
			}
		}
	}

	private boolean delete(IntTreeNode current, int x) {
		if (current.getLeft() != null && current.getLeft().getData() == x) {
			rebalance(current, x);
			return true;
		} else if (current.getRight() != null && current.getRight().getData() == x) {
			rebalance(current, x);
			return true;
		} else if (current.getData() < x && current.getRight() != null) {
			return delete(current.getRight(), x);
		} else if (current.getData() > x && current.getLeft() != null) {
			return delete(current.getLeft(), x);
		} else {
			return false;
		}
	}

	private void evaluate(IntTreeNode current) {
		System.out.println(current.getData());
	}
}