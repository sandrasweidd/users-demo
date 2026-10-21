# users-demo: CRUD lal Users b Spring Boot

Mashrou3 sghir la tetmarran 3ala OOP ma3 Spring Boot.

## Kif t-shaghglo

**IntelliJ (el ashal):**
1. File > Open > ekhtar el folder `users-demo` (fi `pom.xml`, IntelliJ bya3ref eno Maven).
2. Stanna l IntelliJ ynazzel el dependencies.
3. Efta7 `UsersDemoApplication.java` w kbos ▶️ Run.
4. El app byeshtghel 3ala `http://localhost:8080`.

**Men el terminal (eza 3andak Maven):**
```
mvn spring-boot:run
```

**La tshaghel el test:** `mvn test` aw kbos ▶️ 7ad `UserControllerTest` bi IntelliJ.

## Jarreb el API

Fik testa3mel Postman, aw curl:

```bash
# Create
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"name":"Ali","email":"ali@test.com","password":"secret123"}'

# Kel el users
curl http://localhost:8080/api/users

# User wa7ad
curl http://localhost:8080/api/users/1

# Update
curl -X PUT http://localhost:8080/api/users/1 \
  -H "Content-Type: application/json" \
  -d '{"name":"Ali Hassan","email":"ali@test.com","password":"secret123"}'

# Delete
curl -X DELETE http://localhost:8080/api/users/1
```

Database console: `http://localhost:8080/h2-console`
(JDBC URL: `jdbc:h2:mem:usersdb`, user: `sa`, password fadi)

## Wen kel mafhoum OOP

| Mafhoum | El file |
|---|---|
| Class / Object | `entity/User.java`, w `new User(...)` bi `UserServiceImpl` |
| Encapsulation | `private` fields bi `User` + `UserResponse` ma fiya password |
| Inheritance | `User extends BaseEntity`, `UserRepository extends JpaRepository`, el exceptions |
| Interface | `service/UserService.java` |
| Polymorphism | `UserController` byesta3mel `UserService` w Spring byeb3at `UserServiceImpl` |
