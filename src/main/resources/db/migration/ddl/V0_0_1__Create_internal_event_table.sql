create table if not exists internal_event
(
    id    uuid default gen_random_uuid() not null
        primary key,
    title text                           not null
);
