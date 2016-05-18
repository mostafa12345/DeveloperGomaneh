/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Entity.PortfolioCategory;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author administrator
 */
@Stateless
public class PortfolioCategoryFacade extends AbstractFacade<PortfolioCategory> {

    @PersistenceContext(unitName = "DeveloperGomanehPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PortfolioCategoryFacade() {
        super(PortfolioCategory.class);
    }
    
}
