#!/bin/bash

java -cp /opt/devel/maven_repo/org/hsqldb/hsqldb/2.2.4/hsqldb-2.2.4.jar  org.hsqldb.server.Server --database.0 mem:mydb --dbname.0 workdb
