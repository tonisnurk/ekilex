package eki.ekilex.service.db;

import static eki.ekilex.data.db.Tables.COLLOCATION;
import static eki.ekilex.data.db.Tables.COLLOCATION_USAGE;
import static eki.ekilex.data.db.Tables.DEFINITION;
import static eki.ekilex.data.db.Tables.DERIV_LABEL;
import static eki.ekilex.data.db.Tables.DOMAIN_LABEL;
import static eki.ekilex.data.db.Tables.FORM;
import static eki.ekilex.data.db.Tables.FORM_RELATION;
import static eki.ekilex.data.db.Tables.FORM_REL_TYPE_LABEL;
import static eki.ekilex.data.db.Tables.FREEFORM;
import static eki.ekilex.data.db.Tables.FREEFORM_REF_LINK;
import static eki.ekilex.data.db.Tables.LEXEME;
import static eki.ekilex.data.db.Tables.LEXEME_DERIV;
import static eki.ekilex.data.db.Tables.LEXEME_FREEFORM;
import static eki.ekilex.data.db.Tables.LEXEME_POS;
import static eki.ekilex.data.db.Tables.LEXEME_REGISTER;
import static eki.ekilex.data.db.Tables.LEX_RELATION;
import static eki.ekilex.data.db.Tables.LEX_REL_TYPE_LABEL;
import static eki.ekilex.data.db.Tables.MEANING;
import static eki.ekilex.data.db.Tables.MEANING_DOMAIN;
import static eki.ekilex.data.db.Tables.MEANING_FREEFORM;
import static eki.ekilex.data.db.Tables.MEANING_RELATION;
import static eki.ekilex.data.db.Tables.MEANING_REL_TYPE_LABEL;
import static eki.ekilex.data.db.Tables.MORPH_LABEL;
import static eki.ekilex.data.db.Tables.PARADIGM;
import static eki.ekilex.data.db.Tables.PERSON;
import static eki.ekilex.data.db.Tables.POS_LABEL;
import static eki.ekilex.data.db.Tables.REGISTER_LABEL;
import static eki.ekilex.data.db.Tables.USAGE_TYPE_LABEL;
import static eki.ekilex.data.db.Tables.WORD;
import static eki.ekilex.data.db.Tables.WORD_RELATION;
import static eki.ekilex.data.db.Tables.WORD_REL_TYPE_LABEL;

import java.sql.Timestamp;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Record10;
import org.jooq.Record15;
import org.jooq.Record16;
import org.jooq.Record2;
import org.jooq.Record3;
import org.jooq.Record4;
import org.jooq.Record5;
import org.jooq.Record7;
import org.jooq.Record8;
import org.jooq.Record9;
import org.jooq.Result;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eki.common.constant.FreeformType;
import eki.ekilex.constant.SystemConstant;
import eki.ekilex.data.db.tables.Collocation;
import eki.ekilex.data.db.tables.CollocationUsage;
import eki.ekilex.data.db.tables.Form;
import eki.ekilex.data.db.tables.Freeform;
import eki.ekilex.data.db.tables.FreeformRefLink;
import eki.ekilex.data.db.tables.Lexeme;
import eki.ekilex.data.db.tables.LexemeFreeform;
import eki.ekilex.data.db.tables.Person;
import eki.ekilex.data.db.tables.UsageTypeLabel;

@Service
public class LexSearchDbService implements SystemConstant {

	private DSLContext create;

	@Autowired
	public LexSearchDbService(DSLContext context) {
		create = context;
	}

