package by.htp.library.dao.writer.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import by.htp.library.bean.Book;
import by.htp.library.bean.User;
import by.htp.library.dao.Creator;
import by.htp.library.dao.exception.DAOLibraryException;
import by.htp.library.dao.writer.DataWriter;

public class DataWriterImp implements DataWriter {

	@Override
	public void writeUserInTXT(User user, String fileName) throws DAOLibraryException {
		Path path = Paths.get(fileName);
		if (!Files.exists(path) || Files.isDirectory(path) || !Files.isReadable(path)) {
			throw new DAOLibraryException("File is not exist or incorrect. File : " + fileName);
		}

		String userParamString = Creator.PARSER_USER_PARAM_TO_STRING.parseUserParamToTXT(user);		

		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true))) {
			if (Files.lines(Paths.get(fileName)).count() != 0) {
				bufferedWriter.write("\n");
			}
			bufferedWriter.write(userParamString);

		} catch (IOException e) {
			throw new DAOLibraryException("Error. Writing user in the file is imposible. File : " + fileName);
		}
	}

	@Override
	public void writeAllUsersInTXT(List<String> listStringUsers, String fileName) throws DAOLibraryException {
		Path path = Paths.get(fileName);
		if (!Files.exists(path) || Files.isDirectory(path) || !Files.isReadable(path)) {
			throw new DAOLibraryException("File is not exist or incorrect. File : " + fileName);
		}

		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, false))) {

			for (int i = 0; i < listStringUsers.size(); i++) {
				if (i != 0) {
					bufferedWriter.write("\n");
				}
				bufferedWriter.write(listStringUsers.get(i));
			}

		} catch (IOException e) {
			throw new DAOLibraryException("Error. Writing user in the file is imposible. File : " + fileName);
		}
	}

	public void writeBookInTXT(Book book, String fileName) throws DAOLibraryException {
		Path path = Paths.get(fileName);
		if (!Files.exists(path) || Files.isDirectory(path) || !Files.isReadable(path)) {
			throw new DAOLibraryException("File is not exist or incorrect. File : " + fileName);
		}
		
		String bookString = Creator.PARSER_BOOK_PARAM_TO_STRING.parseBookParamToStringForTXT(book);

		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true))) {
			if (Files.lines(Paths.get(fileName)).count() != 0) {
				bufferedWriter.write("\n");
			}
			bufferedWriter.write(bookString);

		} catch (IOException e) {
			throw new DAOLibraryException("Error. Writing book in the file is imposible. File : " + fileName);
		}

	}

	public void writeAllBookInTXT(List<String> listBook, String fileName) throws DAOLibraryException {
		Path path = Paths.get(fileName);
		if (!Files.exists(path) || Files.isDirectory(path) || !Files.isReadable(path)) {
			throw new DAOLibraryException("File is not exist or incorrect. File : " + fileName);
		}
		
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, false))) {

			for (int i = 0; i < listBook.size(); i++) {
				if (i != 0) {
					bufferedWriter.write("\n");
				}
				bufferedWriter.write(listBook.get(i));
			}

		} catch (IOException e) {
			throw new DAOLibraryException("Error. Writing book in the file is imposible. File : " + fileName);
		}

	}
}
