package org.softlang.company.features;

import java.io.InputStream;
import java.io.IOException;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class Parsing {

    public static JsonObject parseCompany(String url) throws IOException {
		InputStream is = new URL(url).openStream();
		JsonReader jsonReader = Json.createReader(is);
		JsonObject jsonObject = jsonReader.readObject();
		jsonReader.close();
		is.close();
		return jsonObject;
    }

}