	public Result<Record10<Long,String,Long,String,Boolean,String[],String,String,String,String>> findParadigmFormTuples(Long wordId, String classifierLabelLang, String classifierLabelTypeCode) {

		return create
				.select(
						PARADIGM.ID.as("paradigm_id"),
						PARADIGM.INFLECTION_TYPE_NR,
						FORM.ID.as("form_id"),
						FORM.VALUE.as("form"),
						FORM.IS_WORD,
						FORM.COMPONENTS,
						FORM.DISPLAY_FORM,
						FORM.VOCAL_FORM,
						FORM.MORPH_CODE,
						MORPH_LABEL.VALUE.as("morph_value")
						)
				.from(PARADIGM, FORM, MORPH_LABEL)
				.where(
						PARADIGM.WORD_ID.eq(wordId)
						.and(FORM.PARADIGM_ID.eq(PARADIGM.ID))
						.and(MORPH_LABEL.CODE.eq(FORM.MORPH_CODE))
						.and(MORPH_LABEL.LANG.eq(classifierLabelLang))
						.and(MORPH_LABEL.TYPE.eq(classifierLabelTypeCode))
						)
				.orderBy(PARADIGM.ID, FORM.ID)
				.fetch();
	}

	public Result<Record2<String, String>> findLexemePos(Long lexemeId, String classifierLabelLang, String classifierLabelTypeCode) {

		return create
				.select(POS_LABEL.CODE, POS_LABEL.VALUE)
				.from(LEXEME_POS, POS_LABEL)
				.where(
						LEXEME_POS.LEXEME_ID.eq(lexemeId)
						.and(POS_LABEL.CODE.eq(LEXEME_POS.POS_CODE))
						.and(POS_LABEL.LANG.eq(classifierLabelLang))
						.and(POS_LABEL.TYPE.eq(classifierLabelTypeCode))
						)
				.fetch();
	}

	public Result<Record2<String, String>> findLexemeDerivs(Long lexemeId, String classifierLabelLang, String classifierLabelTypeCode) {

		return create
				.select(DERIV_LABEL.CODE, DERIV_LABEL.VALUE)
				.from(LEXEME_DERIV, DERIV_LABEL)
				.where(
						LEXEME_DERIV.LEXEME_ID.eq(lexemeId)
						.and(DERIV_LABEL.CODE.eq(LEXEME_DERIV.DERIV_CODE))
						.and(DERIV_LABEL.LANG.eq(classifierLabelLang))
						.and(DERIV_LABEL.TYPE.eq(classifierLabelTypeCode))
						)
				.fetch();
	}

	public Result<Record2<String, String>> findLexemeRegisters(Long lexemeId, String classifierLabelLang, String classifierLabelTypeCode) {

		return create
				.select(REGISTER_LABEL.CODE, REGISTER_LABEL.VALUE)
				.from(LEXEME_REGISTER, REGISTER_LABEL)
				.where(
						LEXEME_REGISTER.LEXEME_ID.eq(lexemeId)
						.and(REGISTER_LABEL.CODE.eq(LEXEME_REGISTER.REGISTER_CODE))
						.and(REGISTER_LABEL.LANG.eq(classifierLabelLang))
						.and(REGISTER_LABEL.TYPE.eq(classifierLabelTypeCode))
						)
				.fetch();
	}

	public Result<Record3<String, String, String>> findMeaningDomains(Long meaningId) {

		return create
				.select(DOMAIN_LABEL.CODE, DOMAIN_LABEL.ORIGIN, DOMAIN_LABEL.VALUE)
				.from(
						MEANING_DOMAIN.leftOuterJoin(DOMAIN_LABEL).on(
								MEANING_DOMAIN.DOMAIN_CODE.eq(DOMAIN_LABEL.CODE)
								.and(MEANING_DOMAIN.DOMAIN_ORIGIN.eq(DOMAIN_LABEL.ORIGIN))
								)
						)
				.where(MEANING_DOMAIN.MEANING_ID.eq(meaningId))
				.fetch();
	}

