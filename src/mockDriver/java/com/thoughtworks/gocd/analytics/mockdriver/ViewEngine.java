package com.thoughtworks.gocd.analytics.mockdriver;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Version;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.Map;

public class ViewEngine {
  public static class F {
    public static String renderView(Map<String, Object> model, String viewName) {
      FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(createDefaultConfiguration());
      String render = freeMarkerEngine.render(
          new ModelAndView(model, viewName + ".ftl")
      );
      return render;
    }

    private static Configuration createDefaultConfiguration() {
      var configuration = new Configuration(new Version(2, 3, 23));
      var classTemplateLoader = new ClassTemplateLoader((ClassLoader) null, "/templates");
      configuration.setTemplateLoader(classTemplateLoader);
      return configuration;
    }
  }

}