-- upgrade from ver 1.8.0 to 1.9.0

alter table lexeme add column type varchar(50);
update lexeme set type = 'PRIMARY' where type is null;
alter table lexeme alter column type set not null;
create index lexeme_type_idx on lexeme(type);

create index dataset_code_idx on dataset(code);
create index dataset_type_idx on dataset(type);

drop type if exists type_term_meaning_word;
create type type_term_meaning_word as (word_id bigint, word text, homonym_nr integer, lang char(3), word_type_codes varchar(100) array, dataset_codes varchar(10) array, matching_word boolean);

drop table if exists temp_ds_import_pk_map cascade;
create table temp_ds_import_pk_map
(
  id bigserial primary key,
  import_code varchar(100) not null,
  created_on timestamp not null default statement_timestamp(),
  table_name text not null,
  source_pk bigint not null,
  target_pk bigint not null
);

create index temp_ds_import_pk_map_import_code_idx on temp_ds_import_pk_map(import_code);
create index temp_ds_import_pk_map_table_name_idx on temp_ds_import_pk_map(table_name);
create index temp_ds_import_pk_map_source_pk_idx on temp_ds_import_pk_map(source_pk);
create index temp_ds_import_pk_map_target_pk_idx on temp_ds_import_pk_map(target_pk);

drop table if exists temp_ds_import_queue cascade;
create table temp_ds_import_queue
(
  id bigserial primary key,
  import_code varchar(100) not null,
  created_on timestamp not null default statement_timestamp(),
  table_name text not null,
  content text not null  
);

create index temp_ds_import_queue_import_code_idx on temp_ds_import_queue(import_code);
create index temp_ds_import_queue_table_name_idx on temp_ds_import_queue(table_name);

update word_relation set relation_status = 'PROCESSED' where relation_status = 'CONFIRMED';

begin;

alter table definition_dataset
drop constraint definition_dataset_dataset_code_fkey;

alter table definition_dataset
add constraint definition_dataset_dataset_code_fkey
foreign key (dataset_code)
references dataset (code)
on update no action
on delete cascade;

commit;

-- level3 has been removed from views, recreate or delete views before running this
alter table lexeme
drop column level3;

create table semantic_type
(
  code varchar(100) primary key,
  datasets varchar(10) array not null,
  order_by bigserial
);

create table semantic_type_label
(
  code varchar(100) references semantic_type(code) on delete cascade not null,
  value text not null,
  lang char(3) references language(code) not null,
  type varchar(10) references label_type(code) not null,
  unique(code, lang, type)
);

create table meaning_semantic_type
(
  id bigserial primary key,
  meaning_id bigint references meaning(id) on delete cascade not null,
  semantic_type_code varchar(100) references semantic_type(code) not null,
  order_by bigserial,
  unique(meaning_id, semantic_type_code)
);
alter sequence meaning_semantic_type_id_seq restart with 10000;

create index meaning_semantic_type_meaning_id_idx on meaning_semantic_type(meaning_id);

