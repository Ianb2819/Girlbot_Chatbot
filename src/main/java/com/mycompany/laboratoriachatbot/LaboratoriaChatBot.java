/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.laboratoriachatbot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.swing.JOptionPane;
import org.json.JSONObject;

public class LaboratoriaChatBot {

    public static String Chat(String a) throws MalformedURLException, IOException {
       String modelName = "llama3.2:1b";
        String promptText = a;
        String responseText = " ";
        try {
            URL url = new URL("http://localhost:11434/api/generate");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8;");
            conn.setRequestProperty("accept", "application/json");
            conn.setDoOutput(true);

            String JsonInputString = String.format(
                    "{\"model\": \"%s\", \"prompt\": \"%s\", \"stream\": false}", modelName, promptText);
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = JsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            int code = conn.getResponseCode();
            if (code == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                in.close();
                JSONObject jsonresponse = new JSONObject(response.toString());
                responseText = jsonresponse.getString("response");

            } else {
                System.out.println("Cuerpo de la respuesta: " + responseText);
                throw new IOException("Error en la respuesta del servidor");
            }
        } 
        catch (MalformedURLException e) {
            responseText = "URL mal formada: " + e.getMessage();
        } catch (IOException e) {
            responseText = "Error de conexión o lectura de la respuesta: " + e.getMessage();
        } catch (Exception e) {
            responseText = "Error inesperado: " + e.getMessage();
        }

        return responseText; 

    }

    public static void main(String[] args) throws MalformedURLException, IOException {
        Intechat frame = new Intechat(); // ESTA ES MI INTERFAZ
        frame.setVisible(true);
        frame.setSize(660, 419);
        frame.setLocationRelativeTo(null);// ES PARA QUE APAREZCA SIEMPRE EN EL MEDIO
    }

}
