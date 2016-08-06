package rs.tijanap.gym.testModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tea implements IHotDrink {
	static Logger logger = LoggerFactory.getLogger(Tea.class);

	@Override
	public void prepareHotDrink() {
		logger.info(" |INFO| Dear Customer we are preparing the TEA.");

	}

}