	public Result<Record15<Long, String, Long, Long, String, String, Long, String, String, Long, String, String, String, String, String>>
		findGovernmentUsageTranslationDefinitionTuples(Long lexemeId, String classifierLabelLang, String classifierLabelTypeCode) {

		LexemeFreeform lff = LEXEME_FREEFORM.as("lff");
		Freeform g = FREEFORM.as("g");
		Freeform um = FREEFORM.as("um");
		Freeform u = FREEFORM.as("u");
		Freeform ut = FREEFORM.as("ut");
		Freeform ud = FREEFORM.as("ud");
		Freeform ua = FREEFORM.as("ua");
		Freeform utrans = FREEFORM.as("utrans");
		Freeform utype = FREEFORM.as("utype");
		UsageTypeLabel utl = USAGE_TYPE_LABEL.as("utl");
		FreeformRefLink frl = FREEFORM_REF_LINK.as("frl");
		FreeformRefLink frl2 = FREEFORM_REF_LINK.as("frl2");
		Person p = PERSON.as("p");
		Person p2 = PERSON.as("p2");

		return create
				.select(
						g.ID.as("government_id"),
						g.VALUE_TEXT.as("government_value"),
						um.ID.as("usage_meaning_id"),
						u.ID.as("usage_id"),
						u.VALUE_TEXT.as("usage_value"),
						u.LANG.as("usage_lang"),
						ut.ID.as("usage_translation_id"),
						ut.VALUE_TEXT.as("usage_translation_value"),
						ut.LANG.as("usage_translation_lang"),
						ud.ID.as("usage_definition_id"),
						ud.VALUE_TEXT.as("usage_definition_value"),
						ud.LANG.as("usage_definition_lang"),
						p.NAME.as("usage_author"),
						p2.NAME.as("usage_translator"),
						utl.VALUE.as("usage_type")
						)
				.from(
						lff.innerJoin(g).on(lff.FREEFORM_ID.eq(g.ID).and(g.TYPE.eq(FreeformType.GOVERNMENT.name())))
						.leftOuterJoin(um).on(um.PARENT_ID.eq(g.ID).and(um.TYPE.eq(FreeformType.USAGE_MEANING.name())))
						.leftOuterJoin(u).on(u.PARENT_ID.eq(um.ID).and(u.TYPE.eq(FreeformType.USAGE.name())))
						.leftOuterJoin(ut).on(ut.PARENT_ID.eq(um.ID).and(ut.TYPE.eq(FreeformType.USAGE_TRANSLATION.name())))
						.leftOuterJoin(ud).on(ud.PARENT_ID.eq(um.ID).and(ud.TYPE.eq(FreeformType.USAGE_DEFINITION.name())))
						.leftOuterJoin(ua).on(ua.PARENT_ID.eq(u.ID).and(ua.TYPE.eq(FreeformType.USAGE_AUTHOR.name())))
						.leftOuterJoin(frl).on(frl.FREEFORM_ID.eq(ua.ID))
						.leftOuterJoin(p).on(p.ID.eq(frl.REF_ID))
						.leftOuterJoin(utrans).on(utrans.PARENT_ID.eq(u.ID).and(utrans.TYPE.eq(FreeformType.USAGE_TRANSLATOR.name())))
						.leftOuterJoin(frl2).on(frl2.FREEFORM_ID.eq(utrans.ID))
						.leftOuterJoin(p2).on(p2.ID.eq(frl2.REF_ID))
						.leftOuterJoin(utype).on(utype.PARENT_ID.eq(u.ID).and(utype.TYPE.eq(FreeformType.USAGE_TYPE.name())))
						.leftOuterJoin(utl)
						.on(utl.CODE.eq(utype.CLASSIF_CODE).and(utl.LANG.eq(classifierLabelLang).and(utl.TYPE.eq(classifierLabelTypeCode))))
						)
				.where(lff.LEXEME_ID.eq(lexemeId))
				.orderBy(g.ORDER_BY, um.ORDER_BY, u.ORDER_BY, ut.ORDER_BY, ud.ORDER_BY)
				.fetch();
	}

