/*
 * This file is generated by jOOQ.
 */
package eki.ekilex.data.db.tables;


import eki.ekilex.data.db.Indexes;
import eki.ekilex.data.db.Keys;
import eki.ekilex.data.db.Public;
import eki.ekilex.data.db.tables.records.LexemeRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
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
public class Lexeme extends TableImpl<LexemeRecord> {

    private static final long serialVersionUID = 1636901445;

    /**
     * The reference instance of <code>public.lexeme</code>
     */
    public static final Lexeme LEXEME = new Lexeme();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LexemeRecord> getRecordType() {
        return LexemeRecord.class;
    }

    /**
     * The column <code>public.lexeme.id</code>.
     */
    public final TableField<LexemeRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('lexeme_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.lexeme.word_id</code>.
     */
    public final TableField<LexemeRecord, Long> WORD_ID = createField("word_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.lexeme.meaning_id</code>.
     */
    public final TableField<LexemeRecord, Long> MEANING_ID = createField("meaning_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.lexeme.dataset_code</code>.
     */
    public final TableField<LexemeRecord, String> DATASET_CODE = createField("dataset_code", org.jooq.impl.SQLDataType.VARCHAR(10).nullable(false), this, "");

    /**
     * The column <code>public.lexeme.created_on</code>.
     */
    public final TableField<LexemeRecord, Timestamp> CREATED_ON = createField("created_on", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>public.lexeme.created_by</code>.
     */
    public final TableField<LexemeRecord, String> CREATED_BY = createField("created_by", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>public.lexeme.modified_on</code>.
     */
    public final TableField<LexemeRecord, Timestamp> MODIFIED_ON = createField("modified_on", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>public.lexeme.modified_by</code>.
     */
    public final TableField<LexemeRecord, String> MODIFIED_BY = createField("modified_by", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>public.lexeme.frequency_group</code>.
     */
    public final TableField<LexemeRecord, String> FREQUENCY_GROUP = createField("frequency_group", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>public.lexeme.level1</code>.
     */
    public final TableField<LexemeRecord, Integer> LEVEL1 = createField("level1", org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.lexeme.level2</code>.
     */
    public final TableField<LexemeRecord, Integer> LEVEL2 = createField("level2", org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.lexeme.level3</code>.
     */
    public final TableField<LexemeRecord, Integer> LEVEL3 = createField("level3", org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.lexeme.value_state_code</code>.
     */
    public final TableField<LexemeRecord, String> VALUE_STATE_CODE = createField("value_state_code", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>public.lexeme.process_state_code</code>.
     */
    public final TableField<LexemeRecord, String> PROCESS_STATE_CODE = createField("process_state_code", org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>public.lexeme.order_by</code>.
     */
    public final TableField<LexemeRecord, Long> ORDER_BY = createField("order_by", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('lexeme_order_by_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * Create a <code>public.lexeme</code> table reference
     */
    public Lexeme() {
        this(DSL.name("lexeme"), null);
    }

    /**
     * Create an aliased <code>public.lexeme</code> table reference
     */
    public Lexeme(String alias) {
        this(DSL.name(alias), LEXEME);
    }

    /**
     * Create an aliased <code>public.lexeme</code> table reference
     */
    public Lexeme(Name alias) {
        this(alias, LEXEME);
    }

    private Lexeme(Name alias, Table<LexemeRecord> aliased) {
        this(alias, aliased, null);
    }

    private Lexeme(Name alias, Table<LexemeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Lexeme(Table<O> child, ForeignKey<O, LexemeRecord> key) {
        super(child, key, LEXEME);
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
        return Arrays.<Index>asList(Indexes.LEXEME_MEANING_ID_IDX, Indexes.LEXEME_PKEY, Indexes.LEXEME_WORD_ID_IDX, Indexes.LEXEME_WORD_ID_MEANING_ID_DATASET_CODE_KEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<LexemeRecord, Long> getIdentity() {
        return Keys.IDENTITY_LEXEME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<LexemeRecord> getPrimaryKey() {
        return Keys.LEXEME_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<LexemeRecord>> getKeys() {
        return Arrays.<UniqueKey<LexemeRecord>>asList(Keys.LEXEME_PKEY, Keys.LEXEME_WORD_ID_MEANING_ID_DATASET_CODE_KEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<LexemeRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<LexemeRecord, ?>>asList(Keys.LEXEME__LEXEME_WORD_ID_FKEY, Keys.LEXEME__LEXEME_MEANING_ID_FKEY, Keys.LEXEME__LEXEME_DATASET_CODE_FKEY, Keys.LEXEME__LEXEME_FREQUENCY_GROUP_FKEY, Keys.LEXEME__LEXEME_VALUE_STATE_CODE_FKEY, Keys.LEXEME__LEXEME_PROCESS_STATE_CODE_FKEY);
    }

    public Word word() {
        return new Word(this, Keys.LEXEME__LEXEME_WORD_ID_FKEY);
    }

    public Meaning meaning() {
        return new Meaning(this, Keys.LEXEME__LEXEME_MEANING_ID_FKEY);
    }

    public Dataset dataset() {
        return new Dataset(this, Keys.LEXEME__LEXEME_DATASET_CODE_FKEY);
    }

    public LexemeFrequency lexemeFrequency() {
        return new LexemeFrequency(this, Keys.LEXEME__LEXEME_FREQUENCY_GROUP_FKEY);
    }

    public ValueState valueState() {
        return new ValueState(this, Keys.LEXEME__LEXEME_VALUE_STATE_CODE_FKEY);
    }

    public ProcessState processState() {
        return new ProcessState(this, Keys.LEXEME__LEXEME_PROCESS_STATE_CODE_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Lexeme as(String alias) {
        return new Lexeme(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Lexeme as(Name alias) {
        return new Lexeme(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Lexeme rename(String name) {
        return new Lexeme(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Lexeme rename(Name name) {
        return new Lexeme(name, null);
    }
}
