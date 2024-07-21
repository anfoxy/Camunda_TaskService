FROM amazoncorretto:17
COPY target/camunda_service-0.0.1-SNAPSHOT.jar camunda_service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/camunda_service-0.0.1-SNAPSHOT.jar"]


## Используем базовый образ Amazon Corretto 17
#FROM amazoncorretto:17
#
## Устанавливаем рабочую директорию в контейнере
#WORKDIR /app
#
## Копируем JAR-файл вашего приложения в контейнер
#COPY target/camunda_service-0.0.1-SNAPSHOT.jar app.jar
#
## Указываем команду для запуска приложения
#ENTRYPOINT ["java", "-jar", "app.jar"]