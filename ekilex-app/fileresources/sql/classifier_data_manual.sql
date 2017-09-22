insert into lang (code, value) values ('est', 'Estonian');
insert into lang (code, value) values ('eng', 'English');
insert into lang (code, value) values ('rus', 'Russian');
insert into lang (code, value) values ('lat', 'Latin');

insert into label_type (code, value) values ('capital', 'capital');
insert into label_type (code, value) values ('abbrev', 'abbrev');
insert into label_type (code, value) values ('ekimorfo', 'ekimorfo');
insert into label_type (code, value) values ('descrip', 'descrip');
insert into label_type (code, value) values ('full', 'full');

insert into dataset (code, name) values ('eos', 'Õigekeelsussõnaraamat ÕS 2013');
insert into dataset (code, name) values ('ss_', 'Eesti keele seletav sõnaraamat');
insert into dataset (code, name) values ('sys', 'Sünonüümisõnastik');
insert into dataset (code, name) values ('evs', 'Eesti-vene sõnaraamat');
insert into dataset (code, name) values ('qq2', 'Eesti-vene sõnaraamat');

insert into lex_rel_type (code, dataset) values ('comp', '{eos, ss_, sys, evs}');

insert into lex_rel_type_label (code, value, lang, type) values ('comp', 'liitsõna', 'est', 'full');

insert into pos (code, dataset) values ('adj', '{eos, ss_, sys, evs}');
insert into pos (code, dataset) values ('adj + ID', '{eos, ss_, sys, evs}');
insert into pos (code, dataset) values ('adv', '{eos, ss_, sys, evs}');
insert into pos (code, dataset) values ('adjg', '{eos, ss_, sys, evs}');
insert into pos (code, dataset) values ('prop', '{eos, ss_, sys, evs}');
insert into pos (code, dataset) values ('interj', '{eos, ss_, sys, evs}');
insert into pos (code, dataset) values ('konj', '{eos, ss_, sys, evs}');
insert into pos (code, dataset) values ('adp', '{eos, ss_, sys, evs}');
insert into pos (code, dataset) values ('postp', '{eos, ss_, sys, evs}');
insert into pos (code, dataset) values ('prep', '{eos, ss_, sys, evs}');
insert into pos (code, dataset) values ('num', '{eos, ss_, sys, evs}');
insert into pos (code, dataset) values ('ord', '{eos, ss_, sys, evs}');
insert into pos (code, dataset) values ('pron', '{eos, ss_, sys, evs}');
insert into pos (code, dataset) values ('pron + ID', '{eos, ss_, sys, evs}');
insert into pos (code, dataset) values ('s', '{eos, ss_, sys, evs}');
insert into pos (code, dataset) values ('v', '{eos, ss_, sys, evs}');
insert into pos (code, dataset) values ('x', '{eos, ss_, sys, evs}');

insert into pos_label (code, value, lang, type) values ('adj', 'A', 'est', 'capital');
insert into pos_label (code, value, lang, type) values ('adv', 'D', 'est', 'capital');
insert into pos_label (code, value, lang, type) values ('adjg', 'G', 'est', 'capital');
insert into pos_label (code, value, lang, type) values ('prop', 'H', 'est', 'capital');
insert into pos_label (code, value, lang, type) values ('interj', 'I', 'est', 'capital');
insert into pos_label (code, value, lang, type) values ('konj', 'J', 'est', 'capital');
insert into pos_label (code, value, lang, type) values ('adp', 'K', 'est', 'capital');
insert into pos_label (code, value, lang, type) values ('num', 'N', 'est', 'capital');
insert into pos_label (code, value, lang, type) values ('ord', 'O', 'est', 'capital');
insert into pos_label (code, value, lang, type) values ('pron', 'P', 'est', 'capital');
insert into pos_label (code, value, lang, type) values ('s', 'S', 'est', 'capital');
insert into pos_label (code, value, lang, type) values ('v', 'V', 'est', 'capital');
insert into pos_label (code, value, lang, type) values ('x', 'X', 'est', 'capital');

