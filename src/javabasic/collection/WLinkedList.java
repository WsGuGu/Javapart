package javabasic.collection;

public class WLinkedList {
    private Node first;
    private Node last;
    private int size;
    public void add(Object obj){
        Node node=new Node(obj);
        if (first==null){
            first=node;
            last=node;
        }
        else {
            node.previous=last;
            node.next=null;
            last.next=node;
            last=node;
        }
        size++;
    }
    public Object get(int index){
        if (index<0||index>size-1){
            throw new RuntimeException("索引数字不合法:"+index);
        }
        Node temp=null;
        if (index<=(size>>1)){
            temp=first;
            for (int i=0;i<index;i++){
                temp=temp.next;
            }
        }else {
            temp=last;
            for (int i=size-1;i>index;i--){
                temp=temp.previous;
            }
        }

        return temp.element;
    }
    public String toString(){
        Node temp=first;
        StringBuilder sb=new StringBuilder("[");
        while (temp!=null){
            sb.append(temp.element+",");
            temp=temp.next;
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }
    public static void main(String[] args) {
        WLinkedList list=new WLinkedList();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);
        System.out.println(list.get(2));
    }
}