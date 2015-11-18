# ToTripComposer
Приложение отправлят HTTP запрос на http://tripcomposer.net/rest/test/countries/get методом POST в формате JSON. 
Получает ответ также в формате JSON, преобразует его в Java-классы (представляющие города и страны), после чего сохраняет данные в PostgreSQL. Инверсия управления реализуется с помощью Spring, работа с базой данных - Hibernate (Настройки соединения с БД - см. файл resources/spring-context.xml).   
Точка входа - класс ua.kushnirenko.ivan.service.Main, JavaDoc этого класса содержит краткое описание работы приложения c навигацией по коду. 

