
public class LinkedGrid {
private Node root;
private int dimension;
public LinkedGrid(int dimension) {
	this.dimension=dimension;
	//top left corner
	root=new Node();
	Node columnMarker=root;
	Node rowMarker=root;
	
	for(int x=0;x<dimension-1;x++) {
		columnMarker.setRight(new Node());
		columnMarker.getRight().setLeft(columnMarker);
		columnMarker=columnMarker.getRight();
	}
	for(int y=0;y<dimension-1;y++) {
		rowMarker.setDown(new Node());
		columnMarker=rowMarker.getDown();
		columnMarker.setUp(rowMarker);
		for(int x=0;x<dimension-1;x++) {
			Node temp=new Node();
			columnMarker.setRight(temp);
			temp.setLeft(columnMarker);
			temp.setUp(columnMarker.getUp().getRight());
			temp.getUp().setDown(temp);
			columnMarker=temp;
		}
		rowMarker=rowMarker.getDown();
	}
}
public void display() {
	Node temp=root;
	Node rowMarker=root;
	System.out.print("start here ->");
	while(rowMarker!=null) {
		temp=rowMarker;
		if(rowMarker==root)
			System.out.print("\t");
		else
			System.out.print("\t\t");
	while(temp!=null) {
		System.out.print(temp.getData()+" ");
		temp=temp.getRight();
	}
	System.out.println();
	rowMarker=rowMarker.getDown();
	}
	
}
public void flood(Node n,int old,int newNum) {
	n.setData(newNum);
	if(n.getRight()!=null)
		if(n.getRight().getData()==old) {
			flood(n.getRight(),old, newNum);
		}
	if(n.getDown()!=null) {
		if(n.getDown().getData()==old) {
			flood(n.getDown(),old,newNum);
		}
	}
	if(n.getLeft()!=null) {
		if(n.getLeft().getData()==old) {
			flood(n.getLeft(),old,newNum);
		}
	}
	if(n.getUp()!=null) {
		if(n.getUp().getData()==old) {
			flood(n.getUp(),old,newNum);
		}
	}
}
public boolean check() {
	Node temp=root;
	Node rowMarker=root;
	int data=root.getData();
	while(rowMarker!=null) {
		temp=rowMarker;
	while(temp!=null) {
		if(temp.getData()!=data)
			return false;
		temp=temp.getRight();
	}
	rowMarker=rowMarker.getDown();
	}
	return true;
}

public Node getRoot() {
	return root;
}
public void setRoot(Node root) {
	this.root = root;
}
public int getDimension() {
	return dimension;
}
public void setDimension(int dimension) {
	this.dimension = dimension;
}

}
