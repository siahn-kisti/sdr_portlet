package cn.bluejoe.elfinder.servlet;

import cn.bluejoe.elfinder.controller.ConnectorController;
import cn.bluejoe.elfinder.controller.executor.CommandExecutorFactory;
import cn.bluejoe.elfinder.controller.executor.DefaultCommandExecutorFactory;
import cn.bluejoe.elfinder.controller.executors.MissingCommandExecutor;
import cn.bluejoe.elfinder.impl.DefaultFsService;
import cn.bluejoe.elfinder.impl.DefaultFsServiceConfig;
import cn.bluejoe.elfinder.impl.FsSecurityCheckFilterMapping;
import cn.bluejoe.elfinder.impl.FsSecurityCheckForAll;
import cn.bluejoe.elfinder.impl.FsSecurityCheckerChain;
import cn.bluejoe.elfinder.impl.StaticFsServiceFactory;
import cn.bluejoe.elfinder.localfs.LocalFsVolume;
import cn.bluejoe.elfinder.service.FsItem;
import cn.bluejoe.elfinder.service.FsSecurityChecker;
import cn.bluejoe.elfinder.service.FsService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SdrConnectorServlet extends HttpServlet {

    ConnectorController _connectorController;

    protected CommandExecutorFactory createCommandExecutorFactory(
            ServletConfig config) {
        DefaultCommandExecutorFactory defaultCommandExecutorFactory = new DefaultCommandExecutorFactory();
        defaultCommandExecutorFactory.setClassNamePattern("cn.bluejoe.elfinder.controller.executors.%sCommandExecutor");
        defaultCommandExecutorFactory.setFallbackCommand(new MissingCommandExecutor());
        return defaultCommandExecutorFactory;
    }

    /**
     * create a connector controller
     *
     * @param config
     * @return
     */
    protected ConnectorController createConnectorController(ServletConfig config) {
        ConnectorController connectorController = new ConnectorController();

        connectorController.setCommandExecutorFactory(createCommandExecutorFactory(config));

        return connectorController;
    }

    protected DefaultFsService createFsService() {
        DefaultFsService fsService = new DefaultFsService();
        fsService.setSecurityChecker(new FsSecurityCheckForAll());

        DefaultFsServiceConfig serviceConfig = new DefaultFsServiceConfig();
        serviceConfig.setTmbWidth(80);

        fsService.setServiceConfig(serviceConfig);

        fsService.addVolume("A", createLocalFsVolume("My Files", new File("/tmp/a")));
        fsService.addVolume("B", createLocalFsVolume("Shared", new File("/tmp/b")));

        return fsService;
    }

    private LocalFsVolume createLocalFsVolume(String name, File rootDir) {
        LocalFsVolume localFsVolume = new LocalFsVolume();
        localFsVolume.setName(name);
        localFsVolume.setRootDir(rootDir);
        return localFsVolume;
    }

    protected DefaultFsService createSdrFsService(JSONArray volumes) throws ServletException, IOException {

        DefaultFsService fsService = new DefaultFsService();
        fsService.setSecurityChecker(new FsSecurityCheckForAll());

        DefaultFsServiceConfig serviceConfig = new DefaultFsServiceConfig();
        serviceConfig.setTmbWidth(80);

        fsService.setServiceConfig(serviceConfig);

        List<FsSecurityCheckFilterMapping> fsSecurityCheckFilterMappings = new ArrayList<FsSecurityCheckFilterMapping>();
        FsSecurityCheckerChain fsSecurityCheckerChain = new FsSecurityCheckerChain();

        for (int i = 0; i < volumes.size(); i++) {
            JSONObject object = (JSONObject) volumes.get(i);

            String datasetName = object.get("datasetName") == null ? (String) object.get("datasetId") : (String) object.get("datasetName");
            String datasetId = object.get("datasetId") == null ? "" : (String) object.get("datasetId");
            File datasetPath = new File((String) object.get("datasetPath"));
            final boolean datasetWriterble = object.get("datasetWriterble") == null ? false : Boolean.parseBoolean((String) object.get("datasetWriterble"));

            fsService.addVolume(datasetName, createLocalFsVolume(datasetName + "(" + datasetId + ")", datasetPath));

            FsSecurityCheckForAll fsSecurity = new FsSecurityCheckForAll();

            FsSecurityCheckFilterMapping fsSecurityCheckFilterMapping = new FsSecurityCheckFilterMapping();
            fsSecurityCheckFilterMapping.setPattern(datasetName + "_.*");
            fsSecurityCheckFilterMapping.setChecker(new FsSecurityChecker() {
                @Override
                public boolean isLocked(FsService fsService, FsItem fsi) throws IOException {
                    return false;
                }

                @Override
                public boolean isReadable(FsService fsService, FsItem fsi) throws IOException {
                    return true;
                }

                @Override
                public boolean isWritable(FsService fsService, FsItem fsi) throws IOException {
                    return datasetWriterble;
                }
            });
            fsSecurityCheckFilterMappings.add(fsSecurityCheckFilterMapping);
        }

        fsSecurityCheckerChain.setFilterMappings(fsSecurityCheckFilterMappings);
        fsService.setSecurityChecker(fsSecurityCheckerChain);

        return fsService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int init = req.getParameter("init") == null ? 0 : Integer.parseInt(req.getParameter("init"));

        JSONArray volumes = new JSONArray();
        if (init == 1) {

            String datasetParam = req.getParameter("datasetParam");
            String tmpPath = req.getParameter("tmpPath");

            JSONParser jsonParser = new JSONParser();
            try {
                volumes = (JSONArray) jsonParser.parse(datasetParam);
            } catch (Exception e) {
                e.printStackTrace();
            }

            StaticFsServiceFactory staticFsServiceFactory = new StaticFsServiceFactory();
            staticFsServiceFactory.setFsService(createSdrFsService(volumes));
            _connectorController.setFsServiceFactory(staticFsServiceFactory);
            
			_connectorController.setTempDirPath(tmpPath+".tmp");

        }
        _connectorController.connector(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int init = req.getParameter("init") == null ? 0 : Integer.parseInt(req.getParameter("init"));

        JSONArray volumes = new JSONArray();
        if (init == 1) {

            String datasetParam = req.getParameter("datasetParam");
            String tmpPath = req.getParameter("tmpPath");

            JSONParser jsonParser = new JSONParser();
            try {
                volumes = (JSONArray) jsonParser.parse(datasetParam);
            } catch (Exception e) {
                e.printStackTrace();
            }

            StaticFsServiceFactory staticFsServiceFactory = new StaticFsServiceFactory();
            staticFsServiceFactory.setFsService(createSdrFsService(volumes));
            _connectorController.setFsServiceFactory(staticFsServiceFactory);
            
			_connectorController.setTempDirPath(tmpPath+".tmp");

        }

        _connectorController.connector(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        _connectorController = createConnectorController(config);
    }
}
