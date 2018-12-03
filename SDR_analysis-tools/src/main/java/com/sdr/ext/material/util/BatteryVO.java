/**
 * @FileName : BatteryVO.java
 * @Project : SDR_base-portlet
 * @Date : 2017. 11. 27.
 * @작성자 : devsky
 * @변경이력 :
 * @프로그램 설명 : Dataset의 서술형 메타데이터 Value object로 색인된 Battery 타입의 dataset의 값을 담을 때 사용.
 */
package com.sdr.ext.material.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.liferay.portal.kernel.search.Document;

public class BatteryVO {
    private long materialId = 0;
    private Double volumetricCapacity = null;
    private String[] elements = null;
    private Double gravimetricCapacity = null;
    private String material = null;
    private Double volumnChange = null;
    private String workingIon = null;
    private Double voltage = null;
    private Double specificEnergy = null;
    private Double energyDensity = null;

    public void setAll(Document doc) {
        this.setMaterialId(Long.parseLong(doc.get("datasetId")));
        this.setVolumetricCapacity(Double.parseDouble(doc.get("volumetric_capacity")));
        this.setElements(doc.get("elements").split(","));
        this.setGravimetricCapacity(Double.parseDouble(doc.get("gravimetric_capacity")));
        this.setMaterial(doc.get("material"));
        this.setVolumnChange(Double.parseDouble(doc.get("volumn_change")));
        this.setWorkingIon(doc.get("working_ion"));
        this.setVoltage(Double.parseDouble(doc.get("voltage")));
        this.setSpecificEnergy(Double.parseDouble(doc.get("specific_energy")));
        this.setEnergyDensity(Double.parseDouble(doc.get("energy_density")));
    }


    public long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(long materialId) {
        this.materialId = materialId;
    }

    public Double getVolumetricCapacity() {
        return volumetricCapacity;
    }

    public void setVolumetricCapacity(Double volumetricCapacity) {
        this.volumetricCapacity = volumetricCapacity;
    }

    public String[] getElements() {
        return elements;
    }

    public void setElements(String[] elements) {
        this.elements = elements;
    }

    public Double getGravimetricCapacity() {
        return gravimetricCapacity;
    }

    public void setGravimetricCapacity(Double gravimetricCapacity) {
        this.gravimetricCapacity = gravimetricCapacity;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Double getVolumnChange() {
        return volumnChange;
    }

    public void setVolumnChange(Double volumeChange) {
        this.volumnChange = volumnChange;
    }

    public String getWorkingIon() {
        return workingIon;
    }

    public void setWorkingIon(String workingIon) {
        this.workingIon = workingIon;
    }

    public Double getVoltage() {
        return voltage;
    }

    public void setVoltage(Double voltage) {
        this.voltage = voltage;
    }

    public Double getSpecificEnergy() {
        return specificEnergy;
    }

    public void setSpecificEnergy(Double specificEnergy) {
        this.specificEnergy = specificEnergy;
    }

    public Double getEnergyDensity() {
        return energyDensity;
    }

    public void setEnergyDensity(Double energyDensity) {
        this.energyDensity = energyDensity;
    }

}