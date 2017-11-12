/*
 * Copyright 2017 Jin Kwon &lt;onacit at wemakeprice.com&gt;.
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
package com.github.jinahya.openfire.bind;

import static java.lang.invoke.MethodHandles.lookup;
import java.util.stream.IntStream;
import org.slf4j.Logger;
import static org.slf4j.LoggerFactory.getLogger;
import org.testng.annotations.Test;

/**
 * Test class for {@link OfGroup} class.
 *
 * @author Jin Kwon &lt;onacit at wemakeprice.com&gt;
 */
public class OfGroupTest extends OfMappedTest<OfGroup> {

    private static final Logger logger = getLogger(lookup().lookupClass());

    // -------------------------------------------------------------------------
    public OfGroupTest() {
        super(OfGroup.class);
    }

    // -------------------------------------------------------------------------
    @Test(enabled = false)
    public void test() {
        IntStream.range(0, 65536)
                .filter(v -> Character.isJavaIdentifierStart((char) v))
                .limit(128)
                .forEach(v -> {
                    logger.debug("start: {}", (char) v);
                });
    }
}
