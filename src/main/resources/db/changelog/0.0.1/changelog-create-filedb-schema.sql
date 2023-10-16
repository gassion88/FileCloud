--liquibase formatted sql

--changeset SoslanGassiev:create-filecloud-schema
--comment create new schema

create schema filecloud
--rollback drop schema filecloud;