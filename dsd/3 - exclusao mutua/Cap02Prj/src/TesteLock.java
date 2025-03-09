import java.util.Random;
public class TesteLock extends Thread {
    private int myId;
    private Lock lock;
    private Random r = new Random();
    public TesteLock(int id, Lock lock) {
        myId = id;
        this.lock = lock;
    }
    private void nonCriticalSection() {
        System.out.println(myId + " n�o est� na CS");
        Util.mySleep(r.nextInt(1000));
    }
    private void CriticalSection() {
        System.out.println(myId + " entrou na CS *****");
        // critical section code
        Util.mySleep(r.nextInt(1000));
        System.out.println(myId + " saiu da CS *****");
    }
    public void run() {
        while (true) {
            lock.requestCS(myId);
            CriticalSection();
            lock.releaseCS(myId);
            nonCriticalSection();
        }
    }
    public static void main(String[] args) throws Exception {
        
        int N = Integer.parseInt(args[0]);

        TesteLock t[];

        t = new TesteLock[N];
        Lock lock = new TestAndSetLock();//implementa��o desejada
        for (int i = 0; i < N; i++) {
            t[i] = new TesteLock(i, lock);
            t[i].start();
        }
    }
}
