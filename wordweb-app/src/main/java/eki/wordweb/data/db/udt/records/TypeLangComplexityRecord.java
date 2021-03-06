/*
 * This file is generated by jOOQ.
 */
package eki.wordweb.data.db.udt.records;


import eki.wordweb.data.db.udt.TypeLangComplexity;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UDTRecordImpl;


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
public class TypeLangComplexityRecord extends UDTRecordImpl<TypeLangComplexityRecord> implements Record2<String, String> {

    private static final long serialVersionUID = -1947707666;

    /**
     * Setter for <code>public.type_lang_complexity.lang</code>.
     */
    public void setLang(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.type_lang_complexity.lang</code>.
     */
    public String getLang() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.type_lang_complexity.complexity</code>.
     */
    public void setComplexity(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.type_lang_complexity.complexity</code>.
     */
    public String getComplexity() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row2<String, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return TypeLangComplexity.LANG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return TypeLangComplexity.COMPLEXITY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getLang();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getComplexity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getLang();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getComplexity();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeLangComplexityRecord value1(String value) {
        setLang(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeLangComplexityRecord value2(String value) {
        setComplexity(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeLangComplexityRecord values(String value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TypeLangComplexityRecord
     */
    public TypeLangComplexityRecord() {
        super(TypeLangComplexity.TYPE_LANG_COMPLEXITY);
    }

    /**
     * Create a detached, initialised TypeLangComplexityRecord
     */
    public TypeLangComplexityRecord(String lang, String complexity) {
        super(TypeLangComplexity.TYPE_LANG_COMPLEXITY);

        set(0, lang);
        set(1, complexity);
    }
}
