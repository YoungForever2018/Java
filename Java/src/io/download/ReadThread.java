package io.download;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;

public class ReadThread implements Runnable {
	private volatile boolean running = false; //线程终止标识
	private File file ;
	private BlockingQueue<Object> blockingQueue ;
	
	public ReadThread(File file ,BlockingQueue<Object> blockingQueue ) {
		this.file = file;
		this.blockingQueue = blockingQueue;
		this.running = true;
	}
	
	@Override
	public void run() {
		readBytes();
		readChars();
	}
	
	
	private void readChars(){
		FileInputStream fileInputStream = null;
		BufferedInputStream bufferedInputStream = null;
		try {
			fileInputStream = new FileInputStream(this.file);
			bufferedInputStream = new BufferedInputStream(fileInputStream);
			
			ArrayList<byte[]> list = new ArrayList<byte[]>();
			byte[] bytes = new byte[64];
			int length = -1;
			while (running &&(length = bufferedInputStream.read(bytes, 0 , bytes.length))!=-1) {
				byte[] temp = Arrays.copyOf(bytes, length);
				blockingQueue.put(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(bufferedInputStream != null){
				try {
					bufferedInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void readBytes(){
		FileInputStream fileInputStream = null;
		BufferedInputStream bufferedInputStream = null;
		try {
			fileInputStream = new FileInputStream(this.file);
			bufferedInputStream = new BufferedInputStream(fileInputStream);
			
			byte[] bytes = new byte[1024];
			int length = -1;
			while (running &&(length = bufferedInputStream.read(bytes, 0 , bytes.length))!=-1) {
				byte[] temp = Arrays.copyOf(bytes, length);
				blockingQueue.put(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(bufferedInputStream != null){
				try {
					bufferedInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
}
