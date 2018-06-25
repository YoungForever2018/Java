package io.download;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

public class WriteThread implements Runnable {
	File file ;
	boolean running = false;
	Object stop = new Object();
	BlockingQueue<Object> queue  ;
	
	public WriteThread(File file , BlockingQueue<Object> queue ) {
		this.file = file;
		this.queue = queue;
		this.running = true;
	}
	
	@Override
	public void run() {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(this.file) ;
			while(true){
				if(queue.isEmpty() && running){
					break;
				}
				Object object = queue.take();
				byte[] bytes = (byte[])object;
				fos.write(bytes);
				fos.flush();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(fos !=null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
