# ToTripComposer
Приложение отправлят HTTP запрос на http://tripcomposer.net/rest/test/countries/get методом POST.
Полученный ответ сохраняет в PostgreSQL. 
Использован Spring, с помощью которого реализуется IoC.
Работа с базой данных реализована с помощью Hibernate, настройки соединения прописаны в resources/spring-context.xml 
Запускается приложение из класса ua.kushnirenko.ivan.service.Main.
JavaDoc этого класса содержит краткое описание работы приложения c навигацией по коду. 

