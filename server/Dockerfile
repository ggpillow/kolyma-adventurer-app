#указываем образ, используем java 17 (JDK 17) от Eclipse Temurin. Стабилен и даёь меньше багов.
#As build - создает промежуточный образ с именем build, чтобы позже его использовать
FROM eclipse-temurin:17-jdk AS build

#задаём рабочую директорию внутри контейнера
#Copy -копируем файлы текущей директории. В нашем случае копируем содержимое server в контейнер /app
WORKDIR /app
COPY pom.xml .
COPY src ./src
COPY .mvn ./.mvn
COPY mvnw .

#Делаем maven wrapper (mvnw) исполняемым
RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests

#Новый чистый образ без мусора от сборки, делает финальный образ меньше и чище.
#Отделение сборки и запуск. Это этап запуска. Уменьшает размер, избавляет от лишних зависмсотей, кеша и папок
FROM eclipse-temurin:17-jdk

#Опять указываем рабочую директорию. В новом образе всё начинается с нуля.
WORKDIR /app

#Копирует JAR-айлы из предыдщуего build-этапа в новый финальный образ
COPY --from=build /app/target/*.jar app.jar

#Указываем порт
EXPOSE 8080

#Запуск выполнения JAR-файла
ENTRYPOINT ["java", "-jar", "app.jar"]