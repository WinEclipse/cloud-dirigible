package com.sap.dirigible.repository.db;

import java.util.Map;

import javax.sql.DataSource;

import com.sap.dirigible.repository.api.IRepository;
import com.sap.dirigible.repository.api.IRepositoryProvider;

public class DBRepositoryProvider implements IRepositoryProvider {

	private static final String PARAM_DATASOURCE = "datasource";
	private static final String PARAM_USER = "user";
	private static final String PARAM_RECREATE = "recreate";

	@Override
	public IRepository createRepository(Map<String, Object> parameters) {
		DataSource dataSource = (DataSource) parameters.get(PARAM_DATASOURCE);
		String user = (String) parameters.get(PARAM_USER);
		Boolean forceRecreate = (Boolean) parameters.get(PARAM_RECREATE);
		return new DBRepository(dataSource, user, forceRecreate);
	}

}
