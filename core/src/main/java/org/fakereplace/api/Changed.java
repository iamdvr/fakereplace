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

package org.fakereplace.api;

/**
 * Represents a changed element of a class
 *
 * @author Stuart Douglas
 */
public interface Changed<T> {

    /**
     * The type of change
     * @return the type of change
     */
    ChangeType getType();

    /**
     *
     * @return A representation of the element after the change
     */
    T getModified();

    /**
     *
     * @return A representation of the element before the change, or null if it did not exist
     */
    T getExisting();
}
