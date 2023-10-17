--liquibase formatted sql

--changeset SoslanGassiev:create-file_cloud-schema
--comment create new schema

create schema file_cloud
--rollback drop schema file_cloud;