package io.download;

public interface ErrorHandler {

	void doHandler(Throwable throwable);
	
	public static final ErrorHandler PRINTER = new ErrorHandler() {
		@Override
		public void doHandler(Throwable throwable) {
			throwable.printStackTrace();
		}
	};
}
