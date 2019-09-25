package br.com.dasa.mirror.api.enumeration;


public enum CamelRoutesEnum {

    ROUTE_LOAD_PRODUTO_TRADUCAO("direct:data-provider-prod-traducao");

    private String routeName;

    CamelRoutesEnum(String routeName) {
        this.routeName = routeName;
    }

    public String getRoute() {
        return this.routeName;
    }
}
