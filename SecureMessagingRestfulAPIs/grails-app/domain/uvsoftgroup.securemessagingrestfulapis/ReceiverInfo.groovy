package uvsoftgroup.securemessagingrestfulapis

import grails.rest.Resource

@Resource(uri = '/receiverinfos')
class ReceiverInfo implements Serializable{
	  Long aesDeId,aesEnId
	  Long aesDeKeySize
	  String aesDeSoBase64String,aesDeSelectionMode,aesDeIvInitVector,aesDeSecretKey
	  String aesDeDeBase64String,aesDePlainString

	String toString() { "${id}"}

	static constraints = {
		aesDeId()
		aesEnId()
		aesDeKeySize()
		aesDeSoBase64String()
		aesDeSelectionMode()
		aesDeIvInitVector()
		aesDeSecretKey()
		aesDeDeBase64String()
		aesDePlainString()
	}

	static belongsTo =[userRegistrations:UserRegistration]

	static mapping = {
		table 'receiverinfo'
		version true
		columns {
			id generator: 'uvsoftgroup.securemessagingrestfulapis.utility.ReceiverInfoIdGenerator'
		}
	  }

}
