package parkjonghyun.foodstore.sale.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import parkjonghyun.foodstore.sale.domain.Sale;

public interface SaleMapper {
	int addSale(@Param("userId") String userId, @Param("prodNo") String prodNo, @Param("prodCnt") String prodCnt, @Param("guestNo") String guestNo);
	List<Sale> selectSale(String userId);
	int updateState(@Param("saleNo") String saleNo, @Param("saleState") String saleState);
}