insert into pos_label (code, value, lang, type) values ('adj', 'adj', 'est', 'abbrev');
insert into pos_label (code, value, lang, type) values ('adj + ID', 'indekl adj', 'est', 'abbrev');
insert into pos_label (code, value, lang, type) values ('adv', 'adv', 'est', 'abbrev');
insert into pos_label (code, value, lang, type) values ('adjg', 'adjg, ag', 'est', 'abbrev');
insert into pos_label (code, value, lang, type) values ('interj', 'interj', 'est', 'abbrev');
insert into pos_label (code, value, lang, type) values ('konj', 'konj', 'est', 'abbrev');
insert into pos_label (code, value, lang, type) values ('postp', 'postp', 'est', 'abbrev');
insert into pos_label (code, value, lang, type) values ('prep', 'prep', 'est', 'abbrev');
insert into pos_label (code, value, lang, type) values ('num', 'num', 'est', 'abbrev');
insert into pos_label (code, value, lang, type) values ('pron', 'pron', 'est', 'abbrev');
insert into pos_label (code, value, lang, type) values ('pron + ID', 'indekl pron', 'est', 'abbrev');
insert into pos_label (code, value, lang, type) values ('s', 's', 'est', 'abbrev');
insert into pos_label (code, value, lang, type) values ('v', 'v', 'est', 'abbrev');

insert into pos_label (code, value, lang, type) values ('adj', 'adjektiiv, omadussõna', 'est', 'descrip');
insert into pos_label (code, value, lang, type) values ('adj + ID', 'käändumatu omadussõna', 'est', 'descrip');
insert into pos_label (code, value, lang, type) values ('adv', 'adverb, määrsõna', 'est', 'descrip');
insert into pos_label (code, value, lang, type) values ('adjg', 'genitiivatribuut, omastavaline täiend', 'est', 'descrip');
insert into pos_label (code, value, lang, type) values ('prop', 'prooprium, pärisnimi', 'est', 'descrip');
insert into pos_label (code, value, lang, type) values ('interj', 'interjektsioon, hüüdsõna', 'est', 'descrip');
insert into pos_label (code, value, lang, type) values ('konj', 'konjunktsioon, sidesõna', 'est', 'descrip');
insert into pos_label (code, value, lang, type) values ('adp', 'adpositsioon, kaassõna', 'est', 'descrip');
insert into pos_label (code, value, lang, type) values ('postp', 'postpositsioon, tagasõna', 'est', 'descrip');
insert into pos_label (code, value, lang, type) values ('prep', 'prepositsioon, eessõna', 'est', 'descrip');
insert into pos_label (code, value, lang, type) values ('num', 'numeraal, arvsõna', 'est', 'descrip');
insert into pos_label (code, value, lang, type) values ('ord', 'ordinaal, järgarvsõna', 'est', 'descrip');
insert into pos_label (code, value, lang, type) values ('pron', 'pronoomen, asesõna', 'est', 'descrip');
insert into pos_label (code, value, lang, type) values ('pron + ID', 'käändumatu asesõna', 'est', 'descrip');
insert into pos_label (code, value, lang, type) values ('s', 'substantiiv, nimisõna', 'est', 'descrip');
insert into pos_label (code, value, lang, type) values ('v', 'verb, tegusõna', 'est', 'descrip');
insert into pos_label (code, value, lang, type) values ('x', 'erivormiline sõna', 'est', 'descrip');

