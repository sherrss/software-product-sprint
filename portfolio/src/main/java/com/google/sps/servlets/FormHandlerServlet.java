package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.IncompleteKey;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the value entered in the form.
    String textValue = request.getParameter("text-input");
    // Get the time of when the value is entered. 
    long timestamp = System.currentTimeMillis();

    // Print the value so you can see it in the server logs.
    System.out.println("You submitted: " + textValue);

    // Create instance of Datastore.
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    // Create key with a kind of "Task".
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Task");

    // Create entity with properties of text value and timestamp.
    FullEntity taskEntity =
        Entity.newBuilder(keyFactory.newKey())
            .set("value", textValue)
            .set("timestamp", timestamp)
            .build();
    datastore.put(taskEntity);

    //Redirect user back to portfolio page
    response.sendRedirect("/index.html");

  }
}