package uvsoftgroup.securemessagingrestfulapis

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class UserRegistrationController {

    UserRegistrationService userRegistrationService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond userRegistrationService.list(params), model:[userRegistrationCount: userRegistrationService.count()]
    }

    def show(Long id) {
        respond userRegistrationService.get(id)
    }

    def save(UserRegistration userRegistration) {
        if (userRegistration == null) {
            render status: NOT_FOUND
            return
        }

        try {
            userRegistrationService.save(userRegistration)
        } catch (ValidationException e) {
            respond userRegistration.errors, view:'create'
            return
        }

        respond userRegistration, [status: CREATED, view:"show"]
    }

    def update(UserRegistration userRegistration) {
        if (userRegistration == null) {
            render status: NOT_FOUND
            return
        }

        try {
            userRegistrationService.save(userRegistration)
        } catch (ValidationException e) {
            respond userRegistration.errors, view:'edit'
            return
        }

        respond userRegistration, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        userRegistrationService.delete(id)

        render status: NO_CONTENT
    }


}