insert into semantic_type (code, datasets) values ('abstr', '{}');
insert into semantic_type (code, datasets) values ('abstr/konkr', '{}');
insert into semantic_type (code, datasets) values ('abstr/konkr_omadus', '{}');
insert into semantic_type (code, datasets) values ('abstr_asend/suund', '{}');
insert into semantic_type (code, datasets) values ('ADV_aeg', '{}');
insert into semantic_type (code, datasets) values ('ADV_aste', '{}');
insert into semantic_type (code, datasets) values ('ADV_koht', '{}');
insert into semantic_type (code, datasets) values ('ADV_modaalsus', '{}');
insert into semantic_type (code, datasets) values ('ADV_põhjus', '{}');
insert into semantic_type (code, datasets) values ('ADV_seisund', '{}');
insert into semantic_type (code, datasets) values ('ADV_tulemus', '{}');
insert into semantic_type (code, datasets) values ('ADV_viis', '{}');
insert into semantic_type (code, datasets) values ('aeg', '{}');
insert into semantic_type (code, datasets) values ('aeg_aastaaeg', '{}');
insert into semantic_type (code, datasets) values ('aeg_kuu', '{}');
insert into semantic_type (code, datasets) values ('aeg_nädalapäev', '{}');
insert into semantic_type (code, datasets) values ('aeg_tähtpäev', '{}');
insert into semantic_type (code, datasets) values ('amet', '{}');
insert into semantic_type (code, datasets) values ('auaste', '{}');
insert into semantic_type (code, datasets) values ('ese', '{}');
insert into semantic_type (code, datasets) values ('ese_anum', '{}');
insert into semantic_type (code, datasets) values ('ese_instru', '{}');
insert into semantic_type (code, datasets) values ('ese_kunst', '{}');
insert into semantic_type (code, datasets) values ('ese_raha', '{}');
insert into semantic_type (code, datasets) values ('ese_riie', '{}');
insert into semantic_type (code, datasets) values ('ese_semio', '{}');
insert into semantic_type (code, datasets) values ('ese_semio_Piibli raamat', '{}');
insert into semantic_type (code, datasets) values ('esitus', '{}');
insert into semantic_type (code, datasets) values ('esitus_arv', '{}');
insert into semantic_type (code, datasets) values ('esitus_info', '{}');
insert into semantic_type (code, datasets) values ('esitus_keel', '{}');
insert into semantic_type (code, datasets) values ('esitus_keel_suhtlus', '{}');
insert into semantic_type (code, datasets) values ('esitus_keel_täht', '{}');
insert into semantic_type (code, datasets) values ('esitus_kujutis', '{}');
insert into semantic_type (code, datasets) values ('esitus_mõõt', '{}');
insert into semantic_type (code, datasets) values ('esitus_tiitel', '{}');
insert into semantic_type (code, datasets) values ('esitus_tähis', '{}');
insert into semantic_type (code, datasets) values ('inimene', '{}');
insert into semantic_type (code, datasets) values ('in_elukutse', '{}');
insert into semantic_type (code, datasets) values ('in_müt', '{}');
insert into semantic_type (code, datasets) values ('in_omadus', '{}');
insert into semantic_type (code, datasets) values ('in_rahvas', '{}');
insert into semantic_type (code, datasets) values ('in_rahvas_keel', '{}');
insert into semantic_type (code, datasets) values ('in_roll', '{}');
insert into semantic_type (code, datasets) values ('in_sugulane', '{}');
insert into semantic_type (code, datasets) values ('in_tegija', '{}');
insert into semantic_type (code, datasets) values ('kehaosa', '{}');
insert into semantic_type (code, datasets) values ('kehaosa_loom', '{}');
insert into semantic_type (code, datasets) values ('kogus', '{}');
insert into semantic_type (code, datasets) values ('koht', '{}');
insert into semantic_type (code, datasets) values ('koht_ala', '{}');
insert into semantic_type (code, datasets) values ('koht_asutus', '{}');
insert into semantic_type (code, datasets) values ('koht_geogr', '{}');
insert into semantic_type (code, datasets) values ('koht_geogr_maailmajagu', '{}');
insert into semantic_type (code, datasets) values ('koht_geogr_veekogu', '{}');
insert into semantic_type (code, datasets) values ('koht_hoone', '{}');
insert into semantic_type (code, datasets) values ('koht_kehaosa', '{}');
insert into semantic_type (code, datasets) values ('koht_loodus', '{}');
insert into semantic_type (code, datasets) values ('koht_suund/asend', '{}');
insert into semantic_type (code, datasets) values ('konkr', '{}');
insert into semantic_type (code, datasets) values ('konkr_omadus', '{}');
insert into semantic_type (code, datasets) values ('käsklus', '{}');
insert into semantic_type (code, datasets) values ('loom', '{}');
insert into semantic_type (code, datasets) values ('loom_kala', '{}');
insert into semantic_type (code, datasets) values ('loom_liik', '{}');
insert into semantic_type (code, datasets) values ('loom_lind', '{}');
insert into semantic_type (code, datasets) values ('loom_omadus', '{}');
insert into semantic_type (code, datasets) values ('loom_putukas', '{}');
insert into semantic_type (code, datasets) values ('materjal/aine', '{}');
insert into semantic_type (code, datasets) values ('nähtus', '{}');
insert into semantic_type (code, datasets) values ('nähtus_füüs', '{}');
insert into semantic_type (code, datasets) values ('nähtus_loodus', '{}');
insert into semantic_type (code, datasets) values ('nähtus_psühh', '{}');
insert into semantic_type (code, datasets) values ('objekt', '{}');
insert into semantic_type (code, datasets) values ('objekt_loodus', '{}');
insert into semantic_type (code, datasets) values ('objekt_loodus_tähtkuju', '{}');
insert into semantic_type (code, datasets) values ('omadus', '{}');
insert into semantic_type (code, datasets) values ('omadus_abstr', '{}');
insert into semantic_type (code, datasets) values ('omadus_aeg', '{}');
insert into semantic_type (code, datasets) values ('omadus_füüs', '{}');
insert into semantic_type (code, datasets) values ('omadus_füüs_värv', '{}');
insert into semantic_type (code, datasets) values ('omadus_koht', '{}');
insert into semantic_type (code, datasets) values ('omadus_kval', '{}');
insert into semantic_type (code, datasets) values ('omadus_psühh', '{}');
insert into semantic_type (code, datasets) values ('omadus_vanus', '{}');
insert into semantic_type (code, datasets) values ('organisatsioon', '{}');
insert into semantic_type (code, datasets) values ('organism', '{}');
insert into semantic_type (code, datasets) values ('seisund', '{}');
insert into semantic_type (code, datasets) values ('seisund_haigus', '{}');
insert into semantic_type (code, datasets) values ('seisund_füüs', '{}');
insert into semantic_type (code, datasets) values ('sündmus', '{}');
insert into semantic_type (code, datasets) values ('taim', '{}');
insert into semantic_type (code, datasets) values ('taim_liik', '{}');
insert into semantic_type (code, datasets) values ('taim_omadus', '{}');
insert into semantic_type (code, datasets) values ('taim_seen', '{}');
insert into semantic_type (code, datasets) values ('taim_õis', '{}');
insert into semantic_type (code, datasets) values ('tegevus', '{}');
insert into semantic_type (code, datasets) values ('tegevus_kõnetegu', '{}');
insert into semantic_type (code, datasets) values ('tegevus_muutus', '{}');
insert into semantic_type (code, datasets) values ('tegevus_mäng', '{}');
insert into semantic_type (code, datasets) values ('tegevus_tegu', '{}');
insert into semantic_type (code, datasets) values ('toit', '{}');
insert into semantic_type (code, datasets) values ('toit_jook', '{}');
insert into semantic_type (code, datasets) values ('toit_maitseaine', '{}');
insert into semantic_type (code, datasets) values ('toit_vili', '{}');
insert into semantic_type (code, datasets) values ('vald', '{}');
insert into semantic_type (code, datasets) values ('VERB_abstr', '{}');
insert into semantic_type (code, datasets) values ('VERB_aeg', '{}');
insert into semantic_type (code, datasets) values ('VERB_alustama', '{}');
insert into semantic_type (code, datasets) values ('VERB_grammatiline', '{}');
insert into semantic_type (code, datasets) values ('VERB_liigutama', '{}');
insert into semantic_type (code, datasets) values ('VERB_liikuma', '{}');
insert into semantic_type (code, datasets) values ('VERB_liikuma/liigutama', '{}');
insert into semantic_type (code, datasets) values ('VERB_modaalsus', '{}');
insert into semantic_type (code, datasets) values ('VERB_muutus', '{}');
insert into semantic_type (code, datasets) values ('VERB_muutust põhjustama', '{}');
insert into semantic_type (code, datasets) values ('VERB_nähtus', '{}');
insert into semantic_type (code, datasets) values ('VERB_seisund', '{}');
insert into semantic_type (code, datasets) values ('VERB_psühh', '{}');
insert into semantic_type (code, datasets) values ('VERB_psühh_emots', '{}');
insert into semantic_type (code, datasets) values ('VERB_psühh_mõistus', '{}');
insert into semantic_type (code, datasets) values ('VERB_suhtlus', '{}');
insert into semantic_type (code, datasets) values ('VERB_tegevus', '{}');
insert into semantic_type (code, datasets) values ('VERB_toimuma', '{}');
insert into semantic_type (code, datasets) values ('VERB_toituma', '{}');
insert into semantic_type (code, datasets) values ('üksus', '{}');

