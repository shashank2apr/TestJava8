package test.java8.asynch;

import java.io.ObjectInputStream.GetField;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestAsync {
	public static void main(String[] args) {

		ExecutorService pool = Executors.newFixedThreadPool(10);
		
		//usingFuture(pool); 
					
		//usingCompletableFuture(pool);
		
		usingFluentProgramming(pool);
		
		
		System.out.println("End of Main!");
		
		sleepForOneSec();
		sleepForOneSec();
		sleepForOneSec();
		sleepForOneSec();
		sleepForOneSec();
		
		pool.shutdown();
	}

	/**
	 * @param pool
	 */
	private static void usingFluentProgramming(ExecutorService pool) {
		
		CompletableFuture
		.supplyAsync((()->{	sleepForOneSec();return "FromCallable";}), pool)
		.thenAcceptAsync((x) -> {
			System.out.println("Consumer printing : " + x);
		})
		.thenRun(()->{System.out.println("Send Notfication!"+Thread.currentThread());});
	}

	private static void usingCompletableFuture(ExecutorService pool) {
		
		CompletableFuture<String> future = CompletableFuture
				.supplyAsync((()->{	sleepForOneSec();return "FromCallable";}), pool);
		
		future.thenAcceptAsync((x) -> {
			System.out.println("Consumer printing : " + x);
		});
		
	}

	/**
	 * @param pool
	 */
	private static void usingFuture(ExecutorService pool) {
		
		Future<String> future = pool.submit(new Callable<String>() {	
			@Override
			public String call() throws Exception {
				sleepForOneSec();
				return "FromCallable";
			}
		});
		
		System.out.println("In between");
		
		try {
			System.out.println(future.get());
		} catch (InterruptedException |ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	private static void sleepForOneSec() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
