package com.practice.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.practice.demo.future.AsyncExecutorService;

public class Future {

	public static void main(String[] args) {
		CompletableFuture
		.runAsync(extracted())
		.thenAccept(p -> System.out.println(p));
		
		CompletableFuture<String> completableFuture 
		  = CompletableFuture.supplyAsync(() -> "Hello")
		    .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));
		
		try {
			System.out.println(completableFuture.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		AsyncExecutorService<String> aes = new AsyncExecutorService<>();
		aes.supplyAsyncExecution(()->"Hello")
		.addToFutureList();
		aes.supplyAsyncExecution(()->{try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} return "Hello";}).addToFutureList();
		aes.getAll();
	}

	private static Runnable extracted() {
		return () -> {System.out.println("hello world");};
	}

}
