Описание проекта и API:

Технологии: Spring Boot/Java

1.	POST - /auth/login – аутентификация пользователя

Принимает username и password пользователя, сравнивает с данными в БД, и, возвращает JWT-токен, если находит пользователя. В противном случае возвращает ошибку 403.

Пример запроса:
```json
{
  "username": "aaa",
  "password": "111"
}
```

Пример ответа:
```json
{
  "token": "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJh…"
}
```




2.	GET - /api/music-bands/data – получение списка всех музыкальных групп

Принимает JWT-токен пользователя в заголовке запроса, проверяет его валидность, и, если токен валидный, отправляет пользователю список всех музыкальных групп в формате JSON. В противном случае возвращает ошибку 403.

Пример запроса: 
```json
Authorization   Bearer eyJhbGciOiJIUzM4NCJ...
```
 
Пример ответа:
```json
[
  {
    "id": 1,
    "name": "elecrosila",
    "numberOfParticipants": 1,
    "singlesCount": 3,
    "albumsCount": 5
  },
  {
    "id": 2,
    "name": "21 pilots",
    "numberOfParticipants": 1,
    "singlesCount": 3,
    "albumsCount": 5
  }
]
```

 




3.	POST - /api/music-bands – создание новой группы

Принимает JWT-токен пользователя в заголовке запроса, заполненные поля группы, которую пользователь хочет создать. Проверяет JWT-токен пользователя и, если токен валидный, добавляет группу в БД. В противном случае возвращает ошибку 403. 

Пример запроса:
```json
Authorization   Bearer eyJhbGciOiJIUzM4NCJ...
```

```json
{
  "name": "21 pilots",
  "numberOfParticipants": 1,
  "singlesCount": 3,
  "albumsCount": 5
}
```

Пример ответа:
```json
{
  "id": 3,
  "name": "21 pilots",
  "numberOfParticipants": 1,
  "singlesCount": 3,
  "albumsCount": 5
}
```


Меры защиты от уязвимостей:

API использует JWT-токены для защиты эндпоинтов.

•	Пользователь проходит аутентификацию через POST - /auth/login
•	Пользователь получает JWT-токен
•	Ключ токена шифруется методом HMAC SHA-256
•	Для доступа к остальным эндпоинтам необходимо передавать токен в заголовке запроса
•	Пароли хэшируются методом BCrypt
•	Время жизни токена 2 часа

**Защита от SQL-инъекций:**

Используется Spring Data JPA, что означает, что все запросы к базе данных являются параметризованными. Spring Data JPA автоматически создает prepared statements, что делает код устойчивым к SQL-инъекциям.

**Защита от XSS:**

1.	Данные передаются в формате JSON, который не исполняет JavaScript.
2.	Используется санитайзер, который экранирует пользовательские данные.

```java
@Service
public class HtmlSanitizerService {

    private static final PolicyFactory POLICY = Sanitizers.FORMATTING.and(Sanitizers.LINKS);

    public String sanitize(String input) {
        if (input == null) {
            return null;
        }
        return POLICY.sanitize(input);
    }
}
```
```java
@PostMapping
public MusicBand createMusicBand(@RequestBody MusicBand musicBand) {
    String originalName = musicBand.getName();
    String sanitizedName = sanitizerService.sanitize(originalName);
    musicBand.setName(sanitizedName);
    return musicBandService.create(musicBand);
}
```



Отчеты SAST/SCA:



<img width="680" height="410" alt="image" src="https://github.com/user-attachments/assets/a5d294b3-b865-48c3-bb69-2802750b84ba" />
<img width="874" height="428" alt="image" src="https://github.com/user-attachments/assets/e522fb98-35c9-44a5-830e-fd005f72cda1" />


Ссылка на последний успешный запуск в pipeline репозитории:
https://github.com/E-v-e-l-i-n-e/information-security/actions/runs/18329664400
