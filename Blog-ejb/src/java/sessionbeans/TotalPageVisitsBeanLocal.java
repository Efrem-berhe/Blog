/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import javax.ejb.Local;

/**
 *
 * @author Marek
 */
@Local
public interface TotalPageVisitsBeanLocal {

    void incrementVisits();

    int getNumberOfTotalVisits();
    
}
