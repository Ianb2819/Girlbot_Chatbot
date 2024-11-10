/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.laboratoriachatbot;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Intechat extends javax.swing.JFrame {

    String conver[] = new String[999];
    ArrayList<String[]> Hist = new ArrayList<>();
    String Titulo[] = new String[999];
    String Vacio[] = new String[0];
    String conver2[][] = new String[999][999];
    String x;
    int n = 999, ñ = 0,k=0,  G=0, y=0, i=0, I;
    public void guardar(String[] conver){
        Titulo[i]= conver[0].substring(4);
        Historial.setListData(Titulo);
        for (int j = 0; j < 999; j++) {
            conver2[i][j] = conver[j];
//            Funcion para guardar el chat en una matriz
        }
    }
    public void chat(){
        for (int j = 0; j < 999; j++) {
            conver[j]=conver2[I][j];
        }
        Chatt.setListData(conver);
//        Funcion para reescribir el chat
    }
    public void eliminar(){
        for (int j = 0; j < 999; j++) {
            conver[j] = null;
        }
        Chatt.setListData(conver);
// Funcion para borrar un chat
    }
    public void eliminarchat(){
        Titulo[I]= null;
        Historial.setListData(Titulo);
        for (int j = 0; j < 999; j=j+1) {
            conver2[i][j] = null;
//            Funcion para eliminar un chat del historial
        }
}

    public static String Chat(String a) throws MalformedURLException, IOException { //MÉTODO PARA MANDAR LA PREGUNTA A LA API
        String modelName = "llama3.2:1b";
        String promptText = a;
        //URL
        URL url = new URL("http://localhost:11434/api");
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
        System.out.println("Response code: " + code);
        if(code == 200){
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = in.readLine()) != null) {
            response.append(line);
        }
        in.close();

        // MOSTRAR LA RESPUESTA EN LA INTERFAZ
        org.json.JSONObject jsonresponse = new org.json.JSONObject(response.toString());
        String responseText = jsonresponse.getString("response");
        // AQUÍ SE CIERRA LA CONEXIÓN  
        conn.disconnect();
        return responseText;
        }else{
            String respuesta = "ERROR EN OLLAMA";
            return respuesta;
        }
    }

    /**
     * Creates new form Intechat
     */
    public Intechat() {
        conver = new String[n];
        LaboratoriaChatBot Lab = new LaboratoriaChatBot();
        initComponents();
        jPanel1.setBackground(new Color(242, 210, 247));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Historial = new javax.swing.JList<>();
        ENVIAR = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TextoPre = new javax.swing.JTextPane();
        jButton2 = new javax.swing.JButton();
        NuevoChat = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Chatt = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Historial.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Historial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HistorialMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Historial);

        ENVIAR.setBackground(new java.awt.Color(255, 153, 153));
        ENVIAR.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        ENVIAR.setText("Enviar");
        ENVIAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ENVIARMouseClicked(evt);
            }
        });

        TextoPre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TextoPre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TextoPreMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TextoPreMouseEntered(evt);
            }
        });
        jScrollPane3.setViewportView(TextoPre);

        jButton2.setBackground(new java.awt.Color(255, 153, 153));
        jButton2.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jButton2.setText("Guardar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
        });

        NuevoChat.setBackground(new java.awt.Color(255, 153, 153));
        NuevoChat.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        NuevoChat.setText("Nuevo chat");
        NuevoChat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NuevoChatMouseClicked(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 204, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel1.setText("Histroial");

        Chatt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(Chatt);

        jLabel2.setBackground(new java.awt.Color(255, 204, 204));
        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        jLabel2.setText("GIRLBOT");

        jButton3.setBackground(new java.awt.Color(255, 153, 153));
        jButton3.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jButton3.setText("Eliminar Chat");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ENVIAR))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3)
                                .addGap(56, 56, 56)
                                .addComponent(NuevoChat)))
                        .addGap(59, 59, 59))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(NuevoChat)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ENVIAR)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ENVIARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ENVIARMouseClicked
        if (TextoPre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una pregunta antes de enviar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // PARA MOSTRARLO GUARDAMOS LA PREGUNTA EN EL ARRAY CONVER
        boolean nueva = false;
        ñ++;
        int p = 0;
        for (int i = 0; i < n; i++) {
            if (conver[i] == null) {
                if (i == 0) {
                    x = TextoPre.getText();
                }
                conver[i] = "Tu: " + TextoPre.getText();  // GUARDAR LA PREGUNTA EN EL VECTOR
                nueva = true;
                p = i;
                TextoPre.setText("");  // CUANDO LE DE AL BOTÓN ENVIAR QUE SE ELIMINE LA INFORMACIÓN EN EL CUADRO DE TEXTO
                break;
            }
        }

        if (nueva) {
            //ACTUALIZAMOS LOS CHATS
            Chatt.setListData(conver);

            String pregunta = conver[p];  // AQUI SE TOMA LA PREGUNTA QUE EL USUARIO ACABA DE DIGITAR
            try {
                // AQUI LE ENVIAMOS LA PREGUNTA A LA CLASE 
                String respuesta = LaboratoriaChatBot.Chat(pregunta);  // LLAMAMOS A LA CLASE
                // GUARDAR LA RESPUESTA EN EL ARRAY CONVER
                for (int i = p + 1; i < n; i++) {  // LA OTRA POSICIÓN QUE SERÁ PARA MOSTRAR LAS RESPUESTAS
                    if (conver[i] == null) {
                        conver[i] = "IA: " + respuesta;  // GUARDAR LAS RESPUESTAS DE OLLAMA
                        break;
                    }
                }
                //ACTUALIZAR CHATS
                Chatt.setListData(conver);

            } catch (IOException ex) {
                Logger.getLogger(Intechat.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Ocurrió un error al conectar con Ollama.", "Error", JOptionPane.ERROR_MESSAGE);
            
            }
        }
    }//GEN-LAST:event_ENVIARMouseClicked

    private void TextoPreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextoPreMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_TextoPreMouseEntered

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        guardar(conver);
//        Aqui llame a guardar e hice i++ para que guardar pase de 0 a 1 y asi
    }//GEN-LAST:event_jButton2MouseClicked

    private void HistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HistorialMouseClicked
        // TODO add your handling code here:
        I = Historial.getSelectedIndex();
        i = I;
        chat();
//        Aqui agarro el inice que es una variable global y mando a que se haga la funcion chat
    }//GEN-LAST:event_HistorialMouseClicked

    private void NuevoChatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NuevoChatMouseClicked
        // TODO add your handling code here:
        guardar(conver);
        i++;
        eliminar();
        
//      Aqui solo llamo a eliminar
    }//GEN-LAST:event_NuevoChatMouseClicked

    private void TextoPreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextoPreMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TextoPreMouseClicked

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        eliminar();
        eliminarchat();
//        Aqui llamo a eliminar para eliminar el contenido del chat y el historial con el indice
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> Chatt;
    private javax.swing.JButton ENVIAR;
    private javax.swing.JList<String> Historial;
    private javax.swing.JButton NuevoChat;
    private javax.swing.JTextPane TextoPre;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables

    private String sendRequestToOllama(String llama32, String prompt_text, URI uri) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