	public Result<Record16<String[],String[],String,Long,String,Long,Long,String,Integer,Integer,Integer,String,String,String,String,String>> findFormMeanings(
			Long wordId, List<String> selectedDatasets) {

		return 
				create
				.select(
						DSL.arrayAggDistinct(FORM.VALUE).as("words"),
						DSL.arrayAggDistinct(FORM.VOCAL_FORM).as("vocal_forms"),
						WORD.LANG.as("word_lang"),
						WORD.ID.as("word_id"),
						WORD.DISPLAY_MORPH_CODE.as("word_display_morph_code"),
						LEXEME.ID.as("lexeme_id"),
						LEXEME.MEANING_ID,
						LEXEME.DATASET_CODE.as("dataset"),
						LEXEME.LEVEL1,
						LEXEME.LEVEL2,
						LEXEME.LEVEL3,
						LEXEME.TYPE_CODE.as("lexeme_type_code"),
						LEXEME.FREQUENCY_GROUP.as("lexeme_frequency_group_code"),
						MEANING.TYPE_CODE.as("meaning_type_code"),
						MEANING.PROCESS_STATE_CODE.as("meaning_process_state_code"),
						MEANING.STATE_CODE.as("meaning_state_code"))
				.from(FORM, PARADIGM, WORD, LEXEME, MEANING)
				.where(
						WORD.ID.eq(wordId)
						.and(FORM.PARADIGM_ID.eq(PARADIGM.ID))
						.and(FORM.IS_WORD.isTrue())
						.and(PARADIGM.WORD_ID.eq(WORD.ID))
						.and(LEXEME.WORD_ID.eq(WORD.ID))
						.and(LEXEME.MEANING_ID.eq(MEANING.ID))
						.and(LEXEME.DATASET_CODE.in(selectedDatasets)))
				.groupBy(WORD.ID, LEXEME.ID, MEANING.ID)
				.orderBy(WORD.ID, LEXEME.DATASET_CODE, LEXEME.LEVEL1, LEXEME.LEVEL2, LEXEME.LEVEL3)
				.fetch();
	}

	public Result<Record4<Long,String,Integer,String>> findMeaningWords(Long sourceWordId, Long meaningId, List<String> datasets) {

		return create
				.select(
						WORD.ID.as("word_id"),
						FORM.VALUE.as("word"),
						WORD.HOMONYM_NR,
						WORD.LANG
						)
				.from(LEXEME, WORD, PARADIGM, FORM)
				.where(
						FORM.PARADIGM_ID.eq(PARADIGM.ID)
						.and(FORM.IS_WORD.isTrue())
						.and(WORD.ID.ne(sourceWordId))
						.and(PARADIGM.WORD_ID.eq(WORD.ID))
						.and(LEXEME.WORD_ID.eq(WORD.ID))
						.and(LEXEME.MEANING_ID.eq(meaningId))
						.and(LEXEME.DATASET_CODE.in(datasets))
				)
				.groupBy(WORD.ID, FORM.VALUE)
				.orderBy(FORM.VALUE)
				.fetch();
	}

	public Result<Record4<Long, String, String, Timestamp>> findLexemeFreeforms(Long lexemeId) {
		return create
				.select(FREEFORM.ID, FREEFORM.TYPE, FREEFORM.VALUE_TEXT, FREEFORM.VALUE_DATE)
				.from(FREEFORM, LEXEME_FREEFORM)
				.where(LEXEME_FREEFORM.LEXEME_ID.eq(lexemeId).and(FREEFORM.ID.eq(LEXEME_FREEFORM.FREEFORM_ID))
						.and(FREEFORM.TYPE.notIn(FreeformType.GOVERNMENT.name(), FreeformType.GRAMMAR.name())))
				.fetch();
	}

	public Result<Record1<String>> findLexemeGrammars(Long lexemeId) {
		return create
				.select(FREEFORM.VALUE_TEXT)
				.from(FREEFORM, LEXEME_FREEFORM)
				.where(LEXEME_FREEFORM.LEXEME_ID.eq(lexemeId)
						.and(FREEFORM.ID.eq(LEXEME_FREEFORM.FREEFORM_ID))
						.and(FREEFORM.TYPE.eq(FreeformType.GRAMMAR.name())))
				.fetch();
	}

	public Result<Record4<Long, String, String, Timestamp>> findMeaningFreeforms(Long meaningId) {
		return create
				.select(
						FREEFORM.ID,
						FREEFORM.TYPE,
						FREEFORM.VALUE_TEXT,
						FREEFORM.VALUE_DATE)
				.from(FREEFORM, MEANING_FREEFORM)
				.where(
						MEANING_FREEFORM.MEANING_ID.eq(meaningId)
						.and(FREEFORM.ID.eq(MEANING_FREEFORM.FREEFORM_ID)))
				.orderBy(FREEFORM.ORDER_BY)
				.fetch();
	}

