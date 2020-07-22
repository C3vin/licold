public class DiningPhilosopher {

    public static void main(String[] args) {
        
        Semaphore chopsticks[];
        Philosopher philosopher[];
        
        int K = 7;      //////// --> you can initiate to any integer number 
 
        chopsticks=new Semaphore[K];   //////// --> Create an array of K Semaphores  
 
        for (int i=0; i<5;i++){   //////// -->   Create K  Semaphore objects and assign to the array
            chopsticks[i] =new Semaphore(1);    //////// --> Semaphore initial value=1
        }
         
        philosopher = new Philosopher[K];    //////// -->  Create an array of five philosopher thread object reference handles
 
        for(int i=0;i<K;i++)   //////// --> Create and initiate K philosopher Thread objects
        {
            philosopher[i] = new Philosopher(i,chopsticks);
            philosopher[i].start();
        }
    }
}

class Semaphore{
    private int value;

    public Semaphore(int value)
    {
        this.value=value;

    }

    public synchronized void p()
    {
        while(value==0)
        {
            try {
                System.out.println("chopStick not available");
                wait();         /////////->  The calling thread waits until semaphore becomes free
            }catch (InterruptedException e){}
        }
        value=value-1;
    }
    public synchronized void v()
    {
        value=value+1;
        notify();
    }
}
class Philosopher extends Thread
{
    private int myName;
    private Semaphore chopsticks[];

    //Executes when a philosopher thread us first created
    public Philosopher(int myName,Semaphore chopsticks[]){
        this.myName=myName;
        this.chopsticks=chopsticks;
    }

    //This is what each philosopher thread executes
    public void run()
    {
        while (true)
        {
            System.out.println("philosopher "+ myName+" thinking");
            try{
                Thread.sleep(new Random().nextInt(100)+50);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Philosopher "+myName+" hungry.");

            chopsticks[myName].p(); //Acquire right chopstick
            System.out.println("Philosopher takes the chopstick: "+myName);

            chopsticks[(myName+1)%5].p(); //Acquire left chopstick
            System.out.println("Philosopher takes the chopstick: "+(myName+1)%5);

            System.out.println("Philosophers "+myName+" eating");
            try{
                Thread.sleep(new Random().nextInt(100)+50);
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            chopsticks[myName].v();// release right chopstick
            System.out.println("Philosopher releases the chopstick: "+myName);

            chopsticks[(myName+1)%5].v();//release left chopstick
            System.out.println("Philosopher releases the chopstick: "+(myName+1)%)5;

        }
    }
}