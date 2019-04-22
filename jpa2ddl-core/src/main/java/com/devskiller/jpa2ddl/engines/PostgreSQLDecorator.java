package com.devskiller.jpa2ddl.engines;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.h2.util.Utils;

class PostgreSQLDecorator extends EngineDecorator {

	@Override
	public String decorateConnectionString(String connectionString, String init) {
		return super.decorateConnectionString(
        connectionString 
          + ";MODE=PostgreSQL;INIT=set search_path to pg_catalog,public"
          + (init != null ? "\\;" + init : ""),
        null
    );
	}

	@Override
	public void decorateDatabaseInitialization(Connection connection) throws IOException, SQLException {
		String dbInit = new String(Utils.getResource("/org/h2/server/pg/pg_catalog.sql"));
		connection.prepareStatement(dbInit).execute();
	}
}
