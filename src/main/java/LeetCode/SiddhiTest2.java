package LeetCode;

class reverseGreeting extends Thread
{
    private int counter;
    public reverseGreeting(int counter)
    {
        super("Thread" + counter);
        this.counter = counter;
    }

    public void run()
    {
        counter++ ;
        if(counter <= 51)
        {
            reverseGreeting thr = new reverseGreeting(counter);
            thr.start();
            try {
                thr.join();
                System.out.println("Hello from "+ getName());
            }
            catch (Exception e)
            {
                //do smth
            }
        }
    }
}
public class SiddhiTest2 {
    public static void main(String[] args) {
        reverseGreeting rr = new reverseGreeting(1);
        rr.start();
    }
}
