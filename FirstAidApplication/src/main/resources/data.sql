insert into categories(id, name) values
                                     (gen_random_uuid(), 'Oparzenia'),
                                     (gen_random_uuid(), 'Krwotok'),
                                     (gen_random_uuid(), 'Rany'),
                                     (gen_random_uuid(), 'Skręcenie'),
                                     (gen_random_uuid(), 'Wstrząs urazowy'),
                                     (gen_random_uuid(), 'Uszkodzenia narządów wewnętrznych'),
                                     (gen_random_uuid(), 'Zwichnięcie'),
                                     (gen_random_uuid(), 'Ugryzienia'),
                                     (gen_random_uuid(), 'Rany postrzałowe'),
                                     (gen_random_uuid(), 'Stłuczenia'),
                                     (gen_random_uuid(), 'Ukąszenia'),
                                     (gen_random_uuid(), 'Zranienia'),
                                     (gen_random_uuid(), 'Omdlenia'),
                                     (gen_random_uuid(), 'Poparzenia chemiczne'),
                                     (gen_random_uuid(), 'Zadrapania'),
                                     (gen_random_uuid(), 'Zatrucia'),
                                     (gen_random_uuid(), 'Złamania'),
                                     (gen_random_uuid(), 'Urwania kończyn'),
                                     (gen_random_uuid(), 'Inne');
insert into emergency_calls(id, name, category_id)  values
                                          (gen_random_uuid(), 'Jak leczyć oparzenia głowy?' ,(select id from categories where name='Oparzenia')),
                                          (gen_random_uuid(), 'Jak leczyć oparzenia ręki?',(select id from categories where name='Oparzenia')),
                                          (gen_random_uuid(), 'Jak leczyć poważne oparzenia?',(select id from categories where name='Oparzenia'));