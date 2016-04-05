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
    public static int ans = 0;
    public static int num1 = 0;
    public static int num2 = 0;
    //if decimal is used
    public static boolean dec = false;  
    //if push2 state
    public static boolean push2 = false;  
    //stack to store integers
    public Stack<Integer> stack;

    //default constructor
    public Postfix(){}

    // *************************    0123456789    *****************************
    public String forEachNum(int key){
        push2 = false;
        String newnum;
        if (ans==0) {
            newnum = String.valueOf(key);
        }else {
            newnum = Integer.toString(ans)+Integer.toString(key);
        }
        System.out.println("INPUT: " + newnum);
        ans = Integer.parseInt(newnum);
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
        String newnum = Integer.toString(num1)+Integer.toString(key)+Integer.toString(num2);
        ans = Integer.parseInt(newnum);
        System.out.println("INPUT: " + ans);
        stack.push(ans);
        ans = 0 ;        
        return newnum;
    }
    
    // ********************* Check if there's already a . *********************
    public int checkForDecimal(){
        if (dec==false){
            dec=true;
        }
        return ans;
    }
    public void clrAns() {
        ans = 0;
    }
    public void clrnum1(){
        num1 = 0;
    }
    public void clrnum2(){
        num2 = 0;
    }
    //if decimal is used
    public void clrdec (){
       dec = false; 
    }  
    //if push2 state
    public void clrpush2(){
        push2 = false;
    }  
    //stack to store integers
    public void clrstack(){
        stack.clear();
    }
}
