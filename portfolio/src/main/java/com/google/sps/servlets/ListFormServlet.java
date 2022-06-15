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
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;

@WebServlet("/list-form")
public class ListFormServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    //Create Datastore instance
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    //Create Query instance with the kind of Task
    //Contains all entities from Datastore of kind Task
    Query<Entity> query =
        Query.newEntityQueryBuilder().setKind("Task").setOrderBy(OrderBy.desc("timestamp")).build();
    QueryResults<Entity> results = datastore.run(query);

    List<Task> tasks = new ArrayList<>();
    //Loop through entities
    while (results.hasNext()) {
      Entity entity = results.next();

      long id = entity.getKey().getId();
      String textValue = entity.getString("value");
      long timestamp = entity.getLong("timestamp");

      Task task = new Task(id, title, timestamp);
      tasks.add(task);
    }

    Gson gson = new Gson();

    response.setContentType("application/json;");
    response.getWriter().println(gson.toJson(tasks));
    
  }
}