package org.softlang.company.features;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class Parsing {

    public static JsonObject parseCompany(String file) throws IOException {
		InputStream fis = new FileInputStream(file);
		JsonReader jsonReader = Json.createReader(fis);
		JsonObject jsonObject = jsonReader.readObject();
		jsonReader.close();
		fis.close();
		return jsonObject;
    }

}