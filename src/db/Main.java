package db;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("=== students 관리 (DB: test) ===");
            System.out.println("1.조회  2.삽입  3.수정  4.삭제  5.종료");
            int menu = readInt(sc, "선택: ");

            switch (menu) {
                case 1:
                    dao.selectAll();
                    break;
                case 2: {
                    int number = readInt(sc, "번호(숫자): ");
                    String name = readRequired(sc, "이름: ");
                    String phone = readLine(sc, "전화번호: ");
                    dao.insert(number, name, phone);
                    break;
                }
                case 3: {
                    int number = readInt(sc, "수정할 번호(숫자): ");
                    String name = readRequired(sc, "새 이름: ");
                    String phone = readLine(sc, "새 전화번호: ");
                    dao.update(number, name, phone);
                    break;
                }
                case 4: {
                    int number = readInt(sc, "삭제할 번호(숫자): ");
                    dao.delete(number);
                    break;
                }
                case 5:
                    sc.close();
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("1~5 사이의 번호를 선택해 주세요.");
            }
        }
    }

    // 정수를 입력받는다. 숫자가 아니면 다시 입력받는다.
    private static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("숫자로 입력해 주세요.");
            }
        }
    }

    // 한 줄 문자열을 입력받는다.
    private static String readLine(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

    // 비어 있지 않은 문자열을 입력받는다. (name 컬럼이 NOT NULL이므로)
    private static String readRequired(Scanner sc, String prompt) {
        while (true) {
            String value = readLine(sc, prompt);
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("비워 둘 수 없습니다.");
        }
    }
}
