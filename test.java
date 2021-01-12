Thread和Runnable的区别

如果一个类继承Thread，则不适合资源共享。

但是如果实现了Runable接口的话，则很容易的实现资源共享。

总结：

实现Runnable接口比继承Thread类所具有的优势：

1）：适合多个相同的程序代码的线程去处理同一个资源

2）：可以避免java中的单继承的限制

3）：增加程序的健壮性，代码可以被多个线程共享，代码和数据独立

4）：线程池只能放入实现Runable或callable类线程，不能直接放入继承Thread的类



提醒一下大家：main方法其实也是一个线程。在java中所以的线程都是同时启动的，至于什么时候，哪个先执行，完全看谁先得到CPU的资源。

在java中，每次程序运行至少启动2个线程。一个是main线程，一个是垃圾收集线程。因为每当使用java命令执行一个类的时候，实际上都会启动一个JVM - 操作系统中的一个进程。



1、新建状态（New）：新创建了一个线程对象。

2、就绪状态（Runnable）：线程对象创建后，其他线程调用了该对象的start()方法。该状态的线程位于可运行线程池中，变得可运行，等待获取CPU的使用权。

3、运行状态（Running）：就绪状态的线程获取了CPU，执行程序代码。

4、阻塞状态（Blocked）：阻塞状态是线程因为某种原因放弃CPU使用权，暂时停止运行。直到线程进入就绪状态，才有机会转到运行状态。阻塞的情况分三种：

（一）、等待阻塞：运行的线程执行wait()方法，JVM会把该线程放入等待池中。(wait会释放持有的锁)
（二）、同步阻塞：运行的线程在获取对象的同步锁时，若该同步锁被别的线程占用，则JVM会把该线程放入锁池中。
（三）、其他阻塞：运行的线程执行sleep()或join()方法，或者发出了I/O请求时，JVM会把该线程置为阻塞状态。当sleep()状态超时、join()等待线程终止或者超时、或者I/O处理完毕时，线程重新转入就绪状态。（注意,sleep是不会释放持有的锁）

5、死亡状态（Dead）：线程执行完了或者因异常退出了run()方法，该线程结束生命周期。
















线程调度
 
1、调整线程优先级：Java线程有优先级，优先级高的线程会获得较多的运行机会。
 
Java线程的优先级用整数表示，取值范围是1~10，Thread类有以下三个静态常量：
static int MAX_PRIORITY
          线程可以具有的最高优先级，取值为10。
static int MIN_PRIORITY
          线程可以具有的最低优先级，取值为1。
static int NORM_PRIORITY
          分配给线程的默认优先级，取值为5。

Thread类的setPriority()和getPriority()方法分别用来设置和获取线程的优先级。
 每个线程都有默认的优先级。主线程的默认优先级为Thread.NORM_PRIORITY。
 
线程的优先级有继承关系，比如A线程中创建了B线程，那么B将和A具有相同的优先级。

JVM提供了10个线程优先级，但与常见的操作系统都不能很好的映射。如果希望程序能移植到各个操作系统中，应该仅仅使用Thread类有以下三个静态常量作为优先级，这样能保证同样的优先级采用了同样的调度方式。
 
2、线程睡眠：Thread.sleep(long millis)方法，使线程转到阻塞状态。millis参数设定睡眠的时间，以毫秒为单位。当睡眠结束后，就转为就绪（Runnable）状态。sleep()平台移植性好。
 
3、线程等待：Object类中的wait()方法，导致当前的线程等待，直到其他线程调用此对象的 notify() 方法或 notifyAll() 唤醒方法。这个两个唤醒方法也是Object类中的方法，行为等价于调用 wait(0) 一样。
 
4、线程让步：Thread.yield() 方法，暂停当前正在执行的线程对象，把执行机会让给相同或者更高优先级的线程。
 
5、线程加入：join()方法，等待其他线程终止。在当前线程中调用另一个线程的join()方法，则当前线程转入阻塞状态，直到另一个进程运行结束，当前线程再由阻塞转为就绪状态。
 
