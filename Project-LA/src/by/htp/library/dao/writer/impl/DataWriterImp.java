package by.htp.library.dao.writer.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import by.htp.library.bean.User;
import by.htp.library.dao.exception.DAOLibraryException;
import by.htp.library.dao.parser.ParserUserParamToString;
import by.htp.library.dao.parser.impl.ParserUserParamToStringImpl;
import by.htp.library.dao.writer.DataWriter;

public class DataWriterImp implements DataWriter {

	@Override
	public void writeUserInTXT(User user, String fileName) throws DAOLibraryException {

		ParserUserParamToString parserUserParamToString = new ParserUserParamToStringImpl();

		String userParamString = parserUserParamToString.parseUserParamToTXT(user);

		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true))) {
			bufferedWriter.write("\n");
			bufferedWriter.write(userParamString);

		} catch (IOException e) {
			throw new DAOLibraryException("Error. Writing user in the file is imposible.");
		}
	}

	@Override
	public void writeAllUsersInTXT(List<String> listStringUsers, String fileName) throws DAOLibraryException {

//		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, false))) {
//			
//
//		} catch (IOException e) {
//			throw new DAOLibraryException("Error. Writing user in the file is imposible.");
//		}
		
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, false))) {
			
			for (int i = 0; i < listStringUsers.size(); i++) {
				if (i != 0) {
					bufferedWriter.write("\n");
				}
				bufferedWriter.write(listStringUsers.get(i));				
			}

		} catch (IOException e) {
			throw new DAOLibraryException("Error. Writing user in the file is imposible.");
		}

	}
}