	public Result<Record3<Long, String, Long>> findMeaningDefinitions(Long meaningId) {
		return create
				.select(DEFINITION.ID, DEFINITION.VALUE, DEFINITION.ORDER_BY)
				.from(DEFINITION)
				.where(DEFINITION.MEANING_ID.eq(meaningId))
				.orderBy(DEFINITION.ORDER_BY)
				.fetch();
	}

	public Result<Record8<Long,Long,Long,Long,String,String,String,Long>> findLexemeRelations(Long lexemeId, String classifierLabelLang, String classifierLabelTypeCode) {

		return create
				.select(
						LEX_RELATION.ID.as("id"),
						LEXEME.ID.as("lexeme_id"),
						WORD.ID.as("word_id"),
						FORM.ID.as("form_id"),
						FORM.VALUE.as("word"),
						WORD.LANG.as("word_lang"),
						LEX_REL_TYPE_LABEL.VALUE.as("rel_type_label"),
						LEX_RELATION.ORDER_BY.as("order_by")
						)
				.from(
						LEX_RELATION.leftOuterJoin(LEX_REL_TYPE_LABEL).on(
								LEX_RELATION.LEX_REL_TYPE_CODE.eq(LEX_REL_TYPE_LABEL.CODE)
								.and(LEX_REL_TYPE_LABEL.LANG.eq(classifierLabelLang)
								.and(LEX_REL_TYPE_LABEL.TYPE.eq(classifierLabelTypeCode)))),
						LEXEME,
						WORD,
						PARADIGM,
						FORM
						)
				.where(
						LEX_RELATION.LEXEME1_ID.eq(lexemeId)
						.and(LEX_RELATION.LEXEME2_ID.eq(LEXEME.ID))
						.and(LEXEME.WORD_ID.eq(WORD.ID))
						.and(PARADIGM.WORD_ID.eq(WORD.ID))
						.and(FORM.PARADIGM_ID.eq(PARADIGM.ID))
						.and(FORM.IS_WORD.eq(Boolean.TRUE))
						)
				.orderBy(LEX_RELATION.ORDER_BY)
				.fetch();
	}

	public Result<Record5<Long,String,String,String,Long>> findWordRelations(Long wordId, String classifierLabelLang, String classifierLabelTypeCode) {

		return create
				.select(
						WORD_RELATION.ID.as("id"),
						FORM.VALUE.as("word"),
						WORD.LANG.as("word_lang"),
						WORD_REL_TYPE_LABEL.VALUE.as("rel_type_label"),
						WORD_RELATION.ORDER_BY.as("order_by")
						)
				.from(
						WORD_RELATION.leftOuterJoin(WORD_REL_TYPE_LABEL).on(
								WORD_RELATION.WORD_REL_TYPE_CODE.eq(WORD_REL_TYPE_LABEL.CODE)
								.and(WORD_REL_TYPE_LABEL.LANG.eq(classifierLabelLang)
								.and(WORD_REL_TYPE_LABEL.TYPE.eq(classifierLabelTypeCode)))),
						WORD,
						PARADIGM,
						FORM
						)
				.where(
						WORD_RELATION.WORD1_ID.eq(wordId)
						.and(WORD_RELATION.WORD2_ID.eq(WORD.ID))
						.and(PARADIGM.WORD_ID.eq(WORD.ID))
						.and(FORM.PARADIGM_ID.eq(PARADIGM.ID))
						.and(FORM.IS_WORD.eq(Boolean.TRUE))
						)
				.orderBy(WORD_RELATION.ORDER_BY)
				.fetch();
	}