insert into semantic_type_label (code, value, lang, type) values ('abstr', 'abstraktne entiteet (nt üksus, suhe, süsteem)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('abstr', 'abstract entity', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('abstr/konkr', 'abstr/konkr entiteet (nt vahend, võttestik, teatav süsteem, meetod)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('abstr/konkr', 'abstract/concrete entity', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('abstr/konkr_omadus', 'esilduva omadusega abstr/konkr entiteet', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('abstr/konkr_omadus', 'abstr/concr_property', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('abstr_asend/suund', 'asend, suund, siht (abstr)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('abstr_asend/suund', 'position, direction, target', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('ADV_aeg', '(nt nüüd, eile)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('ADV_aste', '(nt väga, äärmiselt)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('ADV_koht', '(nt üles, ette)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('ADV_modaalsus', 'rõhuadverb (nt võib-olla, tõtt-öelda)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('ADV_põhjus', '(nt järelikult)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('ADV_seisund', 'seisundiadverb (nt kinni, lahti, välja)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('ADV_tulemus', 'märgib lõpetatust või tulemuslikkust, saavutust (nt välja, ära)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('ADV_viis', '(nt aeglaselt, hästi)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('aeg', 'ajalõik, piiratud või piiramata kestus', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('aeg', 'time', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('aeg_aastaaeg', 'aastaaeg (4 aastaaega)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('aeg_aastaaeg', 'time_season', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('aeg_kuu', 'kuu (12 kuud)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('aeg_kuu', 'time_month', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('aeg_nädalapäev', 'nädalapäev (7 päeva)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('aeg_nädalapäev', 'time_day', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('aeg_tähtpäev', 'tähtpäev, püha (nt küünlapäev, võidupäev)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('aeg_tähtpäev', 'time_holiday', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('amet', 'amet', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('auaste', 'auaste', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('ese', 'ese, objekt', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('ese', 'artefact, object', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('ese_anum', 'anum, nõu, mahuti', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('ese_anum', 'artefact_vessel', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('ese_instru', 'tööriist, sõiduvahend jt', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('ese_instru', 'artefact_instrument, vehicle', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('ese_kunst', 'kunstiteos, käsitöö, kunstilooming', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('ese_kunst', 'artefact_piece of art, handicraft', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('ese_raha', 'rahaühik, rahasumma vm vara', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('ese_raha', 'artefact_money', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('ese_riie', 'riietusese, rõivas, ka jalats', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('ese_riie', 'artefact_clothing', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('ese_semio', 'teos, sõnaline (märgiline) toode, programm jm', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('ese_semio', 'artefact_semiotical', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('ese_semio_Piibli raamat', 'Piibli raamat (Koguja raamat)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('ese_semio_Piibli raamat', 'artefact_semiotical_parts of the Bible', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('esitus', 'info, teave, nimetus, märk jt', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('esitus', 'representation', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('esitus_arv', 'arv, number, arvuline näitaja (nt viies, kolmandik)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('esitus_arv', 'representation_number', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('esitus_info', 'info, teave jt (nt aadress, andmed)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('esitus_info', 'representation_information, content', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('esitus_keel', '(grammatiline) keeleüksus, keeletermin', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('esitus_keel', 'representation_(grammatical) unit of language, linguistic term', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('esitus_keel_suhtlus', 'suhtlusüksus, kõnetlussõna, sõimusõna jms (nt braavo, härra, kurat)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('esitus_keel_suhtlus', 'representation_unit of communication', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('esitus_keel_täht', 'täht, häälik', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('esitus_keel_täht', 'representation_letter, sound', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('esitus_kujutis', 'pilt, sümbol, kujutis, märk', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('esitus_kujutis', 'representation_image, symbol', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('esitus_mõõt', 'mõõde, mõõt, mõõtühik, suurus, pikkus jt', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('esitus_mõõt', 'representation_quantity_definite', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('esitus_tiitel', 'seisuse, teaduskraadi nimetus, aunimetus', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('esitus_tiitel', 'representation_title', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('esitus_tähis', 'tähis, sümbol, märk (nt O, g)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('esitus_tähis', 'representation_symbol', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('inimene', 'inimolend, isik, indiviid', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('inimene', 'human, person', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('in_elukutse', 'elukutse, amet', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('in_elukutse', 'profession', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('in_müt', 'üleloomulik olend, muinasjututegelane vm (nt Punamütsike)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('in_müt', 'human_mythological', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('in_omadus', 'esilduva omadusega inimene', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('in_omadus', 'human_his property', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('in_rahvas', 'teatud rahva esindaja, rahvas, inimrühm', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('in_rahvas', 'human_nation', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('in_rahvas_keel', 'mingi rahvuse keel, keele nimetus', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('in_rahvas_keel', 'human_nation_language', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('in_roll', 'esilduva rolliga olend, mõttesuuna, sotsiaalse staatuse esindaja', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('in_roll', 'human_role', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('in_sugulane', 'teatava sugulussuhte esindaja', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('in_sugulane', 'human_relative', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('in_tegija', 'agent, tegevuse tegija, seisundis olija', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('in_tegija', 'human_agent of the activity, subject', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('kehaosa', 'inimese (ja looma) kehaosa', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('kehaosa', 'body part', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('kehaosa_loom', 'looma kehaosa', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('kehaosa_loom', 'body part_animal', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('kogus', 'n-ö puhas kogusesõna, kogus (mis tahes asja)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('kogus', 'amount', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('koht', 'ruumi, pinna, joone punkt või piirkond, asukoht', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('koht', 'place', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('koht_ala', 'maa-ala, piirkond', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('koht_ala', 'place_territorium', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('koht_asutus', 'asutus, institutsioon, teatav üksus', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('koht_asutus', 'institution', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('koht_geogr', 'kohanimi, geopoliitiline koht', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('koht_geogr', 'place name', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('koht_geogr_maailmajagu', 'maailmajagu', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('koht_geogr_maailmajagu', 'place name', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('koht_geogr_veekogu', 'ookean, meri, jõgi jm veekogud', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('koht_geogr_veekogu', 'place name_seas et al', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('koht_hoone', 'rajatis, (suurem) ehitis', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('koht_hoone', 'place_building', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('koht_kehaosa', 'kehapiirkond (ka loomal)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('koht_kehaosa', 'place_body part', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('koht_loodus', 'looduslik piirkond, pinnavorm', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('koht_loodus', 'place_nature', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('koht_suund/asend', 'suund, asupaik', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('koht_suund/asend', 'place_direction, location', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('konkr', 'konkreetne entiteet', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('konkr', 'concrete entity', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('konkr_omadus', 'esilduva omadusega konkreetne entiteet', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('konkr_omadus', 'concrete entity_its property', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('käsklus', 'käsklus', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('loom', 'loom', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('loom', 'animal', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('loom_kala', 'kala', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('loom_kala', 'animal_fish', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('loom_liik', 'liik/tüüp/rühm loomi', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('loom_liik', 'animal_kind/type/group of', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('loom_lind', 'lind', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('loom_lind', 'animal_bird', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('loom_omadus', 'esilduva omadusega loom', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('loom_omadus', 'animal_its property', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('loom_putukas', 'putukas, mardikas, lülijalgne', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('loom_putukas', 'animal_insect', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('materjal/aine', 'materjal, aine, sh keemiline element', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('materjal/aine', 'material/substance, incl. chemical elements', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('nähtus', 'asjade muutumine ajas, see, mis ilmneb, tekib', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('nähtus', 'phenomenon', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('nähtus_füüs', 'füüsikaline nähtus (nt heli)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('nähtus_füüs', 'phenomenon_physical', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('nähtus_loodus', 'loodusnähtus, loomulik, isetekkeline nähtus', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('nähtus_loodus', 'phenomenon_nature, natural kind', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('nähtus_psühh', 'tunne, psüühikaga seotud nähtus, kognitiivne fakt', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('nähtus_psühh', 'phenomenon_psychological, emotion', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('objekt', 'objekt', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('objekt', 'object', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('objekt_loodus', 'looduslik, loomulik objekt', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('objekt_loodus', 'object_natural', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('objekt_loodus_tähtkuju', 'tähtkujud (Kaljukits)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('objekt_loodus_tähtkuju', 'object_natural', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('omadus', 'omadus, iseloomulik tunnus', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('omadus', 'property', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('omadus_abstr', 'abstraktne omadus (nt väärtus)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('omadus_abstr', 'property_abstract', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('omadus_aeg', 'ajaga seotud omadus (nt suvine, eilne)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('omadus_aeg', 'property_time', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('omadus_füüs', 'füüsikaline omadus (mass, kõrgus, kiirus, heli, värv jne)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('omadus_füüs', 'physical property (weight, speed, height, sound, colour, etc)', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('omadus_füüs_värv', 'värv, värvus', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('omadus_füüs_värv', 'colour', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('omadus_koht', 'koha, asendi, suunaga seotud omadus (nt aknapoolne)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('omadus_koht', 'property_location', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('omadus_kval', 'sisuline omadus, hinnang (nt hea)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('omadus_kval', 'qualitative property', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('omadus_psühh', 'psüühikaga (tunnetega, tajuga) seotud omadus', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('omadus_psühh', 'property_psychological, cognitive, emotional', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('omadus_vanus', 'vanust kirjeldav omadus', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('organisatsioon', 'organisatsioon', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('organism', 'organism, elusolend', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('organism', 'living being', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('seisund', 'olek, seis teataval ajahetkel, üldine olukord', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('seisund', 'state', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('seisund_haigus', 'haiguslik seisund', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('seisund_haigus', 'state_illness, disease', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('seisund_füüs', '(asjade) füüsiline seisund', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('seisund_füüs', 'state_physical', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('sündmus', 'aja, koha ja tegevusega piiritletud sündmus, juhtum', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('sündmus', 'event', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('taim', 'taim, taimestik', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('taim', 'plant, flora', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('taim_liik', 'liik/tüüp/rühm taimi', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('taim_liik', 'plant_kind/type/group of', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('taim_omadus', 'esilduva omadusega taim', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('taim_omadus', 'plant_its property', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('taim_seen', 'seen', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('taim_seen', 'plant_mushroom', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('taim_õis', 'taime õis koos varrega', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('taim_õis', 'plant_flower together with its stalk', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('tegevus', 'tegevus, protsess', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('tegevus', 'activity, process', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('tegevus_kõnetegu', 'kõnetegu, suhtlusakt (nt käsk, palve, hüüatus)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('tegevus_kõnetegu', 'activity_speech act', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('tegevus_muutus', 'seisundit/olekut muutev tegevus', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('tegevus_muutus', 'activity_change', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('tegevus_mäng', 'sportmäng, lauamäng jt', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('tegevus_mäng', 'activity_game', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('tegevus_tegu', 'tegevuse üksikjuhtum, toiming, tegevuse tulemus', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('tegevus_tegu', 'activity_act, action', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('toit', 'toit, söök, toiduaine', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('toit', 'food', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('toit_jook', 'jook, vedelik joomiseks', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('toit_jook', 'food_drink', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('toit_maitseaine', 'maitseaine, vürts', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('toit_maitseaine', 'food_spice', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('toit_vili', 'taime osa toiduna', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('toit_vili', 'food_seed of the plant', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('vald', 'valdkond, eriala, tegevusala', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('vald', 'domain, speciality', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('VERB_abstr', 'abstraktse sisuga tegevus', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('VERB_abstr', 'verb_abstract', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('VERB_aeg', 'ajaga seostuv tegevus (nt kestma)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('VERB_aeg', 'verb_time', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('VERB_alustama', 'mingit tegevust alustama, inhoatiivne verb (nt panema)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('VERB_alustama', 'verb_inchoative', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('VERB_grammatiline', 'grammatilise funktsiooniga verb (nt tugiverb, abiverb)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('VERB_liigutama', 'liigutama, liigutusega tegema, liikuma panema (nt andma)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('VERB_liigutama', 'verb_cause to move', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('VERB_liikuma', 'mingil viisil liikuma ühest kohast teise (nt lendama)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('VERB_liikuma', 'verb_move', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('VERB_liikuma/liigutama', 'liikuma, liigutama (nt lendama)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('VERB_liikuma/liigutama', 'verb_move', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('VERB_modaalsus', 'võimalikkus, vajalikkus, tõenäosus (nt võima, tohtima, tarvitsema)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('VERB_modaalsus', 'verb_modality', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('VERB_muutus', 'muutuma (nii et seisund muutub), teisenema (nt haigestuma, lõhkuma, sulama)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('VERB_muutus', 'verb_change, transition', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('VERB_muutust põhjustama', 'muutma, (seisundi) muutust põhjustama', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('VERB_muutust põhjustama', 'verb_cause change', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('VERB_nähtus', 'heli tekitama, kõlama, loodusnähtus jm', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('VERB_nähtus', 'verb_act_phenomenon', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('VERB_seisund', 'olema, paiknema, asetsema; ka haigusseisund (nt asetsema, valutama)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('VERB_seisund', 'verb_be/exist, verb_state', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('VERB_psühh', 'psüühikaga seotud tegevus', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('VERB_psühh', 'verb_psychological state', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('VERB_psühh_emots', 'emotsioon (nt rõõmustama, vihkama)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('VERB_psühh_mõistus', 'teadma, mõistma (nt käsitlema, taipama)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('VERB_psühh_mõistus', 'verb_know', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('VERB_suhtlus', 'suuline või kirjalik suhtlus jm kõneaktid (nt käskima, kirjutama)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('VERB_suhtlus', 'verb_act_communication', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('VERB_tegevus', 'tegevus/protsess üldiselt, mingit tegevust sooritama (nt lööma)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('VERB_tegevus', 'verb_perform/do, verb_ execute', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('VERB_toimuma', 'toimuma, aset leidma, juhtuma (nt sattuma, juhtuma)', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('VERB_toimuma', 'verb_happen', 'eng', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('VERB_toituma', 'sööma, jooma, toiduga tegelema', 'est', 'descrip');
insert into semantic_type_label (code, value, lang, type) values ('üksus', 'üksus', 'est', 'descrip');

insert into meaning_semantic_type (meaning_id, semantic_type_code)
(select distinct on (ff.value_text, meaning_id) mff.meaning_id, ff.value_text
from meaning_freeform mff, freeform ff
where mff.freeform_id = ff.id
  and ff.type = 'SEMANTIC_TYPE');

insert into morph (code, datasets) values ('sing, nomn', '{}');
insert into morph (code, datasets) values ('pl, nomn', '{}');
insert into morph (code, datasets) values ('sing, gent', '{}');
insert into morph (code, datasets) values ('sing', '{}');
insert into morph (code, datasets) values ('pl', '{}');
insert into morph (code, datasets) values ('nomn', '{}');
insert into morph (code, datasets) values ('gent', '{}');
insert into morph (code, datasets) values ('gerundiiv', '{}');
insert into morph (code, datasets) values ('infinitiiv, imperf', '{}');
insert into morph (code, datasets) values ('infinitiiv, perf', '{}');
insert into morph (code, datasets) values ('infinitiiv, imperf, impe', '{}');
insert into morph (code, datasets) values ('infinitiiv, perf, impe', '{}');
insert into morph (code, datasets) values ('infinitiiv, imperf, perf', '{}');

insert into morph_label (code, value, lang, type) values ('sing, nomn', 'sing, nomn', 'est', 'descrip');
insert into morph_label (code, value, lang, type) values ('pl, nomn', 'pl, nomn', 'est', 'descrip');
insert into morph_label (code, value, lang, type) values ('sing, gent', 'sing, gent', 'est', 'descrip');
insert into morph_label (code, value, lang, type) values ('sing', 'sing', 'est', 'descrip');
insert into morph_label (code, value, lang, type) values ('pl', 'pl', 'est', 'descrip');
insert into morph_label (code, value, lang, type) values ('nomn', 'nomn', 'est', 'descrip');
insert into morph_label (code, value, lang, type) values ('gent', 'gent', 'est', 'descrip');
insert into morph_label (code, value, lang, type) values ('gerundiiv', 'gerundiiv', 'est', 'descrip');
insert into morph_label (code, value, lang, type) values ('infinitiiv, imperf', 'infinitiiv, imperf', 'est', 'descrip');
insert into morph_label (code, value, lang, type) values ('infinitiiv, perf', 'infinitiiv, perf', 'est', 'descrip');
insert into morph_label (code, value, lang, type) values ('infinitiiv, imperf, impe', 'infinitiiv, imperf, impe', 'est', 'descrip');
insert into morph_label (code, value, lang, type) values ('infinitiiv, perf, impe', 'infinitiiv, perf, impe', 'est', 'descrip');
insert into morph_label (code, value, lang, type) values ('infinitiiv, imperf, perf', 'infinitiiv, imperf, perf', 'est', 'descrip');

insert into gender (code, datasets) values ('mf', '{}');
insert into gender (code, datasets) values ('mn', '{}');

insert into gender_label (code, value, lang, type) values ('mf', 'meessugu ja naissugu', 'est', 'descrip');
insert into gender_label (code, value, lang, type) values ('mn', 'meessugu ja kesksugu', 'est', 'descrip');

insert into word_rel_type (code, datasets) values ('head', '{}');
insert into word_rel_type_label (code, value, lang, type) values ('head', 'põhisõna', 'est', 'full');
insert into word_rel_type_label (code, value, lang, type) values ('head', 'põhisõna', 'est', 'wordweb');

create table lex_rel_mapping
(
  code1 varchar(100) references lex_rel_type(code) on delete cascade not null,
  code2 varchar(100) references lex_rel_type(code) on delete cascade not null,
  unique(code1, code2)
);

create table word_rel_mapping
(
  code1 varchar(100) references word_rel_type(code) on delete cascade not null,
  code2 varchar(100) references word_rel_type(code) on delete cascade not null,
  unique(code1, code2)
);

create table meaning_rel_mapping
(
  code1 varchar(100) references meaning_rel_type(code) on delete cascade not null,
  code2 varchar(100) references meaning_rel_type(code) on delete cascade not null,
  unique(code1, code2)
);

create index lex_rel_mapping_code1_idx on lex_rel_mapping(code1);
create index lex_rel_mapping_code2_idx on lex_rel_mapping(code2);
create index word_rel_mapping_code1_idx on word_rel_mapping(code1);
create index word_rel_mapping_code2_idx on word_rel_mapping(code2);
create index meaning_rel_mapping_code1_idx on meaning_rel_mapping(code1);
create index meaning_rel_mapping_code2_idx on meaning_rel_mapping(code2);

insert into word_rel_mapping (code1, code2) values ('posit', 'komp');
insert into word_rel_mapping (code1, code2) values ('posit', 'superl');
insert into word_rel_mapping (code1, code2) values ('deriv_base', 'deriv');
insert into word_rel_mapping (code1, code2) values ('komp', 'posit');
insert into word_rel_mapping (code1, code2) values ('komp', 'superl');
insert into word_rel_mapping (code1, code2) values ('superl', 'posit');
insert into word_rel_mapping (code1, code2) values ('superl', 'komp');
insert into word_rel_mapping (code1, code2) values ('deriv', 'deriv_base');
insert into word_rel_mapping (code1, code2) values ('ühend', 'head');
insert into word_rel_mapping (code1, code2) values ('raw', 'raw');
insert into lex_rel_mapping (code1, code2) values ('comp', 'head');
insert into lex_rel_mapping (code1, code2) values ('head', 'comp');
insert into lex_rel_mapping (code1, code2) values ('head', 'vor');
insert into lex_rel_mapping (code1, code2) values ('head', 'yvr');
insert into lex_rel_mapping (code1, code2) values ('head', 'pyh');
insert into lex_rel_mapping (code1, code2) values ('head', 'yhvt');
insert into lex_rel_mapping (code1, code2) values ('head', 'lyh');
insert into lex_rel_mapping (code1, code2) values ('head', 'sub_word');
insert into lex_rel_mapping (code1, code2) values ('vor', 'head');
insert into lex_rel_mapping (code1, code2) values ('yvr', 'head');
insert into lex_rel_mapping (code1, code2) values ('pyh', 'head');
insert into lex_rel_mapping (code1, code2) values ('yhvt', 'head');
insert into lex_rel_mapping (code1, code2) values ('tvt:vrd', 'tvt:vrd');
insert into lex_rel_mapping (code1, code2) values ('tvt:vt ka', 'tvt:vt ka');
insert into lex_rel_mapping (code1, code2) values ('yvt:vrd', 'yvt:vrd');
insert into lex_rel_mapping (code1, code2) values ('yvt:vt ka', 'yvt:vt ka');
insert into lex_rel_mapping (code1, code2) values ('yvt:NB', 'yvt:NB');
insert into lex_rel_mapping (code1, code2) values ('lyh', 'head');
insert into lex_rel_mapping (code1, code2) values ('sub_word', 'head');
insert into meaning_rel_mapping (code1, code2) values ('antonüüm', 'antonüüm');
insert into meaning_rel_mapping (code1, code2) values ('kaashüponüüm', 'kaashüponüüm');
insert into meaning_rel_mapping (code1, code2) values ('määramata', 'määramata');
insert into meaning_rel_mapping (code1, code2) values ('soomõiste', 'liigimõiste');
insert into meaning_rel_mapping (code1, code2) values ('liigimõiste', 'soomõiste');
insert into meaning_rel_mapping (code1, code2) values ('tervikumõiste', 'osamõiste');
insert into meaning_rel_mapping (code1, code2) values ('osamõiste', 'tervikumõiste');
insert into meaning_rel_mapping (code1, code2) values ('kaasalluv mõiste', 'kaasalluv mõiste');
insert into meaning_rel_mapping (code1, code2) values ('seotud mõiste', 'seotud mõiste');
insert into meaning_rel_mapping (code1, code2) values ('põhjus', 'tagajärg');
insert into meaning_rel_mapping (code1, code2) values ('tagajärg', 'põhjus');
insert into meaning_rel_mapping (code1, code2) values ('eelnev', 'järgnev');
insert into meaning_rel_mapping (code1, code2) values ('järgnev', 'eelnev');
insert into meaning_rel_mapping (code1, code2) values ('vastand', 'vastand');
insert into meaning_rel_mapping (code1, code2) values ('vahend', 'eesmärk');
insert into meaning_rel_mapping (code1, code2) values ('eesmärk', 'vahend');
insert into meaning_rel_mapping (code1, code2) values ('tegevus', 'tegija');
insert into meaning_rel_mapping (code1, code2) values ('tegija', 'tegevus');
insert into meaning_rel_mapping (code1, code2) values ('dimensioon', 'mõõtühik');
insert into meaning_rel_mapping (code1, code2) values ('mõõtühik', 'dimensioon');
insert into meaning_rel_mapping (code1, code2) values ('tootja', 'toode');
insert into meaning_rel_mapping (code1, code2) values ('toode', 'tootja');
insert into meaning_rel_mapping (code1, code2) values ('ülemmõiste', 'alammõiste');
insert into meaning_rel_mapping (code1, code2) values ('alammõiste', 'ülemmõiste');
insert into meaning_rel_mapping (code1, code2) values ('üldmõiste', 'ainikmõiste');
insert into meaning_rel_mapping (code1, code2) values ('ainikmõiste', 'üldmõiste');

insert into language (code, datasets) values ('abe', '{}');
insert into language (code, datasets) values ('amh', '{}');
insert into language (code, datasets) values ('arc', '{}');
insert into language (code, datasets) values ('auf', '{}');
insert into language (code, datasets) values ('akk', '{}');
insert into language (code, datasets) values ('bre', '{}');
insert into language (code, datasets) values ('ewe', '{}');
insert into language (code, datasets) values ('gug', '{}');
insert into language (code, datasets) values ('qbp', '{}');
insert into language (code, datasets) values ('ibo', '{}');
insert into language (code, datasets) values ('iku', '{}');
insert into language (code, datasets) values ('ydg', '{}');
insert into language (code, datasets) values ('yor', '{}');
insert into language (code, datasets) values ('kab', '{}');
insert into language (code, datasets) values ('keb', '{}');
insert into language (code, datasets) values ('ltc', '{}');
insert into language (code, datasets) values ('aem', '{}');
insert into language (code, datasets) values ('myn', '{}');
insert into language (code, datasets) values ('arn', '{}');
insert into language (code, datasets) values ('rom', '{}');
insert into language (code, datasets) values ('xnt', '{}');
insert into language (code, datasets) values ('neg', '{}');
insert into language (code, datasets) values ('oji', '{}');
insert into language (code, datasets) values ('oac', '{}');
insert into language (code, datasets) values ('roh', '{}');
insert into language (code, datasets) values ('smo', '{}');
insert into language (code, datasets) values ('chr', '{}');
insert into language (code, datasets) values ('tpw', '{}');
insert into language (code, datasets) values ('ota', '{}');
insert into language (code, datasets) values ('umb', '{}');
insert into language (code, datasets) values ('uzb', '{}');
insert into language (code, datasets) values ('peo', '{}');

insert into language_label (code, value, lang, type) values ('abe', 'abnaki', 'est', 'descrip');
insert into language_label (code, value, lang, type) values ('abe', 'abnaki', 'est', 'wordweb');
insert into language_label (code, value, lang, type) values ('abe', 'abnaki keel', 'est', 'full');
insert into language_label (code, value, lang, type) values ('abe', 'abe', 'est', 'iso2');
insert into language_label (code, value, lang, type) values ('amh', 'amhari', 'est', 'descrip');
insert into language_label (code, value, lang, type) values ('amh', 'amhari', 'est', 'wordweb');
insert into language_label (code, value, lang, type) values ('amh', 'amhari keel', 'est', 'full');
insert into language_label (code, value, lang, type) values ('amh', 'am', 'est', 'iso2');
insert into language_label (code, value, lang, type) values ('arc', 'aramea', 'est', 'descrip');
insert into language_label (code, value, lang, type) values ('arc', 'aramea', 'est', 'wordweb');
insert into language_label (code, value, lang, type) values ('arc', 'aramea keel', 'est', 'full');
insert into language_label (code, value, lang, type) values ('arc', 'arc', 'est', 'iso2');
insert into language_label (code, value, lang, type) values ('auf', 'arava', 'est', 'descrip');
insert into language_label (code, value, lang, type) values ('auf', 'arava', 'est', 'wordweb');
insert into language_label (code, value, lang, type) values ('auf', 'arava keel', 'est', 'full');
insert into language_label (code, value, lang, type) values ('auf', 'auf', 'est', 'iso2');
insert into language_label (code, value, lang, type) values ('akk', 'assüüria', 'est', 'descrip');
insert into language_label (code, value, lang, type) values ('akk', 'assüüria', 'est', 'wordweb');
insert into language_label (code, value, lang, type) values ('akk', 'assüüria keel', 'est', 'full');
insert into language_label (code, value, lang, type) values ('akk', 'akk', 'est', 'iso2');
insert into language_label (code, value, lang, type) values ('bre', 'bretooni', 'est', 'descrip');
insert into language_label (code, value, lang, type) values ('bre', 'bretooni', 'est', 'wordweb');
insert into language_label (code, value, lang, type) values ('bre', 'bretooni keel', 'est', 'full');
insert into language_label (code, value, lang, type) values ('bre', 'br', 'est', 'iso2');
insert into language_label (code, value, lang, type) values ('ewe', 'eve', 'est', 'descrip');
insert into language_label (code, value, lang, type) values ('ewe', 'eve', 'est', 'wordweb');
insert into language_label (code, value, lang, type) values ('ewe', 'eve keel', 'est', 'full');
insert into language_label (code, value, lang, type) values ('ewe', 'ee', 'est', 'iso2');
insert into language_label (code, value, lang, type) values ('gug', 'guaranii', 'est', 'descrip');
insert into language_label (code, value, lang, type) values ('gug', 'guaranii', 'est', 'wordweb');
insert into language_label (code, value, lang, type) values ('gug', 'guaranii keel', 'est', 'full');
insert into language_label (code, value, lang, type) values ('gug', 'gug', 'est', 'iso2');
insert into language_label (code, value, lang, type) values ('qbp', 'gutni', 'est', 'descrip');
insert into language_label (code, value, lang, type) values ('qbp', 'gutni', 'est', 'wordweb');
insert into language_label (code, value, lang, type) values ('qbp', 'gutni keel', 'est', 'full');
insert into language_label (code, value, lang, type) values ('qbp', 'qbp', 'est', 'iso2');
insert into language_label (code, value, lang, type) values ('ibo', 'ibo', 'est', 'descrip');
insert into language_label (code, value, lang, type) values ('ibo', 'ibo', 'est', 'wordweb');
insert into language_label (code, value, lang, type) values ('ibo', 'ibo keel', 'est', 'full');
insert into language_label (code, value, lang, type) values ('ibo', 'ig', 'est', 'iso2');
insert into language_label (code, value, lang, type) values ('iku', 'inuktituti', 'est', 'descrip');
insert into language_label (code, value, lang, type) values ('iku', 'inuktituti', 'est', 'wordweb');
insert into language_label (code, value, lang, type) values ('iku', 'inuktituti keel', 'est', 'full');
insert into language_label (code, value, lang, type) values ('iku', 'iu', 'est', 'iso2');
insert into language_label (code, value, lang, type) values ('ydg', 'jidga', 'est', 'descrip');
insert into language_label (code, value, lang, type) values ('ydg', 'jidga', 'est', 'wordweb');
insert into language_label (code, value, lang, type) values ('ydg', 'jidga keel', 'est', 'full');
insert into language_label (code, value, lang, type) values ('ydg', 'ydg', 'est', 'iso2');
insert into language_label (code, value, lang, type) values ('yor', 'joruba', 'est', 'descrip');
insert into language_label (code, value, lang, type) values ('yor', 'joruba', 'est', 'wordweb');
insert into language_label (code, value, lang, type) values ('yor', 'joruba keel', 'est', 'full');
insert into language_label (code, value, lang, type) values ('yor', 'yo', 'est', 'iso2');
insert into language_label (code, value, lang, type) values ('kab', 'kabardi', 'est', 'descrip');
insert into language_label (code, value, lang, type) values ('kab', 'kabardi', 'est', 'wordweb');
insert into language_label (code, value, lang, type) values ('kab', 'kabardi keel', 'est', 'full');
insert into language_label (code, value, lang, type) values ('kab', 'kab', 'est', 'iso2');
insert into language_label (code, value, lang, type) values ('keb', 'kele', 'est', 'descrip');
insert into language_label (code, value, lang, type) values ('keb', 'kele', 'est', 'wordweb');
insert into language_label (code, value, lang, type) values ('keb', 'kele keel', 'est', 'full');
insert into language_label (code, value, lang, type) values ('keb', 'keb', 'est', 'iso2');
insert into language_label (code, value, lang, type) values ('ltc', 'keskhiina', 'est', 'descrip');
insert into language_label (code, value, lang, type) values ('ltc', 'keskhiina', 'est', 'wordweb');
insert into language_label (code, value, lang, type) values ('ltc', 'keskhiina keel', 'est', 'full');
insert into language_label (code, value, lang, type) values ('ltc', 'ltc', 'est', 'iso2');
insert into language_label (code, value, lang, type) values ('aem', 'krii', 'est', 'descrip');
insert into language_label (code, value, lang, type) values ('aem', 'krii', 'est', 'wordweb');
insert into language_label (code, value, lang, type) values ('aem', 'krii keel', 'est', 'full');
insert into language_label (code, value, lang, type) values ('aem', 'aem', 'est', 'iso2');
insert into language_label (code, value, lang, type) values ('myn', 'maaja', 'est', 'descrip');
insert into language_label (code, value, lang, type) values ('myn', 'maaja', 'est', 'wordweb');
insert into language_label (code, value, lang, type) values ('myn', 'maaja keel', 'est', 'full');
insert into language_label (code, value, lang, type) values ('myn', 'myn', 'est', 'iso2');
insert into language_label (code, value, lang, type) values ('arn', 'mapudunguni', 'est', 'descrip');
insert into language_label (code, value, lang, type) values ('arn', 'mapudunguni', 'est', 'wordweb');
insert into language_label (code, value, lang, type) values ('arn', 'mapudunguni keel', 'est', 'full');
insert into language_label (code, value, lang, type) values ('arn', 'arn', 'est', 'iso2');
insert into language_label (code, value, lang, type) values ('rom', 'mustlaskeel', 'est', 'descrip');
insert into language_label (code, value, lang, type) values ('rom', 'mustlaskeel', 'est', 'wordweb');
insert into language_label (code, value, lang, type) values ('rom', 'mustlaskeel mustlaskeel', 'est', 'full');
insert into language_label (code, value, lang, type) values ('rom', 'rom', 'est', 'iso2');
insert into language_label (code, value, lang, type) values ('xnt', 'narraganseti', 'est', 'descrip');
insert into language_label (code, value, lang, type) values ('xnt', 'narraganseti', 'est', 'wordweb');
insert into language_label (code, value, lang, type) values ('xnt', 'narraganseti keel', 'est', 'full');
insert into language_label (code, value, lang, type) values ('xnt', 'xnt', 'est', 'iso2');
insert into language_label (code, value, lang, type) values ('neg', 'negidali', 'est', 'descrip');
insert into language_label (code, value, lang, type) values ('neg', 'negidali', 'est', 'wordweb');
insert into language_label (code, value, lang, type) values ('neg', 'negidali keel', 'est', 'full');
insert into language_label (code, value, lang, type) values ('neg', 'neg', 'est', 'iso2');
insert into language_label (code, value, lang, type) values ('oji', 'odžibvei', 'est', 'descrip');
insert into language_label (code, value, lang, type) values ('oji', 'odžibvei', 'est', 'wordweb');
insert into language_label (code, value, lang, type) values ('oji', 'odžibvei keel', 'est', 'full');
insert into language_label (code, value, lang, type) values ('oji', 'oj', 'est', 'iso2');
insert into language_label (code, value, lang, type) values ('oac', 'orotši', 'est', 'descrip');
insert into language_label (code, value, lang, type) values ('oac', 'orotši', 'est', 'wordweb');
insert into language_label (code, value, lang, type) values ('oac', 'orotši keel', 'est', 'full');
insert into language_label (code, value, lang, type) values ('oac', 'oac', 'est', 'iso2');
insert into language_label (code, value, lang, type) values ('roh', 'retoromaani', 'est', 'descrip');
insert into language_label (code, value, lang, type) values ('roh', 'retoromaani', 'est', 'wordweb');
insert into language_label (code, value, lang, type) values ('roh', 'retoromaani keel', 'est', 'full');
insert into language_label (code, value, lang, type) values ('roh', 'rm', 'est', 'iso2');
insert into language_label (code, value, lang, type) values ('smo', 'samoa', 'est', 'descrip');
insert into language_label (code, value, lang, type) values ('smo', 'samoa', 'est', 'wordweb');
insert into language_label (code, value, lang, type) values ('smo', 'samoa keel', 'est', 'full');
insert into language_label (code, value, lang, type) values ('smo', 'sm', 'est', 'iso2');
insert into language_label (code, value, lang, type) values ('chr', 'tšerokii', 'est', 'descrip');
insert into language_label (code, value, lang, type) values ('chr', 'tšerokii', 'est', 'wordweb');
insert into language_label (code, value, lang, type) values ('chr', 'tšerokii keel', 'est', 'full');
insert into language_label (code, value, lang, type) values ('chr', 'chr', 'est', 'iso2');
insert into language_label (code, value, lang, type) values ('tpw', 'tupii', 'est', 'descrip');
insert into language_label (code, value, lang, type) values ('tpw', 'tupii', 'est', 'wordweb');
insert into language_label (code, value, lang, type) values ('tpw', 'tupii keel', 'est', 'full');
insert into language_label (code, value, lang, type) values ('tpw', 'tpw', 'est', 'iso2');
insert into language_label (code, value, lang, type) values ('ota', 'türgi (osmani)', 'est', 'descrip');
insert into language_label (code, value, lang, type) values ('ota', 'türgi (osmani)', 'est', 'wordweb');
insert into language_label (code, value, lang, type) values ('ota', 'türgi (osmani) keel', 'est', 'full');
insert into language_label (code, value, lang, type) values ('ota', 'ota', 'est', 'iso2');
insert into language_label (code, value, lang, type) values ('umb', 'umbundu', 'est', 'descrip');
insert into language_label (code, value, lang, type) values ('umb', 'umbundu', 'est', 'wordweb');
insert into language_label (code, value, lang, type) values ('umb', 'umbundu', 'est', 'full');
insert into language_label (code, value, lang, type) values ('umb', 'umb', 'est', 'iso2');
insert into language_label (code, value, lang, type) values ('uzb', 'usbeki', 'est', 'descrip');
insert into language_label (code, value, lang, type) values ('uzb', 'usbeki', 'est', 'wordweb');
insert into language_label (code, value, lang, type) values ('uzb', 'usbeki keel', 'est', 'full');
insert into language_label (code, value, lang, type) values ('uzb', 'uz', 'est', 'iso2');
insert into language_label (code, value, lang, type) values ('peo', 'vanapärsia', 'est', 'descrip');
insert into language_label (code, value, lang, type) values ('peo', 'vanapärsia', 'est', 'wordweb');
insert into language_label (code, value, lang, type) values ('peo', 'vanapärsia keel', 'est', 'full');
insert into language_label (code, value, lang, type) values ('peo', 'peo', 'est', 'iso2');
insert into language_label (code, value, lang, type) values ('abe', 'Abenaki', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('abe', 'Abenaki', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('akk', 'Akkadian', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('akk', 'Akkadian', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('amh', 'Amharic', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('amh', 'Amharic', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('arc', 'Aramean', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('arc', 'Aramean', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('auf', 'Arawan', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('auf', 'Arawan', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('bre', 'Breton', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('bre', 'Breton', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('car', 'Caribbean', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('car', 'Caribbean', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('chr', 'Cherokee', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('chr', 'Cherokee', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('ewe', 'Ewe', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('ewe', 'Ewe', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('gug', 'Guarani', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('gug', 'Guarani', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('ibo', 'Igbo', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('ibo', 'Igbo', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('iku', 'Inuktituti', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('iku', 'Inuktituti', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('kab', 'Kabardian', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('kab', 'Kabardian', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('xas', 'Kamassian', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('xas', 'Kamassian', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('keb', 'Kélé', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('keb', 'Kélé', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('aem', 'Krik', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('aem', 'Krik', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('lud', 'Lydian', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('lud', 'Lydian', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('mlg', 'Malagasy', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('mlg', 'Malagasy', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('mns', 'Mansi', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('mns', 'Mansi', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('arn', 'Mapuche', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('arn', 'Mapuche', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('myn', 'Mayan', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('myn', 'Mayan', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('ltc', 'Middle Chineseh', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('ltc', 'Middle Chinese', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('xnt', 'Narragansett', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('xnt', 'Narragansett', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('neg', 'Negidal', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('neg', 'Negidal', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('yrk', 'Nenets', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('yrk', 'Nenets', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('nep', 'Nepal', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('nep', 'Nepal', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('nio', 'Nganassan', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('nio', 'Nganassan', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('nor', 'Norwegian', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('nor', 'Norwegian', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('oji', 'Ojibwa', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('oji', 'Ojibwa', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('non', 'Old Norse', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('non', 'Old Norse', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('peo', 'Old Persian', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('peo', 'Old Persian', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('oac', 'Oroch', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('oac', 'Oroch', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('oss', 'Ossetian', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('oss', 'Ossetian', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('roh', 'Rhaeto-Romance', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('roh', 'Rhaeto-Romance', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('rom', 'Romani', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('rom', 'Romani', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('smo', 'Samoan', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('smo', 'Samoan', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('srh', 'Sarikoli', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('srh', 'Sarikoli', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('dak', 'Sioux', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('dak', 'Sioux', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('tpw', 'Tupi', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('tpw', 'Tupi', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('ota', 'Turkish (Ottoman)', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('ota', 'Turkish (Ottoman)', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('umb', 'Umbundu', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('umb', 'Umbundu', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('uzb', 'Uzbek', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('uzb', 'Uzbek', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('ydg', 'Yidgha', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('ydg', 'Yidgha', 'eng', 'wordweb');
insert into language_label (code, value, lang, type) values ('yor', 'Yoruba', 'eng', 'descrip');
insert into language_label (code, value, lang, type) values ('yor', 'Yoruba', 'eng', 'wordweb');

create index lifecycle_log_event_by_idx on lifecycle_log(event_by);
create index definition_complexity_idx on definition(complexity);
