import java.util.*;

class Task01Thread extends Thread{
    //Scanner var = new Scanner(System.in);
    int n1,n2;
    String thread;
    public Task01Thread(String name, int a, int b){
        super(name);
        thread = name;
        n1= a;
        n2 = b;
    }

    @Override
    public void run(){
        int addition, subtraction, multiplication, division;

         if(thread == "add"){
             addition = n1+n2;
             System.out.println("Addition value: "+addition);
             System.out.println("Threrad name: "+Thread.currentThread().getName());
         }
        else if(thread == "sub"){
            subtraction = n1-n2;
            System.out.println("Subtraction value: "+subtraction);
            System.out.println("Threrad name: "+Thread.currentThread().getName());
        }
         else if(thread == "mul"){
             multiplication = n1*n2;
             System.out.println("Multiplication value: "+multiplication);
             System.out.println("Threrad name: "+Thread.currentThread().getName());
         }
         else if(thread == "div"){
             division = n1/n2;
             System.out.println("Division value: "+division);
             System.out.println("Threrad name: "+Thread.currentThread().getName());
         }
         else {
             System.out.println("oth: No valid operation");
             System.out.println("Threrad name: " + Thread.currentThread().getName());
         }

    }

}
public class Task01_Final {
    public static void main(String [] args){
        Scanner var = new Scanner(System.in);
        System.out.println("Please enter a number");
        int n1 = var.nextInt();

        System.out.println("Please enter a number");
        int n2 = var.nextInt();

        //System.out.println("Please enter a user input");
        //String input = var.nextLine();

        Task01Thread addition = new Task01Thread("add", n1, n2);
        Task01Thread subtraction = new Task01Thread("sub", n1,n2);
        Task01Thread multiplication = new Task01Thread("mul", n1,n2);
        Task01Thread division = new Task01Thread("div",n1,n2);
        Task01Thread other = new Task01Thread("oth", n1, n2);

        addition.start();
        subtraction.start();
        multiplication.start();
        division.start();
        other.start();
    }
}
