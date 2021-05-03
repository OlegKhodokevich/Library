package by.htp.library.service.exception;

public class ServiceLibraryException extends Exception{

		private static final long serialVersionUID = 7486031531632857766L;

		public ServiceLibraryException() {
			super();
		}

		public ServiceLibraryException(String message, Throwable cause) {
			super(message, cause);
		}

		public ServiceLibraryException(String message) {
			super(message);
		}

		public ServiceLibraryException(Throwable cause) {
			super(cause);
		}
	

}
