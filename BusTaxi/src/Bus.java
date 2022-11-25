class Bus extends Transport {

        Bus(int Num) {
            this.Num = Num;
            this.oil = oil;
            this.maxPassengers = 30;
            this.charge = charge;

        }

        public void check() {
            System.out.println("버스 번호 : " + Num + "번");
            System.out.println("탑승 승객 수 : " + currentPassengers + "명");
            System.out.println("잔여 승객 수  : " + (maxPassengers - currentPassengers) + "명");
            System.out.println("요금 확인 : " + charge+ "원");
            System.out.println("누적 요금 : " + totalCharges + "원");
            System.out.println("현재 주유량 : " + oil + "L");
            if (oil < 10) {
                currentStatus = "운행종료";
            }
            System.out.println("운행 상태 : " + currentStatus);
            System.out.println("현재 속도 : " + velocity+ "km/h");
            System.out.println();
        }

        public void boarding(int num) {
            if (!ready()) {
                return;
            }
            currentPassengers += num;
            if (currentPassengers > maxPassengers) {

                System.out.println("최대 승객 수를 초과했습니다. 탑승 불가능합니다.");
                System.out.println();
                currentPassengers = currentPassengers - num;
            } else {
                charge += 1000 * num;
                currentStatus = "운행";
                System.out.printf("총 %d명이 탑승했습니다. 현재 총 탑승자 수는 %d명입니다.", num, currentPassengers);
                System.out.println();
                System.out.println();
            }
        }

        public void stopOperation(String str) {
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
                currentStatus = "운행";
            } else {
                System.out.println("\"운행\" or \"운행종료\"를 입력해 주세요.");
            }
        }
    }

