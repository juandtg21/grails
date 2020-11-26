package binxhealth

class Partner{

    Date date_created
    String code
    Boolean has_own_clinician
    String subdomain
    static hasMany = [partnerstatesavailable: PartnerStatesAvailable]

    static constraints = {
        date_created blank:false, nullable: false
        code blank:false, nullable: false, maxSize: 50
        has_own_clinician blank:false, nullable: false
        subdomain blank:true, nullable: true, maxSize: 50
    }
    String toString(){
        code
    }
}
