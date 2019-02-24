grails.gorm.default.constraints = {
    '*'(nullable:true, blank:true)
}

grails.gorm.default.mapping = {
    '*'(autoTimestamp:false)
}

grails.databinding.dateFormats = ['yyyy-MM-dd',
                                  'yyyy/MM/dd',
                                  'MMddyyyy']