package io.download;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadURL {

	public static void main(String[] args) throws Exception {
		long begin = System.currentTimeMillis();
		
		HttpURLConnection connection = getConnection("http://down.23us.cc/92/91062/Íò¹ÅÉñµÛ.txt");
		InputStream is = connection.getInputStream();
		
		download(is, "f:\\wgsd.txt");
				
		long end = System.currentTimeMillis();
		System.out.println(Math.round((end-begin)/1000/60));	
	}
	
	private static HttpURLConnection getConnection(String urlString) throws Exception {
		URL url = new URL(urlString);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setConnectTimeout(5000);
		return connection;
	}
	
	//22min
	private static void download(InputStream is,String dest){
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(dest);
			byte[] bytes = new byte[1024];
			int length = -1 ;
			while ((length = is.read(bytes, 0, bytes.length))!=-1) {
				fos.write(bytes, 0, length);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (fos !=null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@SuppressWarnings("unused")
	private static void download1(InputStream is,String dest){
		BufferedOutputStream bos = null;
		FileOutputStream fos =null;
		try {
			fos = new FileOutputStream(dest);
			bos = new BufferedOutputStream(fos);

			byte[] bytes = new byte[1024];
			int length = -1 ;
			while ((length = is.read(bytes,0,bytes.length))!= -1) {
				bos.write(bytes, 0, length);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//ÂÒÂë
	@SuppressWarnings("unused")
	private static void download2(InputStream is,String dest) {
		InputStreamReader inputStreamReader = null;
		BufferedReader bReader = null;
		BufferedWriter bWriter = null;
		try {
			inputStreamReader = new InputStreamReader(is,"utf-8");
			bReader = new BufferedReader(inputStreamReader);
			bWriter = new BufferedWriter(new FileWriter(dest) );
			
			char[] chars = new char[1024];
			int length = -1;
			while ((length = bReader.read(chars, 0, chars.length)) !=-1) {
				bWriter.write(chars, 0, length);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
