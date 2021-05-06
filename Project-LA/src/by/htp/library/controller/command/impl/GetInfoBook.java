package by.htp.library.controller.command.impl;

import java.util.List;
import java.util.Optional;

import by.htp.library.bean.Book;
import by.htp.library.controller.CreatorForController;
import by.htp.library.controller.command.Command;
import by.htp.library.controller.exeption.ControllerLibraryException;
import by.htp.library.controller.parser.ParserRequest;
import by.htp.library.service.LibraryService;
import by.htp.library.service.exception.ServiceLibraryException;

public class GetInfoBook implements Command {

	@Override
	public String execute(String request) throws ControllerLibraryException {

		// 1/Tatiana Polyakova1/Mansion with access to the astral
		// plane/detective/2021/paper/ALL/Oleg

		String nameBook = null;
		String author = null;
		String responce = null;
		Optional<Book> book = null;

		CreatorForController creator = CreatorForController.getInstanceCreator();
		ParserRequest parserRequest = creator.getParserRequest();
		List<String> paramsRequest = parserRequest.parseParamsBookFromRequest(request);

		nameBook = paramsRequest.get(0);
		author = paramsRequest.get(1);

		LibraryService libraryService = creator.getLibraryService();
		try {
			book = libraryService.getInfoBook(nameBook, author);

		} catch (ServiceLibraryException e) {
			throw new ControllerLibraryException(e);
		}

		if (book != null && book.isPresent()) {
			responce = "You book : " + book.get().toString();

		} else {
			responce = "Book with that name = " + nameBook + " and author = " + author + "  is not exist.";
		}

		System.out.println();
		return responce;
	}

}
