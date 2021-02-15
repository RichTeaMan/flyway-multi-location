# Flyway Migration Demo

A small project demonstrating Flyway migration into a H2 database.

## Running Migration

```bash
mvn flyway:migration
```

## Testing

```mvn spring-boot:run
```

Navigate to http://localhost:5000/h2-console

JDBC URL: `jdbc:h2:./data/demo`
User Name: `sa`
Password: `password`
