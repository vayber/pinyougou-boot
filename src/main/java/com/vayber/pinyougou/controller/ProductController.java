package com.vayber.pinyougou.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vayber.pinyougou.bean.Product;
import com.vayber.pinyougou.bean.QiNiuUtil;
import com.vayber.pinyougou.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



import java.util.List;

@RestController
    @RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    QiNiuUtil qiNiuUtil;

    @RequestMapping("/getProductList")
    @Cacheable(cacheNames = "product",key = "#root.methodName+'['+#currentPage+']'")
    public List<Product> getProductList(@RequestParam(value ="currentPage",defaultValue = "1")Integer currentPage,
                                        @RequestParam(value ="pageSize",required = false)Integer pageSize){

        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();

        Page<Product> page = new Page<>(currentPage,pageSize);

        Page<Product> ordersPage = productService.page(page, queryWrapper);

        List<Product> records = ordersPage.getRecords();

        return records;
    }

    @RequestMapping("/getProductListNoPage")
    @Cacheable(cacheNames = "product",key = "#root.methodName")
    public List<Product> getProductListNoPage(){
        return productService.list();
    }

    @RequestMapping("/getProductCount")
    @Cacheable(cacheNames = "product",key = "#root.methodName")
    public Integer getProductCount(){
        return productService.count();
    }

    @RequestMapping("/add")
    @CacheEvict(cacheNames = "product",allEntries=true)
    public String addProduct(@RequestParam("file") MultipartFile file,Product product) {
        String originalFilename = file.getOriginalFilename();

        String upload = qiNiuUtil.upload(file, originalFilename);

        product.setImg(upload);

        if(productService.save(product)){
           return "添加成功！";
        }else {
            return "添加失败！";
        }

    }



    @RequestMapping("/delete")
    @CacheEvict(cacheNames = "product",allEntries=true)
    public String deleteProduct(@RequestParam(value = "id",defaultValue = "")Integer id) {
                if (productService.removeById(id)){
                    return "删除成功！";
                }   else {
                    return "删除失败！";
                }
    }


    @RequestMapping("/alter")
    @CacheEvict(cacheNames = "product",allEntries=true)
    public String alterProduct(Product product) {

        if (productService.updateById(product)){
            return "修改成功！";
        }   else {
            return "修改失败！";
        }
    }


}
