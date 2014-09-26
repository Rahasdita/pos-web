/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pos;

import com.pos.dao.ItemKategoriDao;
import com.pos.model.ItemKategori;
import com.pos.service.MasterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author faheem
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:com/pos/**/applicationContext.xml")

public class TestItemKategori {
    @Autowired 
    MasterService service;
    
    @Test
    public void simpan(){
        ItemKategori i=new ItemKategori();
        i.setNama("ROKOK");
        i.setKeterangan("");
        service.simpan(i);
    }
    
}
