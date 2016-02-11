package jeffreytackett.datastore

import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.cfg.Configuration
import org.hibernate.service.ServiceRegistry
import org.hibernate.service.ServiceRegistryBuilder

/**
 * Created by Jeffrey on 2015-11-16.
 */
class Items {
    private static SessionFactory sessionFactory
    private static ServiceRegistry serviceRegistry
    Session session

    Items() {
        sessionFactory = createSessionFactory()
    }

    private static SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration()
        configuration.configure()
        serviceRegistry = new ServiceRegistryBuilder().applySettings(
                configuration.getProperties()).buildServiceRegistry()
        sessionFactory = configuration.buildSessionFactory(serviceRegistry)
        return sessionFactory
    }

    public void startSession() throws Exception {
        session = sessionFactory.openSession()
        session.beginTransaction()
    }

    public void closeSession() throws Exception {
        session.getTransaction().commit()
        session.close()
    }

    List<Item> getSearchItems(List<String> categories = null, List<String> keywords = null) {
        String hql = buildQuery(categories, keywords)

        return session.createQuery(hql).list()
    }

    private String buildQuery(List<String> categories = null, List<String> keywords = null) {
        StringBuilder hql = new StringBuilder("from Inventory")

        if (categories || keywords) {
            hql.append(" where ")
        }

        if (categories) {
            hql.append(buildStringQueryRestriction("category", categories))
        }

        if (categories && keywords) {
            hql.append(" and ")
        }

        if (keywords) {
            hql.append(buildStringQueryRestriction("title", keywords, false))
        }

        return hql.toString()
    }

    private static String buildStringQueryRestriction(String fieldName, List<String> restritions, isExact = true) {
        StringBuilder hql = new StringBuilder()

        boolean isFirstItem = true

        hql.append("(")

        for (String restriction : restritions) {
            if (!isFirstItem) {
                hql.append(" or ")
            } else {
                isFirstItem = false
            }

            hql.append(fieldName)

            if (isExact) {
                hql.append(" = ")
            } else {
                hql.append(" like ")
            }

            hql.append("'")

            if (!isExact) {
                hql.append("%")
            }

            hql.append(restriction)

            if (!isExact) {
                hql.append("%")
            }

            hql.append("'")
        }

        hql.append(")")

        return hql.toString()
    }

}
