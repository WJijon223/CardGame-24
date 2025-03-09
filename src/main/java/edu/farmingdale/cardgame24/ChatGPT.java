package edu.farmingdale.cardgame24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Set;

public class ChatGPT {

    public static void main(String[] args) {
//        System.out.println(chatGPT("[4,4,8,12]"));
        // Prints out a response to the question.
    }

    public static String chatGPT(Set<Integer> integerSet) {
        String url = "https://api.openai.com/v1/chat/completions";
        String apiKey = System.getenv("OPENAI_API_KEY"); // API key goes here
        String model = "gpt-3.5-turbo"; // current model of chatgpt api

        String msg = "I am playing a game where I am given four numbers " +
                "and I have to write an expression using ONLY each number " +
                "exactly once and must use only addition, subtraction, " +
                "multiplication, and addition. Give me a hint that is " +
                "less than 10 words don't say anything else. Here is the " +
                "array of numbers I must use (MUST use the numbers in the hint):" +
                integerSet.toString();

        try {
            // Create the HTTP POST request
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Authorization", "Bearer " + apiKey);
            con.setRequestProperty("Content-Type", "application/json");

            // Build the request body
            String body = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + msg + "\"}]}";
            con.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
            writer.write(body);
            writer.flush();
            writer.close();

            // Get the response
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // returns the extracted contents of the response.
            return extractContentFromResponse(response.toString());

        } catch (IOException e) {
            return "Error: Missing API key!";
        }
    }

    // This method extracts the response expected from chatgpt and returns it.
    public static String extractContentFromResponse(String response) {
        int startMarker = response.indexOf("content")+11; // Marker for where the content starts.
        int endMarker = response.indexOf("\"", startMarker); // Marker for where the content ends.
        return response.substring(startMarker, endMarker); // Returns the substring containing only the response.
    }
}