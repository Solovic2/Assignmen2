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
public interface IPolynomialSolver {
    
    /**
* Set polynomial terms (coefficients & exponents)
* @param poly
* name of the polynomial
* @param terms
* array of [coefficients][exponents]
*/
public void setPolynomial(char poly, int[][] terms);
/**
* Print the polynomial in ordered human readable representation
* @param poly
* name of the polynomial
* @return polynomial in the form like 27x^2+x-1
*/
public String print(char poly);
/**
* Clear the polynomial
* @param poly
* name of the polynomial
*/
public void clearPolynomial(char poly);
/**
* Evaluate the polynomial
* @param poly
* name of the polynomial
* @param value
* polynomial constant value
* @return the value of the polynomial
*/
public float evaluatePolynomial(char poly, float value);
/**
* Add two polynomials
* @param poly1
* first polynomial
* @param poly2
* second polynomial
* @return the result polynomial
*/
public int[][] add(char poly1, char poly2);
/**
* Subtract two polynomials
* @param poly1
* first polynomial
* @param poly2
* second polynomial
* @return the result polynomial
*/
public int[][] subtract(char poly1, char poly2);
/**
* Multiply two polynomials
* @param poly1
* first polynomial
* @param poly2
* second polynomial
* @return the result polynomial
*/
public int[][] multiply(char poly1, char poly2);
}
