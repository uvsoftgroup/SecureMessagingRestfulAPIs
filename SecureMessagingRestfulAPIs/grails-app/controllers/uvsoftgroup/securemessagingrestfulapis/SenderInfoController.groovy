package uvsoftgroup.securemessagingrestfulapis

import grails.validation.ValidationException

import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec
import uvsoftgroup.securemessagingrestfulapis.SenderInfo

import static org.springframework.http.HttpStatus.*

class SenderInfoController {

    SenderInfoService senderInfoService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond senderInfoService.list(params), model:[senderInfoCount: senderInfoService.count()]
    }

    def show(Long id) {
        respond senderInfoService.get(id)
    }

    def save(SenderInfo senderInfo) {
        if (senderInfo == null) {
            render status: NOT_FOUND
            return
        }

        try {
            addSenderInfoGeneration(senderInfo)
            senderInfoService.save(senderInfo)
        } catch (ValidationException e) {
            respond senderInfo.errors, view:'create'
            return
        }

        respond senderInfo, [status: CREATED, view:"show"]
    }

    def update(SenderInfo senderInfo) {
        if (senderInfo == null) {
            render status: NOT_FOUND
            return
        }

        try {
            senderInfoService.save(senderInfo)
        } catch (ValidationException e) {
            respond senderInfo.errors, view:'edit'
            return
        }

        respond senderInfo, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        senderInfoService.delete(id)

        render status: NO_CONTENT
    }

    def addSenderInfoGeneration(SenderInfo senderInfo) {

        try {
            Cipher cipher = Cipher.getInstance(senderInfo.getAesEnSelectionMode()!=null? senderInfo.getAesEnSelectionMode():"AES/CBC/PKCS5PADDING")
            IvParameterSpec iv = new IvParameterSpec(senderInfo.getAesEnIvInitVector()!=null? senderInfo.getAesEnIvInitVector().getBytes("UTF-8"):"7a11111111111118".getBytes("UTF-8"))
            SecretKeySpec secretKeySpec = new SecretKeySpec(senderInfo.getAesEnSecretKey().getBytes("UTF-8"), "AES")

            cipher.init(Cipher.ENCRYPT_MODE,secretKeySpec, iv)

            byte[] encrypted = cipher.doFinal(senderInfo.getAesEnSourceString().getBytes())
            String   encryptedStringValue = new String(Base64.getEncoder().encode(encrypted))
            println(encryptedStringValue)

            senderInfo.setAesEnSelectionMode(senderInfo.getAesEnSelectionMode()!=null? senderInfo.getAesEnSelectionMode():"AES/CBC/PKCS5PADDING")
            senderInfo.setAesEnIvInitVector(senderInfo.getAesEnIvInitVector()!=null? senderInfo.getAesEnIvInitVector():"7a11111111111118")
            senderInfo.setAesEnSecretKey(senderInfo.getAesEnSecretKey())
            senderInfo.setAesEnSourceString(senderInfo.getAesEnSourceString())
            senderInfo.setAesEnBase64String(encryptedStringValue)


        } catch (Exception ex) {
            ex.printStackTrace()
        }
        return senderInfo
    }

}
