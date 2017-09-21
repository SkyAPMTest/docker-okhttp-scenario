FROM openjdk:8-jdk

ENV COLLECTOR_SERVER=127.0.0.1:12800

ADD startup.sh /usr/local/skywalking-spring-case/
ADD spring-case.jar /usr/local/skywalking-spring-case/
ADD sky-walking.config /usr/local/skywalking-spring-case/agent-config/

ADD docker-entrypoint.sh /
RUN chmod +x /usr/local/skywalking-spring-case/startup.sh && chmod +x /docker-entrypoint.sh

EXPOSE 5005
EXPOSE 8080

VOLUME /usr/local/skywalking-spring-case/agent
ENTRYPOINT ["/docker-entrypoint.sh"]
CMD ["/usr/local/skywalking-spring-case/startup.sh"]
