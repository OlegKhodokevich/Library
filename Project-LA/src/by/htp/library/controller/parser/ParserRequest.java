package by.htp.library.controller.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParserRequest {
	private static final String DELIMITER = " ";
	
	public List<String> parseParamsFromRequest(String request) {
		List<String> paramsReque = new ArrayList<String>();
		
		paramsReque = Arrays.asList(request.split(DELIMITER));

		return paramsReque;		
	}
	
	public String parseAndDeliteParamAdminFromRequest(String request) {	
		
		int lastindex = request.indexOf(DELIMITER);		
		request = request.substring(lastindex + 1);

		lastindex = request.indexOf(DELIMITER);		
		request = request.substring(lastindex + 1);
		
		return request;		
	}

}
