
public class PolynomialSolver {
	
	polynomials [] po = {new polynomials(),new polynomials(),new polynomials(),new polynomials()};
	 void BubbleSort (int[][] A) {
		int swapFlag = 1;
		
		int i, j;
		for(i = 0; i <A.length; i++) {
			if(swapFlag==0)break;
		swapFlag=0;
		for(j = 0; j < A.length-1-i; j++)
		if(A[j][1] < A[j+1][1]) {
		swap(A, j, j+1);
		swapFlag=1;
		}
		}
	}
	 void swap (int[][] A, int a, int b) {
		int temp1 = A[a][0];
		int temp2 =A[a][1];
		A[a][0] = A[b][0];
		A[a][1] = A[b][1];
		A[b][0] = temp1;
		A[b][1] =temp2;
		}

	
	public int terns (char poly) {
		 int i = 0;
	        switch (poly) {
	        case 'A':
	            i = 0;
	            break;
	        case 'B':
	            i = 1;
	            break;
	        case 'C':
	            i = 2;
	            break;
	        case 'R':
	            i = 3;
	            break;
	        }
	        return i;
	}
	
	 void setPolynomial(char poly, int[][] terms) {
		int x=terns(poly);
		
		po[x].coeff.clear();
		po[x].exponent.clear();
		for(int i=0;i<terms.length;i++) {
			po[x].coeff.add(terms[i][0]);
			po[x].exponent.add(terms[i][1]);
		}
		
	}
	 
	void clearPolynomial(char poly) {
		int x=terns(poly);
		po[x].coeff.clear();
		po[x].exponent.clear();
	}
	
	String print(char poly) {
		int x=terns(poly);
		String ans="";
		int size=po[x].coeff.getlength();
		System.out.println("size of "+poly+" is  "+size);
		System.out.println("size of "+poly+" is  "+po[x].exponent.getlength());
		for(int i=0;i<size;i++) {
			int c=po[x].coeff.get(i);
			int v=po[x].exponent.get(i);
			if(c!=0) {
			ans+=Integer.toString(c);
			if(v!=0) {ans+="x^";
			ans+=Integer.toString(v);}
			if(i+1!=size&&po[x].coeff.get(i+1)!=0)ans+=" + ";
			}

		}
		
		return ans;
	}
	
	float evaluatePolynomial(char poly, float m) {
		int x=terns(poly);
		float ans=0;
		int size=po[x].coeff.getlength();
		for(int i=0;i<size;i++) {
			ans+=(po[x].coeff.get(i))*Math.pow(m,po[x].exponent.get(i));
		}
		return ans;
	}
	
	int[][] add(char poly1, char poly2){
        int z=3;
        po[z].coeff.clear();
        po[z].exponent.clear();
        int x=terns(poly1);
        int y=terns(poly2);
        int size1=po[x].coeff.getlength();
        int size2=po[y].coeff.getlength();
            for(int count=0;count<size1;count++){
            	po[z].coeff.add(po[x].coeff.get(count));
            	po[z].exponent.add(po[x].exponent.get(count));
            	
            }
            for(int i=0;i<size2;i++) {
            	int h=po[y].exponent.get(i);
            	int u=po[z].exponent.contain2(h);
            	if(u!=-1) {
            		po[z].coeff.edit(u, po[y].coeff.get(i));
            	}
            	else {
            		po[z].coeff.add(po[y].coeff.get(i));
                	po[z].exponent.add(po[y].exponent.get(i));
            	}
            }
            int[][] arr=new int [po[z].coeff.getlength()][2];
            for(int i=0;i<po[z].coeff.getlength();i++){
                    arr[i][0]=po[z].coeff.get(i);
                    arr[i][1]=po[z].exponent.get(i);
            }
            BubbleSort(arr);
            setPolynomial('R',arr);
        
                  return arr;
    }
	
    int[][] subtract(char poly1, char poly2){
    	int z=3;
        po[z].coeff.clear();
        po[z].exponent.clear();
        int x=terns(poly1);
        int y=terns(poly2);
        int size1=po[x].coeff.getlength();
        int size2=po[y].coeff.getlength();
            for(int count=0;count<size1;count++){
            	po[z].coeff.add(po[x].coeff.get(count));
            	po[z].exponent.add(po[x].exponent.get(count));
            	
            }
            for(int i=0;i<size2;i++) {
            	int h=po[y].exponent.get(i);
            	int u=po[z].exponent.contain2(h);
            	if(u!=-1) {
            		po[z].coeff.edit2(u, po[y].coeff.get(i));
            	}
            	else {
            		po[z].coeff.add(-po[y].coeff.get(i));
                	po[z].exponent.add(po[y].exponent.get(i));
            	}
            }
            int[][] arr=new int [po[z].coeff.getlength()][2];
            for(int i=0;i<po[z].coeff.getlength();i++){
                    arr[i][0]=po[z].coeff.get(i);
                    arr[i][1]=po[z].exponent.get(i);
            }
            BubbleSort(arr);
            setPolynomial('R',arr);
        
                  return arr;

    }
    int[][] multiply(char poly1, char poly2){
        int z=3;
        po[z].coeff.clear();
        po[z].exponent.clear();
        int x=terns(poly1);
        int y=terns(poly2);
        int size1=po[x].coeff.getlength();
        int size2=po[y].coeff.getlength();
        int row = 0;
        int coloum = 0;
       /* if(size1==size2 || size1>size2){
            row=size1;
            coloum=size2;
        }else if(size2>size1){
              row=size2;
            coloum=size1;
        }*/	
        // multiplay the polonomial coeff and calculate sum of exp
            for(int count=0;count<size1;count++){
                for(int count_2=0;count_2<size2;count_2++){
                   int k=po[x].coeff.get(count)*po[y].coeff.get(count_2);
                   int k2=po[x].exponent.get(count) + po[y].exponent.get(count_2);
                   po[z].coeff.add(k);
                   po[z].exponent.add(k2);
                }
            }
	//check if there are repeated exp and add them 
            for(int count=0;count< po[z].exponent.getlength();count++){
                for(int count2=count+1;count2< po[z].exponent.getlength();count2++){
                    if(po[z].exponent.get(count)==po[z].exponent.get(count2)){
                        int num=po[z].coeff.get(count)+po[z].coeff.get(count2);
                        po[z].coeff.set(count, num);
                         po[z].coeff.remove(count2);
                        po[z].exponent.remove(count2);
                    }
                }
            }
	 // put it in array 2D of 2 coloums one for coeff and another for exp
            int[][] arr=new int [po[z].coeff.getlength()][2];
            for(int i=0;i<po[z].coeff.getlength();i++){
                    arr[i][0]=po[z].coeff.get(i);
                    arr[i][1]=po[z].exponent.get(i);
            }
            BubbleSort(arr);
            setPolynomial('R',arr);
            
            return arr;
    }
	
}
