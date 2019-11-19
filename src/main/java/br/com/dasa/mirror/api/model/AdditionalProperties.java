package br.com.dasa.mirror.api.model;

public class AdditionalProperties {
	
	private String value;

    private String key;

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
    }

    public String getKey ()
    {
        return key;
    }

    public void setKey (String key)
    {
        this.key = key;
    }


    public AdditionalProperties() {
    }

    public AdditionalProperties(String value, String key) {
        this.value = value;
        this.key = key;
    }

    @Override
    public String toString()
    {
        return "AdditionalProperties [value = "+value+", key = "+key+"]";
    }
}
