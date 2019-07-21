import java.util.Arrays;
abstract class List{
	private int size;
	List(){
		size=0;
	}


public void pushFront(int val){
	insertinternal(0,val);
}
public void pushBack(int val){
	insertinternal(size,val);
}
//抽象方法：只给出方法名 无方法实现
//方法实现子类来完成
public void insert(int index,int val){
	if(index<0||index>size){
		System.out.println("index 越界");
	}
	insertinternal(index,val);
}
protected abstract void insertinternal(int index,int val);
protected void incSize(){
	size++;
}
public int getSize(){
	return size;
}
abstract public void display();
}
class ArrayList extends List{
	private int[] array;
	ArrayList(){
		super();
		array=new int[10];
	}
	@Override
	public void insertinternal(int index,int val){
		ensureCapacity();
		for(int i=getSize();i>index;i--){
	    array[i]=array[i-1];
	}
	array[index]=val;
	super.incSize();
}
    @Override
	public void display(){
		for(int i=0;i<getSize();i++){
			System.out.println(array[i]);
		}
	}
	private void ensureCapacity(){
		if(getSize()<array.length){
			return;
		}
		array=Arrays.copyOf(array,2*array.length);
	}
}
	class Node{
		int val;
		Node next=null;
		Node(int val){
			this.val=val;
		}
		Node(int val,Node next){
			this.val=val;
			this.next=next;
		}
	}
	class LinkedList extends List{
		private Node head=null;
		
	
	@Override
	public void insertinternal(int index,int val){
		if(index==0){
			head=new Node(val,head);
		}
		else{
			Node prev=head;
			for(int i=0;i<index-1;i++){
				prev=prev.next;
			}
			prev.next=new Node(val,prev.next);
			Node node=new Node(val);
			node. next=prev.next;
			prev.next=node;
		}
		incSize();
	}
	@Override
	public void display(){
		for(Node cur=head;cur!=null;cur=cur.next){
			System.out.println(cur.val);
		}
	}
}
	public class 继承{
		static void testList(List list){
			list. pushBack(1);
			list. pushBack(2);
			list. pushBack(3);
			list. pushFront(10);
			list. pushFront(20);
			list. pushFront(30);
			list. insert(3,100);
			list. display();

		}
	public static void main(String[] args){
		testList(new ArrayList());
		testList(new LinkedList());
	    } 
	}
	