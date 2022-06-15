package com.google.sps.servlets;

import java.io.IOException;
import java.util.Date;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.ArrayList;

@WebServlet("/sample")
public class SampleServlet extends HttpServlet {

    ArrayList<String> messages = new ArrayList<String>(Arrays.asList("To infinity and beyond!", "May the force be with you", "Im the king of the world!"));

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html;");

    Gson gson = new Gson();
    String json = gson.toJson(messages);
    
    response.getWriter().println(json);
  }
    
}
