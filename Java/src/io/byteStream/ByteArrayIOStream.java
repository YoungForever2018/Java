package io.byteStream;

import java.io.ByteArrayInputStream;

public class ByteArrayIOStream {

	public static void main(String[] args) {
		testByteArrayInputStream();
	
	}

	/**
	 * A ByteArrayInputStream contains an internal buffer that contains bytes that may be read from the stream.
	 * An internal counter keeps track of the next byte to be supplied by the read method.
	 */
	public static void testByteArrayInputStream(){
		byte[] buf = "hello".getBytes();
		ByteArrayInputStream bis = new ByteArrayInputStream(buf);

		byte[] bytes = new byte[1024];
		int len = -1;
		while ((len=bis.read(bytes, 0, 10))!=-1) {
			System.out.println(new String(bytes,0,len));
		}
	}
}
