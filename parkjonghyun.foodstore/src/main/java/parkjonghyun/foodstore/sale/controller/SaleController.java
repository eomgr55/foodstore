package parkjonghyun.foodstore.sale.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import parkjonghyun.foodstore.guest.service.GuestService;
import parkjonghyun.foodstore.product.domain.Product;
import parkjonghyun.foodstore.product.service.ProdService;
import parkjonghyun.foodstore.sale.service.SaleService;
import parkjonghyun.foodstore.stock.service.StockService;
import parkjonghyun.foodstore.user.domain.User;

@Controller
@RequestMapping("/sale")
public class SaleController {
	@Autowired private StockService stockService;
	@Autowired private ProdService prodService;
	@Autowired private SaleService saleService;
	@Autowired private GuestService guestService;
	
	@RequestMapping(value="/order", method=RequestMethod.GET)
	public String order(Model model, HttpSession session) {
		User user = (User)session.getAttribute("user");
		model.addAttribute("stocks", stockService.getStocks(user.getUserId()));
		model.addAttribute("products", prodService.getProds());
		return "/sale/order";
	}
	
	@RequestMapping(value="/orderdetail")
	@ResponseBody
	public List<Product> orderdetail(String str){
		return prodService.getProdstr(str);
	}
	
	@Transactional
	@RequestMapping("/addSale")
	public String addSale(HttpServletRequest request, HttpSession session){
		String prodNo[] = request.getParameterValues("prodNo");
		String prodCnt[] = request.getParameterValues("prodCnt");
		String userid = ((User)session.getAttribute("user")).getUserId();
		guestService.addGuest();
		String guestNo = guestService.findGuest();
		for(int i=0; i<prodCnt.length; i++){
			stockService.saleStocks(userid, prodNo[i], prodCnt[i]);
			saleService.addSale(userid, prodNo[i], prodCnt[i], guestNo);		
		}
		return "redirect:../sale/order";
	}
}