package com.practice.demo.future;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class AsyncExecutorService<T> extends CompletableFuture<T> implements ScheduledExecutorService{
	
	private Executor executor;
	private Integer noOfThreads;
	private Boolean useDefaultExecutor;
	private List<AsyncExecutorService<T>> allFutures = new ArrayList<>();
//	private ThreadFactory threadFactory;
	
	public AsyncExecutorService() {
//		threadFactory = Thread.currentThread();
		if(useDefaultExecutor==null)
			executor = this.defaultExecutor();
		else {
			if(noOfThreads!=null)
				executor = Executors.newFixedThreadPool(noOfThreads);
			else
				executor = Executors.newCachedThreadPool();
		}
	}

	public AsyncExecutorService<T> supplyAsyncExecution(Supplier<T> supplier) {
		AsyncExecutorService<T> future = null;
		try {
			if(executor==null)
				future = (AsyncExecutorService<T>) supplyAsync(supplier);
			future =  (AsyncExecutorService<T>) supplyAsync(supplier, executor);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return future;
    }
	
	@Override
	public CompletableFuture<Void> thenAccept(Consumer<? super T> action) {
		// TODO Auto-generated method stub
		return super.thenAccept(action);
	}
	
	public List<T> getAll() {
		List<T> list = new ArrayList<>();
		allFutures.forEach(future -> {
			try {
				list.add(future.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		});
		return list;
	}
	
	public AsyncExecutorService<T> addToFutureList() {
		allFutures.add(this);
		return this;
	}
	
	@Override
	public void shutdown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Runnable> shutdownNow() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isShutdown() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTerminated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("hiding")
	@Override
	public <T> Future<T> submit(Callable<T> task) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("hiding")
	@Override
	public <T> Future<T> submit(Runnable task, T result) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Future<?> submit(Runnable task) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("hiding")
	@Override
	public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("hiding")
	@Override
	public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
			throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("hiding")
	@Override
	public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("hiding")
	@Override
	public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
			throws InterruptedException, ExecutionException, TimeoutException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void execute(Runnable command) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <V> ScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) {
		// TODO Auto-generated method stub
		return null;
	}


}
