package binxhealth

import grails.gorm.services.Service

@Service(PartnerStatesAvailable)
interface PartnerStatesAvailableService {

    PartnerStatesAvailable get(Serializable id)

    List<PartnerStatesAvailable> list(Map args)

    Long count()

    void delete(Serializable id)

    PartnerStatesAvailable save(PartnerStatesAvailable partnerStatesAvailable)

}