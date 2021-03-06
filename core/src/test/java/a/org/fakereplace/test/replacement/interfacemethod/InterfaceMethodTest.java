/*
 * Copyright 2016, Stuart Douglas, and individual contributors as indicated
 * by the @authors tag.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package a.org.fakereplace.test.replacement.interfacemethod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import a.org.fakereplace.test.util.ClassReplacer;

public class InterfaceMethodTest {
    @BeforeClass
    public static void setup() {
        ClassReplacer rep = new ClassReplacer();
        rep.queueClassForReplacement(InterfaceCallingClass.class, InterfaceCallingClass1.class);
        rep.queueClassForReplacement(SomeInterface.class, SomeInterface1.class);
        rep.queueClassForReplacement(ImplementingClass.class, ImplementingClass1.class);
        rep.replaceQueuedClasses();
    }

    @Test
    public void testAddingInterfaceMethod() {
        SomeInterface iface = new ImplementingClass();
        InterfaceCallingClass caller = new InterfaceCallingClass();
        Assert.assertEquals("added", caller.call(iface));
    }

    @Test
    public void testAddingInterfaceMethodByReflection() throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        Method method = SomeInterface.class.getDeclaredMethod("added");
        ImplementingClass cls = new ImplementingClass();
        Assert.assertEquals("added", method.invoke(cls));
    }
}
