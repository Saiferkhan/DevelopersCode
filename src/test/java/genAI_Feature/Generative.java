package genAI_Feature;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

public class Generative {
	
	public static void main(String arg[]) {
		
		String APIKey="AQ.Ab8RN6IGOGtyJSSSgp1VCqbWjayRjZHZ87P23Ut0nXl-wcYf1w";
		Client client = Client.builder().apiKey(APIKey).build();

        GenerateContentResponse response =
                client.models.generateContent(
                        "gemini-2.5-flash",
                        "act as a automation test engineer create testscript of loginpage testng based",
                        null);

        System.out.println(response.text());
    }
}


