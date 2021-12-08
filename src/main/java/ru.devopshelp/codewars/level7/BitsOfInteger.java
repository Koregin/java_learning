package codewars.level7;

import javax.sound.midi.Soundbank;

import static java.lang.Integer.parseInt;
import static java.lang.Long.toBinaryString;

public class BitsOfInteger {
    public static int reverseBits(int decimal) {
        int[] binary = new int[32];
        int index = 0;
        while (decimal > 0) {
            binary[index++] = decimal % 2;
            decimal = decimal / 2;
        }
        int newDecimal = 0, i = 0;
        index--;
        while (index >= 0) {
            newDecimal += binary[index] * Math.pow(2, i);
            ++i;
            index--;
        }
        return newDecimal;
    }

    static int reverseBitsBest(int n) {
        return parseInt(new StringBuilder(toBinaryString(n)).reverse() + "", 2);
    }

    public static void main(String[] args) {
        int num = reverseBits(417);
        System.out.println(num);
        System.out.println(reverseBitsBest(417));
    }
}
