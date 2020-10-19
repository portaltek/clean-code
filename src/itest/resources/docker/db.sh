#!/usr/bin/env bash

create_db() {
    docker run --name cleancode_db_itest --env MYSQL_ROOT_PASSWORD=root_password -p 4306:3306 -d mysql:8.0.21
}

delete_db() {
    docker rm -f cleancode_db_itest
}

#update_db() {
#    docker rm -f cleancode_db_itest
#}

case "${1}" in
    "create") echo Creating Integration Test DB && create_db;;
    "delete") echo Deleting Integration Test DB && delete_db;;
esac