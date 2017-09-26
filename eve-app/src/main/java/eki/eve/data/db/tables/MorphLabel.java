/*
 * This file is generated by jOOQ.
*/
package eki.eve.data.db.tables;


import eki.eve.data.db.Keys;
import eki.eve.data.db.Public;
import eki.eve.data.db.tables.records.MorphLabelRecord;

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
public class MorphLabel extends TableImpl<MorphLabelRecord> {

    private static final long serialVersionUID = 1063335608;

    /**
     * The reference instance of <code>public.morph_label</code>
     */
    public static final MorphLabel MORPH_LABEL = new MorphLabel();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MorphLabelRecord> getRecordType() {
        return MorphLabelRecord.class;
    }

    /**
     * The column <code>public.morph_label.code</code>.
     */
    public final TableField<MorphLabelRecord, String> CODE = createField("code", org.jooq.impl.SQLDataType.VARCHAR.length(100).nullable(false), this, "");

    /**
     * The column <code>public.morph_label.value</code>.
     */
    public final TableField<MorphLabelRecord, String> VALUE = createField("value", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>public.morph_label.lang</code>.
     */
    public final TableField<MorphLabelRecord, String> LANG = createField("lang", org.jooq.impl.SQLDataType.CHAR.length(3).nullable(false), this, "");

    /**
     * The column <code>public.morph_label.type</code>.
     */
    public final TableField<MorphLabelRecord, String> TYPE = createField("type", org.jooq.impl.SQLDataType.VARCHAR.length(10).nullable(false), this, "");

    /**
     * Create a <code>public.morph_label</code> table reference
     */
    public MorphLabel() {
        this("morph_label", null);
    }

    /**
     * Create an aliased <code>public.morph_label</code> table reference
     */
    public MorphLabel(String alias) {
        this(alias, MORPH_LABEL);
    }

    private MorphLabel(String alias, Table<MorphLabelRecord> aliased) {
        this(alias, aliased, null);
    }

    private MorphLabel(String alias, Table<MorphLabelRecord> aliased, Field<?>[] parameters) {
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
    public List<UniqueKey<MorphLabelRecord>> getKeys() {
        return Arrays.<UniqueKey<MorphLabelRecord>>asList(Keys.MORPH_LABEL_CODE_LANG_TYPE_KEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<MorphLabelRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<MorphLabelRecord, ?>>asList(Keys.MORPH_LABEL__MORPH_LABEL_CODE_FKEY, Keys.MORPH_LABEL__MORPH_LABEL_LANG_FKEY, Keys.MORPH_LABEL__MORPH_LABEL_TYPE_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MorphLabel as(String alias) {
        return new MorphLabel(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public MorphLabel rename(String name) {
        return new MorphLabel(name, null);
    }
}
