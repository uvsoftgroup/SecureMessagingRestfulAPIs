package uvsoftgroup.securemessagingrestfulapis

import grails.validation.ValidationException
import uvsoftgroup.securemessagingrestfulapis.ReceiverInfo
import uvsoftgroup.securemessagingrestfulapis.SenderInfo
import uvsoftgroup.securemessagingrestfulapis.SenderInfoService

import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

import static org.springframework.http.HttpStatus.*

class ReceiverInfoController {

    SenderInfoService senderInfoService
    ReceiverInfoService receiverInfoService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 50, 100)
        respond receiverInfoService.list(params), model:[receiverInfoCount: receiverInfoService.count()]
    }

    def show(Long id) {
        respond receiverInfoService.get(id)
    }

    def save(ReceiverInfo receiverInfo) {
        if (receiverInfo == null) {
            render status: NOT_FOUND
            return
        }

        try {
            addReceiverInfoGeneration(receiverInfo)
            receiverInfoService.save(receiverInfo)
        } catch (ValidationException e) {
            respond receiverInfo.errors, view:'create'
            return
        }

        respond receiverInfo, [status: CREATED, view:"show"]
    }

    def update(ReceiverInfo receiverInfo) {
        if (receiverInfo == null) {
            render status: NOT_FOUND
            return
        }

        try {
            receiverInfoService.save(receiverInfo)
        } catch (ValidationException e) {
            respond receiverInfo.errors, view:'edit'
            return
        }

        respond receiverInfo, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        receiverInfoService.delete(id)

        render status: NO_CONTENT
    }

    /**
     * to get SenderInfo by calling ReceiverInfoService's get methods
     * @param id
     * @return
     */
    def getSenderInfo(Long id) {
        SenderInfo senderInfo=senderInfoService.get(id)
        senderInfo
    }

    /**
     * call SenderInfo with sender message id, SecretKey and encrypted message
     * @param receiverInfo
     * @return
     */
    def addReceiverInfoGeneration(ReceiverInfo receiverInfo) {
        // call senderInfo with sender message id
        SenderInfo receiverInfoFromSender=getSenderInfo(receiverInfo.getAesEnId())
        try {
            /* Checks with sender message id, SecretKey and encrypted message
               If all secrete information are ok from the input of receiver side
             */
            if(receiverInfo.getAesEnId().equals(receiverInfoFromSender.id)
                    && receiverInfo.getAesDeSoBase64String().equalsIgnoreCase(receiverInfoFromSender.aesEnBase64String)
                    && receiverInfo.getAesDeSecretKey().equalsIgnoreCase(receiverInfoFromSender.aesEnSecretKey)) {

                Cipher cipher = Cipher.getInstance(receiverInfo.getAesDeSelectionMode()!=null? receiverInfo.getAesDeSelectionMode():"AES/CBC/PKCS5PADDING")
                IvParameterSpec iv = new IvParameterSpec(receiverInfo.getAesDeIvInitVector()!=null? receiverInfo.getAesDeIvInitVector().getBytes("UTF-8"):"7a11111111111118".getBytes("UTF-8"))
                SecretKeySpec skeySpec= new SecretKeySpec(receiverInfo.getAesDeSecretKey().getBytes("UTF-8"), "AES")

                cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv)
                // decode the encrypted message from the sender
                byte[] original = cipher.doFinal(Base64.getDecoder().decode(receiverInfo.getAesDeSoBase64String()))
                String decryptedStringValue=new String(original)

                /* set into the ReceiverInfo into the receiverinfo database table
                 and get the sender plain text message and then read the message(s) from the ReceiverInfo list
                 */
                receiverInfo.setAesDeDeBase64String(decryptedStringValue)
                receiverInfo.setAesDeSelectionMode(receiverInfoFromSender.aesEnSelectionMode)
                receiverInfo.setAesDeIvInitVector(receiverInfoFromSender.aesEnIvInitVector)
                receiverInfo.setAesDeSecretKey(receiverInfo.getAesDeSecretKey())
            }

            else {
                // set into the ReceiverInfo into the receiverinfo database table
                receiverInfo.setAesDeSelectionMode(receiverInfo.getAesDeSelectionMode()!=null?receiverInfo.getAesDeSelectionMode():"AES/CBC/PKCS5PADDING");
                if(receiverInfo.getAesDeIvInitVector()!=null && receiverInfo.getAesDeIvInitVector().length()==16){
                    receiverInfo.setAesDeIvInitVector(receiverInfo.getAesDeIvInitVector())
                }
                else{
                    receiverInfo.setAesDeIvInitVector("7a11111111111118")
                }
                if(receiverInfo.getAesDeSecretKey()!=null && receiverInfo.getAesDeSecretKey().length()==16){
                    receiverInfo.setAesDeSecretKey(receiverInfo.getAesDeSecretKey())
                }
                else{
                    receiverInfo.setAesDeSecretKey(receiverInfo.getAesDeSecretKey())
                }
                // get the sender text message and set into the receiver
                receiverInfo.setAesDeDeBase64String(receiverInfo.getAesDeSoBase64String())
            }

        } catch (Exception ex) {
            ex.printStackTrace()
        }
        return receiverInfo
    }
}
