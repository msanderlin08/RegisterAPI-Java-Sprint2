package edu.uark.models.entities;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.dataaccess.repository.DatabaseTable;
import edu.uark.models.api.Transaction;
import edu.uark.models.entities.fieldnames.TransactionFieldNames;
import org.apache.commons.lang3.StringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class TransactionEntity extends BaseEntity<TransactionEntity> {
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.lookupCode = rs.getString(TransactionFieldNames.LOOKUP_CODE);
		this.count = rs.getInt(TransactionFieldNames.COUNT);
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		record.put(TransactionFieldNames.LOOKUP_CODE, this.lookupCode);
		record.put(TransactionFieldNames.COUNT, this.count);

		return record;
	}

	private String lookupCode;
	public String getLookupCode() {
		return this.lookupCode;
	}
	public TransactionEntity setLookupCode(String lookupCode) {
		if (!StringUtils.equals(this.lookupCode, lookupCode)) {
			this.lookupCode = lookupCode;
			this.propertyChanged(TransactionFieldNames.LOOKUP_CODE);
		}

		return this;
	}

	private int count;
	public int getCount() {
		return this.count;
	}
	public TransactionEntity setCount(int count) {
		if (this.count != count) {
			this.count = count;
			this.propertyChanged(TransactionFieldNames.COUNT);
		}

		return this;
	}

	public Transaction synchronize(Transaction apiTransaction) {
		this.setCount(apiTransaction.getCount());
		this.setLookupCode(apiTransaction.getLookupCode());

		apiTransaction.setId(this.getId());
		apiTransaction.setCreatedOn(this.getCreatedOn());

		return apiTransaction;
	}

	public TransactionEntity() {
		super(DatabaseTable.PRODUCT);

		this.count = -1;
		this.lookupCode = StringUtils.EMPTY;
	}

	public TransactionEntity(Transaction apiTransaction) {
		super(DatabaseTable.PRODUCT);
		
		this.count = apiTransaction.getCount();
		this.lookupCode = apiTransaction.getLookupCode();
	}
}
