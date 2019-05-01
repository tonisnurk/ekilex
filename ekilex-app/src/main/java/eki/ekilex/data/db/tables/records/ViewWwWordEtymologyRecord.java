/*
 * This file is generated by jOOQ.
 */
package eki.ekilex.data.db.tables.records;


import eki.ekilex.data.db.tables.ViewWwWordEtymology;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record18;
import org.jooq.Row18;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ViewWwWordEtymologyRecord extends TableRecordImpl<ViewWwWordEtymologyRecord> implements Record18<Long, Long, Long, String, String, String, Boolean, Long, String[], Long, String, Boolean, Boolean, Long, Long, String, String, String[]> {

    private static final long serialVersionUID = -1597799326;

    /**
     * Setter for <code>public.view_ww_word_etymology.word_id</code>.
     */
    public void setWordId(Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.view_ww_word_etymology.word_id</code>.
     */
    public Long getWordId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>public.view_ww_word_etymology.word_etym_word_id</code>.
     */
    public void setWordEtymWordId(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.view_ww_word_etymology.word_etym_word_id</code>.
     */
    public Long getWordEtymWordId() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>public.view_ww_word_etymology.word_etym_id</code>.
     */
    public void setWordEtymId(Long value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.view_ww_word_etymology.word_etym_id</code>.
     */
    public Long getWordEtymId() {
        return (Long) get(2);
    }

    /**
     * Setter for <code>public.view_ww_word_etymology.etymology_type_code</code>.
     */
    public void setEtymologyTypeCode(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.view_ww_word_etymology.etymology_type_code</code>.
     */
    public String getEtymologyTypeCode() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.view_ww_word_etymology.etymology_year</code>.
     */
    public void setEtymologyYear(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.view_ww_word_etymology.etymology_year</code>.
     */
    public String getEtymologyYear() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.view_ww_word_etymology.word_etym_comment</code>.
     */
    public void setWordEtymComment(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.view_ww_word_etymology.word_etym_comment</code>.
     */
    public String getWordEtymComment() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.view_ww_word_etymology.word_etym_is_questionable</code>.
     */
    public void setWordEtymIsQuestionable(Boolean value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.view_ww_word_etymology.word_etym_is_questionable</code>.
     */
    public Boolean getWordEtymIsQuestionable() {
        return (Boolean) get(6);
    }

    /**
     * Setter for <code>public.view_ww_word_etymology.word_etym_order_by</code>.
     */
    public void setWordEtymOrderBy(Long value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.view_ww_word_etymology.word_etym_order_by</code>.
     */
    public Long getWordEtymOrderBy() {
        return (Long) get(7);
    }

    /**
     * Setter for <code>public.view_ww_word_etymology.word_etym_sources</code>.
     */
    public void setWordEtymSources(String... value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.view_ww_word_etymology.word_etym_sources</code>.
     */
    public String[] getWordEtymSources() {
        return (String[]) get(8);
    }

    /**
     * Setter for <code>public.view_ww_word_etymology.word_etym_rel_id</code>.
     */
    public void setWordEtymRelId(Long value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.view_ww_word_etymology.word_etym_rel_id</code>.
     */
    public Long getWordEtymRelId() {
        return (Long) get(9);
    }

    /**
     * Setter for <code>public.view_ww_word_etymology.word_etym_rel_comment</code>.
     */
    public void setWordEtymRelComment(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.view_ww_word_etymology.word_etym_rel_comment</code>.
     */
    public String getWordEtymRelComment() {
        return (String) get(10);
    }

    /**
     * Setter for <code>public.view_ww_word_etymology.word_etym_rel_is_questionable</code>.
     */
    public void setWordEtymRelIsQuestionable(Boolean value) {
        set(11, value);
    }

    /**
     * Getter for <code>public.view_ww_word_etymology.word_etym_rel_is_questionable</code>.
     */
    public Boolean getWordEtymRelIsQuestionable() {
        return (Boolean) get(11);
    }

    /**
     * Setter for <code>public.view_ww_word_etymology.word_etym_rel_is_compound</code>.
     */
    public void setWordEtymRelIsCompound(Boolean value) {
        set(12, value);
    }

    /**
     * Getter for <code>public.view_ww_word_etymology.word_etym_rel_is_compound</code>.
     */
    public Boolean getWordEtymRelIsCompound() {
        return (Boolean) get(12);
    }

    /**
     * Setter for <code>public.view_ww_word_etymology.word_etym_rel_order_by</code>.
     */
    public void setWordEtymRelOrderBy(Long value) {
        set(13, value);
    }

    /**
     * Getter for <code>public.view_ww_word_etymology.word_etym_rel_order_by</code>.
     */
    public Long getWordEtymRelOrderBy() {
        return (Long) get(13);
    }

    /**
     * Setter for <code>public.view_ww_word_etymology.related_word_id</code>.
     */
    public void setRelatedWordId(Long value) {
        set(14, value);
    }

    /**
     * Getter for <code>public.view_ww_word_etymology.related_word_id</code>.
     */
    public Long getRelatedWordId() {
        return (Long) get(14);
    }

    /**
     * Setter for <code>public.view_ww_word_etymology.related_word</code>.
     */
    public void setRelatedWord(String value) {
        set(15, value);
    }

    /**
     * Getter for <code>public.view_ww_word_etymology.related_word</code>.
     */
    public String getRelatedWord() {
        return (String) get(15);
    }

    /**
     * Setter for <code>public.view_ww_word_etymology.related_word_lang</code>.
     */
    public void setRelatedWordLang(String value) {
        set(16, value);
    }

    /**
     * Getter for <code>public.view_ww_word_etymology.related_word_lang</code>.
     */
    public String getRelatedWordLang() {
        return (String) get(16);
    }

    /**
     * Setter for <code>public.view_ww_word_etymology.meaning_words</code>.
     */
    public void setMeaningWords(String... value) {
        set(17, value);
    }

    /**
     * Getter for <code>public.view_ww_word_etymology.meaning_words</code>.
     */
    public String[] getMeaningWords() {
        return (String[]) get(17);
    }

    // -------------------------------------------------------------------------
    // Record18 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row18<Long, Long, Long, String, String, String, Boolean, Long, String[], Long, String, Boolean, Boolean, Long, Long, String, String, String[]> fieldsRow() {
        return (Row18) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row18<Long, Long, Long, String, String, String, Boolean, Long, String[], Long, String, Boolean, Boolean, Long, Long, String, String, String[]> valuesRow() {
        return (Row18) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field1() {
        return ViewWwWordEtymology.VIEW_WW_WORD_ETYMOLOGY.WORD_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field2() {
        return ViewWwWordEtymology.VIEW_WW_WORD_ETYMOLOGY.WORD_ETYM_WORD_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field3() {
        return ViewWwWordEtymology.VIEW_WW_WORD_ETYMOLOGY.WORD_ETYM_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return ViewWwWordEtymology.VIEW_WW_WORD_ETYMOLOGY.ETYMOLOGY_TYPE_CODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return ViewWwWordEtymology.VIEW_WW_WORD_ETYMOLOGY.ETYMOLOGY_YEAR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return ViewWwWordEtymology.VIEW_WW_WORD_ETYMOLOGY.WORD_ETYM_COMMENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field7() {
        return ViewWwWordEtymology.VIEW_WW_WORD_ETYMOLOGY.WORD_ETYM_IS_QUESTIONABLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field8() {
        return ViewWwWordEtymology.VIEW_WW_WORD_ETYMOLOGY.WORD_ETYM_ORDER_BY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String[]> field9() {
        return ViewWwWordEtymology.VIEW_WW_WORD_ETYMOLOGY.WORD_ETYM_SOURCES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field10() {
        return ViewWwWordEtymology.VIEW_WW_WORD_ETYMOLOGY.WORD_ETYM_REL_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field11() {
        return ViewWwWordEtymology.VIEW_WW_WORD_ETYMOLOGY.WORD_ETYM_REL_COMMENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field12() {
        return ViewWwWordEtymology.VIEW_WW_WORD_ETYMOLOGY.WORD_ETYM_REL_IS_QUESTIONABLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field13() {
        return ViewWwWordEtymology.VIEW_WW_WORD_ETYMOLOGY.WORD_ETYM_REL_IS_COMPOUND;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field14() {
        return ViewWwWordEtymology.VIEW_WW_WORD_ETYMOLOGY.WORD_ETYM_REL_ORDER_BY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Long> field15() {
        return ViewWwWordEtymology.VIEW_WW_WORD_ETYMOLOGY.RELATED_WORD_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field16() {
        return ViewWwWordEtymology.VIEW_WW_WORD_ETYMOLOGY.RELATED_WORD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field17() {
        return ViewWwWordEtymology.VIEW_WW_WORD_ETYMOLOGY.RELATED_WORD_LANG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String[]> field18() {
        return ViewWwWordEtymology.VIEW_WW_WORD_ETYMOLOGY.MEANING_WORDS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component1() {
        return getWordId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component2() {
        return getWordEtymWordId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component3() {
        return getWordEtymId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getEtymologyTypeCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getEtymologyYear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getWordEtymComment();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component7() {
        return getWordEtymIsQuestionable();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component8() {
        return getWordEtymOrderBy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] component9() {
        return getWordEtymSources();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component10() {
        return getWordEtymRelId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component11() {
        return getWordEtymRelComment();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component12() {
        return getWordEtymRelIsQuestionable();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component13() {
        return getWordEtymRelIsCompound();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component14() {
        return getWordEtymRelOrderBy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long component15() {
        return getRelatedWordId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component16() {
        return getRelatedWord();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component17() {
        return getRelatedWordLang();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] component18() {
        return getMeaningWords();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value1() {
        return getWordId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value2() {
        return getWordEtymWordId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value3() {
        return getWordEtymId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getEtymologyTypeCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getEtymologyYear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getWordEtymComment();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value7() {
        return getWordEtymIsQuestionable();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value8() {
        return getWordEtymOrderBy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] value9() {
        return getWordEtymSources();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value10() {
        return getWordEtymRelId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value11() {
        return getWordEtymRelComment();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value12() {
        return getWordEtymRelIsQuestionable();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value13() {
        return getWordEtymRelIsCompound();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value14() {
        return getWordEtymRelOrderBy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long value15() {
        return getRelatedWordId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value16() {
        return getRelatedWord();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value17() {
        return getRelatedWordLang();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] value18() {
        return getMeaningWords();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwWordEtymologyRecord value1(Long value) {
        setWordId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwWordEtymologyRecord value2(Long value) {
        setWordEtymWordId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwWordEtymologyRecord value3(Long value) {
        setWordEtymId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwWordEtymologyRecord value4(String value) {
        setEtymologyTypeCode(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwWordEtymologyRecord value5(String value) {
        setEtymologyYear(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwWordEtymologyRecord value6(String value) {
        setWordEtymComment(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwWordEtymologyRecord value7(Boolean value) {
        setWordEtymIsQuestionable(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwWordEtymologyRecord value8(Long value) {
        setWordEtymOrderBy(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwWordEtymologyRecord value9(String... value) {
        setWordEtymSources(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwWordEtymologyRecord value10(Long value) {
        setWordEtymRelId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwWordEtymologyRecord value11(String value) {
        setWordEtymRelComment(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwWordEtymologyRecord value12(Boolean value) {
        setWordEtymRelIsQuestionable(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwWordEtymologyRecord value13(Boolean value) {
        setWordEtymRelIsCompound(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwWordEtymologyRecord value14(Long value) {
        setWordEtymRelOrderBy(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwWordEtymologyRecord value15(Long value) {
        setRelatedWordId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwWordEtymologyRecord value16(String value) {
        setRelatedWord(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwWordEtymologyRecord value17(String value) {
        setRelatedWordLang(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwWordEtymologyRecord value18(String... value) {
        setMeaningWords(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwWordEtymologyRecord values(Long value1, Long value2, Long value3, String value4, String value5, String value6, Boolean value7, Long value8, String[] value9, Long value10, String value11, Boolean value12, Boolean value13, Long value14, Long value15, String value16, String value17, String[] value18) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        value17(value17);
        value18(value18);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ViewWwWordEtymologyRecord
     */
    public ViewWwWordEtymologyRecord() {
        super(ViewWwWordEtymology.VIEW_WW_WORD_ETYMOLOGY);
    }

    /**
     * Create a detached, initialised ViewWwWordEtymologyRecord
     */
    public ViewWwWordEtymologyRecord(Long wordId, Long wordEtymWordId, Long wordEtymId, String etymologyTypeCode, String etymologyYear, String wordEtymComment, Boolean wordEtymIsQuestionable, Long wordEtymOrderBy, String[] wordEtymSources, Long wordEtymRelId, String wordEtymRelComment, Boolean wordEtymRelIsQuestionable, Boolean wordEtymRelIsCompound, Long wordEtymRelOrderBy, Long relatedWordId, String relatedWord, String relatedWordLang, String[] meaningWords) {
        super(ViewWwWordEtymology.VIEW_WW_WORD_ETYMOLOGY);

        set(0, wordId);
        set(1, wordEtymWordId);
        set(2, wordEtymId);
        set(3, etymologyTypeCode);
        set(4, etymologyYear);
        set(5, wordEtymComment);
        set(6, wordEtymIsQuestionable);
        set(7, wordEtymOrderBy);
        set(8, wordEtymSources);
        set(9, wordEtymRelId);
        set(10, wordEtymRelComment);
        set(11, wordEtymRelIsQuestionable);
        set(12, wordEtymRelIsCompound);
        set(13, wordEtymRelOrderBy);
        set(14, relatedWordId);
        set(15, relatedWord);
        set(16, relatedWordLang);
        set(17, meaningWords);
    }
}
