/*
 * This file is generated by jOOQ.
*/
package eki.eve.data.db.tables;


import eki.eve.data.db.Keys;
import eki.eve.data.db.Public;
import eki.eve.data.db.tables.records.LexemePosRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.5"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LexemePos extends TableImpl<LexemePosRecord> {

    private static final long serialVersionUID = -2126402934;

    /**
     * The reference instance of <code>public.lexeme_pos</code>
     */
    public static final LexemePos LEXEME_POS = new LexemePos();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LexemePosRecord> getRecordType() {
        return LexemePosRecord.class;
    }

    /**
     * The column <code>public.lexeme_pos.id</code>.
     */
    public final TableField<LexemePosRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('lexeme_pos_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.lexeme_pos.lexeme_id</code>.
     */
    public final TableField<LexemePosRecord, Long> LEXEME_ID = createField("lexeme_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.lexeme_pos.pos_code</code>.
     */
    public final TableField<LexemePosRecord, String> POS_CODE = createField("pos_code", org.jooq.impl.SQLDataType.VARCHAR.length(100).nullable(false), this, "");

    /**
     * Create a <code>public.lexeme_pos</code> table reference
     */
    public LexemePos() {
        this("lexeme_pos", null);
    }

    /**
     * Create an aliased <code>public.lexeme_pos</code> table reference
     */
    public LexemePos(String alias) {
        this(alias, LEXEME_POS);
    }

    private LexemePos(String alias, Table<LexemePosRecord> aliased) {
        this(alias, aliased, null);
    }

    private LexemePos(String alias, Table<LexemePosRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
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
    public Identity<LexemePosRecord, Long> getIdentity() {
        return Keys.IDENTITY_LEXEME_POS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<LexemePosRecord> getPrimaryKey() {
        return Keys.LEXEME_POS_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<LexemePosRecord>> getKeys() {
        return Arrays.<UniqueKey<LexemePosRecord>>asList(Keys.LEXEME_POS_PKEY, Keys.LEXEME_POS_LEXEME_ID_POS_CODE_KEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<LexemePosRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<LexemePosRecord, ?>>asList(Keys.LEXEME_POS__LEXEME_POS_LEXEME_ID_FKEY, Keys.LEXEME_POS__LEXEME_POS_POS_CODE_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LexemePos as(String alias) {
        return new LexemePos(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public LexemePos rename(String name) {
        return new LexemePos(name, null);
    }
}
