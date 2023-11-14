package com.thoughtworks.gocd.analytics.mockdriver;

import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.thoughtworks.gocd.analytics.models.Agent;

import static com.thoughtworks.gocd.analytics.AgentMother.agentWith;
import static spark.Spark.*;
import static spark.Spark.get;

import static com.thoughtworks.gocd.analytics.mockdriver.ViewEngine.*;

public class Main {
  public static void main(String[] args) {
    port(4567);
    Gson gson = new Gson();

    get("/example", (req, res) -> renderView(exampleModel(), "example"));
    get("/agents", (req, res) -> {
      res.type("application/json");
      return agents();
    }, gson::toJson);
  }

  private static Agent[] agents(){
    Agent oneAgent = createAgent("agent-1", "host_name", false, "127.0.0.1", "some_os");
    return new Agent[]{oneAgent};
  }

  private static Agent createAgent(String uuid, String hostName, boolean isElastic, String ipAddress, String os) {
    return agentWith(uuid, hostName, isElastic, ipAddress, os, "10G", "enabled");
  }

  private static Map<String, Object> exampleModel() {
    Map<String, Object> model = new HashMap<>();
    model.put("message", "Hello Thymeleaf");
    return model;
  }
}