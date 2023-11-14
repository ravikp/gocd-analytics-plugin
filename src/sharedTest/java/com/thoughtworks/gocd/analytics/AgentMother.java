package com.thoughtworks.gocd.analytics;

import com.thoughtworks.gocd.analytics.models.Agent;

public class AgentMother {
  public static Agent agentWith(String uuid, String hostName, boolean isElastic, String ipAddress, String os, String freeSpace, String configState) {
    Agent agent = new Agent();
    agent.setUuid(uuid);
    agent.setHostName(hostName);
    agent.setIsElastic(isElastic);
    agent.setIpAddress(ipAddress);
    agent.setOperatingSystem(os);
    agent.setFreeSpace(freeSpace);
    agent.setConfigState(configState);

    return agent;
  }
}