insert into pos_label (code, value, lang, type) values ('adj', 'adjective', 'eng', 'descrip');
insert into pos_label (code, value, lang, type) values ('adj + ID', 'indeclinable adjective', 'eng', 'descrip');
insert into pos_label (code, value, lang, type) values ('adv', 'adverb', 'eng', 'descrip');
insert into pos_label (code, value, lang, type) values ('adjg', 'attribute in genitive', 'eng', 'descrip');
insert into pos_label (code, value, lang, type) values ('prop', 'proper noun', 'eng', 'descrip');
insert into pos_label (code, value, lang, type) values ('interj', 'interjection', 'eng', 'descrip');
insert into pos_label (code, value, lang, type) values ('konj', 'conjunction', 'eng', 'descrip');
insert into pos_label (code, value, lang, type) values ('adp', 'postposition, preposition', 'eng', 'descrip');
insert into pos_label (code, value, lang, type) values ('postp', 'postposition', 'eng', 'descrip');
insert into pos_label (code, value, lang, type) values ('prep', 'preposition', 'eng', 'descrip');
insert into pos_label (code, value, lang, type) values ('num', 'cardinal, numeral', 'eng', 'descrip');
insert into pos_label (code, value, lang, type) values ('ord', 'ordinal', 'eng', 'descrip');
insert into pos_label (code, value, lang, type) values ('pron', 'pronoun', 'eng', 'descrip');
insert into pos_label (code, value, lang, type) values ('pron + ID', 'indeclinable pronoun', 'eng', 'descrip');
insert into pos_label (code, value, lang, type) values ('s', 'substantive', 'eng', 'descrip');
insert into pos_label (code, value, lang, type) values ('v', 'verb', 'eng', 'descrip');

