FROM openjdk:11-jre-slim
RUN mkdir -p /usr/src/app
ADD ./target/shop-online-app.jar /usr/src/app
WORKDIR /usr/src/app
EXPOSE 80
CMD java -jar shop-online-app.jar
