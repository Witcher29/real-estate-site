# Используем официальный образ MySQL 8.0
FROM mysql:8.0

# Установим переменные окружения для настройки MySQL
ENV MYSQL_DATABASE=web_site
ENV MYSQL_USER=user
ENV MYSQL_PASSWORD=1111
ENV MYSQL_ROOT_PASSWORD=0000

# Копируем скрипты инициализации базы данных (если есть)
COPY init.sql /docker-entrypoint-initdb.d/

# Открываем порт 3306 для подключения к базе данных
EXPOSE 3306

# Запускаем MySQL-сервер при создании контейнера
CMD ["mysqld"]

#FROM openjdk:21-jdk
#
## Копируем файл инициализации базы данных
#COPY init.sql /docker-entrypoint-initdb.d/
#
## Устанавливаем рабочую директорию
#WORKDIR /app
#
## Копируем WAR-файл
#COPY target/real-estate-0.0.1-SNAPSHOT.war app.war
#
## Экспонируем порт 8080
#EXPOSE 8080
#
## Запускаем приложение
#CMD ["java", "-jar", "app.war"]