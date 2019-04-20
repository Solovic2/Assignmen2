
public class DoublyLinkedList {
	Dnode head=null;
	
	// add in index
	public void add (int c, int index){
        Dnode i=head;
        Dnode c1=new Dnode();
        c1.value=c;
        if(index==0){
            c1.next=head;
            head.previous=c1;
            c1.previous=null;
            head=c1;
        }else{
           for(int count=0;count <index-1 ;count++){
                   i=i.next;
            } 
            Dnode k=i.next;
            if(k!=null) {
            c1.next=i.next;
            k.previous=c1;
            c1.previous=i;
            i.next=c1;}
            else {c1.next=i.next;
            c1.previous=i;
            i.next=c1;}
        }
    }
	
	//add in tail
	public void add(int element) {
		Dnode i=head;
		Dnode c1=new Dnode();
		
		if(head==null) {
			c1.value=element;
			head =c1;
			c1.next=null;
			c1.previous=null;
		}
		else {
			while(i.next!=null) {
				i=i.next;
			}
			c1.value=element;
			i.next=c1;
			c1.previous=i;
			c1.next=null;
		}
	}
	
	//get value
	public int get (int index) {
		int h;
		Dnode i=head;
		for(int j=0;j<index;j++) {
			i=i.next;
		}
		h=i.value;
		return h;
	}
	
	//print linked
	public  void print () {
		Dnode k=head;
		Dnode b=k;
		while(k!=null) {
			System.out.print(k.value+" ");
			b=k;
			k=k.next;
		}
		System.out.println();
		while(b!=null) {
			System.out.print(b.value+" ");
			b=b.previous;
		}
	}
	//get the size
	public int size() {
		int j=0;
		Dnode i=head;
		while(i!=null) {
			j++;
			i=i.next;
		}
		
		return j;
	}
	
	//replace value
	public void set(int index, int element) {
		Dnode i=head;
		for(int j=0;j<index;j++) {
			i=i.next;
		}
		i.value=element;
	}
	//clear the linked
	public void clear() {
		head.next.previous=null;
		head.next=null;
		head=null;
	}
	
	//is empty
	public boolean isEmpty() {
		if(head==null)return true;
		return false;
	}
	//removing
	public void remove(int index) {
		Dnode i=head;
		if(i==null)return;
		if(index==0) {
			if(head.next!=null) {
			head=head.next;
			head.previous=null;
			return ;}
			else {head=null;
			return ;}
		}
		for(int j=0;j<index;j++) {
			i=i.next;
		}
		if(i.next==null) {
			i.previous.next=null;
			return;
		}
		i.previous.next=i.next;
		i.next.previous=i.previous;
	}
	//is there
	public boolean contains(int o) {
		Dnode i=head;
		while(i!=null) {
			if(i.value==o)return true;
			i=i.next;
		}
		return false;
	}
	
}

