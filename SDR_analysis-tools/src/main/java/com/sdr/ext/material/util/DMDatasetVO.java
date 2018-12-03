/**
 * @FileName : DMDatasetVO.java
 * @Project : SDR_base-portlet
 * @Date : 2017. 8. 1.
 * @작성자 : devsky
 * @변경이력 :
 * @프로그램 설명 : Dataset의 서술형 메타데이터 Value object로 주로 색인된 dataset의 값을 담을 때 사용하며
 * 각자 필요한 키는 추가하여 사용하고, Data type를 변경할 때는 다른 곳에도 영향을 끼칠 수 있으니 협의하여 변경합니다.
 */
package com.sdr.ext.material.util;

import java.lang.reflect.Type;
import java.util.*;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.liferay.portal.kernel.search.Document;

public class DMDatasetVO {
	private long materialId = 0;
	private String dataType = null;
	private String location = null;
	private String reducedFormula = null;
	private String fullFormula = null;
	private String spaceGroup = null;
	private Double bandGap = null;
	private Double density = null;
	private Integer nsites = null;
	private Double volume = null;
	private Double finalEnergyPerAtom = null;
	private Double finalEnergy = null;
	private Double formationenergy = null;
	private Map<String, Object> unitCellFormula = new HashMap<String, Object>();

	public void setAll(Document doc) {
		this.setMaterialId(Long.parseLong(doc.get("datasetId")));
		this.setDataType(doc.get("DataType"));
		this.setLocation(doc.get("location"));
		this.setReducedFormula(doc.get("reducedformula"));
		this.setFullFormula(doc.get("fullformula"));
		this.setSpaceGroup(doc.get("spacegroupsymbol"));
		if (StringUtils.isNotEmpty(doc.get("bandgap"))) {
			this.setBandGap(Double.parseDouble(doc.get("bandgap")));
		}
		if (StringUtils.isNotEmpty(doc.get("density"))) {
			this.setDensity(Double.parseDouble(doc.get("density")));
		}
		if (StringUtils.isNotEmpty(doc.get("nsites"))) {
			this.setNsites(Integer.parseInt(doc.get("nsites")));
		}
		if (StringUtils.isNotEmpty(doc.get("volume"))) {
			this.setVolume(Double.parseDouble(doc.get("volume")));
		}
		if (StringUtils.isNotEmpty(doc.get("finalenergyperatom"))) {
			this.setFinalEnergyPerAtom(Double.parseDouble(doc.get("finalenergyperatom")));
		}
		if (StringUtils.isNotEmpty(doc.get("finalenergy"))) {
			this.setFinalEnergy(Double.parseDouble(doc.get("finalenergy")));
		}
		if (StringUtils.isNotEmpty(doc.get("formationenergy"))) {
			this.setFormationenergy(Double.parseDouble(doc.get("formationenergy")));
		}
		if (StringUtils.isNotEmpty(doc.get("unitcellformula"))) {
			this.setUnitCellFormula(doc.get("unitcellformula"));
		}
}

	public long getMaterialId() {
		return materialId;
	}

	public void setMaterialId(long materialId) {
		this.materialId = materialId;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFullFormula() { return fullFormula; }

	public void setFullFormula(String fullFormula) {
		this.fullFormula = fullFormula;
	}

	public String getSpaceGroup() {
		return spaceGroup;
	}

	public void setSpaceGroup(String spaceGroup) {
		this.spaceGroup = spaceGroup;
	}

	public Double getBandGap() {
		return bandGap;
	}

	public void setBandGap(Double bandGap) {
		this.bandGap = bandGap;
	}

	public Double getDensity() {
		return density;
	}

	public void setDensity(Double density) {
		this.density = density;
	}

	public Integer getNsites() {
		return nsites;
	}

	public void setNsites(Integer nsites) {
		this.nsites = nsites;
	}

	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public Double getFinalEnergyPerAtom() {
		return finalEnergyPerAtom;
	}

	public void setFinalEnergyPerAtom(Double finalEnergyPerAtom) {
		this.finalEnergyPerAtom = finalEnergyPerAtom;
	}

	public Double getFinalEnergy() {
		return finalEnergy;
	}

	public void setFinalEnergy(Double finalEnergy) {
		this.finalEnergy = finalEnergy;
	}

	public Double getFormationenergy() {
		return formationenergy;
	}

	public void setFormationenergy(Double formationenergy) {
		this.formationenergy = formationenergy;
	}

	public String getReducedFormula() {
		return reducedFormula;
	}

	public void setReducedFormula(String reducedFormula) {
		this.reducedFormula = reducedFormula;
	}

	public Map<String, Object> getUnitCellFormula() {
		return unitCellFormula;
	}

	public void setUnitCellFormula(String unitCellFormula) {
		String jsonData = "{ unitCellFormula : " + unitCellFormula + "}";
		JsonParser jsonParser = new JsonParser();
		JsonObject json = (JsonObject) jsonParser.parse(jsonData);
		Gson gson = new Gson();
		Type mapType = new TypeToken<Map<String, Map<String, Object>>>() {}.getType();
		Map<String, Map<String, Object>> map = gson.fromJson(json, mapType);
		Map<String, Object> mapUnitCellFormula = map.get("unitCellFormula");
		this.unitCellFormula = mapUnitCellFormula;
	}
}