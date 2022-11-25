public class Main {
    public static void main(String[] args) {

        Bus num01bus = new Bus(01);
        Bus num02bus = new Bus(02);
        num01bus.check();
        num02bus.check();
        num01bus.boarding(2); // 사람 2명 탑승
        num01bus.check(); // 버스 현황 체크
        num01bus.chargingOil(-50); // 오일 -50만큼 충전
        num01bus.velocityUp(20); // 속도 증가
        num01bus.velocityUp(-55); // 속도 감소
        num01bus.check(); // 버스 현황 체크
        num01bus.stopOperation("운행종료"); // 버스 상태 운행종료
        num01bus.chargingOil(10); // 기름 10만큼 충전
        num01bus.check(); // 버스 현황 체크
        num01bus.stopOperation("운행"); //  // 버스 상태 운행으로 변경
        num01bus.boarding(45); // 45명 버스 탑승
        num01bus.boarding(5); // 5명 버스 탑승
        num01bus.check(); // 버스 현황 체크
        num01bus.chargingOil(-55); // 기름 -55만큼 충전


        System.out.println("----------------------------------------------------------------------------");
        Taxi num1tax = new Taxi(1850);
        Taxi num2tax = new Taxi(3548);
        num1tax.check();
        num2tax.check();
        num1tax.boarding("서울역", 2,2);
        num1tax.check();
        num1tax.chargingOil(-80);
        num1tax.arrival();
        num1tax.startStop("운행종료");
        num1tax.check();
        num1tax.startStop("운행");
        num1tax.boarding("공덕역",12,5);
        num1tax.boarding("공덕역",12,3);
        num1tax.check();
        num1tax.chargingOil(-20);
        num1tax.arrival();
        num1tax.check();

    }
}