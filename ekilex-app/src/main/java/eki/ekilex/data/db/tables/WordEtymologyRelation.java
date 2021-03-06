/*
 * This file is generated by jOOQ.
 */
package eki.ekilex.data.db.tables;


import eki.ekilex.data.db.Indexes;
import eki.ekilex.data.db.Keys;
import eki.ekilex.data.db.Public;
import eki.ekilex.data.db.tables.records.WordEtymologyRelationRecord;

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
public class WordEtymologyRelation extends TableImpl<WordEtymologyRelationRecord> {

    private static final long serialVersionUID = 1252637160;

    /**
     * The reference instance of <code>public.word_etymology_relation</code>
     */
    public static final WordEtymologyRelation WORD_ETYMOLOGY_RELATION = new WordEtymologyRelation();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<WordEtymologyRelationRecord> getRecordType() {
        return WordEtymologyRelationRecord.class;
    }

    /**
     * The column <code>public.word_etymology_relation.id</code>.
     */
    public final TableField<WordEtymologyRelationRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('word_etymology_relation_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.word_etymology_relation.word_etym_id</code>.
     */
    public final TableField<WordEtymologyRelationRecord, Long> WORD_ETYM_ID = createField("word_etym_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.word_etymology_relation.related_word_id</code>.
     */
    public final TableField<WordEtymologyRelationRecord, Long> RELATED_WORD_ID = createField("related_word_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.word_etymology_relation.comment</code>.
     */
    public final TableField<WordEtymologyRelationRecord, String> COMMENT = createField("comment", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.word_etymology_relation.comment_prese</code>.
     */
    public final TableField<WordEtymologyRelationRecord, String> COMMENT_PRESE = createField("comment_prese", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.word_etymology_relation.is_questionable</code>.
     */
    public final TableField<WordEtymologyRelationRecord, Boolean> IS_QUESTIONABLE = createField("is_questionable", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.field("false", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>public.word_etymology_relation.is_compound</code>.
     */
    public final TableField<WordEtymologyRelationRecord, Boolean> IS_COMPOUND = createField("is_compound", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.field("false", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>public.word_etymology_relation.order_by</code>.
     */
    public final TableField<WordEtymologyRelationRecord, Long> ORDER_BY = createField("order_by", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('word_etymology_relation_order_by_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * Create a <code>public.word_etymology_relation</code> table reference
     */
    public WordEtymologyRelation() {
        this(DSL.name("word_etymology_relation"), null);
    }

    /**
     * Create an aliased <code>public.word_etymology_relation</code> table reference
     */
    public WordEtymologyRelation(String alias) {
        this(DSL.name(alias), WORD_ETYMOLOGY_RELATION);
    }

    /**
     * Create an aliased <code>public.word_etymology_relation</code> table reference
     */
    public WordEtymologyRelation(Name alias) {
        this(alias, WORD_ETYMOLOGY_RELATION);
    }

    private WordEtymologyRelation(Name alias, Table<WordEtymologyRelationRecord> aliased) {
        this(alias, aliased, null);
    }

    private WordEtymologyRelation(Name alias, Table<WordEtymologyRelationRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> WordEtymologyRelation(Table<O> child, ForeignKey<O, WordEtymologyRelationRecord> key) {
        super(child, key, WORD_ETYMOLOGY_RELATION);
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
        return Arrays.<Index>asList(Indexes.WORD_ETYM_REL_REL_WORD_ID_IDX, Indexes.WORD_ETYM_REL_WORD_ETYM_ID_IDX, Indexes.WORD_ETYMOLOGY_RELATION_PKEY, Indexes.WORD_ETYMOLOGY_RELATION_WORD_ETYM_ID_RELATED_WORD_ID_KEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<WordEtymologyRelationRecord, Long> getIdentity() {
        return Keys.IDENTITY_WORD_ETYMOLOGY_RELATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<WordEtymologyRelationRecord> getPrimaryKey() {
        return Keys.WORD_ETYMOLOGY_RELATION_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<WordEtymologyRelationRecord>> getKeys() {
        return Arrays.<UniqueKey<WordEtymologyRelationRecord>>asList(Keys.WORD_ETYMOLOGY_RELATION_PKEY, Keys.WORD_ETYMOLOGY_RELATION_WORD_ETYM_ID_RELATED_WORD_ID_KEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<WordEtymologyRelationRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<WordEtymologyRelationRecord, ?>>asList(Keys.WORD_ETYMOLOGY_RELATION__WORD_ETYMOLOGY_RELATION_WORD_ETYM_ID_FKEY, Keys.WORD_ETYMOLOGY_RELATION__WORD_ETYMOLOGY_RELATION_RELATED_WORD_ID_FKEY);
    }

    public WordEtymology wordEtymology() {
        return new WordEtymology(this, Keys.WORD_ETYMOLOGY_RELATION__WORD_ETYMOLOGY_RELATION_WORD_ETYM_ID_FKEY);
    }

    public Word word() {
        return new Word(this, Keys.WORD_ETYMOLOGY_RELATION__WORD_ETYMOLOGY_RELATION_RELATED_WORD_ID_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WordEtymologyRelation as(String alias) {
        return new WordEtymologyRelation(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WordEtymologyRelation as(Name alias) {
        return new WordEtymologyRelation(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public WordEtymologyRelation rename(String name) {
        return new WordEtymologyRelation(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public WordEtymologyRelation rename(Name name) {
        return new WordEtymologyRelation(name, null);
    }
}
