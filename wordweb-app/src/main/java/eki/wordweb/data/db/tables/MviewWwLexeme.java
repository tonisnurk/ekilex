/*
 * This file is generated by jOOQ.
 */
package eki.wordweb.data.db.tables;


import eki.wordweb.data.db.Indexes;
import eki.wordweb.data.db.Public;
import eki.wordweb.data.db.tables.records.MviewWwLexemeRecord;
import eki.wordweb.data.db.udt.records.TypeGovernmentRecord;
import eki.wordweb.data.db.udt.records.TypeGrammarRecord;
import eki.wordweb.data.db.udt.records.TypeMeaningWordRecord;
import eki.wordweb.data.db.udt.records.TypePublicNoteRecord;
import eki.wordweb.data.db.udt.records.TypeUsageRecord;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
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
public class MviewWwLexeme extends TableImpl<MviewWwLexemeRecord> {

    private static final long serialVersionUID = -2048980476;

    /**
     * The reference instance of <code>public.mview_ww_lexeme</code>
     */
    public static final MviewWwLexeme MVIEW_WW_LEXEME = new MviewWwLexeme();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MviewWwLexemeRecord> getRecordType() {
        return MviewWwLexemeRecord.class;
    }

    /**
     * The column <code>public.mview_ww_lexeme.lexeme_id</code>.
     */
    public final TableField<MviewWwLexemeRecord, Long> LEXEME_ID = createField("lexeme_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.mview_ww_lexeme.word_id</code>.
     */
    public final TableField<MviewWwLexemeRecord, Long> WORD_ID = createField("word_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.mview_ww_lexeme.meaning_id</code>.
     */
    public final TableField<MviewWwLexemeRecord, Long> MEANING_ID = createField("meaning_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.mview_ww_lexeme.dataset_type</code>.
     */
    public final TableField<MviewWwLexemeRecord, String> DATASET_TYPE = createField("dataset_type", org.jooq.impl.SQLDataType.VARCHAR(10), this, "");

    /**
     * The column <code>public.mview_ww_lexeme.dataset_code</code>.
     */
    public final TableField<MviewWwLexemeRecord, String> DATASET_CODE = createField("dataset_code", org.jooq.impl.SQLDataType.VARCHAR(10), this, "");

    /**
     * The column <code>public.mview_ww_lexeme.level1</code>.
     */
    public final TableField<MviewWwLexemeRecord, Integer> LEVEL1 = createField("level1", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.mview_ww_lexeme.level2</code>.
     */
    public final TableField<MviewWwLexemeRecord, Integer> LEVEL2 = createField("level2", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>public.mview_ww_lexeme.weight</code>.
     */
    public final TableField<MviewWwLexemeRecord, BigDecimal> WEIGHT = createField("weight", org.jooq.impl.SQLDataType.NUMERIC(5, 4), this, "");

    /**
     * The column <code>public.mview_ww_lexeme.complexity</code>.
     */
    public final TableField<MviewWwLexemeRecord, String> COMPLEXITY = createField("complexity", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>public.mview_ww_lexeme.lex_order_by</code>.
     */
    public final TableField<MviewWwLexemeRecord, Long> LEX_ORDER_BY = createField("lex_order_by", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>public.mview_ww_lexeme.register_codes</code>.
     */
    public final TableField<MviewWwLexemeRecord, String[]> REGISTER_CODES = createField("register_codes", org.jooq.impl.SQLDataType.VARCHAR.getArrayDataType(), this, "");

    /**
     * The column <code>public.mview_ww_lexeme.pos_codes</code>.
     */
    public final TableField<MviewWwLexemeRecord, String[]> POS_CODES = createField("pos_codes", org.jooq.impl.SQLDataType.VARCHAR.getArrayDataType(), this, "");

    /**
     * The column <code>public.mview_ww_lexeme.deriv_codes</code>.
     */
    public final TableField<MviewWwLexemeRecord, String[]> DERIV_CODES = createField("deriv_codes", org.jooq.impl.SQLDataType.VARCHAR.getArrayDataType(), this, "");

    /**
     * The column <code>public.mview_ww_lexeme.meaning_words</code>.
     */
    public final TableField<MviewWwLexemeRecord, TypeMeaningWordRecord[]> MEANING_WORDS = createField("meaning_words", eki.wordweb.data.db.udt.TypeMeaningWord.TYPE_MEANING_WORD.getDataType().getArrayDataType(), this, "");

    /**
     * The column <code>public.mview_ww_lexeme.advice_notes</code>.
     */
    public final TableField<MviewWwLexemeRecord, String[]> ADVICE_NOTES = createField("advice_notes", org.jooq.impl.SQLDataType.CLOB.getArrayDataType(), this, "");

    /**
     * The column <code>public.mview_ww_lexeme.public_notes</code>.
     */
    public final TableField<MviewWwLexemeRecord, TypePublicNoteRecord[]> PUBLIC_NOTES = createField("public_notes", eki.wordweb.data.db.udt.TypePublicNote.TYPE_PUBLIC_NOTE.getDataType().getArrayDataType(), this, "");

    /**
     * The column <code>public.mview_ww_lexeme.grammars</code>.
     */
    public final TableField<MviewWwLexemeRecord, TypeGrammarRecord[]> GRAMMARS = createField("grammars", eki.wordweb.data.db.udt.TypeGrammar.TYPE_GRAMMAR.getDataType().getArrayDataType(), this, "");

    /**
     * The column <code>public.mview_ww_lexeme.governments</code>.
     */
    public final TableField<MviewWwLexemeRecord, TypeGovernmentRecord[]> GOVERNMENTS = createField("governments", eki.wordweb.data.db.udt.TypeGovernment.TYPE_GOVERNMENT.getDataType().getArrayDataType(), this, "");

    /**
     * The column <code>public.mview_ww_lexeme.usages</code>.
     */
    public final TableField<MviewWwLexemeRecord, TypeUsageRecord[]> USAGES = createField("usages", eki.wordweb.data.db.udt.TypeUsage.TYPE_USAGE.getDataType().getArrayDataType(), this, "");

    /**
     * The column <code>public.mview_ww_lexeme.od_lexeme_recommendations</code>.
     */
    public final TableField<MviewWwLexemeRecord, String[]> OD_LEXEME_RECOMMENDATIONS = createField("od_lexeme_recommendations", org.jooq.impl.SQLDataType.CLOB.getArrayDataType(), this, "");

    /**
     * The column <code>public.mview_ww_lexeme.lang_filter</code>.
     */
    public final TableField<MviewWwLexemeRecord, String[]> LANG_FILTER = createField("lang_filter", org.jooq.impl.SQLDataType.VARCHAR.getArrayDataType(), this, "");

    /**
     * Create a <code>public.mview_ww_lexeme</code> table reference
     */
    public MviewWwLexeme() {
        this(DSL.name("mview_ww_lexeme"), null);
    }

    /**
     * Create an aliased <code>public.mview_ww_lexeme</code> table reference
     */
    public MviewWwLexeme(String alias) {
        this(DSL.name(alias), MVIEW_WW_LEXEME);
    }

    /**
     * Create an aliased <code>public.mview_ww_lexeme</code> table reference
     */
    public MviewWwLexeme(Name alias) {
        this(alias, MVIEW_WW_LEXEME);
    }

    private MviewWwLexeme(Name alias, Table<MviewWwLexemeRecord> aliased) {
        this(alias, aliased, null);
    }

    private MviewWwLexeme(Name alias, Table<MviewWwLexemeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> MviewWwLexeme(Table<O> child, ForeignKey<O, MviewWwLexemeRecord> key) {
        super(child, key, MVIEW_WW_LEXEME);
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
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.MVIEW_WW_LEXEME_COMPLEXITY_IDX, Indexes.MVIEW_WW_LEXEME_DATASET_TYPE_IDX, Indexes.MVIEW_WW_LEXEME_LANG_FILTER_GIN_IDX, Indexes.MVIEW_WW_LEXEME_LEXEME_ID_IDX, Indexes.MVIEW_WW_LEXEME_MEANING_ID_IDX, Indexes.MVIEW_WW_LEXEME_WORD_ID_IDX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwLexeme as(String alias) {
        return new MviewWwLexeme(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MviewWwLexeme as(Name alias) {
        return new MviewWwLexeme(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public MviewWwLexeme rename(String name) {
        return new MviewWwLexeme(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public MviewWwLexeme rename(Name name) {
        return new MviewWwLexeme(name, null);
    }
}
