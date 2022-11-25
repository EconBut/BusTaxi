class Taxi extends Transport {

    String destination = "";
    int distance;
    int basicdistance = 1;
    int basicfare = 3000;
    int disface = 1000;

    Taxi(int Num) {
        this.Num = Num;
        this.oil = oil;
        this.velocity = 30;
        this.maxPassengers = 4;
        this.currentStatus = "일반";

    }

    public void check() {
        System.out.println("현재 택시 번호 : " + Num);
        System.out.println("탑승 승객 수 : " + currentPassengers + "명");
        System.out.println("잔여 승객 수 : " + (maxPassengers - currentPassengers) + "명");
        System.out.println("기본 요금 확인 : " + basicfare + "원");
        System.out.println("목적지 : " + destination);
        System.out.println("목적지 까지의 거리 : " + distance + "km");
        System.out.println("지불할 요금 : " + charge + "원");
        System.out.println("누적 요금 : " + totalCharges + "원");
        System.out.println("잔여 주유량 : " + oil + "L");
        System.out.println("현재 속도 : " + velocity + "km/h");
        if (oil < 10) {
            currentStatus = "운행불가";
        }
        System.out.println("상태 : " + currentStatus);
        System.out.println();

    }

    public void boarding(String str, int receivedistance, int person) {
        if (!ready()) {
            return;
        }
        if (!currentStatus.equals("일반")) {
            System.out.println("운행중이 아닙니다. 탑승할 수 없습니다.");
            return;
        }
        distance = receivedistance;
        destination = str;
        currentPassengers += person;
        if (currentPassengers > maxPassengers) {
            System.out.println("최대 승객 수를 초과했습니다. 탑승 불가능합니다.");
            System.out.println();
            currentPassengers = currentPassengers - person;
        } else {
            charge += basicfare + (   disface * (distance - basicdistance));
            currentStatus = "운행";
            System.out.printf("총 %d명이 탑승했습니다. 현재 총 탑승자 수는 %d명입니다.", person, currentPassengers);
            System.out.println();
            System.out.println();
        }
    }

    public void startStop(String str) {
        if (str.equals("운행종료")) {
            System.out.println("운행을 종료합니다.");
            System.out.println();
            currentStatus = "운행종료";
            currentPassengers = 0;
            velocity = 0;
            totalCharges += charge;
            charge = 0;
        } else if (str.equals("운행")) {
            System.out.println("운행을 시작합니다.");
            System.out.println();
            currentStatus = "일반";
        } else {
            System.out.println("\"운행\" or \"운행종료\"를 입력해 주세요.");
        }
    }

    public void arrival() {
        System.out.printf("목적지에 도착했습니다. 이동거리는 %d km이고, 요금은 %d원 입니다.\n", distance, charge);
        System.out.println();
        currentStatus = "일반";
        totalCharges += charge;
        charge = 0;
        velocity = 0;
        currentPassengers = 0;
        destination = "";
        distance = 0;
    }

}
