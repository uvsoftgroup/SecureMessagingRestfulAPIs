package uvsoftgroup.securemessagingrestfulapis

import grails.gorm.services.Service

@Service(ReceiverInfo)
interface ReceiverInfoService {

    ReceiverInfo get(Serializable id)

    List<ReceiverInfo> list(Map args)

    Long count()

    void delete(Serializable id)

    ReceiverInfo save(ReceiverInfo receiverInfo)

}