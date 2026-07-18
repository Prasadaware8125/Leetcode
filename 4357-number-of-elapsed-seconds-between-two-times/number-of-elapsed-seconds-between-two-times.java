class Solution {
    public int getTimeInSec(String time) {
        int hh = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
        int mm = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
        int ss = (time.charAt(6) - '0') * 10 + (time.charAt(7) - '0');

        return hh * 3600 + mm * 60 + ss;
    }
    public int secondsBetweenTimes(String startTime, String endTime) {
        int st = 0;
        st = getTimeInSec(startTime);
        int et = 0;
        et = getTimeInSec(endTime);

        return Math.abs(et - st);
    }
}