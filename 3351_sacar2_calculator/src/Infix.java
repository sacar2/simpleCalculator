/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author isacar
 */
public class Infix {
    
    public final static char add = '+';
    public final static char subtract = '-';
    public final static char multiply = '*';
    public final static char divide = '/';
    public final static char equals = '=';
    //one of the input numbers
    private static int num = 0;
    //if the display has been cleared
    private static boolean clrnum = true;   
    //answer
    private static int ans = 0;
    //if decimal is used
    private static boolean dec = false;
    //if decimal is used
    private static char opr;

    //default constructor
    public Infix(){}

    // *************************    0123456789    *****************************
    public String forEachNum(int key){
        // get the input to be displayed
        String numberToDisplay = dispNum(key);
        System.out.println("INPUT: " + numberToDisplay);
        //find what ans is equal to
        calcAns();
        return numberToDisplay;
    }
    
            // ***********************   DISPLAY NUM = NUM KEY   **********************
            private String dispNum(int key){
                System.out.println("num before = " + num);
                String newnum;
                if (num==0) {
                    
                    newnum = String.valueOf(key);
                }
                else {
                    newnum = Integer.toString(num)+Integer.toString(key);
                }
                System.out.println("new number = " + newnum);
                num = Integer.parseInt(newnum);
                return newnum;
            }

            // ************************   CALCULTE WHAT ANSWER IS   *******************
            private void calcAns(){
                // if the display was cleared prior to this sequence of numbers
                //then the answer is the number! 
                if (clrnum== true){
                    ans = num;
                }
                else{
                    // if not cleared, it is the operation on the numbers!
                    //findout what ans is equal to
                    switch(opr){
                        case add: ans += num;
                            break;
                        case subtract: ans -= num;
                            break;
                        case multiply: ans *= num;
                            break;
                        case divide: ans /= num;
                            break;
                        case '=': //go to the DISP NUM = ans state!!!
                            break;
                    }
                }
                System.out.println("answer = " + ans);
            }
    
    // *********************      =     *********************
    public String equalPressed(){
        String dispStr = String.valueOf(ans);
        dec = false;
        setClrNum(true);
        return dispStr;
    }
    
    // *********************    + - / *   ********************************
    public String operatorPressed(char key){
        String strToDisp = String.valueOf(ans);
        opr = key;
        num = 0;
        setClrNum(false);
        System.out.println("opr = " + opr);
        return strToDisp;
    }
    
    // ********************* Check if there's already a . *********************
    public int checkForDecimal(){
        if (dec==false){
            dec=true;            
        }
        if (num%0 ==0){
        }
        return num;
    }
   
    // ********************* getters/setters ********************* 

    //one of the input numbers
    public int getNum() {
        return num;
    }
    public void setNum(int newnum){
        num = newnum;
        return;
    }
    //if the display has been cleared
    public boolean getClrNum(){
        return clrnum;
    }
    public void setClrNum(boolean clr){
        clrnum = clr;
        num = 0;
        return;
    }
    //answer
    public int getAns() {
        return ans;
    }
    public void setAns(int newans){
        ans = newans;
        return;
    }
    
    public void setDec(boolean decnew){
        dec = decnew;
        return;
    }
    public void setOpr(char newop){
        opr = newop;
        return;
    }
    
    
}
