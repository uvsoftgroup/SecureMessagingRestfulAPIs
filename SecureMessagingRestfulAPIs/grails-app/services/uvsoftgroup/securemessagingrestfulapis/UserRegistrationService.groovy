package uvsoftgroup.securemessagingrestfulapis

import grails.gorm.services.Service

@Service(UserRegistration)
interface UserRegistrationService {

    UserRegistration get(Serializable id)

    List<UserRegistration> list(Map args)

    Long count()

    void delete(Serializable id)

    UserRegistration save(UserRegistration userRegistration)

}