import java.util.List;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class App {
    private ItemRepository itemRepository;
    private SalesPromotionRepository salesPromotionRepository;

    public App(ItemRepository itemRepository, SalesPromotionRepository salesPromotionRepository) {
        this.itemRepository = itemRepository;
        this.salesPromotionRepository = salesPromotionRepository;
    }

    public String bestCharge(List<String> inputs) {
        //TODO: write code here
        String result = "============= Order details =============\n";

        int sum = 0;
        for (String input : inputs) {
            String itemStr = input.substring(0, 8);
            Item item = null;

            for (Item i : itemRepository.findAll()) {
                if (itemStr == i.getId()) {
                    item = i;
                    break;
                }
            }

            sum += (int)(item.getPrice() * Integer.parseInt(input.substring(11)));
            result += (item.getName() + input.substring(8) + " = " + (int)(item.getPrice() * Integer.parseInt(input.substring(11))) + " yuan\n");
        }

        result += "-----------------------------------\n";

        int lastSum = 0;
        if (sum >= 30) {
            result += "Promotion used:\n";
            int lastSum0 = sum - 6;
            int lastSum1 = 0;

            SalesPromotion salesPromotion = null;
            for (SalesPromotion s : salesPromotionRepository.findAll()) {
                salesPromotion = s;
            }

            for (String input : inputs) {
                boolean flag = false;
                for (String relatedItem : salesPromotion.getRelatedItems()) {
                    if (input.substring(0, 8) == relatedItem) {
                        flag = true;
                    }
                }

//                if (flag == true) {
//
//                } else {
//                    lastSum1 += (int)(item.getPrice() * Integer.parseInt(input.substring(11)));
//                }
            }

        }

        result += "===================================";


        return result;
    }
}
