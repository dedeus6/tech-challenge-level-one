FROM amazoncorretto:21-alpine-jdk

RUN apt-get update && apt-get install -qq -y --no-install-recommends

ENV INSTALL_PATH /tech-challenge-level-one

RUN mkdir $INSTALL_PATH

WORKDIR $INSTALL_PATH

COPY . .