CREATE USER simple WITH LOGIN PASSWORD 'simple';

ALTER ROLE simple superuser createdb;

CREATE DATABASE sampleDB OWNER simple ENCODING 'utf-8';