public class ConditionalsAndLoops {
    public static void main(String[] args) {

    }

    public static boolean isEvenNumber(int num){
        return num % 2 == 0;
    }

    public static String schoolSituation(double media){
        if(media >= 7.0) {
            return "Approved";
        } else if(media >= 5.0) {
            return "In remedial classes.";
        } else {
            return "Failed";
        }
    }

    public static double discountAmount(double price){
        if(isDiscountApplicable(price)){
            return price * 0.1;
        } else {
            return 0;
        }
    }

    public static boolean isDiscountApplicable(double price){
        return price > 100;
    }
}
