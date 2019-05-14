/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eg.edu.alexu.csd.datastructure.linkedList;

/**
 *
 * @author Momen
 */
public class linkedlist_iniit implements ILinkedList {
      private  node head=null ;
   // private node node;
    
    public void add (int index ,Object c){
        node i=head;
        node c1=new node();
        c1.value=c;
        if(index==0){
            c1.next=head;
            head=c1;
        }else{
           for(int count=0;count <index-1 ;count++){
                   i=i.next;
            }  
            c1.next=i.next;
            i.next=c1;
        }
    }
    public void add(Object c){
        node i=head;
        node c2=new node();
        c2.value=c;
        if(head==null) {
        	head=c2;
        	return ;
        }
        while(i!=null){
            if(i.next==null){
                c2.next=null;
                i.next=c2;
                i=null;
            }else{
                i=i.next;
            }
        }
        
    }
    public void print(){
        node i=head;
       while(i!=null){
        System.out.print(i.value+" ");
        i=i.next;
       }
       System.out.println();
    }
    public  int  size(){
        node i=head;
        int length=0;
        while(i!=null){
            length++;
            i=i.next;
        }
        return length;
    }
    public Object get(int index){
      node i=head;
        int counter;
       counter= size();
        if(index==0){
           return head.value;
        }
        else if(index>counter)
        {
        throw new RuntimeException("Linked List out of bounds");
        }
        else
        {
            for(int count =0;count<index;count++){
                i=i.next;
            }
            return i.value;
        }
    }
    public void set(int index, Object c){
        int counter;
        counter=size();
            node i=head;
        if(index==0){
           head.value=c;
        }
        else if(index>counter)
        {
          throw new RuntimeException("Linked List out of bounds");
            
        }
        else
        {
            for(int count =0;count<index;count++){
                i=i.next;
            }
            i.value=c;
        }
        
    }
   
    public void clear(){
    	if(head!=null) {
        head.next=null;
        head=null;}
        
 
    }
    public boolean isEmpty(){
        node i=head;
        if(i==null){
            return true;
        }else{
            return false;
        }
    }
    public void remove(int index){
        node i=head;
        int counter;
        counter=size();
        node j=i.next;
        if(index==0){
          head=head.next;
        }else if(index==counter-1){
            for(int count =0;count<index-1;count++){
                i=i.next;
                j=j.next;
            } 
            i.next=j.next;
            j.next=null;
        }
        else
        {
           for(int count=0;count<index-1;count++){
                i=i.next;
                j=j.next;
            }
            i.next=j.next;
            j.next=null;
        }
    }
    public boolean contains(Object c){
        node i=head;
        while(i!=null){
            if(i.value==c)
            {
                return true;
            }else 
                i=i.next;
            
        }
        return false;
    }
    public int contain2(Object c){
        node i=head;
        int j=0;
        while(i!=null){
            if(i.value==c)
            {
                return j;
            }else 
                i=i.next;
            j++;
        }
        return -1;
    }
    public void edit(Object c,int va){
        node i=head;
        for(int j=0;j<(int)c;j++) {
        	i=i.next;
        }
        i.value=(int)i.value+va;
    }
    public void edit2(Object c,int va){
        node i=head;
        for(int j=0;j<(int)c;j++) {
        	i=i.next;
        }
        i.value=(int)i.value-va;
    }

}
