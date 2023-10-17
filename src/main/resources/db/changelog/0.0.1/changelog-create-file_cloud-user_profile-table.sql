--liquibase formatted sql

--changeset SoslanGassiev:create-file_cloud-user_profiles-table
--comment create table file_cloud.user_profiles
create table file_cloud.user_profiles
(
    id         integer primary key,
    nickname   varchar(32)  not null,
    image_link varchar(128) not null
);
--rollback drop table file_cloud.user_profiles;

--changeset SoslanGassiev:add-file_cloud-user_profiles-table-constraints
--comment add constraints to file_cloud.user_profiles table
alter table file_cloud.user_profiles
    add constraint user_profiles__user_accounts__fk
        foreign key (id) references identity.user_accounts (id);

alter table file_cloud.user_profiles
    add constraint user_profiles__nickname__unique
        unique (nickname);
--rollback alter table file_cloud.user_profiles drop constraint user_profiles__user_accounts__fk;
--rollback alter table file_cloud.user_profiles drop constraint user_profiles__nickname__unique;