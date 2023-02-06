package Java.Thread.thread_20221123;

public class poker {

    static volatile boolean notice = false;
    static volatile boolean check = false;


    public static void main(String[] args) {



        Thread thread_001 = new Thread(() -> {
            while (true){
                if(notice == true) {
                    System.out.println("you can bottom pour");
                    break;
                }
            }
        });

        Thread thread_002 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " : " + i + " : " + notice);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }


            notice = true;
            System.out.println(notice);
        });


        thread_002.start();
        thread_001.start();



    }


}

class Thread_poker implements Runnable{

    private boolean notice;

    public Thread_poker(boolean notice) {

        this.notice = notice;

    }

    @Override
    public void run() {

        while (notice == true){
            System.out.println("you can bottom pour");
        }

    }

}
