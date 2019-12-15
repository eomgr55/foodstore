package parkjonghyun.foodstore.sale.service;

import java.util.List;

import parkjonghyun.foodstore.sale.domain.Sale;


public interface SaleService {
	boolean addSale(String userId, String prodNo, String prodCnt, String guestNo);
	List<Sale> selectSale(String userId);
	boolean updateState(String saleNo, String saleState);
}
