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

import com.github.jinahya.openfire.persistence.OfProp;
import static java.lang.invoke.MethodHandles.lookup;
import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;

public abstract class OfPropMapperTest<PropType extends OfProp<PropType>, MapperType extends OfPropMapper<PropType>>
        extends OfMappedMapperTest<PropType, MapperType> {

    private static final Logger logger = getLogger(lookup().lookupClass());

    // -------------------------------------------------------------------------
//    static <T extends OfProp<T>, U extends OfPropMapper<T>> void acceptOfPropsPaginated(
//            final Class<T> mappedClass, final Class<U> mapperClass,
//            final U mapper,
//            final String room,
//            final Consumer<List<T>> consumer) {
//        final int limit = 4;
//        for (int offset = 0; offset <= 16; offset += limit) {
//            final List<OfConversation> ofConversations = mapper.selectList01(
//                    CATALOG, SCHEMA, room, false, false,
//                    new RowBounds(offset, limit));
//            if (ofConversations.isEmpty()) {
//                break;
//            }
//            ofConversations.forEach(ofConversation -> {
//                logger.debug("ofConversation: {}", ofConversation);
//            });
//            consumer.accept(ofConversations);
//        }
//    }

    // -------------------------------------------------------------------------
    public OfPropMapperTest(final Class<PropType> mappedType,
                            final Class<MapperType> mapperType) {
        super(mappedType, mapperType);
    }

//    private void test(final String room) {
//        acceptMucConversationsPaginated(
//                mappedMapper,
//                room,
//                ofMucConversations -> {
//                    validate(ofMucConversations);
//                    ofMucConversations.forEach(ofMucConversation -> {
//                        final OfConversation one = mappedMapper.selectOne01(
//                                CATALOG, SCHEMA,
//                                ofMucConversation.getConversationId(),
//                                room);
//                        validate(one);
//                    });
//                });
//    }
//
//    @Test
//    public void selectList01WithRoom() {
//        acceptOfMucRoomsPaginated(
//                ofMucRoomMapper,
//                null,
//                ofMucRooms -> {
//                    ofMucRooms.forEach(ofMucRoom -> {
//                        final String room
//                                = OfConversation.room(ofMucRoom, DOMAIN);
//                        test(room);
//                    });
//                });
//    }
//
//    @Test
//    public void selectList01WithoutRoom() {
//        test(null);
//    }

    // -------------------------------------------------------------------------
}
