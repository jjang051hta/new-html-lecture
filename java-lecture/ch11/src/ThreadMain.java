public class ThreadMain {
    public static void main(String[] args) {
        // main 자체가 thread이다.
        // Thread.currentThread().setPriority(10);
        System.out.println("name ==" + Thread.currentThread().getName());
        System.out.println("Priority==" + Thread.currentThread().getPriority());
        System.out.println("state==" + Thread.currentThread().getState());
        System.out.println("id==" + Thread.currentThread().getId());

        // while (true) {
        // System.out.print("=");
        // }
        // for (int i = 0; i < 100; i++) {
        // System.out.print("|");
        // }

        Thread thread01 = new Thread(new Runnable() {
            @Override
            public void run() {
                int num = 0;
                for (int i = 0; i < 100; i++) {
                    // num++;
                    System.out.print("=");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread thread02 = new Thread(new Runnable() {
            @Override
            public void run() {
                int num = 0;
                for (int i = 0; i < 100; i++) {
                    // num++;
                    System.out.print("|");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread01.start();
        thread02.start();
    }
}
