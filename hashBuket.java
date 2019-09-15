
public class hashBuket {
    class Node{
        private int key;
        private int val;

        private Node next;

    }
    private Node[] array;
    private int size;

    public hashBuket(){
        array=new Node[20];
        size=0;
    }
//返回指定键所映射的值
    public int get(int key){
        int index=hashFunction(key,array.length);
        Node head=array[index];
        Node cur=head;
        while(cur!=null){
            if(key==cur.key){
                return cur.val;
            }
            cur=cur.next;
        }
        return -1;
    }
//put将指定的值与此映射中的指定键相关联
    public int put(int key,int val){
        int index=hashFunction(key,array.length);
        Node head=array[index];
        Node cur=head;
        while(cur!=null){
            if(key==cur.key){
                int oldvalue=cur.val;
                cur.val=val;
                return oldvalue;
            }
            cur=cur.next;
        }
        Node node=new Node();
        node.val=cur.val;
        node.key=cur.key;
        node.next=head;
        head=node;
        size++;

        if((double)size/array.length>0.75){
            resize();
        }
        return -1;
    }

    public void resize(){
        Node[] newArray=new Node[array.length*2];
        for(int i=0;i<array.length;i++){
            Node head=array[i];
            Node cur=head;
            while(cur!=null){
                int index=hashFunction(cur.key,newArray.length);
                Node node=array[index];
                node.key=cur.key;
                node.val=cur.val;
                node.next=newArray[index];
                newArray[index]=node;

                cur=cur.next;
            }
        }
        array=newArray;
    }
    public int hashFunction(int key,int capacity){

        return key%capacity;
    }
    public  int remove(int key){
        int index=hashFunction(key,array.length);
        Node head=array[index];
        Node cur=head;
        Node prev=null;
        while(cur!=null){
            if(key==cur.key){
                int oldValue=cur.val;
                if(cur==head){
                    head=head.next;
                }else{
                    prev.next=cur.next;
                }
                size--;
                return oldValue;
            }
            prev=cur;
            cur=cur.next;

        }
         return -1;

    }

}
