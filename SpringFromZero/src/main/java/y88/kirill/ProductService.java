package y88.kirill;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.stereotype.Component;
import org.springframework.beans.factory.stereotype.Service;

@Component
@Service
public class ProductService {

    @Autowired
    private PromotionService promotionService;



    public PromotionService getPromotionService(){
        return promotionService;
    }

    public void setPromotionService(PromotionService promotionService) {
        this.promotionService = promotionService;
    }
}