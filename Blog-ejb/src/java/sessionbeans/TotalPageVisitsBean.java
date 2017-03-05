/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import javax.ejb.Singleton;

/**
 *
 * @author Marek
 */
@Singleton
public class TotalPageVisitsBean implements TotalPageVisitsBeanLocal {

    private int totalVisits = 0;
    
    @Override
    public void incrementVisits() {
        totalVisits++;
    }
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public int getNumberOfTotalVisits() {
        return totalVisits;
    }
}
