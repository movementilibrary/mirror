package br.com.dasa.mirror.api.model;

public class UnitRealization {

    private Integer id;
    private String regionName;
    private String name;
    private String address;


    public UnitRealization() {
    }

    public UnitRealization(Integer id, String regionName, String name, String address) {
        this.id = id;
        this.regionName = regionName;
        this.name = name;
        this.address = address;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
