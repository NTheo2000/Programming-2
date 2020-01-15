package GUI_Classes;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Evaluationforgui {
	
	public static String[] questions ={"1. Is your cooperation with your manager good?\n","\n2. Are you happy you are in our organization?\n",
			"\n3. Do you think that your manager deserves his possition?\n","\n4. How hard or easily you're considering to leave?\n",
			"\n5. How hard or easily you're considering to leave?\n","\n6. Is your manager sympahetic with you?\n","\n7. Do you think that other departments have better managers?\n",
			"\n8. Does your manager behave nice to you and to your colleagues?\n","\n9. Is your manager fair?\n","\n10. Does you manager have the same behavior to your f/m collegues?\n",
			"\n11. Do you think that you manager has the skills to be leader?\n"};
	
	@SuppressWarnings("unchecked")
	public static void saveAnswers(int[] answers, String id) throws IOException, ClassNotFoundException {
		JSONParser parser = new JSONParser();
		JSONArray list;
		try {	
			list = (JSONArray) parser.parse(new FileReader("id_scores.json"));
		} catch (ParseException e) {
			list = new JSONArray();
		}
		JSONObject obj = new JSONObject();
		JSONObject array_obj = new JSONObject();
		obj.put("id", id);
		for (int i = 0; i < answers.length; i ++) {
			array_obj.put("question " + (i + 1), answers[i]);
		}
		obj.put("score", array_obj);
		list.add(obj);
		FileWriter writer = new FileWriter("id_scores.json");
		writer.write(list.toJSONString());
		writer.flush();  
        writer.close();
	}
}

