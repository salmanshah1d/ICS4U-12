package com.bayviewglen.trees;

import java.io.BufferedWriter;
import java.io.IOException;

import com.bayviewglen.arrays.Contact;

public class BST {
	TreeNode root;

	public BST(TreeNode root) {
		super();
		this.root = root;
	}

	public BST() {
		super();
		this.root = null;
	}

	public TreeNode getRoot() {
		return root;
	}

	private void add(TreeNode current, Comparable<Contact> x) {
		if (x.compareTo((Contact) current.getData()) < 0) {
			if (current.getLeft() == null) {
				TreeNode temp = new TreeNode(x);
				current.setLeft(temp);
			} else {
				add(current.getLeft(), x);
			}
		} else {
			if (current.getRight() == null) {
				TreeNode temp = new TreeNode(x);
				current.setRight(temp);
			} else {
				add(current.getRight(), x);
			}
		}
	}

	public void add(Comparable<Contact> x) {
		if (root == null) {
			TreeNode temp = new TreeNode(x);
			root = temp;
		} else {
			add(root, x);
		}
	}

	private String search(TreeNode current, Comparable<Contact> x) {
		if (x.compareTo((Contact) current.getData()) == 0) {
			return ((Contact) (current).getData()).toString();
		} else if (x.compareTo((Contact) current.getData()) < 0) {
			if (current.getLeft() == null) {
				return "Contact not found.";
			} else {
				return search(current.getLeft(), x);
			}
		} else {
			if (current.getRight() == null) {
				return "Contact not found.";
			} else {
				return search(current.getRight(), x);
			}
		}
	}

	public String search(String x, String y) {
		Contact toFind = new Contact(x, y);
		if (root == null) {
			return "Contact not found.";
		} else if ((root.getData()).compareTo(toFind) == 0) {
			return ((Contact) root.getData()).getNumber();
		} else {
			return search(root, toFind);
		}
	}

	private boolean ifExists(TreeNode current, Comparable<Contact> x) {
		if (x.compareTo((Contact) current.getData()) == 0) {
			return true;
		} else if (x.compareTo((Contact) current.getData()) < 0) {
			if (current.getLeft() == null) {
				return false;
			} else {
				return ifExists(current.getLeft(), x);
			}
		} else {
			if (current.getRight() == null) {
				return false;
			} else {
				return ifExists(current.getRight(), x);
			}
		}
	}

	public boolean ifExists(String first, String last) {
		Contact toFind = new Contact(first, last);
		if (root == null) {
			return false;
		} else if ((root.getData()).compareTo(toFind) == 0) {
			return true;
		} else {
			return ifExists(root, toFind);
		}
	}

	public void inOrderTraversal(TreeNode current) {
		if (current.getLeft() != null) {
			inOrderTraversal(current.getLeft());
		}
		evaluate(current);
		if (current.getRight() != null) {
			inOrderTraversal(current.getRight());
		}
	}

	public void preorderTraversal(TreeNode current) {
		evaluate(current);

		if (current.getLeft() != null) {
			inOrderTraversal(current.getLeft());
		}

		if (current.getRight() != null) {
			inOrderTraversal(current.getRight());
		}
	}

	public void postorderTraversal(TreeNode current) {
		if (current.getLeft() != null) {
			inOrderTraversal(current.getLeft());
		}

		if (current.getRight() != null) {
			inOrderTraversal(current.getRight());
		}

		evaluate(current);
	}

	public boolean delete(String first, String last) {
		Contact x = new Contact(first, last);
		if (root == null) {
			return false;
		} else if ((root.getData()).compareTo(x) == 0) {
			if (root.getRight() != null && root.getLeft() == null) {
				root = root.getRight();
			} else if (root.getRight() == null && root.getLeft() != null) {
				root = root.getLeft();
			} else if (root.getRight() != null && root.getLeft() != null) {
				TreeNode tempNode = root.getRight();
				if (tempNode.getLeft() == null) {
					root.setData(tempNode.getData());
					root.setRight(null);
				} else {
					while (tempNode.getLeft().getLeft() != null) {
						tempNode = tempNode.getLeft();
					}
					root.setData(tempNode.getLeft().getData());
					tempNode.setLeft(null);
				}
			} else {
				root = null;
			}
			return true;
		} else {
			return delete(root, x);
		}
	}

	private void rebalance(TreeNode current, Comparable<Contact> x) {
		if (current.getRight() != null && current.getRight().getData().compareTo(x) == 0) {
			if (current.getRight().getLeft() == null && current.getRight().getRight() == null) {
				current.setRight(null);
			} else if (current.getRight().getLeft() == null) {
				current.setRight(current.getRight().getRight());
			} else if (current.getRight().getRight() == null) {
				current.setRight(current.getRight().getLeft());
			} else {
				TreeNode tempNode = current.getRight().getRight();
				Comparable<Contact> temp;
				if (tempNode.getLeft() != null) {
					while (tempNode.getLeft().getLeft() != null) {
						tempNode = tempNode.getLeft();
					}
					temp = tempNode.getLeft().getData();
					tempNode.setLeft(null);
				} else {
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
				TreeNode tempNode = current.getLeft().getRight();
				Comparable<Contact> temp;
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

	private boolean delete(TreeNode current, Comparable<Contact> x) {
		if (current.getLeft() != null && current.getLeft().getData().compareTo(x) == 0) {
			rebalance(current, x);
			return true;
		} else if (current.getRight() != null && current.getRight().getData().compareTo(x) == 0) {
			rebalance(current, x);
			return true;
		} else if (x.compareTo((Contact) current.getData()) < 0 && current.getRight() != null) {
			return delete(current.getRight(), x);
		} else if (x.compareTo((Contact) current.getData()) > 0 && current.getLeft() != null) {
			return delete(current.getLeft(), x);
		} else {
			return false;
		}
	}

	private void evaluate(TreeNode current) {
		System.out.println(current.getData());
	}

	public void save(TreeNode current, BufferedWriter writer) throws IOException {
		if (current.getLeft() != null) {
			save(current.getLeft(), writer);
		}
		
		writer.append(current.getData().toString() + "\n");
		
		if (current.getRight() != null) {
			save(current.getRight(), writer);
		}
	}
}