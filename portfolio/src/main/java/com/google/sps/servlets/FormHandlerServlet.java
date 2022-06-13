package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.KeyFactory;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the value entered in the form.
    String textValue = request.getParameter("text-input");

    // Print the value so you can see it in the server logs.
    System.out.println("You submitted: " + textValue);

    // Create instance of Datastore 
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    // Create key with a king of "Task"
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Task");

    //Redirect user back to portfolio page
    response.sendRedirect("http://sliu-sps-summer22.appspot.com ");

  }
}