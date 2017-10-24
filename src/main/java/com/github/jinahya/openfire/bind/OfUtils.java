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
package com.github.jinahya.openfire.bind;

import java.util.Date;
import static java.util.Optional.ofNullable;

/**
 *
 * @author Jin Kwon &lt;onacit at gmail.com&gt;
 */
final class OfUtils {

    static Date copyOf(final Date date) {
        return ofNullable(date).map(v -> new Date(v.getTime())).orElse(null);
    }

    // -------------------------------------------------------------------------    
    private OfUtils() {
        super();
    }
}
