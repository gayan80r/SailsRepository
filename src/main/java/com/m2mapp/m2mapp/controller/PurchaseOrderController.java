package com.m2mapp.m2mapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.m2mapp.m2mapp.entity.Item;
import com.m2mapp.m2mapp.entity.PurchaseItem;
import com.m2mapp.m2mapp.entity.PurchaseOrder;
import com.m2mapp.m2mapp.model.Product;
import com.m2mapp.m2mapp.model.ProductList;
import com.m2mapp.m2mapp.service.ItemService;
import com.m2mapp.m2mapp.service.PurchaseItemService;
import com.m2mapp.m2mapp.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/pocontroller")//using to call ajax to controller
public class PurchaseOrderController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private PurchaseOrderService purchaseOrderService;
    @Autowired
    private PurchaseItemService purchaseItemService;

    @RequestMapping(value = {"/neworder"}, method = RequestMethod.GET)
    //HttpSession is used store the user information
    public String newOrder(ModelMap model, HttpSession session) {
        //pass purchaseOrder model attribute from in to Controller
        PurchaseOrder newOrder = new PurchaseOrder();
        // model.addAttribute("PurchaseOrder",newOrder);
        model.addAttribute("PurchaseOrder", newOrder);
        List<Item> itemList = itemService.findall();
        Product product = new Product();

        //ProductList productList = new ProductList();
        //session.setAttribute("plist", productList);

        // model.addAttribute("ptList",productList);
        //pass model attribute controller to ui
        model.addAttribute("itemList", itemList);
        model.addAttribute("product", product);

        return "PurchaseOrder";
    }

    @RequestMapping(value = {"/additem"}, method = RequestMethod.GET)
    public String addItem(@RequestParam("json") String requestJSON, ModelMap model, HttpSession session) {
        //System.out.println(requestJSON);
        try {
            //object mapper class used map json object into the entity class object
            //this time our json object can not directly map our entity class therefore
            //we create the string array
            ObjectMapper mapper = new ObjectMapper();
            String[] values = mapper.readValue(requestJSON, String[].class);
            //System.out.println(values[0]+"---"+values[1]);
            Integer itemId = Integer.parseInt(values[0]);
            Integer quantity = Integer.parseInt(values[1]);

            Item itemObj = itemService.findById(itemId);

            Product proObj = new Product();
            //add the product name quantity into the product
            proObj.setItem(itemObj);
            proObj.setQuantity(quantity);

            if(session.getAttribute("pList")!=null){
                ProductList productList = (ProductList) session.getAttribute("pList");
               //then we call addProduct method of the productList model class
                productList.addProduct(proObj, quantity);
                session.setAttribute("pList", productList);
            }
            else{
                ProductList productList = new ProductList();
                //then we call addProduct method of the productList model class
                productList.addProduct(proObj, quantity);
                session.setAttribute("pList", productList);

            }

            //List <Product> productList=new ArrayList<>();
            //we track the product list add by the user in each time
            //The HttpSession object is used for session management. A session contains information specific to a particular user across the whole application.

            //List <Product> productList=Listsession.getAttribute("pList");

            //productList.add(proObj);
            //model.addAttribute("ptList",productList);

        } catch (Exception e) {
            //we need redirect the following url /pocontroller/neworder
            return "redirect:/pocontroller/neworder";
        }

//        System.out.println();
        return "";
    }

    /* @RequestMapping(value = {"/savepurchaseorder"}, method = RequestMethod.POST)
     public String savePurchaseOrder(PurchaseOrder purchaseOrder, ModelMap model, HttpSession session, PurchaseItem  purchaseItem){
         purchaseOrderService.save(purchaseOrder);
         purchaseItemService.save(purchaseItem);
         return "sucessfully inserted";
     }*/
    @RequestMapping(value = {"/neworder"}, method = RequestMethod.POST)
    //HttpSession is used store the user information
    public String savePurchaseOrder(@RequestParam("json") String requestJSON, ModelMap model, HttpSession session) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            //String[] values = mapper.readValue(requestJSON, String[].class);

            PurchaseOrder purchaseOrder=new PurchaseOrder();
            purchaseOrder.setPoNumber("10001121");
            purchaseOrder.setPoDate(new Date());
            purchaseOrder.setTotalPrice(12500.00);
            purchaseOrderService.save(purchaseOrder);

            ProductList productList = (ProductList) session.getAttribute("pList");
            for (Product p : productList.getProductList()) {
                //product p data type is product this the enhance for loop or foreach

                PurchaseItem purchaseItem = new PurchaseItem();

                purchaseItem.setPurchaseorder(purchaseOrder);
                purchaseItem.setQuantity(p.getQuantity());
                purchaseItem.setItemobj(p.getItem());

                purchaseItemService.save(purchaseItem);
            }
        }
        catch(Exception e){}
        return "";
    }
}
