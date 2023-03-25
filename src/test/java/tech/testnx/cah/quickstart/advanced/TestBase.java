package tech.testnx.cah.quickstart.advanced;

import tech.testnx.cah.AbstractTest;
import tech.testnx.cah.quickstart.ModulesConfig;

/**
 * @author Yun
 *
 */
public abstract class TestBase extends AbstractTest  {

	@Override
	public String getModuleName() {
		return ModulesConfig.ADVANCED_EXAMPLES.getParameter("module_name");
	}

}
