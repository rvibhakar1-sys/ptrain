
import java.util.Scanner;
public class ifelse {
    public static void main(String[] args) {
        
        
        if(5==6)
             System.out.println("true");



        if(true)
            System.out.println("true");
        else
            System.out.println("false");



        if(false)
            System.out.println("hello world");
            System.out.println("hi");


        
        if(5==5){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
     

    
               if(false){
                    System.out.println("true");
                }else{
                    System.out.println("false");
                }
///////////////////////////////////////////////////////////////////////

/*100 units o rupee
200 -500 units per 5 rupee
501-1000 units per 8 rupee
1000-above units per 8 rupee
*/

    Scanner scan = new Scanner(System.in);
    System.out.println("Enter unit:");
    int unit=scan.nextInt();
    if(unit<=100){
        System.out.println("free no bill");
    }else if(unit >100 && unit<=500){
        System.out.println("bill is: "+unit*5);
    }else if(unit >500 && unit<=1000){
        System.out.println("The bill is: "+unit*8);
    }else if(unit>1000){
        System.out.println("The bill is: "+unit*10);
    }
    System.out.println("Enter unit:");
    int u=scan.nextInt();
int bill= (u<=100)? 0:(u>200 && u<=500) ? u*5 : (u>500&&u<=1000) ? u*8:u*10;
System.out.println(bill);


}
}

