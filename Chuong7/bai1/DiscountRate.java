   package bai1;        
class DiscountRate {
    static final double PREMIUM_SERVICE_DISCOUNT = 0.2;
    static final double GOLD_SERVICE_DISCOUNT = 0.15;
    static final double SILVER_SERVICE_DISCOUNT = 0.1;
    static final double PRODUCT_DISCOUNT = 0.1;

    static double getServiceDiscountRate(String membership) {
        switch (membership) {
            case "Premium": return PREMIUM_SERVICE_DISCOUNT;
            case "Gold": return GOLD_SERVICE_DISCOUNT;
            case "Silver": return SILVER_SERVICE_DISCOUNT;
            default: return 0;
        }
    }

    static double getProductDiscountRate() {
        return PRODUCT_DISCOUNT;
    }
}