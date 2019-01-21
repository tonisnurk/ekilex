/*
 * This file is generated by jOOQ.
 */
package eki.ekilex.data.db.tables;


import eki.ekilex.data.db.Indexes;
import eki.ekilex.data.db.Keys;
import eki.ekilex.data.db.Public;
import eki.ekilex.data.db.tables.records.FeedbackLogRecord;

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
public class FeedbackLog extends TableImpl<FeedbackLogRecord> {

    private static final long serialVersionUID = -1316290275;

    /**
     * The reference instance of <code>public.feedback_log</code>
     */
    public static final FeedbackLog FEEDBACK_LOG = new FeedbackLog();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<FeedbackLogRecord> getRecordType() {
        return FeedbackLogRecord.class;
    }

    /**
     * The column <code>public.feedback_log.id</code>.
     */
    public final TableField<FeedbackLogRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('feedback_log_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.feedback_log.feedback_type</code>.
     */
    public final TableField<FeedbackLogRecord, String> FEEDBACK_TYPE = createField("feedback_type", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>public.feedback_log.sender_name</code>.
     */
    public final TableField<FeedbackLogRecord, String> SENDER_NAME = createField("sender_name", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>public.feedback_log.sender_email</code>.
     */
    public final TableField<FeedbackLogRecord, String> SENDER_EMAIL = createField("sender_email", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>public.feedback_log.created_on</code>.
     */
    public final TableField<FeedbackLogRecord, Timestamp> CREATED_ON = createField("created_on", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("statement_timestamp()", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * The column <code>public.feedback_log.word</code>.
     */
    public final TableField<FeedbackLogRecord, String> WORD = createField("word", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>public.feedback_log.definition</code>.
     */
    public final TableField<FeedbackLogRecord, String> DEFINITION = createField("definition", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.feedback_log.comments</code>.
     */
    public final TableField<FeedbackLogRecord, String> COMMENTS = createField("comments", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.feedback_log.usages</code>.
     */
    public final TableField<FeedbackLogRecord, String> USAGES = createField("usages", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.feedback_log.other_info</code>.
     */
    public final TableField<FeedbackLogRecord, String> OTHER_INFO = createField("other_info", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.feedback_log.last_search</code>.
     */
    public final TableField<FeedbackLogRecord, String> LAST_SEARCH = createField("last_search", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>public.feedback_log</code> table reference
     */
    public FeedbackLog() {
        this(DSL.name("feedback_log"), null);
    }

    /**
     * Create an aliased <code>public.feedback_log</code> table reference
     */
    public FeedbackLog(String alias) {
        this(DSL.name(alias), FEEDBACK_LOG);
    }

    /**
     * Create an aliased <code>public.feedback_log</code> table reference
     */
    public FeedbackLog(Name alias) {
        this(alias, FEEDBACK_LOG);
    }

    private FeedbackLog(Name alias, Table<FeedbackLogRecord> aliased) {
        this(alias, aliased, null);
    }

    private FeedbackLog(Name alias, Table<FeedbackLogRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> FeedbackLog(Table<O> child, ForeignKey<O, FeedbackLogRecord> key) {
        super(child, key, FEEDBACK_LOG);
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
        return Arrays.<Index>asList(Indexes.FEEDBACK_LOG_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<FeedbackLogRecord, Long> getIdentity() {
        return Keys.IDENTITY_FEEDBACK_LOG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<FeedbackLogRecord> getPrimaryKey() {
        return Keys.FEEDBACK_LOG_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<FeedbackLogRecord>> getKeys() {
        return Arrays.<UniqueKey<FeedbackLogRecord>>asList(Keys.FEEDBACK_LOG_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FeedbackLog as(String alias) {
        return new FeedbackLog(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FeedbackLog as(Name alias) {
        return new FeedbackLog(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public FeedbackLog rename(String name) {
        return new FeedbackLog(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public FeedbackLog rename(Name name) {
        return new FeedbackLog(name, null);
    }
}
