package by.htp.library.controller.command.impl;

import java.util.List;

import by.htp.library.bean.Book;
import by.htp.library.controller.CreatorForController;
import by.htp.library.controller.command.Command;
import by.htp.library.controller.exeption.ControllerLibraryException;
import by.htp.library.service.LibraryService;
import by.htp.library.service.exception.ServiceLibraryException;

public class GetInfoAllBooks implements Command {

	@Override
	public String execute(String request) throws ControllerLibraryException {

		// 1/Tatiana Polyakova1/Mansion with access to the astral
		// plane/detective/2021/paper/ALL/Oleg

		String responce = null;
		List<Book> books = null;

		CreatorForController creator = CreatorForController.getInstanceCreator();

		LibraryService libraryService = creator.getLibraryService();
		try {
			books = libraryService.getInfoAllBook();

		} catch (ServiceLibraryException e) {
			throw new ControllerLibraryException(e);
		}

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("We have the following books: \n");

		for (int i = 0; i < books.size(); i++) {
			stringBuilder.append(books.get(i).toString());
			if (i != books.size() - 1) {
				stringBuilder.append("\n");
			}
		}
		responce = stringBuilder.toString();

		System.out.println();
		return responce;
	}
}
