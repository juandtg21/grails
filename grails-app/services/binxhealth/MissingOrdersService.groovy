package binxhealth

import grails.gorm.services.Service

@Service(MissingOrders)
interface MissingOrdersService {

    MissingOrders get(Serializable id)

    List<MissingOrders> list(Map args)

    Long count()

    void delete(Serializable id)

    MissingOrders save(MissingOrders missingOrders)

}