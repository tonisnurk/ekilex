/*
 * This file is generated by jOOQ.
 */
package eki.ekilex.data.db.tables;


import eki.ekilex.data.db.Public;
import eki.ekilex.data.db.tables.records.ViewWwWordRecord;
import eki.ekilex.data.db.udt.records.TypeDefinitionRecord;
import eki.ekilex.data.db.udt.records.TypeWordRecord;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class ViewWwWord extends TableImpl<ViewWwWordRecord> {

    private static final long serialVersionUID = -1461163074;

    /**
     * The reference instance of <code>public.view_ww_word</code>
     */
    public static final ViewWwWord VIEW_WW_WORD = new ViewWwWord();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ViewWwWordRecord> getRecordType() {
        return ViewWwWordRecord.class;
    }

    /**
     * The column <code>public.view_ww_word.word_id</code>.
     */
    public final TableField<ViewWwWordRecord, Long> WORD_ID = createField("word_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.view_ww_word.word</code>.
     */
    public final TableField<ViewWwWordRecord, String> WORD = createField("word", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.view_ww_word.homonym_nr</code>.
     */
    public final TableField<ViewWwWordRecord, Integer> HOMONYM_NR = createField("homonym_nr", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.view_ww_word.word_class</code>.
     */
    public final TableField<ViewWwWordRecord, String> WORD_CLASS = createField("word_class", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>public.view_ww_word.lang</code>.
     */
    public final TableField<ViewWwWordRecord, String> LANG = createField("lang", org.jooq.impl.SQLDataType.CHAR(3), this, "");

    /**
     * The column <code>public.view_ww_word.word_type_codes</code>.
     */
    public final TableField<ViewWwWordRecord, String[]> WORD_TYPE_CODES = createField("word_type_codes", org.jooq.impl.SQLDataType.VARCHAR.getArrayDataType(), this, "");

    /**
     * The column <code>public.view_ww_word.morph_code</code>.
     */
    public final TableField<ViewWwWordRecord, String> MORPH_CODE = createField("morph_code", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>public.view_ww_word.display_morph_code</code>.
     */
    public final TableField<ViewWwWordRecord, String> DISPLAY_MORPH_CODE = createField("display_morph_code", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>public.view_ww_word.aspect_code</code>.
     */
    public final TableField<ViewWwWordRecord, String> ASPECT_CODE = createField("aspect_code", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>public.view_ww_word.dataset_codes</code>.
     */
    public final TableField<ViewWwWordRecord, String[]> DATASET_CODES = createField("dataset_codes", org.jooq.impl.SQLDataType.VARCHAR.getArrayDataType(), this, "");

    /**
     * The column <code>public.view_ww_word.meaning_count</code>.
     */
    public final TableField<ViewWwWordRecord, Long> MEANING_COUNT = createField("meaning_count", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.view_ww_word.meaning_words</code>.
     */
    public final TableField<ViewWwWordRecord, TypeWordRecord[]> MEANING_WORDS = createField("meaning_words", eki.ekilex.data.db.udt.TypeWord.TYPE_WORD.getDataType().getArrayDataType(), this, "");

    /**
     * The column <code>public.view_ww_word.definitions</code>.
     */
    public final TableField<ViewWwWordRecord, TypeDefinitionRecord[]> DEFINITIONS = createField("definitions", eki.ekilex.data.db.udt.TypeDefinition.TYPE_DEFINITION.getDataType().getArrayDataType(), this, "");

    /**
     * Create a <code>public.view_ww_word</code> table reference
     */
    public ViewWwWord() {
        this(DSL.name("view_ww_word"), null);
    }

    /**
     * Create an aliased <code>public.view_ww_word</code> table reference
     */
    public ViewWwWord(String alias) {
        this(DSL.name(alias), VIEW_WW_WORD);
    }

    /**
     * Create an aliased <code>public.view_ww_word</code> table reference
     */
    public ViewWwWord(Name alias) {
        this(alias, VIEW_WW_WORD);
    }

    private ViewWwWord(Name alias, Table<ViewWwWordRecord> aliased) {
        this(alias, aliased, null);
    }

    private ViewWwWord(Name alias, Table<ViewWwWordRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> ViewWwWord(Table<O> child, ForeignKey<O, ViewWwWordRecord> key) {
        super(child, key, VIEW_WW_WORD);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwWord as(String alias) {
        return new ViewWwWord(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewWwWord as(Name alias) {
        return new ViewWwWord(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ViewWwWord rename(String name) {
        return new ViewWwWord(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ViewWwWord rename(Name name) {
        return new ViewWwWord(name, null);
    }
}
