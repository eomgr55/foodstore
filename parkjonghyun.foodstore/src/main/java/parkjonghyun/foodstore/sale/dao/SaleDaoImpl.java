package parkjonghyun.foodstore.sale.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import parkjonghyun.foodstore.sale.dao.mapper.SaleMapper;
import parkjonghyun.foodstore.sale.domain.Sale;

@Repository
public class SaleDaoImpl implements SaleDao {
	@Autowired private SaleMapper saleMapper;
	
	@Override
	public int addSale(String userId, String prodNo, String prodCnt, String guestNo) {
		return saleMapper.addSale(userId,prodNo, prodCnt, guestNo);
	}

	@Override
	public List<Sale> selectSale(String userId) {
		return saleMapper.selectSale(userId);
	}

	@Override
	public int updateState(String saleNo, String saleState) {
		return saleMapper.updateState(saleNo, saleState);
	}

	
}
