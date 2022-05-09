class Solution {

    public boolean checkRecord(String s) {
        int absentCount = 0;
        int lateCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char status = s.charAt(i);
            if (status == 'P') {
                lateCount = 0;
            } else if (status == 'L') {
                lateCount += 1;
            } else {
                absentCount += 1;
                lateCount = 0;
            }

            if (lateCount == 3 || absentCount == 2) {
                return false;
            }
        }
        return true;
    }
}
