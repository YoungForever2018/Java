package io.download;

import java.io.File;

public class DownloadMulti {

	public static void main(String[] args) {
		File file = new File("f:\\wgsd.txt");

		TxtProcessor processor = new TxtProcessor(file);
		processor.start();
		processor.join();
	}
}
