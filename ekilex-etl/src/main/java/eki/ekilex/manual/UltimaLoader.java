package eki.ekilex.manual;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eki.ekilex.data.transform.Guid;
import eki.ekilex.runner.CollocLoaderRunner;
import eki.ekilex.runner.DbReInitialiserRunner;
import eki.ekilex.runner.EstermLoaderRunner;
import eki.ekilex.runner.EstermSourceLoaderRunner;
import eki.ekilex.runner.PsvLoaderRunner;
import eki.ekilex.runner.Qq2LoaderRunner;
import eki.ekilex.runner.Ss1LoaderRunner;
import eki.ekilex.runner.TermekiRunner;
import eki.ekilex.service.MabService;

public class UltimaLoader extends AbstractLoader {

	private static Logger logger = LoggerFactory.getLogger(UltimaLoader.class);

	public static void main(String[] args) {
		new UltimaLoader().execute();
	}

	@Override
	void execute() {

		List<String> successfullyLoadedDatasets = new ArrayList<>();

		try {
			initWithTermeki();

			DbReInitialiserRunner initRunner = getComponent(DbReInitialiserRunner.class);
			MabService mabService = getComponent(MabService.class);
			Ss1LoaderRunner ss1Runner = getComponent(Ss1LoaderRunner.class);
			Qq2LoaderRunner qq2Runner = getComponent(Qq2LoaderRunner.class);
			EstermSourceLoaderRunner estSrcRunner = getComponent(EstermSourceLoaderRunner.class);
			EstermLoaderRunner estRunner = getComponent(EstermLoaderRunner.class);
			TermekiRunner termekiRunner = getComponent(TermekiRunner.class);
			PsvLoaderRunner psvRunner = getComponent(PsvLoaderRunner.class);
			CollocLoaderRunner kolRunner = getComponent(CollocLoaderRunner.class);

			String dataFilePath, dataset;
			Map<String, List<Guid>> ssGuidMap;

			boolean doReports = doReports();

			logger.info("Starting to clear database and load all datasets specified in ultima-loader.properties file");

			// db init
			initRunner.execute();

			// mab
			dataFilePath = getConfProperty("mab.data.file");
			if (StringUtils.isNotBlank(dataFilePath)) {
				mabService.loadParadigms(dataFilePath, doReports);
				successfullyLoadedDatasets.add("mab");
			}

			// ss1
			dataFilePath = getConfProperty("ss1.data.file");
			if (StringUtils.isNotBlank(dataFilePath)) {
				ss1Runner.execute(dataFilePath, doReports);
				successfullyLoadedDatasets.add("ss1");
			}

			// qq2
			dataFilePath = getConfProperty("qq2.data.file");
			if (StringUtils.isNotBlank(dataFilePath)) {
				dataset = qq2Runner.getDataset();
				ssGuidMap = getSsGuidMapFor(dataset);
				qq2Runner.execute(dataFilePath, ssGuidMap, doReports);
				successfullyLoadedDatasets.add(dataset);
			}

			// psv
			dataFilePath = getConfProperty("psv.data.file");
			if (StringUtils.isNotBlank(dataFilePath)) {
				dataset = qq2Runner.getDataset();
				ssGuidMap = getSsGuidMapFor(dataset);
				psvRunner.execute(dataFilePath, ssGuidMap, doReports);
				successfullyLoadedDatasets.add("psv");
			}

			// kol
			dataFilePath = getConfProperty("kol.data.file");
			if (StringUtils.isNotBlank(dataFilePath)) {
				dataset = kolRunner.getDataset();
				ssGuidMap = getSsGuidMapFor(dataset);
				kolRunner.execute(dataFilePath, ssGuidMap, doReports);
				successfullyLoadedDatasets.add("kol");
			}

			// est src + est
			dataFilePath = getConfProperty("est.data.file");
			if (StringUtils.isNotBlank(dataFilePath)) {
				estSrcRunner.execute(dataFilePath, doReports);
				successfullyLoadedDatasets.add("est src");
				estRunner.execute(dataFilePath, doReports);
				successfullyLoadedDatasets.add("est");
			}

			// termeki
			dataFilePath = getConfProperty("termeki.data.file");
			if (StringUtils.isNotBlank(dataFilePath)) {
				termekiRunner.batchLoad(dataFilePath);
				successfullyLoadedDatasets.add("termeki");
			}

			logger.info("----DONE LOADING DATASETS!!----");
		} catch (Exception e) {
			logger.error("Unexpected behaviour of the system", e);
			logger.info("Successfully loaded datasets: {}", successfullyLoadedDatasets);
		} finally {
			shutdown();
		}
	}

}
