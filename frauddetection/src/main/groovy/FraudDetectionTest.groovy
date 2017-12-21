import spock.lang.*

class FraudDetectionTest extends Specification {
    String[] line

    def setup(){
        line = "123,ciao,iochisono,quattro,cinque,sei,sette,otto".split(",")
    }

    def "length of Spock's and his friends' names"() {
        expect:
        name.size() == length

        where:
        name     | length
        "Kirk"   | 4
        "Spock"  | 5
        "Scotty" | 6
    }

    def "is an OrderId"(){
        given:
        FraudDetection.Record rec = FraudDetection.createRecord(line)

        when:
        FraudDetection.detectFraudEmail(rec)

        then:
        rec.orderID == "123"
    }

}