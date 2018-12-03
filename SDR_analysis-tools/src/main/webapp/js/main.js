var common;

common = new Analysis();
common.initEvents();

AUI().ready(function(A) {
});

Liferay.Portlet.ready(
	function(portletId, node) {
		var portletName = portletId.split("_")[0];

		var mh, me, ct, pd, rc, vc, mp, bp, mo, np;

		if (portletName == "materialshome") {
			mh = new MaterialsHome(common);
			mh.initEvents();			
		} else if (portletName == "materialsexplorer") {
			me = new MaterialsExplorer(common);
			me.initEvents();
		} else if (portletName == "crystaltoolkit") {
			ct = new CrystalToolkit(common);
			ct.initEvents();
		} else if (portletName == "phasediagram") {
			pd = new PhaseDiagram(common);
			pd.initEvents();
        } else if (portletName == "reactioncalculator") {
            rc = new ReactionCalculator(common);
            rc.initEvents();
        } else if (portletName == "visualizationchart") {
			vc = new VisualizationChart(common);
			vc.initEvents();			
		} else if (portletName == "mlpredictor") {
			mp = new MLPredictor(common);
			mp.initEvents();
		} else if (portletName == "batteryexplorer") {
			bp = new BatteryExplorer(common);
			bp.initEvents();
		} else if (portletName == "monitoringportlet") {
            mo = new Monitoring(common);
            mo.initEvents();
        } else if (portletName == "nanoporousexplorer") {
            np = new NanoporousExplorer(common);
            np.initEvents();
		} else if (portletName == "nanoporousanalysis") {
			np = new NanoporousAnalysis(common);
			np.initEvents();
		}
	}
);

Liferay.on('allPortletsReady', function() {	
});