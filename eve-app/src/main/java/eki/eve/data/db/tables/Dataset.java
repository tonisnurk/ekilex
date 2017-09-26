/*
 * This file is generated by jOOQ.
*/
package eki.eve.data.db.tables;


import eki.eve.data.db.Keys;
import eki.eve.data.db.Public;
import eki.eve.data.db.tables.records.DatasetRecord;

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
public class Dataset extends TableImpl<DatasetRecord> {

    private static final long serialVersionUID = -1675818803;

    /**
     * The reference instance of <code>public.dataset</code>
     */
    public static final Dataset DATASET = new Dataset();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DatasetRecord> getRecordType() {
        return DatasetRecord.class;
    }

    /**
     * The column <code>public.dataset.code</code>.
     */
    public final TableField<DatasetRecord, String> CODE = createField("code", org.jooq.impl.SQLDataType.VARCHAR.length(10).nullable(false), this, "");

    /**
     * The column <code>public.dataset.name</code>.
     */
    public final TableField<DatasetRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * Create a <code>public.dataset</code> table reference
     */
    public Dataset() {
        this("dataset", null);
    }

    /**
     * Create an aliased <code>public.dataset</code> table reference
     */
    public Dataset(String alias) {
        this(alias, DATASET);
    }

    private Dataset(String alias, Table<DatasetRecord> aliased) {
        this(alias, aliased, null);
    }

    private Dataset(String alias, Table<DatasetRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<DatasetRecord> getPrimaryKey() {
        return Keys.DATASET_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<DatasetRecord>> getKeys() {
        return Arrays.<UniqueKey<DatasetRecord>>asList(Keys.DATASET_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Dataset as(String alias) {
        return new Dataset(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Dataset rename(String name) {
        return new Dataset(name, null);
    }
}
