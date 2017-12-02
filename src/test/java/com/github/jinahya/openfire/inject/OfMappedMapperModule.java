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
package com.github.jinahya.openfire.inject;

import com.github.jinahya.openfire.ibatis.mapper.OfConversationMapper;
import com.github.jinahya.openfire.ibatis.mapper.OfMucRoomMapper;
import com.github.jinahya.openfire.ibatis.mapper.OfMucServiceMapper;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.apache.ibatis.session.SqlSession;

public class OfMappedMapperModule extends AbstractModule {

    @Override
    protected void configure() {
    }

    @Provides
    public OfMucServiceMapper ofMucServiceMapper(final SqlSession sqlSession) {
        return sqlSession.getMapper(OfMucServiceMapper.class);
    }

    @Provides
    public OfMucRoomMapper ofMucRoomMapper(final SqlSession sqlSession) {
        return sqlSession.getMapper(OfMucRoomMapper.class);
    }

    @Provides
    public OfConversationMapper ofConversationMapper(
            final SqlSession sqlSession) {
        return sqlSession.getMapper(OfConversationMapper.class);
    }

    // -------------------------------------------------------------------------
//    @Inject
//    private SqlSession sqlSession;
}
