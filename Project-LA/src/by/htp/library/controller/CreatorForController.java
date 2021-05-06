package by.htp.library.controller;

import by.htp.library.bean.creator.BookCreator;
import by.htp.library.bean.creator.UserCreator;
import by.htp.library.bean.creator.impl.BookCreatorImpl;
import by.htp.library.bean.creator.impl.UserCreatorImpl;
import by.htp.library.controller.parser.ParserRequest;
import by.htp.library.controller.parser.ParserUserParamToStringForController;
import by.htp.library.service.ClientService;
import by.htp.library.service.LibraryService;
import by.htp.library.service.impl.ClientServiceImpl;
import by.htp.library.service.impl.LibraryServiceImpl;

public class CreatorForController {
	private static final CreatorForController INSTANCE_CREATOR = new CreatorForController();
	
	private static final ParserRequest PARSER_REQUEST = new ParserRequest();
	private static final ClientService CLIENT_SERVICE = new ClientServiceImpl();
	private static final LibraryService LIBRARY_SERVICE = new LibraryServiceImpl();
	private static final ParserUserParamToStringForController PARSER_USER_PARAM_TO_STRING = new ParserUserParamToStringForController();
	private static final UserCreator USER_CREATOR = new UserCreatorImpl();
	private static final BookCreator BOOK_CREATOR = new BookCreatorImpl();

	public CreatorForController() {
	}

	public static CreatorForController getInstanceCreator() {
		return INSTANCE_CREATOR;
	}

	public ParserRequest getParserRequest() {
		return PARSER_REQUEST;
	}

	public ClientService getClientService() {
		return CLIENT_SERVICE;
	}

	public LibraryService getLibraryService() {
		return LIBRARY_SERVICE;
	}

	public ParserUserParamToStringForController getParserUserParamToString() {
		return PARSER_USER_PARAM_TO_STRING;
	}

	public UserCreator getUserCreator() {
		return USER_CREATOR;
	}

	public BookCreator getBookCreator() {
		return BOOK_CREATOR;
	}
	
	

}
