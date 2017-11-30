package eki.ekilex.runner;

import java.io.InputStream;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DbReInitialiserRunner extends AbstractLoaderRunner {

	private static Logger logger = LoggerFactory.getLogger(DbReInitialiserRunner.class);

	@Override
	void initialise() throws Exception {

	}

	@Transactional
	public void execute() throws Exception {

		logger.debug("Re-initialising database...");

		final String scriptFilePath1 = "sql/create_tables.sql";
		final String scriptFilePath2 = "sql/classifier-manual.sql";
		final String scriptFilePath3 = "sql/classifier-main.sql";
		final String scriptFilePath4 = "sql/classifier-domain.sql";
		final String[] scriptFilePaths = new String[] {
				scriptFilePath1, scriptFilePath2, scriptFilePath3, scriptFilePath4
		};

		long t1, t2;
		t1 = System.currentTimeMillis();

		ClassLoader classLoader = this.getClass().getClassLoader();
		InputStream resourceFileInputStream;
		String sqlScript;

		for (String scriptFilePath : scriptFilePaths) {
			logger.debug("{}...", scriptFilePath);
			resourceFileInputStream = classLoader.getResourceAsStream(scriptFilePath);
			sqlScript = getContent(resourceFileInputStream);
			basicDbService.executeScript(sqlScript);
		}

		t2 = System.currentTimeMillis();
		logger.debug("Done in {} ms", (t2 - t1));
	}
}
