package com.devskiller.jpa2ddl.engines;

class MySQLDecorator extends EngineDecorator {

	@Override
	public String decorateConnectionString(String connectionString, String init) {
		return super.decorateConnectionString(connectionString + ";MODE=MYSQL", init);
	}

}
