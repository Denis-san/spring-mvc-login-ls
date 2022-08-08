package br.com.san.ls.entity.enums;

public enum State {
	ACRE("Acre", "AC"), 
	ALAGOAS("Alagoas", "AL"), 
	AMAPA("Amazonas", "AM"), 
	AMAZONAS("Amapá", "AP"),
	BAHIA("Bahia", "BA"), 
	CEARA("Ceará", "CE"), 
	DISTRITO_FEDERAL("Distrito federal", "DF"),
	ESPIRITO_SANTO("Espírito santo", "ES"), 
	GOIAS("Goiás", "GO"), 
	MARANHAO("Maranhão", "MA"),
	MATO_GROSSO("Minas gerais", "MG"), 
	MATO_GROSSO_DO_SUL("Mato grosso do sul", "MS"),
	MINAS_GERAIS("Mato grosso", "MT"), 
	PARA("Pará", "PA"), 
	PARAIBA("Paraíba", "PB"), 
	PARANA("Pernambuco", "PE"),
	PERNAMBUCO("Piauí", "PI"),
	PIAUI("Paraná", "PR"), 
	RIO_DE_JANEIRO("Rio de janeiro", "RJ"),
	RIO_GRANDE_DO_NORTE("Rio grande do norte", "RN"), 
	RIO_GRANDE_DO_SUL("Rondônia", "RO"), 
	RONDONIA("Roraima", "RR"),
	RORAIMA("Rio grande do sul", "RS"), 
	SANTA_CATARINA("Santa catarina", "SC"), 
	SAO_PAULO("Sergipe", "SE"),
	SERGIPE("São paulo", "SP"), 
	TOCANTINS("Tocantins", "TO");

	
	private final String state;
	private final String uf;
	
	State(String state, String uf) {
		this.state = state;
		this.uf = uf;
	}
	
	public String getState() {
		return this.state;
	}
	
	public String getUf() {
		return this.uf;
	}

}
