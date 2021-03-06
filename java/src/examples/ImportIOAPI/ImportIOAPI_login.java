package examples.ImportIOAPI;

import apiworld.FinalURLNotGeneratedException;
import examples.ImportIOAPI.ImportIOAPI;
import static apiworld.UtilityFunctions.*;

public final class ImportIOAPI_login {

	private ImportIOAPI_login() {
		// Hide utility class constructor
	}

	public static void main(String[] args) throws InterruptedException,
			FinalURLNotGeneratedException {
		String username = readPropertyFrom("resources/importIO_settings.properties","username");
		String password = readPropertyFrom("resources/importIO_settings.properties","password");

		ImportIOSearch importIOSearch = new ImportIOSearch("", "",
				username, password);
		System.out.format("%s", importIOSearch.getFetchedResults());
	}
}

class ImportIOSearch extends ImportIOAPI {
	ImportIOSearch(String apiKey, String paramStart, String... params)
			throws FinalURLNotGeneratedException {
		String apiCommand = "login";
		String[] arrayURLParamCodes = { "username", "password" };

		fetchedResults = buildAPIReadyToExecute(apiKey, apiCommand, paramStart,
				arrayURLParamCodes, params);
		fetchedResults.executeURL();
	}
}