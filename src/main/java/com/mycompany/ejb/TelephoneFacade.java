package com.mycompany.ejb;

import com.mycompany.model.Telephone;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class TelephoneFacade extends AbstractFacade<Telephone> implements TelephoneFacadeLocal {

    @PersistenceContext(unitName = "PrimerPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TelephoneFacade() {
        super(Telephone.class);
    }

    @Override
    public List<Telephone> LookforTelephone(int codigoPersona) {
        List<Telephone> lista = null;
        String consulta;
        
        try {
            consulta = "FROM Telehone t WHERE t.persona.codigo = ?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, codigoPersona);            

            lista = query.getResultList();            
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

}
