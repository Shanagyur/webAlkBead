package hu.iit.uni.miskolc.RequestRegistry.PersistImpl.daoImpl.converter;

import hu.iit.uni.miskolc.RequestRegistry.Model.Details;
import hu.iit.uni.miskolc.RequestRegistry.PersistImpl.daoImpl.entity.DetailsEntity;

public class DetailsEntityConverter {

	public DetailsEntityConverter() {
	}

	public static Details convertDetailsEntityToModel(DetailsEntity detailsEntity) {
		Details details = new Details();
		
		details.setFirstName(detailsEntity.getFirstName());
		details.setLastName(detailsEntity.getLastName());
		details.setEmail(detailsEntity.getEmail());
		details.setSettlement(SettlementEntityConverter.convertSettlementEntityToModel(detailsEntity.getSettlement()));
		
		return details;
	}
}
