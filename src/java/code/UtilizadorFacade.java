/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Fernando
 */
@Stateless
public class UtilizadorFacade implements UtilizadorFacadeLocal {

    @EJB
    private DAOLocal dao;

    @Override
    public List<TUtilizador> getAll() {
        return dao.getEntityManager().
                createNamedQuery("TUtilizador.findAll").
                getResultList();
    }

    @Override
    public void createNew(String nome, String morada, String username, String password) {
        TUtilizador u = new TUtilizador(username, nome, morada, password);
        dao.getEntityManager().persist(u);
    }

    @Override
    public void changeName(TUtilizador user, String nome) {
        dao.getEntityManager().createNativeQuery("UPDATE t_utilizador SET nome='" + nome + "' "
                + "WHERE username='" + user.getUsername() + "';").executeUpdate();

    }

    @Override
    public void changeAdress(TUtilizador user, String address) {
        dao.getEntityManager().createNativeQuery("UPDATE t_utilizador SET morada='" + address + "' "
                + "WHERE username='" + user.getUsername() + "';").executeUpdate();
    }

    @Override
    public void changePassword(TUtilizador user, String password) {
        dao.getEntityManager().createNativeQuery("UPDATE t_utilizador SET password='" + password + "' "
                + "WHERE username='" + user.getUsername() + "';").executeUpdate();
    }

    @Override
    public void increaseBalance(TUtilizador user, float valor) {
        dao.getEntityManager().createNativeQuery("UPDATE t_utilizador SET saldo='" + valor + "' "
                + "WHERE username='" + user.getUsername() + "';").executeUpdate();
    }

    @Override
    public void suspensionRequest(TUtilizador user, String reason) {
        TSuspensao s = new TSuspensao();
        s.setUtilizadorid(user);       
        s.setRazao(reason);
        s.setPendente(true);
        dao.getEntityManager().persist(s);
    }

}
