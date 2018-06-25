package io.download;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class A {

	interface DataHandler{
		void doHandler(String[] data);
	}
	interface ErrorHandler{
		void doHandler(Throwable t);
		public static final ErrorHandler PRINTER = new ErrorHandler() {
			public void doHandler(Throwable t) {
				t.printStackTrace();
			}
		};
	}
	/**
	 * �����࣬���ļ����ݴ�����
	 */
	class BigFileProcessor{
		/**
		 * ��¼�ķָ�����ÿ���ָ���ռһ�С�
		 */
		public static final String DEFAULT_SEPERATOR = "*****************";
		/**
		 * ������ҩ�����ڸɵ��������ݵ��̡߳�
		 */
		public final Object POISON = new Object();
		private BlockingQueue<Object> queue = new ArrayBlockingQueue<Object>(64);
		private String seperator = DEFAULT_SEPERATOR;
		private ErrorHandler errorHandler = ErrorHandler.PRINTER;
		/**
		 * ������ֹ��ȡ�̣߳���ǿ����ֹ��
		 */
		private volatile boolean running = false;
		/**
		 * ���ݶ�ȡ�߳�
		 */
		private Thread fileReader;
		/**
		 * ���ݴ����߳�
		 */
		private Thread[] proccessors;
		public BigFileProcessor(final File file, final DataHandler handler) {
			fileReader = new Thread(new Runnable() {
				public void run() {
					try {
						Charset charset = Charset.defaultCharset();
						@SuppressWarnings("resource")
						BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),charset));
						String line = null;
						ArrayList<String> cache = new ArrayList<String>();
						while(running&&(line=reader.readLine())!=null){
							line = line.trim();
							if(seperator.equals(line)){
								String[] data = cache.toArray(new String[cache.size()]);
								cache.clear();
								queue.put(data);
							}else{
								cache.add(line);
							}
						}
					} catch (Throwable t) {
						errorHandler.doHandler(t);
					} finally {
						try {
							queue.put(POISON);
						} catch (InterruptedException e) {
							errorHandler.doHandler(e);
						}
					}
				}
			},"reader_thread");
			//Ĭ�ϴ������߳�������CPU������ں�����ͬ��¥���������и��ġ�
			proccessors = new Thread[Runtime.getRuntime().availableProcessors()];
			Runnable worker = new Runnable() {
				public void run() {
					try {
						for(;;){
							Object obj = queue.take();
							if(obj==POISON){
								queue.put(obj);
								break;
							}else{
								String[] data =(String[])obj;
								handler.doHandler(data);
							}
						}
					} catch (Throwable t) {
						errorHandler.doHandler(t);
					}
				}
			};
			for(int i=0;i<proccessors.length;i++){
				proccessors[i] = new Thread(worker,"proccessor-thread_"+i);
			}
		}
		public void setErrorHandler(ErrorHandler errorHandler) {
			this.errorHandler = errorHandler;
		}
		public void setSeperator(String seperator) {
			this.seperator = seperator;
		}
		/**
		 * �����������
		 */
		public synchronized void start(){
			if(running)return ;
			running = true;
			fileReader.start();
			for(int i=0;i<proccessors.length;i++){
				proccessors[i].start();
			}
		}
		/**
		 * �жϴ�����̣���ǿ���ж�
		 */
		public synchronized void shutdown(){
			if(running){
				running = false;
			}
		}
		/**
		 * ��ͼ�ȴ���������������
		 */
		public void join(){
			try {
				fileReader.join();
			} catch (InterruptedException e) {
				errorHandler.doHandler(e);
			}
			for(int i=0;i<proccessors.length;i++){
				try {
					proccessors[i].join();
				} catch (InterruptedException e) {
					errorHandler.doHandler(e);
				}
			}
		}
	}
	/**
	 * ������������������ʹ����Щ���롣
	 */
	public void testcase(){
		File file = new File("f:\\1.txt");
		DataHandler dataHandler = new DataHandler() {
			public void doHandler(String[] data) {
				synchronized (System.out) {
					for(String s : data){
						System.out.print(s);System.out.print('\t');
					}
					System.out.println();
				}
			}
		};
		BigFileProcessor processor = new BigFileProcessor(file,dataHandler);
		processor.start();
		processor.join();
	}
	/**
	 * �������
	 */
	public static void main(String[] args) {
		A instance = new A();
		instance.testcase();
	}

}
