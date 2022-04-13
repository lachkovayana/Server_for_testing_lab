create table task
(
    uuid   varchar(255) not null
        primary key,
    input  varchar(255),
    result integer
);

alter table task
    owner to hits;

