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
import static com.github.jinahya.openfire.persistence.OfMucServiceEntityTest.applyOfMucServices;
import static java.lang.Math.pow;

/**
 * A class for testing {@link OfMucService} as an Entity.
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
public class OfMucServiceEntityTest extends OfMappedEntityTest<OfMucService> {

    private static final Logger logger = getLogger(lookup().lookupClass());

    // -------------------------------------------------------------------------
    public static <R> R applyOfMucServices(
            final EntityManager manager,
            final Function<List<OfMucService>, R> function) {
        final CriteriaBuilder builder = manager.getCriteriaBuilder();
        final CriteriaQuery<OfMucService> criteria
                = builder.createQuery(OfMucService.class);
        final Root<OfMucService> root = criteria.from(OfMucService.class);
        criteria.orderBy(builder.desc(root.get(OfMucService_.subdomain)));
        final TypedQuery<OfMucService> typed = manager.createQuery(criteria);
        typed.setFirstResult(0);
        typed.setMaxResults((int) pow(2.0d, OfMucServiceTest.EXPONENT));
        final List<OfMucService> list = typed.getResultList();
        return function.apply(list);
    }

    // -------------------------------------------------------------------------
    /**
     * Creates a new instance.
     */
    public OfMucServiceEntityTest() {
        super(OfMucService.class);
    }

    // -------------------------------------------------------------------------
    @Test
    public void test() {
        acceptEntityManager(entityManager -> {
            applyOfMucServices(
                    entityManager,
                    ofMucServices -> {
                        ofMucServices.forEach(ofMucService -> {
                            logger.debug("ofMucService: {}", ofMucService);
                        });
                        return null;
                    }
            );
        });
    }
}
