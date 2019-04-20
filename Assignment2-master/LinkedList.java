public class LinkedList {
    private  node head=null ;
   // private node node;
    
    public void add (int c, int index){
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
    public void add(int c){
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
    public  int  getlength(){
        node i=head;
        int length=0;
        while(i!=null){
            length++;
            i=i.next;
        }
        return length;
    }
    public int get(int index){
      node i=head;
        int counter;
       counter= getlength();
        if(index==0){
           return head.value;
        }
        else if(index>counter)
        {
            System.out.println("You Choose A Null Character");
            return -1 ;
        }
        else
        {
            for(int count =0;count<index;count++){
                i=i.next;
            }
            return i.value;
        }
    }
    public void set(int index, int c){
        int counter;
        counter=getlength();
            node i=head;
        if(index==0){
           head.value=c;
        }
        else if(index>counter)
        {
            System.out.println("You Choose A Null Character");
            
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
        counter=getlength();
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
    public boolean contains(int c){
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
    public int contain2(int c){
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
    public void edit(int c,int va){
        node i=head;
        for(int j=0;j<c;j++) {
        	i=i.next;
        }
        i.value=i.value+va;
    }
    public void edit2(int c,int va){
        node i=head;
        for(int j=0;j<c;j++) {
        	i=i.next;
        }
        i.value=i.value-va;
    }

}