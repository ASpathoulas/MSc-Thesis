public class Data3 implements Runnable {
    int d = 42;

    public void run () {
         doSomething(1001);
         d = 0; // (1)

    }


    public static void main (String[] args){
         Data3 racer = new Data3();
         Thread t = new Thread(racer);
         t.start();

         doSomething(1000);
         int c = 420 / racer.d;              // (2)
         System.out.println(c);
    }

    static void doSomething (int n) {
         try { Thread.sleep(n); } catch (InterruptedException ix) {}
    }
}
