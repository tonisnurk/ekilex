/*
 * This file is generated by jOOQ.
 */
package eki.ekilex.data.db.tables;


import eki.ekilex.data.db.Indexes;
import eki.ekilex.data.db.Keys;
import eki.ekilex.data.db.Public;
import eki.ekilex.data.db.tables.records.WordWordTypeRecord;

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
        "jOOQ version:3.11.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class WordWordType extends TableImpl<WordWordTypeRecord> {

    private static final long serialVersionUID = 989283633;

    /**
     * The reference instance of <code>public.word_word_type</code>
     */
    public static final WordWordType WORD_WORD_TYPE = new WordWordType();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<WordWordTypeRecord> getRecordType() {
        return WordWordTypeRecord.class;
    }

    /**
     * The column <code>public.word_word_type.id</code>.
     */
    public final TableField<WordWordTypeRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('word_word_type_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.word_word_type.word_id</code>.
     */
    public final TableField<WordWordTypeRecord, Long> WORD_ID = createField("word_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.word_word_type.word_type_code</code>.
     */
    public final TableField<WordWordTypeRecord, String> WORD_TYPE_CODE = createField("word_type_code", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>public.word_word_type.order_by</code>.
     */
    public final TableField<WordWordTypeRecord, Long> ORDER_BY = createField("order_by", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('word_word_type_order_by_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * Create a <code>public.word_word_type</code> table reference
     */
    public WordWordType() {
        this(DSL.name("word_word_type"), null);
    }

    /**
     * Create an aliased <code>public.word_word_type</code> table reference
     */
    public WordWordType(String alias) {
        this(DSL.name(alias), WORD_WORD_TYPE);
    }

    /**
     * Create an aliased <code>public.word_word_type</code> table reference
     */
    public WordWordType(Name alias) {
        this(alias, WORD_WORD_TYPE);
    }

    private WordWordType(Name alias, Table<WordWordTypeRecord> aliased) {
        this(alias, aliased, null);
    }

    private WordWordType(Name alias, Table<WordWordTypeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> WordWordType(Table<O> child, ForeignKey<O, WordWordTypeRecord> key) {
        super(child, key, WORD_WORD_TYPE);
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
        return Arrays.<Index>asList(Indexes.WORD_WORD_TYPE_PKEY, Indexes.WORD_WORD_TYPE_WORD_ID_WORD_TYPE_CODE_KEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<WordWordTypeRecord, Long> getIdentity() {
        return Keys.IDENTITY_WORD_WORD_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<WordWordTypeRecord> getPrimaryKey() {
        return Keys.WORD_WORD_TYPE_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<WordWordTypeRecord>> getKeys() {
        return Arrays.<UniqueKey<WordWordTypeRecord>>asList(Keys.WORD_WORD_TYPE_PKEY, Keys.WORD_WORD_TYPE_WORD_ID_WORD_TYPE_CODE_KEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<WordWordTypeRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<WordWordTypeRecord, ?>>asList(Keys.WORD_WORD_TYPE__WORD_WORD_TYPE_WORD_ID_FKEY, Keys.WORD_WORD_TYPE__WORD_WORD_TYPE_WORD_TYPE_CODE_FKEY);
    }

    public Word word() {
        return new Word(this, Keys.WORD_WORD_TYPE__WORD_WORD_TYPE_WORD_ID_FKEY);
    }

    public WordType wordType() {
        return new WordType(this, Keys.WORD_WORD_TYPE__WORD_WORD_TYPE_WORD_TYPE_CODE_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WordWordType as(String alias) {
        return new WordWordType(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WordWordType as(Name alias) {
        return new WordWordType(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public WordWordType rename(String name) {
        return new WordWordType(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public WordWordType rename(Name name) {
        return new WordWordType(name, null);
    }
}
