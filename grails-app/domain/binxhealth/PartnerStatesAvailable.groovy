package binxhealth

class PartnerStatesAvailable {

    static belongsTo = [partner: Partner]
    String usa_state

    static constraints = {
        usa_state blank: null,nullable: false,maxSize: 10
    }
    String toString(){
        usa_state
    }
}

