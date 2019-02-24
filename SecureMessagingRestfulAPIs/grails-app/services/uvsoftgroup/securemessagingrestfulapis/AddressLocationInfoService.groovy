package uvsoftgroup.securemessagingrestfulapis

import grails.gorm.services.Service

@Service(AddressLocationInfo)
interface AddressLocationInfoService {

    AddressLocationInfo get(Serializable id)

    List<AddressLocationInfo> list(Map args)

    Long count()

    void delete(Serializable id)

    AddressLocationInfo save(AddressLocationInfo addressLocationInfo)

}