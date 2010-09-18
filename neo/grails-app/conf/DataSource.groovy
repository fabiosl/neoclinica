dataSource {
	pooled = true
	driverClassName = "org.hsqldb.jdbcDriver"
	username = "sa"
	password = ""
}
hibernate {
	cache.use_second_level_cache=true
	cache.use_query_cache=true
	cache.provider_class='net.sf.ehcache.hibernate.EhCacheProvider'
}
// environment specific settings
environments {
	development {
		dataSource {
			dbCreate =  "update"           // "create"
			// or "update"   (after you run with create-drop )
			username = "root"
			password = "r00tpa55"
			url = "jdbc:mysql://localhost/neo"
		}
	}
	test {
		dataSource {
			dbCreate =  "update"           // "create"
			// or "update"   (after you run with create-drop )
			username = "root"
			password = "r00tpa55"
			url = "jdbc:mysql://localhost/neo"
		}
	}
	production {
		dataSource {
			dbCreate =  "update"           // "create"
			// or "update"   (after you run with create-drop )
			username = "root"
			password = "r00tpa55"
			url = "jdbc:mysql://localhost/neo"
		}
	}
}