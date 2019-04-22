package com.devskiller.jpa2ddl.engines;

class SQLServerDecorator extends EngineDecorator {

	@Override
	public String decorateConnectionString(String connectionString, String init) {
		return super.decorateConnectionString(connectionString + ";MODE=MSSQLServer", init);
	}
}
