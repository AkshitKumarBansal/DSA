class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        long minLandFinish = Long.MAX_VALUE;
        for (int i = 0; i < landStartTime.length; i++) {
            long finishTime = (long) landStartTime[i] + landDuration[i];
            minLandFinish = Math.min(minLandFinish, finishTime);
        }
        long minWaterFinish = Long.MAX_VALUE;
        for (int i = 0; i < waterStartTime.length; i++) {
            long finishTime = (long) waterStartTime[i] + waterDuration[i];
            minWaterFinish = Math.min(minWaterFinish, finishTime);
        }
        long minTimeA = Long.MAX_VALUE;
        for (int i = 0; i < waterStartTime.length; i++) {
            long waterStart = Math.max(minLandFinish, (long) waterStartTime[i]);
            long finishTime = waterStart + waterDuration[i];
            minTimeA = Math.min(minTimeA, finishTime);
        }
        long minTimeB = Long.MAX_VALUE;
        for (int i = 0; i < landStartTime.length; i++) {
            long landStart = Math.max(minWaterFinish, (long) landStartTime[i]);            
            long finishTime = landStart + landDuration[i];            
            minTimeB = Math.min(minTimeB, finishTime);
        }
        return (int)Math.min(minTimeA, minTimeB);
    }
}