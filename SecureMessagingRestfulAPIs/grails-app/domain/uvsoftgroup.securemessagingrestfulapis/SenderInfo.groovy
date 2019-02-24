package uvsoftgroup.securemessagingrestfulapis

import grails.rest.Resource

@Resource(uri = '/senderinfos')
class SenderInfo implements Serializable{
  Long aesEnId
  Long aesEnKeySize
  String aesEnSourceString,aesEnSelectionMode,aesEnIvInitVector,aesEnSecretKey,aesEnBase64String

  String toString(){"${id}"}

  static constraints = {
    aesEnId()
    aesEnKeySize()
    aesEnSourceString()
    aesEnSelectionMode()
    aesEnIvInitVector()
    aesEnSecretKey()
    aesEnBase64String()

  }
  static belongsTo =[userRegistrations:UserRegistration]

  static mapping ={
    table 'senderinfo'
    version true
    columns {
    id generator: 'uvsoftgroup.securemessagingrestfulapis.utility.SenderInfoIdGenerator'
   }
  }

  Long getAesEnId() {
    return aesEnId
  }

  void setAesEnId(Long aesEnId) {
    this.aesEnId = aesEnId
  }

  Long getAesEnKeySize() {
    return aesEnKeySize
  }

  void setAesEnKeySize(Long aesEnKeySize) {
    this.aesEnKeySize = aesEnKeySize
  }

  String getAesEnSourceString() {
    return aesEnSourceString
  }

  void setAesEnSourceString(String aesEnSourceString) {
    this.aesEnSourceString = aesEnSourceString
  }

  String getAesEnSelectionMode() {
    return aesEnSelectionMode
  }

  void setAesEnSelectionMode(String aesEnSelectionMode) {
    this.aesEnSelectionMode = aesEnSelectionMode
  }

  String getAesEnIvInitVector() {
    return aesEnIvInitVector
  }

  void setAesEnIvInitVector(String aesEnIvInitVector) {
    this.aesEnIvInitVector = aesEnIvInitVector
  }

  String getAesEnSecretKey() {
    return aesEnSecretKey
  }

  void setAesEnSecretKey(String aesEnSecretKey) {
    this.aesEnSecretKey = aesEnSecretKey
  }

  String getAesEnBase64String() {
    return aesEnBase64String
  }

  void setAesEnBase64String(String aesEnBase64String) {
    this.aesEnBase64String = aesEnBase64String
  }
}