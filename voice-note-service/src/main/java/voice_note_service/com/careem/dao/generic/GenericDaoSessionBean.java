/**
 *
 */
package voice_note_service.com.careem.dao.generic;

import javax.ejb.Local;
import javax.ejb.Stateless;

import voice_note_service.com.careem.dao.generic.interfaces.GenericDaoInterface;

/**
 * @author AhmedTalaat
 *
 */

@Stateless
@Local(GenericDaoInterface.class)
public class GenericDaoSessionBean extends GenericDao implements GenericDaoInterface {

}
