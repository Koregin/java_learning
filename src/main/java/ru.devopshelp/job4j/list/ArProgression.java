package ru.devopshelp.job4j.list;

import java.util.List;

public class ArProgression {
    public static int checkData(List<Integer> data) {
        int res = 0;
        for (int index = 0; index < data.size(); index++ ) {
            res += data.get(index);
            if(index > 0 && index < data.size() - 1) {
                if (data.get(index) != (data.get(index - 1) + data.get(index + 1)) / 2) {
                    res = 0;
                    break;
                }
            }
        }
        return res;
    }
}
