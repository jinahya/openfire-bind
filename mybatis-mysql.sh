#!/bin/sh
mvn -Pmybatis,mysql -Ddriver.version=5.1.44 -Djdbc.driver=com.mysql.jdbc.Driver -Djdbc.url="jdbc:mysql://192.168.56.101:3306/openfire" -Djdbc.user=openfire -Djdbc.password=openfire clean test
