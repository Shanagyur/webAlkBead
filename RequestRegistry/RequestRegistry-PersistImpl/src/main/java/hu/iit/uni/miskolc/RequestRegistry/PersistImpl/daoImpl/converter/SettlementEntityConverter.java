package hu.iit.uni.miskolc.RequestRegistry.PersistImpl.daoImpl.converter;

import hu.iit.uni.miskolc.RequestRegistry.Model.Settlement;
import hu.iit.uni.miskolc.RequestRegistry.PersistImpl.daoImpl.entity.SettlementEntity;

public class SettlementEntityConverter {

	private SettlementEntityConverter() {
	}

	public static Settlement convertSettlementEntityToModel(SettlementEntity settlementEntity) {
		Settlement settlement = new Settlement();
		
		settlement.setId(settlementEntity.getId());
		settlement.setZip(settlementEntity.getZip());
		settlement.setCity(settlementEntity.getCity());
		settlement.setStreet(settlementEntity.getStreet());
		settlement.setStreetNumber(settlementEntity.getStreetNumber());
		
		return settlement;
	}
}
