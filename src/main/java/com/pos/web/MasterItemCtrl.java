/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pos.web;

import com.pos.dao.ItemDao;
import com.pos.model.Item;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author faheem
 */
@Controller
@RequestMapping("/master")
public class MasterItemCtrl {
    @Autowired
    ItemDao itemDao;
    private Logger logger=LoggerFactory.getLogger(MasterItemCtrl.class);
    
    @RequestMapping(value = "/item", method = RequestMethod.GET)
    @ResponseBody
    public Page<Item> listAll(
            @RequestParam(required = false) String search, 
            Pageable pageable, 
            HttpServletResponse response){
        PageRequest pr = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), Sort.Direction.ASC, "nama");
        logger.debug("pageNumber [{}], pageSize: [{}]", pageable.getPageNumber(), pageable.getPageSize());
        return itemDao.findAll(pr);
    }
    
    @RequestMapping(value = "/item/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Item findOne(@PathVariable String id, 
            HttpServletResponse response){
        return itemDao.findOne(id);
    }
    @RequestMapping(value = "/item/cek-nama/{nama}", method = RequestMethod.GET)
    @ResponseBody
    public Item cekNama(@PathVariable String nama, 
            HttpServletResponse response){
        return itemDao.findByNama(nama);
    }
    @RequestMapping(value = "/item/{nama}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Item> findByName(@PathVariable String nama, 
            Pageable pageable, 
            HttpServletResponse response){
        return itemDao.filter("%"+nama+"%", pageable);
    }
    @RequestMapping(value = "/item/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Item> findAll(@PathVariable String nama, 
            HttpServletResponse response){
        return itemDao.filterAll("%"+nama+"%");
    }
    
    
    @RequestMapping(value = "/item", method = RequestMethod.POST)
    public void save(@RequestBody Item ik, 
            HttpServletResponse response){
        itemDao.save(ik);
    }
    
    @RequestMapping(value = "/item", method = RequestMethod.PUT)
    public void update(@RequestBody Item ik, 
            HttpServletResponse response){
        itemDao.save(ik);
    }
    
    
    @RequestMapping(value = "/item/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id, 
            HttpServletResponse response){
        itemDao.delete(id);
    }
    
    @RequestMapping(value = "/item/count", method = RequestMethod.GET)
    public Long count(HttpServletResponse response){
        return itemDao.count();
    }
    
}
