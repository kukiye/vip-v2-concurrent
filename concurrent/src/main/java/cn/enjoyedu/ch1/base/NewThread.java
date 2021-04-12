package cn.enjoyedu.ch1.base;

import java.util.concurrent.ExecutionException;

/**
 * 类说明：新启线程的方式
 */
public class NewThread {
    /*扩展自Thread类*/
    private static class UseThread extends Thread {
        @Override
        public void run() {
            super.run();
            // do my work;
            System.out.println("I am extendec Thread");
        }
    }


    /*实现Runnable接口*/
    private static class UseRunnable implements Runnable {

        @Override
        public void run() {
            // do my work;
            System.out.println("I am implements Runnable");
        }
    }


    public static void main(String[] args)
            throws InterruptedException, ExecutionException {
        UseThread useThread = new UseThread();
        //start()方法里面的start0()方法，是线程申请CPU使用权。获得CPU占有权后，就会去执行run方法，在子线程执行。
        useThread.start();

        //run方法是线程的一个普通方法，直接调用是在调用者的线程里，而不会在子线程执行。调用多次都可以
//        useThread.run();

        //调用两次报错 java.lang.IllegalThreadStateException
        //useThread.start();

        UseRunnable useRunnable = new UseRunnable();
        new Thread(useRunnable).start();


    }
}
