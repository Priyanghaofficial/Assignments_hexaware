public class task5_twopointers{
    public static void main(String[] args){
        int[] orderValues={10,20,30,40,50,60,70,80};
        int giftCardValue=90;
        int left=0;
        int right=orderValues.length-1;
        boolean found=false;
        System.out.println("Gift-card value: "+giftCardValue);
        System.out.println("Matching pairs:");
        while(left<right){
            int sum=orderValues[left]+orderValues[right];
            if(sum==giftCardValue){
                System.out.println(orderValues[left]+" + "+orderValues[right]+" = "+giftCardValue);
                found=true;
                left++;
                right--;
                while(left<right&&orderValues[left]==orderValues[left-1]){
                    left++;
                }
                while(left<right&&orderValues[right]==orderValues[right+1]){
                    right--;
                }
            }else if(sum<giftCardValue){
                left++;
            }else{
                right--;
            }
        }
        if(!found){
            System.out.println("No matching pairs found.");
        }
    }
}
