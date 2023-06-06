package com.ck.scmproject.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "shipments")
public class NewShipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    
    @ManyToOne
    private Signup user;

    @NotNull
    private int shipmentNumber;

    @NotNull
    private String routeDetails;
    
    @NotNull
    private String device;
    
    @NotNull
    private int pONumber;
    
    @NotNull
    private int nDCNumber;
    
    @NotNull
    private int serialNumberOfGoods;
    
    @NotNull
    private int containerNumber;
    
    @NotNull
    private String goods;
    private String deliveryDate;
    private int deliveryNumber;
    private int batchId;
    private String shipmentDescription;


    public NewShipment() {
        super();
    }

    // Getters & Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getShipmentNumber() {
        return shipmentNumber;
    }

    public void setShipmentNumber(int shipmentNumber) {
        this.shipmentNumber = shipmentNumber;
    }

    public String getRouteDetails() {
        return routeDetails;
    }

    public void setRouteDetails(String routeDetails) {
        this.routeDetails = routeDetails;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public int getpONumber() {
		return pONumber;
	}

	public void setpONumber(int pONumber) {
		this.pONumber = pONumber;
	}

	public int getnDCNumber() {
		return nDCNumber;
	}

	public void setnDCNumber(int nDCNumber) {
		this.nDCNumber = nDCNumber;
	}

	public int getSerialNumberOfGoods() {
        return serialNumberOfGoods;
    }

    public void setSerialNumberOfGoods(int serialNumberOfGoods) {
        this.serialNumberOfGoods = serialNumberOfGoods;
    }

    public int getContainerNumber() {
        return containerNumber;
    }

    public void setContainerNumber(int containerNumber) {
        this.containerNumber = containerNumber;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getDeliveryNumber() {
        return deliveryNumber;
    }

    public void setDeliveryNumber(int deliveryNumber) {
        this.deliveryNumber = deliveryNumber;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public String getShipmentDescription() {
        return shipmentDescription;
    }

    public void setShipmentDescription(String shipmentDescription) {
        this.shipmentDescription = shipmentDescription;
    }

}
