public class task4_slidingwindow{
    public static void main(String[] args){
        int[] requests=new int[24*60];
        for(int minute=0;minute<requests.length;minute++){
            requests[minute]=80+(minute%60);
            if(minute>=10*60&&minute<13*60){
                requests[minute]+=250;
            }
        }
        int windowSize=3*60;
        int currentSum=0;
        for(int i=0;i<windowSize;i++){
            currentSum+=requests[i];
        }
        int maxSum=currentSum;
        int bestStart=0;
        for(int i=windowSize;i<requests.length;i++){
            currentSum+=requests[i]-requests[i-windowSize];
            if(currentSum>maxSum){
                maxSum=currentSum;
                bestStart=i-windowSize+1;
            }
        }
        int endExclusive=bestStart+windowSize;
        System.out.println("Busiest 3-hour window: "+toTime(bestStart)+" to "+toTime(endExclusive));
        System.out.println("Total requests in that window: "+maxSum);
        System.out.println("Average requests per minute: "+(maxSum/windowSize));
        System.out.println("Sample traffic data is used for demonstration.");
    }
    static String toTime(int minuteOfDay){
        int normalized=minuteOfDay%(24*60);
        int hour=normalized/60;
        int minute=normalized%60;
        return String.format("%02d:%02d",hour,minute);
    }
}
