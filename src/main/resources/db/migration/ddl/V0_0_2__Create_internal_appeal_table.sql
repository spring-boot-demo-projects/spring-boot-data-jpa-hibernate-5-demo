create table if not exists internal_appeal
(
    id       uuid default gen_random_uuid() not null
        primary key,
    event_id uuid                           not null
        constraint internal_appeal_event_id_fk references internal_event (id)
);
create index if not exists internal_appeal_event_id_index on internal_appeal (event_id);
