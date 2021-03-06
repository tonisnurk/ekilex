package eki.ekilex.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;

import eki.common.constant.FreeformType;
import eki.common.constant.LifecycleEntity;
import eki.common.constant.TableName;
import eki.common.service.db.BasicDbService;
import eki.ekilex.constant.SystemConstant;
import eki.ekilex.service.XmlReader;

public abstract class AbstractLoaderCommons implements SystemConstant, TableName {

	@Autowired
	protected XmlReader xmlReader;

	@Autowired
	protected BasicDbService basicDbService;

	protected String toReadableFormat(long timeMillis) {
		long secondMillis = 1000;
		long minuteMillis = 60000;
		String timeLog;
		if (timeMillis < secondMillis) {
			timeLog = timeMillis + " millis";
		} else if (timeMillis < minuteMillis) {
			float timeSeconds = (float) timeMillis / (float) secondMillis;
			BigDecimal timeSecondsRound = new BigDecimal(timeSeconds);
			timeSecondsRound = timeSecondsRound.setScale(2, BigDecimal.ROUND_HALF_UP);
			timeLog = timeSecondsRound.toString() + " seconds";
		} else {
			float timeMinutes = (float) timeMillis / (float) minuteMillis;
			BigDecimal timeMinutesRound = new BigDecimal(timeMinutes);
			timeMinutesRound = timeMinutesRound.setScale(2, BigDecimal.ROUND_HALF_UP);
			timeLog = timeMinutesRound.toString() + " minutes";
		}
		return timeLog;
	}

	protected String getContent(InputStream resourceInputStream) throws Exception {
		String content = IOUtils.toString(resourceInputStream, UTF_8);
		resourceInputStream.close();
		return content;
	}

	protected List<String> readFileLines(String sourcePath) throws Exception {
		try (InputStream resourceInputStream = new FileInputStream(sourcePath)) {
			return IOUtils.readLines(resourceInputStream, UTF_8);
		}
	}

	protected List<String> getContentLines(InputStream resourceInputStream) throws Exception {
		List<String> contentLines = IOUtils.readLines(resourceInputStream, UTF_8);
		resourceInputStream.close();
		return contentLines;
	}

	protected LifecycleEntity translate(FreeformType freeformType) {
		LifecycleEntity lifecycleEntity;
		try {
			lifecycleEntity = LifecycleEntity.valueOf(freeformType.name());
		} catch (Exception e) {
			lifecycleEntity = LifecycleEntity.ATTRIBUTE_FREEFORM;
		}
		return lifecycleEntity;
	}
}