	public Result<Record9<Long,Long,Long,Long,Long,String,String,String,Long>> findMeaningRelations(Long meaningId, String classifierLabelLang, String classifierLabelTypeCode) {

		return create
				.select(
						MEANING_RELATION.ID.as("id"),
						MEANING.ID.as("meaning_id"),
						LEXEME.ID.as("lexeme_id"),
						WORD.ID.as("word_id"),
						FORM.ID.as("form_id"),
						FORM.VALUE.as("word"),
						WORD.LANG.as("word_lang"),
						MEANING_REL_TYPE_LABEL.VALUE.as("rel_type_label"),
						MEANING_RELATION.ORDER_BY.as("order_by")
				)
				.from(
						MEANING_RELATION.leftOuterJoin(MEANING_REL_TYPE_LABEL).on(
								MEANING_RELATION.MEANING_REL_TYPE_CODE.eq(MEANING_REL_TYPE_LABEL.CODE)
								.and(MEANING_REL_TYPE_LABEL.LANG.eq(classifierLabelLang)
								.and(MEANING_REL_TYPE_LABEL.TYPE.eq(classifierLabelTypeCode)))),
						MEANING,
						LEXEME,
						WORD,
						PARADIGM,
						FORM
				)
				.where(
						MEANING_RELATION.MEANING1_ID.eq(meaningId)
								.and(MEANING_RELATION.MEANING2_ID.eq(MEANING.ID))
								.and(LEXEME.MEANING_ID.eq(MEANING.ID))
								.and(LEXEME.WORD_ID.eq(WORD.ID))
								.and(PARADIGM.WORD_ID.eq(WORD.ID))
								.and(FORM.PARADIGM_ID.eq(PARADIGM.ID))
								.and(FORM.IS_WORD.eq(Boolean.TRUE))
				)
				.orderBy(MEANING_RELATION.ORDER_BY)
				.fetch();
	}

	public Result<Record7<Long,Long,String,Long,String,String,String>> findWordFormRelations(Long wordId, String classifierLabelLang, String classifierLabelTypeCode) {

		Form f1 = FORM.as("f1");
		Form f2 = FORM.as("f2");

		return create
				.select(
						PARADIGM.ID.as("paradigm_id"),
						f1.ID.as("form1_id"),
						f1.VALUE.as("form1_value"),
						f2.ID.as("form2_id"),
						f2.VALUE.as("form2_value"),
						FORM_REL_TYPE_LABEL.CODE.as("rel_type_code"),
						FORM_REL_TYPE_LABEL.VALUE.as("rel_type_label")
						)
				.from(
						PARADIGM,
						f1,
						f2,
						FORM_RELATION.leftOuterJoin(FORM_REL_TYPE_LABEL).on(
							FORM_RELATION.FORM_REL_TYPE_CODE.eq(FORM_REL_TYPE_LABEL.CODE)
							.and(FORM_REL_TYPE_LABEL.LANG.eq(classifierLabelLang)
							.and(FORM_REL_TYPE_LABEL.TYPE.eq(classifierLabelTypeCode))))
						)
				.where(
						PARADIGM.WORD_ID.eq(wordId)
						.and(f1.PARADIGM_ID.eq(PARADIGM.ID))
						.and(FORM_RELATION.FORM1_ID.eq(f1.ID))
						.and(FORM_RELATION.FORM2_ID.eq(f2.ID))
						)
				.orderBy(PARADIGM.ID, FORM_RELATION.ORDER_BY)
				.fetch();
	}

	public Result<Record5<Long,Long,Long,String,String[]>> findCollocations(Long lexemeId) {

		Lexeme cl2 = LEXEME.as("cl2");
		Collocation col = COLLOCATION.as("col");
		CollocationUsage colu = COLLOCATION_USAGE.as("colu");

		return create
				.select(
						col.ID.as("colloc_id"),
						col.LEXEME2_ID.as("colloc_lexeme_id"),
						cl2.WORD_ID.as("colloc_word_id"),
						col.VALUE.as("collocation"),
						DSL.arrayAgg(colu.VALUE).as("colloc_usages")
						)
				.from(
						col.innerJoin(cl2).on(cl2.ID.eq(col.LEXEME2_ID))
						.leftOuterJoin(colu).on(colu.COLLOCATION_ID.eq(col.ID))
						)
				.where(col.LEXEME1_ID.eq(lexemeId))
				.groupBy(col.ID, cl2.WORD_ID)
				.orderBy(col.ID)
				.fetch();
	}
}
