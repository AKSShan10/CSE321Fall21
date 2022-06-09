class FirstHalfEven extends Thread{
    long [] array = new long[9];

    long  sum = 0;
    public FirstHalfEven(long [] arr){
        //super(arr);
        array = arr;
    }

    @Override
    public void run() {
        for(int i=0;i<9;i++){
            sum=sum+ array[i];
        }
        System.out.println(sum);
        sum = sum/9;
        System.out.println(sum);

    }

    public long getValue(){
        return sum;
    }

}
class FirstHalfOdd extends Thread{
    long [] array = new long[9];

    long  sum = 0;
    public FirstHalfOdd(long [] arr){
        //super(arr);
        array = arr;
    }

    @Override
    public void run() {
        for(int i=0;i<16;i++){
            sum=sum+ array[i];
        }
        System.out.println(sum);
        sum = sum/16;
        System.out.println(sum);

    }

    public long getValue(){
        return sum;
    }

}

class SecondHalfEven extends Thread{
    long [] array = new long[9];

    long  sum = 0;
    public SecondHalfEven(long [] arr){
        //super(arr);
        array = arr;
    }

    @Override
    public void run() {
        for(int i=0;i<8;i++){
            sum=sum+ array[i];
        }
        System.out.println(sum);
        sum = sum/8;
        System.out.println(sum);

    }

    public long getValue(){
        return sum;
    }

}

class SecondHalfOdd extends Thread{
    long [] array = new long[9];

    long  sum = 0;
    public SecondHalfOdd (long [] arr){
        //super(arr);
        array = arr;
    }

    @Override
    public void run() {
        for(int i=0;i<17;i++){
            sum=sum+ array[i];
        }
        System.out.println(sum);
        sum = sum/17;
        System.out.println(sum);

    }

    public long getValue(){
        return sum;
    }

}
class Average extends Thread{
    long sum,value1, value2, value3, value4;

    public Average (long val1, long val2, long val3, long val4){
        value1=val1;
        value2= val2;
        value3 = val3;
        value4 = val4;


    }

    @Override
    public void run() {
         sum = value1+value2+value3+value4;
         sum = sum/4;

    }

    public long getValue(){
        return sum;
    }

}

public class Task03 {
    public static void main(String[]args){

        long First_position=0,second_position=1,temp;

        long array [] = new long[50];
        array[0] = 0;
        array[1]= 1;

        for(int i=2;i<50;i++) {
            temp = First_position + second_position;
            array[i] = temp;
            //System.out.println(array[i]+" ");
            First_position=second_position;
            second_position = temp;
        }
       // for(int i =0; i< array.length;i++){
        //    System.out.println(array[i]);
       // }
        long first_half_odd [] = new long[16];
        long first_half_even [] = new long[9];
        long second_half_odd [] = new long[17];
        long second_half_even [] = new long[8];

        int count1=0, count2=0, count3=0,count4=0;

        for(int i = 0; i<25; i++){
            if(array[i]%2==0) {
                first_half_even[count1] = array[i];
                //System.out.println(first_half_even[count1]);
                count1++;
            }
            else {
                first_half_odd[count2] = array[i];
                //System.out.println(first_half_odd[count2]);
                count2++;
            }
        }

        for(int i = 25; i<50; i++){
            if(array[i]%2==0) {
                second_half_even[count3] = array[i];
                //System.out.println(second_half_even[count3]);
                count3++;
            }
            else {
                second_half_odd[count4] = array[i];
                //System.out.println();
               // System.out.println(second_half_odd[count4]);
                count4++;
            }
        }

        FirstHalfEven firstEven = new FirstHalfEven(first_half_even);
        firstEven.start();
        FirstHalfOdd firstOdd = new FirstHalfOdd(first_half_odd);
        firstOdd.start();
        SecondHalfOdd secondOdd = new SecondHalfOdd(second_half_odd);
        secondOdd.start();
        SecondHalfEven secondEven = new SecondHalfEven(second_half_even);
        secondEven.start();
        try{
            firstEven.join();
            firstOdd.join();
            secondOdd.join();
            secondEven.join();
            //average.join();
        }catch(Exception e){
            System.out.println("Exception" + e );
        }
        long value1 = firstEven.getValue();
        long value2 = firstOdd.getValue();
        long value3 = secondOdd.getValue();
        long value4 = secondEven.getValue();


        System.out.println(value1);
        System.out.println(value2);
        System.out.println(value3);
        System.out.println(value4);
        Average average = new Average(value1, value2, value3, value4);
        average.start();
        try{
            average.join();
        }catch(Exception e){
            System.out.println("Exception" + e );
        }
        long avg = average.getValue();
        System.out.println("Mean value: "+avg);
    }
}
