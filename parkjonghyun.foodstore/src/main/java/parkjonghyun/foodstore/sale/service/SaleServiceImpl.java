package parkjonghyun.foodstore.sale.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import parkjonghyun.foodstore.sale.dao.SaleDao;
import parkjonghyun.foodstore.sale.domain.Sale;

@Service
public class SaleServiceImpl implements SaleService{
	@Autowired private SaleDao saleDao;
	
	@Transactional
	@Override
	public boolean addSale(String userId, String prodNo, String prodCnt, String guestNo) {
		return saleDao.addSale(userId,prodNo, prodCnt, guestNo)>0;
	}

	@Override
	public List<Sale> selectSale(String userId) {
		return saleDao.selectSale(userId);
	}

	@Transactional
	@Override
	public boolean updateState(String saleNo, String saleState) {
		return saleDao.updateState(saleNo, saleState)>0;
	}
}
