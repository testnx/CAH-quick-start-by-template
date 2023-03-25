package tech.testnx.cah.quickstart;

import tech.testnx.cah.common.config.CahConfigurable;


public enum ModulesConfig implements CahConfigurable {
    
    BASIC_EXAMPLES("basic-examples-config.properties"),
    ADVANCED_EXAMPLES("advanced-examples-config.properties");
    
    private String configFileName;

    private ModulesConfig(String configFileName) {
    	this.configFileName = configFileName;
    }

	@Override
	public String getConfigFileName() {
		return configFileName;
	}

}
