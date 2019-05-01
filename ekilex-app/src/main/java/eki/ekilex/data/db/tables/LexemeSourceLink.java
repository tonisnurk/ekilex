/*
 * This file is generated by jOOQ.
 */
package eki.ekilex.data.db.tables;


import eki.ekilex.data.db.Indexes;
import eki.ekilex.data.db.Keys;
import eki.ekilex.data.db.Public;
import eki.ekilex.data.db.tables.records.LexemeSourceLinkRecord;

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
public class LexemeSourceLink extends TableImpl<LexemeSourceLinkRecord> {

    private static final long serialVersionUID = -1850975481;

    /**
     * The reference instance of <code>public.lexeme_source_link</code>
     */
    public static final LexemeSourceLink LEXEME_SOURCE_LINK = new LexemeSourceLink();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LexemeSourceLinkRecord> getRecordType() {
        return LexemeSourceLinkRecord.class;
    }

    /**
     * The column <code>public.lexeme_source_link.id</code>.
     */
    public final TableField<LexemeSourceLinkRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('lexeme_source_link_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.lexeme_source_link.lexeme_id</code>.
     */
    public final TableField<LexemeSourceLinkRecord, Long> LEXEME_ID = createField("lexeme_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.lexeme_source_link.source_id</code>.
     */
    public final TableField<LexemeSourceLinkRecord, Long> SOURCE_ID = createField("source_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.lexeme_source_link.type</code>.
     */
    public final TableField<LexemeSourceLinkRecord, String> TYPE = createField("type", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>public.lexeme_source_link.name</code>.
     */
    public final TableField<LexemeSourceLinkRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.lexeme_source_link.value</code>.
     */
    public final TableField<LexemeSourceLinkRecord, String> VALUE = createField("value", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.lexeme_source_link.order_by</code>.
     */
    public final TableField<LexemeSourceLinkRecord, Long> ORDER_BY = createField("order_by", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('lexeme_source_link_order_by_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * Create a <code>public.lexeme_source_link</code> table reference
     */
    public LexemeSourceLink() {
        this(DSL.name("lexeme_source_link"), null);
    }

    /**
     * Create an aliased <code>public.lexeme_source_link</code> table reference
     */
    public LexemeSourceLink(String alias) {
        this(DSL.name(alias), LEXEME_SOURCE_LINK);
    }

    /**
     * Create an aliased <code>public.lexeme_source_link</code> table reference
     */
    public LexemeSourceLink(Name alias) {
        this(alias, LEXEME_SOURCE_LINK);
    }

    private LexemeSourceLink(Name alias, Table<LexemeSourceLinkRecord> aliased) {
        this(alias, aliased, null);
    }

    private LexemeSourceLink(Name alias, Table<LexemeSourceLinkRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> LexemeSourceLink(Table<O> child, ForeignKey<O, LexemeSourceLinkRecord> key) {
        super(child, key, LEXEME_SOURCE_LINK);
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
        return Arrays.<Index>asList(Indexes.LEXEME_SOURCE_LINK_LEXEME_ID_IDX, Indexes.LEXEME_SOURCE_LINK_PKEY, Indexes.LEXEME_SOURCE_LINK_SOURCE_ID_IDX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<LexemeSourceLinkRecord, Long> getIdentity() {
        return Keys.IDENTITY_LEXEME_SOURCE_LINK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<LexemeSourceLinkRecord> getPrimaryKey() {
        return Keys.LEXEME_SOURCE_LINK_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<LexemeSourceLinkRecord>> getKeys() {
        return Arrays.<UniqueKey<LexemeSourceLinkRecord>>asList(Keys.LEXEME_SOURCE_LINK_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<LexemeSourceLinkRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<LexemeSourceLinkRecord, ?>>asList(Keys.LEXEME_SOURCE_LINK__LEXEME_SOURCE_LINK_LEXEME_ID_FKEY, Keys.LEXEME_SOURCE_LINK__LEXEME_SOURCE_LINK_SOURCE_ID_FKEY);
    }

    public Lexeme lexeme() {
        return new Lexeme(this, Keys.LEXEME_SOURCE_LINK__LEXEME_SOURCE_LINK_LEXEME_ID_FKEY);
    }

    public Source source() {
        return new Source(this, Keys.LEXEME_SOURCE_LINK__LEXEME_SOURCE_LINK_SOURCE_ID_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LexemeSourceLink as(String alias) {
        return new LexemeSourceLink(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LexemeSourceLink as(Name alias) {
        return new LexemeSourceLink(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public LexemeSourceLink rename(String name) {
        return new LexemeSourceLink(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public LexemeSourceLink rename(Name name) {
        return new LexemeSourceLink(name, null);
    }
}
