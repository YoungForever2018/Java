package io.download.testCase;

import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import io.download.ReadThread;
import io.download.WriteThread;

public class TestReadThread {

	public static void main(String[] args) {
		
		BlockingQueue<Object> queue = new ArrayBlockingQueue<Object>(64);
		File file = new File("F:\\wgsd.txt");
		Thread thread = new Thread(new ReadThread(file, queue));
		thread.start();
		
		File fileD = new File("F:\\wgsdCopy.txt");
		Thread threadRead = new Thread(new WriteThread(fileD, queue));
		threadRead.start();
		
//		WriteThread writeThread = new WriteThread(fileD, queue);
//		Thread[] processThreads = new Thread[Runtime.getRuntime().availableProcessors()];
//		for (int i = 0; i < processThreads.length; i++) {
//			processThreads[i] = new Thread(writeThread);
//			processThreads[i].start();
//		}
	}
}
