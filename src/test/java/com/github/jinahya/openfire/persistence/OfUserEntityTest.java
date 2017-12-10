/*
 * Copyright 2017 Jin Kwon &lt;onacit at gmail.com&gt;.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.jinahya.openfire.persistence;

import static java.lang.invoke.MethodHandles.lookup;
import java.util.List;
import java.util.function.Function;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;
import org.testng.annotations.Test;

/**
 * A class for testing {@link OfUser} as an Entity.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public class OfUserEntityTest extends OfMappedEntityTest<OfUser> {

    private static final Logger logger = getLogger(lookup().lookupClass());

    // -------------------------------------------------------------------------
    public static <R> R applyOfUsers(
            final EntityManager manager,
            final Function<List<OfUser>, R> function) {
        final CriteriaBuilder builder = manager.getCriteriaBuilder();
        final CriteriaQuery<OfUser> criteria
                = builder.createQuery(OfUser.class);
        final Root<OfUser> root = criteria.from(OfUser.class);
        criteria.orderBy(builder.desc(root.get(OfUser_.username)));
        final TypedQuery<OfUser> typed = manager.createQuery(criteria);
        typed.setFirstResult(0);
        typed.setMaxResults(8);
        final List<OfUser> list = typed.getResultList();
        return function.apply(list);
    }

    // -------------------------------------------------------------------------
    public OfUserEntityTest() {
        super(OfUser.class);
    }

    // -------------------------------------------------------------------------
    @Test
    public void test() {
        acceptEntityManager(entityManager -> {
            applyOfUsers(
                    entityManager,
                    ofUsers -> {
                        ofUsers.forEach(ofUser -> {
                            logger.debug("ofUser: {}", ofUser);
                        });
                        return null;
                    }
            );
        });
    }
}
