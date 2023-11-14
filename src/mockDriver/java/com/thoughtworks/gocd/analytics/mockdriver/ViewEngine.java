package com.thoughtworks.gocd.analytics.mockdriver;

import spark.ModelAndView;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import java.util.Map;

public class ViewEngine {
  public static String renderView(Map<String, Object> model, String viewName) {
    return new ThymeleafTemplateEngine().render(
        new ModelAndView(model, viewName)
    );
  }
}
