package binxhealth

class MissingOrders {

    String first_name
    String last_name
    String error_code
    String barcode
    Date received_date
    Date dob
    String email

    static constraints = {
        first_name blank:false, nullable: false, maxSize: 50
        last_name blank:false, nullable: false, maxSize: 50
        error_code blank:false, nullable: false, maxSize: 50
        barcode blank:false, nullable: false, maxSize: 50
        received_date blank:false, nullable: false
        dob blank:false, nullable: false
        email blank:false, nullable: false, maxSize: 100


    }
}