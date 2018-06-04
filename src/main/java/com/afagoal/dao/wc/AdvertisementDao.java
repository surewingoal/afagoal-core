package com.afagoal.dao.wc;

import com.afagoal.dao.BaseDao;
import com.afagoal.entity.wc.Advertisement;
import com.afagoal.entity.wc.QAdvertisement;

import org.springframework.stereotype.Component;

/**
 * Created by BaoCai on 18/6/3.
 * Description:
 */
@Component
public class AdvertisementDao extends BaseDao<Advertisement,QAdvertisement> {
    public AdvertisementDao(){
        this.setQEntity(QAdvertisement.advertisement);
    }
}