insert into morph (code, dataset) values ('ID', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('??', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('SgN', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('SgG', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('SgP', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('SgAdt', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('SgIll', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('SgIn', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('SgEl', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('SgAll', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('SgAd', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('SgAbl', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('SgTr', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('SgTer', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('SgEs', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('SgAb', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('SgKom', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('PlN', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('PlG', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('PlP', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('PlIll', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('PlIn', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('PlEl', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('PlAll', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('PlAd', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('PlAbl', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('PlTr', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('PlTer', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('PlEs', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('PlAb', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('PlKom', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('Sup', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('SupAb', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('SupIn', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('SupEl', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('SupTr', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('SupIps', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('Inf', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('Ger', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('PtsPrPs', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('PtsPrIps', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('PtsPtPs', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('PtsPtIps', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('IndPrSg1', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('IndPrSg2', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('IndPrSg3', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('IndPrPl1', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('IndPrPl2', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('IndPrPl3', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('IndPrPs_', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('IndPrIps', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('IndPrIps_', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('IndIpfSg1', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('IndIpfSg2', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('IndIpfSg3', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('IndIpfPl1', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('IndIpfPl2', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('IndIpfPl3', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('IndIpfIps', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('KndPrSg1', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('KndPrSg2', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('KndPrPs', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('KndPrPl1', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('KndPrPl2', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('KndPrPl3', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('KndPrIps', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('KndPtSg1', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('KndPtSg2', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('KndPtPs', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('KndPtPl1', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('KndPtPl2', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('KndPtPl3', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('KndPtIps', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('KvtPrPs', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('KvtPrIps', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('KvtPtPs', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('KvtPtIps', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('ImpPrSg2', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('ImpPrPl1', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('ImpPrPl2', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('ImpPrPs', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('ImpPrIps', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('Neg', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('ImpPrSg2N', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('ImpPrPl1N', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('ImpPrPl2N', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('ImpPrN', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('IndPrPsN', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('IndPrIpsN', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('IndIpfPsN', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('IndIpfIpsN', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('KvtPrPsN', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('KvtPtPsN', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('KndPrPsN', '{eos, ss_, sys, evs}');
insert into morph (code, dataset) values ('KndPtPsN', '{eos, ss_, sys, evs}');

insert into morph_label (code, value, lang, type) values ('ID','--------','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('??','------xx','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('SgN','------0N','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('SgG','------0G','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('SgP','------0P','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('SgAdt','------0D','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('SgIll','------01','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('SgIn','------02','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('SgEl','------03','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('SgAll','------04','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('SgAd','------05','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('SgAbl','------06','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('SgTr','------0T','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('SgTer','------0R','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('SgEs','------0E','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('SgAb','------0A','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('SgKom','------0K','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('PlN','------1N','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('PlG','------1G','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('PlP','------1P','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('PlIll','------1N','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('PlIn','------1G','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('PlEl','------1P','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('PlAll','------11','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('PlAd','------12','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('PlAbl','------13','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('PlTr','------1T','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('PlTer','------1R','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('PlEs','------1E','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('PlAb','------1A','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('PlKom','------1K','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('Sup','30------','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('SupAb','30-----A','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('SupIn','30-----2','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('SupEl','30-----3','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('SupTr','30-----T','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('SupIps','31------','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('Inf','1-------','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('Ger','2-------','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('PtsPrPs','400---0N','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('PtsPrIps','410---0N','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('PtsPtPs','401--0--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('PtsPtIps','411--0--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('IndPrSg1','-00011--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('IndPrSg2','-00021--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('IndPrSg3','-00031--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('IndPrPl1','-00041--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('IndPrPl2','-00051--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('IndPrPl3','-00061--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('IndPrPs_','-00000--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('IndPrIps','-100-1--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('IndPrIps_','-100-0--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('IndIpfSg1','-02011--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('IndIpfSg2','-02021--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('IndIpfSg3','-02031--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('IndIpfPl1','-02041--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('IndIpfPl2','-02051--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('IndIpfPl3','-02061--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('IndIpfIps','-120-1--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('KndPrSg1','-00211--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('KndPrSg2','-00221--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('KndPrPs','-00200--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('KndPrPl1','-00241--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('KndPrPl2','-00251--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('KndPrPl3','-00261--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('KndPrIps','-102-0--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('KndPtSg1','-01211--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('KndPtSg2','-01221--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('KndPtPs','-01200--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('KndPtPl1','-01241--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('KndPtPl2','-01251--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('KndPtPl3','-01261--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('KndPtIps','-112-0--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('KvtPrPs','-00100--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('KvtPrIps','-101-0--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('KvtPtPs','-01100--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('KvtPtIps','-111-0--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('ImpPrSg2','-00320--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('ImpPrPl1','-00340--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('ImpPrPl2','-00350--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('ImpPrPs','-00300--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('ImpPrIps','-103-0--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('Neg','-----2--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('ImpPrSg2N','-00322--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('ImpPrPl1N','-00342--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('ImpPrPl2N','-00352--','est','ekimorfo');
insert into morph_label (code, value, lang, type) values ('ImpPrN','--0302--','est','ekimorfo');

insert into morph_label (code, value, lang, type) values ('ID','indekl','lat','abbrev');
insert into morph_label (code, value, lang, type) values ('SgN','nom','lat','abbrev');
insert into morph_label (code, value, lang, type) values ('SgG','sg gen, gen','lat','abbrev');
insert into morph_label (code, value, lang, type) values ('SgP','part','lat','abbrev');
insert into morph_label (code, value, lang, type) values ('SgIll','illat','lat','abbrev');
insert into morph_label (code, value, lang, type) values ('SgIn','iness','lat','abbrev');
insert into morph_label (code, value, lang, type) values ('SgEl','adess','lat','abbrev');
insert into morph_label (code, value, lang, type) values ('PlN','pl nom','lat','abbrev');
insert into morph_label (code, value, lang, type) values ('PlG','pl gen','lat','abbrev');
insert into morph_label (code, value, lang, type) values ('PlP','pl part','lat','abbrev');
insert into morph_label (code, value, lang, type) values ('PlIll','pl illat','lat','abbrev');
insert into morph_label (code, value, lang, type) values ('PlIn','pl iness','lat','abbrev');
insert into morph_label (code, value, lang, type) values ('PlEl','pl elat','lat','abbrev');
insert into morph_label (code, value, lang, type) values ('PlTer','pl term','lat','abbrev');

insert into morph_label (code, value, lang, type) values ('SgG','om','est','abbrev');
insert into morph_label (code, value, lang, type) values ('SgP','os','est','abbrev');

insert into morph_label (code, value, lang, type) values ('ID','muutumatu sõna (indekl)','est','descrip');
insert into morph_label (code, value, lang, type) values ('??','määramatu vorm','est','descrip');
insert into morph_label (code, value, lang, type) values ('SgN','ainsuse nimetav','est','descrip');
insert into morph_label (code, value, lang, type) values ('SgG','ainsuse omastav','est','descrip');
insert into morph_label (code, value, lang, type) values ('SgP','ainsuse osastav','est','descrip');
insert into morph_label (code, value, lang, type) values ('SgAdt','ainsuse suunduv e lühike sisseütlev','est','descrip');
insert into morph_label (code, value, lang, type) values ('SgIll','ainsuse sisseütlev','est','descrip');
insert into morph_label (code, value, lang, type) values ('SgIn','ainsuse seesütlev','est','descrip');
insert into morph_label (code, value, lang, type) values ('SgEl','ainsuse seestütlev','est','descrip');
insert into morph_label (code, value, lang, type) values ('SgAll','ainsuse alaleütlev','est','descrip');
insert into morph_label (code, value, lang, type) values ('SgAd','ainsuse alalütlev','est','descrip');
insert into morph_label (code, value, lang, type) values ('SgAbl','ainsuse alaltütlev','est','descrip');
insert into morph_label (code, value, lang, type) values ('SgTr','ainsuse saav','est','descrip');
insert into morph_label (code, value, lang, type) values ('SgTer','ainsuse rajav','est','descrip');
insert into morph_label (code, value, lang, type) values ('SgEs','ainsuse olev','est','descrip');
insert into morph_label (code, value, lang, type) values ('SgAb','ainsuse ilmaütlev','est','descrip');
insert into morph_label (code, value, lang, type) values ('SgKom','ainsuse kaasaütlev','est','descrip');
insert into morph_label (code, value, lang, type) values ('PlN','mitmuse nimetav','est','descrip');
insert into morph_label (code, value, lang, type) values ('PlG','mitmuse omastav','est','descrip');
insert into morph_label (code, value, lang, type) values ('PlP','mitmuse osastav','est','descrip');
insert into morph_label (code, value, lang, type) values ('PlIll','mitmuse sisseütlev','est','descrip');
insert into morph_label (code, value, lang, type) values ('PlIn','mitmuse seesütlev','est','descrip');
insert into morph_label (code, value, lang, type) values ('PlEl','mitmuse seestütlev','est','descrip');
insert into morph_label (code, value, lang, type) values ('PlAll','mitmuse alaleütlev','est','descrip');
insert into morph_label (code, value, lang, type) values ('PlAd','mitmuse alalütlev','est','descrip');
insert into morph_label (code, value, lang, type) values ('PlAbl','mitmuse alaltütlev','est','descrip');
insert into morph_label (code, value, lang, type) values ('PlTr','mitmuse saav','est','descrip');
insert into morph_label (code, value, lang, type) values ('PlTer','mitmuse rajav','est','descrip');
insert into morph_label (code, value, lang, type) values ('PlEs','mitmuse olev','est','descrip');
insert into morph_label (code, value, lang, type) values ('PlAb','mitmuse ilmaütlev','est','descrip');
insert into morph_label (code, value, lang, type) values ('PlKom','mitmuse kaasaütlev','est','descrip');
insert into morph_label (code, value, lang, type) values ('Sup','ma-infinitiiv e ma-tegevusnimi','est','descrip');
insert into morph_label (code, value, lang, type) values ('SupAb','mata-vorm','est','descrip');
insert into morph_label (code, value, lang, type) values ('SupIn','mas-vorm','est','descrip');
insert into morph_label (code, value, lang, type) values ('SupEl','mast-vorm','est','descrip');
insert into morph_label (code, value, lang, type) values ('SupTr','maks-vorm','est','descrip');
insert into morph_label (code, value, lang, type) values ('SupIps','ma-tegevusnime umbisikuline tegumood','est','descrip');
insert into morph_label (code, value, lang, type) values ('Inf','da-infinitiiv e da-tegevusnimi','est','descrip');
insert into morph_label (code, value, lang, type) values ('Ger','des-vorm','est','descrip');
insert into morph_label (code, value, lang, type) values ('PtsPrPs','oleviku isikuline kesksõna e v-kesksõna','est','descrip');
insert into morph_label (code, value, lang, type) values ('PtsPrIps','oleviku umbisikuline kesksõna e tav-kesksõna','est','descrip');
insert into morph_label (code, value, lang, type) values ('PtsPtPs','mineviku isikuline kesksõna e nud-kesksõna','est','descrip');
insert into morph_label (code, value, lang, type) values ('PtsPtIps','mineviku umbisikuline kesksõna e tud-kesksõna','est','descrip');
insert into morph_label (code, value, lang, type) values ('IndPrSg1','kindla kõneviisi oleviku ainsuse 1.pööre','est','descrip');
insert into morph_label (code, value, lang, type) values ('IndPrSg2','kindla kõneviisi oleviku ainsuse 2.p.','est','descrip');
insert into morph_label (code, value, lang, type) values ('IndPrSg3','kindla kõneviisi oleviku ainsuse 3.p.','est','descrip');
insert into morph_label (code, value, lang, type) values ('IndPrPl1','kindla kõneviisi oleviku mitmuse 1.p.','est','descrip');
insert into morph_label (code, value, lang, type) values ('IndPrPl2','kindla kõneviisi oleviku mitmuse 2.p.','est','descrip');
insert into morph_label (code, value, lang, type) values ('IndPrPl3','kindla kõneviisi oleviku mitmuse 3.p.','est','descrip');
insert into morph_label (code, value, lang, type) values ('IndPrPs_','kindla kõneviisi oleviku isikuline tegumood (eitusega)','est','descrip');
insert into morph_label (code, value, lang, type) values ('IndPrIps','kindla kõneviisi oleviku umbisikuline tegumood','est','descrip');
insert into morph_label (code, value, lang, type) values ('IndPrIps_','kindla kõneviisi oleviku umbisikuline tegumood (eitusega)','est','descrip');
insert into morph_label (code, value, lang, type) values ('IndIpfSg1','kindla kõneviisi lihtmineviku ainsuse 1.p.','est','descrip');
insert into morph_label (code, value, lang, type) values ('IndIpfSg2','kindla kõneviisi lihtmineviku ainsuse 2.p.','est','descrip');
insert into morph_label (code, value, lang, type) values ('IndIpfSg3','kindla kõneviisi lihtmineviku ainsuse 3.p.','est','descrip');
insert into morph_label (code, value, lang, type) values ('IndIpfPl1','kindla kõneviisi lihtmineviku mitmuse 1.p.','est','descrip');
insert into morph_label (code, value, lang, type) values ('IndIpfPl2','kindla kõneviisi lihtmineviku mitmuse 2.p.','est','descrip');
insert into morph_label (code, value, lang, type) values ('IndIpfPl3','kindla kõneviisi lihtmineviku mitmuse 3.p.','est','descrip');
insert into morph_label (code, value, lang, type) values ('IndIpfIps','kindla kõneviisi lihtmineviku umbisikuline tegumood','est','descrip');
insert into morph_label (code, value, lang, type) values ('KndPrSg1','tingiva kõneviisi oleviku ainsuse 1.p.','est','descrip');
insert into morph_label (code, value, lang, type) values ('KndPrSg2','tingiva kõneviisi oleviku ainsuse 2.p.','est','descrip');
insert into morph_label (code, value, lang, type) values ('KndPrPs','tingiva kõneviisi oleviku isikuline tegumood','est','descrip');
insert into morph_label (code, value, lang, type) values ('KndPrPl1','tingiva kõneviisi oleviku mitmuse 1.p.','est','descrip');
insert into morph_label (code, value, lang, type) values ('KndPrPl2','tingiva kõneviisi oleviku mitmuse 2.p.','est','descrip');
insert into morph_label (code, value, lang, type) values ('KndPrPl3','tingiva kõneviisi oleviku mitmuse 3.p.','est','descrip');
insert into morph_label (code, value, lang, type) values ('KndPrIps','tingiva kõneviisi oleviku umbisikuline tegumood','est','descrip');
insert into morph_label (code, value, lang, type) values ('KndPtSg1','tingiva kõneviisi mineviku ainsuse 1.p.','est','descrip');
insert into morph_label (code, value, lang, type) values ('KndPtSg2','tingiva kõneviisi mineviku ainsuse 2.p.','est','descrip');
insert into morph_label (code, value, lang, type) values ('KndPtPs','tingiva kõneviisi mineviku isikuline tegumood','est','descrip');
insert into morph_label (code, value, lang, type) values ('KndPtPl1','tingiva kõneviisi mineviku mitmuse 1.p.','est','descrip');
insert into morph_label (code, value, lang, type) values ('KndPtPl2','tingiva kõneviisi mineviku mitmuse 2.p.','est','descrip');
insert into morph_label (code, value, lang, type) values ('KndPtPl3','tingiva kõneviisi mineviku mitmuse 3.p.','est','descrip');
insert into morph_label (code, value, lang, type) values ('KndPtIps','tingiva kõneviisi mineviku umbisikuline tegumood','est','descrip');
insert into morph_label (code, value, lang, type) values ('KvtPrPs','kaudse kõneviisi oleviku isikuline tegumood','est','descrip');
insert into morph_label (code, value, lang, type) values ('KvtPrIps','kaudse kõneviisi oleviku umbisikuline tegumood','est','descrip');
insert into morph_label (code, value, lang, type) values ('KvtPtPs','kaudse kõneviisi mineviku isikuline tegumood','est','descrip');
insert into morph_label (code, value, lang, type) values ('KvtPtIps','kaudse kõneviisi mineviku umbisikuline tegumood','est','descrip');
insert into morph_label (code, value, lang, type) values ('ImpPrSg2','käskiva kõneviisi oleviku ainsuse 2.p.','est','descrip');
insert into morph_label (code, value, lang, type) values ('ImpPrPl1','käskiva kõneviisi oleviku mitmuse 1.p.','est','descrip');
insert into morph_label (code, value, lang, type) values ('ImpPrPl2','käskiva kõneviisi oleviku mitmuse 2.p.','est','descrip');
insert into morph_label (code, value, lang, type) values ('ImpPrPs','käskiva kõneviisi oleviku isikuline tegumood','est','descrip');
insert into morph_label (code, value, lang, type) values ('ImpPrIps','käskiva kõneviisi oleviku umbisikuline tegumood','est','descrip');
insert into morph_label (code, value, lang, type) values ('Neg','eitus (ei)','est','descrip');
insert into morph_label (code, value, lang, type) values ('ImpPrSg2N','käskiva kõneviisi oleviku ainsuse 2.p. eitus (ära)','est','descrip');
insert into morph_label (code, value, lang, type) values ('ImpPrPl1N','käskiva kõneviisi oleviku mitmuse 1.p. eitus (ärgem)','est','descrip');
insert into morph_label (code, value, lang, type) values ('ImpPrPl2N','käskiva kõneviisi oleviku mitmuse 2.p. eitus (ärge)','est','descrip');
insert into morph_label (code, value, lang, type) values ('ImpPrN','käskiva kõneviisi oleviku isikulise tegumoe eitus (ärgu)','est','descrip');
insert into morph_label (code, value, lang, type) values ('IndPrPsN','pole','est','descrip');
insert into morph_label (code, value, lang, type) values ('IndPrIpsN','polda','est','descrip');
insert into morph_label (code, value, lang, type) values ('IndIpfPsN','polnud','est','descrip');
insert into morph_label (code, value, lang, type) values ('IndIpfIpsN','poldud','est','descrip');
insert into morph_label (code, value, lang, type) values ('KvtPrPsN','polevat','est','descrip');
insert into morph_label (code, value, lang, type) values ('KvtPtPsN','polnuvat','est','descrip');
insert into morph_label (code, value, lang, type) values ('KndPrPsN','poleks','est','descrip');
insert into morph_label (code, value, lang, type) values ('KndPtPsN','polnuks','est','descrip');

insert into deriv (code, dataset) values ('as', '{eos, ss_, sys, evs}');
insert into deriv (code, dataset) values ('dem', '{eos, ss_, sys, evs}');
insert into deriv (code, dataset) values ('posit', '{eos, ss_, sys, evs}');
insert into deriv (code, dataset) values ('komp', '{eos, ss_, sys, evs}');
insert into deriv (code, dataset) values ('superl', '{eos, ss_, sys, evs}');
insert into deriv (code, dataset) values ('tgn', '{eos, ss_, sys, evs}');
insert into deriv (code, dataset) values ('tn', '{eos, ss_, sys, evs}');

insert into deriv_label (code, value, lang, type) values ('as','US','est','ekimorfo');
insert into deriv_label (code, value, lang, type) values ('dem','KE/KENE','est','ekimorfo');
insert into deriv_label (code, value, lang, type) values ('posit','_','est','ekimorfo');
insert into deriv_label (code, value, lang, type) values ('komp','M','est','ekimorfo');
insert into deriv_label (code, value, lang, type) values ('superl','IM','est','ekimorfo');
insert into deriv_label (code, value, lang, type) values ('tgn','JA','est','ekimorfo');
insert into deriv_label (code, value, lang, type) values ('tn','MINE','est','ekimorfo');

insert into deriv_label (code, value, lang, type) values ('as','as','lat','abbrev');
insert into deriv_label (code, value, lang, type) values ('dem','dem','lat','abbrev');
insert into deriv_label (code, value, lang, type) values ('komp','komp','lat','abbrev');
insert into deriv_label (code, value, lang, type) values ('superl','superl','lat','abbrev');

insert into deriv_label (code, value, lang, type) values ('posit','algvõrre','est','full');

insert into deriv_label (code, value, lang, type) values ('komp','keskv','est','abbrev');
insert into deriv_label (code, value, lang, type) values ('superl','üliv','est','abbrev');
insert into deriv_label (code, value, lang, type) values ('tgn','tgn','est','abbrev');
insert into deriv_label (code, value, lang, type) values ('tn','tn','est','abbrev');

insert into deriv_label (code, value, lang, type) values ('as','abstraktne substantiiv','est','descrip');
insert into deriv_label (code, value, lang, type) values ('dem','deminutiiv, vähendussõna','est','descrip');
insert into deriv_label (code, value, lang, type) values ('posit','positiiv, algvõrre','est','descrip');
insert into deriv_label (code, value, lang, type) values ('komp','komparatiiv, keskvõrre','est','descrip');
insert into deriv_label (code, value, lang, type) values ('superl','superlatiiv, ülivõrre','est','descrip');
insert into deriv_label (code, value, lang, type) values ('tgn','tegijanimi','est','descrip');
insert into deriv_label (code, value, lang, type) values ('tn','teonimi','est','descrip');

insert into deriv_label (code, value, lang, type) values ('as','abstract substantive','eng','descrip');
insert into deriv_label (code, value, lang, type) values ('dem','diminutive','eng','descrip');
insert into deriv_label (code, value, lang, type) values ('posit','positive degree','eng','descrip');
insert into deriv_label (code, value, lang, type) values ('komp','comparative (degree)','eng','descrip');
insert into deriv_label (code, value, lang, type) values ('superl','superlative (degree)','eng','descrip');
insert into deriv_label (code, value, lang, type) values ('tgn','ja-derivative = actor','eng','descrip');
insert into deriv_label (code, value, lang, type) values ('tn','mine-derivative = act, process','eng','descrip');
