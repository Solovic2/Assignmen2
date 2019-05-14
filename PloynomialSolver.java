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
public class PloynomialSolver implements IPolynomialSolver {

    polynomials[] po = {new polynomials(), new polynomials(), new polynomials(), new polynomials()};

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
    public void setPolynomial(char poly, int[][] terms) {
        int x = terns(poly);

        po[x].coeff.clear();
        po[x].exponent.clear();
        for (int i = 0; i < terms.length; i++) {
            po[x].coeff.add(terms[i][0]);
            po[x].exponent.add(terms[i][1]);
        }

    }

    public void clearPolynomial(char poly) {
        int x = terns(poly);
        po[x].coeff.clear();
        po[x].exponent.clear();
    }

public String print(char poly) {
		int x=terns(poly);
		String ans="";
		int size=po[x].coeff.size();
	//	System.out.println("size of "+poly+" is  "+size);
//		System.out.println("size of "+poly+" is  "+po[x].exponent.getlength());
		for(int i=0;i<size;i++) {
			int c=(int)po[x].coeff.get(i);
			int v=(int)po[x].exponent.get(i);
			if(c!=0) {
				if(c>0&&i==0) {
					if(c==1&&v!=0) {}
					else ans+=Integer.toString(c);}
				else if(c>0&&i!=0) {
					ans+=" + ";
					if(c==1&&v!=0) {}
					else ans+=Integer.toString(c);
				}
				else if(c<0&&i==0) {
					ans+=" - ";
					if(c==-1&&v!=0) {}
					else ans+=Integer.toString(-1*c);
				}
				else if(c<0&&i!=0) {
					ans+=" - ";
					if(c==-1&&v!=0) {}
					else ans+=Integer.toString(-1*c);
				}
			if(v!=0) {ans+="x^";
			ans+=Integer.toString(v);}
		//	if(i+1!=size&&po[x].coeff.get(i+1)!=0)ans+=" + ";
			}

		}
		
		return ans;
	}

    public float evaluatePolynomial(char poly, float m) {
        int x = terns(poly);
        float ans = 0;
        int size = po[x].coeff.size();
        for (int i = 0; i < size; i++) {
            ans += ((float) po[x].coeff.get(i)) * Math.pow(m, (float) po[x].exponent.get(i));
        }
        return ans;
    }

public int[][] add(char poly1, char poly2){
        int z=3;
        po[z].coeff.clear();
        po[z].exponent.clear();
        int x=terns(poly1);
        int y=terns(poly2);
        int size1=po[x].coeff.size();
        int size2=po[y].coeff.size();
            for(int count=0;count<size1;count++){
            	po[z].coeff.add(po[x].coeff.get(count));
            	po[z].exponent.add(po[x].exponent.get(count));
            	
            }
            for(int i=0;i<size2;i++) {
            	int h=(int)po[y].exponent.get(i);
            	int u=(int)po[z].exponent.contain2(h);
            	if(u!=-1) {
            		po[z].coeff.edit(u, (int)po[y].coeff.get(i));
            	}
            	else {
            		po[z].coeff.add(po[y].coeff.get(i));
                	po[z].exponent.add(po[y].exponent.get(i));
            	}
            }
            int[][] arr=new int [po[z].coeff.size()][2];
            for(int i=0;i<po[z].coeff.size();i++){
                    arr[i][0]=(int)po[z].coeff.get(i);
                    arr[i][1]=(int)po[z].exponent.get(i);
            }
                    BubbleSort(arr);
            setPolynomial('R',arr);
                  return arr;
    }

    public int[][] subtract(char poly1, char poly2){
    	int z=3;
        po[z].coeff.clear();
        po[z].exponent.clear();
        int x=terns(poly1);
        int y=terns(poly2);
        int size1=po[x].coeff.size();
        int size2=po[y].coeff.size();
            for(int count=0;count<size1;count++){
            	po[z].coeff.add(po[x].coeff.get(count));
            	po[z].exponent.add(po[x].exponent.get(count));
            	
            }
            for(int i=0;i<size2;i++) {
            	int h=(int)po[y].exponent.get(i);
            	int u=(int)po[z].exponent.contain2(h);
            	if(u!=-1) {
            		po[z].coeff.edit2(u, (int)po[y].coeff.get(i));
            	}
            	else {
            		po[z].coeff.add(-(int)po[y].coeff.get(i));
                	po[z].exponent.add((int)po[y].exponent.get(i));
            	}
            }
            int[][] arr=new int [po[z].coeff.size()][2];
            for(int i=0;i<po[z].coeff.size();i++){
                    arr[i][0]=(int)po[z].coeff.get(i);
                    arr[i][1]=(int)po[z].exponent.get(i);
            }
                        BubbleSort(arr);
            setPolynomial('R',arr);
                  return arr;
    }

    public int[][] multiply(char poly1, char poly2) {
        int z = 3;
        int x = terns(poly1);
        int y = terns(poly2);
        int size1 = po[x].coeff.size();
        int size2 = po[y].coeff.size();
        int row = 0;
        int coloum = 0;
            row = size1;
            coloum = size2;
      	// multiplay the polonomial coeff and calculate sum of exp
        for (int count = 0; count < row; count++) {
            for (int count_2 = 0; count_2 < coloum; count_2++) {
                int k =(int) po[x].coeff.get(count) * (int)po[y].coeff.get(count_2);
                int k2 = (int)po[x].exponent.get(count) + (int)po[y].exponent.get(count_2);
                po[z].coeff.add(k);
                po[z].exponent.add(k2);
            }
        }
        //check if there are repeated exp and add them 
        for (int count = 0; count < po[z].exponent.size(); count++) {
            for (int count2 = count + 1; count2 < po[z].exponent.size(); count2++) {
                if (po[z].exponent.get(count) == po[z].exponent.get(count2)) {
                    int num = (int)po[z].coeff.get(count) + (int)po[z].coeff.get(count2);
                    po[z].coeff.set(count, num);
                    po[z].coeff.remove(count2);
                    po[z].exponent.remove(count2);
                }
            }
        }
        // put it in array 2D of 2 coloums one for coeff and another for exp
        int[][] arr = new int[po[z].coeff.size()][2];
        for (int i = 0; i < po[z].coeff.size(); i++) {
            arr[i][0] = (int)po[z].coeff.get(i);
            arr[i][1] = (int)po[z].exponent.get(i);
        }
                    BubbleSort(arr);
            setPolynomial('R',arr);
        return arr;
    }
}
