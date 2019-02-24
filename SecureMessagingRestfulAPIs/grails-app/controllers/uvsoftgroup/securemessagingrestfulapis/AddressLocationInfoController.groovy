package uvsoftgroup.securemessagingrestfulapis

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AddressLocationInfoController {

    AddressLocationInfoService addressLocationInfoService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond addressLocationInfoService.list(params), model:[addressLocationInfoCount: addressLocationInfoService.count()]
    }

    def show(Long id) {
        respond addressLocationInfoService.get(id)
    }

    def save(AddressLocationInfo addressLocationInfo) {
        if (addressLocationInfo == null) {
            render status: NOT_FOUND
            return
        }

        try {
            addressLocationInfoService.save(addressLocationInfo)
        } catch (ValidationException e) {
            respond addressLocationInfo.errors, view:'create'
            return
        }

        respond addressLocationInfo, [status: CREATED, view:"show"]
    }

    def update(AddressLocationInfo addressLocationInfo) {
        if (addressLocationInfo == null) {
            render status: NOT_FOUND
            return
        }

        try {
            addressLocationInfoService.save(addressLocationInfo)
        } catch (ValidationException e) {
            respond addressLocationInfo.errors, view:'edit'
            return
        }

        respond addressLocationInfo, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        addressLocationInfoService.delete(id)

        render status: NO_CONTENT
    }
}
