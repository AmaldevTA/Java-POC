package lamal.threadpool.sigle_thread_cancel_old_task_on_new_submit;

import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class InterruptingExecutorService extends ThreadPoolExecutor{
    private volatile FutureTask<?> currentFuture;

    public InterruptingExecutorService(boolean daemon) {
        super(0, 1, 5000, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(), 
                daemon ? new DaemonThreadFactory() : Executors.defaultThreadFactory());

    }

    public static class DaemonThreadFactory implements ThreadFactory{
        ThreadFactory delegate = Executors.defaultThreadFactory();

        @Override
        public Thread newThread(Runnable r) {
            Thread t = delegate.newThread(r);
            t.setDaemon(true);
            return t;
        }

    }

    private void cancelCurrentFuture(){
        // cancel all pending tasks
        Iterator<Runnable> it = getQueue().iterator();
        while(it.hasNext()){
            FutureTask<?> task = (FutureTask<?>)it.next();
            task.cancel(true);
            it.remove();
        }

        // cancel the current task
        FutureTask<?> currentFuture = this.currentFuture;
        if(currentFuture != null){
            currentFuture.cancel(true);
        }
    }

    @Override
    public void execute(Runnable command) {
        if (command == null) throw new NullPointerException();

        cancelCurrentFuture();
        if (!(command instanceof FutureTask)){ // we have to be able to cancel a task, so we have to wrap any non Future
            command = newTaskFor(command, null);
        }
        super.execute(command);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        // it is safe to access currentFuture like this b/c we have limited the # of worker threads to only 1
        // it isn't possible for currentFuture to be set by any other thread than the one calling this method
        this.currentFuture = (FutureTask<?>)r;
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        // it is safe to access currentFuture like this b/c we have limited the # of worker threads to only 1
        // it isn't possible for currentFuture to be set by any other thread than the one calling this method
        this.currentFuture = null;
    }
}
