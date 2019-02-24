package uvsoftgroup.securemessagingrestfulapis

import grails.gorm.services.Service

@Service(SenderInfo)
interface SenderInfoService {

    SenderInfo get(Serializable id)

    List<SenderInfo> list(Map args)

    Long count()

    void delete(Serializable id)

    SenderInfo save(SenderInfo senderInfo)

}