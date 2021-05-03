package by.htp.library.service;

import by.htp.library.service.impl.ClientServiceImpl;
import by.htp.library.service.impl.LibraryServiceImpl;

public class ServiceProvider {
	private static final ServiceProvider INSTANCE_PROVIDER = new ServiceProvider();
	
	private static final ClientService CLIENT_SERVICE = new ClientServiceImpl();
	private static final LibraryService LIBRARY_SERVICE = new LibraryServiceImpl();
	
	private ServiceProvider(){		
	}
	
	

	public static ServiceProvider getInstanceProvider() {
		return INSTANCE_PROVIDER;
	}

	public ClientService getClientService() {
		return CLIENT_SERVICE;
	}

	public LibraryService getLibraryService() {
		return LIBRARY_SERVICE;
	}
	
	
}
