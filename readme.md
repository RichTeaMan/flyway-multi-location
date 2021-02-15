# Flyway Multiple Location Demo

A small project demonstrating Flyway migration into a H2 database with multiple reference data configurations.

## Reference Data

Depending on different deployment needs a database may need different reference data. This project shows how Flyway can have different directories to mix and match migrations.

Note that the migration history is still preserved. A V2 configuration cannot be applied to a V2 from another directory.

Also note that versioned migrations may skip numbers. eg, V1 -> V3 without a V2 script is valid. However, a V2 script cannot be applied afterwards.

## Running Migration

Script directories must be passed into the Flyway tool. This project organises scripts into common, site-a, site b:
* `db/migration/common` pertains to schema changes. This should only have definition changes, such as tables, columns, and views.
* `db/migration/site-a` has reference data for 'site A'.
* `db/migration/site-b` has reference data for 'site B'.

These directories are only a convention, more sites or a test set could be added as necessary. Schema changes could also be added to specific directories, but this should be done with extreme caution.

With this layout, a site and the common directory should be chosen:

```bash
# a rebuild is necessary
mvn install
mvn flyway:migrate -Dflyway.locations=db/migration/common,db/migration/site-a
```

### Other Migrations

```bash
mvn flyway:migrate -Dflyway.locations=db/migration/common,db/migration/site-b
```

An empty database with no data could be done with just common:

```bash
mvn flyway:migrate -Dflyway.locations=db/migration/common
```

## Testing

```bash
mvn spring-boot:run
```

Navigate to http://localhost:5000/h2-console

JDBC URL: `jdbc:h2:./data/demo`
User Name: `sa`
Password: `password`
