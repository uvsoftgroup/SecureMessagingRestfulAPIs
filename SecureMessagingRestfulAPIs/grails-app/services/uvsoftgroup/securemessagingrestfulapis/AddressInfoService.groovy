package uvsoftgroup.securemessagingrestfulapis

import grails.gorm.services.Service

@Service(AddressInfo)
interface AddressInfoService {

    AddressInfo get(Serializable id)

    List<AddressInfo> list(Map args)

    Long count()

    void delete(Serializable id)

    AddressInfo save(AddressInfo addressInfo)

}