6、线程唤醒：Object类中的notify()方法，唤醒在此对象监视器上等待的单个线程。如果所有线程都在此对象上等待，则会选择唤醒其中一个线程。选择是任意性的，并在对实现做出决定时发生。线程通过调用其中一个 wait 方法，在对象的监视器上等待。 

直到当前的线程放弃此对象上的锁定，才能继续执行被唤醒的线程。被唤醒的线程将以常规方式与在该对象上主动同步的其他所有线程进行竞争；例如，唤醒的线程在作为锁定此对象的下一个线程方面没有可靠的特权或劣势。类似的方法还有一个notifyAll()，唤醒在此对象监视器上等待的所有线程。















常用函数说明
①sleep(long millis): 在指定的毫秒数内让当前正在执行的线程休眠（暂停执行）

②join():指等待t线程终止。
 
join是Thread类的一个方法，启动线程后直接调用，即join()的作用是：“等待该线程终止”，这里需要理解的就是该线程是指的主线程等待子线程的终止。也就是在子线程调用了join()方法后面的代码，只有等到子线程结束了才能执行。

Thread t = new AThread(); t.start(); t.join();

为什么要用join()方法
在很多情况下，主线程生成并起动了子线程，如果子线程里要进行大量的耗时的运算，主线程往往将于子线程之前结束，但是如果主线程处理完其他的事务后，需要用到子线程的处理结果，也就是主线程需要等待子线程执行完成之后再结束，这个时候就要用到join()方法了。

不加join。






////  ----->>> no join 
class Thread1 extends Thread{

	private String name;
    
    public Thread1(String name) {
    	super(name);
       this.name=name;
    }
    
	public void run() {
		System.out.println(Thread.currentThread().getName() + " 线程运行开始!");
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程"+name + "运行 : " + i);
            try {
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " 线程运行结束!");
	}
}
 
public class Main {
 
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+"主线程运行开始!");
		Thread1 mTh1=new Thread1("A");
		Thread1 mTh2=new Thread1("B");
		mTh1.start();
		mTh2.start();
		System.out.println(Thread.currentThread().getName()+ "主线程运行结束!");
 
	}
}

 
输出结果：
main主线程运行开始!
main主线程运行结束!
B 线程运行开始!
子线程B运行 : 0
A 线程运行开始!
子线程A运行 : 0
子线程B运行 : 1
子线程A运行 : 1
子线程A运行 : 2
子线程A运行 : 3
子线程A运行 : 4
A 线程运行结束!
子线程B运行 : 2
子线程B运行 : 3
子线程B运行 : 4
B 线程运行结束!
发现主线程比子线程早结束


////  ----->>> with join


public class Main {
 
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+"主线程运行开始!");
		Thread1 mTh1=new Thread1("A");
		Thread1 mTh2=new Thread1("B");
		mTh1.start();
		mTh2.start();
		try {
			mTh1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			mTh2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+ "主线程运行结束!");
 
	}
 
}


运行结果：
main主线程运行开始!
A 线程运行开始!
子线程A运行 : 0
B 线程运行开始!
子线程B运行 : 0
子线程A运行 : 1
子线程B运行 : 1
子线程A运行 : 2
子线程B运行 : 2
子线程A运行 : 3
子线程B运行 : 3
子线程A运行 : 4
子线程B运行 : 4
A 线程运行结束!
主线程一定会等子线程都结束了才结束


////  ----->>> yield
yield():暂停当前正在执行的线程对象，并执行其他线程。
        Thread.yield()方法作用是：暂停当前正在执行的线程对象，并执行其他线程。
          yield()应该做的是让当前运行线程回到可运行状态，以允许具有相同优先级的其他线程获得运行机会。因此，使用yield()的目的是让相同优先级的线程之间能适当的轮转执行。但是，实际中无法保证yield()达到让步目的，因为让步的线程还有可能被线程调度程序再次选中。
 
结论：yield()从未导致线程转到等待/睡眠/阻塞状态。在大多数情况下，yield()将导致线程从运行状态转到可运行状态，但有可能没有效果。可看上面的图。


































































































































































































































































