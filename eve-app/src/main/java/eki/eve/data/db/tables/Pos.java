/*
 * This file is generated by jOOQ.
*/
package eki.eve.data.db.tables;


import eki.eve.data.db.Keys;
import eki.eve.data.db.Public;
import eki.eve.data.db.tables.records.PosRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
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
public class Pos extends TableImpl<PosRecord> {

    private static final long serialVersionUID = -1832361368;

    /**
     * The reference instance of <code>public.pos</code>
     */
    public static final Pos POS = new Pos();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PosRecord> getRecordType() {
        return PosRecord.class;
    }

    /**
     * The column <code>public.pos.code</code>.
     */
    public final TableField<PosRecord, String> CODE = createField("code", org.jooq.impl.SQLDataType.VARCHAR.length(100).nullable(false), this, "");

    /**
     * The column <code>public.pos.dataset</code>.
     */
    public final TableField<PosRecord, String[]> DATASET = createField("dataset", org.jooq.impl.SQLDataType.VARCHAR.getArrayDataType(), this, "");

    /**
     * Create a <code>public.pos</code> table reference
     */
    public Pos() {
        this("pos", null);
    }

    /**
     * Create an aliased <code>public.pos</code> table reference
     */
    public Pos(String alias) {
        this(alias, POS);
    }

    private Pos(String alias, Table<PosRecord> aliased) {
        this(alias, aliased, null);
    }

    private Pos(String alias, Table<PosRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<PosRecord> getPrimaryKey() {
        return Keys.POS_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<PosRecord>> getKeys() {
        return Arrays.<UniqueKey<PosRecord>>asList(Keys.POS_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pos as(String alias) {
        return new Pos(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Pos rename(String name) {
        return new Pos(name, null);
    }
}
