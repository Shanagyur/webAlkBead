package hu.iit.uni.miskolc.RequestRegistry.PersistImpl.daoImpl.converter;

import hu.iit.uni.miskolc.RequestRegistry.Model.Details;
import hu.iit.uni.miskolc.RequestRegistry.PersistImpl.daoImpl.entity.DetailsEntity;

public class DetailsEntityConverter {

	private DetailsEntityConverter() {
	}

	public static Details convertDetailsEntityToModel(DetailsEntity detailsEntity) {
		Details details = new Details();
		
		details.setFirstName(detailsEntity.getFirstName());
		details.setLastName(detailsEntity.getLastName());
		details.setEmail(detailsEntity.getEmail());
		details.setSettlement(SettlementEntityConverter.convertSettlementEntityToModel(detailsEntity.getSettlement()));
		
		return details;
	}
	
	public static DetailsEntity convertDetailsToEntity(Details details) {
		DetailsEntity detailsEntity = new DetailsEntity();

		detailsEntity.setFirstName(details.getFirstName());
		detailsEntity.setLastName(details.getLastName());
		detailsEntity.setEmail(details.getEmail());
		detailsEntity.setSettlement(SettlementEntityConverter.convertSettlementToEntity(details.getSettlement()));
		
		return detailsEntity;
	}
}
