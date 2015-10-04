package StuMtrManageSys.TestService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {
    
    @SuppressWarnings("unchecked")
    public void OneKeyOrder(List<Good> goods){
        double totalPrice = 0;//总价
        for (int i = 0;i < goods.size();i++){
            totalPrice += goods.get(i).getPrice();
        }
        @SuppressWarnings("rawtypes")
        Map map = new HashMap();
        map.put("totalPrice", totalPrice);
        map.put("goods", goods);
    }
    
    public class Good{//商品类
        private String name;
        private double price;
        private int storeId;//商铺ID
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public double getPrice() {
            return price;
        }
        public void setPrice(double price) {
            this.price = price;
        }
        public int getStoreId() {
            return storeId;
        }
        public void setStoreId(int storeId) {
            this.storeId = storeId;
        }
    }
    
    public class Orders{//订单类
        private int id;
    }
}
