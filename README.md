#Клиент-серверное приложение Kolyma Adventurer App ^^

Это мобильное приложение для Android, работающее с сервером на Java (Spring Boot) через REST API.

##Структура проекта
|-server (Серверная часть на Spring Boot + SQLite + Flyway для миграции)
|-client-android (Мобильный клиент Android на  Java + Retrofit)

##Что нужно для быстро старта

###Сервер
1. Перейди в папку 'server'
2. Запусти файл:
-run-server.bat - если у тебя Windows
-run-server.sh - если у тебя Linux/Mac → Обязательно сделай файл исполняемым с помощью команды: chmod +x run-server.sh

Можешь сделать это вручную в терминале. Введи команду:
cd server
java -jar target/your-server.jar

Обязательно убедись, что в target/ есть .jar файл. Если нет - собери проект с помощью команды в терминале:
./mvnw clean package

###Клиент
1. Открой папку kolyma-adventurer-app в Android Studio
2. Убедись, что подключен интернет на компьютере
3. Нажми Run (или Shift + F10)

Примечание: клиент использует Retrofit для связи с сервером по адресу: http://10.0.2.2:8080/.
На реальном устройстве нужно будет указать IP хоста вместо 10.0.2.2

Используемые технологии в проекте:
1. Java 17
2. Spring Boot
3. SQLite
4. Retrofit
5. Android SDK
6. Maven