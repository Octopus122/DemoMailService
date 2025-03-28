# DemoMailService #

**DemoMailService** - сервис для отправки сообщений на почту пользователей через подключенный 
SMTP-сервер. Для получения инструкций для отправки используется брокер сообщений.

## Технологии ##
Сервис написан на языке **Kotlin** с использованием **Spring Boot** для внедрения зависимотей. Также важно отметить:
* для получения инструкций для отправки сообщений используется **Apache Kafka**;
* для отправки сообщений используется **JavaMail**.

## Структура проекта ##
Далее описаны основные составляющие проекта.

### Структура сообщений ###
Сообщения с инстуркциями для отправления писем приходят из [UserMailService](https://github.com/Octopus122/UserMailService).
Каждая инструкция имеет содержит следующую информацию:
1. адрес электронной почты, на которую необходимо отправить письмо;
2. тип письма (в нынешней реализации отправлются только письма для подтвержения почты);
3. данные - дополнительная информация, которой нужно дополнить письмо (например ссылка для подтверждения).
### Подключение к SMTP-серверу ###
Параметры для работы с SMTP-сервером указываются в application.yaml. Отпарвка сообщений происходит асинхронно 
и не блокирует выполение программы.
## TO DO ##
В краткосрочной перспективе:
- [ ] Сделать html-шаблон для отправки сообщения;
- [ ] Добавить еще типы сообщений.
