package io.download;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TxtProcessor {

	public final Object stop = new Object();
	
	private BlockingQueue<Object> queue = new ArrayBlockingQueue<Object>(64);
	
	private volatile boolean running = false; //线程终止标识
	
	private Thread readThread ; //数据读取线程
	
	private Thread[] processThreads ;//数据处理线程
	
	public TxtProcessor(File file) {
		readThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				Charset charset = Charset.defaultCharset();
				BufferedReader bufferedReader = null;
				try {
					bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),charset));
					
					ArrayList<String> list = new ArrayList<String>();
					String line = null;
					while (running && (line = bufferedReader.readLine())!= null) {
						list.add(line);
					}
					String[] data = list.toArray(new String[list.size()]);
					list.clear();
					queue.put(data);
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally{
					if(bufferedReader != null){
						try {
							bufferedReader.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		},"read_thread");
	
		processThreads = new Thread[Runtime.getRuntime().availableProcessors()];
		
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				BufferedWriter bufferedWriter = null;
				try {
					for (;;) {
						Object object = queue.take();
						if(object == stop ){
							queue.put(object);
							break;
						}else {
							String[] data = (String[])object;
							
						    bufferedWriter = new BufferedWriter(new FileWriter("f:\\1.txt"));
							for (int i = 0; i < data.length; i++) {
								bufferedWriter.write(data[i]);
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					if(bufferedWriter != null){
						try {
							bufferedWriter.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		};
		
		for (int i = 0; i < processThreads.length; i++) {
			processThreads[i] = new Thread(runnable,"thread"+i); 
		}
	}
	
	
	public synchronized void start(){
		if(running){
			return;
		}
		
		running = true;
		readThread.start();
		
		for (int i = 0; i < processThreads.length; i++) {
			processThreads[i].start();
		}
	}
	
	public synchronized void shutDown(){
		if(running){
			running = false ;
		}
	}
	
	/*
	 * 试图等待整个处理过程完毕 
	 */
	public void join(){
		try {
			readThread.join();
			
			for (int i = 0; i < processThreads.length; i++) {
				processThreads[i].join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
