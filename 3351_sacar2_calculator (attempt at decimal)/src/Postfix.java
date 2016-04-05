/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Stack;

/**
 *
 * @author isacar
 */
public class Postfix {
    public final static char add = '+';
    public final static char subtract = '-';
    public final static char multiply = '*';
    public final static char divide = '/';
    public final static char equals = '=';
    //answer
    private static double ans = 0;
    private static double num1 = 0;
    private static double num2 = 0;
    //if decimal is used
    private static boolean dec = false;  
    //if push2 state
    private static boolean push2 = false;  
    //stack to store integers
    private Stack<Double> stack;

    //default constructor
    public Postfix(){}

    // *************************    0123456789    *****************************
    public String forEachNum(double key){
        push2 = false;
        String newnum;
        if (ans==0) {
            newnum = String.valueOf(key);
        }else {
            newnum = Double.toString(ans)+Double.toString(key);
        }
        System.out.println("INPUT: " + newnum);
        ans = Double.parseDouble(newnum);
        //find what ans is equal to
        return newnum;
    }

            
    // *********************      =     *********************
    public String equalPressed(){
        if(push2 ==true){
             ans = stack.peek();
        }
        stack.push(ans);
        String toDisp = String.valueOf(ans);
        ans = 0;
        dec = false;
        return String.valueOf(toDisp);
    }
    
    // *********************    + - / *   ********************************
    public String operatorPressed(char key){
        push2 = true;
        num2 = stack.pop();
        num1 = stack.pop();
        String newnum = Double.toString(num1)+Double.toString(key)+Double.toString(num2);
        ans = Double.parseDouble(newnum);
        System.out.println("INPUT: " + ans);
        stack.push(ans);
        ans = 0 ;        
        return newnum;
    }
    
    // ********************* Check if there's already a . *********************
    public double checkForDecimal(){
        if (dec==false){
            dec=true;
        }
        return ans;
    }
}
