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
package com.github.jinahya.openfire.ibatis.mapper;

import com.github.jinahya.openfire.persistence.OfMessageArchive;
import static com.github.jinahya.openfire.ibatis.mapper.OfMappedMapperTest.CATALOG;
import com.google.inject.Inject;
import static java.lang.invoke.MethodHandles.lookup;
import java.util.List;
import java.util.function.Consumer;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;
import org.testng.annotations.Test;
import static com.github.jinahya.openfire.ibatis.mapper.OfConversationMapperTest.acceptMucConversationsPaginated;
import static java.util.concurrent.ThreadLocalRandom.current;
import static org.testng.Assert.assertEquals;

public class OfMessageArchiveMapperTest
        extends OfMappedMapperTest<OfMessageArchive, OfMessageArchiveMapper> {

    private static final Logger logger = getLogger(lookup().lookupClass());

    // -------------------------------------------------------------------------
    static void acceptOfMessageArchivesPaginated(
            final OfMessageArchiveMapper mapper,
            final Long conversationId,
            final Consumer<List<OfMessageArchive>> consumer) {
        final int limit = 5;
        for (int offset = 0; offset <= 32; offset += limit) {
            final List<OfMessageArchive> OfMessageArchives
                    = mapper.selectList01(
                            CATALOG, SCHEMA, conversationId,
                            current().nextBoolean(), current().nextBoolean(),
                            new RowBounds(offset, limit));
            if (OfMessageArchives.isEmpty()) {
                break;
            }
            OfMessageArchives.forEach(ofMessageArchive -> {
                logger.debug("ofMessageArchive: {}", ofMessageArchive);
            });
            consumer.accept(OfMessageArchives);
        }
    }

    // -------------------------------------------------------------------------
    public OfMessageArchiveMapperTest() {
        super(OfMessageArchive.class, OfMessageArchiveMapper.class);
    }

    // -------------------------------------------------------------------------
    private void test(final Long conversationId) {
        acceptOfMessageArchivesPaginated(
                mappedMapper,
                conversationId,
                list -> {
                    validate(list);
                    list.forEach(v -> {
                        final OfMessageArchive one
                                = mappedMapper.selectOne01(
                                        CATALOG, SCHEMA, v.getMessageId());
                        validate(one);
                        if (conversationId != null) {
                            assertEquals(
                                    one.getConversation().getConversationId(),
                                    conversationId);
                        }
                    });
                });
    }

    @Test
    public void selectWithConversation() {
        acceptMucConversationsPaginated(
                ofConversationMapper,
                null,
                ofConversations -> {
                    ofConversations.forEach(ofConversation -> {
                        test(ofConversation.getConversationId());
                    });
                });
    }

    @Test
    public void selectWithoutConversation() {
        test(null);
    }

    // -------------------------------------------------------------------------
    @Inject
    private OfConversationMapper ofConversationMapper;
}
