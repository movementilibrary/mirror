#Imagem base
FROM imagesdasa.azurecr.io/prd/base-image:latest

ARG PROJECT_NAME
ARG VERSION
ARG REVISION
#ARG env

ENV PROJECT_NAME $PROJECT_NAME
ENV VERSION $VERSION
ENV REVISION $REVISION
ENV APPNAME $PROJECT_NAME-$VERSION-$REVISION.jar
#ENV env $env

RUN add-apt-repository ppa:openjdk-r/ppa && \
    apt-get update && \
    apt-get install -y openjdk-8-jdk && \
    apt-get update && \
    mkdir /app && \
    groupadd app && \
    useradd app -u 1001 -g app -d /app -s /bin/bash

COPY target/"$APPNAME" /app/

#RUN mkdir -p app/newrelic/logs
#RUN chmod 777 app/newrelic/logs

#COPY target/newrelic/newrelic.jar /app/newrelic
#COPY newrelic.yml /app/newrelic

RUN chown 1001:app /app -R

WORKDIR /app

CMD java -jar /app/"$APPNAME"

#ENTRYPOINT java -javaagent:/app/newrelic/newrelic.jar -Dnewrelic.environment="$env" -jar /app/"$APPNAME"

EXPOSE 8090

