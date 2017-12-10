# openfire-bind

[![Build Status](https://travis-ci.org/jinahya/openfire-bind.svg?branch=master)](https://travis-ci.org/jinahya/openfire-bind)
[![Maven metadata URI](https://img.shields.io/maven-metadata/v/http/central.maven.org/maven2/com/github/jinahya/openfire-bind/maven-metadata.xml.svg)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.github.jinahya%22%20AND%20a%3A%22openfire-bind%22)
[![Javadocs](http://javadoc.io/badge/com.github.jinahya/openfire-bind.svg)](http://javadoc.io/doc/com.github.jinahya/openfire-bind)

##

## tesitng against exsiting databases

#### common properties

|name                 |description                           |
|---------------------|--------------------------------------|
|`jdbc.driver.version`|version of the target driver artifact.|
|`jdbc.driver`        |driver class name                     |
|`jdbc.url`           |JDBC url of the target database       |
|`jdbc.user`          |username of the database              |
|`jdbc.password`      |password of the database              |
|`xmpp.domain`        |XMPP domain name                      |

#### \<database\>

|name                 |description                           |
|---------------------|--------------------------------------|
|`mysql`|version of the target driver artifact.|

### JPA

```
$ mvn -Pjpa,<provider>,<database> \
      -Dpersistence.provider.version=... \
      -Djdbc.driver.version= ...\
      -Djdbc.driver=...\
      -Djdbc.user=...\
      -Djdbc.password=....
      clean
      test
```

#### \<provider\>

|name         |artifact                                                             |
|-------------|---------------------------------------------------------------------|
|`eclipselink`|`org.eclipse.persistence:eclipselink:${persistence.provider.version}`|
|`hibernate`  |`org.hibernate:hibernate-core:${persistence.provider.version}`       |

#### properties

|name                          |description                                        |
|------------------------------|---------------------------------------------------|
|`persistence.provider.version`|version of the target persistence provider artifact|

### examples

#### eclipselink / mysql

```
$ mvn -Pjpa,eclipselink,mysql \
      -Dpersistence.provider.version=2.7.0 \
      -Djdbc.driver.version=5.1.44 \
      -Djdbc.driver=com.mysql.jdbc.Driver \
      -Djdbc.url="jdbc:mysql://xxx.xxx.xxx.xxx:3306/yyy" \
      -Djdbc.user=some \
      -Djdbc.password = some \
      clean
      test
```

### MyBatis
