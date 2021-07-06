package leetcode.easy;

/**
 * 326. Power of Three
 * https://leetcode.com/problems/power-of-three/
 */
public class PowerOfThree {
    public static void main(String[] args) {
        PowerOfThree powerOfThree = new PowerOfThree();
        System.out.println(powerOfThree.isPowerOfThree(27) == true);
        System.out.println(powerOfThree.isPowerOfThree(0) == false);
        System.out.println(powerOfThree.isPowerOfThree(9) == true);
        System.out.println(powerOfThree.isPowerOfThree(45) == false);

    }

    public boolean isPowerOfThree(int n) {
        //0 이면 종료
        if(n < 1){
            return false;
        }

        // 3^0 = 1
        // 1 이 아니면 loop
        while (n != 1){
            // 3의 배수 검증
            if(n % 3 != 0){
                return false;
            }
            // 3으로 나누어서 n을 찾음
            n = n / 3;
        }


        return true;
    }

}
