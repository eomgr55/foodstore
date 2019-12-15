package parkjonghyun.foodstore.sale.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import parkjonghyun.foodstore.sale.domain.Sale;


public interface SaleDao {
	int addSale(String userId, String prodNo, String prodCnt, String guestNo);
	List<Sale> selectSale(String userId);
	int updateState(String saleNo, String saleState);
}
