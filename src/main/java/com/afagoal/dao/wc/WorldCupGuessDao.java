package com.afagoal.dao.wc;

import com.afagoal.dao.BaseDao;
import com.afagoal.entity.wc.QWorldCupGuess;
import com.afagoal.entity.wc.WorldCupGuess;

import org.springframework.stereotype.Component;

/**
 * Created by BaoCai on 18/6/3.
 * Description:
 */
@Component
public class WorldCupGuessDao extends BaseDao<WorldCupGuess,QWorldCupGuess> {
    public WorldCupGuessDao(){
        this.setQEntity(QWorldCupGuess.worldCupGuess);
    }
}
