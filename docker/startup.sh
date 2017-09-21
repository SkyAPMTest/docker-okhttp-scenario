#!/bin/sh

export AGENT_FILE_PATH=/usr/local/skywalking-spring-case/agent
if [ -f "${AGENT_FILE_PATH}/skywalking-agent.jar" ]; then
    SPRING_CASE_OPTS="$CATALINA_OPTS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 -javaagent:${AGENT_FILE_PATH}/skywalking-agent.jar -DconfigPath=/usr/local/skywalking-spring-case/agent-config"
fi

java $SPRING_CASE_OPTS -jar /usr/local/skywalking-spring-case/spring-case.jar
