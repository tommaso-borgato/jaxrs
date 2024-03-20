# podman build --tag jaxrs -f ./Dockerfile
# podman run --rm --network=host jaxrs
# podman run --rm -p 8080:8080 -p 9990:9990 jaxrs
# curl http://127.0.0.1:8080/hello
# curl http://0.0.0.0:9990/health
FROM docker.io/library/openjdk:11
USER root
COPY target/jaxrs-bootable.jar /opt/
# COPY scripts/startup.sh /opt/
# RUN chown -R 185:0 /opt/jaxrs-bootable.jar && chown -R 185:0 /opt/startup.sh && chmod +x /opt/startup.sh
RUN chown -R 185:0 /opt/jaxrs-bootable.jar
USER 185
#CMD /opt/startup.sh
CMD java -jar /opt/jaxrs-bootable.jar
