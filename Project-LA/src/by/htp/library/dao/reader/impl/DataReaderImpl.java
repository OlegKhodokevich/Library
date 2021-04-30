package by.htp.library.dao.reader.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import by.htp.library.dao.exception.DAOLibraryException;
import by.htp.library.dao.reader.DataReader;
import by.htp.library.dao.validator.ValidatorStingBook;
import by.htp.library.dao.validator.ValidatorStringUser;

public class DataReaderImpl implements DataReader {

	public List<String> readAllLegalUser(String fileName) throws DAOLibraryException {
		List<String> listData = new ArrayList<String>();
		Path path = Paths.get(fileName);

		if (Files.exists(path) && !Files.isDirectory(path) && Files.isReadable(path)) {
			try {
				listData = Files.readAllLines(path).stream()
						.filter(s -> ValidatorStringUser.validateStringForCreateUser(s)).collect(Collectors.toList());

			} catch (IOException e) {
				throw new DAOLibraryException(e);
			}
		} else {
			throw new DAOLibraryException("File can not be read. File " + fileName);
		}

		return listData;
	}

	@Override
	public List<String> readAllLegalBook(String fileName) throws DAOLibraryException {
		List<String> listData = new ArrayList<String>();
		Path path = Paths.get(fileName);

		if (Files.exists(path) && !Files.isDirectory(path) && Files.isReadable(path)) {
			try {
				listData = Files.readAllLines(path).stream()
						.filter(s -> ValidatorStingBook.validateStringBook(s)).collect(Collectors.toList());

			} catch (IOException e) {
				throw new DAOLibraryException(e);
			}
		} else {
			throw new DAOLibraryException("File can not be read. File " + fileName);
		}

		return listData;
	}
	
	
}
