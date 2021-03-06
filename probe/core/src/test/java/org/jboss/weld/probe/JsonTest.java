/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.weld.probe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * TODO add more complex test
 *
 * @author Martin Kouba
 */
public class JsonTest {

    @Test
    public void testJsonArrayBuilder() {
        assertEquals("[\"foo\",\"bar\",[\"baz\"]]", Json.newArrayBuilder().add("foo").add("bar").add(Json.newArrayBuilder().add("baz")).build());
    }

    @Test
    public void testJsonObjectBuilder() {
        assertEquals("{\"foo\":\"bar\",\"baz\":[\"qux\"]}", Json.newObjectBuilder().add("foo", "bar").add("baz", Json.newArrayBuilder().add("qux")).build());
    }

    @Test
    public void testIgnoreEmptyBuilders() {
        assertEquals("[true]", Json.newArrayBuilder().setIgnoreEmptyBuilders(true).add(true).add(Json.newObjectBuilder().add("foo", Json.newObjectBuilder()))
                .setIgnoreEmptyBuilders(true).build());
    }

}
