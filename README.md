# Работа над плагином Atlassian SDK для Jira Data Center

В соответствии с [заданием](task1.md)

1. Установил Jira Data Center используя docker [образ](compose.yaml).
2. Загрузил предложенный плагин.
3. Добавил [сущность](src/main/java/ru/teamlead/jira/plugins/tutorial/ao/ExampleEntity.java).
4. Добавил [Issue Tab Panel](src/main/java/ru/teamlead/jira/plugins/tutorial/action/IssueTabExample.java).
5. Добавил [Dropdown и Dialog](src/main/resources/templates/tutorial/dropdown/dropdown-example.vm).
6. Логику наполнения таблицы данными добавил в [TutorialUtilsImpl](src/main/java/ru/teamlead/jira/plugins/tutorial/listener/TutorialUtilsImpl.java).
7. Описание Uml по [task2](uml/task2.md) находится [здесь](uml/uml-design.md).
8. Новый [jar](jira-plugin-tutorial-1.0.0-new.jar).

P.S. Работа с бд на примитивном уровне, да и все остальное)) в ввиду ограниченности во времени.
Готов доработать, в случае необходимости.

9. Добавил [web-panel](src/main/resources/templates/tutorial/webpanel/webpanel-example.vm) с Velocity в [Issue Tab Panel](src/main/java/ru/teamlead/jira/plugins/tutorial/action/IssueTabWithWebPanel.java).
10. [Реализовал](src/main/java/ru/teamlead/jira/plugins/tutorial/servlet/WebpanelServlet.java) добавление записей в [таблицу](src/main/java/ru/teamlead/jira/plugins/tutorial/ao/ExampleEntity.java) через форму.
---
11. Отправка [формы](src/main/resources/templates/tutorial/webpanel/webpanel-example.vm) посредством Javascript, Ajax. Сохранение по [ресту](src/main/java/ru/teamlead/jira/plugins/tutorial/rest/TutorialRest.java) (saveLink()).

P.S. Пока не разобрался с работой подстановки i18n, в процессе.