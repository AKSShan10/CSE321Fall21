class House_Stark extends Thread{

    public House_Stark(String name){
        super(name);
    }

    @Override
    public void run(){
        System.out.println("The house is : "+ getName());
        try {
            sleep(1000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

    }

}
class House_Targaryen extends Thread{

    public House_Targaryen(String name){
        super(name);
    }

    @Override
    public void run(){
        System.out.println("The house is : "+ getName());
        try {
            sleep(1000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

    }

}
class House_Lannister extends Thread{

    public  House_Lannister(String name){
        super(name);
    }

    @Override
    public void run(){
        System.out.println("The house is : "+ getName());
        try {
            sleep(3000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

    }

}
class House_Bolton extends Thread{

    public House_Bolton(String name){
        super(name);
    }

    @Override
    public void run(){
        System.out.println("The house is : "+ getName());
        try {
            sleep(3000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

    }

}
class House_Tyrell extends Thread{

    public House_Tyrell(String name){
        super(name);
    }

    @Override
    public void run(){
        System.out.println("The house is : "+ getName());
        try {
            sleep(5000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

    }

}


public class Task02_Final {
    public static void main(String[]args){
        House_Stark stark = new House_Stark("House Stark");
        House_Targaryen targaryen = new House_Targaryen("House Targaryen");
        House_Lannister lannister = new House_Lannister("House Lannister");
        House_Bolton bolton = new House_Bolton("House Bolton");
        House_Tyrell tyrell = new House_Tyrell("House Tyrell");
        //System.out.println("Run");
        stark.run();
        targaryen.run();
        lannister.run();
        bolton.run();

        //System.out.println("Start");
        stark.start();
        tyrell.start();
        lannister.start();
        bolton.start();

        try{
            stark.join();
            //targaryen.join();
            lannister.join();
            bolton.join();
            //tyrell.join();
        }catch(Exception e){
            System.out.println("Exception" + e );
        }
        if(stark.isAlive())
            System.out.println("Not Today!");

        if(!bolton.isAlive())
           System.out.println("You know nothing!");


    }
}
