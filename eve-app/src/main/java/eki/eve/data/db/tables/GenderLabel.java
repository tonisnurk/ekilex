/*
 * This file is generated by jOOQ.
*/
package eki.eve.data.db.tables;


import eki.eve.data.db.Keys;
import eki.eve.data.db.Public;
import eki.eve.data.db.tables.records.GenderLabelRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
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
public class GenderLabel extends TableImpl<GenderLabelRecord> {

    private static final long serialVersionUID = 1571525076;

    /**
     * The reference instance of <code>public.gender_label</code>
     */
    public static final GenderLabel GENDER_LABEL = new GenderLabel();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<GenderLabelRecord> getRecordType() {
        return GenderLabelRecord.class;
    }

    /**
     * The column <code>public.gender_label.code</code>.
     */
    public final TableField<GenderLabelRecord, String> CODE = createField("code", org.jooq.impl.SQLDataType.VARCHAR.length(100).nullable(false), this, "");

    /**
     * The column <code>public.gender_label.value</code>.
     */
    public final TableField<GenderLabelRecord, String> VALUE = createField("value", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>public.gender_label.lang</code>.
     */
    public final TableField<GenderLabelRecord, String> LANG = createField("lang", org.jooq.impl.SQLDataType.CHAR.length(3).nullable(false), this, "");

    /**
     * The column <code>public.gender_label.type</code>.
     */
    public final TableField<GenderLabelRecord, String> TYPE = createField("type", org.jooq.impl.SQLDataType.VARCHAR.length(10).nullable(false), this, "");

    /**
     * Create a <code>public.gender_label</code> table reference
     */
    public GenderLabel() {
        this("gender_label", null);
    }

    /**
     * Create an aliased <code>public.gender_label</code> table reference
     */
    public GenderLabel(String alias) {
        this(alias, GENDER_LABEL);
    }

    private GenderLabel(String alias, Table<GenderLabelRecord> aliased) {
        this(alias, aliased, null);
    }

    private GenderLabel(String alias, Table<GenderLabelRecord> aliased, Field<?>[] parameters) {
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
    public List<UniqueKey<GenderLabelRecord>> getKeys() {
        return Arrays.<UniqueKey<GenderLabelRecord>>asList(Keys.GENDER_LABEL_CODE_LANG_TYPE_KEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<GenderLabelRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<GenderLabelRecord, ?>>asList(Keys.GENDER_LABEL__GENDER_LABEL_CODE_FKEY, Keys.GENDER_LABEL__GENDER_LABEL_LANG_FKEY, Keys.GENDER_LABEL__GENDER_LABEL_TYPE_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GenderLabel as(String alias) {
        return new GenderLabel(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public GenderLabel rename(String name) {
        return new GenderLabel(name, null);
    }
}
